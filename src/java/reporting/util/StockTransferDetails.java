package reporting.util;

import java.util.Date;

public class StockTransferDetails {

    private Date transferDate;
    private Integer quantitySent;
    private String warehouseName;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Integer getQuantitySent() {
        return quantitySent;
    }

    public void setQuantitySent(Integer quantitySent) {
        this.quantitySent = quantitySent;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
