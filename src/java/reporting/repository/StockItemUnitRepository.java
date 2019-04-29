/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.repository;

import java.util.Date;
import java.util.List;
import reporting.domain.Manufacturer;
import reporting.domain.Payment;
import reporting.domain.PurchaseOrder;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.StockBatch;
import reporting.domain.StockItemUnit;
import reporting.domain.Supplier;

         /**START MAIN*****************/
//public interface StockItemUnitRepository {
//    
//    public StockItemUnit getStockItemUnitById(Integer id);
//    
//    public List<String> getBrandsSuppliedByDifferentVendors(String supplierId, Date startDate, Date endDate);
//    
//    public Double getAmountPaidToVendorsBetweenDates(String supplierId, Date startDate);
//    
//    public Double getAmountLeftToPayVendorsBetweenDates(String supplierId, Date startDate);
//    
//    public List<Date> getAllMatchingDatesSupplierDeliveredGoods(String supplierId, Date startDate, Date endDate);
//    
//     public List<String> getBrandsVendorSuppliedOnAParticularDay( String supplierId, Date searchDate);
//     
//     public List<Date> getDateOfPurchaseOrder( Date searchDate, String supplierId);
//     
//     public List<Supplier> getListOfVendorsBetweenDates( Date startDate, Date endDate);
//}
/*******END MAIN*******/




//?????????????????????????????????????????   START NEW  ????????????????????????????????????????????????????

public interface StockItemUnitRepository {
    
   public StockItemUnit getStockItemUnitById(Integer id);
   
   public List<Supplier> getListOfVendorsBetweenDates( Date startDate, Date endDate);
   
   public List<StockBatch> getAllMatchingDatesSupplierDeliveredGoods(String supplierId, Date startDate, Date endDate);
    
   public List<Manufacturer> getBrandsSuppliedByDifferentVendors(String supplierId, Date startDate, Date endDate);
    
   public List<PurchaseOrder> getDateOfPurchaseOrder( Date searchDate, String supplierId);
   
   public List<Manufacturer> getBrandsVendorSuppliedOnAParticularDay(String supplierId, Date searchDate);
   
   public List<PurchaseOrder> getAllDatesOfSpecificVendorPurchaseOrder(String supplierId,Date startDate,Date endDate);
   
   public List<Payment> getAmountLeftToPayVendorsBetweenDates(String supplierId,Date searchDate);
   
   public List<Payment> getAmountPaidToVendorsBetweenDates(String supplierId,Date searchDate);
	
   public List<PurchaseOrderItem> getListOfItemsOrdered(Date searchDate);
   
   
   
   
   public PurchaseOrder getPurchaseOrderCode(String supplierId,Date searchDate);
    
   public List<Manufacturer> getBrandName(Integer id);
    
   public PurchaseOrder getOrderNumber(String supplierId,Integer id);

   public List<PurchaseOrder> listOfPurchaseOrders(Date searchDate, String supplierId);
}


//?????????????????????????????????????????   END NEW  ????????????????????????????????????????????????????