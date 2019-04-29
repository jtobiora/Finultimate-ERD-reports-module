package com.rsdynamics.projects.jdbc.dao;

import com.rsdynamics.projects.jdbc.connection.JDBCEntityRegressor;
import com.rsdynamics.projects.jdbc.connection.JDBCQuery;
import com.codrellica.projects.commons.SQLStyle;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.abstractobjects.FieldColumnName;
import com.rsdynamix.abstractobjects.FieldData;
import com.rsdynamix.projects.annotations.processor.DDLProcessor;
import com.rsdynamics.projects.jdbc.connection.ConnectionSource;
import com.rsdynamics.projects.jdbc.connection.JDBCEAOManager;
import com.rsdynamix.abstractobjects.AbstractDataField;
import com.rsdynamix.ultisure.insurance.productbuilder.entities.AbstractDataRecord;
import com.rsdynamix.abstractobjects.AbstractFieldMetaEntity;
import com.rsdynamix.abstractobjects.PersistConstraintType;
import com.rsdynamix.abstractobjects.PersistenceOrientationType;
import com.rsdynamix.abstractobjects.UlticoreLOVFieldMetaEntity;
import com.rsdynamix.abstractobjects.UlticoreProductFieldMetaEntity;
import com.rsdynamix.abstractobjects.UlticoreScheduleFieldMetaEntity;
import com.rsdynamix.dynamo.applicationdata.ApplicationDataHolder;
import com.rsdynamix.dynamo.common.entities.ActionType;
import com.rsdynamix.dynamo.common.entities.AuditTrailSwitchType;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import com.rsdynamix.dynamo.common.entities.DDLExecutionSwitchType;
import com.rsdynamix.finance.constants.FinultimateConstants;
import com.rsdynamix.projects.common.sequences.beans.ApplicationPropertyBean;
import com.rsdynamix.projects.security.bean.UserManagerBean;
import com.rsdynamix.projects.web.commons.bean.CommonBean;
import com.rsdynamix.tns.dataobjects.DatabaseTNSConfig;
import com.rsdynamix.tns.util.Constants;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * This class implements entity persistence logic declared in
 * <code>JDBCEntityManager</code> interface.
 *
 * @author p-aniah
 */
public class JDBCEntityManagerImpl implements JDBCEntityManager {

    private static String BIZ_ACTION_TRAIL_SERIAL_LEN = "biz_actn_trail_no_serial";
    
    public JDBCEntityManagerImpl() {   }

    public JDBCQuery createQuery(String queryString) {
        return  new JDBCQuery();
    }
    
    public void executeDDLStatement(
            String ddlStatement, 
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws Exception {
        JDBCEAOManager eaoManager = new JDBCEAOManager();

        try {
            eaoManager.executeDDLStatement(ddlStatement, tenantDatabase, connectionName, connectionSrc);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void persist(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        UserManagerBean userManagerBean = (UserManagerBean) CommonBean.getBeanFromContext(
                "#{sessionScope.userManagerBean}", UserManagerBean.class);
        if (userManagerBean == null) {
            userManagerBean = new UserManagerBean();
            CommonBean.setBeanToContext("#{sessionScope.userManagerBean}",
                    UserManagerBean.class, userManagerBean);
        }

        try {
            entity.setApprover(userManagerBean.getUserAccount().getUserName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        new JDBCEntityRegressor().performEntityRegression(
                entity, tenantDatabase, connectionName, connectionSrc);

        standardPersist(entity, tenantDatabase, connectionName, connectionSrc);

        if ((CommonBean.AUDIT_TRAIL_SWITCH == AuditTrailSwitchType.ON) && (!entity.isSuppressAuditTrail())) {
            try {
                persistMaster(entity, ActionType.CREATE, tenantDatabase, connectionName, connectionSrc);
            } catch (SQLException ex) {
                throw ex;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void persistMaster(AbstractEntity entity, 
            ActionType actionType,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        int entityMastID = 0;

        FieldData pkFieldName = null;
        if (actionType != ActionType.DELETE) {
            ApplicationPropertyBean appPropBean = (ApplicationPropertyBean) CommonBean.getBeanFromContext("#{applicationScope.applicationPropertyBean}", ApplicationPropertyBean.class);
            if (appPropBean == null) {
                appPropBean = new ApplicationPropertyBean();
                CommonBean.setBeanToContext("#{applicationScope.applicationPropertyBean}",
                        ApplicationPropertyBean.class, appPropBean);
            }

            DDLProcessor ddlProcessor = new DDLProcessor();
            int columnCount = 0;

            String tableName = ddlProcessor.getTableNameFromEntity(entity);
            String insertSQL = "INSERT INTO " + tableName + "_MAST (";
            String paramNameSpec = "";
            String paramPlaceHolderSpec = " Values(";

            List<FieldData> fieldDataList = entity.getFieldDataList();

            List<FieldColumnName> columnList = DDLProcessor.buildFieldColumnNameList(entity);
            FieldColumnName pkColumn = DDLProcessor.findPKFieldColumnName(columnList);
            if (pkColumn != null) {
                pkFieldName = ddlProcessor.findFieldDataByFieldName(fieldDataList, pkColumn.getFieldName());

                entityMastID = Integer.parseInt(appPropBean.getValue(
                        tableName + "." + pkFieldName.getFieldName(),
                        FinultimateConstants.ONE_STR, true));

                FieldData mastIDField = new FieldData();
                mastIDField.setFieldName("entityMasterID");
                mastIDField.setFieldValue(entityMastID);
                mastIDField.setPrimaryKey(true);

                pkColumn = new FieldColumnName();
                pkColumn.setFieldName("entityMasterID");
                pkColumn.setColumnName("ENTITY_MASTER_ID");

                fieldDataList.add(mastIDField);
                columnList.add(pkColumn);
            }

            Collections.sort(fieldDataList, new Comparator<FieldData>() {

                public int compare(FieldData o1, FieldData o2) {
                    return (o1.getFieldName().compareTo(o2.getFieldName()));
                }
            });

            Collections.sort(columnList, new Comparator<FieldColumnName>() {

                public int compare(FieldColumnName o1, FieldColumnName o2) {
                    return (o1.getFieldName().compareTo(o2.getFieldName()));
                }
            });

            for (FieldColumnName column : columnList) {
                columnCount++;
                paramNameSpec += column.getColumnName() + ", ";
                paramPlaceHolderSpec += "?, ";
            }

            if (columnCount > 0) {
                insertSQL += paramNameSpec.substring(0, paramNameSpec.length() - 2) + ")"
                        + paramPlaceHolderSpec.substring(0, paramPlaceHolderSpec.length() - 2) + ")";
            }
            System.out.println(">>>>>>>>>>>>> SQL ==>> " + insertSQL);

            JDBCEAOManager eaoManager = new JDBCEAOManager();

            eaoManager.persistEntity(
                    fieldDataList, insertSQL, tenantDatabase, connectionName, connectionSrc);
        }

        executeBusinessActionTrail(
                entity, 
                entityMastID, 
                actionType, 
                pkFieldName, 
                tenantDatabase, connectionName, connectionSrc);
    }

    private void standardPersist(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception{
        DDLProcessor ddlProcessor = new DDLProcessor();
        int columnCount = 0;

        String insertSQL = "INSERT INTO " + ddlProcessor.getTableNameFromEntity(entity) + " (";
        String paramNameSpec = "";
        String paramPlaceHolderSpec = " Values(";

        List<FieldData> fieldDataList = entity.getFieldDataList();
        List<FieldColumnName> columnList = ddlProcessor.buildFieldColumnNameList(entity);

        Collections.sort(fieldDataList, new Comparator<FieldData>() {

            public int compare(FieldData o1, FieldData o2) {
                return (o1.getFieldName().compareTo(o2.getFieldName()));
            }
        });

        Collections.sort(columnList, new Comparator<FieldColumnName>() {

            public int compare(FieldColumnName o1, FieldColumnName o2) {
                return (o1.getFieldName().compareTo(o2.getFieldName()));
            }
        });

        for (FieldColumnName column : columnList) {
            columnCount++;
            paramNameSpec += column.getColumnName() + ", ";
            paramPlaceHolderSpec += "?, ";
        }

        if (columnCount > 0) {
            insertSQL += paramNameSpec.substring(0, paramNameSpec.length() - 2) + ")"
                    + paramPlaceHolderSpec.substring(0, paramPlaceHolderSpec.length() - 2) + ")";
        }
        System.out.println(">>>>>>>>>>>>> SQL ==>> " + insertSQL);

        JDBCEAOManager eaoManager = new JDBCEAOManager();

        eaoManager.persistEntity(
                fieldDataList, insertSQL, tenantDatabase, connectionName, connectionSrc);
    }

    public void merge(AbstractEntity entity, 
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        UserManagerBean userManagerBean = (UserManagerBean) CommonBean.getBeanFromContext(
                "#{sessionScope.userManagerBean}", UserManagerBean.class);
        if (userManagerBean == null) {
            userManagerBean = new UserManagerBean();
            CommonBean.setBeanToContext("#{sessionScope.userManagerBean}",
                    UserManagerBean.class, userManagerBean);
        }

        try {
            entity.setApprover(userManagerBean.getUserAccount().getUserName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        new JDBCEntityRegressor().performEntityRegression(entity, tenantDatabase, connectionName, connectionSrc);

        DDLProcessor ddlProcessor = new DDLProcessor();
        int columnCount = 0;

        String updateSQL = "UPDATE " + ddlProcessor.getTableNameFromEntity(entity) + " SET ";
        String paramSpec = "";

        List<FieldData> fieldDataList = entity.getFieldDataList();
        List<FieldColumnName> columnList = ddlProcessor.buildFieldColumnNameList(entity);

        Collections.sort(fieldDataList, new Comparator<FieldData>() {

            public int compare(FieldData o1, FieldData o2) {
                return (o1.getFieldName().compareTo(o2.getFieldName()));
            }
        });

        Collections.sort(columnList, new Comparator<FieldColumnName>() {

            public int compare(FieldColumnName o1, FieldColumnName o2) {
                return (o1.getFieldName().compareTo(o2.getFieldName()));
            }
        });

        for (FieldColumnName column : columnList) {
            columnCount++;
            paramSpec += column.getColumnName() + " = ?, ";
        }

        if (columnCount > 0) {
            String idFieldName = ddlProcessor.getFieldNameOfIDField(entity);
            FieldColumnName column = ddlProcessor.findFieldColumnNameByFieldName(columnList, idFieldName);
            FieldData fieldData = ddlProcessor.findFieldDataByFieldName(fieldDataList, idFieldName);

            if (fieldData.getFieldValue() instanceof String) {
                updateSQL += paramSpec.substring(0, paramSpec.length() - 2) + " Where "
                        + column.getColumnName() + " = '" + fieldData.getFieldValue().toString() + "'";
            } else {
                updateSQL += paramSpec.substring(0, paramSpec.length() - 2) + " Where "
                        + column.getColumnName() + " = " + fieldData.getFieldValue().toString();
            }
        }
        System.out.println(">>>>>>>>>>>>> SQL ==>> " + updateSQL);

        JDBCEAOManager eaoManager = new JDBCEAOManager();

        eaoManager.mergeEntity(fieldDataList, updateSQL, tenantDatabase, connectionName, connectionSrc);

        if ((CommonBean.AUDIT_TRAIL_SWITCH == AuditTrailSwitchType.ON) && (!entity.isSuppressAuditTrail())) {
            try {
                persistMaster(entity, ActionType.UPDATE, tenantDatabase, connectionName, connectionSrc);
            } catch (SQLException ex) {
                throw ex;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void merge(AbstractEntity updateFields, 
            AbstractEntity conditionFields,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        UserManagerBean userManagerBean = (UserManagerBean) CommonBean.getBeanFromContext(
                "#{sessionScope.userManagerBean}", UserManagerBean.class);
        if (userManagerBean == null) {
            userManagerBean = new UserManagerBean();
            CommonBean.setBeanToContext("#{sessionScope.userManagerBean}",
                    UserManagerBean.class, userManagerBean);
        }

        try {
            updateFields.setApprover(userManagerBean.getUserAccount().getUserName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        new JDBCEntityRegressor().performEntityRegression(updateFields, tenantDatabase, connectionName, connectionSrc);

        DDLProcessor ddlProcessor = new DDLProcessor();
        int columnCount = 0;

        String updateSQL = "UPDATE " + ddlProcessor.getTableNameFromEntity(updateFields) + " SET ";
        String paramSpec = "";

        List<FieldData> fieldDataList = ddlProcessor.buildNonEmptyFieldDataList(updateFields);
        List<FieldColumnName> columnList = ddlProcessor.buildNonEmptyFieldColumnNameList(updateFields);
        List<FieldData> conditionFieldDataList = ddlProcessor.buildNonEmptyFieldDataList(conditionFields);

        for (FieldColumnName column : columnList) {
            columnCount++;
            paramSpec += column.getColumnName() + " = ?, ";
        }

        if (columnCount > 0) {
            updateSQL += paramSpec.substring(0, paramSpec.length() - 2) + " Where ";

            for (FieldData fieldData : conditionFieldDataList) {
                fieldDataList.add(fieldData);
                updateSQL += fieldData.getFieldName() + " = ? AND ";
            }
            updateSQL = updateSQL.substring(0, updateSQL.length() - 5);

            System.out.println(">>>>>>>>>>>>> SQL ==>> " + updateSQL);

            JDBCEAOManager eaoManager = new JDBCEAOManager();

            eaoManager.mergeEntity(fieldDataList, updateSQL, tenantDatabase, connectionName, connectionSrc);
        }

        if ((CommonBean.AUDIT_TRAIL_SWITCH == AuditTrailSwitchType.ON) && (!updateFields.isSuppressAuditTrail())) {
            try {
                persistMaster(updateFields, ActionType.UPDATE, tenantDatabase, connectionName, connectionSrc);
            } catch (SQLException ex) {
                throw ex;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void executeBusinessActionTrail(
            AbstractEntity entity,
            long entityMasterID,
            ActionType actionType,
            FieldData pkFieldName,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        ApplicationPropertyBean appPropBean = (ApplicationPropertyBean) CommonBean.getBeanFromContext("#{applicationScope.applicationPropertyBean}", ApplicationPropertyBean.class);
        if (appPropBean == null) {
            appPropBean = new ApplicationPropertyBean();
            CommonBean.setBeanToContext("#{applicationScope.applicationPropertyBean}",
                    ApplicationPropertyBean.class, appPropBean);
        }

        UserManagerBean userManagerBean = (UserManagerBean) CommonBean.getBeanFromContext(
                "#{sessionScope.userManagerBean}", UserManagerBean.class);
        if (userManagerBean == null) {
            userManagerBean = new UserManagerBean();
            CommonBean.setBeanToContext("#{sessionScope.userManagerBean}",
                    UserManagerBean.class, userManagerBean);
        }

        BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

        actionTrail.setActionType(actionType);
        actionTrail.setEntryDate(new Date());
        actionTrail.setApprover(userManagerBean.getUserAccount().getUserName());
        actionTrail.setEntityName(entity.getClass().getSimpleName());
        actionTrail.setEntityMasterID(entityMasterID);

        if ((pkFieldName != null) && (CommonBean.isDigitSequence(pkFieldName.getFieldValue().toString()))) {
            actionTrail.setEntityID(Long.parseLong(pkFieldName.getFieldValue().toString()));
        }

        int actionTrailID = Integer.parseInt(appPropBean.getValue(
                BIZ_ACTION_TRAIL_SERIAL_LEN,
                FinultimateConstants.ONE_STR, true));
        actionTrail.setBusinessActionTrailID(actionTrailID);

        standardPersist(actionTrail, tenantDatabase, connectionName, connectionSrc);
    }
    
    public void persist(AbstractDataRecord dataPayload,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        String insertSQL = "INSERT INTO " + dataPayload.getTableName() + " (";
        String paramNameSpec = "";
        String paramPlaceHolderSpec = " Values(";
        int columnCount = 0;

        List<FieldData> fieldDataList = new ArrayList<FieldData>();
        for (AbstractFieldMetaEntity fieldMeta : dataPayload.getFieldMetaList()) {
            boolean persistable = false;
            String dataType = "";

            if (fieldMeta instanceof UlticoreLOVFieldMetaEntity) {
                persistable = ((UlticoreLOVFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
                dataType = ((UlticoreLOVFieldMetaEntity) fieldMeta).getParameterTypeFQN();
            } else if (fieldMeta instanceof UlticoreProductFieldMetaEntity) {
                persistable = ((UlticoreProductFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
                dataType = ((UlticoreProductFieldMetaEntity) fieldMeta).getParameterTypeFQN();
            } else if (fieldMeta instanceof UlticoreScheduleFieldMetaEntity) {
                persistable = ((UlticoreScheduleFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
                dataType = ((UlticoreScheduleFieldMetaEntity) fieldMeta).getParameterTypeFQN();
            }

            if (persistable) {
                columnCount++;
                paramNameSpec += fieldMeta.getDatabaseFieldName() + ", ";
                paramPlaceHolderSpec += "?, ";

                FieldData fieldData = new FieldData();
                fieldData.setFieldColumnName(fieldMeta.getDatabaseFieldName());
                fieldData.setDataType(dataType);
                AbstractDataField fieldValue = dataPayload.findFieldValueByMetaName(fieldMeta.getDatabaseFieldName());
                if (fieldValue != null) {
                    fieldData.setFieldValue(fieldValue.getFieldValue());
                }

                fieldDataList.add(fieldData);
            }
        }

        if (columnCount > 0) {
            insertSQL += paramNameSpec.substring(0, paramNameSpec.length() - 2) + ")"
                    + paramPlaceHolderSpec.substring(0, paramPlaceHolderSpec.length() - 2) + ")";
        }
        System.out.println(">>>>>>>>>>>>> SQL ==>> " + insertSQL);

        JDBCEAOManager eaoManager = new JDBCEAOManager();

        eaoManager.persistEntity(
                fieldDataList, insertSQL, tenantDatabase, connectionName, connectionSrc);
    }
    
    public void merge(AbstractDataRecord dataPayload,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception {
        DDLProcessor ddlProcessor = new DDLProcessor();
        int columnCount = 0;

        String updateSQL = "UPDATE " + dataPayload.getTableName() + " SET ";
        String paramSpec = "";

        List<FieldData> fieldDataList = new ArrayList<FieldData>();

        for (AbstractFieldMetaEntity fieldMeta : dataPayload.getFieldMetaList()) {
            PersistConstraintType constraint = null;

            boolean persistable = false;

            if (fieldMeta instanceof UlticoreLOVFieldMetaEntity) {
                UlticoreLOVFieldMetaEntity lovField = (UlticoreLOVFieldMetaEntity) fieldMeta;
                constraint = lovField.getConstraintType();
                persistable = ((UlticoreLOVFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
            } else if (fieldMeta instanceof UlticoreProductFieldMetaEntity) {
                UlticoreProductFieldMetaEntity lovField = (UlticoreProductFieldMetaEntity) fieldMeta;
                constraint = lovField.getConstraintType();
                persistable = ((UlticoreProductFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
            } else if (fieldMeta instanceof UlticoreScheduleFieldMetaEntity) {
                UlticoreScheduleFieldMetaEntity lovField = (UlticoreScheduleFieldMetaEntity) fieldMeta;
                constraint = lovField.getConstraintType();
                persistable = ((UlticoreScheduleFieldMetaEntity) fieldMeta).getPersistOrientType() == PersistenceOrientationType.PERSISTABLE;
            }

            if (persistable) {
                if (constraint != PersistConstraintType.PRIMARY_KEY) {
                    columnCount++;
                    paramSpec += fieldMeta.getDatabaseFieldName() + " = ?, ";

                    FieldData fieldData = new FieldData();
                    fieldData.setFieldColumnName(fieldMeta.getDatabaseFieldName());

                    AbstractDataField fieldValue = dataPayload.findFieldValueByMetaName(
                            fieldMeta.getDatabaseFieldName());

                    if (fieldValue != null) {
                        fieldData.setFieldValue(fieldValue.getFieldValue());
                    }

                    fieldDataList.add(fieldData);
                }
            }
        }

        if (columnCount > 0) {
            AbstractFieldMetaEntity fieldMeta = dataPayload.findPrimaryKeyField();

            AbstractDataField pkFieldValue = dataPayload.findFieldValueByMetaName(
                    fieldMeta.getDatabaseFieldName());

            if (pkFieldValue.getFieldValue() instanceof String) {
                updateSQL += paramSpec.substring(0, paramSpec.length() - 2) + " Where "
                        + fieldMeta.getDatabaseFieldName() + " = '" + pkFieldValue.getFieldValue().toString() + "'";
            } else {
                updateSQL += paramSpec.substring(0, paramSpec.length() - 2) + " Where "
                        + fieldMeta.getDatabaseFieldName() + " = " + pkFieldValue.getFieldValue().toString();
            }
        }
        System.out.println(">>>>>>>>>>>>> SQL ==>> " + updateSQL);

        JDBCEAOManager eaoManager = new JDBCEAOManager();

        eaoManager.mergeEntity(
                fieldDataList, updateSQL, tenantDatabase, connectionName, connectionSrc);
    }

}
