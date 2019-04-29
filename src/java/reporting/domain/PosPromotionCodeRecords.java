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

public class PosPromotionCodeRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "PROMOTION_CODE_ID", columnDefinition = "NUMBER(20)")
    private int posPromotionCodeRecordsID;

    @Column(name = "PROMOTION_CODE", columnDefinition = "Varchar2(255)")
    private String promotionCode;
    
    @Column(name = "PROMOTION_STATUS", columnDefinition = "NUMBER(11)")
    private int promotionStatus;
    
    @Column(name = "PROMOTION_USE_COUNT", columnDefinition = "NUMBER(20)")
    private int promotionUseCount;
    
    @Column(name = "PROMOTION_ID", columnDefinition = "NUMBER(20)")
    private int promotionID;
    
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPromotionCodeRecords() {
        posPromotionCodeRecordsID = 0;
        
    }

    /**
     * @return the posPromotionCodeRecordsID
     */
    public int getPosPromotionCodeRecordsID() {
        return posPromotionCodeRecordsID;
    }

    /**
     * @param posPromotionCodeRecordsID the posPromotionCodeRecordsID to set
     */
    public void setPosPromotionCodeRecordsID(int posPromotionCodeRecordsID) {
        this.posPromotionCodeRecordsID = posPromotionCodeRecordsID;
    }

    /**
     * @return the promotionCode
     */
    public String getPromotionCode() {
        return promotionCode;
    }

    /**
     * @param promotionCode the promotionCode to set
     */
    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    /**
     * @return the promotionStatus
     */
    public int getPromotionStatus() {
        return promotionStatus;
    }

    /**
     * @param promotionStatus the promotionStatus to set
     */
    public void setPromotionStatus(int promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    /**
     * @return the promotionUseCount
     */
    public int getPromotionUseCount() {
        return promotionUseCount;
    }

    /**
     * @param promotionUseCount the promotionUseCount to set
     */
    public void setPromotionUseCount(int promotionUseCount) {
        this.promotionUseCount = promotionUseCount;
    }

    /**
     * @return the promotionID
     */
    public int getPromotionID() {
        return promotionID;
    }

    /**
     * @param promotionID the promotionID to set
     */
    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
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
