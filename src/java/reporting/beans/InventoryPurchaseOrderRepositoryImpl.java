
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.PurchaseOrder;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.pref.PurchaseOrder_PF;
import reporting.repository.InventoryPurchaseOrderRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryPurchaseOrderRepositoryImpl")
public class InventoryPurchaseOrderRepositoryImpl implements Serializable,InventoryPurchaseOrderRepository{

    private DateConvert dateConvert;
     
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    public InventoryPurchaseOrderRepositoryImpl(){
       dateConvert = new DateConvert();
    }
    
    
    @Override
    public PurchaseOrder getPurchaseOrderForAnItem(Integer id) {
        PurchaseOrder pOrder = new PurchaseOrder();
        try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order.* from purchase_order,stock_item_unit, purchase_order_item "
                            + "WHERE purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                            + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
                            + "and stock_item_unit.PO_ITEM_ID = '" + id + "'");

            pOrder = (PurchaseOrder) entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return pOrder;
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrder(Date startDate, Date endDate) {
         List<PurchaseOrder> pOrder = new ArrayList<>();
       try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order.* from purchase_order, stock_item_unit,stock_item,stock_batch,purchase_order_item "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID");

            for (AbstractEntity entity : entityList) {
                PurchaseOrder pOrderEntity = (PurchaseOrder) entity;
                
                pOrder.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return pOrder;

    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderUsingParamList(List<Integer> ids) {
         List<PurchaseOrder> itemsList = new ArrayList<>();
        try {
            PurchaseOrder criteria = new PurchaseOrder();
            
            String str = "(";
            for(Integer i : ids){
               str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length()-1) + ")";
            String query = "select purchase_order.* from purchase_order where purchase_order.PURCHASE_ORDER_ID IN "+str;
            
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, query);
 
            for (AbstractEntity entity : entityList) {
                PurchaseOrder listEntity = (PurchaseOrder) entity;
                
                itemsList.add(listEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return itemsList;
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrderAvl() {
           List<PurchaseOrder> pOrderAvl = new ArrayList<>();
       try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order.* from purchase_order, stock_item_unit,purchase_order_item "
                    + "WHERE purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID");

            for (AbstractEntity entity : entityList) {
                PurchaseOrder pOrderEntity = (PurchaseOrder) entity;
                
                pOrderAvl.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return pOrderAvl;

    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
    
    
 
}
