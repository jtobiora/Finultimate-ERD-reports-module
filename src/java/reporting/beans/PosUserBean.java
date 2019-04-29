/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PosCartItem;
import reporting.domain.PosTransactionRecords;
import reporting.domain.PosUsersRecords;
import reporting.repository.PosUserRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "posUserBean")
public class PosUserBean implements Serializable, PosUserRepository {

    private PosTransactionRecords posTransactionRecords;
    private List<PosTransactionRecords> posTransactionRecordsList;
    private List<PosUsersRecords> posUserRecord ;

    private FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    /**
     * Creates a new instance of PosUserBean
     */
    public PosUserBean() {
        posTransactionRecords = new PosTransactionRecords();
        posTransactionRecordsList = new ArrayList<PosTransactionRecords>();
        
        posUserRecord = new ArrayList<>();
    }

    @Override
    public List<PosTransactionRecords> listPosUsers() {
        try {
            PosTransactionRecords criteria = new PosTransactionRecords();
            List<AbstractEntity> entityList = getDataServer().findData(criteria, "SELECT u.* FROM pos_users_records u");

            for (AbstractEntity entity : entityList) {
                PosTransactionRecords posTransactionRecordsEntity = (PosTransactionRecords) entity;

                getPosTransactionRecordsList().add(posTransactionRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posTransactionRecordsList;
    }

    public PosUsersRecords findOne(Long userId) {
        PosUsersRecords posUserRecord = new PosUsersRecords();

        try {
            PosUsersRecords criteria = new PosUsersRecords();
            criteria.setUserID(userId);
            
            List<AbstractEntity> entityList = getDataServer().findData(criteria);

            posUserRecord = (PosUsersRecords)entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return posUserRecord;
    }
    
    public List<PosUsersRecords> findAll() {
        

        try {
            PosUsersRecords criteria = new PosUsersRecords();
            
            List<AbstractEntity> entityList = getDataServer().findData(criteria);

            for (AbstractEntity entity : entityList) {
                PosUsersRecords posUsersRecordsEntity = (PosUsersRecords) entity;

                getPosUserRecord().add(posUsersRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return getPosUserRecord();
    }

    /**
     * @return the posTransactionRecords
     */
    public PosTransactionRecords getPosTransactionRecords() {
        return posTransactionRecords;
    }

    /**
     * @param posTransactionRecords the posTransactionRecords to set
     */
    public void setPosTransactionRecords(PosTransactionRecords posTransactionRecords) {
        this.posTransactionRecords = posTransactionRecords;
    }

    /**
     * @return the posTransactionRecordsList
     */
    public List<PosTransactionRecords> getPosTransactionRecordsList() {
        return posTransactionRecordsList;
    }

    /**
     * @param posTransactionRecordsList the posTransactionRecordsList to set
     */
    public void setPosTransactionRecordsList(List<PosTransactionRecords> posTransactionRecordsList) {
        this.posTransactionRecordsList = posTransactionRecordsList;
    }

    /**
     * @return the dataServer
     */
    public FinultimatePersistenceRemote getDataServer() {
        return dataServer;
    }

    /**
     * @param dataServer the dataServer to set
     */
    public void setDataServer(FinultimatePersistenceRemote dataServer) {
        this.dataServer = dataServer;
    }

    /**
     * @return the posUserRecord
     */
    public List<PosUsersRecords> getPosUserRecord() {
        return posUserRecord;
    }

    /**
     * @param posUserRecord the posUserRecord to set
     */
    public void setPosUserRecord(List<PosUsersRecords> posUserRecord) {
        this.posUserRecord = posUserRecord;
    }

}
