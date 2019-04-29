/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rsdynamics.projects.eao;

import com.codrellica.projects.commons.SQLStyle;
import com.rsdynamics.persistence.config.PersistenceProtocolType;
import com.rsdynamics.persistence.config.PersistenceUnitName;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamics.projects.jdbc.connection.ConnectionSource;
import com.rsdynamics.projects.jdbc.connection.DatabaseConnection;
import com.rsdynamics.projects.jdbc.connection.JDBCColumn;
import com.rsdynamics.projects.jdbc.dao.JDBCDataServer;
import com.rsdynamics.projects.jdbc.dao.JDBCDataServerImpl;
import com.rsdynamics.projects.jdbc.connection.JDBCQuery;
import com.rsdynamics.projects.query.builder.ClauseCondition;
import com.rsdynamics.projects.query.builder.QueryBuilder;
import com.rsdynamics.projects.query.builder.QueryBuilderImpl;
import com.rsdynamics.projects.query.criteria.QueryCriteria;
import com.rsdynamix.abstractobjects.AbstractQueryParameter;
import com.rsdynamix.abstractobjects.AbstractDataField;
import com.rsdynamics.projects.jdbc.connection.JDBCConnectionManager;
import com.rsdynamics.projects.jdbc.dao.procedures.StoredProcedure;
import com.rsdynamix.abstractobjects.AbstractAdaptableEntity;
import com.rsdynamix.ultisure.insurance.productbuilder.entities.AbstractDataRecord;
import com.rsdynamix.abstractobjects.AbstractFieldMetaEntity;
import com.rsdynamix.tns.dataobjects.DatabaseTNSConfig;
import com.rsdynamix.tns.endpoint.TNSManager;
import com.rsdynamix.tns.endpoint.TNSManagerImpl;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author p-aniah
 */
@Stateless
public class FinultimatePersistenceBean implements FinultimatePersistenceRemote {

    private static final String DEFAULT_PU = "FinultimatePrimePU";
    // private static final String COMMON_PU = "commonPU";
    private static final String COMMON_PU = "FinultimatePrimePU";
    //private static final String REPORT_PU = "reportPU";
    private static final String REPORT_PU = "FinultimatePrimePU";
    //
    @PersistenceContext(unitName = DEFAULT_PU)
    private EntityManager entityManager;
    //
    @PersistenceContext(unitName = DEFAULT_PU)
    private EntityManager financeEntityManager;
    //
    @PersistenceContext(unitName = COMMON_PU)
    private EntityManager commonEntityManager;
    //
    @PersistenceContext(unitName = REPORT_PU)
    private EntityManager reportEntityManager;
    //
    private PersistenceProtocolType persistenceProtocolType;
    private String persistenceUnitName;
    //
    private String selectedTnsName;
    private String tenantDatabase;

    /**
     * Creates a new instance of FinancePersistenceBean1
     */
    public FinultimatePersistenceBean() {
        setPersistenceProtocolType(PersistenceProtocolType.JPA_PROTOCOL_TYPE);
    }

    public void setPersistenceUnitName(PersistenceUnitName unitName) {
        System.out.println("++++++++++++++++++++++++++++ PU-TYPE ==>> " + unitName.toString());

        if (unitName == PersistenceUnitName.COMMONS_PU) {
            this.setEntityManager(getCommonEntityManager());
        } else if (unitName == PersistenceUnitName.REPORTS_PU) {
            this.setEntityManager(getReportEntityManager());
        } else if (unitName == PersistenceUnitName.FINANCE_PU) {
            this.setEntityManager(getFinanceEntityManager());
        }
    }

    public void rollbackTransaction() {
        try {
            DatabaseConnection connection = JDBCConnectionManager.getConnectionInstance(tenantDatabase);
            connection.getConnection().rollback();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void beginTransaction() {
        try {
            DatabaseConnection connection = JDBCConnectionManager.getConnectionInstance(tenantDatabase);
            connection.getConnection().setAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void endTransaction() {
        try {
            DatabaseConnection connection = JDBCConnectionManager.getConnectionInstance(tenantDatabase);
            connection.getConnection().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void saveData(AbstractDataRecord dataPayload) throws SQLException, Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
        jdbcDataServer.saveData(dataPayload, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
    }

    public synchronized void updateData(AbstractDataRecord dataPayload) throws SQLException, Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
        jdbcDataServer.updateData(dataPayload, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
    }

    public synchronized void executeDDLStatement(String ddlStatement) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
        jdbcDataServer.executeDDLStatement(ddlStatement, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
    }

    @Override
    public synchronized void saveData(AbstractEntity entity) throws SQLException, Exception {
        System.out.println("++++++++++++++++++++++++++++ saveData()\n" + entity);

        if (getPersistenceProtocolType() == PersistenceProtocolType.JPA_PROTOCOL_TYPE) {
            getEntityManager().persist(entity);
        } else {
            JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
            jdbcDataServer.saveData(entity, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
        }
    }

    public synchronized List<AbstractEntity> findData(AbstractEntity entity) throws Exception {
        List<AbstractEntity> baseTOList = null;

        if (getPersistenceProtocolType() == PersistenceProtocolType.JPA_PROTOCOL_TYPE) {
            baseTOList = findJPAData(entity);
        } else if (getPersistenceProtocolType() == PersistenceProtocolType.JDBC_PROTOCOL_TYPE) {
            JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

            DatabaseTNSConfig tnsConfig = null;

            TNSManager tnsManager = new TNSManagerImpl();
            try {
                tnsManager.unmarshallTNSConfig();
                tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            baseTOList = jdbcDataServer.findData(
                    entity, 
                    tenantDatabase, 
                    getSelectedTnsName(), 
                    ConnectionSource.CONFIG_FILE_SOURCE, tnsConfig);
        }

        return baseTOList;
    }

    public synchronized List<AbstractEntity> findData(AbstractEntity entity, String queryString) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        DatabaseTNSConfig tnsConfig = null;

        TNSManager tnsManager = new TNSManagerImpl();
        try {
            tnsManager.unmarshallTNSConfig();
            tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<AbstractEntity> baseTOList = jdbcDataServer.findData(
                entity, 
                queryString, 
                tenantDatabase, 
                getSelectedTnsName(), 
                ConnectionSource.CONFIG_FILE_SOURCE, tnsConfig);

        return baseTOList;
    }

    public synchronized List<AbstractEntity> findDataByMaxID(AbstractEntity entity) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        DatabaseTNSConfig tnsConfig = null;

        TNSManager tnsManager = new TNSManagerImpl();
        try {
            tnsManager.unmarshallTNSConfig();
            tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<AbstractEntity> baseTOList = jdbcDataServer.findDataByMaxID(
                entity, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE, tnsConfig);

        return baseTOList;
    }

    public synchronized List<AbstractEntity> findMasterData(AbstractEntity entity, long entityMasterID) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        DatabaseTNSConfig tnsConfig = null;

        TNSManager tnsManager = new TNSManagerImpl();
        try {
            tnsManager.unmarshallTNSConfig();
            tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<AbstractEntity> baseTOList = jdbcDataServer.findMasterData(
                entity, entityMasterID, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE, tnsConfig);

        return baseTOList;
    }

    public synchronized List<AbstractEntity> findMasterData(AbstractEntity entity) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        DatabaseTNSConfig tnsConfig = null;

        TNSManager tnsManager = new TNSManagerImpl();
        try {
            tnsManager.unmarshallTNSConfig();
            tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<AbstractEntity> baseTOList = jdbcDataServer.findMasterData(
                entity, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE, tnsConfig);

        return baseTOList;
    }

    public synchronized List<AbstractEntity> findJPAData(AbstractEntity entity) throws Exception {
        QueryCriteria queryCriteria = new QueryCriteria();
        List<ClauseCondition> conditionList = null;

        conditionList = queryCriteria.buildQuery(entity);

        QueryBuilder queryBuilder = new QueryBuilderImpl();
        Query query = getEntityManager().createQuery(queryBuilder.buildSelectQuery(
                conditionList,
                entity.getClass().getName(),
                entity.getQueryGateOperators().createSubquery(
                        PersistenceProtocolType.JPA_PROTOCOL_TYPE)));

        query = queryCriteria.populateQuery(entity, query, conditionList);

        return queryBuilder.buildEntityList(query.getResultList());
    }

    public synchronized List<JDBCColumn> getFieldMetaDataList(
            String tnsEntryKey, String queryString, String TNSConfigFileName) throws Exception {
        JDBCQuery query = new JDBCQuery();
        return query.getFieldMetaDataColumnList(tnsEntryKey, queryString, TNSConfigFileName);
    }

    /**
     * Finds Non-Object/Relation-ally Mapped Data: means the data returned
     * doesnt have to match any of the application objects.
     *
     * @param reportTemplate
     * @return an instance of UlticoreReport
     */
    public synchronized AbstractAdaptableEntity findNonORMData(AbstractAdaptableEntity template, SQLStyle sqlStyle) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        return jdbcDataServer.findNonORMData(template, sqlStyle, tenantDatabase, getSelectedTnsName());
    }

    //
    public synchronized List<List<AbstractDataField>> findNonORMData(AbstractAdaptableEntity template,
            List<AbstractFieldMetaEntity> abstractFieldMetaList,
            List<AbstractQueryParameter> queryParamList, SQLStyle sqlStyle) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        return jdbcDataServer.findNonORMData(
                template, abstractFieldMetaList, queryParamList, sqlStyle, tenantDatabase, getSelectedTnsName());
    }

    public synchronized void executeArbitraryRoutine(StoredProcedure procedure, SQLStyle sqlStyle) throws Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
        jdbcDataServer.executeArbitraryRoutine(
                procedure, sqlStyle, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
    }

    public synchronized void updateData(AbstractEntity entity) throws SQLException, Exception {
        System.out.println("<<updateData()>>\n{" + entity.toString() + "}");
        if (getPersistenceProtocolType() == PersistenceProtocolType.JPA_PROTOCOL_TYPE) {
            getEntityManager().merge(entity);
        } else {
            JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();
            jdbcDataServer.updateData(
                    entity, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> update-data succeeded!");
    }

    public synchronized void updateData(AbstractEntity entity, PersistenceProtocolType persistenceProtocolType) throws SQLException, Exception {
        if (persistenceProtocolType == PersistenceProtocolType.JPA_PROTOCOL_TYPE) {
            updateData(entity);
        } else if (persistenceProtocolType == PersistenceProtocolType.JDBC_PROTOCOL_TYPE) {
            JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

            jdbcDataServer.updateData(entity, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
        }
    }

    public synchronized void updateData(AbstractEntity updateFields, AbstractEntity conditionFields) throws SQLException, Exception {
        JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

        jdbcDataServer.updateData(
                updateFields, conditionFields, tenantDatabase, getSelectedTnsName(), ConnectionSource.CONFIG_FILE_SOURCE);
    }

    public synchronized void deleteData(AbstractEntity entity) throws Exception {
        if (getPersistenceProtocolType() == PersistenceProtocolType.JPA_PROTOCOL_TYPE) {
            QueryCriteria queryCriteria = new QueryCriteria();
            List<ClauseCondition> conditionList = null;

            try {
                conditionList = queryCriteria.buildQuery(entity);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            QueryBuilder queryBuilder = new QueryBuilderImpl();
            Query query = getEntityManager().createQuery(queryBuilder.buildDeleteQuery(
                    conditionList,
                    entity.getClass().getName(),
                    entity.getQueryGateOperators().createSubquery(PersistenceProtocolType.JPA_PROTOCOL_TYPE)));

            try {
                query = queryCriteria.populateQuery(entity, query, conditionList);
                System.out.println("<<deleteData()>>\n{" + entity.toString() + "}");
                query.executeUpdate();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>> delete-data succeeded!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JDBCDataServer jdbcDataServer = new JDBCDataServerImpl();

            DatabaseTNSConfig tnsConfig = null;

            TNSManager tnsManager = new TNSManagerImpl();
            try {
                tnsManager.unmarshallTNSConfig();
                tnsConfig = tnsManager.findTNSConfigByTnsName(getSelectedTnsName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            jdbcDataServer.deleteData(
                    entity,
                    tenantDatabase,
                    getSelectedTnsName(),
                    ConnectionSource.CONFIG_FILE_SOURCE,
                    tnsConfig);
        }
    }

    public synchronized List<String> getFieldMetaNameList(String tnsEntryKey, String queryString) throws Exception {
        JDBCQuery query = new JDBCQuery();
        return query.getFieldMetaNameList(tnsEntryKey, queryString, tenantDatabase);
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    private void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @return the persistenceProtocolType
     */
    public PersistenceProtocolType getPersistenceProtocolType() {
        return persistenceProtocolType;
    }

    /**
     * @param persistenceProtocolType the persistenceProtocolType to set
     */
    public void setPersistenceProtocolType(PersistenceProtocolType persistenceProtocolType) {
        this.persistenceProtocolType = persistenceProtocolType;
    }

    /**
     * @return the persistenceUnitName
     */
    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    /**
     * @param persistenceUnitName the persistenceUnitName to set
     */
    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    /**
     * @return the selectedTnsName
     */
    public String getSelectedTnsName() {
        return selectedTnsName;
    }

    /**
     * @param selectedTnsName the selectedTnsName to set
     */
    public void setSelectedTnsName(String selectedTnsName) {
        this.selectedTnsName = selectedTnsName;
    }

    /**
     * @return the commonEntityManager
     */
    public EntityManager getCommonEntityManager() {
        return commonEntityManager;
    }

    /**
     * @param commonEntityManager the commonEntityManager to set
     */
    public void setCommonEntityManager(EntityManager commonEntityManager) {
        this.commonEntityManager = commonEntityManager;
    }

    /**
     * @return the reportEntityManager
     */
    public EntityManager getReportEntityManager() {
        return reportEntityManager;
    }

    /**
     * @param reportEntityManager the reportEntityManager to set
     */
    public void setReportEntityManager(EntityManager reportEntityManager) {
        this.reportEntityManager = reportEntityManager;
    }

    /**
     * @return the financeEntityManager
     */
    public EntityManager getFinanceEntityManager() {
        return financeEntityManager;
    }

    /**
     * @param financeEntityManager the financeEntityManager to set
     */
    public void setFinanceEntityManager(EntityManager financeEntityManager) {
        this.financeEntityManager = financeEntityManager;
    }

    /**
     * @return the tenantDatabase
     */
    public String getTenantDatabase() {
        return tenantDatabase;
    }

    /**
     * @param tenantDatabase the tenantDatabase to set
     */
    public void setTenantDatabase(String tenantDatabase) {
        this.tenantDatabase = tenantDatabase;
    }
}
