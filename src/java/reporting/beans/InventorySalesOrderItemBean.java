
package reporting.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.SalesOrderItem;
import reporting.domain.pref.SalesOrderItem_PF;
import reporting.services.InventorySalesOrderItemService;


@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventorySalesOrderItemBean")
public class InventorySalesOrderItemBean implements Serializable,InventorySalesOrderItemService{

    @ManagedProperty(value = "#{inventorySalesOrderItemRepositoryImpl}")
    private InventorySalesOrderItemRepositoryImpl inventorySalesOrderItemRepository;
     
    public InventorySalesOrderItemBean(){
         inventorySalesOrderItemRepository = new InventorySalesOrderItemRepositoryImpl();
    }
     
    @Override
    public List<SalesOrderItem> getItemsSoldBetweenDates(Date startDate, Date endDate) {
         return inventorySalesOrderItemRepository.getItemsSoldBetweenDates(startDate, endDate);
    }

    public InventorySalesOrderItemRepositoryImpl getInventorySalesOrderItemRepository() {
        return inventorySalesOrderItemRepository;
    }

    public void setInventorySalesOrderItemRepository(InventorySalesOrderItemRepositoryImpl inventorySalesOrderItemRepository) {
        this.inventorySalesOrderItemRepository = inventorySalesOrderItemRepository;
    }
    
    
    
    
}
