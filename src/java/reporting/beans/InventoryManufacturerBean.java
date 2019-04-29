
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.Manufacturer;
import reporting.domain.pref.Manufacturer_PF;
import reporting.services.InventoryManufacturerService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryManufacturerBean")
public class InventoryManufacturerBean implements Serializable, InventoryManufacturerService{

    @ManagedProperty(value = "#{inventoryManufacturerRepositoryImpl}")
    private InventoryManufacturerRepositoryImpl inventoryManufacturerRepository;
    
    public InventoryManufacturerBean(){
       inventoryManufacturerRepository = new InventoryManufacturerRepositoryImpl();
    }
    
    @Override
    public List<Manufacturer> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate) {
        return inventoryManufacturerRepository.getBrandNamesOfCurrentInventoryItems(startDate, endDate);
    }

    @Override
    public List<Manufacturer> getBrandNamesOfAllSoldItems(Date startDate, Date endDate) {
       return inventoryManufacturerRepository.getBrandNamesOfAllSoldItems(startDate, endDate);
    }

    @Override
    public Manufacturer getManufacturerById(Integer id) {
       return inventoryManufacturerRepository.getManufacturerById(id);
    }

    @Override
    public List<Manufacturer> findAllBrands() {
      return inventoryManufacturerRepository.findAllBrands();
    }

    @Override
    public List<Manufacturer> getManufacturerUsingParamList(Set<Integer> ids) {
       return inventoryManufacturerRepository.getManufacturerUsingParamList(ids);
    }

    public InventoryManufacturerRepositoryImpl getInventoryManufacturerRepository() {
        return inventoryManufacturerRepository;
    }

    public void setInventoryManufacturerRepository(InventoryManufacturerRepositoryImpl inventoryManufacturerRepository) {
        this.inventoryManufacturerRepository = inventoryManufacturerRepository;
    }
    
    
    
}
