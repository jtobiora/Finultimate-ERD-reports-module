
package reporting.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.ItemWarehouse;
import reporting.domain.pref.ItemWarehouse_PF;
import reporting.services.InventoryWarehouseService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryWarehouseBean")
public class InventoryWarehouseBean implements Serializable,InventoryWarehouseService{

    @ManagedProperty(value = "#{inventoryWarehouseRepositoryImpl}")
    private InventoryWarehouseRepositoryImpl inventoryWarehouseRepository;
    
    public InventoryWarehouseBean(){
      inventoryWarehouseRepository = new InventoryWarehouseRepositoryImpl();
    }   
    
    @Override
    public List<ItemWarehouse> findAllWarehouses() {
        return inventoryWarehouseRepository.findAllWarehouses();
    }
    
    @Override
    public List<ItemWarehouse> getWarehousesUsingParamList(Set<Integer> ids) {
        return inventoryWarehouseRepository.getWarehousesUsingParamList(ids);
    }
    
    public InventoryWarehouseRepositoryImpl getInventoryWarehouseRepository() {
        return inventoryWarehouseRepository;
    }

    public void setInventoryWarehouseRepository(InventoryWarehouseRepositoryImpl inventoryWarehouseRepository) {
        this.inventoryWarehouseRepository = inventoryWarehouseRepository;
    }    
    
}
