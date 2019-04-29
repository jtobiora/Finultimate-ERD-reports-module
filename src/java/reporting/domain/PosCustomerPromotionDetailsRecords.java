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
@Table(name="POS_CUSTOMER_PROMOTION_DETAILS_RECORDS")
public class PosCustomerPromotionDetailsRecords extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posCustomerPromotionID;
    
    @Column(name = "TOTAL_LLTY_POINTS", columnDefinition = "NUMBER(11)")
    private int totalLLTYPoints;
    
    @Column(name = "PROMOTION_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double promotionAmount;
    
    @Column(name = "PROMOTION_CODE", columnDefinition = "Varchar2(255)")
    private String promotionCode;
    
    @Column(name = "SALES_ORDER_ID", columnDefinition = "NUMBER(20)")
    private int salesOrderID;
    
    @Column(name = "PROMOTION_SUMMARY_ID", columnDefinition = "NUMBER(20)")
    private int promotionSummaryID;
    
    private transient int approvalStatusID = 0;
   
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosCustomerPromotionDetailsRecords() {
        posCustomerPromotionID = 0;
        
    }

    /**
     * @return the totalLLTYPoints
     */
    public int getTotalLLTYPoints() {
        return totalLLTYPoints;
    }

    /**
     * @param totalLLTYPoints the totalLLTYPoints to set
     */
    public void setTotalLLTYPoints(int totalLLTYPoints) {
        this.totalLLTYPoints = totalLLTYPoints;
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
     * @return the salesOrderID
     */
    public int getSalesOrderID() {
        return salesOrderID;
    }

    /**
     * @param salesOrderID the salesOrderID to set
     */
    public void setSalesOrderID(int salesOrderID) {
        this.salesOrderID = salesOrderID;
    }

    /**
     * @return the promotionSummaryID
     */
    public int getPromotionSummaryID() {
        return promotionSummaryID;
    }

    /**
     * @param promotionSummaryID the promotionSummaryID to set
     */
    public void setPromotionSummaryID(int promotionSummaryID) {
        this.promotionSummaryID = promotionSummaryID;
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

    /**
     * @return the posCustomerPromotionID
     */
    public int getPosCustomerPromotionID() {
        return posCustomerPromotionID;
    }

    /**
     * @param posCustomerPromotionID the posCustomerPromotionID to set
     */
    public void setPosCustomerPromotionID(int posCustomerPromotionID) {
        this.posCustomerPromotionID = posCustomerPromotionID;
    }
}
