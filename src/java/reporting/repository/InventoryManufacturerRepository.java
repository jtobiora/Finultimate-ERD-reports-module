/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import reporting.domain.Manufacturer;
import reporting.domain.pref.Manufacturer_PF;


public interface InventoryManufacturerRepository {
    
    public List<Manufacturer> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate);

    public List<Manufacturer> getBrandNamesOfAllSoldItems(Date startDate,Date endDate);

    public List<Manufacturer> getManufacturerUsingParamList(Set<Integer> ids);
    
    public Manufacturer getManufacturerById(Integer id);
    
    public List<Manufacturer> findAllBrands();

//    public List<Manufacturer_PF> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate);
//
//    public List<Manufacturer_PF> getBrandNamesOfAllSoldItems(Date startDate,Date endDate);
//
//    public List<Manufacturer_PF> getManufacturerUsingParamList(Set<Integer> ids);
//    
//    public Manufacturer_PF getManufacturerById(Integer id);
//    
//    public List<Manufacturer_PF> findAllBrands();
}
