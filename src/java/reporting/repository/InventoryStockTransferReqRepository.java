
package reporting.repository;

import java.util.Date;
import java.util.List;
import reporting.domain.StockTransferReq;


public interface InventoryStockTransferReqRepository {
    public List<StockTransferReq> getStockTransfers(Date startDate,Date endDate,Integer status);
}
