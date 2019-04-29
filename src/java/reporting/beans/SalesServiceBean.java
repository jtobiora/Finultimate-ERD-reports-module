/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import reporting.domain.PosCustomerRecords;
import reporting.domain.PosItemRecord;
import reporting.domain.PosUsersRecords;
import reporting.services.SalesService;
import reporting.util.ReportUtil;
import reporting.wrapper.CustomerProductReport;
import reporting.wrapper.CustomerReport;
import reporting.wrapper.GranularReport;
import reporting.wrapper.OutletProductReport;
import reporting.wrapper.OutletReport;
import reporting.wrapper.ReportGranularity;
import reporting.wrapper.ReportItem;
import reporting.wrapper.ReportResponse;
import reporting.wrapper.UserProductReport;
import reporting.wrapper.UserReport;

/**
 *
 * @author S3-Developer
 */
@javax.faces.bean.SessionScoped
@ManagedBean(name = "salesServiceBean")
public class SalesServiceBean implements Serializable, SalesService {

    @ManagedProperty(value = "#{reportProcessorBean}")
    private ReportProcessorBean rpService;

    @ManagedProperty(value = "#{userReportProcessorBean}")
    private UserReportProcessorBean userReportService;

    @ManagedProperty(value = "#{customerReportProcessorBean}")
    private CustomerReportProcessorBean customerReportService;

    @ManagedProperty(value = "#{outletReportProcessorBean}")
    private OutletReportProcessorBean outletReportService;

    @ManagedProperty(value = "#{transactionBean}")
    private TransactionBean transactionRepository;

    @ManagedProperty(value = "#{itemTableBean}")
    private ItemTableBean itemRepository;

    @ManagedProperty(value = "#{posUserBean}")
    private PosUserBean userRepository;

    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerRepository;

    /**
     * Creates a new instance of SalesServiceBean
     */
    public SalesServiceBean() {
        rpService = new ReportProcessorBean();
        userReportService = new UserReportProcessorBean();
        customerReportService = new CustomerReportProcessorBean();
        outletReportService = new OutletReportProcessorBean();
        transactionRepository = new TransactionBean();
        itemRepository = new ItemTableBean();
        userRepository = new PosUserBean();
        customerRepository = new CustomerBean();

    }

    @Override
    public ReportResponse generateSalesSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<GranularReport> granularReports = new ArrayList<>();

        reportGranularity.getSliceDate().forEach(dateSlice -> {

            Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

            List<ReportItem> reportItems = new ArrayList<>();
            //Create a daily report. A daily report has a list of report item. Each report item contains a summary of
            GranularReport granularReport = new GranularReport();
            Date reportStartDate = dateSlice.getStart();
            Date reportEndDate = dateSlice.getEnd();

            granularReport.setDateTitle(dateSlice.getTitle());

            //Retrieve Measures
            //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
            if (measure.equalsIgnoreCase("basket-size")) {
                ReportItem basket_size = new ReportItem();
                basket_size.setDateTitle(dateSlice.getTitle());
                try {
                    basket_size.setValue(getRpService().getBasketSize(interval));
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                basket_size.setDate(reportStartDate);
                basket_size.setTitle("Basket Size");
                basket_size.setCurrency(false);
                basket_size.setPercentage(false);
                reportItems.add(basket_size);
            }

            if (measure.equalsIgnoreCase("basket-value")) {
                ReportItem basket_size = new ReportItem();
                basket_size.setDateTitle(dateSlice.getTitle());
                try {
                    basket_size.setValue(getRpService().getBasketValue(interval));
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                basket_size.setDate(reportStartDate);
                basket_size.setTitle("Basket Value");
                basket_size.setCurrency(true);
                basket_size.setPercentage(false);
                reportItems.add(basket_size);
            }

            if (measure.equalsIgnoreCase("items-sold")) {
                ReportItem items_sold = new ReportItem();
                items_sold.setDateTitle(dateSlice.getTitle());
                items_sold.setValue(getRpService().getItemsSold(interval));
                items_sold.setDate(reportStartDate);
                items_sold.setTitle("Items Sold");
                items_sold.setCurrency(false);
                items_sold.setPercentage(false);
                reportItems.add(items_sold);
            }

            if (measure.equalsIgnoreCase("discount")) {
                ReportItem discount = new ReportItem();
                discount.setDateTitle(dateSlice.getTitle());
                try {
                    discount.setValue(getRpService().round(Double.isNaN(getRpService().getDiscount(interval)) ? 0d : getRpService().getDiscount(interval)));
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                discount.setDate(reportStartDate);
                discount.setTitle("Discount");
                discount.setCurrency(true);
                discount.setPercentage(false);
                reportItems.add(discount);
            }

            if (measure.equalsIgnoreCase("customer-count")) {
                ReportItem cc = new ReportItem();
                cc.setDateTitle(dateSlice.getTitle());
                try {
                    cc.setValue(getRpService().getCustomers(interval).intValue());
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                cc.setDate(reportStartDate);
                cc.setCurrency(false);
                cc.setPercentage(false);
                cc.setTitle("Customer Count");
                reportItems.add(cc);
            }

            if (measure.equalsIgnoreCase("refund")) {
                ReportItem refund = new ReportItem();
                refund.setDateTitle(dateSlice.getTitle());
                try {
                    refund.setValue(getRpService().getRefund(interval).intValue());
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                refund.setDate(reportStartDate);
                refund.setCurrency(false);
                refund.setPercentage(false);
                refund.setTitle("Returns");
                reportItems.add(refund);
            }

            if (measure.equalsIgnoreCase("transaction-count")) {
                ReportItem tc = new ReportItem();
                tc.setDateTitle(dateSlice.getTitle());
                try {
                    tc.setValue(getRpService().getTransactionCount(interval));
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                //tc.setValue(ReportUtil.getUniqueItems(transactionRepository.getTransactionsBetweenDatesByProduct(interval.getStart().toDate(), interval.getEnd().toDate(), 89l)).size());
                tc.setDate(reportStartDate);
                tc.setCurrency(false);
                tc.setPercentage(false);
                tc.setTitle("Transaction Count");
                reportItems.add(tc);
            }
            
            //==========================REVENUE=====================================

            ReportItem revenue = new ReportItem();
            revenue.setDateTitle(dateSlice.getTitle());
//            revenue.setValue(0);
            try {
                revenue.setValue(getRpService().getRevenue(interval));
               // revenue.setValue(0);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            revenue.setDate(reportStartDate);
            revenue.setTitle("Revenue");
            revenue.setCurrency(true);
            revenue.setPercentage(false);
            if (measure.equalsIgnoreCase("revenue")) {
                reportItems.add(0, revenue);
            } else {
                reportItems.add(revenue);
            }
            
            //==========================COST OF GOODS=====================================

            ReportItem cog = new ReportItem();
            cog.setDateTitle(dateSlice.getTitle());
            try {
                // cog.setValue(0.00);
                cog.setValue(getRpService().round(getRpService().getCostOfGoods(interval)));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            cog.setDate(reportStartDate);
            cog.setCurrency(true);
            cog.setPercentage(false);
            cog.setTitle("Cost of Goods");

            if (measure.equalsIgnoreCase("cost-of-goods")) {
                reportItems.add(0, cog);
            } else {
                reportItems.add(cog);
            }
            
            //==========================Gross Profit=====================================

            ReportItem gp = new ReportItem();
            gp.setDateTitle(dateSlice.getTitle());
           // gp.setValue(0.00);
            try {
                gp.setValue(getRpService().round(Double.isNaN(getRpService().getGrossProfit(interval)) ? 0d : getRpService().getGrossProfit(interval)));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            gp.setDate(reportStartDate);
            gp.setTitle("Gross Profit");
            gp.setCurrency(true);
            gp.setPercentage(false);
            
            if (measure.equalsIgnoreCase("gross-profit")) {
                reportItems.add(0, gp);
            } else {
                reportItems.add(gp);
            }
            
            //==========================MARGIN=====================================

            ReportItem margin = new ReportItem();
            margin.setDateTitle(dateSlice.getTitle());
           // margin.setValue(0.00);
            try {
                margin.setValue(getRpService().round(Double.isNaN(getRpService().getMargin(interval)) ? 0d : getRpService().getMargin(interval)));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            margin.setDate(reportStartDate);
            margin.setCurrency(false);
            margin.setPercentage(true);
            margin.setTitle("Margin");
            
            if (measure.equalsIgnoreCase("margin")) {
                reportItems.add(0, margin);
            } else {
                reportItems.add(margin);
            }
            
            //==========================TAX=====================================

            ReportItem tax = new ReportItem();
            tax.setDateTitle(dateSlice.getTitle());
            tax.setValue(0d);//To be changed
            tax.setDate(reportStartDate);
            tax.setTitle("Tax");
            tax.setCurrency(true);
            tax.setPercentage(false);
            
            if (measure.equalsIgnoreCase("tax")) {
                reportItems.add(0, tax);
            } else {
                reportItems.add(tax);
            }

            granularReport.setReportItems(reportItems);
            granularReports.add(granularReport);
        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        return response;
    }

    @Override
    public ReportResponse generateProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<PosItemRecord> products = ReportUtil.getUniqueItems(rpService.getTransactions1(new Interval(new DateTime(reportGranularity.getStart()), new DateTime(reportGranularity.getEnd()))));

        List<GranularReport> granularReports = new ArrayList<>();

        reportGranularity.getSliceDate().forEach(dateSlice -> {
            Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

            List<ReportItem> reportItems = new ArrayList<>();
            //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
            GranularReport granularReport = new GranularReport();
            Date reportStartDate = dateSlice.getStart();
            Date reportEndDate = dateSlice.getEnd();
            granularReport.setDateTitle(dateSlice.getTitle());

            //Retrieve Measures
            //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
            products.stream().distinct().forEach(p -> {
                try {
                    ReportItem productReport = new ReportItem();
                    productReport.setDateTitle(dateSlice.getTitle());
                    productReport.setValue(itemRepository.getItemsBetweenDatesByProduct(interval.getStart().toDate(), interval.getEnd().toDate(), p.getPosItemRecordID()).size());
                    productReport.setDate(reportStartDate);
                    productReport.setTitle(p.getItemName());
                    productReport.setCurrency(false);
                    productReport.setPercentage(false);

                    Map<String, Object> reportData = new HashMap<>();

                    //This is the total summary for the whole duration
                    int wholeCount = itemRepository.getItemsBetweenDatesByProduct(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), p.getPosItemRecordID()).size();
                    Double revenue = p.getItemSellingPrice() * wholeCount;
                    Double cog = p.getItemCostPrice() * wholeCount;
                    Double margin = ((revenue - cog) / cog) * 100;

                    Double profit = p.getItemSellingPrice() * wholeCount - p.getItemCostPrice() * wholeCount;

                    reportData.put("Revenue", p.getItemSellingPrice() * wholeCount);
                    reportData.put("Cost of Goods", p.getItemCostPrice() * wholeCount);
                    reportData.put("Gross Profit", profit);
                    reportData.put("Margin", margin);
                    reportData.put("Tax", 0d);

                    productReport.setData(reportData);
                    reportItems.add(productReport);
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            granularReport.setReportItems(reportItems);
            granularReports.add(granularReport);
        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        return response;
    }

    @Override
    public List<UserReport> generateSalesSummaryByUsers(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<UserReport> userReports = new ArrayList<>();
        List<PosUsersRecords> users = userRepository.findAll();
        users.stream().forEach(user -> {
            try {
                userReports.add(this.generateUserSalesReport(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), reportType, measure, reportGranularity, user.getUserID()));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return userReports;
    }

    @Override
    public List<UserProductReport> generateUserProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<UserProductReport> userReports = new ArrayList<>();

        List<PosUsersRecords> users = userRepository.findAll();

        users.stream().forEach(user -> {

            try {
                List<GranularReport> granularReports = new ArrayList<>();
                List<PosItemRecord> products;

                products = ReportUtil.getUniqueItems(rpService.getTransactionsByUser1(new Interval(new DateTime(reportGranularity.getStart()), new DateTime(reportGranularity.getEnd())), user.getUserID()));

                reportGranularity.getSliceDate().forEach(dateSlice -> {
                    Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                    List<ReportItem> reportItems = new ArrayList<>();
                    //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                    GranularReport granularReport = new GranularReport();
                    Date reportStartDate = dateSlice.getStart();
                    Date reportEndDate = dateSlice.getEnd();
                    granularReport.setDateTitle(dateSlice.getTitle());

                    //Retrieve Measures
                    //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                    products.stream().distinct().forEach(p -> {
                        try {
                            ReportItem productReport = new ReportItem();
                            productReport.setDateTitle(dateSlice.getTitle());
                            productReport.setValue(itemRepository.getItemsBetweenDatesByProduct(interval.getStart().toDate(), interval.getEnd().toDate(), p.getPosItemRecordID()).size());
                            productReport.setDate(reportStartDate);
                            productReport.setTitle(p.getItemName());
                            productReport.setCurrency(false);
                            productReport.setPercentage(false);

                            Map<String, Object> reportData = new HashMap<>();

                            //This is the total summary for the whole duration
                            int wholeCount = itemRepository.getItemsBetweenDatesByProduct(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), p.getPosItemRecordID()).size();
                            Double revenue = p.getItemSellingPrice() * wholeCount;
                            Double cog = p.getItemCostPrice() * wholeCount;
                            Double margin = ((revenue - cog) / cog) * 100;

                            Double profit = p.getItemSellingPrice() * wholeCount - p.getItemCostPrice() * wholeCount;

                            reportData.put("Revenue", p.getItemSellingPrice() * wholeCount);
                            reportData.put("Cost of Goods", p.getItemCostPrice() * wholeCount);
                            reportData.put("Gross Profit", profit);
                            reportData.put("Margin", margin);
                            reportData.put("Tax", 0d);

                            productReport.setData(reportData);
                            reportItems.add(productReport);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    granularReport.setReportItems(reportItems);
                    granularReports.add(granularReport);

                });

                ReportResponse response = new ReportResponse();
                response.setReports(granularReports);

                UserProductReport userProductReport = new UserProductReport();
                userProductReport.setUser(user);
                userProductReport.setReport(response);
                userReports.add(userProductReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return userReports;
    }

    @Override
    public List<CustomerReport> generateSalesSummaryByCustomer(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<CustomerReport> customerReports = new ArrayList<>();
        List<PosCustomerRecords> customers = customerRepository.findAll();
        customers.stream().forEach(customer -> {
            try {
                customerReports.add(this.generateCustomerSalesReport(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), reportType, measure, reportGranularity, customer.getClientID()));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return customerReports;
    }

    @Override
    public List<CustomerProductReport> generateCustomerProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<CustomerProductReport> customerReports = new ArrayList<>();

        List<PosCustomerRecords> customerRecordses = customerRepository.findAll();

        customerRecordses.stream().forEach(customer -> {

            try {
                List<GranularReport> granularReports = new ArrayList<>();
                List<PosItemRecord> products = ReportUtil.getUniqueItems(rpService.getTransactionsByCustomer1(new Interval(new DateTime(reportGranularity.getStart()), new DateTime(reportGranularity.getEnd())), customer.getClientID()));

                reportGranularity.getSliceDate().forEach(dateSlice -> {
                    Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                    List<ReportItem> reportItems = new ArrayList<>();
                    //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                    GranularReport granularReport = new GranularReport();
                    Date reportStartDate = dateSlice.getStart();
                    Date reportEndDate = dateSlice.getEnd();
                    granularReport.setDateTitle(dateSlice.getTitle());

                    //Retrieve Measures
                    //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                    products.stream().distinct().forEach(p -> {
                        try {
                            ReportItem productReport = new ReportItem();
                            productReport.setDateTitle(dateSlice.getTitle());
                            productReport.setValue(itemRepository.getItemsBetweenDatesByProduct(interval.getStart().toDate(), interval.getEnd().toDate(), p.getPosItemRecordID()).size());
                            productReport.setDate(reportStartDate);
                            productReport.setTitle(p.getItemName());
                            productReport.setCurrency(false);
                            productReport.setPercentage(false);

                            Map<String, Object> reportData = new HashMap<>();

                            //This is the total summary for the whole duration
                            int wholeCount = itemRepository.getItemsBetweenDatesByProduct(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), p.getPosItemRecordID()).size();
                            Double revenue = p.getItemSellingPrice() * wholeCount;
                            Double cog = p.getItemCostPrice() * wholeCount;
                            Double margin = ((revenue - cog) / cog) * 100;

                            Double profit = p.getItemSellingPrice() * wholeCount - p.getItemCostPrice() * wholeCount;

                            reportData.put("Revenue", p.getItemSellingPrice() * wholeCount);
                            reportData.put("Cost of Goods", p.getItemCostPrice() * wholeCount);
                            reportData.put("Gross Profit", profit);
                            reportData.put("Margin", margin);
                            reportData.put("Tax", 0d);

                            productReport.setData(reportData);
                            reportItems.add(productReport);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    granularReport.setReportItems(reportItems);
                    granularReports.add(granularReport);
                });

                ReportResponse response = new ReportResponse();
                response.setReports(granularReports);

                CustomerProductReport customerProductReport = new CustomerProductReport();
                customerProductReport.setCustomer(customer);
                customerProductReport.setReport(response);
                customerReports.add(customerProductReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return customerReports;
    }

    @Override
    public List<OutletReport> generateSalesSummaryByOutlet(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        Date start = new DateTime(reportGranularity.getStart()).toDate();
        Date end = new DateTime(reportGranularity.getEnd()).toDate();
        List<OutletReport> outletReports = new ArrayList<>();
        List<String> outlets = transactionRepository.getOutletsBetweenDates(start, end);
        outlets.stream().distinct().forEach(outlet -> {
            outletReports.add(this.generateOutletSalesReport(start, end, reportType, measure, reportGranularity, outlet));
        });
        return outletReports;
    }

    @Override
    public List<OutletProductReport> generateOutletProductSummary(String reportType, String measure, ReportGranularity reportGranularity) throws ParseException {
        List<OutletProductReport> outletReports = new ArrayList<>();

        Date start = new DateTime(reportGranularity.getStart()).toDate();
        Date end = new DateTime(reportGranularity.getEnd()).toDate();
        List<String> outlets = transactionRepository.getOutletsBetweenDates(start, end);

        outlets.stream().distinct().forEach(outlet -> {

            try {
                List<GranularReport> granularReports = new ArrayList<>();
                List<PosItemRecord> products = ReportUtil.getUniqueItems(rpService.getTransactionsByOutlet(new Interval(new DateTime(reportGranularity.getStart()), new DateTime(reportGranularity.getEnd())), outlet));

                reportGranularity.getSliceDate().forEach(dateSlice -> {
                    Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                    List<ReportItem> reportItems = new ArrayList<>();
                    //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                    GranularReport granularReport = new GranularReport();
                    Date reportStartDate = dateSlice.getStart();
                    Date reportEndDate = dateSlice.getEnd();
                    granularReport.setDateTitle(dateSlice.getTitle());

                    //Retrieve Measures
                    //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                    products.stream().distinct().forEach(p -> {
                        try {
                            ReportItem productReport = new ReportItem();
                            productReport.setDateTitle(dateSlice.getTitle());
                            productReport.setValue(itemRepository.getItemsBetweenDatesByProduct(interval.getStart().toDate(), interval.getEnd().toDate(), p.getPosItemRecordID()).size());
                            productReport.setDate(reportStartDate);
                            productReport.setTitle(p.getItemName());
                            productReport.setCurrency(false);
                            productReport.setPercentage(false);

                            Map<String, Object> reportData = new HashMap<>();

                            //This is the total summary for the whole duration
                            int wholeCount = itemRepository.getItemsBetweenDatesByProduct(new DateTime(reportGranularity.getStart()).toDate(), new DateTime(reportGranularity.getEnd()).toDate(), p.getPosItemRecordID()).size();
                            Double revenue = p.getItemSellingPrice() * wholeCount;
                            Double cog = p.getItemCostPrice() * wholeCount;
                            Double margin = ((revenue - cog) / cog) * 100;

                            Double profit = p.getItemSellingPrice() * wholeCount - p.getItemCostPrice() * wholeCount;

                            reportData.put("Revenue", p.getItemSellingPrice() * wholeCount);
                            reportData.put("Cost of Goods", p.getItemCostPrice() * wholeCount);
                            reportData.put("Gross Profit", profit);
                            reportData.put("Margin", margin);
                            reportData.put("Tax", 0d);

                            productReport.setData(reportData);
                            reportItems.add(productReport);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });

                    granularReport.setReportItems(reportItems);
                    granularReports.add(granularReport);
                });

                ReportResponse response = new ReportResponse();
                response.setReports(granularReports);

                OutletProductReport customerProductReport = new OutletProductReport();
                customerProductReport.setOutletName(outlet);
                customerProductReport.setReport(response);
                outletReports.add(customerProductReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return outletReports;
    }

    @Override
    public List<UserReport> generateProductSummaryByUsers(String reportType, String measure, ReportGranularity reportGranularity) {
        Date start = new DateTime(reportGranularity.getStart()).toDate();
        Date end = new DateTime(reportGranularity.getEnd()).toDate();
        List<UserReport> userReports = new ArrayList<>();
        List<PosUsersRecords> users = userRepository.findAll();
        users.stream().forEach(user -> {
            try {
                userReports.add(this.generateProductSummaryReportByUser(start, end, reportType, measure, reportGranularity, user.getUserID()));
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        return userReports;
    }

    private UserReport generateUserSalesReport(Date start, Date end, String reportType, String measure, ReportGranularity reportGranularity, Long userId)
            throws ParseException {

        //int days = new Interval(start.getTime(), end.getTime()).toDuration().toStandardDays().getDays();
        //List<Interval> intervals = DateUtil.splitDuration(new DateTime(start), new DateTime(end).plusHours(23).plusMinutes(60), days, 1000 * 60 * 60 * 24); //correct timing
        List<GranularReport> granularReports = new ArrayList<>();

        reportGranularity.getSliceDate().forEach(dateSlice -> {

            try {
                Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                List<ReportItem> reportItems = new ArrayList<>();
                //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                GranularReport granularReport = new GranularReport();
                Date reportStartDate = interval.getStart().toDate();
                Date reportEndDate = interval.getEnd().toDate();
                granularReport.setDateTitle(dateSlice.getTitle());

                //Retrieve Measures
                //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                if (measure.equalsIgnoreCase("basket-size")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(userReportService.getBasketSize(interval, userId));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Size");
                    basket_size.setCurrency(false);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("basket-value")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(userReportService.getBasketValue(interval, userId));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Value");
                    basket_size.setCurrency(true);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("items-sold")) {
                    ReportItem items_sold = new ReportItem();
                    items_sold.setDateTitle(dateSlice.getTitle());
                    items_sold.setValue(userReportService.getItemsSold(interval, userId));
                    items_sold.setDate(reportStartDate);
                    items_sold.setTitle("Items Sold");
                    items_sold.setCurrency(false);
                    items_sold.setPercentage(false);
                    reportItems.add(items_sold);
                }

                if (measure.equalsIgnoreCase("discount")) {
                    try {
                        ReportItem discount = new ReportItem();
                        discount.setDateTitle(dateSlice.getTitle());
                        discount.setValue(rpService.round(Double.isNaN(userReportService.getDiscount(interval, userId)) ? 0d : userReportService.getDiscount(interval, userId)));
                        discount.setDate(reportStartDate);
                        discount.setTitle("Discount");
                        discount.setCurrency(true);
                        discount.setPercentage(false);
                        reportItems.add(discount);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("customer-count")) {
                    try {
                        ReportItem cc = new ReportItem();
                        cc.setDateTitle(dateSlice.getTitle());
                        cc.setValue(userReportService.getCustomers(interval, userId).intValue());
                        cc.setDate(reportStartDate);
                        cc.setCurrency(false);
                        cc.setPercentage(false);
                        cc.setTitle("Customer Count");
                        reportItems.add(cc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("refund")) {
                    try {
                        ReportItem refund = new ReportItem();
                        refund.setDateTitle(dateSlice.getTitle());
                        refund.setValue(userReportService.getRefund(interval, userId).intValue());
                        refund.setDate(reportStartDate);
                        refund.setCurrency(false);
                        refund.setPercentage(false);
                        refund.setTitle("Returns");
                        reportItems.add(refund);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("transaction-count")) {
                    try {
                        ReportItem tc = new ReportItem();
                        tc.setDateTitle(dateSlice.getTitle());
                        tc.setValue(userReportService.getTransactionCount(interval, userId));
                        //tc.setValue(ReportUtil.getUniqueItems(transactionRepository.getTransactionsBetweenDatesByProductAndUser(interval.getStart().toDate(), interval.getEnd().toDate(), )).size());
                        tc.setDate(reportStartDate);
                        tc.setCurrency(false);
                        tc.setPercentage(false);
                        tc.setTitle("Transaction Count");
                        reportItems.add(tc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ReportItem revenue = new ReportItem();
                revenue.setDateTitle(dateSlice.getTitle());
                revenue.setValue(userReportService.getRevenue(interval, userId));
                revenue.setDate(reportStartDate);
                revenue.setTitle("Revenue");
                revenue.setCurrency(true);
                revenue.setPercentage(false);
                if (measure.equalsIgnoreCase("revenue")) {
                    reportItems.add(0, revenue);
                } else {
                    reportItems.add(revenue);
                }

                ReportItem cog = new ReportItem();
                cog.setDateTitle(dateSlice.getTitle());
                cog.setValue(rpService.round(userReportService.getCostOfGoods(interval, userId)));
                cog.setDate(reportStartDate);
                cog.setCurrency(true);
                cog.setPercentage(false);
                cog.setTitle("Cost of Goods");
                if (measure.equalsIgnoreCase("cost-of-goods")) {
                    reportItems.add(0, cog);
                } else {
                    reportItems.add(cog);
                }

                ReportItem gp = new ReportItem();
                gp.setDateTitle(dateSlice.getTitle());
                gp.setValue(rpService.round(Double.isNaN(userReportService.getGrossProfit(interval, userId)) ? 0d : userReportService.getGrossProfit(interval, userId)));
                gp.setDate(reportStartDate);
                gp.setTitle("Gross Profit");
                gp.setCurrency(true);
                gp.setPercentage(false);
                if (measure.equalsIgnoreCase("gross-profit")) {
                    reportItems.add(0, gp);
                } else {
                    reportItems.add(gp);
                }

                ReportItem margin = new ReportItem();
                margin.setDateTitle(dateSlice.getTitle());
                margin.setValue(rpService.round(Double.isNaN(userReportService.getMargin(interval, userId)) ? 0d : userReportService.getMargin(interval, userId)));
                margin.setDate(reportStartDate);
                margin.setCurrency(false);
                margin.setPercentage(true);
                margin.setTitle("Margin");
                if (measure.equalsIgnoreCase("margin")) {
                    reportItems.add(0, margin);
                } else {
                    reportItems.add(margin);
                }

                ReportItem tax = new ReportItem();
                tax.setDateTitle(dateSlice.getTitle());
                tax.setValue(0d);//To be changed
                tax.setDate(reportStartDate);
                tax.setTitle("Tax");
                tax.setCurrency(true);
                tax.setPercentage(false);
                if (measure.equalsIgnoreCase("tax")) {
                    reportItems.add(0, tax);
                } else {
                    reportItems.add(tax);
                }

                granularReport.setReportItems(reportItems);
                granularReports.add(granularReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        UserReport userReport = new UserReport();
        userReport.setReport(response);
        try {
            userReport.setUser(userRepository.findOne(userId));
        } catch (Exception ex) {
            userReport.setUser(null);
        }

        return userReport;

    }

    private CustomerReport generateCustomerSalesReport(Date start, Date end, String reportType, String measure, ReportGranularity reportGranularity, String clientId) throws ParseException {

        //int days = new Interval(start.getTime(), end.getTime()).toDuration().toStandardDays().getDays();
        //List<Interval> intervals = DateUtil.splitDuration(new DateTime(start), new DateTime(end).plusHours(23).plusMinutes(60), days, 1000 * 60 * 60 * 24); //correct timing
        List<GranularReport> granularReports = new ArrayList<>();

        reportGranularity.getSliceDate().forEach(dateSlice -> {

            try {
                Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                List<ReportItem> reportItems = new ArrayList<>();
                //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                GranularReport granularReport = new GranularReport();
                Date reportStartDate = interval.getStart().toDate();
                Date reportEndDate = interval.getEnd().toDate();
                granularReport.setDateTitle(dateSlice.getTitle());

                //Retrieve Measures
                //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                if (measure.equalsIgnoreCase("basket-size")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(customerReportService.getBasketSize(interval, clientId));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Size");
                    basket_size.setCurrency(false);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("basket-value")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(customerReportService.getBasketValue(interval, clientId));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Value");
                    basket_size.setCurrency(true);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("items-sold")) {
                    ReportItem items_sold = new ReportItem();
                    items_sold.setDateTitle(dateSlice.getTitle());
                    items_sold.setValue(customerReportService.getItemsSold(interval, clientId));
                    items_sold.setDate(reportStartDate);
                    items_sold.setTitle("Items Sold");
                    items_sold.setCurrency(false);
                    items_sold.setPercentage(false);
                    reportItems.add(items_sold);
                }

                if (measure.equalsIgnoreCase("discount")) {
                    try {
                        ReportItem discount = new ReportItem();
                        discount.setDateTitle(dateSlice.getTitle());
                        discount.setValue(rpService.round(Double.isNaN(customerReportService.getDiscount(interval, clientId)) ? 0d : customerReportService.getDiscount(interval, clientId)));
                        discount.setDate(reportStartDate);
                        discount.setTitle("Discount");
                        discount.setCurrency(true);
                        discount.setPercentage(false);
                        reportItems.add(discount);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("customer-count")) {
                    try {
                        ReportItem cc = new ReportItem();
                        cc.setDateTitle(dateSlice.getTitle());
                        cc.setValue(customerReportService.getCustomers(interval, clientId).intValue());
                        cc.setDate(reportStartDate);
                        cc.setCurrency(false);
                        cc.setPercentage(false);
                        cc.setTitle("Customer Count");
                        reportItems.add(cc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("refund")) {
                    try {
                        ReportItem refund = new ReportItem();
                        refund.setDateTitle(dateSlice.getTitle());
                        refund.setValue(customerReportService.getRefund(interval, clientId).intValue());
                        refund.setDate(reportStartDate);
                        refund.setCurrency(false);
                        refund.setPercentage(false);
                        refund.setTitle("Returns");
                        reportItems.add(refund);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("transaction-count")) {
                    try {
                        ReportItem tc = new ReportItem();
                        tc.setDateTitle(dateSlice.getTitle());
                        tc.setValue(customerReportService.getTransactionCount(interval, clientId));
                        tc.setDate(reportStartDate);
                        tc.setCurrency(false);
                        tc.setPercentage(false);
                        tc.setTitle("Transaction Count");
                        reportItems.add(tc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ReportItem revenue = new ReportItem();
                revenue.setDateTitle(dateSlice.getTitle());
                revenue.setValue(customerReportService.getRevenue(interval, clientId));
                revenue.setDate(reportStartDate);
                revenue.setTitle("Revenue");
                revenue.setCurrency(true);
                revenue.setPercentage(false);
                if (measure.equalsIgnoreCase("revenue")) {
                    reportItems.add(0, revenue);
                } else {
                    reportItems.add(revenue);
                }

                ReportItem cog = new ReportItem();
                cog.setDateTitle(dateSlice.getTitle());
                cog.setValue(rpService.round(customerReportService.getCostOfGoods(interval, clientId)));
                cog.setDate(reportStartDate);
                cog.setCurrency(true);
                cog.setPercentage(false);
                cog.setTitle("Cost of Goods");
                if (measure.equalsIgnoreCase("cost-of-goods")) {
                    reportItems.add(0, cog);
                } else {
                    reportItems.add(cog);
                }

                ReportItem gp = new ReportItem();
                gp.setDateTitle(dateSlice.getTitle());
                gp.setValue(rpService.round(Double.isNaN(customerReportService.getGrossProfit(interval, clientId)) ? 0d : customerReportService.getGrossProfit(interval, clientId)));
                gp.setDate(reportStartDate);
                gp.setTitle("Gross Profit");
                gp.setCurrency(true);
                gp.setPercentage(false);
                if (measure.equalsIgnoreCase("gross-profit")) {
                    reportItems.add(0, gp);
                } else {
                    reportItems.add(gp);
                }

                ReportItem margin = new ReportItem();
                margin.setDateTitle(dateSlice.getTitle());
                margin.setValue(rpService.round(Double.isNaN(customerReportService.getMargin(interval, clientId)) ? 0d : customerReportService.getMargin(interval, clientId)));
                margin.setDate(reportStartDate);
                margin.setCurrency(false);
                margin.setPercentage(true);
                margin.setTitle("Margin");
                if (measure.equalsIgnoreCase("margin")) {
                    reportItems.add(0, margin);
                } else {
                    reportItems.add(margin);
                }

                ReportItem tax = new ReportItem();
                tax.setDateTitle(dateSlice.getTitle());
                tax.setValue(0d);//To be changed
                tax.setDate(reportStartDate);
                tax.setTitle("Tax");
                tax.setCurrency(true);
                tax.setPercentage(false);
                if (measure.equalsIgnoreCase("tax")) {
                    reportItems.add(0, tax);
                } else {
                    reportItems.add(tax);
                }

                granularReport.setReportItems(reportItems);
                granularReports.add(granularReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        CustomerReport customerReport = new CustomerReport();
        customerReport.setReport(response);
        try {
            customerReport.setCustomer(customerRepository.findByClientId(clientId));
        } catch (Exception ex) {
            customerReport.setCustomer(null);
        }

        return customerReport;

    }

    private OutletReport generateOutletSalesReport(Date start, Date end, String reportType, String measure, ReportGranularity reportGranularity, String outletName) {

        //int days = new Interval(start.getTime(), end.getTime()).toDuration().toStandardDays().getDays();
        //List<Interval> intervals = DateUtil.splitDuration(new DateTime(start), new DateTime(end).plusHours(23).plusMinutes(60), days, 1000 * 60 * 60 * 24); //correct timing
        List<GranularReport> granularReports = new ArrayList<>();

        reportGranularity.getSliceDate().stream().forEach(dateSlice -> {
            try {
                Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());
                List<ReportItem> reportItems = new ArrayList<>();
                //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                GranularReport granularReport = new GranularReport();
                Date reportStartDate = interval.getStart().toDate();
                Date reportEndDate = interval.getEnd().toDate();
                granularReport.setDateTitle(dateSlice.getTitle());

                //Retrieve Measures
                //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                if (measure.equalsIgnoreCase("basket-size")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(outletReportService.getBasketSize(interval, outletName));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Size");
                    basket_size.setCurrency(false);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("basket-value")) {
                    ReportItem basket_size = new ReportItem();
                    basket_size.setDateTitle(dateSlice.getTitle());
                    basket_size.setValue(outletReportService.getBasketValue(interval, outletName));
                    basket_size.setDate(reportStartDate);
                    basket_size.setTitle("Basket Value");
                    basket_size.setCurrency(true);
                    basket_size.setPercentage(false);
                    reportItems.add(basket_size);
                }

                if (measure.equalsIgnoreCase("items-sold")) {
                    ReportItem items_sold = new ReportItem();
                    items_sold.setDateTitle(dateSlice.getTitle());
                    items_sold.setValue(outletReportService.getItemsSold(interval, outletName));
                    items_sold.setDate(reportStartDate);
                    items_sold.setTitle("Items Sold");
                    items_sold.setCurrency(false);
                    items_sold.setPercentage(false);
                    reportItems.add(items_sold);
                }

                if (measure.equalsIgnoreCase("discount")) {
                    try {
                        ReportItem discount = new ReportItem();
                        discount.setDateTitle(dateSlice.getTitle());
                        discount.setValue(rpService.round(Double.isNaN(outletReportService.getDiscount(interval, outletName)) ? 0d : outletReportService.getDiscount(interval, outletName)));
                        discount.setDate(reportStartDate);
                        discount.setTitle("Discount");
                        discount.setCurrency(true);
                        discount.setPercentage(false);
                        reportItems.add(discount);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("customer-count")) {
                    try {
                        ReportItem cc = new ReportItem();
                        cc.setDateTitle(dateSlice.getTitle());
                        cc.setValue(outletReportService.getCustomers(interval, outletName).intValue());
                        cc.setDate(reportStartDate);
                        cc.setCurrency(false);
                        cc.setPercentage(false);
                        cc.setTitle("Customer Count");
                        reportItems.add(cc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("refund")) {
                    try {
                        ReportItem refund = new ReportItem();
                        refund.setDateTitle(dateSlice.getTitle());
                        refund.setValue(outletReportService.getRefund(interval, outletName).intValue());
                        refund.setDate(reportStartDate);
                        refund.setCurrency(false);
                        refund.setPercentage(false);
                        refund.setTitle("Returns");
                        reportItems.add(refund);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (measure.equalsIgnoreCase("transaction-count")) {
                    try {
                        ReportItem tc = new ReportItem();
                        tc.setDateTitle(dateSlice.getTitle());
                        tc.setValue(outletReportService.getTransactionCount(interval, outletName));
                        tc.setDate(reportStartDate);
                        tc.setCurrency(false);
                        tc.setPercentage(false);
                        tc.setTitle("Transaction Count");
                        reportItems.add(tc);
                    } catch (ParseException ex) {
                        Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                ReportItem revenue = new ReportItem();
                revenue.setDateTitle(dateSlice.getTitle());
                revenue.setValue(outletReportService.getRevenue(interval, outletName));
                revenue.setDate(reportStartDate);
                revenue.setTitle("Revenue");
                revenue.setCurrency(true);
                revenue.setPercentage(false);
                if (measure.equalsIgnoreCase("revenue")) {
                    reportItems.add(0, revenue);
                } else {
                    reportItems.add(revenue);
                }

                ReportItem cog = new ReportItem();
                cog.setDateTitle(dateSlice.getTitle());
                cog.setValue(rpService.round(outletReportService.getCostOfGoods(interval, outletName)));
                cog.setDate(reportStartDate);
                cog.setCurrency(true);
                cog.setPercentage(false);
                cog.setTitle("Cost of Goods");
                if (measure.equalsIgnoreCase("cost-of-goods")) {
                    reportItems.add(0, cog);
                } else {
                    reportItems.add(cog);
                }

                ReportItem gp = new ReportItem();
                gp.setDateTitle(dateSlice.getTitle());
                gp.setValue(rpService.round(Double.isNaN(outletReportService.getGrossProfit(interval, outletName)) ? 0d : customerReportService.getGrossProfit(interval, outletName)));
                gp.setDate(reportStartDate);
                gp.setTitle("Gross Profit");
                gp.setCurrency(true);
                gp.setPercentage(false);
                if (measure.equalsIgnoreCase("gross-profit")) {
                    reportItems.add(0, gp);
                } else {
                    reportItems.add(gp);
                }

                ReportItem margin = new ReportItem();
                margin.setDateTitle(dateSlice.getTitle());
                margin.setValue(rpService.round(Double.isNaN(outletReportService.getMargin(interval, outletName)) ? 0d : customerReportService.getMargin(interval, outletName)));
                margin.setDate(reportStartDate);
                margin.setCurrency(false);
                margin.setPercentage(true);
                margin.setTitle("Margin");
                if (measure.equalsIgnoreCase("margin")) {
                    reportItems.add(0, margin);
                } else {
                    reportItems.add(margin);
                }

                ReportItem tax = new ReportItem();
                tax.setDateTitle(dateSlice.getTitle());
                tax.setValue(0d);//To be changed
                tax.setDate(reportStartDate);
                tax.setTitle("Tax");
                tax.setCurrency(true);
                tax.setPercentage(false);
                if (measure.equalsIgnoreCase("tax")) {
                    reportItems.add(0, tax);
                } else {
                    reportItems.add(tax);
                }

                granularReport.setReportItems(reportItems);
                granularReports.add(granularReport);
            } catch (ParseException ex) {
                Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        OutletReport outletReport = new OutletReport();
        outletReport.setReport(response);
        outletReport.setOutletName(outletName);

        return outletReport;

    }

    private UserReport generateProductSummaryReportByUser(Date start, Date end, String reportType, String measure, ReportGranularity reportGranularity, Long userId) throws ParseException {

        //int days = new Interval(start.getTime(), end.getTime()).toDuration().toStandardDays().getDays();
        //List<Interval> intervals = DateUtil.splitDuration(new DateTime(start), new DateTime(end).plusHours(23).plusMinutes(60), days, 1000 * 60 * 60 * 24); //correct timing
        List<GranularReport> granularReports = new ArrayList<>();

        List<PosItemRecord> userProducts = itemRepository.getItemsBetweenDatesByUser(start, end, userId);

        userProducts.stream().forEach(p -> {

            reportGranularity.getSliceDate().forEach(dateSlice -> {
                try {
                    Interval interval = new Interval(dateSlice.getStart().getTime(), dateSlice.getEnd().getTime());

                    List<ReportItem> reportItems = new ArrayList<>();
                    //Create a daily report. A daily report have a list of report item. Each report item contains a summary of
                    GranularReport granularReport = new GranularReport();
                    Date reportStartDate = interval.getStart().toDate();
                    Date reportEndDate = interval.getEnd().toDate();
                    granularReport.setDateTitle(dateSlice.getTitle());

                    //Retrieve Measures
                    //Default measures are Revenue, Cost of Goods, Gross Profit, Margin, Tax,
                    if (measure.equalsIgnoreCase("basket-size")) {
                        ReportItem basket_size = new ReportItem();
                        basket_size.setDateTitle(dateSlice.getTitle());
                        basket_size.setValue(userReportService.getBasketSize(interval, userId));
                        basket_size.setDate(reportStartDate);
                        basket_size.setTitle("Basket Size");
                        basket_size.setCurrency(false);
                        basket_size.setPercentage(false);
                        reportItems.add(basket_size);
                    }

                    if (measure.equalsIgnoreCase("basket-value")) {
                        ReportItem basket_size = new ReportItem();
                        basket_size.setDateTitle(dateSlice.getTitle());
                        basket_size.setValue(userReportService.getBasketValue(interval, userId));
                        basket_size.setDate(reportStartDate);
                        basket_size.setTitle("Basket Value");
                        basket_size.setCurrency(true);
                        basket_size.setPercentage(false);
                        reportItems.add(basket_size);
                    }

                    if (measure.equalsIgnoreCase("items-sold")) {
                        ReportItem items_sold = new ReportItem();
                        items_sold.setDateTitle(dateSlice.getTitle());
                        items_sold.setValue(userReportService.getItemsSold(interval, userId));
                        items_sold.setDate(reportStartDate);
                        items_sold.setTitle("Items Sold");
                        items_sold.setCurrency(false);
                        items_sold.setPercentage(false);
                        reportItems.add(items_sold);
                    }

                    if (measure.equalsIgnoreCase("discount")) {
                        try {
                            ReportItem discount = new ReportItem();
                            discount.setDateTitle(dateSlice.getTitle());
                            discount.setValue(rpService.round(Double.isNaN(userReportService.getDiscount(interval, userId)) ? 0d : userReportService.getDiscount(interval, userId)));
                            discount.setDate(reportStartDate);
                            discount.setTitle("Discount");
                            discount.setCurrency(true);
                            discount.setPercentage(false);
                            reportItems.add(discount);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (measure.equalsIgnoreCase("customer-count")) {
                        try {
                            ReportItem cc = new ReportItem();
                            cc.setDateTitle(dateSlice.getTitle());
                            cc.setValue(userReportService.getCustomers(interval, userId).intValue());
                            cc.setDate(reportStartDate);
                            cc.setCurrency(false);
                            cc.setPercentage(false);
                            cc.setTitle("Customer Count");
                            reportItems.add(cc);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (measure.equalsIgnoreCase("refund")) {
                        try {
                            ReportItem refund = new ReportItem();
                            refund.setDateTitle(dateSlice.getTitle());
                            refund.setValue(userReportService.getRefund(interval, userId).intValue());
                            refund.setDate(reportStartDate);
                            refund.setCurrency(false);
                            refund.setPercentage(false);
                            refund.setTitle("Returns");
                            reportItems.add(refund);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    if (measure.equalsIgnoreCase("transaction-count")) {
                        try {
                            ReportItem tc = new ReportItem();
                            tc.setDateTitle(dateSlice.getTitle());
                            tc.setValue(userReportService.getTransactionCount(interval, userId));
                            //tc.setValue(ReportUtil.getUniqueItems(transactionRepository.getTransactionsBetweenDatesByProductAndUser(interval.getStart().toDate(), interval.getEnd().toDate(), )).size());
                            tc.setDate(reportStartDate);
                            tc.setCurrency(false);
                            tc.setPercentage(false);
                            tc.setTitle("Transaction Count");
                            reportItems.add(tc);
                        } catch (ParseException ex) {
                            Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    ReportItem revenue = new ReportItem();
                    revenue.setDateTitle(dateSlice.getTitle());
                    revenue.setValue(userReportService.getRevenue(interval, userId));
                    revenue.setDate(reportStartDate);
                    revenue.setTitle("Revenue");
                    revenue.setCurrency(true);
                    revenue.setPercentage(false);
                    if (measure.equalsIgnoreCase("revenue")) {
                        reportItems.add(0, revenue);
                    } else {
                        reportItems.add(revenue);
                    }

                    ReportItem cog = new ReportItem();
                    cog.setDateTitle(dateSlice.getTitle());
                    cog.setValue(rpService.round(userReportService.getCostOfGoods(interval, userId)));
                    cog.setDate(reportStartDate);
                    cog.setCurrency(true);
                    cog.setPercentage(false);
                    cog.setTitle("Cost of Goods");
                    if (measure.equalsIgnoreCase("cost-of-goods")) {
                        reportItems.add(0, cog);
                    } else {
                        reportItems.add(cog);
                    }

                    ReportItem gp = new ReportItem();
                    gp.setDateTitle(dateSlice.getTitle());
                    gp.setValue(rpService.round(Double.isNaN(userReportService.getGrossProfit(interval, userId)) ? 0d : userReportService.getGrossProfit(interval, userId)));
                    gp.setDate(reportStartDate);
                    gp.setTitle("Gross Profit");
                    gp.setCurrency(true);
                    gp.setPercentage(false);
                    if (measure.equalsIgnoreCase("gross-profit")) {
                        reportItems.add(0, gp);
                    } else {
                        reportItems.add(gp);
                    }

                    ReportItem margin = new ReportItem();
                    margin.setDateTitle(dateSlice.getTitle());
                    margin.setValue(rpService.round(Double.isNaN(userReportService.getMargin(interval, userId)) ? 0d : userReportService.getMargin(interval, userId)));
                    margin.setDate(reportStartDate);
                    margin.setCurrency(false);
                    margin.setPercentage(true);
                    margin.setTitle("Margin");
                    if (measure.equalsIgnoreCase("margin")) {
                        reportItems.add(0, margin);
                    } else {
                        reportItems.add(margin);
                    }

                    ReportItem tax = new ReportItem();
                    tax.setDateTitle(dateSlice.getTitle());
                    tax.setValue(0d);//To be changed
                    tax.setDate(reportStartDate);
                    tax.setTitle("Tax");
                    tax.setCurrency(true);
                    tax.setPercentage(false);
                    if (measure.equalsIgnoreCase("tax")) {
                        reportItems.add(0, tax);
                    } else {
                        reportItems.add(tax);
                    }

                    granularReport.setReportItems(reportItems);
                    granularReports.add(granularReport);
                } catch (ParseException ex) {
                    Logger.getLogger(SalesServiceBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        });

        ReportResponse response = new ReportResponse();
        response.setReports(granularReports);
        UserReport userReport = new UserReport();
        userReport.setReport(response);
        try {
            userReport.setUser(userRepository.findOne(userId));
        } catch (Exception ex) {
            userReport.setUser(null);
        }

        return userReport;
    }

    /**
     * @return the userReportService
     */
    public UserReportProcessorBean getUserReportService() {
        return userReportService;
    }

    /**
     * @param userReportService the userReportService to set
     */
    public void setUserReportService(UserReportProcessorBean userReportService) {
        this.userReportService = userReportService;
    }

    /**
     * @return the customerReportService
     */
    public CustomerReportProcessorBean getCustomerReportService() {
        return customerReportService;
    }

    /**
     * @param customerReportService the customerReportService to set
     */
    public void setCustomerReportService(CustomerReportProcessorBean customerReportService) {
        this.customerReportService = customerReportService;
    }

    /**
     * @return the outletReportService
     */
    public OutletReportProcessorBean getOutletReportService() {
        return outletReportService;
    }

    /**
     * @param outletReportService the outletReportService to set
     */
    public void setOutletReportService(OutletReportProcessorBean outletReportService) {
        this.outletReportService = outletReportService;
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
     * @return the itemRepository
     */
    public ItemTableBean getItemRepository() {
        return itemRepository;
    }

    /**
     * @param itemRepository the itemRepository to set
     */
    public void setItemRepository(ItemTableBean itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * @return the userRepository
     */
    public PosUserBean getUserRepository() {
        return userRepository;
    }

    /**
     * @param userRepository the userRepository to set
     */
    public void setUserRepository(PosUserBean userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return the customerRepository
     */
    public CustomerBean getCustomerRepository() {
        return customerRepository;
    }

    /**
     * @param customerRepository the customerRepository to set
     */
    public void setCustomerRepository(CustomerBean customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * @return the rpService
     */
    public ReportProcessorBean getRpService() {
        return rpService;
    }

    /**
     * @param rpService the rpService to set
     */
    public void setRpService(ReportProcessorBean rpService) {
        this.rpService = rpService;
    }

}
