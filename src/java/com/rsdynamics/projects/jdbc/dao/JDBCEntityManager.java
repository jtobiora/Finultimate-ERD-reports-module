package com.rsdynamics.projects.jdbc.dao;

import com.rsdynamics.projects.jdbc.connection.JDBCQuery;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamics.projects.jdbc.connection.ConnectionSource;
import com.rsdynamix.ultisure.insurance.productbuilder.entities.AbstractDataRecord;
import com.rsdynamix.dynamo.common.entities.ActionType;
import com.rsdynamix.tns.dataobjects.DatabaseTNSConfig;
import java.sql.SQLException;

/**
 *
 * This interface encapsulates entity persistence logic
 *
 * @author p-aniah
 */
public interface JDBCEntityManager {

    public void executeDDLStatement(String ddlStatement,  
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws Exception;
    
    public JDBCQuery createQuery(String queryString);

    public void persist(AbstractEntity entity,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception;
    
    public void persistMaster(AbstractEntity entity, 
            ActionType actionType,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception;

    public void merge(AbstractEntity entity, 
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception;

    public void merge(AbstractEntity updateFields, 
            AbstractEntity conditionFields,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException,Exception;
    
    public void merge(AbstractDataRecord dataPayload,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception;
    
    public void persist(AbstractDataRecord dataPayload,
            String tenantDatabase, 
            String connectionName,
            ConnectionSource connectionSrc) throws SQLException, Exception;

}
