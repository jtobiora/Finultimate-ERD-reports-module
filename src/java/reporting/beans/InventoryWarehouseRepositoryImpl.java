package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import reporting.domain.ItemWarehouse;
import reporting.domain.pref.ItemWarehouse_PF;
import reporting.repository.InventoryWarehouseRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryWarehouseRepositoryImpl")
public class InventoryWarehouseRepositoryImpl implements Serializable, InventoryWarehouseRepository {

    private DateConvert dateConvert;

    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    public InventoryWarehouseRepositoryImpl() {
        dateConvert = new DateConvert();
    }

    @Override
    public List<ItemWarehouse> findAllWarehouses() {
        List<ItemWarehouse> warehouses = new ArrayList<>();
        try {
            ItemWarehouse criteria = new ItemWarehouse();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select item_warehouse.* from item_warehouse");

            for (AbstractEntity entity : entityList) {
                ItemWarehouse warehouseEntity = (ItemWarehouse) entity;

                warehouses.add(warehouseEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return warehouses;
    }

    @Override
    public List<ItemWarehouse> getWarehousesUsingParamList(Set<Integer> ids) {
        List<ItemWarehouse> warehouses = new ArrayList<>();
        try {
            ItemWarehouse criteria = new ItemWarehouse();

            String str = "(";
            for (Integer i : ids) {
                str += "'" + i.toString() + "',";
            }
            str = str.substring(0, str.length() - 1) + ")";
            String query = "select item_warehouse.* from item_warehouse where item_warehouse.WAREHOUSE_ID IN " + str;
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, query);

            for (AbstractEntity entity : entityList) {
                ItemWarehouse paramEntity = (ItemWarehouse) entity;

                warehouses.add(paramEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return warehouses;
    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }

}
