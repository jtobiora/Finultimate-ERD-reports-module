package reporting.repository;

import java.util.List;
import java.util.Set;
import reporting.domain.ItemWarehouse;

public interface InventoryWarehouseRepository {

    public List<ItemWarehouse> findAllWarehouses();

    public List<ItemWarehouse> getWarehousesUsingParamList(Set<Integer> ids);
}
