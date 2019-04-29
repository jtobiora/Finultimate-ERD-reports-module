
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.StockItem;
import reporting.domain.pref.StockItem_PF;
import reporting.services.InventoryStock_ItemService;


@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStock_ItemBean")
public class InventoryStock_ItemBean implements Serializable, InventoryStock_ItemService{

    @ManagedProperty(value = "#{inventoryStock_ItemRepositoryImpl}")
    private InventoryStock_ItemRepositoryImpl inventoryStock_ItemRepository;
    
    public InventoryStock_ItemBean(){
        inventoryStock_ItemRepository = new InventoryStock_ItemRepositoryImpl();
    }
    
    @Override
    public StockItem getItemName(Integer id) {
       return inventoryStock_ItemRepository.getItemName(id);
    }

    @Override
    public List<StockItem> listStockItems(Date startDate, Date endDate) {
       return inventoryStock_ItemRepository.listStockItems(startDate, endDate);
    }

    @Override
    public List<StockItem> getStockItemUsingParamList(Set<Integer> ids) {
        return inventoryStock_ItemRepository.getStockItemUsingParamList(ids);
    }

    @Override
    public List<StockItem> getStockItemsAvailable() {
        return inventoryStock_ItemRepository.getAvailableStockItems();
    }

    public InventoryStock_ItemRepositoryImpl getInventoryStock_ItemRepository() {
        return inventoryStock_ItemRepository;
    }

    public void setInventoryStock_ItemRepository(InventoryStock_ItemRepositoryImpl inventoryStock_ItemRepository) {
        this.inventoryStock_ItemRepository = inventoryStock_ItemRepository;
    }
    
    
    
}
