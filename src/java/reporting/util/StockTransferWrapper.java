package reporting.util;

import reporting.domain.StockTransferReq;

public class StockTransferWrapper {

    private Integer manufacturerId;
    private StockTransferReq transferReq;

    public StockTransferReq getTransferReq() {
        return transferReq;
    }

    public void setTransferReq(StockTransferReq transferReq) {
        this.transferReq = transferReq;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Override
    public String toString() {
        return "brandId=" + manufacturerId + ", stockItem=" + transferReq.getStockItemId();
    }
}
