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
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.joda.time.Interval;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import reporting.domain.PosTransactionRecords;
import reporting.repository.TransactionRepository;
import reporting.services.ReportProcessorService;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "reportProcessorBean")
public class ReportProcessorBean implements Serializable, ReportProcessorService {

    private PosCartItem posCartItem;
    private List<PosCartItem> posCartItemList;
    private List<PosItemRecord> posItemRecordList;
    private PosCartTable posCartTable;
    private List<PosCartTable> posCartTableList;

    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    @ManagedProperty(value = "#{transactionBean}")
    private TransactionBean transactionRepository;

    @ManagedProperty(value = "#{cartItemBean}")
    private CartItemBean cartItemRepository;

    /**
     * Creates a new instance of ReportProcessorBean
     */
    public ReportProcessorBean() {
        posCartItem = new PosCartItem();
        posCartItemList = new ArrayList<PosCartItem>();
        posItemRecordList = new ArrayList<>();

        posCartTable = new PosCartTable();
        posCartTableList = new ArrayList<PosCartTable>();

        transactionRepository = new TransactionBean();
        cartItemRepository = new CartItemBean();
    }

    @Override
    public Double round(Double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    @Override
    public Integer getBasketSize(Interval interval) throws ParseException {
        List<PosCartTable> cartTables = getPosCartTables(interval);
        return cartTables.stream().filter(Objects::nonNull).mapToInt(PosCartTable::getCartSize).sum();
    }

    @Override
    public Double getBasketValue(Interval interval) throws ParseException {
        List<PosCartTable> cartTables = getPosCartTables(interval);
        return cartTables.stream().mapToDouble(PosCartTable::getCartValue).sum();
    }

    @Override
    public Double getBasketCost(Interval interval) throws ParseException {
        List<PosCartTable> cartTables = getPosCartTables(interval);
        return cartTables.stream().mapToDouble(PosCartTable::getCartCost).sum();
    }

    @Override
    public Double getRevenue(Interval interval) throws ParseException {
        List<PosTransactionRecords> transactionRecordses = this.getTransactions1(interval);
        return transactionRecordses.stream().mapToDouble(PosTransactionRecords::getTransactionTotal).sum();
    }

    @Override
    public Double getCostOfGoods(Interval interval) throws ParseException {
        List<PosCartTable> cartTables = getPosCartTables(interval);
        return cartTables.stream().mapToDouble(PosCartTable::getCartCost).sum();
    }

    @Override
    public Double getDiscount(Interval interval) throws ParseException {
        List<PosTransactionRecords> transactionRecords = this.getTransactions1(interval);
        return transactionRecords.stream().mapToDouble(PosTransactionRecords::getTransactionDiscount).sum();
    }

    @Override
    public Integer getItemsSold(Interval interval) {
        int itemSold = 0;
        try {
            List<PosCartTable> cartTables = this.getTransactions(interval);
            //return transactionRecordses.stream().map(PosTransactionRecords::getCartID).mapToInt(PosCartTable::getCartSize).sum();

            for (PosCartTable ptr : cartTables) {
                itemSold += ptr.getCartSize();
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return itemSold;
    }

    @Override
    public Double getMargin(Interval interval) throws ParseException {
        Double revenue = getRevenue(interval);
        Double costOfGoods = getCostOfGoods(interval);
        return ((revenue - costOfGoods) / costOfGoods) * 100;
    }

    @Override
    public Double getGrossProfit(Interval interval) throws ParseException {
        Double revenue = getRevenue(interval);
        Double costOfGoods = getCostOfGoods(interval);
        return ((revenue - costOfGoods));
    }

    @Override
    public Long getCustomers(Interval interval) throws ParseException {
        List<PosTransactionRecords> transactionRecords = this.getTransactions1(interval);
        return transactionRecords.stream().map(PosTransactionRecords::getTransactionCustomer).distinct().count();
    }

    @Override
    public Long getRefund(Interval interval) throws ParseException {
        List<PosTransactionRecords> transactionRecords = this.getTransactions1(interval);
        return transactionRecords.stream().map(PosTransactionRecords::getRefundentityID).filter(Objects::nonNull).count();
    }

    @Override
    public Long getTransactionCount(Interval interval) throws ParseException {
        List<PosTransactionRecords> transactionRecords = this.getTransactions1(interval);
        return transactionRecords.stream().count();
    }

    @Override
    public List<PosCartTable> getPosCartTables(Interval interval) throws ParseException {
//        List<PosCartTable> retPosCartTableList = new ArrayList<>();
//        try {
//            List<PosTransactionRecords> transactions = getTransactions(interval);
//            //return transactions.stream().map(PosTransactionRecords::getCartID).collect(Collectors.toList())
//            for (PosTransactionRecords posTransRec : transactions) {
//                PosCartTable criteria = new PosCartTable();
//                
//                if (posTransRec.getCartID() > 0) {
//                    criteria.setPosCartID(posTransRec.getCartID());
//                    List<AbstractEntity> entityList = dataServer.findData(criteria);
//                   
//                    retPosCartTableList.add((PosCartTable) entityList.get(0));
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        
//        return retPosCartTableList;
        return this.getTransactions(interval);
    }

    @Override
    public List<PosCartTable> getPosCartTablesByUser(Interval interval, Long userId) throws ParseException {
//        List<PosCartTable> retPosCartTableList = new ArrayList<>();
//        try {
//            List<PosTransactionRecords> transactions = getTransactionsByUser(interval, userId);
//            // return transactions.stream().map(PosTransactionRecords::getCartID).collect(Collectors.toList());
//            PosCartTable criteria = new PosCartTable();
//            for (PosTransactionRecords PosTransRec : transactions) {
//                criteria.setPosCartID(PosTransRec.getCartID());
//                List<AbstractEntity> entityList = dataServer.findData(criteria);
//                retPosCartTableList.add((PosCartTable) entityList.get(0));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return retPosCartTableList;
        return this.getTransactionsByUser(interval, userId);
    }

    @Override
    public List<PosCartTable> getPosCartTablesByCustomer(Interval interval, String clientId) throws ParseException {
//        List<PosCartTable> retPosCartTableList = new ArrayList<>();
//        try {
//            List<PosTransactionRecords> transactions = getTransactionsByCustomer(interval, clientId);
//            //return transactions.stream().map(PosTransactionRecords::getCartID).collect(Collectors.toList());
//            PosCartTable criteria = new PosCartTable();
//            for (PosTransactionRecords PosTransRec : transactions) {
//                criteria.setPosCartID(PosTransRec.getCartID());
//                List<AbstractEntity> entityList = dataServer.findData(criteria);
//                retPosCartTableList.add((PosCartTable) entityList.get(0));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return retPosCartTableList;
        return this.getTransactionsByCustomer(interval, clientId);
    }

    @Override
    public List<PosCartTable> getPosCartTablesByOutlet(Interval interval, String outletName) {
        List<PosCartTable> retPosCartTableList = new ArrayList<>();

        try {
            List<PosTransactionRecords> transactions = getTransactionsByOutlet(interval, outletName);
            //return transactions.stream().map(PosTransactionRecords::getCartID).collect(Collectors.toList());
            PosCartTable criteria = new PosCartTable();

            for (PosTransactionRecords PosTransRec : transactions) {
                criteria.setPosCartID(PosTransRec.getCartID());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                retPosCartTableList.add((PosCartTable) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return retPosCartTableList;
    }

    @Override
    public List<PosCartItem> getPosCartItems(Interval interval) throws ParseException {
        return cartItemRepository.getCartItemEntitiesBetweenDates(interval.getStart().toDate(), interval.getEnd().toDate());
    }

    @Override
    public List<PosCartItem> getPosCartItemsByUser(Interval interval, Long userId) {
        //return cartItemRepository.getCartItemEntitiesBetweenDatesByUser(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
        try {
            List<PosItemRecord> cartI = cartItemRepository.getCartItemEntitiesBetweenDatesByUser(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
            PosCartItem criteria = new PosCartItem();

            for (PosItemRecord posI : cartI) {
                criteria.setItemId(posI.getPosItemRecordID());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                posCartItemList.add((PosCartItem) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posCartItemList;
    }

    @Override
    public List<PosCartItem> getPosCartItemsByCustomer(Interval interval, String userId) throws ParseException {
        return cartItemRepository.getCartItemEntitiesBetweenDatesByCustomer(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
    }

    @Override
    public List<PosCartItem> getPosCartItemsByOutlet(Interval interval, String outletName) throws ParseException {
        return cartItemRepository.getCartItemEntitiesBetweenDatesByOutlet(interval.getStart().toDate(), interval.getEnd().toDate(), outletName);
    }

    @Override
    public List<PosItemRecord> getProducts(Interval interval) {
        try {
            List<PosCartItem> cartItems = getPosCartItems(interval);
            // return cartItems.parallelStream().map(PosCartItem::getItemId).collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                posItemRecordList.add((PosItemRecord) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getProductsByUser(Interval interval, Long userId) {
        try {
            List<PosCartItem> cartItems = getPosCartItemsByUser(interval, userId);
            //return cartItems.parallelStream().map(PosCartItem::getItemId).collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                posItemRecordList.add((PosItemRecord) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getProductsByCustomer(Interval interval, String clientId) {
        try {
            List<PosCartItem> cartItems = getPosCartItemsByCustomer(interval, clientId);
            // return cartItems.parallelStream().map(PosCartItem::getItemId).collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                posItemRecordList.add((PosItemRecord) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getProductsByOutlet(Interval interval, String outletName) {
        try {
            List<PosCartItem> cartItems = getPosCartItemsByOutlet(interval, outletName);
            //return cartItems.parallelStream().map(PosCartItem::getItemId).collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);
                posItemRecordList.add((PosItemRecord) entityList.get(0));
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getDistinctProducts(Interval interval) {
        try {
            List<PosCartItem> cartItems = getPosCartItems(interval);
            // return cartItems.parallelStream().map(PosCartItem::getItemId).distinct().collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);

                //Check if the object is in the list
                if (!(posItemRecordList.contains((PosItemRecord) entityList.get(0)))) {
                    posItemRecordList.add((PosItemRecord) entityList.get(0));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getDistinctProductsByCustomer(Interval interval, String client) {
        try {
            List<PosCartItem> cartItems = getPosCartItemsByCustomer(interval, client);
            // return cartItems.parallelStream().map(PosCartItem::getItemId).distinct().collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);

                //Check if the object is in the list
                if (!(posItemRecordList.contains((PosItemRecord) entityList.get(0)))) {
                    posItemRecordList.add((PosItemRecord) entityList.get(0));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

//    @Override
//    public List<PosItemRecord> getDistinctProductsByUser(Interval interval, Long userId) {
//        List<PosCartItem> cartItems = getPosCartItemsByUser(interval, userId);
//        return cartItems.parallelStream().map(PosCartItem::getItemId).distinct().collect(Collectors.toList());
//    }
    @Override
    public List<PosItemRecord> getDistinctProductsByUser(Interval interval, Long userId) {
        List<PosItemRecord> posItemRecordList = new ArrayList<PosItemRecord>();

        List<PosCartItem> cartItems = getPosCartItemsByUser(interval, userId);

        try {

            // return cartItems.parallelStream().map(PosCartItem::getItemId).distinct().collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);

                //Check if the object is in the list
                if (!(posItemRecordList.contains((PosItemRecord) entityList.get(0)))) {
                    posItemRecordList.add((PosItemRecord) entityList.get(0));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosItemRecord> getDistinctProductsByOutlet(Interval interval, String outletName) throws ParseException {
        List<PosItemRecord> posItemRecordList = new ArrayList<PosItemRecord>();

        List<PosCartItem> cartItems = getPosCartItemsByOutlet(interval, outletName);

        //return cartItems.parallelStream().map(PosCartItem::getItemID).distinct().collect(Collectors.toList());
        try {

            // return cartItems.parallelStream().map(PosCartItem::getItemId).distinct().collect(Collectors.toList());
            PosItemRecord criteria = new PosItemRecord();
            for (PosCartItem cartI : cartItems) {
                criteria.setPosItemRecordID(cartI.getItemId());
                List<AbstractEntity> entityList = dataServer.findData(criteria);

                //Check if the object is in the list
                if (!(posItemRecordList.contains((PosItemRecord) entityList.get(0)))) {
                    posItemRecordList.add((PosItemRecord) entityList.get(0));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    @Override
    public List<PosCartTable> getTransactions(Interval interval) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDates(interval.getStart().toDate(), interval.getEnd().toDate());
    }

    public List<PosTransactionRecords> getTransactions1(Interval interval) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDates1(interval.getStart().toDate(), interval.getEnd().toDate());
    }

    @Override
    public List<PosCartTable> getTransactionsByUser(Interval interval, Long userId) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDatesByUser(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
    }

    public List<PosTransactionRecords> getTransactionsByUser1(Interval interval, Long userId) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDatesByUser1(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
    }

    @Override
    public List<PosCartTable> getTransactionsByCustomer(Interval interval, String userId) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDatesByCustomer(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
    }
    
    public List<PosTransactionRecords> getTransactionsByCustomer1(Interval interval, String userId) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDatesByCustomer1(interval.getStart().toDate(), interval.getEnd().toDate(), userId);
    }

    @Override
    public List<PosTransactionRecords> getTransactionsByOutlet(Interval interval, String outletName) throws ParseException {
        return this.transactionRepository.getTransactionsBetweenDatesByOutlet1(interval.getStart().toDate(), interval.getEnd().toDate(), outletName);
    }

    /**
     * @return the transactionRepository
     */
    public TransactionBean getTransactionRepository() {
        return transactionRepository;
    }

    /**
     * @param transactionRepository the transactionRepository to set
     */
    public void setTransactionRepository(TransactionBean transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * @return the cartItemRepository
     */
    public CartItemBean getCartItemRepository() {
        return cartItemRepository;
    }

    /**
     * @param cartItemRepository the cartItemRepository to set
     */
    public void setCartItemRepository(CartItemBean cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    /**
     * @return the posCartItem
     */
    public PosCartItem getPosCartItem() {
        return posCartItem;
    }

    /**
     * @param posCartItem the posCartItem to set
     */
    public void setPosCartItem(PosCartItem posCartItem) {
        this.posCartItem = posCartItem;
    }

    /**
     * @return the posCartItemList
     */
    public List<PosCartItem> getPosCartItemList() {
        return posCartItemList;
    }

    /**
     * @param posCartItemList the posCartItemList to set
     */
    public void setPosCartItemList(List<PosCartItem> posCartItemList) {
        this.posCartItemList = posCartItemList;
    }

    /**
     * @return the posItemRecordList
     */
    public List<PosItemRecord> getPosItemRecordList() {
        return posItemRecordList;
    }

    /**
     * @param posItemRecordList the posItemRecordList to set
     */
    public void setPosItemRecordList(List<PosItemRecord> posItemRecordList) {
        this.posItemRecordList = posItemRecordList;
    }

    /**
     * @return the posCartTableList
     */
    public List<PosCartTable> getPosCartTableList() {
        return posCartTableList;
    }

    /**
     * @param posCartTableList the posCartTableList to set
     */
    public void setPosCartTableList(List<PosCartTable> posCartTableList) {
        this.posCartTableList = posCartTableList;
    }

}
