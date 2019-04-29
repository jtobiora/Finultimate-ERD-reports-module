
package reporting.services;

import java.util.List;
import java.util.Set;
import reporting.domain.ItemWarehouse;

public interface InventoryWarehouseService {
    
    
     public List<ItemWarehouse> findAllWarehouses();
     
     public List<ItemWarehouse> getWarehousesUsingParamList(Set<Integer> ids);
}
