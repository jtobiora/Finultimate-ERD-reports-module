
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.StockBatch;
import reporting.domain.pref.StockBatch_PF;
import reporting.services.InventoryStockBatchService;


@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockBatchBean")
public class InventoryStockBatchBean implements Serializable,InventoryStockBatchService{

    @ManagedProperty(value = "#{inventoryStockBatchRepositoryImpl}")
    private InventoryStockBatchRepositoryImpl inventoryStockBatchRepository;
    
    public InventoryStockBatchBean(){
       inventoryStockBatchRepository = new InventoryStockBatchRepositoryImpl();
    }
    
    @Override
    public StockBatch getSupplyInfoForAnItem(Integer id) {
        return inventoryStockBatchRepository.getSupplyInfoForAnItem(id);
    }

    @Override
    public List<StockBatch> getSupplyInfoForAllItems(Date startDate, Date endDate) {
	return inventoryStockBatchRepository.getSupplyInfoForAllItems(startDate, endDate);
    }

    @Override
    public List<StockBatch> getStockBatchUsingParamList(List<Integer> ids) {
	return inventoryStockBatchRepository.getStockBatchUsingParamList(ids);
    }

    @Override
    public List<StockBatch> getStockBatchAvl() {
        return inventoryStockBatchRepository.getStockBatchAvl();
    }

    public InventoryStockBatchRepositoryImpl getInventoryStockBatchRepository() {
        return inventoryStockBatchRepository;
    }

    public void setInventoryStockBatchRepository(InventoryStockBatchRepositoryImpl inventoryStockBatchRepository) {
        this.inventoryStockBatchRepository = inventoryStockBatchRepository;
    }
    
    
}
