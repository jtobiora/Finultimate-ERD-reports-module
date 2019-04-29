
package reporting.repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import reporting.domain.StockItemUnit;
import reporting.domain.pref.StockItemUnit_PF;

public interface InventoryStockItemUnitRepository {
    
    
    public List<StockItemUnit> getInventoryItems(Date startDate, Date endDate);

    public List<StockItemUnit> getInventoryItemsUsingOrderLevel(Date startDate, Date endDate);

    public List<StockItemUnit> getCurrentInventoryItemsBelongingToABrand(Date startDate, Date endDate,Integer id);

    public List<StockItemUnit> getStockItemUnitUsingParamList(Set<Integer> ids);
    
    public List<StockItemUnit> getAvailableProducts();
    
    
//    public List<StockItemUnit_PF> getInventoryItems(Date startDate, Date endDate);
//
//    public List<StockItemUnit_PF> getInventoryItemsUsingOrderLevel(Date startDate, Date endDate);
//
//    public List<StockItemUnit_PF> getCurrentInventoryItemsBelongingToABrand(Date startDate, Date endDate,Integer id);
//
//    public List<StockItemUnit_PF> getStockItemUnitUsingParamList(Set<Integer> ids);
//    
//    public List<StockItemUnit_PF> getAvailableProducts();
    
}
