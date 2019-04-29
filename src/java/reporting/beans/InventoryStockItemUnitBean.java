
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.StockItemUnit;
import reporting.domain.pref.StockItemUnit_PF;
import reporting.services.InventoryStockItemUnitService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockItemUnitBean")
public class InventoryStockItemUnitBean implements Serializable,InventoryStockItemUnitService{

    @ManagedProperty(value = "#{inventoryStockItemUnitRepositoryImpl}")
    private InventoryStockItemUnitRepositoryImpl inventoryStockItemUnitRepository;
    
    public InventoryStockItemUnitBean(){
       inventoryStockItemUnitRepository = new InventoryStockItemUnitRepositoryImpl();
    }
    
    @Override
    public List<StockItemUnit> getInventoryItems(Date startDate, Date endDate) {
	return inventoryStockItemUnitRepository.getInventoryItems(startDate, endDate);
    }

    @Override
    public List<StockItemUnit> getCurrentInventoryItemsBelongingToABrand(Date startDate, Date endDate, Integer id) {
        return inventoryStockItemUnitRepository.getCurrentInventoryItemsBelongingToABrand(startDate, endDate, id);
    }

    @Override
    public List<StockItemUnit> getInventoryItemsUsingOrderLevel(Date startDate, Date endDate) {
	return inventoryStockItemUnitRepository.getInventoryItemsUsingOrderLevel(startDate, endDate);
    }

    @Override
    public List<StockItemUnit> getStockItemUnitUsingParamList(Set<Integer> ids) {
	return inventoryStockItemUnitRepository.getStockItemUnitUsingParamList(ids);
    }

    @Override
    public List<StockItemUnit> getProductsAvailable() {
	return inventoryStockItemUnitRepository.getAvailableProducts();
    }

    public InventoryStockItemUnitRepositoryImpl getInventoryStockItemUnitRepository() {
        return inventoryStockItemUnitRepository;
    }

    public void setInventoryStockItemUnitRepository(InventoryStockItemUnitRepositoryImpl inventoryStockItemUnitRepository) {
        this.inventoryStockItemUnitRepository = inventoryStockItemUnitRepository;
    }
    
    
}
