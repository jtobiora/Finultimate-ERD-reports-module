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
@Table(name="POS_CART_ITEM")
public class PosCartItem extends AbstractEntity implements Serializable {
    
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private long posCartItemID;
    
    @Column(name = "ITEM_COST_PRICE", columnDefinition = "DOUBLE PRECISION")
    private double itemCostPRice;
    
    @Column(name = "ITEM_DISCOUNT", columnDefinition = "DOUBLE PRECISION")
    private double itemDiscount;
    
    @Column(name = "ITEM_PRESCRIPTION_URL", columnDefinition = "VARCHAR2(255)")
    private String itemPrescriptionUrl;
    
    @Column(name = "ITEM_QUANTITY", columnDefinition = "NUMBER(11)")
    private int itemQuantity;
    
    @Column(name = "ITEM_SELLING_PRICE", columnDefinition = "DOUBLE PRECISION")
    private double itemSellingPrice;
    
    @Column(name = "CART_ID", columnDefinition = "NUMBER(20)")
    private int cartId;
    
    @Column(name = "ITEM_ID", columnDefinition = "NUMBER(20)")
    private long itemId;
    
    //
    private transient int approvalStatusID = 0;
    //
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosCartItem() {
        posCartItemID = 0;
        
    }
    
    public boolean equals(Object o){
        boolean eqls = false;

        if(o instanceof PosCartItem) {
            if((((PosCartItem)o).getPosCartItemID() > 0) &&
                    (((PosCartItem)o).getPosCartItemID() == this.getPosCartItemID())){
                eqls = true;
            }
        }

        return eqls;
    }
    
//    public PosItemRecord getAsPosItemRecord() {
//        PosItemRecord entity = new PosItemRecord();
//        
//        entity.setID(posCartItemID);
//        entity.setItemCostPrice(itemCostPRice);
//        entity.setItemDiscount(itemDiscount);
//        entity.setItemPrescriptionUrl(itemQuantity);
//        
//        return entity;
//    }

    

    /**
     * @return the itemCostPRice
     */
    public double getItemCostPRice() {
        return itemCostPRice;
    }

    /**
     * @param itemCostPRice the itemCostPRice to set
     */
    public void setItemCostPRice(double itemCostPRice) {
        this.itemCostPRice = itemCostPRice;
    }

    /**
     * @return the itemDiscount
     */
    public double getItemDiscount() {
        return itemDiscount;
    }

    /**
     * @param itemDiscount the itemDiscount to set
     */
    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    /**
     * @return the itemPrescriptionUrl
     */
    public String getItemPrescriptionUrl() {
        return itemPrescriptionUrl;
    }

    /**
     * @param itemPrescriptionUrl the itemPrescriptionUrl to set
     */
    public void setItemPrescriptionUrl(String itemPrescriptionUrl) {
        this.itemPrescriptionUrl = itemPrescriptionUrl;
    }

    /**
     * @return the itemQuantity
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * @param itemQuantity the itemQuantity to set
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * @return the itemSellingPrice
     */
    public double getItemSellingPrice() {
        return itemSellingPrice;
    }

    /**
     * @param itemSellingPrice the itemSellingPrice to set
     */
    public void setItemSellingPrice(double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    /**
     * @return the cartId
     */
    public int getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(int cartId) {
        this.cartId = cartId;
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
     * @return the posCartItemID
     */
    public long getPosCartItemID() {
        return posCartItemID;
    }

    /**
     * @param posCartItemID the posCartItemID to set
     */
    public void setPosCartItemID(long posCartItemID) {
        this.posCartItemID = posCartItemID;
    }

    /**
     * @return the itemId
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
    
}
