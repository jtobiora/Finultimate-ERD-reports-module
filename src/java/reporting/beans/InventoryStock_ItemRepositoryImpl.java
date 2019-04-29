
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import reporting.domain.StockItem;
import reporting.domain.pref.StockItem_PF;
import reporting.repository.InventoryStock_ItemRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStock_ItemRepositoryImpl")
public class InventoryStock_ItemRepositoryImpl implements Serializable,InventoryStock_ItemRepository{

    private DateConvert dateConvert;
    
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
     
    public InventoryStock_ItemRepositoryImpl(){
       dateConvert = new DateConvert();
       
    }

    @Override
    public StockItem getItemName(Integer id) {
        StockItem stockItem = new StockItem();
        try {
            StockItem criteria = new StockItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct stock_item.* from stock_item, stock_item_unit  where "
                            + "stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                            + "and stock_item_unit.STOCK_UNIT_ITEM_ID = '" + id + "'");

            stockItem = (StockItem) entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return stockItem;
    }

    @Override
    public List<StockItem> listStockItems(Date startDate, Date endDate) {
       List<StockItem> sItem = new ArrayList<>();
       try {
            StockItem criteria = new StockItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item.* from stock_item, stock_item_unit,stock_batch  "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and stock_item_unit.quantity > 0");

            for (AbstractEntity entity : entityList) {
                StockItem stockEntity = (StockItem) entity;
                
                sItem.add(stockEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return sItem;
    }

    @Override
    public List<StockItem> getStockItemUsingParamList(Set<Integer> ids) {
        List<StockItem> itemsList = new ArrayList<>();
        try {
            StockItem criteria = new StockItem();
            
            String str = "(";
            for(Integer i : ids){
               str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length()-1) + ")";
            String query = "select stock_item.* from stock_item where stock_item.STOCK_ITEM_ID IN "+str;
            
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                StockItem listEntity = (StockItem) entity;
                
                itemsList.add(listEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return itemsList;
    }

    @Override
    public List<StockItem> getAvailableStockItems() {
         List<StockItem> sItemAvl = new ArrayList<>();
       try {
            StockItem criteria = new StockItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item.* from stock_item, stock_item_unit,stock_batch "
                    + "WHERE stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and stock_item_unit.quantity > 0");

            for (AbstractEntity entity : entityList) {
                StockItem pOrderEntity = (StockItem) entity;
                
                sItemAvl.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return sItemAvl;
    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
    
    
    
}
