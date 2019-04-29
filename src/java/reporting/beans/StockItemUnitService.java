/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import reporting.domain.Manufacturer;
import reporting.domain.Payment;
import reporting.domain.PurchaseOrder;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.StockBatch;
import reporting.domain.Supplier;
import reporting.util.ChunkReport;
import reporting.util.GranReports;
import reporting.util.ItemDetails;
import reporting.util.ItemReports;
import reporting.util.ReportFormat;
import reporting.util.ReportPattern;
import reporting.util.ReportPull;

/*************START MAIN********************/
//@javax.faces.bean.SessionScoped
//@ManagedBean(name = "stockItemUnitService")
//public class StockItemUnitService implements Serializable {
//
//    private static final Integer VENDOR_BRAND_REPORT = 1;
//    private static final Integer VENDOR_PAYMENT_REPORT = 2;
//
//    @ManagedProperty(value = "#{stockItemUnitBean}")
//    private StockItemUnitBean stockItemUnitRepository;
//
//    @ManagedProperty(value = "#{supplierBean}")
//    private SupplierBean supplierRepository;
//
//    /**
//     * Creates a new instance of StockItemUnitService
//     */
//    public StockItemUnitService() {
//        stockItemUnitRepository = new StockItemUnitBean();
//        supplierRepository = new SupplierBean();
//    }
//
//    public List<ReportFormat> getReportOfVendorByBrandSupplied(Date startDate, Date endDate) {
//        List<ReportFormat> brandReports = new ArrayList<>();
//        // find all the suppliers available within the given dates
//        List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);
//        if (suppliers.isEmpty()) {
//            return brandReports;
//        } else {
//            // for each supplier, get a list of dates he supplied goods
//
//            suppliers.stream().forEach(supplier -> {
//
//                List<Date> matchingDates = stockItemUnitRepository
//                        .getAllMatchingDatesSupplierDeliveredGoods(supplier.getSupplier_Number(), startDate, endDate);
//
//                brandReports.add(this.generateBrandReportFormat(matchingDates, supplier.getSupplier_Number(), startDate,
//                        endDate));
//            });
//        }
//
//        return brandReports;
//    }
//
//    public List<ReportFormat> getReportOfVendorPayments(Date startDate, Date endDate) {
//
//        List<ReportFormat> paymentReports = new ArrayList<>();
//
//        //find all the suppliers available within the given dates
//        List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);
//
//        if (suppliers.isEmpty()) {
//            System.out.println("Suppliers Empty");
//            return paymentReports;
//        } else {
//            System.out.println("Suppliers Not Empty");
//            suppliers.stream().forEach(supplier -> {
//                paymentReports.add(this.generatePaymentReportFormat(startDate, 
//                         endDate,  supplier.getSupplier_Number()));
//            });
//        }
//
//        for (ReportFormat testI : paymentReports) {
//            System.out.println(testI.getSupplier().getSupplier_Name());
//        }
//
//        return paymentReports;
//    }
//
//    public List<ReportPattern> getReportOfVendorByPerformance(Date startDate, Date endDate) {
//
//        List<ReportPattern> reportPattern = new ArrayList<>();
//
//        //find all the suppliers available within the given dates
//        List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);
//
//        if (suppliers.isEmpty()) {
//            return reportPattern;
//        } else {
//            //for each supplier, 
//            suppliers.stream().forEach(supplier -> {
//
//                List<Date> matchingDates
//                        = stockItemUnitRepository.getAllMatchingDatesSupplierDeliveredGoods(supplier.getSupplier_Number(), startDate, endDate);
//
//                reportPattern.add(this.loadVendorPerformanceDetails(matchingDates, supplier.getSupplier_Number()));
//
//            }); //end for each supplier
//        }
//
//        return reportPattern;
//    }
//
//    public ReportPattern loadVendorPerformanceDetails(List<Date> datesFound, String supplierId) {
//        //for each date a vendor supplied some goods, create a new ItemReport to hold the details
//        List<ItemReports> reports = new ArrayList<>();
//        ChunkReport chunkReport = new ChunkReport();
//        ReportPattern reportPattern = new ReportPattern();
//
//        for (Date entryDate : datesFound) {
//
//            List<Date> purchaseOrderDate = getDateOfPurchaseOrder(entryDate, supplierId);  //get the purchase order date for the supply
//
//            for (Date poDate : purchaseOrderDate) {
//                
//                ItemReports itemReport = new ItemReports();
//                //Long deliveryTime = DateSetter.differenceBetweenDays(purchaseOrderDate, entryDate);
//                Integer deliveryTimeInDays = this.getDeliveryTimeInDays(entryDate, poDate);
//                //itemReport.setBrandNames(brandNames);
//                itemReport.setPurchaseOrderDate(poDate);
//                itemReport.setDeliveryTimeInDays(deliveryTimeInDays);
//                itemReport.setEntryDate(entryDate);
//
//                reports.add(itemReport);
//            }
//
//        }
//
//        chunkReport.setItemReports(reports);
//        reportPattern.setReport(chunkReport);
//
//        try {
//            reportPattern.setSupplier(supplierRepository.getSupplierById(supplierId));
//        } catch (Exception e) {
//            reportPattern.setSupplier(null);
//        }
//        return reportPattern;
//    }
//
////    private ReportFormat generateAllReportFormats(Date startDate, Date endDate, String supplierId, Integer reportType) {
////        List<GranReports> granularReports = new ArrayList<>();
////        GranReports granularReport = new GranReports();
////        ReportPull reportPull = new ReportPull();
////        ReportFormat format = new ReportFormat();
////
////        switch (reportType) {
////            case 1:
////                granularReport.setBrandNames(this.getAllBrandsSupplied(supplierId, startDate, endDate));
////                break;
////            case 2:
////                granularReport.setAmountExecuted(this.getAmountPaidToVendors(supplierId, startDate, endDate));
////                granularReport.setBalanceRemaining(this.getAmountLeftToPayVendorsBetweenDates(supplierId, startDate, endDate));
////                granularReport.setBrandNames(this.getAllBrandsSupplied(supplierId, startDate, endDate));
////                break;
////
////        }
////        granularReports.add(granularReport);
////        reportPull.setReports(granularReports);
////        format.setReport(reportPull);
////
////        try {
////            format.setSupplier(supplierRepository.getSupplierById(supplierId));
////        } catch (Exception ex) {
////            format.setSupplier(null);
////        }
////        return format;
////    }
//    
//    public ReportFormat generatePaymentReportFormat(Date startDate, Date endDate, String supplierId) {
//        List<GranReports> granularReports = new ArrayList<>();
//        ReportPull reportPull = new ReportPull();
//        ReportFormat format = new ReportFormat();
//        List<Date> listOfPurchaseOrders = stockItemUnitRepository.getAllDatesOfSpecificVendorPurchaseOrder(supplierId, startDate, endDate);
//
//        for (Date poDate : listOfPurchaseOrders) {
//            GranReports granularReport = new GranReports();
//
//            granularReport.setAmountExecuted(this.getAmountPaidToVendors(supplierId, poDate));
//            granularReport.setBalanceRemaining(this.getAmountLeftToPayVendorsBetweenDates(supplierId, poDate));
//            granularReport.setDateOfEntry(poDate);
//
//            granularReports.add(granularReport);
//        }
//
//        reportPull.setReports(granularReports);
//        format.setReport(reportPull);
//
//        try {
//            format.setSupplier(supplierRepository.getSupplierById(supplierId));
//        } catch (Exception ex) {
//            format.setSupplier(null);
//        }
//        return format;
//
//    }
//
//    public ReportFormat generateBrandReportFormat(List<Date> datesFound, String supplierId, Date startDate,
//            Date endDate) {
//        List<GranReports> granularReports = new ArrayList<>();
//        ReportPull reportPull = new ReportPull();
//        ReportFormat format = new ReportFormat();
//        // for each date found, process the brand supplied
//        for (Date dates : datesFound) {
//            GranReports granularReport = new GranReports();
//
//            granularReport.setDateOfEntry(dates);
//            //granularReport.setBrandNames(this.getAllBrandsSupplied(supplierId, startDate, endDate));
//            granularReport.setBrandNames(this.getBrandsVendorSuppliedOnAParticularDay(supplierId, dates));
//
//            granularReports.add(granularReport);
//        }
//
//        reportPull.setReports(granularReports);
//        format.setReport(reportPull);
//
//        try {
//            format.setSupplier(supplierRepository.getSupplierById(supplierId));
//        } catch (Exception ex) {
//            format.setSupplier(null);
//        }
//        return format;
//    }
//    
//    public List<String> getBrandsVendorSuppliedOnAParticularDay(String supplierId, Date searchDate){
//        return stockItemUnitRepository.getBrandsVendorSuppliedOnAParticularDay(supplierId, searchDate);
//    }
//
//    public List<String> getAllBrandsSupplied(String supplierId, Date startDate, Date endDate) {
//        return stockItemUnitRepository.getBrandsSuppliedByDifferentVendors(supplierId, startDate, endDate);
//    }
//
//    public String getAmountPaidToVendors(String supplierId, Date startDate) {
//        Double amountPaid = stockItemUnitRepository.getAmountPaidToVendorsBetweenDates(supplierId, startDate);
//        return this.currencyFormatter(amountPaid);
//    }
//
//    public String getAmountLeftToPayVendorsBetweenDates(String supplierId, Date startDate) {
//        Double balanceLeft = stockItemUnitRepository.getAmountLeftToPayVendorsBetweenDates(supplierId, startDate);
//        return this.currencyFormatter(balanceLeft);
//    }
//
//    public List<Date> getSupplierMatchingDates(String supplierId, Date startDate, Date endDate) {
//        return stockItemUnitRepository.getAllMatchingDatesSupplierDeliveredGoods(supplierId, startDate, endDate);
//    }
//
//    public List<String> getAllBrandsSuppliedOnAParticularDay(String supplierId, Date searchDate) {
//        return stockItemUnitRepository.getBrandsVendorSuppliedOnAParticularDay(supplierId, searchDate);
//    }
//
//    public List<Date> getDateOfPurchaseOrder(Date searchDate, String supplierId) {
//
//        return stockItemUnitRepository.getDateOfPurchaseOrder(searchDate, supplierId);
//    }
//
//    public Integer getDeliveryTimeInDays(Date d1, Date d2) {
//        return Days.daysBetween(
//                new LocalDate(d1.getTime()),
//                new LocalDate(d2.getTime())).getDays();
//    }
//
//    public List<Supplier> getListOfVendorsBetweenDates(Date startDate, Date endDate) {
//        return stockItemUnitRepository.getListOfVendorsBetweenDates(startDate, endDate);
//    }
//
//    private String currencyFormatter(Double money) {
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//        return numberFormat.format(money).substring(1);
//    }
//
//    /**
//     * @return the stockItemUnitRepository
//     */
//    public StockItemUnitBean getStockItemUnitRepository() {
//        return stockItemUnitRepository;
//    }
//
//    /**
//     * @param stockItemUnitRepository the stockItemUnitRepository to set
//     */
//    public void setStockItemUnitRepository(StockItemUnitBean stockItemUnitRepository) {
//        this.stockItemUnitRepository = stockItemUnitRepository;
//    }
//
//    /**
//     * @return the supplierRepository
//     */
//    public SupplierBean getSupplierRepository() {
//        return supplierRepository;
//    }
//
//    /**
//     * @param supplierRepository the supplierRepository to set
//     */
//    public void setSupplierRepository(SupplierBean supplierRepository) {
//        this.supplierRepository = supplierRepository;
//    }
//
//}
/************END MAIN***********************/






//??????????????????????????????????????????????????? START NEW ????????????????????????????????????????????????????

@javax.faces.bean.SessionScoped
@ManagedBean(name = "stockItemUnitService")
public class StockItemUnitService implements Serializable {
   private static final Integer BRAND_PARAM = 1;
   private static final Integer PAYMENT_PARAM  = 2;

    @ManagedProperty(value = "#{stockItemUnitBean}")
    private StockItemUnitBean stockItemUnitRepository;

    @ManagedProperty(value = "#{supplierBean}")
    private SupplierBean supplierRepository;
    
    //constructor
    public StockItemUnitService() {
        stockItemUnitRepository = new StockItemUnitBean();
        supplierRepository = new SupplierBean();
    }
     
    public List<ReportFormat> getReportOfVendorPayments(Date startDate, Date endDate) {
		List<ReportFormat> paymentReports = new ArrayList<>();

		// find all the suppliers available within the given dates
		List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);

		if (suppliers.isEmpty()) {
			return paymentReports;
		} else {
		    suppliers.stream().forEach(supplier -> {
			  paymentReports.add((this.generatePaymentReportFormat(startDate, endDate, supplier.getSupplier_Number())));

			});
		}

		return paymentReports;
    }
    
    
    public ReportFormat generatePaymentReportFormat(Date startDate, Date endDate, String supplierId) {
		List<GranReports> granularReports = new ArrayList<>();
		ReportPull reportPull = new ReportPull();
		ReportFormat format = new ReportFormat();
		List<Date> listOfPurchaseOrders = this.getAllDatesOfSpecificVendorPurchaseOrder(supplierId, startDate, endDate);
		
		for (Date poDate : listOfPurchaseOrders) {
			GranReports granularReport = new GranReports();
			granularReport.setAmountExecuted(this.getAmountPaidToVendorsBetweenDates(supplierId, poDate));
			granularReport.setBalanceRemaining(this.getAmountLeftToPayVendorsBetweenDates(supplierId, poDate));
			granularReport.setDateOfEntry(poDate);
			granularReport.setPurchaseOrderCode(this.getPurchaseOrderCode(supplierId, poDate,null, PAYMENT_PARAM));
			granularReports.add(granularReport);
		}

		reportPull.setReports(granularReports);
		format.setReport(reportPull);

		try {
			format.setSupplier(supplierRepository.getSupplierById(supplierId));
		} catch (Exception ex) {
			format.setSupplier(null);
		}
		return format;

	}

    public List<ReportFormat> getReportOfVendorByBrandSupplied(Date startDate, Date endDate) {
        List<ReportFormat> brandReports = new ArrayList<>();
        // find all the suppliers available within the given dates
        List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);
        if (suppliers.isEmpty()) {
            return brandReports;
        } else {
            // for each supplier, get a list of dates he supplied goods

            suppliers.stream().forEach(supplier -> {

                List<Date> matchingDates = this.getAllMatchingDatesSupplierDeliveredGoods(supplier.getSupplier_Number(),
                        startDate, endDate);

                brandReports.add(this.generateBrandReportFormat(matchingDates, supplier.getSupplier_Number(), startDate,
                        endDate));
            });
        }

        return brandReports;
    }


    public ReportFormat generateBrandReportFormat(List<Date> datesFound, String supplierId, Date startDate,
            Date endDate) {
        List<GranReports> granularReports = new ArrayList<>();
        ReportPull reportPull = new ReportPull();
        ReportFormat format = new ReportFormat();

        // for each date found, process the item details
        for (Date searchDate : datesFound) {
            GranReports granularReport = new GranReports();
            List<ItemDetails> itemDetailsBag = new ArrayList<>();

            // get all the items ordered in the purchase order and which is
            // supplied on this day
            List<PurchaseOrderItem> itemsOrdered = getItemsOrderedList(searchDate);

            for (PurchaseOrderItem poItems : itemsOrdered) {

                ItemDetails itemDetails = new ItemDetails();

                String brandName = this.getBrandName(poItems.getPo_Item_ID());
                Integer quantityOrdered = poItems.getQuantity();
                Integer quantityDelivered = poItems.getExecuted_Quantity();
                String deliveryStatus = ((quantityDelivered - quantityOrdered) < 0) ? "Partial Delivery"
                        : "Full Delivery";
                String purchaseOrderNumber = this.getPurchaseOrderCode(supplierId, searchDate, poItems.getPurchase_order_id(), BRAND_PARAM);

                itemDetails.setItemName(poItems.getItem_desc());
                itemDetails.setDeliveryStatus(deliveryStatus);
                itemDetails.setQuantityDelivered(quantityDelivered);
                itemDetails.setQuantityOrdered(quantityOrdered);
                itemDetails.setPurchaseOrderNumber(purchaseOrderNumber);

                itemDetails.setBrandName(brandName);

                granularReport.setDateOfEntry(searchDate);

                itemDetails.setDateOfEntry(searchDate);

                itemDetailsBag.add(itemDetails);
                granularReport.setItemDetailsReport(itemDetailsBag);

            }
            granularReports.add(granularReport);

        }
        reportPull.setReports(granularReports);
        format.setReport(reportPull);

        try {
            format.setSupplier(supplierRepository.getSupplierById(supplierId));
        } catch (Exception ex) {
            format.setSupplier(null);
        }
        return format;
    }

    public List<ReportPattern> getReportOfVendorByPerformance(Date startDate, Date endDate) {

        List<ReportPattern> reportPattern = new ArrayList<>();

        // find all the suppliers available within the given dates
        List<Supplier> suppliers = this.getListOfVendorsBetweenDates(startDate, endDate);

        if (suppliers.isEmpty()) {
            return reportPattern;
        } else {
            // for each supplier,
            suppliers.stream().forEach(supplier -> {

                List<Date> matchingDates = this.getAllMatchingDatesSupplierDeliveredGoods(supplier.getSupplier_Number(),
                        startDate, endDate);

                reportPattern.add(this.loadVendorPerformanceDetails(matchingDates, supplier.getSupplier_Number()));

            }); // end for each supplier
        }

        return reportPattern;
    }

    public ReportPattern loadVendorPerformanceDetails(List<Date> datesFound, String supplierId) {
        // for each date a vendor supplied some goods, create a new ItemReport
        // to hold the details
        List<ItemReports> reports = new ArrayList<>();
        ChunkReport chunkReport = new ChunkReport();
        ReportPattern reportPattern = new ReportPattern();
        for (Date entryDate : datesFound) {

            //List<Date> purchaseOrderDate = this.getDateOfPurchaseOrder(entryDate, supplierId); // get
            List<PurchaseOrder> purchaseOrderDate = this.getDateOfPurchaseOrder(entryDate, supplierId);																					// the
            // //
            for (PurchaseOrder pOrder : purchaseOrderDate) {
                ItemReports itemReport = new ItemReports();

                Integer deliveryTimeInDays = this.getDeliveryTimeInDays(pOrder.getPurchase_order_date(), entryDate);
                itemReport.setPurchaseOrderDate(pOrder.getPurchase_order_date());
                itemReport.setDeliveryTimeInDays(deliveryTimeInDays);
                itemReport.setEntryDate(entryDate);
                itemReport.setPurchaseOrderNo(pOrder.getPurchase_order_code());

                reports.add(itemReport);
            }

        }

        chunkReport.setItemReports(reports);
        reportPattern.setReport(chunkReport);

        try {
            reportPattern.setSupplier(supplierRepository.getSupplierById(supplierId));
        } catch (Exception e) {
            reportPattern.setSupplier(null);
        }
        return reportPattern;
    }

    
    
    
    
    
    
    
    
    
    
    public List<Supplier> getListOfVendorsBetweenDates(Date start, Date end) {
	return stockItemUnitRepository.getListOfVendorsBetweenDates(start, end);
    }
    
    public List<Date> getAllMatchingDatesSupplierDeliveredGoods(String supplierId, Date startDate, Date endDate) {
	List<Date> datesToUse = new ArrayList<>();
	List<StockBatch> dates = stockItemUnitRepository.getAllMatchingDatesSupplierDeliveredGoods(supplierId,
				startDate, endDate);
	for (StockBatch stockBatchDates : dates) {
		datesToUse.add(stockBatchDates.getStock_batch_date());
	}
		return datesToUse;
    }

    public List<String> getBrandsSuppliedByDifferentVendors(String supplierId, Date startDate, Date endDate) {
        List<String> brandsToUse = new ArrayList<>();
        List<Manufacturer> brands = stockItemUnitRepository.getBrandsSuppliedByDifferentVendors(supplierId, startDate,
                        endDate);
            for (Manufacturer brandsSupplied : brands){
                brandsToUse.add(brandsSupplied.getManufacturer_name());
            }
                   return brandsToUse;
    }
    
    public String getAmountPaidToVendorsBetweenDates(String supplierId, Date searchDate) {
	Double amountPaid = 0.0;
	List<Payment> payments = stockItemUnitRepository.getAmountPaidToVendorsBetweenDates(supplierId, searchDate);
	    for (Payment pays : payments){
		amountPaid += pays.getActual_amount();
            }
		   return this.currencyFormatter(amountPaid);
    }
    
    public String getAmountLeftToPayVendorsBetweenDates(String supplierId, Date searchDate) {
	Double amountLeft = 0.0;
	List<Payment> payments = stockItemUnitRepository.getAmountLeftToPayVendorsBetweenDates(supplierId, searchDate);
	    for (Payment pays : payments)
		amountLeft += (pays.getAmount() - pays.getActual_amount());
		   return this.currencyFormatter(amountLeft);
    } 
    
    public Integer getDeliveryTimeInDays(Date d1, Date d2) {
	return Days.daysBetween(new LocalDate(d1.getTime()), new LocalDate(d2.getTime())).getDays();
    }
    
    public List<String> getBrandsSuppliedOnAParticularDay(String supplierId, Date searchDate) {
        List<String> brandsToUse = new ArrayList<>();
	List<Manufacturer> brands = stockItemUnitRepository.getBrandsVendorSuppliedOnAParticularDay(supplierId,
				searchDate);
		for (Manufacturer brandsSupplied : brands)
			brandsToUse.add(brandsSupplied.getManufacturer_name());
		return brandsToUse;
    }
    
    public List<Date> getAllDatesOfSpecificVendorPurchaseOrder(String supplierId, Date startDate, Date endDate) {
	List<Date> datesOfPurchaseOrder = new ArrayList<>();
	List<PurchaseOrder> poDates = stockItemUnitRepository.getAllDatesOfSpecificVendorPurchaseOrder(supplierId,
				startDate, endDate);
	    for (PurchaseOrder dates : poDates) {
		datesOfPurchaseOrder.add(dates.getPurchase_order_date());
	    }
		return datesOfPurchaseOrder;
    }
    
    public String getPurchaseOrderCode(String supplierId, Date searchDate,Integer poId, Integer param) {
	switch(param){
	    case 1:
		return stockItemUnitRepository.getOrderNumber(supplierId, poId).getPurchase_order_code();
	    case 2: 
		return stockItemUnitRepository.getPurchaseOrderCode(supplierId, searchDate).getPurchase_order_code();
	}
		
	    return null;
    }
    
    public List<PurchaseOrderItem> getItemsOrderedList(Date searchDate) {
	return stockItemUnitRepository.getListOfItemsOrdered(searchDate);
    }
    
    public String getBrandName(Integer id) {
	Manufacturer brands = stockItemUnitRepository.getBrandName(id).get(0);
	    return brands.getManufacturer_name();
    }
    
    public List<PurchaseOrder> getDateOfPurchaseOrder(Date searchDate, String supplierId) {
	return stockItemUnitRepository.getDateOfPurchaseOrder(searchDate, supplierId);
    }
    
    private String currencyFormatter(Double money) {
	NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
	    return numberFormat.format(money).substring(1);
    }
}



//??????????????????????????????????????????????????? END NEW ????????????????????????????????????????????????????