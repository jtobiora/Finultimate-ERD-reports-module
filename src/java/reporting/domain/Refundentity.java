/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REFUNDENTITY")
public class Refundentity extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int refundentityID;
    
    //
    @Column(name = "REFUND_DATE", columnDefinition = "DATE")
    private Date refundDate;
    
    //
    @Column(name = "REFUND_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double refundTotal;
    
    //
    @Column(name = "SESSIONENTITY_ID", columnDefinition = "NUMBER(20)")
    private int sessionEntityID;
    
    //
    @Column(name = "REFUND_CUSTOMER", columnDefinition = "VARCHAR2(255)")
    private String refundCustomer;
    
    //
    @Column(name = "REFUND_USER", columnDefinition = "NUMBER(20)")
    private int refundUser;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public Refundentity() {
        refundentityID = 0;
        
    }

    /**
     * @return the refundentityID
     */
    public int getRefundentityID() {
        return refundentityID;
    }

    /**
     * @param refundentityID the refundentityID to set
     */
    public void setRefundentityID(int refundentityID) {
        this.refundentityID = refundentityID;
    }

    /**
     * @return the refundDate
     */
    public Date getRefundDate() {
        return refundDate;
    }

    /**
     * @param refundDate the refundDate to set
     */
    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    /**
     * @return the refundTotal
     */
    public double getRefundTotal() {
        return refundTotal;
    }

    /**
     * @param refundTotal the refundTotal to set
     */
    public void setRefundTotal(double refundTotal) {
        this.refundTotal = refundTotal;
    }

    /**
     * @return the sessionEntityID
     */
    public int getSessionEntityID() {
        return sessionEntityID;
    }

    /**
     * @param sessionEntityID the sessionEntityID to set
     */
    public void setSessionEntityID(int sessionEntityID) {
        this.sessionEntityID = sessionEntityID;
    }

    /**
     * @return the refundCustomer
     */
    public String getRefundCustomer() {
        return refundCustomer;
    }

    /**
     * @param refundCustomer the refundCustomer to set
     */
    public void setRefundCustomer(String refundCustomer) {
        this.refundCustomer = refundCustomer;
    }

    /**
     * @return the refundUser
     */
    public int getRefundUser() {
        return refundUser;
    }

    /**
     * @param refundUser the refundUser to set
     */
    public void setRefundUser(int refundUser) {
        this.refundUser = refundUser;
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