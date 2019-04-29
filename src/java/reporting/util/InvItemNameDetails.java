package reporting.util;

import java.util.Date;

public class InvItemNameDetails {
    private String itemName;
    private Date dateOfEntry;
    private Date expiryDate;
    private String purchaseOrderNumber;
    private String stockBatchNumber;
    private Integer stockAge;
    private Double stockLeft;
    private String stockValue;
    private String unitPrice;
    private Integer reorderLevel;
    private String revenueEarned;
    private Double totalQtySold;
    private String barcodeNumber;
    private String serialNumber;

    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getRevenueEarned() {
        return revenueEarned;
    }

    public void setRevenueEarned(String revenueEarned) {
        this.revenueEarned = revenueEarned;
    }

    public Double getTotalQtySold() {
        return totalQtySold;
    }

    public void setTotalQtySold(Double totalQtySold) {
        this.totalQtySold = totalQtySold;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStockValue() {
        return stockValue;
    }

    public void setStockValue(String stockValue) {
        this.stockValue = stockValue;
    }

    public Double getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(Double stockLeft) {
        this.stockLeft = stockLeft;
    }

    public Integer getStockAge() {
        return stockAge;
    }

    public void setStockAge(Integer stockAge) {
        this.stockAge = stockAge;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getStockBatchNumber() {
        return stockBatchNumber;
    }

    public void setStockBatchNumber(String stockBatchNumber) {
        this.stockBatchNumber = stockBatchNumber;
    }

}
