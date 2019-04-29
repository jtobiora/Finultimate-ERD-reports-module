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
@Table(name="POS_ITEM_RECORD")

public class PosItemRecord extends AbstractEntity implements Serializable {
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private long posItemRecordID;
    
    @Column(name = "CATEGORY_ID", columnDefinition = "NUMBER(20)")
    private int categoryID;
    
    @Column(name = "ITEM_CONTRA_INDICATOR", columnDefinition = "Varchar2(255)")
    private String itemContraIndicator;
    
    @Column(name = "ITEM_COST_PRICE", columnDefinition = "DOUBLE PRECISION")
    private double itemCostPrice;
    
    @Column(name = "ITEM_DISCOUNT", columnDefinition = "DOUBLE PRECISION")
    private double itemDiscount;
    
    @Column(name = "ITEM_IMAGE", columnDefinition = "Varchar2(255)")
    private byte[] itemImage;
    
    @Column(name = "ITEM_NAME", columnDefinition = "Varchar2(255)")
    private String itemName;
    
    @Column(name = "ITEM_PRESCRIPTION", columnDefinition = "NUMBER(1)")
    private int itemPrescription;
    
    @Column(name = "ITEM_RECIEPT_LIMIT", columnDefinition = "NUMBER(11)")
    private int itemReceiptLimit;
    
    @Column(name = "ITEM_SELLING_PRICE", columnDefinition = "DOUBLE")
    private double itemSellingPrice;
    
    @Column(name = "ITEM_SERIAL_NUMBER", columnDefinition = "Varchar2(255)")
    private String itemSerialNumber;
    
    @Column(name = "ITEM_TYPE", columnDefinition = "Varchar2(255)")
    private String itemType;
    
    @Column(name = "ITEM_VAT", columnDefinition = "DOUBLE")
    private double itemVAT;
    
    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(20)")
    private int warehouseID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosItemRecord() {
        posItemRecordID = 0;
        
    }

   public boolean equals(Object o){
        boolean eqls = false;

        if(o instanceof PosItemRecord) {
            if((((PosItemRecord)o).getPosItemRecordID() > 0) &&
                    (((PosItemRecord)o).getPosItemRecordID() == this.getPosItemRecordID())){
                eqls = true;
            }
        }

        return eqls;
    } 

    /**
     * @return the categoryID
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the itemContraIndicator
     */
    public String getItemContraIndicator() {
        return itemContraIndicator;
    }

    /**
     * @param itemContraIndicator the itemContraIndicator to set
     */
    public void setItemContraIndicator(String itemContraIndicator) {
        this.itemContraIndicator = itemContraIndicator;
    }

    /**
     * @return the itemCostPrice
     */
    public double getItemCostPrice() {
        return itemCostPrice;
    }

    /**
     * @param itemCostPrice the itemCostPrice to set
     */
    public void setItemCostPrice(double itemCostPrice) {
        this.itemCostPrice = itemCostPrice;
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
     * @return the itemImage
     */
    public byte[] getItemImage() {
        return itemImage;
    }

    /**
     * @param itemImage the itemImage to set
     */
    public void setItemImage(byte[] itemImage) {
        this.itemImage = itemImage;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemPrescription
     */
    public int getItemPrescription() {
        return itemPrescription;
    }

    /**
     * @param itemPrescription the itemPrescription to set
     */
    public void setItemPrescription(int itemPrescription) {
        this.itemPrescription = itemPrescription;
    }

    /**
     * @return the itemReceiptLimit
     */
    public int getItemReceiptLimit() {
        return itemReceiptLimit;
    }

    /**
     * @param itemReceiptLimit the itemReceiptLimit to set
     */
    public void setItemReceiptLimit(int itemReceiptLimit) {
        this.itemReceiptLimit = itemReceiptLimit;
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
     * @return the itemSerialNumber
     */
    public String getItemSerialNumber() {
        return itemSerialNumber;
    }

    /**
     * @param itemSerialNumber the itemSerialNumber to set
     */
    public void setItemSerialNumber(String itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the itemVAT
     */
    public double getItemVAT() {
        return itemVAT;
    }

    /**
     * @param itemVAT the itemVAT to set
     */
    public void setItemVAT(double itemVAT) {
        this.itemVAT = itemVAT;
    }

    /**
     * @return the warehouseID
     */
    public int getWarehouseID() {
        return warehouseID;
    }

    /**
     * @param warehouseID the warehouseID to set
     */
    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
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
     * @return the posItemRecordID
     */
    public long getPosItemRecordID() {
        return posItemRecordID;
    }

    /**
     * @param posItemRecordID the posItemRecordID to set
     */
    public void setPosItemRecordID(long posItemRecordID) {
        this.posItemRecordID = posItemRecordID;
    }
}
