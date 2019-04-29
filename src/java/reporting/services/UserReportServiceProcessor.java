package reporting.services;

import java.text.ParseException;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import reporting.domain.PosTransactionRecords;
import org.joda.time.Interval;

import java.util.List;

/**
 * Created by israel on 5/17/17.
 */
public interface UserReportServiceProcessor {

    Integer getBasketSize(Interval interval, Long id);

    Double getBasketValue(Interval interval, Long id);

    Double getBasketCost(Interval interval, Long id);

    Double getRevenue(Interval interval, Long id) throws ParseException;

    Double getCostOfGoods(Interval interval, Long id);

    Double getDiscount(Interval interval, Long id) throws ParseException;

    Integer getItemsSold(Interval interval, Long id) throws ParseException;

    Double getMargin(Interval interval, Long id) throws ParseException;

    Double getGrossProfit(Interval interval, Long id) throws ParseException;

    Long getCustomers(Interval interval, Long id) throws ParseException;

    Long getRefund(Interval interval, Long id) throws ParseException;

    Long getTransactionCount(Interval interval, Long id) throws ParseException;

    List<PosCartTable> getPosCartTables(Interval interval, Long id);

    List<PosCartItem> getPosCartItems(Interval interval, Long id);

    List<PosItemRecord> getProducts(Interval interval, Long id);

    List<PosItemRecord> getDistinctProducts(Interval interval, Long id);
}
