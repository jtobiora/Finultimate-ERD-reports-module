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


@Entity
@Table(name="POS_PAYMENT")
public class PosPayment extends AbstractEntity implements Serializable{
    
    @Id
    @Column(name = "POS_REFERENCE_NO", columnDefinition = "Varchar2(25)")
    private String posReferenceNo;
    
    @Column(name = "RECEIPT_NUMBER", columnDefinition = "Varchar2(20)")
    private String receiptNumber;
    
    @Column(name = "POS_TELLER_NO", columnDefinition = "Varchar2(20)")
    private String posTellerNo;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPayment() {
        posReferenceNo = "";
        
    }

    /**
     * @return the posReferenceNo
     */
    public String getPosReferenceNo() {
        return posReferenceNo;
    }

    /**
     * @param posReferenceNo the posReferenceNo to set
     */
    public void setPosReferenceNo(String posReferenceNo) {
        this.posReferenceNo = posReferenceNo;
    }

    /**
     * @return the receiptNumber
     */
    public String getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * @param receiptNumber the receiptNumber to set
     */
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    /**
     * @return the posTellerNo
     */
    public String getPosTellerNo() {
        return posTellerNo;
    }

    /**
     * @param posTellerNo the posTellerNo to set
     */
    public void setPosTellerNo(String posTellerNo) {
        this.posTellerNo = posTellerNo;
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
