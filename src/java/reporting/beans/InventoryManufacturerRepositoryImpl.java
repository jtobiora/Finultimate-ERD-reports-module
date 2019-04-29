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
import reporting.domain.Manufacturer;
import reporting.domain.pref.Manufacturer_PF;
import reporting.repository.InventoryManufacturerRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryManufacturerRepositoryImpl")
public class InventoryManufacturerRepositoryImpl implements Serializable, InventoryManufacturerRepository {

    private DateConvert dateConvert;

//    private List<Manufacturer> cBrands;
//    private List<Manufacturer> sItems;
//    private List<Manufacturer> params;
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    public InventoryManufacturerRepositoryImpl() {
        dateConvert = new DateConvert();
//       cBrands = new ArrayList<>();
//       sItems = new ArrayList<>();  
//       params = new ArrayList<>();

    }

    @Override
    public List<Manufacturer> getBrandNamesOfCurrentInventoryItems(Date startDate, Date endDate) {
        List<Manufacturer> currentBrands = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select distinct manufacturer.* from manufacturer, stock_item_unit,stock_item,stock_batch "
                            + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                            + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                            + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                            + "and stock_item.MANUFACTURER_ID = manufacturer.MANUFACTURER_ID "
                            + "and stock_item.STOCK_ITEM_ID = stock_item_unit.STOCK_ITEM_ID "
                            + "and stock_item_unit.quantity > 0");

            for (AbstractEntity entity : entityList) {
                Manufacturer brandEntity = (Manufacturer) entity;

                currentBrands.add(brandEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return listOfVendors;
        return currentBrands;
    }

    @Override
    public List<Manufacturer> getBrandNamesOfAllSoldItems(Date startDate, Date endDate) {
        List<Manufacturer> soldItems = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select distinct manufacturer.* from manufacturer, stock_item_unit,stock_item,sales_order_item, sales_order "
                            + "WHERE sales_order.ORDER_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                            + "and sales_order.ORDER_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                            + "and sales_order.SALES_ORDER_ID = sales_order_item.SALES_ORDER_ID "
                            + "and sales_order_item.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                            + "and sales_order_item.STOCK_ITEM_UNIT_ID = stock_item_unit.STOCK_UNIT_ITEM_ID "
                            + "and stock_item.STOCK_ITEM_ID = stock_item_unit.STOCK_ITEM_ID "
                            + "and stock_item.MANUFACTURER_ID = manufacturer.MANUFACTURER_ID");

            for (AbstractEntity entity : entityList) {
                Manufacturer soldEntity = (Manufacturer) entity;

                soldItems.add(soldEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return listOfVendors;
        return soldItems;
    }

    @Override
    public List<Manufacturer> getManufacturerUsingParamList(Set<Integer> ids) {
        List<Manufacturer> items = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();

            String str = "(";
            for (Integer i : ids) {
                str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length() - 1) + ")";
            String query = "select manufacturer.* from manufacturer where manufacturer.MANUFACTURER_ID IN " + str;
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                Manufacturer paramEntity = (Manufacturer) entity;

                items.add(paramEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return items;
    }

    @Override
    public Manufacturer getManufacturerById(Integer id) {
        Manufacturer brand = new Manufacturer();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select manufacturer.* from manufacturer where manufacturer.MANUFACTURER_ID = '" + id + "' ");

            brand = (Manufacturer) entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return brand;
    }

    @Override
    public List<Manufacturer> findAllBrands() {
        List<Manufacturer> allBrands = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select manufacturer.* from manufacturer");

            for (AbstractEntity entity : entityList) {
                Manufacturer warehouseEntity = (Manufacturer) entity;

                allBrands.add(warehouseEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return allBrands;
    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }
}
