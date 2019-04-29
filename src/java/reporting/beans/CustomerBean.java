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
import reporting.domain.PosCustomerRecords;
import reporting.domain.PosUsersRecords;
import reporting.repository.CustomerRepository;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "customerBean")
public class CustomerBean implements Serializable, CustomerRepository {

    private PosCustomerRecords posCustomerRecords;
    private List<PosCustomerRecords> posCustomerRecordsList;
    
    private FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
        posCustomerRecords = new PosCustomerRecords();
        posCustomerRecordsList = new ArrayList<PosCustomerRecords>();
    }

    @Override
    public PosCustomerRecords findByClientId(String clientId) {
        try {
            PosCustomerRecords criteria = new PosCustomerRecords();
            List<AbstractEntity> entityList = getDataServer().findData(criteria,"SELECT c.* FROM pos_customer_records c WHERE c.CLIENT_ID ='"+clientId+"'");
            
            posCustomerRecords = (PosCustomerRecords) entityList.get(0);
                      
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return posCustomerRecords;
    }
    
    
    public List<PosCustomerRecords> findAll() {
        

        try {
            PosCustomerRecords criteria = new PosCustomerRecords();
            
            List<AbstractEntity> entityList = getDataServer().findData(criteria);

            for (AbstractEntity entity : entityList) {
                PosCustomerRecords posCustomerRecordsEntity = (PosCustomerRecords) entity;

                getPosCustomerRecordsList().add(posCustomerRecordsEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return getPosCustomerRecordsList();
    }

    /**
     * @return the posCustomerRecords
     */
    public PosCustomerRecords getPosCustomerRecords() {
        return posCustomerRecords;
    }

    /**
     * @param posCustomerRecords the posCustomerRecords to set
     */
    public void setPosCustomerRecords(PosCustomerRecords posCustomerRecords) {
        this.posCustomerRecords = posCustomerRecords;
    }

    /**
     * @return the posCustomerRecordsList
     */
    public List<PosCustomerRecords> getPosCustomerRecordsList() {
        return posCustomerRecordsList;
    }

    /**
     * @param posCustomerRecordsList the posCustomerRecordsList to set
     */
    public void setPosCustomerRecordsList(List<PosCustomerRecords> posCustomerRecordsList) {
        this.posCustomerRecordsList = posCustomerRecordsList;
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
    
}
