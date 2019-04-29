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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author israel
 */
@Entity
@Table(name="POS_DASHBOARD_RECORDS")
public class PosDashboardRecords extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "ID", columnDefinition = "Varchar2(255)")
    private String posDashboardRecordID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosDashboardRecords() {
        posDashboardRecordID = "";
        
    }

    /**
     * @return the posDashboardRecordID
     */
    public String getPosDashboardRecordID() {
        return posDashboardRecordID;
    }

    /**
     * @param posDashboardRecordID the posDashboardRecordID to set
     */
    public void setPosDashboardRecordID(String posDashboardRecordID) {
        this.posDashboardRecordID = posDashboardRecordID;
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
