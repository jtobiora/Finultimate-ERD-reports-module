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
@Table(name = "POS_PROMOTION_REWARD_RECORDS")
public class PosPromotionRewardRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "PROMOTION_REWARD_ID", columnDefinition = "NUMBER(20)")
    private int promotionRewardID;

    @Column(name = "PROMOTION_AMOUNT_ID", columnDefinition = "DOUBLE PRECISION")    
    private double promotionAmountID;

    @Column(name = "ITEM_ID", columnDefinition = "NUMBER(20)")
    private int itemID;

    @Column(name = "MAX_PURCHASE_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double maxPurchaseAmount;

    @Column(name = "MIN_PURCHASE_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double minPurchaseAmount;

    @Column(name = "NUMBER_OF_POINTS", columnDefinition = "NUMBER(20)")
    private int numberOfPoints;

    @Column(name = "QUANTITY", columnDefinition = "NUMBER(20)")
    private int quantity;

    @Column(name = "RATE_TYPE", columnDefinition = "NUMBER(20)")
    private int promotionTypeID;

    @Column(name = "PROMOTION_ID", columnDefinition = "NUMBER(20)")
    private int promotionID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPromotionRewardRecords() {
        promotionRewardID = 0;
        
    }

    /**
     * @return the promotionRewardID
     */
    public int getPromotionRewardID() {
        return promotionRewardID;
    }

    /**
     * @param promotionRewardID the promotionRewardID to set
     */
    public void setPromotionRewardID(int promotionRewardID) {
        this.promotionRewardID = promotionRewardID;
    }

    /**
     * @return the promotionAmountID
     */
    public double getPromotionAmountID() {
        return promotionAmountID;
    }

    /**
     * @param promotionAmountID the promotionAmountID to set
     */
    public void setPromotionAmountID(double promotionAmountID) {
        this.promotionAmountID = promotionAmountID;
    }

    /**
     * @return the itemID
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the maxPurchaseAmount
     */
    public double getMaxPurchaseAmount() {
        return maxPurchaseAmount;
    }

    /**
     * @param maxPurchaseAmount the maxPurchaseAmount to set
     */
    public void setMaxPurchaseAmount(double maxPurchaseAmount) {
        this.maxPurchaseAmount = maxPurchaseAmount;
    }

    /**
     * @return the minPurchaseAmount
     */
    public double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    /**
     * @param minPurchaseAmount the minPurchaseAmount to set
     */
    public void setMinPurchaseAmount(double minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    /**
     * @return the numberOfPoints
     */
    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    /**
     * @param numberOfPoints the numberOfPoints to set
     */
    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the promotionTypeID
     */
    public int getPromotionTypeID() {
        return promotionTypeID;
    }

    /**
     * @param promotionTypeID the promotionTypeID to set
     */
    public void setPromotionTypeID(int promotionTypeID) {
        this.promotionTypeID = promotionTypeID;
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
