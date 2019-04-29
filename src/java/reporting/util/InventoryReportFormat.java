package reporting.util;

import java.util.List;
import reporting.domain.ItemWarehouse;
import reporting.domain.Manufacturer;

public class InventoryReportFormat {

    private Manufacturer manufacturer;
    private ItemWarehouse warehouse;
    private InventoryReportPull reportPull;
    private String brandName;
    private String itemName;
    private List<StockTransferDetails> transferDetails;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<StockTransferDetails> getTransferDetails() {
        return transferDetails;
    }

    public void setTransferDetails(List<StockTransferDetails> transferDetails) {
        this.transferDetails = transferDetails;
    }

    public ItemWarehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(ItemWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public InventoryReportPull getReportPull() {
        return reportPull;
    }

    public void setReportPull(InventoryReportPull reportPull) {
        this.reportPull = reportPull;
    }

}
