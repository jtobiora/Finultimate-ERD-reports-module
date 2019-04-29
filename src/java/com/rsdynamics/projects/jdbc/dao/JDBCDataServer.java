package com.rsdynamics.projects.jdbc.dao;

import com.codrellica.projects.commons.SQLStyle;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamics.projects.jdbc.connection.ConnectionSource;
import com.rsdynamics.projects.jdbc.dao.procedures.StoredProcedure;
import com.rsdynamix.abstractobjects.AbstractQueryParameter;
import com.rsdynamix.abstractobjects.AbstractDataField;
import com.rsdynamix.abstractobjects.AbstractAdaptableEntity;
import com.rsdynamix.ultisure.insurance.productbuilder.entities.AbstractDataRecord;
import com.rsdynamix.abstractobjects.AbstractFieldMetaEntity;
import com.rsdynamix.tns.dataobjects.DatabaseTNSConfig;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * This interface encapsulates the JDBC Object/Relational Mapping (O/RM) logic
 *
 * @author p-aniah
 */
public interface JDBCDataServer {
    
    public void executeDDLStatement(String ddlStatement,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws Exception;
    
    void saveData(AbstractEntity entity,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws SQLException,Exception;
    
    void saveData(AbstractDataRecord dataPayload,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws SQLException, Exception;
    
    void updateData(AbstractDataRecord dataPayload,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws SQLException, Exception;
    
    public AbstractAdaptableEntity findNonORMData(
            AbstractAdaptableEntity template, 
            SQLStyle sqlStyle, 
            String tenantDatabase,
            String connectionName)throws Exception;
    //
    public List<List<AbstractDataField>> findNonORMData(AbstractAdaptableEntity template,
            List<AbstractFieldMetaEntity> abstractFieldMetaList,
            List<AbstractQueryParameter> queryParamList, 
            SQLStyle sqlStyle,
            String tenantDatabase,
            String connectionName) throws Exception;
    

    public void executeArbitraryRoutine(StoredProcedure procedure, 
            SQLStyle sqlStyle,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws Exception;

    List<AbstractEntity> findData(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;
    
    List<AbstractEntity> findData(AbstractEntity entity, 
            String queryString,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;
    
    List<AbstractEntity> findDataByMaxID(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;
    
    public List<AbstractEntity> findMasterData(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;
    
    public List<AbstractEntity> findMasterData(AbstractEntity entity, 
            long entityMasterID,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;

    void updateData(AbstractEntity entity,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws SQLException, Exception;

    void updateData(AbstractEntity updateFields, 
            AbstractEntity conditionFields,
            String tenantDatabase,
            String connectionName, 
            ConnectionSource connectionSrc) throws SQLException, Exception;

    void deleteData(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc,
            DatabaseTNSConfig tnsConfig) throws Exception;

}
