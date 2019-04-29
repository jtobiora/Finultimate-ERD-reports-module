
package reporting.services;

import java.util.Date;
import java.util.List;
import reporting.domain.SalesOrderItem;
import reporting.domain.pref.SalesOrderItem_PF;


public interface InventorySalesOrderItemService {
    
    public List<SalesOrderItem> getItemsSoldBetweenDates(Date startDate,Date endDate);

    //public List<SalesOrderItem_PF> getItemsSoldBetweenDates(Date startDate,Date endDate);

}
