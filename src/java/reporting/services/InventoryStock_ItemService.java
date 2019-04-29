package reporting.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import reporting.domain.StockItem;
import reporting.domain.pref.StockItem_PF;

public interface InventoryStock_ItemService {

    public StockItem getItemName(Integer id);

    public List<StockItem> listStockItems(Date startDate, Date endDate);

    public List<StockItem> getStockItemUsingParamList(Set<Integer> ids);

    public List<StockItem> getStockItemsAvailable();
    
    
    
//    public StockItem_PF getItemName(Integer id);
//
//    public List<StockItem_PF> listStockItems(Date startDate, Date endDate);
//
//    public List<StockItem_PF> getStockItemUsingParamList(Set<Integer> ids);
//
//    public List<StockItem_PF> getStockItemsAvailable();
}
