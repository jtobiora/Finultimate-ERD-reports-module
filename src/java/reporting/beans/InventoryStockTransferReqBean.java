package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.StockTransferReq;
import reporting.services.InventoryStockTransferReqService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockTransferReqBean")
public class InventoryStockTransferReqBean implements Serializable, InventoryStockTransferReqService {

    @ManagedProperty(value = "#{inventoryStockTransferReqRepositoryImpl}")
    private InventoryStockTransferReqRepositoryImpl inventoryStockTransferReqRepositoryImpl;

    public InventoryStockTransferReqBean() {
        inventoryStockTransferReqRepositoryImpl = new InventoryStockTransferReqRepositoryImpl();
    }

    @Override
    public List<StockTransferReq> getStockTransfers(Date startDate, Date endDate, Integer status) {
        return inventoryStockTransferReqRepositoryImpl.getStockTransfers(startDate, endDate, status);
    }

    public InventoryStockTransferReqRepositoryImpl getInventoryStockTransferReqRepositoryImpl() {
        return inventoryStockTransferReqRepositoryImpl;
    }

    public void setInventoryStockTransferReqRepositoryImpl(InventoryStockTransferReqRepositoryImpl inventoryStockTransferReqRepositoryImpl) {
        this.inventoryStockTransferReqRepositoryImpl = inventoryStockTransferReqRepositoryImpl;
    }
      
}
