package reporting.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.function.Predicate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.PurchaseOrderItem;
import reporting.util.InvItemNameDetails;
import reporting.util.InventoryReportFormat;
import reporting.util.InventoryReportPull;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.faces.bean.SessionScoped;
import reporting.domain.ItemWarehouse;
import reporting.domain.Manufacturer;
import reporting.domain.StockItemUnit;
import reporting.domain.PurchaseOrderItem;
import reporting.domain.PurchaseOrder;
import reporting.domain.SalesOrderItem;
import reporting.domain.StockBatch;
import reporting.domain.StockItemUnit;
import reporting.domain.StockItem;
import reporting.domain.StockTransferReq;
import reporting.util.Holder;
import reporting.util.StockTransferDetails;
import reporting.util.StockTransferWrapper;

@SessionScoped
@ManagedBean(name = "inventoryAuxillaryBean")
public class InventoryAuxillaryBean {

    @ManagedProperty(value = "#{inventoryPurchaseOrderBean}")
    private InventoryPurchaseOrderBean inventoryPurchaseOrderBean;

    @ManagedProperty(value = "#{inventoryStockBatchBean}")
    private InventoryStockBatchBean inventoryStockBatchBean;

    @ManagedProperty(value = "#{inventoryStockItemUnitBean}")
    private InventoryStockItemUnitBean inventoryStockItemUnitBean;

    @ManagedProperty(value = "#{inventoryStock_ItemBean}")
    private InventoryStock_ItemBean inventoryStock_ItemBean;

    @ManagedProperty(value = "#{inventoryManufacturerBean}")
    private InventoryManufacturerBean inventoryManufacturerBean;

    @ManagedProperty(value = "#{inventorySalesOrderItemBean}")
    private InventorySalesOrderItemBean inventorySalesOrderItemBean;

    @ManagedProperty(value = "#{inventoryWarehouseBean}")
    private InventoryWarehouseBean inventoryWarehouseBean;

    @ManagedProperty(value = "#{inventoryPurchaseOrderItemBean}")
    private InventoryPurchaseOrderItemBean poiBean;

    @ManagedProperty(value = "#{inventoryStockTransferReqBean}")
    private InventoryStockTransferReqBean inventoryStockTransferReqBean;

    public InventoryAuxillaryBean() {
        inventoryPurchaseOrderBean = new InventoryPurchaseOrderBean();
        inventoryStockBatchBean = new InventoryStockBatchBean();
        inventoryStockItemUnitBean = new InventoryStockItemUnitBean();
        inventoryStock_ItemBean = new InventoryStock_ItemBean();
        inventoryManufacturerBean = new InventoryManufacturerBean();
        inventorySalesOrderItemBean = new InventorySalesOrderItemBean();
        inventoryWarehouseBean = new InventoryWarehouseBean();
        poiBean = new InventoryPurchaseOrderItemBean();
        inventoryStockTransferReqBean = new InventoryStockTransferReqBean();
    }

    public InventoryReportFormat generateReportsByItemName(Date startDate, Date endDate, String match) {

        if (match.equals("below-min-qty")) {
            List<StockItemUnit> reorderLevelStocks = inventoryStockItemUnitBean.getInventoryItemsUsingOrderLevel(startDate, endDate);
            return fillReportDetailsByItemName(startDate, endDate, reorderLevelStocks, match);
        } else if (match.equals("best-selling-criteriasearch") || match.equals("worst-selling-criteriasearch")) {
            return processBestAndWorstSellingProductsByItemName(startDate, endDate, match);
        } else if (match.equals("inventory-listing")) {
            List<StockItemUnit> stocks = inventoryStockItemUnitBean.getInventoryItems(startDate, endDate);
            return fillReportDetailsByItemName(startDate, endDate, stocks, match);
        } else if (match.equals("stock-availability-report")) {
            List<StockItemUnit> itemUnitList = inventoryStockItemUnitBean.getProductsAvailable();
            return viewAvailableItems(itemUnitList);
        } else {
            List<StockItemUnit> productsInfo = inventoryStockItemUnitBean.getInventoryItems(startDate, endDate);
            return fillReportDetailsByItemName(startDate, endDate, productsInfo, match);
        }

    }

    public InventoryReportFormat fetchBrandReport(Date startDate, Date endDate, List<StockItemUnit> unitsList,
            List<StockItem> itemList, String match, Manufacturer manuf) {

        List<InvItemNameDetails> granularReports = new ArrayList<>();
        InventoryReportPull reportPull = new InventoryReportPull();
        InventoryReportFormat format = new InventoryReportFormat();

        Date today = new Date();

        for (StockItemUnit stocks : unitsList) {
            InvItemNameDetails details = new InvItemNameDetails();

            List<StockBatch> batchDelivery = inventoryStockBatchBean.getSupplyInfoForAllItems(startDate, endDate);
            PurchaseOrder pOrder = inventoryPurchaseOrderBean.getPurchaseOrderForAnItem(stocks.getPo_item_id());
            StockBatch filteredBatch = this.filterStream(batchDelivery, this.getSupplyDetails(stocks.getStock_batch_id())).get(0);
            StockItem filteredStockItems = this.filterStream(itemList, this.getStocks(stocks.getStock_item_id())).get(0);
            System.out.println(filteredStockItems);
            granularReports.add(this.appendReportDetails(stocks, filteredBatch, pOrder, filteredStockItems, match));
        }
        reportPull.setReportDetails(granularReports);
        format.setReportPull(reportPull);

        try {
            format.setManufacturer(manuf);
        } catch (Exception ex) {
            format.setManufacturer(null);
        }
        return format;

    }

    public InventoryReportFormat generateInventoryReportByWarehouse(Date startDate, Date endDate, String match,
            List<StockItemUnit> stocks, ItemWarehouse warehouse) {
        List<InvItemNameDetails> blockReports = new ArrayList<>();
        InventoryReportPull chunk = new InventoryReportPull();
        InventoryReportFormat reportFormat = new InventoryReportFormat();

        for (StockItemUnit unit : stocks) {

            List<StockBatch> batchDelivery = inventoryStockBatchBean.getSupplyInfoForAllItems(startDate, endDate);
            List<StockItem> stockItemList = inventoryStock_ItemBean.listStockItems(startDate, endDate);
            PurchaseOrder pOrder = inventoryPurchaseOrderBean.getPurchaseOrderForAnItem(unit.getPo_item_id());
            StockBatch filteredBatch = this.filterStream(batchDelivery, this.getSupplyDetails(unit.getStock_batch_id())).get(0);
            StockItem filteredStockItems = this.filterStream(stockItemList, this.getStocks(unit.getStock_item_id())).get(0);

            blockReports.add(this.appendReportDetails(unit, filteredBatch, pOrder, filteredStockItems, match));
        }

        chunk.setReportDetails(blockReports);
        reportFormat.setReportPull(chunk);

        try {
            reportFormat.setWarehouse(warehouse);
        } catch (Exception ex) {
            reportFormat.setManufacturer(null);
        }
        return reportFormat;

    }

    private InventoryReportFormat viewAvailableItems(List<StockItemUnit> itemUnitList) {

        InventoryReportPull reportPull = new InventoryReportPull();
        InventoryReportFormat format = new InventoryReportFormat();

        List<Integer> poiItemIdList = itemUnitList.stream().map(StockItemUnit::getPo_item_id).collect(toList());
        List<PurchaseOrderItem> poItemList = poiBean.getPurchaseOrderItemUsingParamList(poiItemIdList);

        List<Integer> poItemIds = poItemList.stream().map(PurchaseOrderItem::getPurchase_order_id).collect(toList());
        List<PurchaseOrder> poList = inventoryPurchaseOrderBean.getPurchaseOrderUsingParamList(poItemIds);
        List<StockItem> itemList = inventoryStock_ItemBean.getStockItemsAvailable();
        List<StockBatch> batchList = inventoryStockBatchBean.getStockBatchAvl();

        List<InvItemNameDetails> granularReports = this.process(itemUnitList, batchList, itemList, poItemList, poList);

        if (granularReports.isEmpty()) {
            return null;
        } else {
            reportPull.setReportDetails(granularReports);
            format.setReportPull(reportPull);
        }

        return format;
    }

    private List<InvItemNameDetails> process(List<StockItemUnit> itemUnitList, List<StockBatch> batchList,
            List<StockItem> itemList, List<PurchaseOrderItem> poItemList, List<PurchaseOrder> poList) {

        List<InvItemNameDetails> granularReports = new ArrayList<>();

        for (StockItemUnit stockInfo : itemUnitList) {
            StockBatch batch = filterStream(batchList, b -> Integer.valueOf(b.getStock_batch_id()).equals(stockInfo.getStock_batch_id()))
                    .get(0);

            StockItem sItem = filterStream(itemList, s -> Integer.valueOf(s.getStock_item_id()).equals(stockInfo.getStock_item_id()))
                    .get(0);

            PurchaseOrderItem pOrderItem = filterStream(poItemList,
                    p -> Integer.valueOf(p.getPo_Item_ID()).equals(stockInfo.getPo_item_id())).get(0);

            Integer i = pOrderItem.getPurchase_order_id();
            PurchaseOrder po = filterStream(poList, p -> Integer.valueOf(p.getPo_ID()).equals(i)).get(0);

            granularReports.add(appendReportDetails(stockInfo, batch, po, sItem, "stock-availability-report"));

        }

        return granularReports;
    }

    public InventoryReportFormat processBestAndWorstSellingProductsByItemName(Date startDate, Date endDate,
            String param) {

        List<SalesOrderItem> itemsSoldBtwDates = inventorySalesOrderItemBean.getItemsSoldBetweenDates(startDate, endDate);

        if (itemsSoldBtwDates.isEmpty()) {
            return null;
        } else {

            Map<String, List<?>> listMap = this.getObjectData(startDate, endDate, param, itemsSoldBtwDates);

            @SuppressWarnings("unchecked")
            List<StockItem> siList = (List<StockItem>) listMap.get("itemList");

            @SuppressWarnings("unchecked")
            List<StockItemUnit> processedItemUnit = (List<StockItemUnit>) listMap.get("itemUnitList");

            List<StockItemUnit> sortedItemUnit = this.sortItemsByQtySold(processedItemUnit, param);

            return this.genFastAndSlowSellingReport(startDate, endDate, sortedItemUnit,
                    param, siList, null, "by-item");

        }
    }

    public List<InventoryReportFormat> processBestAndWorstSellingProductsByBrand(Date startDate, Date endDate,
            String type) {

        List<InventoryReportFormat> brandList = new ArrayList<>();

        List<SalesOrderItem> itemsSoldBtwDates = inventorySalesOrderItemBean.getItemsSoldBetweenDates(startDate,
                endDate);

        // if no items were sold
        if (itemsSoldBtwDates.isEmpty()) {
            return new ArrayList<InventoryReportFormat>();
        } else {

            List<Manufacturer> brandsSold = inventoryManufacturerBean.getBrandNamesOfAllSoldItems(startDate, endDate);

            Map<String, List<?>> listMap = this.getObjectData(startDate, endDate, type, itemsSoldBtwDates);

            @SuppressWarnings("unchecked")
            List<StockItem> siList = (List<StockItem>) listMap.get("itemList");

            @SuppressWarnings("unchecked")
            List<StockItemUnit> processedItemUnit = (List<StockItemUnit>) listMap.get("itemUnitList");

            for (Manufacturer brand : brandsSold) {
                List<StockItem> sItems = this.filterStream(siList,
                        si -> Integer.valueOf(si.getManufacturer_id()).equals(brand.getManufacturer_id()));

                List<Integer> ids = sItems.stream().map(StockItem::getStock_item_id).collect(toList());
                List<StockItemUnit> units = processedItemUnit.stream().filter(f -> ids.contains(f.getStock_item_id())).collect(toList());

                List<StockItemUnit> sorted = this.sortItemsByQtySold(units, type);

                brandList.add(this.genFastAndSlowSellingReport(startDate, endDate,
                        sorted, type, sItems, brand, "by-brand"));
            }
        }

        return brandList;
    }

    public List<InventoryReportFormat> processBestAndWorstSellingByWarehouse(Date startDate, Date endDate,
            String type) {
        List<SalesOrderItem> itemsSoldBtwDates = inventorySalesOrderItemBean.getItemsSoldBetweenDates(startDate,
                endDate);
        List<InventoryReportFormat> warehouseList = new ArrayList<>();

        if (itemsSoldBtwDates.isEmpty()) {
            return new ArrayList<InventoryReportFormat>();
        } else {

            Map<String, List<?>> listMap = this.getObjectData(startDate, endDate, type, itemsSoldBtwDates);

            @SuppressWarnings("unchecked")
            List<ItemWarehouse> warehouses = (List<ItemWarehouse>) listMap.get("warehouses");

            @SuppressWarnings("unchecked")
            List<StockItem> siList = (List<StockItem>) listMap.get("itemList");

            @SuppressWarnings("unchecked")
            List<StockItemUnit> processedItemUnit = (List<StockItemUnit>) listMap.get("itemUnitList");

            @SuppressWarnings("unchecked")
            List<Integer> widList = (List<Integer>) listMap.get("warehouseIdList");

            List<StockItemUnit> stocksInWarehouse = processedItemUnit.stream().filter(t -> widList.contains(t.getWarehouse_id())).collect(toList());

            List<Integer> siuId = stocksInWarehouse.stream().map(StockItemUnit::getWarehouse_id).collect(toList());

            Set<ItemWarehouse> distinctWarehouses = warehouses.stream().filter(x -> siuId.contains(x.getWarehouseid())).collect(toSet());

            for (ItemWarehouse warehouse : distinctWarehouses) {

                List<StockItemUnit> units = filterStream(stocksInWarehouse,
                        siu -> Integer.valueOf(siu.getWarehouse_id()).equals(warehouse.getWarehouseid()));

                List<StockItemUnit> sorted = this.sortItemsByQtySold(units, type);

                warehouseList.add(this.genFastAndSlowSellingReport(startDate, endDate, sorted,
                        type, siList, warehouse, "by-warehouse"));
            }

        }

        return warehouseList;
    }

    private InventoryReportFormat fillReportDetailsByItemName(Date startDate, Date endDate,
            List<StockItemUnit> productsInfo, String criteria) {
        List<InvItemNameDetails> granularReports = new ArrayList<>();
        InventoryReportPull reportPull = new InventoryReportPull();
        InventoryReportFormat format = new InventoryReportFormat();

        List<StockItem> stockItems = inventoryStock_ItemBean.listStockItems(startDate, endDate);
        List<StockBatch> batchItems = inventoryStockBatchBean.getSupplyInfoForAllItems(startDate, endDate);
        List<PurchaseOrderItem> poItem = poiBean.getPurchaseOrderItem(startDate, endDate);
        List<Integer> poItemIds = poItem.stream().map(PurchaseOrderItem::getPurchase_order_id).collect(toList());
        List<PurchaseOrder> purchaseOrder = inventoryPurchaseOrderBean.getPurchaseOrderUsingParamList(poItemIds);

        for (StockItemUnit stockInfo : productsInfo) {

            StockBatch batch = filterStream(batchItems, b -> Integer.valueOf(b.getStock_batch_id()).equals(stockInfo.getStock_batch_id()))
                    .get(0);

            StockItem sItem = filterStream(stockItems, s -> Integer.valueOf(s.getStock_item_id()).equals(stockInfo.getStock_item_id()))
                    .get(0);

            PurchaseOrderItem pOrderItem = filterStream(poItem,
                    p -> Integer.valueOf(p.getPo_Item_ID()).equals(stockInfo.getPo_item_id())).get(0);

            Integer i = pOrderItem.getPurchase_order_id();

            PurchaseOrder po = filterStream(purchaseOrder, p -> Integer.valueOf(p.getPo_ID()).equals(i)).get(0);

            granularReports.add(appendReportDetails(stockInfo, batch, po, sItem, criteria));
        }
        if (granularReports.isEmpty()) {
            return null;
        } else {
            reportPull.setReportDetails(granularReports);
            format.setReportPull(reportPull);
        }

        return format;

    }

    public List<InventoryReportFormat> viewAvailableBrands(List<StockItemUnit> stocksList) {
        List<InventoryReportFormat> brandList = new ArrayList<>();
        List<StockItem> itemList = inventoryStock_ItemBean.getStockItemsAvailable();
        Set<Integer> ids = itemList.stream().map(StockItem::getManufacturer_id).collect(toSet());

        List<Manufacturer> brands = inventoryManufacturerBean.getManufacturerUsingParamList(ids);

        if (brands.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (Manufacturer manuf : brands) {
                List<StockItem> si = itemList.stream().filter(s -> Integer.valueOf(s.getManufacturer_id()).equals(manuf.getManufacturer_id())).collect(toList());
                List<Integer> sid = si.stream().map(StockItem::getStock_item_id).collect(toList());

                List<StockItemUnit> siu = stocksList.stream().filter(s -> sid.contains(s.getStock_item_id())).collect(toList());

                brandList.add(this.getAvailableTypes(siu, si, manuf, "by-brand"));
            }
        }

        return brandList;
    }

    private InventoryReportFormat getAvailableTypes(List<StockItemUnit> units, List<StockItem> itemList, Object klazz, String repType) {
        InventoryReportPull reportPull = new InventoryReportPull();
        InventoryReportFormat format = new InventoryReportFormat();

        List<Integer> poiItemIdList = units.stream().map(StockItemUnit::getPo_item_id).collect(toList());
        List<PurchaseOrderItem> poItemList = poiBean.getPurchaseOrderItemUsingParamList(poiItemIdList);

        List<Integer> poItemIds = poItemList.stream().map(PurchaseOrderItem::getPurchase_order_id).collect(toList());
        List<PurchaseOrder> poList = inventoryPurchaseOrderBean.getPurchaseOrderUsingParamList(poItemIds);
        List<StockBatch> batchList = inventoryStockBatchBean.getStockBatchAvl();

        List<InvItemNameDetails> granularReports = this.process(units, batchList, itemList, poItemList, poList);

        reportPull.setReportDetails(granularReports);
        format.setReportPull(reportPull);

        try {
            if (repType.equals("by-brand")) {
                Manufacturer manuf = (Manufacturer) klazz;
                format.setManufacturer(manuf);
            } else {
                ItemWarehouse warehouse = (ItemWarehouse) klazz;
                format.setWarehouse(warehouse);
            }
        } catch (Exception ex) {
            format.setManufacturer(null);
            format.setWarehouse(null);
        }
        return format;
    }

    private InventoryReportFormat genFastAndSlowSellingReport(Date startDate, Date endDate, List<StockItemUnit> itemUnit,
            String measure, List<StockItem> item, Object klass, String category) {

        List<InvItemNameDetails> reports = new ArrayList<>();
        InventoryReportPull box = new InventoryReportPull();
        InventoryReportFormat format = new InventoryReportFormat();

        ItemWarehouse warehouse = null;
        Manufacturer manufacturer = null;

        for (StockItemUnit stocks : itemUnit) {

            StockItem st = filterStream(item, i -> Integer.valueOf(i.getStock_item_id()).equals(stocks.getStock_item_id())).get(0);

            reports.add(this.appendReportDetails(stocks, null, null, st, measure));
        }

        if (category.equals("by-item")) {
            if (reports.isEmpty()) {
                return null;
            } else {
                box.setReportDetails(reports);
                format.setReportPull(box);
            }

            return format;
        } else {
            box.setReportDetails(reports);
            format.setReportPull(box);

            try {
                if (category.equals("by-brand")) {
                    manufacturer = (Manufacturer) klass;
                    format.setManufacturer(manufacturer);
                } else if (category.equals("by-warehouse")) {
                    warehouse = (ItemWarehouse) klass;
                    format.setWarehouse(warehouse);
                }
            } catch (Exception ex) {
                format.setWarehouse(null);
                format.setManufacturer(null);
            }

            return format;
        }
    }

    private InvItemNameDetails appendReportDetails(StockItemUnit unit, StockBatch batch, PurchaseOrder pOrder,
            StockItem item, String criteria) {

        InvItemNameDetails details = new InvItemNameDetails();

        if (criteria.equals("best-selling-criteriasearch") || criteria.equals("worst-selling-criteriasearch")) {
            details.setItemName(item.getStock_item_name());
            details.setRevenueEarned(unit.getRevenueEarned());
            details.setTotalQtySold(unit.getQtyOfItemsSold());
        } else {
            // set all the details
            Date today = new Date();
            details.setDateOfEntry(batch.getEntry_date());
            details.setStockBatchNumber(batch.getStock_batch_no());
            details.setItemName(item.getStock_item_name());
            details.setPurchaseOrderNumber(pOrder.getPurchase_order_code());

            if (criteria.equals("expiry-list-report")) {
                details.setExpiryDate(unit.getExpiry_date());
            } else if (criteria.equals("stock-aging-report")) {
                details.setStockAge(this.getStockAge(today, batch.getStock_batch_date()));
            } else if (criteria.equals("stock-value-report")) {
                Double qty = unit.getQuantity();
                Double purchasePrice = unit.getStock_item_price();
                details.setStockLeft(qty);
                details.setUnitPrice(this.currencyFormatter(unit.getStock_item_price()));
                details.setStockValue(this.currencyFormatter(qty * purchasePrice));
            } else if (criteria.equals("below-min-qty")) {
                details.setStockLeft(unit.getQuantity());
                details.setReorderLevel(item.getReorder_level());
            } else if (criteria.equals("inventory-listing")) {
                details.setBarcodeNumber(unit.getBarcode_number());
                details.setSerialNumber(unit.getManuf_serial_no());
            } else if (criteria.equals("stock-availability-report")) {
                details.setStockLeft(unit.getQuantity());
            }
        }

        return details;
    }

    public <T> List<T> filterStream(List<T> items, Predicate<T> pre) {
        return items.stream().filter(pre).collect(Collectors.<T>toList());
    }

    public Integer getStockAge(Date today, Date stockEntryDate) {
        return Days.daysBetween(new LocalDate(stockEntryDate.getTime()), new LocalDate(today.getTime())).getDays();
    }

    private String currencyFormatter(Double money) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(money).substring(1);
    }

    public List<StockItemUnit> sortItemsByQtySold(List<StockItemUnit> stockItemUnit, String measure) {
        // check if it is best-selling or worst-selling that was selected
        if (measure.contains("best-selling")) {
            // sort the items in descending order
            return stockItemUnit.stream().sorted(comparing(StockItemUnit::getQtyOfItemsSold).reversed())
                    .collect(toList());

        } else if (measure.contains("worst-selling")) {
            // sort the items in ascending order
            return stockItemUnit.stream().sorted(comparing(StockItemUnit::getQtyOfItemsSold)).collect(toList());
        }
        return null;
    }

    private Map<String, List<?>> getObjectData(Date startDate, Date endDate, String type,
            List<SalesOrderItem> itemsSoldBtwDates) {

        Map<String, List<?>> mapList = new HashMap<>();

        List<ItemWarehouse> warehouses = inventoryWarehouseBean.findAllWarehouses();

        List<Integer> widList = warehouses.stream().map(ItemWarehouse::getWarehouseid).collect(toList());

        // if no items were sold
        if (itemsSoldBtwDates.isEmpty()) {
            return null;
        } else {
            Map<Integer, List<SalesOrderItem>> stockItemUnitGroup = itemsSoldBtwDates.stream()
                    .collect(groupingBy(SalesOrderItem::getStockItemUnitId));

            Map<Integer, List<SalesOrderItem>> stockItemGroup = itemsSoldBtwDates.stream()
                    .collect(groupingBy(SalesOrderItem::getStockItemId));

            Set<Integer> siuKeys = stockItemUnitGroup.keySet();
            Set<Integer> siKeys = stockItemGroup.keySet();

            List<Holder> holderList = createHolderList(stockItemUnitGroup, siuKeys);

            List<StockItemUnit> siuList = inventoryStockItemUnitBean.getStockItemUnitUsingParamList(siuKeys);

            List<StockItem> siList = inventoryStock_ItemBean.getStockItemUsingParamList(siKeys);
            List<StockItemUnit> processedItemUnit = resetStockItemUnitData(siuList, holderList);

            mapList.put("warehouses", warehouses);
            mapList.put("itemUnitList", processedItemUnit);
            mapList.put("itemList", siList);
            mapList.put("warehouseIdList", widList);

            return mapList;

        }

    }

    public List<Holder> createHolderList(Map<Integer, List<SalesOrderItem>> itemGroup, Set<Integer> keys) {
        List<Holder> holderList = new ArrayList<>();
        int count = 0;
        double revenueEarned = 0.0;
        for (Integer key : keys) {
            for (SalesOrderItem orderItem : itemGroup.get(key)) {
                count += orderItem.getQuantity();
                revenueEarned += orderItem.getAmount();
            }
            Holder holder = new Holder(key, count, revenueEarned);
            holderList.add(holder);
            count = 0;
            revenueEarned = 0.0;
        }

        return holderList;
    }

    public List<StockItemUnit> resetStockItemUnitData(List<StockItemUnit> itemUnit, List<Holder> holderList) {
        List<StockItemUnit> processedItemUnit = new ArrayList<>();

        if (!itemUnit.isEmpty()) {
            itemUnit.stream().forEach(unit -> {
                Optional<Integer> qty = this.filterOutQtyOfItemsSold(holderList, unit.getStock_unit_item_id());
                Optional<Double> rev = this.filterOutRevenueEarned(holderList, unit.getStock_unit_item_id());

                Integer qtySold = (qty.isPresent()) ? qty.get() : -1;
                Double revenue = (rev.isPresent()) ? rev.get() : 0.0;

                String earning = this.currencyFormatter(revenue);
                unit.setQtyOfItemsSold(qtySold.doubleValue());
                unit.setRevenueEarned(earning);
                processedItemUnit.add(unit);
            });
        }
        return processedItemUnit;

    }

    public Optional<Integer> filterOutQtyOfItemsSold(List<Holder> items, Integer stockItemUnitId) {
        return items.stream().filter(e -> e.getId().equals(stockItemUnitId)).distinct().map(Holder::getQtySold)
                .findFirst();
    }

    public Optional<Double> filterOutRevenueEarned(List<Holder> items, Integer stockItemUnitId) {
        return items.stream().filter(e -> e.getId().equals(stockItemUnitId)).distinct().map(Holder::getRevenueEarned)
                .findFirst();
    }

    public Predicate<StockBatch> getSupplyDetails(Integer id) {
        return sb -> Integer.valueOf(sb.getStock_batch_id()).equals(id);
    }

    public Predicate<StockItem> getStocks(Integer id) {
        return si -> Integer.valueOf(si.getStock_item_id()).equals(id);
    }

    public List<InventoryReportFormat> viewStockMovementsByItem(Date startDate, Date endDate) {
        InventoryReportFormat format = null;
        List<InventoryReportFormat> movtReports = new ArrayList<>();

        //1. Get all the stock transfer requests between a start data and an end date
        List<StockTransferReq> stockTransfers = inventoryStockTransferReqBean.getStockTransfers(startDate, endDate, 2);

        String itemName = null;
        String brandName = null;
        Manufacturer manufacturer = null;
        if (stockTransfers.isEmpty()) {
            return null;
        } else {
            //2.Get the stockItemid in the transfers
            Set<Integer> stockTransferIds = stockTransfers.stream().map(StockTransferReq::getStockItemId).collect(toSet());

            //3. Use the stockItemId's to find all the stocks that correspond to it
            List<StockItem> transferedStocks = inventoryStock_ItemBean.getStockItemUsingParamList(stockTransferIds);

            //a.Get all the manufacturer ids
            Set<Integer> brandIds = transferedStocks.stream().map(StockItem::getManufacturer_id).collect(toSet());

            //b. Get all the brands corresponding to the id list
            List<Manufacturer> brands = inventoryManufacturerBean.getManufacturerUsingParamList(brandIds);

            //4. get all the warehouse id's from the stock transfers
            Set<Integer> warehouseIds = stockTransfers.stream().map(StockTransferReq::getWarehouseId).collect(toSet());

            //5.find all the warehouses with that id
            List<ItemWarehouse> warehouseTransfers = inventoryWarehouseBean.getWarehousesUsingParamList(warehouseIds);

            for (Integer id : stockTransferIds) {
                List<StockTransferDetails> transferDetails = new ArrayList<>();
                format = new InventoryReportFormat();
                //StockTransfers stkMovt = new StockTransfers();

                //a. filter out the items in the stocktransfers that have the same id as this
                List<StockTransferReq> filteredStocks = stockTransfers.stream().filter(f -> f.getStockItemId().equals(id)).collect(toList());

                for (StockTransferReq stockReq : filteredStocks) {
                    StockTransferDetails details = new StockTransferDetails();

                    Integer itemId = stockReq.getStockItemId();
                    Integer locationId = stockReq.getWarehouseId();

                    itemName
                            = transferedStocks.stream()
                                    .filter(s -> Integer.valueOf(s.getStock_item_id())
                                    .equals(itemId))
                                    .map(StockItem::getStock_item_name)
                                    .findAny()
                                    .orElse(null);

                    String warehouseName
                            = warehouseTransfers.stream()
                                    .filter(w -> Integer.valueOf(w.getWarehouseid())
                                    .equals(locationId))
                                    .map(ItemWarehouse::getWarehouseName)
                                    .findAny()
                                    .orElse(null);

                    Integer mid = transferedStocks.stream().filter(m -> Integer.valueOf(m.getStock_item_id()).equals(itemId)).collect(toList()).get(0).getManufacturer_id();

                    //brandName = brands.stream().filter(b -> b.getManufacturerId().equals(mid)).map(Manufacturer::getManufacturerName).findAny().orElse(null);	
                    manufacturer = brands.stream().filter(b -> Integer.valueOf(b.getManufacturer_id()).equals(mid)).collect(toList()).get(0);

                    details.setQuantitySent(stockReq.getQuantity());
                    details.setTransferDate(stockReq.getEffectiveDate());
                    details.setWarehouseName(warehouseName);

                    transferDetails.add(details);

                }

                format.setTransferDetails(transferDetails);
                format.setItemName(itemName);
                //format.setBrandName(brandName);
                format.setManufacturer(manufacturer);
                movtReports.add(format);
            }
            return movtReports;
        }
    }

    public List<InventoryReportFormat> viewStockMovementsByBrand(Date startDate, Date endDate) {
        List<StockTransferWrapper> transferWrapper = new ArrayList<>();
        InventoryReportFormat format = null;
        List<InventoryReportFormat> movtReports = new ArrayList<>();

        // 1. Get all the stock transfer requests between a start data and an
        // end date
        List<StockTransferReq> stockTransfers = inventoryStockTransferReqBean.getStockTransfers(startDate, endDate, 2);

        String itemName = null;
        if (stockTransfers.isEmpty()) {
            return null;
        } else {

            Set<Integer> stockTransferIds = stockTransfers.stream().map(StockTransferReq::getStockItemId)
                    .collect(toSet());

            List<StockItem> transferedStocks = inventoryStock_ItemBean.getStockItemUsingParamList(stockTransferIds);

            Set<Integer> brandIds = transferedStocks.stream().map(StockItem::getManufacturer_id).collect(toSet());

            List<Manufacturer> brands = inventoryManufacturerBean.getManufacturerUsingParamList(brandIds);

            for (StockTransferReq transReq : stockTransfers) {
                StockTransferWrapper wrapper = new StockTransferWrapper();

                Integer stockTransId = transReq.getStockItemId();
                Integer manufacturerId = transferedStocks.stream().filter(f -> Integer.valueOf(f.getStock_item_id()).equals(stockTransId))
                        .map(StockItem::getManufacturer_id).findAny().orElse(null);

                wrapper.setTransferReq(transReq);
                wrapper.setManufacturerId(manufacturerId);

                transferWrapper.add(wrapper);
            }

            Set<Integer> warehouseIds = stockTransfers.stream().map(StockTransferReq::getWarehouseId).collect(toSet());

            List<ItemWarehouse> warehouseTransfers = inventoryWarehouseBean.getWarehousesUsingParamList(warehouseIds);

            for (Manufacturer manuf : brands) {
                List<StockTransferDetails> transferDetails = new ArrayList<>();
                format = new InventoryReportFormat();

                List<StockTransferReq> stockmovtReq = transferWrapper.stream()
                        .filter(x -> x.getManufacturerId().equals(manuf.getManufacturer_id()))
                        .map(StockTransferWrapper::getTransferReq).collect(toList());

                for (StockTransferReq req : stockmovtReq) {
                    StockTransferDetails details = new StockTransferDetails();
                    Integer itemId = req.getStockItemId();
                    Integer locationId = req.getWarehouseId();

                    itemName = transferedStocks.stream().filter(s -> Integer.valueOf(s.getStock_item_id()).equals(itemId))
                            .map(StockItem::getStock_item_name).findAny().orElse(null);

                    String warehouseName = warehouseTransfers.stream()
                            .filter(w -> Integer.valueOf(w.getWarehouseid()).equals(locationId)).map(ItemWarehouse::getWarehouseName)
                            .findAny().orElse(null);

                    details.setQuantitySent(req.getQuantity());
                    details.setTransferDate(req.getEffectiveDate());
                    details.setWarehouseName(warehouseName);
                    details.setName(itemName);

                    transferDetails.add(details);
                }

                format.setTransferDetails(transferDetails);
                format.setManufacturer(manuf);
                movtReports.add(format);
            }

            return movtReports;
        }
    }

    public InventoryPurchaseOrderBean getInventoryPurchaseOrderBean() {
        return inventoryPurchaseOrderBean;
    }

    public void setInventoryPurchaseOrderBean(InventoryPurchaseOrderBean inventoryPurchaseOrderBean) {
        this.inventoryPurchaseOrderBean = inventoryPurchaseOrderBean;
    }

    public InventoryStockBatchBean getInventoryStockBatchBean() {
        return inventoryStockBatchBean;
    }

    public void setInventoryStockBatchBean(InventoryStockBatchBean inventoryStockBatchBean) {
        this.inventoryStockBatchBean = inventoryStockBatchBean;
    }

    public InventoryStockItemUnitBean getInventoryStockItemUnitBean() {
        return inventoryStockItemUnitBean;
    }

    public void setInventoryStockItemUnitBean(InventoryStockItemUnitBean inventoryStockItemUnitBean) {
        this.inventoryStockItemUnitBean = inventoryStockItemUnitBean;
    }

    public InventoryStock_ItemBean getInventoryStock_ItemBean() {
        return inventoryStock_ItemBean;
    }

    public void setInventoryStock_ItemBean(InventoryStock_ItemBean inventoryStock_ItemBean) {
        this.inventoryStock_ItemBean = inventoryStock_ItemBean;
    }

    public InventoryManufacturerBean getInventoryManufacturerBean() {
        return inventoryManufacturerBean;
    }

    public void setInventoryManufacturerBean(InventoryManufacturerBean inventoryManufacturerBean) {
        this.inventoryManufacturerBean = inventoryManufacturerBean;
    }

    public InventorySalesOrderItemBean getInventorySalesOrderItemBean() {
        return inventorySalesOrderItemBean;
    }

    public void setInventorySalesOrderItemBean(InventorySalesOrderItemBean inventorySalesOrderItemBean) {
        this.inventorySalesOrderItemBean = inventorySalesOrderItemBean;
    }

    public InventoryWarehouseBean getInventoryWarehouseBean() {
        return inventoryWarehouseBean;
    }

    public void setInventoryWarehouseBean(InventoryWarehouseBean inventoryWarehouseBean) {
        this.inventoryWarehouseBean = inventoryWarehouseBean;
    }

    public InventoryPurchaseOrderItemBean getPoiBean() {
        return poiBean;
    }

    public void setPoiBean(InventoryPurchaseOrderItemBean poiBean) {
        this.poiBean = poiBean;
    }

}
