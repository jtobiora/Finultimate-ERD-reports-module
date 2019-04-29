
package reporting.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import reporting.domain.Manufacturer;
import reporting.domain.pref.Manufacturer_PF;

public interface InventoryManufacturerService {
    
    public List<Manufacturer> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate);

	public List<Manufacturer> getBrandNamesOfAllSoldItems(Date startDate,Date endDate);
	 
	public Manufacturer getManufacturerById(Integer id);
	
	public List<Manufacturer> findAllBrands();
	
	public List<Manufacturer> getManufacturerUsingParamList(Set<Integer> ids);
        
        
//    	public List<Manufacturer_PF> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate);
//
//	public List<Manufacturer_PF> getBrandNamesOfAllSoldItems(Date startDate,Date endDate);
//	 
//	public Manufacturer_PF getManufacturerById(Integer id);
//	
//	public List<Manufacturer_PF> findAllBrands();
//	
//	public List<Manufacturer_PF> getManufacturerUsingParamList(Set<Integer> ids);
}
