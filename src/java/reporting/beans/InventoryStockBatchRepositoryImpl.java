
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.StockBatch;
import reporting.domain.pref.StockBatch_PF;
import reporting.repository.InventoryStockBatchRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockBatchRepositoryImpl")
public class InventoryStockBatchRepositoryImpl implements Serializable, InventoryStockBatchRepository{

    private DateConvert dateConvert;
     
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
    
    public InventoryStockBatchRepositoryImpl(){
       dateConvert = new DateConvert();
    }
    
    @Override
    public StockBatch getSupplyInfoForAnItem(Integer id) {
        StockBatch batch = new StockBatch();
        try {
            StockBatch criteria = new StockBatch();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_batch.* from stock_batch, stock_item_unit where "
                            + "stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                            + "and stock_item_unit.STOCK_UNIT_ITEM_ID = '" + id + "'");

            batch = (StockBatch) entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return batch;
    }

    
    @Override
    public List<StockBatch> getSupplyInfoForAllItems(Date startDate, Date endDate) {
        List<StockBatch> stockBatchList = new ArrayList<>();
       try {
            StockBatch criteria = new StockBatch();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct stock_batch.* from stock_item_unit,stock_batch  "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID");

            for (AbstractEntity entity : entityList) {
                StockBatch pOrderEntity = (StockBatch) entity;
                
                stockBatchList.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return stockBatchList;

    }

    
    @Override
    public List<StockBatch> getStockBatchUsingParamList(List<Integer> ids) {
        List<StockBatch> itemsList = new ArrayList<>();
        try {
            StockBatch criteria = new StockBatch();
            
            String str = "(";
            for(Integer i : ids){
               str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length()-1) + ")";
            String query = "select stock_batch.* from stock_batch where stock_batch.STOCK_BATCH_ID IN "+str;
            
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                StockBatch listEntity = (StockBatch) entity;
                
                itemsList.add(listEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return itemsList;
    }

    
    @Override
    public List<StockBatch> getStockBatchAvl() {
       List<StockBatch> list = new ArrayList<>();
       try {
            StockBatch criteria = new StockBatch();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_batch.* from stock_batch,stock_item_unit "
                    + "WHERE stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID");

            for (AbstractEntity entity : entityList) {
                StockBatch pOrderEntity = (StockBatch) entity;
                
                list.add(pOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return list;

    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
    
    
    
}
