
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.pref.PurchaseOrderItem_PF;
import reporting.services.InventoryPurchaseOrderItemService;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryPurchaseOrderItemBean")
public class InventoryPurchaseOrderItemBean implements Serializable, InventoryPurchaseOrderItemService {
    
    @ManagedProperty(value = "#{inventoryPurchaseOrderItemRepositoryImpl}")
    private InventoryPurchaseOrderItemRepositoryImpl poiRepository;
    
    public InventoryPurchaseOrderItemBean(){
       poiRepository = new InventoryPurchaseOrderItemRepositoryImpl();
    }
    
//    @Override
//    public List<PurchaseOrderItem_PF> getPurchaseOrderItem(Date startDate, Date endDate) {
//       return poiRepository.getPurchaseOrderItem(startDate, endDate);
//    }
//
//    @Override
//    public List<PurchaseOrderItem_PF> listPurchaseOrderItemAvl() {
//       return poiRepository.listPurchaseOrderItemAvl();
//    }
//
//    @Override
//    public List<PurchaseOrderItem_PF> getPurchaseOrderItemUsingParamList(List<Integer> ids) {
//        return poiRepository.getPurchaseOrderItemUsingParamList(ids);
//    }

    
        @Override
    public List<PurchaseOrderItem> getPurchaseOrderItem(Date startDate, Date endDate) {
       return poiRepository.getPurchaseOrderItem(startDate, endDate);
    }

    @Override
    public List<PurchaseOrderItem> listPurchaseOrderItemAvl() {
       return poiRepository.listPurchaseOrderItemAvl();
    }

    @Override
    public List<PurchaseOrderItem> getPurchaseOrderItemUsingParamList(List<Integer> ids) {
        return poiRepository.getPurchaseOrderItemUsingParamList(ids);
    }
    
    
    public InventoryPurchaseOrderItemRepositoryImpl getPoiRepository() {
        return poiRepository;
    }

    public void setPoiRepository(InventoryPurchaseOrderItemRepositoryImpl poiRepository) {
        this.poiRepository = poiRepository;
    }
    
    
    
}
