package reporting.services;

import java.text.ParseException;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import org.joda.time.Interval;

import java.util.List;

/**
 * Created by israel on 5/21/17.
 */
public interface OutletProcessorService {

    Integer getBasketSize(Interval interval, String id) throws ParseException;

    Double getBasketValue(Interval interval, String id) throws ParseException;

    Double getBasketCost(Interval interval, String id) throws ParseException;

    Double getRevenue(Interval interval, String id) throws ParseException;

    Double getCostOfGoods(Interval interval, String id) throws ParseException;

    Double getDiscount(Interval interval, String id) throws ParseException;

    Integer getItemsSold(Interval interval, String id) throws ParseException;

    Double getMargin(Interval interval, String id) throws ParseException;

    Double getGrossProfit(Interval interval, String id) throws ParseException;

    Long getCustomers(Interval interval, String id) throws ParseException;

    Long getRefund(Interval interval, String id) throws ParseException;

    Long getTransactionCount(Interval interval, String id) throws ParseException;

    List<PosCartTable> getPosCartTables(Interval interval, String id) throws ParseException;

    List<PosCartItem> getPosCartItems(Interval interval, String id) throws ParseException;

    List<PosItemRecord> getProducts(Interval interval, String id) throws ParseException;

    List<PosItemRecord> getDistinctProducts(Interval interval, String id) throws ParseException;

}
