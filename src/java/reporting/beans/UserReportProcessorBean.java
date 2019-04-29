/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.joda.time.Interval;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import reporting.domain.PosTransactionRecords;
import reporting.services.UserReportServiceProcessor;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "userReportProcessorBean")
public class UserReportProcessorBean implements Serializable, UserReportServiceProcessor {

    @ManagedProperty(value = "#{reportProcessorBean}")
    private ReportProcessorBean reService;
    
     FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    /**
     * Creates a new instance of UserReportProcessorBean
     */
    public UserReportProcessorBean() {
        reService = new ReportProcessorBean();
    }

    @Override
    public Integer getBasketSize(Interval interval, Long id) {
        List<PosCartTable> cartTables = new ArrayList<>();
        try {
            cartTables = reService.getPosCartTablesByUser(interval, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserReportProcessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartTables.stream().filter(Objects::nonNull).mapToInt(PosCartTable::getCartSize).sum();
    }

    @Override
    public Double getBasketValue(Interval interval, Long id) {
        List<PosCartTable> cartTables = new ArrayList<>();
        try {
            cartTables = reService.getPosCartTablesByUser(interval, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserReportProcessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartTables.stream().mapToDouble(PosCartTable::getCartValue).sum();
    }

    @Override
    public Double getBasketCost(Interval interval, Long id) {
        List<PosCartTable> cartTables = new ArrayList<>();
        try {
            cartTables = reService.getPosCartTablesByUser(interval, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserReportProcessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartTables.stream().mapToDouble(PosCartTable::getCartCost).sum();
    }

    @Override
    public Double getRevenue(Interval interval, Long id) throws ParseException{
        List<PosTransactionRecords> transactionRecordses = reService.getTransactionsByUser1(interval, id);
        return transactionRecordses.stream().mapToDouble(PosTransactionRecords::getTransactionTotal).sum();
    }

    @Override
    public Double getCostOfGoods(Interval interval, Long id) {
        List<PosCartTable> cartTables = new ArrayList<>();
        try {
            cartTables = reService.getPosCartTablesByUser(interval, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserReportProcessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartTables.stream().mapToDouble(PosCartTable::getCartCost).sum();
    }

    @Override
    public Double getDiscount(Interval interval, Long id) throws ParseException{
        List<PosTransactionRecords> transactionRecords = reService.getTransactionsByUser1(interval, id);
        return transactionRecords.stream().mapToDouble(PosTransactionRecords::getTransactionDiscount).sum();
    }

    @Override
    public Integer getItemsSold(Interval interval, Long id) {
        int itemSold = 0;
        try {
            List<PosCartTable> transactionRecordses = reService.getTransactionsByUser(interval, id);
            //return transactionRecordses.stream().map(PosTransactionRecords::getCartId).mapToInt(PosCartTable::getCartSize).sum();
           
            for (PosCartTable ptr : transactionRecordses) {
                itemSold += ptr.getCartSize();
            }
        }catch (Exception ex) {
            ex.printStackTrace();

        }
        return itemSold;
    }

    @Override
    public Double getMargin(Interval interval, Long id) throws ParseException{
        Double revenue = getRevenue(interval, id);
        Double costOfGoods = getCostOfGoods(interval, id);
        return ((revenue - costOfGoods) / costOfGoods) * 100;
    }

    @Override
    public Double getGrossProfit(Interval interval, Long id) throws ParseException{
        Double revenue = getRevenue(interval, id);
        Double costOfGoods = getCostOfGoods(interval, id);
        return ((revenue - costOfGoods));
    }

    @Override
    public Long getCustomers(Interval interval, Long id) throws ParseException{
        List<PosTransactionRecords> transactionRecords = reService.getTransactionsByUser1(interval, id);
        return transactionRecords.stream().map(PosTransactionRecords::getTransactionCustomer).distinct().count();
    }

    @Override
    public Long getRefund(Interval interval, Long id) throws ParseException{
        List<PosTransactionRecords> transactionRecords = reService.getTransactionsByUser1(interval, id);
        return transactionRecords.stream().map(PosTransactionRecords::getRefundentityID).filter(Objects::nonNull).count();
    }

    @Override
    public Long getTransactionCount(Interval interval, Long id) throws ParseException{
        List<PosTransactionRecords> transactionRecords = reService.getTransactionsByUser1(interval, id);
        return transactionRecords.stream().count();
    }

    @Override
    public List<PosCartTable> getPosCartTables(Interval interval, Long id) {
        List<PosCartTable> lsPosCart = new ArrayList<>();
        try {           
           lsPosCart =  reService.getPosCartTablesByUser(interval, id);
        } catch (ParseException ex) {
            Logger.getLogger(UserReportProcessorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsPosCart;
    }

    @Override
    public List<PosCartItem> getPosCartItems(Interval interval, Long id) {
        return reService.getPosCartItemsByUser(interval, id);
    }

    @Override
    public List<PosItemRecord> getProducts(Interval interval, Long id) {
        return reService.getProductsByUser(interval, id);
    }

    @Override
    public List<PosItemRecord> getDistinctProducts(Interval interval, Long id) {
        return reService.getDistinctProductsByUser(interval, id);
    }

    /**
     * @return the reService
     */
    public ReportProcessorBean getReService() {
        return reService;
    }

    /**
     * @param reService the reService to set
     */
    public void setReService(ReportProcessorBean reService) {
        this.reService = reService;
    }

}
