
package reporting.repository;

import java.util.Date;
import java.util.List;
import reporting.domain.StockBatch;

public interface InventoryStockBatchRepository {
    
    
    public StockBatch getSupplyInfoForAnItem(Integer id);
    
    public List<StockBatch> getSupplyInfoForAllItems(Date startDate, Date endDate);

    public List<StockBatch> getStockBatchUsingParamList(List<Integer> ids);
    
    public List<StockBatch> getStockBatchAvl();
    
    
//    public StockBatch_PF getSupplyInfoForAnItem(Integer id);
//    
//    public List<StockBatch_PF> getSupplyInfoForAllItems(Date startDate, Date endDate);
//
//    public List<StockBatch_PF> getStockBatchUsingParamList(List<Integer> ids);
//    
//    public List<StockBatch_PF> getStockBatchAvl();
    
}
