
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.pref.PurchaseOrderItem_PF;
import reporting.repository.InventoryPurchaseOrderItemRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryPurchaseOrderItemRepositoryImpl")
public class InventoryPurchaseOrderItemRepositoryImpl implements Serializable,InventoryPurchaseOrderItemRepository{
     private DateConvert dateConvert;
     
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    public InventoryPurchaseOrderItemRepositoryImpl(){
       dateConvert = new DateConvert();
    }
    

    @Override
    public List<PurchaseOrderItem> getPurchaseOrderItem(Date startDate, Date endDate) {
        List<PurchaseOrderItem> pOrderItem = new ArrayList<>();
       try {
            PurchaseOrderItem criteria = new PurchaseOrderItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order_item.* from purchase_order_item, stock_item_unit,stock_item,stock_batch,purchase_order "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID");

            for (AbstractEntity entity : entityList) {
                PurchaseOrderItem pOrderEntity = (PurchaseOrderItem) entity;
                
                pOrderItem.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return pOrderItem;

    }

    
    @Override
    public List<PurchaseOrderItem> listPurchaseOrderItemAvl() {
        List<PurchaseOrderItem> pOrderItemAvl = new ArrayList<>();
       try {
            PurchaseOrderItem criteria = new PurchaseOrderItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order_item.* from purchase_order_item, stock_item_unit,stock_item,stock_batch,purchase_order "
                    + "WHERE stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID");

            for (AbstractEntity entity : entityList) {
                PurchaseOrderItem pOrderEntity = (PurchaseOrderItem) entity;
                
                pOrderItemAvl.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return pOrderItemAvl;
    }

    @Override
    public List<PurchaseOrderItem> getPurchaseOrderItemUsingParamList(List<Integer> ids) {
        List<PurchaseOrderItem> itemsList = new ArrayList<>();
        try {
            PurchaseOrderItem criteria = new PurchaseOrderItem();
            
            String str = "(";
            for(Integer i : ids){
               str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length()-1) + ")";
            String query = "select purchase_order_item.* from purchase_order_item where purchase_order_item.PO_ITEM_ID IN  "+str;
            
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                PurchaseOrderItem listEntity = (PurchaseOrderItem) entity;
                
                itemsList.add(listEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return itemsList;
    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
    
    
    
}
