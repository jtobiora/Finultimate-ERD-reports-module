
package reporting.repository;

import java.util.Date;
import java.util.List;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.pref.PurchaseOrderItem_PF;


public interface InventoryPurchaseOrderItemRepository {
    
    public List<PurchaseOrderItem> getPurchaseOrderItem(Date startDate,Date endDate);

    public List<PurchaseOrderItem> listPurchaseOrderItemAvl();
    
    public List<PurchaseOrderItem> getPurchaseOrderItemUsingParamList(List<Integer> ids);
    
    
//    public List<PurchaseOrderItem_PF> getPurchaseOrderItem(Date startDate,Date endDate);
//
//    public List<PurchaseOrderItem_PF> listPurchaseOrderItemAvl();
//    
//    public List<PurchaseOrderItem_PF> getPurchaseOrderItemUsingParamList(List<Integer> ids);
	
}
