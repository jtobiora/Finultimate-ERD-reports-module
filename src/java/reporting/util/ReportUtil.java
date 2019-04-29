package reporting.util;

import com.rsdynamics.projects.eao.FinultimatePersistenceRemote;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.projects.binding.FinanceServiceLocator;
import reporting.domain.PosCartItem;
import reporting.domain.PosCartTable;
import reporting.domain.PosItemRecord;
import reporting.domain.PosTransactionRecords;
import reporting.report.SalesReport;
import reporting.wrapper.GranularReport;
import reporting.wrapper.ReportItem;
import reporting.wrapper.Summary;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import reporting.domain.PosCustomerRecords;

/**
 * Created by israel on 5/12/17.
 */
public class ReportUtil {

    private static FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();

    public static List<Double> getSummaryDouble(List<GranularReport> reports, String property) {
        return reports.stream().map(dr -> dr.getReportItems()).flatMap(List::stream).filter(r -> r.getTitle().equalsIgnoreCase(property)).filter(r -> r.getValue() != null).map(ReportItem::getValue).map(v -> v instanceof Double ? (Double) v : (Integer) v).collect(Collectors.toList());
    }

    public static Number getTotalSummaryDouble(List<GranularReport> reports, String property) {
        return reports.stream().map(dr -> dr.getReportItems()).flatMap(List::stream).filter(r -> r.getTitle().equalsIgnoreCase(property)).filter(r -> r.getValue() != null).map(ReportItem::getValue).map(v -> v).reduce(0, (a, b) -> {
            if (b instanceof Double) {
                return (Double) a + (Double) b;
            } else if (b instanceof Integer) {
                return (Integer) a + (Integer) b;
            } else {
                return (Integer) a + (Integer) b;
            }
        });
    }

    public static List<Integer> getSummaryInteger(List<GranularReport> reports, String property) {
        return reports.stream().map(dr -> dr.getReportItems()).flatMap(List::stream).filter(r -> r.getTitle().equalsIgnoreCase(property)).filter(r -> r.getValue() != null).map(ReportItem::getValue).map(v -> (Integer) v).collect(Collectors.toList());
    }

    public static Integer getTotalSummaryInteger(List<GranularReport> reports, String property) {
        return reports.stream().map(dr -> dr.getReportItems()).flatMap(List::stream).filter(r -> r.getTitle().equalsIgnoreCase(property)).filter(r -> r.getValue() != null).map(ReportItem::getValue).map(v -> (Integer) v).mapToInt(x -> x).sum();
    }

    public static List<String> getListOfMeasures(List<GranularReport> reports) {
        return reports.stream().map(gr -> gr.getReportItems()).flatMap(List::stream).filter(distinctByKey(p -> p.getTitle())).map(ReportItem::getTitle).collect(Collectors.toList());
    }

    public static List<Summary> generateSummary(List<GranularReport> reports) {
        List<String> measures = getListOfMeasures(reports);
        List<Summary> summaries = new ArrayList<>();
        for (String measure : measures) {
            Summary summary = new Summary();
            summary.setName(measure);

            if (measure.equalsIgnoreCase("Margin")) {
                summary.setValue(calculateMargin(reports));
            } else {
                summary.setValue(getTotalSummaryDouble(reports, measure));
            }
            summaries.add(summary);
        }
        return summaries;
    }

    public static double calculateMargin(List<GranularReport> reports) {
        double revenue = (Double) getTotalSummaryDouble(reports, "Revenue");
        System.out.println(revenue);
        double cost_of_goods = (Double) getTotalSummaryDouble(reports, "Cost of Goods");
        System.out.println(cost_of_goods);
        return ((revenue - cost_of_goods) / revenue) * 100;
    }

    public static List<PosItemRecord> getUniqueItems(List<PosTransactionRecords> transactions) {
        /* return transactions.stream()
                .map(PosTransactionRecords::getCartID)
                .map(PosCartTable::getPosCartItemCollection)
                .flatMap(x->x.stream())
                .map(PosCartItem::getItemId)
                .filter(distinctByKey(p->p.getId()))
                //.distinct()
                .collect(Collectors.toList());*/
        List<PosItemRecord> posItemRecordList = new ArrayList<>();
        try {
            for (PosTransactionRecords PosTransRec : transactions) {
                PosCartItem criteria = new PosCartItem();
                criteria.setCartId(PosTransRec.getCartID());

                List<AbstractEntity> entityList = dataServer.findData(criteria);

                for (AbstractEntity entity : entityList) {
                    PosCartItem posCartItemEntity = (PosCartItem) entity;

                    PosItemRecord criteria1 = new PosItemRecord();
                    criteria1.setPosItemRecordID(posCartItemEntity.getItemId());

                    List<AbstractEntity> entityList1 = dataServer.findData(criteria);
                    for (AbstractEntity entity1 : entityList1) {
                        if (!(posItemRecordList.contains((PosItemRecord) entity1))) {
                            posItemRecordList.add((PosItemRecord) entity1);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return posItemRecordList;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        final Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static String getDateTile(String frequency, Interval interval) {
        if (frequency.equalsIgnoreCase("Hour")) {
            return interval.getStart().hourOfDay().getName();
        } else if (frequency.equalsIgnoreCase("Day")) {
            return interval.getStart().dayOfMonth().getName();
        } else if (frequency.equalsIgnoreCase("Week")) {
            return interval.getStart().weekOfWeekyear().getName();
        } else if (frequency.equalsIgnoreCase("Month")) {
            interval.getStart().monthOfYear().getName();
        } else if (frequency.equalsIgnoreCase("Year")) {
            return interval.getStart().year().getName();
        }
        return "";
    }

    /**
     * @return the dataServer
     */
    public FinultimatePersistenceRemote getDataServer() {
        return dataServer;
    }

    /**
     * @param dataServer the dataServer to set
     */
    public void setDataServer(FinultimatePersistenceRemote dataServer) {
        this.dataServer = dataServer;
    }
}
