
package reporting.repository;

import java.util.Date;
import java.util.List;
import reporting.domain.PurchaseOrder;

public interface InventoryPurchaseOrderRepository {
    
    
    public PurchaseOrder getPurchaseOrderForAnItem(Integer id);
	
    public List<PurchaseOrder> getPurchaseOrder(Date startDate,Date endDate);
    
    public List<PurchaseOrder> getPurchaseOrderUsingParamList(List<Integer> ids);
    
    public List<PurchaseOrder> getPurchaseOrderAvl();
    
    
//    public PurchaseOrder_PF getPurchaseOrderForAnItem(Integer id);
//	
//    public List<PurchaseOrder_PF> getPurchaseOrder(Date startDate,Date endDate);
//    
//    public List<PurchaseOrder_PF> getPurchaseOrderUsingParamList(List<Integer> ids);
//    
//    public List<PurchaseOrder_PF> getPurchaseOrderAvl();
}
