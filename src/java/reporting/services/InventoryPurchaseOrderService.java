
package reporting.services;

import java.util.Date;
import java.util.List;
import reporting.domain.PurchaseOrder;
import reporting.domain.pref.PurchaseOrder_PF;


public interface InventoryPurchaseOrderService {
    
    	public PurchaseOrder getPurchaseOrderForAnItem(Integer id);
	
	public List<PurchaseOrder> getPurchaseOrder(Date start, Date end);
	
	public List<PurchaseOrder> getPurchaseOrderUsingParamList(List<Integer> ids);
	
	public List<PurchaseOrder> getPurchaseOrderAvl();
    
    
//    public PurchaseOrder_PF getPurchaseOrderForAnItem(Integer id);
//	
//	public List<PurchaseOrder_PF> getPurchaseOrder(Date start, Date end);
//	
//	public List<PurchaseOrder_PF> getPurchaseOrderUsingParamList(List<Integer> ids);
//	
//	public List<PurchaseOrder_PF> getPurchaseOrderAvl();
}
