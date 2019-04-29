/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

public class PosWarehouseRecords extends AbstractEntity implements Serializable {
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posWarehouseRecordsID;
    
    @Column(name = "NAME", columnDefinition = "Varchar2(255)")
    private String name;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosWarehouseRecords() {
        posWarehouseRecordsID = 0;
        
    }

    /**
     * @return the posWarehouseRecordsID
     */
    public int getPosWarehouseRecordsID() {
        return posWarehouseRecordsID;
    }

    /**
     * @param posWarehouseRecordsID the posWarehouseRecordsID to set
     */
    public void setPosWarehouseRecordsID(int posWarehouseRecordsID) {
        this.posWarehouseRecordsID = posWarehouseRecordsID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the approvalStatusID
     */
    public int getApprovalStatusID() {
        return approvalStatusID;
    }

    /**
     * @param approvalStatusID the approvalStatusID to set
     */
    public void setApprovalStatusID(int approvalStatusID) {
        this.approvalStatusID = approvalStatusID;
    }

    /**
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * @return the actionTrail
     */
    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    /**
     * @param actionTrail the actionTrail to set
     */
    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
    }
}
