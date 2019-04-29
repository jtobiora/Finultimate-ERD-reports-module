package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import reporting.domain.StockTransferReq;
import reporting.repository.InventoryStockTransferReqRepository;
import reporting.util.DateConvert;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryStockTransferReqRepositoryImpl")
public class InventoryStockTransferReqRepositoryImpl implements Serializable, InventoryStockTransferReqRepository {

    private DateConvert dateConvert;
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    public InventoryStockTransferReqRepositoryImpl() {
        dateConvert = new DateConvert();
    }

    @Override
    public List<StockTransferReq> getStockTransfers(Date startDate, Date endDate, Integer status) {
        List<StockTransferReq> transferList = new ArrayList<>();
        try {
            StockTransferReq criteria = new StockTransferReq();
            List<AbstractEntity> entityList
                    = dataServer.findData(criteria, "select stock_transfr_req.* from stock_transfr_req "
                            + "WHERE stock_transfr_req.EFFECTIVE_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                            + "and stock_transfr_req.EFFECTIVE_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                            + "and stock_transfr_req.TRANSFR_STATUS = '" + status + "' "
                            + "order by stock_transfr_req.STOCK_ITEM_ID");

            for (AbstractEntity entity : entityList) {
                StockTransferReq entityMovt = (StockTransferReq) entity;

                transferList.add(entityMovt);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return transferList;
    }

    public DateConvert getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(DateConvert dateConvert) {
        this.dateConvert = dateConvert;
    }

}
