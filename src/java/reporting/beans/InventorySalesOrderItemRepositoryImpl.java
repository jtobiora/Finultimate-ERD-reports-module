
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.SalesOrderItem;
import reporting.domain.pref.SalesOrderItem_PF;
import reporting.repository.InventorySalesOrderItemRepository;
import reporting.util.DateConvert;


@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventorySalesOrderItemRepositoryImpl")
public class InventorySalesOrderItemRepositoryImpl implements Serializable,InventorySalesOrderItemRepository{
    private DateConvert dateConvert;
     
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    public InventorySalesOrderItemRepositoryImpl(){
       dateConvert = new DateConvert();
    }
    
    
    @Override
    public List<SalesOrderItem> getItemsSoldBetweenDates(Date startDate, Date endDate) {
          List<SalesOrderItem> soldItems = new ArrayList<>();
       try {
            SalesOrderItem criteria = new SalesOrderItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct sales_order_item.* from sales_order_item, sales_order,stock_batch,stock_item, stock_item_unit "
                    + "WHERE sales_order.ORDER_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and sales_order.ORDER_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and sales_order.SALES_ORDER_ID = sales_order_item.SALES_ORDER_ID "
                    + "and sales_order_item.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and sales_order_item.STOCK_ITEM_UNIT_ID = stock_item_unit.STOCK_UNIT_ITEM_ID "
                    + "and stock_item.STOCK_ITEM_ID = stock_item_unit.STOCK_ITEM_ID "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID");

            for (AbstractEntity entity : entityList) {
                SalesOrderItem soldEntity = (SalesOrderItem) entity;
                
                soldItems.add(soldEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return listOfVendors;
        return soldItems;

    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
    
    
    
}
