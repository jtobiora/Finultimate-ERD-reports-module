package reporting.util;

import java.util.Date;
import java.util.List;

public class GranReports {

    //private Double amountExecuted;
    //private Double balanceRemaining;
    private List<String> brandNames;
    private String amountExecuted;
    private String balanceRemaining;
    private Integer daysTakenForDelivery;
    private Date dateOfEntry;
    private String purchaseOrderCode;
    private List<ItemDetails> itemDetailsReport;

    public List<ItemDetails> getItemDetailsReport() {
        return itemDetailsReport;
    }

    public void setItemDetailsReport(List<ItemDetails> itemDetailsReport) {
        this.itemDetailsReport = itemDetailsReport;
    }

    public String getPurchaseOrderCode() {
        return purchaseOrderCode;
    }

    public void setPurchaseOrderCode(String purchaseOrderCode) {
        this.purchaseOrderCode = purchaseOrderCode;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Integer getDaysTakenForDelivery() {
        return daysTakenForDelivery;
    }

    public void setDaysTakenForDelivery(Integer daysTakenForDelivery) {
        this.daysTakenForDelivery = daysTakenForDelivery;
    }

    public List<String> getBrandNames() {
        return brandNames;
    }

    public void setBrandNames(List<String> brandNames) {
        this.brandNames = brandNames;
    }

    public String getAmountExecuted() {
        return amountExecuted;
    }

    public void setAmountExecuted(String amountExecuted) {
        this.amountExecuted = amountExecuted;
    }

    public String getBalanceRemaining() {
        return balanceRemaining;
    }

    public void setBalanceRemaining(String balanceRemaining) {
        this.balanceRemaining = balanceRemaining;
    }
}
