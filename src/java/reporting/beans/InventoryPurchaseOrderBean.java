
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.PurchaseOrder;
import reporting.domain.pref.PurchaseOrder_PF;
import reporting.services.InventoryPurchaseOrderService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryPurchaseOrderBean")
public class InventoryPurchaseOrderBean implements Serializable, InventoryPurchaseOrderService{

    @ManagedProperty(value = "#{inventoryPurchaseOrderRepositoryImpl}")
    private InventoryPurchaseOrderRepositoryImpl inventoryPurchaseOrderRepository;
    
    public InventoryPurchaseOrderBean(){
       inventoryPurchaseOrderRepository = new InventoryPurchaseOrderRepositoryImpl();
    }
    
//    @Override
//    public PurchaseOrder getPurchaseOrderForAnItem(Integer id) {
//         return inventoryPurchaseOrderRepository.getPurchaseOrderForAnItem(id);
//    }
//
//    @Override
//    public List<PurchaseOrder> getPurchaseOrder(Date start, Date end) {
//	 return inventoryPurchaseOrderRepository.getPurchaseOrder(start, end);
//    }
//
//    @Override
//    public List<PurchaseOrder> getPurchaseOrderUsingParamList(List<Integer> ids) {
//	return inventoryPurchaseOrderRepository.getPurchaseOrderUsingParamList(ids);
//    }
//
//    @Override
//    public List<PurchaseOrder> getPurchaseOrderAvl() {
//       return inventoryPurchaseOrderRepository.getPurchaseOrderAvl();
//    }

    
    @Override
    public PurchaseOrder getPurchaseOrderForAnItem(Integer id) {
         return inventoryPurchaseOrderRepository.getPurchaseOrderForAnItem(id);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrder(Date start, Date end) {
	 return inventoryPurchaseOrderRepository.getPurchaseOrder(start, end);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderUsingParamList(List<Integer> ids) {
	return inventoryPurchaseOrderRepository.getPurchaseOrderUsingParamList(ids);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderAvl() {
       return inventoryPurchaseOrderRepository.getPurchaseOrderAvl();
    }
    
    
    public InventoryPurchaseOrderRepositoryImpl getInventoryPurchaseOrderRepository() {
        return inventoryPurchaseOrderRepository;
    }

    public void setInventoryPurchaseOrderRepository(InventoryPurchaseOrderRepositoryImpl inventoryPurchaseOrderRepository) {
        this.inventoryPurchaseOrderRepository = inventoryPurchaseOrderRepository;
    }
    
    
    
}
