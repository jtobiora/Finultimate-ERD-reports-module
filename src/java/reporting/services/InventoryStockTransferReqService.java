
package reporting.services;

import java.util.Date;
import java.util.List;
import reporting.domain.StockTransferReq;


public interface InventoryStockTransferReqService {
    
      public List<StockTransferReq> getStockTransfers(Date startDate, Date endDate, Integer status);
}
