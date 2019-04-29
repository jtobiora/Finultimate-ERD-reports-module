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

/**
 *
 * @author israel
 */
@Entity
@Table(name = "POS_PROMOTION_RECORDS")
public class PosPromotionRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "PROMOTION_ID", columnDefinition = "NUMBER(20)")
    private int promotionID;

    @Column(name = "PROMOTION_TYPE_ID", columnDefinition = "NUMBER(20)")
    private int promotionTypeID;
    
    @Column(name = "PAYMENT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double paymentAmount;
    
    @Column(name = "CREATE_DATE", columnDefinition = "DATE")
    private Date createDate;
    
    @Column(name = "END_DATE", columnDefinition = "DATE")
    private Date endDate;
    
    @Column(name = "NUMBER_OF_USES", columnDefinition = "NUMBER(20)")
    private int numberOfUses;
    
    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(255)")
    private String currencyCode;
    
    @Column(name = "PROMOTION_DESCRIPTION", columnDefinition = "Varchar2(255)")
    private String promotionDescription;
    
    @Column(name = "PROMOTION_IDENTITY_TYPE", columnDefinition = "NUMBER(11)")
    private double promotionIdentityType;
    
    @Column(name = "START_DATE", columnDefinition = "DATE")
    private Date startDate;
    
    @Column(name = "ACTIVE_FLG", columnDefinition = "NUMBER(11)")
    private int activeFLG;
    
    @Column(name = "ITEM_ID", columnDefinition = "NUMBER(20)")
    private int itemID;
    
    @Column(name = "ITEM_PROMOTIONS", columnDefinition = "NUMBER(20)")
    private int itemPromotions;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPromotionRecords() {
        promotionID = 0;
        
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
     * @return the paymentAmount
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the numberOfUses
     */
    public int getNumberOfUses() {
        return numberOfUses;
    }

    /**
     * @param numberOfUses the numberOfUses to set
     */
    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return the promotionDescription
     */
    public String getPromotionDescription() {
        return promotionDescription;
    }

    /**
     * @param promotionDescription the promotionDescription to set
     */
    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    /**
     * @return the promotionIdentityType
     */
    public double getPromotionIdentityType() {
        return promotionIdentityType;
    }

    /**
     * @param promotionIdentityType the promotionIdentityType to set
     */
    public void setPromotionIdentityType(double promotionIdentityType) {
        this.promotionIdentityType = promotionIdentityType;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the activeFLG
     */
    public int getActiveFLG() {
        return activeFLG;
    }

    /**
     * @param activeFLG the activeFLG to set
     */
    public void setActiveFLG(int activeFLG) {
        this.activeFLG = activeFLG;
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
     * @return the itemPromotions
     */
    public int getItemPromotions() {
        return itemPromotions;
    }

    /**
     * @param itemPromotions the itemPromotions to set
     */
    public void setItemPromotions(int itemPromotions) {
        this.itemPromotions = itemPromotions;
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
