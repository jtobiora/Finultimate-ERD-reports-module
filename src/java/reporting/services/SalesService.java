package reporting.services;
import java.text.ParseException;
import reporting.wrapper.*;


import java.util.*;

/**
 * Created by israel on 5/2/17.
 */
public interface SalesService {

    ReportResponse generateSalesSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    ReportResponse generateProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<UserReport> generateSalesSummaryByUsers(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<UserProductReport> generateUserProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<CustomerReport> generateSalesSummaryByCustomer(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<CustomerProductReport> generateCustomerProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<OutletReport> generateSalesSummaryByOutlet(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<OutletProductReport> generateOutletProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException;

    List<UserReport> generateProductSummaryByUsers(String reportType, String measure, ReportGranularity reportGranularity);

}
