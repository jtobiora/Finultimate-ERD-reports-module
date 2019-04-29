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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import reporting.domain.Manufacturer;
import reporting.domain.Payment;
import reporting.domain.PosTransactionRecords;
import reporting.domain.PurchaseOrder;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.StockBatch;
import reporting.domain.StockItemUnit;
import reporting.domain.Supplier;
import reporting.repository.StockItemUnitRepository;
import reporting.util.DateConvert;

/*****************START MAIN***********************************/

//@javax.faces.bean.SessionScoped
//@ManagedBean(name = "stockItemUnitBean")
//public class StockItemUnitBean implements Serializable, StockItemUnitRepository {
//
//    private StockItemUnit stockItemUnit;
//    private List<String> brandsByDifferentVendors;
//    private Payment payment;
//    private StockBatch stockBatch;
//    private List<Date> allMatchingDates;
//    private List<String> getBrandVendorSupplied;
//    private List<Date> dateOfPurchaseOrder;
//    private List<Supplier> listOfVendors;
//    private List<String> brandsVendorSuppliedOnAParticularDay;
//    private DateConvert dateConvert;
//
//    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
//
//    /**
//     * Creates a new instance of StockItemUnitBean
//     */
//    public StockItemUnitBean() {
//        stockItemUnit = new StockItemUnit();
//        brandsByDifferentVendors = new ArrayList<>();
//        payment = new Payment();
//        stockBatch = new StockBatch();
//        allMatchingDates = new ArrayList<>();
//        getBrandVendorSupplied = new ArrayList<>();
//        dateOfPurchaseOrder = new ArrayList<>();
//        listOfVendors = new ArrayList<>();
//        brandsVendorSuppliedOnAParticularDay = new ArrayList<>();
//        dateConvert = new DateConvert();
//    }
//
//    @Override
//    public StockItemUnit getStockItemUnitById(Integer id) {
//        try {
//            StockItemUnit criteria = new StockItemUnit();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select stock_item_unit.* from stock_item_unit  where STOCK_UNIT_ITEM_ID = '" + id + "'");
//
//            stockItemUnit = (StockItemUnit) entityList.get(0);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        return stockItemUnit;
//    }
//
//    @Override
//    public List<String> getBrandsSuppliedByDifferentVendors(String supplierId, Date startDate, Date endDate) {
//
//        try {
//            Manufacturer criteria = new Manufacturer();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct manufacturer.* from stock_batch, stock_item_unit, stock_item,"
//                    + "manufacturer where stock_batch.STOCK_BATCH_DATE >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') AND stock_batch.STOCK_BATCH_DATE <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
//                    + "AND stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID AND stock_item_unit.SUPPLIER_ID = '" + supplierId + "' "
//                    + "AND stock_item.STOCK_ITEM_ID = stock_item_unit.STOCK_ITEM_ID "
//                    + "AND stock_item.MANUFACTURER_ID = manufacturer.MANUFACTURER_ID");
//
//            for (AbstractEntity entity : entityList) {
//                Manufacturer manufacturerEntity = (Manufacturer) entity;
//
//                brandsByDifferentVendors.add(manufacturerEntity.getManufacturer_name());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return brandsByDifferentVendors;
//    }
//
//   @Override
//    public Double getAmountPaidToVendorsBetweenDates(String supplierId, Date searchDate) {
//        double amountPaid = 0.00;
//        try {
//            Payment criteria = new Payment();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct payment.* from payment, payment_req, policy_settlement, purchase_order "
//                    + "WHERE purchase_order.purchase_order_date = TIMESTAMP('" + dateConvert.convertDate(searchDate) + "') "
//                    + "AND payment.REQUISTION_NUMBER = payment_req.REQUISITION_NO "
//                    + "AND payment_req.CLAIM_NO = policy_settlement.SETTLEMENT_CODE "
//                    + "AND purchase_order.PURCHASE_ORDER_CODE = policy_settlement.REFERENCE_NUMBER "
//                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");
//
//            for (AbstractEntity entity : entityList) {
//                Payment paymentEntity = (Payment) entity;
//
//                amountPaid += paymentEntity.getActual_amount();
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return amountPaid;
//    }
//
//    @Override
//    public Double getAmountLeftToPayVendorsBetweenDates(String supplierId, Date searchDate) {
//        double amountLeftToPay = 0.00;
//
//        try {
//            Payment criteria = new Payment();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct payment.* from payment, payment_req, policy_settlement, purchase_order "
//                    + "WHERE purchase_order.purchase_order_date = TIMESTAMP('" + dateConvert.convertDate(searchDate) + "') "
//                    + "AND payment.REQUISTION_NUMBER = payment_req.REQUISITION_NO "
//                    + "AND payment_req.CLAIM_NO = policy_settlement.SETTLEMENT_CODE "
//                    + "AND purchase_order.PURCHASE_ORDER_CODE = policy_settlement.REFERENCE_NUMBER "
//                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");
//
//            for (AbstractEntity entity : entityList) {
//                Payment paymentEntity = (Payment) entity;
//
//                amountLeftToPay += (paymentEntity.getAmount() - paymentEntity.getActual_amount());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return amountLeftToPay;
//    }
//    
//    public List<Date> getAllDatesOfSpecificVendorPurchaseOrder(String supplierId, Date startDate, Date endDate) {
//        List<Date> listOfSpecificVendorPurchaseOrder = new ArrayList<>();
//        try{
//           PurchaseOrder criteria = new PurchaseOrder();
//           List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct purchase_order.* from purchase_order "
//                    + "WHERE purchase_order.purchase_order_date >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') "
//                    + "AND purchase_order.purchase_order_date <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
//                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");
//           
//           for (AbstractEntity entity : entityList) {
//                PurchaseOrder purchaseOrderEntity = (PurchaseOrder) entity;
//
//                listOfSpecificVendorPurchaseOrder.add(purchaseOrderEntity.getPurchase_order_date());
//            }
//        }catch(Exception ex){
//           ex.printStackTrace();
//        }
//        
//        return listOfSpecificVendorPurchaseOrder;
//    }
//
//    @Override
//    public List<Date> getAllMatchingDatesSupplierDeliveredGoods(String supplierId, Date startDate, Date endDate) {
//
//        try {
//            StockBatch criteria = new StockBatch();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct stock_batch.* FROM stock_batch, stock_item_unit "
//                    + "WHERE stock_batch.stock_batch_date >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') "
//                    + "AND stock_batch.STOCK_BATCH_DATE <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
//                    + "AND stock_item_unit.STOCK_BATCH_ID = stock_batch.STOCK_BATCH_ID "
//                    + "AND stock_item_unit.SUPPLIER_ID = '" + supplierId + "'");
//
//            for (AbstractEntity entity : entityList) {
//                StockBatch stockBatchEntity = (StockBatch) entity;
//
//                allMatchingDates.add(stockBatchEntity.getStock_batch_date());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return allMatchingDates;
//    }
//
//    @Override
//    public List<String> getBrandsVendorSuppliedOnAParticularDay(String supplierId, Date searchDate) {
//
//        try {
//            Manufacturer criteria = new Manufacturer();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select manufacturer.* from stock_batch, stock_item_unit,stock_item,manufacturer "
//                    + "where stock_batch.STOCK_BATCH_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
//                    + "and stock_item_unit.STOCK_BATCH_ID = stock_batch.STOCK_BATCH_ID "
//                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
//                    + "and manufacturer.MANUFACTURER_ID = stock_item.MANUFACTURER_ID "
//                    + "and stock_item_unit.SUPPLIER_ID = '" + supplierId + "'");
//
//            for (AbstractEntity entity : entityList) {
//                Manufacturer manufacturerEntity = (Manufacturer) entity;
//
//                getBrandVendorSupplied.add(manufacturerEntity.getManufacturer_name());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return getBrandVendorSupplied;
//    }
//
//    @Override
//    public List<Date> getDateOfPurchaseOrder(Date searchDate, String supplierId) {
//
//        System.out.println("In getDateOfPurchaseOrder123");
//        try {
//            System.out.println(dateConvert.convertDate(searchDate));
//            System.out.println(supplierId);
//        } catch (ParseException ex) {
//            Logger.getLogger(StockItemUnitBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            PurchaseOrder criteria = new PurchaseOrder();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct purchase_order.* from stock_batch,stock_item_unit,purchase_order_item,purchase_order "
//                    + "where stock_batch.STOCK_BATCH_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
//                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
//                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
//                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
//                    + "and purchase_order.SUPPLIER_ID = '" + supplierId + "'");
//
//            for (AbstractEntity entity : entityList) {
//                PurchaseOrder purchaseOrderEntity = (PurchaseOrder) entity;
//
//                dateOfPurchaseOrder.add(purchaseOrderEntity.getPurchase_order_date());
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//        
//        return dateOfPurchaseOrder;
//    }
//
//    @Override
//    public List<Supplier> getListOfVendorsBetweenDates(Date startDate, Date endDate) {
//
//        System.out.println(startDate);
//        try {
//            System.out.println("Date After Conversion:" + dateConvert.convertDate(startDate));
//        } catch (ParseException ex) {
//            Logger.getLogger(StockItemUnitBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        System.out.println(endDate);
//        try {
//            System.out.println("Date After Conversion:" + dateConvert.convertDate(endDate));
//        } catch (ParseException ex) {
//            Logger.getLogger(StockItemUnitBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            Supplier criteria = new Supplier();
//            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct supplier.* from stock_batch, stock_item_unit,supplier "
//                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
//                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
//                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
//                    + "and supplier.SUPPLIER_NUMBER = stock_item_unit.SUPPLIER_ID");
//
//            for (AbstractEntity entity : entityList) {
//                Supplier supplierEntity = (Supplier) entity;
//
//                getListOfVendors().add(supplierEntity);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
//        }
//
//        return getListOfVendors();
//    }
//
//    /**
//     * @return the stockItemUnit
//     */
//    public StockItemUnit getStockItemUnit() {
//        return stockItemUnit;
//    }
//
//    /**
//     * @param stockItemUnit the stockItemUnit to set
//     */
//    public void setStockItemUnit(StockItemUnit stockItemUnit) {
//        this.stockItemUnit = stockItemUnit;
//    }
//
//    /**
//     * @return the brandsByDifferentVendors
//     */
//    public List<String> getBrandsByDifferentVendors() {
//        return brandsByDifferentVendors;
//    }
//
//    /**
//     * @param brandsByDifferentVendors the brandsByDifferentVendors to set
//     */
//    public void setBrandsByDifferentVendors(List<String> brandsByDifferentVendors) {
//        this.brandsByDifferentVendors = brandsByDifferentVendors;
//    }
//
//    /**
//     * @return the payment
//     */
//    public Payment getPayment() {
//        return payment;
//    }
//
//    /**
//     * @param payment the payment to set
//     */
//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
//
//    /**
//     * @return the getBrandVendorSupplied
//     */
//    public List<String> getGetBrandVendorSupplied() {
//        return getBrandVendorSupplied;
//    }
//
//    /**
//     * @param getBrandVendorSupplied the getBrandVendorSupplied to set
//     */
//    public void setGetBrandVendorSupplied(List<String> getBrandVendorSupplied) {
//        this.getBrandVendorSupplied = getBrandVendorSupplied;
//    }
//
//    /**
//     * @return the dateOfPurchaseOrder
//     */
//    public List<Date> getDateOfPurchaseOrder() {
//        return dateOfPurchaseOrder;
//    }
//
//    /**
//     * @param dateOfPurchaseOrder the dateOfPurchaseOrder to set
//     */
//    public void setDateOfPurchaseOrder(List<Date> dateOfPurchaseOrder) {
//        this.dateOfPurchaseOrder = dateOfPurchaseOrder;
//    }
//
//    /**
//     * @return the listOfVendors
//     */
//    public List<Supplier> getListOfVendors() {
//        return listOfVendors;
//    }
//
//    /**
//     * @param listOfVendors the listOfVendors to set
//     */
//    public void setListOfVendors(List<Supplier> listOfVendors) {
//        this.listOfVendors = listOfVendors;
//    }
//
//    /**
//     * @return the brandsVendorSuppliedOnAParticularDay
//     */
//    public List<String> getBrandsVendorSuppliedOnAParticularDay() {
//        return brandsVendorSuppliedOnAParticularDay;
//    }
//
//    /**
//     * @param brandsVendorSuppliedOnAParticularDay the
//     * brandsVendorSuppliedOnAParticularDay to set
//     */
//    public void setBrandsVendorSuppliedOnAParticularDay(List<String> brandsVendorSuppliedOnAParticularDay) {
//        this.brandsVendorSuppliedOnAParticularDay = brandsVendorSuppliedOnAParticularDay;
//    }
//
//}
/*********END MAIN**************/





//??????????????????????????????????????????????? START NEW ??????????????????????????????????????????????????????????????????
@javax.faces.bean.SessionScoped
@ManagedBean(name = "stockItemUnitBean")
public class StockItemUnitBean implements Serializable, StockItemUnitRepository {
    private StockItemUnit stockItemUnit;
    //private List<String> brandsByDifferentVendors;
    private List<Manufacturer> brandsByDifferentVendors;
    private Payment payment;
    private StockBatch stockBatch;
    //private List<Date> allMatchingDates;
    private List<StockBatch> allMatchingDates;
    private List<String> getBrandVendorSupplied;
   // private List<Date> dateOfPurchaseOrder;
    private List<PurchaseOrder> dateOfPurchaseOrder;
    private List<Supplier> listOfVendors;
    private List<Manufacturer> brandsVendorSuppliedOnAParticularDay;
    private DateConvert dateConvert;
    //private List<Date> listOfSpecificVendorPurchaseOrder;
    private  List<Payment> vendorPayments;
    private List<PurchaseOrderItem> purchaseOrderItemList;
    private PurchaseOrder purchaseOrderCode;
    private List<Manufacturer> brandName;
    private PurchaseOrder orderNumber;
    private List<PurchaseOrder> listOfPo;
    private List<PurchaseOrder> listOfSpecificVendorPurchaseOrder;
    //private List<Payment> amountLeftToPayVendors;
    //private List<Payment> amountPaidVendors;
    
    FinultimatePersistenceRemote dataServer = FinanceServiceLocator.locateFinancePersistenceManager();
    
     public StockItemUnitBean() {
        stockItemUnit = new StockItemUnit();
        brandsByDifferentVendors = new ArrayList<>();
        payment = new Payment();
        stockBatch = new StockBatch();
        allMatchingDates = new ArrayList<>();
        getBrandVendorSupplied = new ArrayList<>();
        dateOfPurchaseOrder = new ArrayList<>();
        listOfVendors = new ArrayList<>();
        brandsVendorSuppliedOnAParticularDay = new ArrayList<>();
        dateConvert = new DateConvert();
        //listOfSpecificVendorPurchaseOrder = new ArrayList<>();
        vendorPayments = new ArrayList<>();
        purchaseOrderItemList = new ArrayList<>();
        purchaseOrderCode = new PurchaseOrder();
        brandName = new ArrayList<>();
        orderNumber = new PurchaseOrder();
        listOfPo = new ArrayList<>();
        listOfSpecificVendorPurchaseOrder = new  ArrayList<>();
        //amountLeftToPayVendors = new ArrayList<>();
        //amountPaidVendors = new ArrayList<>();
    }
     
     
    @Override
    public StockItemUnit getStockItemUnitById(Integer id) {
        try {
            StockItemUnit criteria = new StockItemUnit();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select stock_item_unit.* from stock_item_unit  where STOCK_UNIT_ITEM_ID = '" + id + "'");

            stockItemUnit = (StockItemUnit) entityList.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return stockItemUnit;
    }

    
    
    @Override
    public List<Supplier> getListOfVendorsBetweenDates(Date startDate, Date endDate) {
        List<Supplier> vendors = new ArrayList<>();
       try {
            Supplier criteria = new Supplier();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct supplier.* from stock_batch, stock_item_unit,supplier "
                    + "WHERE stock_batch.STOCK_BATCH_DATE >= timestamp('" + dateConvert.convertDate(startDate) + "') "
                    + "and stock_batch.STOCK_BATCH_DATE <= timestamp('" + dateConvert.convertDate(endDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and supplier.SUPPLIER_NUMBER = stock_item_unit.SUPPLIER_ID");

            for (AbstractEntity entity : entityList) {
                Supplier supplierEntity = (Supplier) entity;

                //listOfVendors.add(supplierEntity);
                vendors.add(supplierEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return listOfVendors;
        return vendors;
    }

    
    
    
    @Override
    public List<StockBatch> getAllMatchingDatesSupplierDeliveredGoods(String supplierId, Date startDate, Date endDate) {
        List<StockBatch> batch = new ArrayList<>();  
        try {
            StockBatch criteria = new StockBatch();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct stock_batch.* FROM stock_batch, stock_item_unit "
                    + "WHERE stock_batch.stock_batch_date >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') "
                    + "AND stock_batch.STOCK_BATCH_DATE <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
                    + "AND stock_item_unit.STOCK_BATCH_ID = stock_batch.STOCK_BATCH_ID "
                    + "AND stock_item_unit.SUPPLIER_ID = '" + supplierId + "'");

            for (AbstractEntity entity : entityList) {
                StockBatch stockBatchEntity = (StockBatch) entity;

                //allMatchingDates.add(stockBatchEntity.getStock_batch_date());
                 //allMatchingDates.add(stockBatchEntity);
                 batch.add(stockBatchEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return allMatchingDates; 
        return batch; 
    }

    
    
    @Override
    public List<Manufacturer> getBrandsSuppliedByDifferentVendors(String supplierId, Date startDate, Date endDate) {
        List<Manufacturer> brands = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct manufacturer.* from stock_batch, stock_item_unit, stock_item,"
                    + "manufacturer where stock_batch.STOCK_BATCH_DATE >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') AND stock_batch.STOCK_BATCH_DATE <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
                    + "AND stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID AND stock_item_unit.SUPPLIER_ID = '" + supplierId + "' "
                    + "AND stock_item.STOCK_ITEM_ID = stock_item_unit.STOCK_ITEM_ID "
                    + "AND stock_item.MANUFACTURER_ID = manufacturer.MANUFACTURER_ID");

            for (AbstractEntity entity : entityList) {
                Manufacturer manufacturerEntity = (Manufacturer) entity;

                //brandsByDifferentVendors.add(manufacturerEntity.getManufacturer_name());
                //brandsByDifferentVendors.add(manufacturerEntity);
                brands.add(manufacturerEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return brandsByDifferentVendors;
         return brands;
    }
    
    
    @Override
    public List<PurchaseOrder> getDateOfPurchaseOrder(Date searchDate, String supplierId) {
        List<PurchaseOrder> pOrder = new ArrayList<>();
        try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct purchase_order.* from stock_batch,stock_item_unit,purchase_order_item,purchase_order "
                    + "where stock_batch.STOCK_BATCH_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID "
                    + "and purchase_order.SUPPLIER_ID = '" + supplierId + "'");

            for (AbstractEntity entity : entityList) {
                PurchaseOrder purchaseOrderEntity = (PurchaseOrder) entity;

                //dateOfPurchaseOrder.add(purchaseOrderEntity);
                pOrder.add(purchaseOrderEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        
        //return dateOfPurchaseOrder;
        return pOrder;
    }

    
    
    @Override
    public List<Manufacturer> getBrandsVendorSuppliedOnAParticularDay(String supplierId, Date searchDate) {     
         List<Manufacturer> brandsSupplied = new ArrayList<>();
        try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList = dataServer.findData(criteria, "select distinct manufacturer.* from stock_batch, stock_item_unit,stock_item,manufacturer "
                    + "where stock_batch.STOCK_BATCH_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
                    + "and stock_item_unit.STOCK_BATCH_ID = stock_batch.STOCK_BATCH_ID "
                    + "and stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID "
                    + "and manufacturer.MANUFACTURER_ID = stock_item.MANUFACTURER_ID "
                    + "and stock_item_unit.SUPPLIER_ID = '" + supplierId + "'");

            for (AbstractEntity entity : entityList) {
                Manufacturer manufacturerEntity = (Manufacturer) entity;

                //brandsVendorSuppliedOnAParticularDay.add(manufacturerEntity);
                brandsSupplied.add(manufacturerEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return brandsVendorSuppliedOnAParticularDay;
          return  brandsSupplied;
    }

    
    
    
    @Override
    public List<PurchaseOrder> getAllDatesOfSpecificVendorPurchaseOrder(String supplierId, Date startDate, Date endDate) {
        List<PurchaseOrder> vendorsPOrder = new ArrayList<>();
        try{
           PurchaseOrder criteria = new PurchaseOrder();
           List<AbstractEntity> entityList = 
                   dataServer.findData(criteria, "select distinct purchase_order.* from purchase_order "
                    + "WHERE purchase_order.purchase_order_date >= TIMESTAMP('" + dateConvert.convertDate(startDate) + "') "
                    + "AND purchase_order.purchase_order_date <= TIMESTAMP('" + dateConvert.convertDate(endDate) + "') "
                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");
           
           for (AbstractEntity entity : entityList) {
                PurchaseOrder purchaseOrderEntity = (PurchaseOrder) entity;

                //listOfSpecificVendorPurchaseOrder.add(purchaseOrderEntity);
                vendorsPOrder.add(purchaseOrderEntity);
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }
        
        //return listOfSpecificVendorPurchaseOrder;
        return vendorsPOrder;
    }

    
    
    @Override
    public List<Payment> getAmountLeftToPayVendorsBetweenDates(String supplierId, Date searchDate) {
        List<Payment> amountLeftToPayVendors = new ArrayList<>();
        try {
            Payment criteria = new Payment();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct payment.* from payment, payment_req, policy_settlement, purchase_order "
                    + "WHERE purchase_order.purchase_order_date = TIMESTAMP('" + dateConvert.convertDate(searchDate) + "') "
                    + "AND payment.REQUISTION_NUMBER = payment_req.REQUISITION_NO "
                    + "AND payment_req.CLAIM_NO = policy_settlement.SETTLEMENT_CODE "
                    + "AND purchase_order.PURCHASE_ORDER_CODE = policy_settlement.REFERENCE_NUMBER "
                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");

            for (AbstractEntity entity : entityList) {
                Payment paymentEntity = (Payment) entity;

                amountLeftToPayVendors.add(paymentEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return amountLeftToPayVendors;
    }

    
    
    @Override
    public List<Payment> getAmountPaidToVendorsBetweenDates(String supplierId, Date searchDate) {     
        List<Payment> amountPaidVendors = new ArrayList<>();
        try {
            Payment criteria = new Payment();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct payment.* from payment, payment_req, policy_settlement, purchase_order "
                    + "WHERE purchase_order.purchase_order_date = TIMESTAMP('" + dateConvert.convertDate(searchDate) + "') "
                    + "AND payment.REQUISTION_NUMBER = payment_req.REQUISITION_NO "
                    + "AND payment_req.CLAIM_NO = policy_settlement.SETTLEMENT_CODE "
                    + "AND purchase_order.PURCHASE_ORDER_CODE = policy_settlement.REFERENCE_NUMBER "
                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");

            for (AbstractEntity entity : entityList) {
                Payment paymentEntity = (Payment) entity;

                amountPaidVendors.add(paymentEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        return amountPaidVendors;

    }

    
    
    @Override
    public List<PurchaseOrderItem> getListOfItemsOrdered(Date searchDate) {
        List<PurchaseOrderItem> items = new ArrayList<>();
        try {
            PurchaseOrderItem criteria = new PurchaseOrderItem();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct purchase_order_item.* from purchase_order_item,stock_batch, stock_item_unit,stock_item,purchase_order "
                    + "WHERE stock_batch.STOCK_BATCH_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
                    + "and stock_batch.STOCK_BATCH_ID = stock_item_unit.STOCK_BATCH_ID "
                    + "and purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "and purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID");

            for (AbstractEntity entity : entityList) {
                PurchaseOrderItem purchaseOrderItemEntity = (PurchaseOrderItem) entity;

                //purchaseOrderItemList.add(purchaseOrderItemEntity);
                items.add(purchaseOrderItemEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        //return purchaseOrderItemList;
        return items;
    }

    
    
    @Override
    public PurchaseOrder getPurchaseOrderCode(String supplierId, Date searchDate) {
        PurchaseOrder pOrderCode = new PurchaseOrder();
        try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select purchase_order.* from purchase_order "
                    + "WHERE purchase_order.PURCHASE_ORDER_DATE = timestamp('" + dateConvert.convertDate(searchDate) + "') "
                    + "AND purchase_order.SUPPLIER_ID = '" + supplierId + "'");
            
           // purchaseOrderCode = (PurchaseOrder)entityList.get(0);
           pOrderCode = (PurchaseOrder)entityList.get(0);
       
        } catch (Exception ex) {
            ex.printStackTrace();

        }
          // return purchaseOrderCode;
          return pOrderCode;
    }

    
    
    @Override
    public List<Manufacturer> getBrandName(Integer id) {
        List<Manufacturer> name = new ArrayList<>();
         try {
            Manufacturer criteria = new Manufacturer();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select manufacturer.* from manufacturer,stock_item,stock_item_unit,purchase_order_item "
                    + "WHERE purchase_order_item.PO_ITEM_ID = '" + id + "' "
                    + "AND purchase_order_item.PO_ITEM_ID = stock_item_unit.PO_ITEM_ID "
                    + "AND manufacturer.MANUFACTURER_ID = stock_item.MANUFACTURER_ID  "
                    + "AND stock_item_unit.STOCK_ITEM_ID = stock_item.STOCK_ITEM_ID");
            
            for (AbstractEntity entity : entityList) {
                Manufacturer manufacturerEntity = (Manufacturer) entity;

               // brandName.add(manufacturerEntity);
               name.add(manufacturerEntity);
            }
       
        } catch (Exception ex) {
            ex.printStackTrace();

        }
           //return brandName;
           return name;
    }

    
    
    @Override
    public PurchaseOrder getOrderNumber(String supplierId, Integer id) {
        PurchaseOrder orderNo = new PurchaseOrder();
            try {
            PurchaseOrder criteria = new PurchaseOrder();
            List<AbstractEntity> entityList = 
                    dataServer.findData(criteria, "select distinct purchase_order.* from purchase_order,purchase_order_item "
                    + "WHERE purchase_order.SUPPLIER_ID = '" + supplierId + "' "
                    + "AND purchase_order_item.PURCHASE_ORDER_ID = '" + id + "' "
                    + "AND purchase_order.PURCHASE_ORDER_ID = purchase_order_item.PURCHASE_ORDER_ID");
            
            //orderNumber = (PurchaseOrder)entityList.get(0);
           orderNo = (PurchaseOrder)entityList.get(0);
       
        } catch (Exception ex) {
            ex.printStackTrace();

        }
           //return orderNumber;
           return orderNo;
    }

    
    
    @Override
    public List<PurchaseOrder> listOfPurchaseOrders(Date searchDate, String supplierId) {
        return null;
    }


}
//??????????????????????????????????????????????? END NEW ????????????????????????????????????????????????????????????????????