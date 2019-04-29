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
@Table(name = "POS_PROMOTION_REWARD_RECORDS")
public class PosPromotionSummaryRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posPromotionRewardID;

    @Column(name = "PROMOTION_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double promotionAmount;

    @Column(name = "LOYALTY_POINTS", columnDefinition = "NUMBER(20)")
    private int loyaltyPoints;

    @Column(name = "CLIENT_ID", columnDefinition = "Varchar2(60)")
    private double clientID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPromotionSummaryRecords() {
        posPromotionRewardID = 0;
        
    }

    /**
     * @return the posPromotionRewardID
     */
    public int getPosPromotionRewardID() {
        return posPromotionRewardID;
    }

    /**
     * @param posPromotionRewardID the posPromotionRewardID to set
     */
    public void setPosPromotionRewardID(int posPromotionRewardID) {
        this.posPromotionRewardID = posPromotionRewardID;
    }

    /**
     * @return the promotionAmount
     */
    public double getPromotionAmount() {
        return promotionAmount;
    }

    /**
     * @param promotionAmount the promotionAmount to set
     */
    public void setPromotionAmount(double promotionAmount) {
        this.promotionAmount = promotionAmount;
    }

    /**
     * @return the loyaltyPoints
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @param loyaltyPoints the loyaltyPoints to set
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * @return the clientID
     */
    public double getClientID() {
        return clientID;
    }

    /**
     * @param clientID the clientID to set
     */
    public void setClientID(double clientID) {
        this.clientID = clientID;
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
