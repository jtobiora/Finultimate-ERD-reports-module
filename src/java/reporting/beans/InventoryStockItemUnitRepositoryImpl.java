
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
import reporting.domain.StockItemUnit;
import reporting.domain.pref.StockItemUnit_PF;
import reporting.repository.InventoryStockItemUnitRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockItemUnitRepositoryImpl")
public class InventoryStockItemUnitRepositoryImpl implements Serializable, InventoryStockItemUnitRepository{

    private DateConvert dateConvert;
    
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
     
    public InventoryStockItemUnitRepositoryImpl(){
       dateConvert = new DateConvert();
       
    }
    

    @Override
    public List<StockItemUnit> getInventoryItems(Date startDate, Date endDate) {
       List<StockItemUnit> sItemUnit = new ArrayList<>();
       try {
            StockItemUnit criteria = new StockItemUnit();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item_unit.* from stock_item_unit, stock_batch  "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.quantity > 0 order by stock_item_unit.EXPIRY_DATE ASC");

            for (AbstractEntity entity : entityList) {
                StockItemUnit stockEntity = (StockItemUnit) entity;
                //st.setActive_date(startDate);
                
                
                
                sItemUnit.add(stockEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return sItemUnit;
    }

    @Override
    public List<StockItemUnit> getInventoryItemsUsingOrderLevel(Date startDate, Date endDate) {
       List<StockItemUnit> orderList = new ArrayList<>();
       try {
            StockItemUnit criteria = new StockItemUnit();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item_unit.* from stock_item_unit, stock_batch,stock_item  "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and stock_item_unit.quantity <= stock_item.REORDER_LEVEL "
                    + "and stock_item_unit.quantity > 0");

            for (AbstractEntity entity : entityList) {
                StockItemUnit stockEntity = (StockItemUnit) entity;
                
                orderList.add(stockEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return orderList;   
    }
		
    @Override
    public List<StockItemUnit> getCurrentInventoryItemsBelongingToABrand(Date startDate, Date endDate, Integer id) {
        List<StockItemUnit> orderList = new ArrayList<>();
        try {
            StockItemUnit criteria = new StockItemUnit();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct stock_item_unit.* from stock_item_unit, stock_batch,stock_item,manufacturer "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and manufacturer.MANUFACTURER_ID = '"+id+"' "
                    + "and stock_item.MANUFACTURER_ID = manufacturer.MANUFACTURER_ID");

            for (AbstractEntity entity : entityList) {
                StockItemUnit stockEntity = (StockItemUnit) entity;
                
                orderList.add(stockEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return orderList;   

    }

    @Override
    public List<StockItemUnit> getStockItemUnitUsingParamList(Set<Integer> ids) {
        List<StockItemUnit> itemsList = new ArrayList<>();
        try {
            StockItemUnit criteria = new StockItemUnit();
            
            String str = "(";
            for(Integer i : ids){
               str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length()-1) + ")";
            String query = "select stock_item_unit.* from stock_item_unit where stock_item_unit.STOCK_UNIT_ITEM_ID IN "+str;
            
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                StockItemUnit listEntity = (StockItemUnit) entity;
                
                itemsList.add(listEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return itemsList;
    }

    @Override
    public List<StockItemUnit> getAvailableProducts() {
       List<StockItemUnit> sItemAvl = new ArrayList<>();
       try {
            StockItemUnit criteria = new StockItemUnit();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item_unit.* from stock_item_unit, stock_item,stock_batch "
                    + "WHERE stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and stock_item_unit.quantity > 0");

            for (AbstractEntity entity : entityList) {
                StockItemUnit pOrderEntity = (StockItemUnit) entity;
                
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
