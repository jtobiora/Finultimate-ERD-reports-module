package reporting.services;

import java.text.ParseException;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import reporting.domain.PosTransactionRecords;
import org.joda.time.Interval;

import java.util.List;

/**
 * Created by israel on 5/12/17.
 */
public interface ReportProcessorService {

    Double round(Double number);

    Integer getBasketSize(Interval interval) throws ParseException;

    Double getBasketValue(Interval interval) throws ParseException;

    Double getBasketCost(Interval interval) throws ParseException;

    Double getRevenue(Interval interval) throws ParseException;

    Double getCostOfGoods(Interval interval) throws ParseException;

    Double getDiscount(Interval interval) throws ParseException;

    Integer getItemsSold(Interval interval) throws ParseException;

    Double getMargin(Interval interval) throws ParseException;

    Double getGrossProfit(Interval interval) throws ParseException;

    Long getCustomers(Interval interval) throws ParseException;

    Long getRefund(Interval interval) throws ParseException;

    Long getTransactionCount(Interval interval) throws ParseException;

    List<PosCartTable> getPosCartTables(Interval interval) throws ParseException;

    List<PosCartTable> getPosCartTablesByUser(Interval interval, Long userId) throws ParseException;

    List<PosCartTable> getPosCartTablesByCustomer(Interval interval, String clientId) throws ParseException;

    List<PosCartTable> getPosCartTablesByOutlet(Interval interval, String outletName) throws ParseException;

    List<PosCartItem> getPosCartItems(Interval interval) throws ParseException;

    List<PosCartItem> getPosCartItemsByUser(Interval interval, Long userId) throws ParseException;

    List<PosCartItem> getPosCartItemsByCustomer(Interval interval, String userId) throws ParseException;

    List<PosCartItem> getPosCartItemsByOutlet(Interval interval, String outletName) throws ParseException;

    List<PosItemRecord> getProducts(Interval interval) throws ParseException;

    List<PosItemRecord> getProductsByUser(Interval interval, Long userId) throws ParseException;

    List<PosItemRecord> getProductsByCustomer(Interval interval, String clientId) throws ParseException;

    List<PosItemRecord> getProductsByOutlet(Interval interval, String outletName) throws ParseException;

    List<PosItemRecord> getDistinctProducts(Interval interval) throws ParseException;

    List<PosItemRecord> getDistinctProductsByCustomer(Interval interval, String client) throws ParseException;

    List<PosItemRecord> getDistinctProductsByUser(Interval interval, Long userId) throws ParseException;

    List<PosItemRecord> getDistinctProductsByOutlet(Interval interval, String outletName) throws ParseException;

    List<PosCartTable> getTransactions(Interval interval) throws ParseException;

    List<PosCartTable> getTransactionsByUser(Interval interval, Long userId) throws ParseException;

    List<PosCartTable> getTransactionsByCustomer(Interval interval, String userId) throws ParseException;

    List<PosTransactionRecords> getTransactionsByOutlet(Interval interval, String outletName) throws ParseException;


}
