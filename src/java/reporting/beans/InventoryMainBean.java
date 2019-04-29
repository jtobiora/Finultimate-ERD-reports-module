package reporting.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import reporting.domain.ItemWarehouse;
import reporting.domain.Manufacturer;
import reporting.domain.StockItem;
import reporting.domain.StockItemUnit;
import reporting.enums.promotion.InvMeasureType;
import reporting.enums.promotion.InvReportType;
import reporting.util.InventoryReportFormat;

@javax.faces.bean.SessionScoped
@ManagedBean(name = "inventoryMainBean")
public class InventoryMainBean implements Serializable {

    @ManagedProperty(value = "#{inventoryStock_ItemBean}")
    private InventoryStock_ItemBean inventoryStock_ItemBean;

    @ManagedProperty(value = "#{InventoryStockItemUnitBean}")
    private InventoryStockItemUnitBean inventoryStockItemUnitBean;

    @ManagedProperty(value = "#{inventoryAuxillaryBean}")
    private InventoryAuxillaryBean auxillaryService;

    @ManagedProperty(value = "#{inventoryManufacturerBean}")
    private InventoryManufacturerBean inventoryManufacturerBean;

    @ManagedProperty(value = "#{inventoryWarehouseBean}")
    private InventoryWarehouseBean inventoryWarehouseBean;

    public InventoryMainBean() {
        inventoryStock_ItemBean = new InventoryStock_ItemBean();
        inventoryStockItemUnitBean = new InventoryStockItemUnitBean();
        auxillaryService = new InventoryAuxillaryBean();
        inventoryManufacturerBean = new InventoryManufacturerBean();
        inventoryWarehouseBean = new InventoryWarehouseBean();
    }

    public List<InventoryReportFormat> processReports(String criteria, Integer type, Date startDate, Date endDate) {
        if (type.equals(InvReportType.EXPIRY_lIST.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "expiry-list-report");

        } else if (type.equals(InvReportType.EXPIRY_lIST.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("expiry-list-report", startDate, endDate);

        } else if (type.equals(InvReportType.EXPIRY_lIST.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "expiry-list-report");

        } else if (type.equals(InvReportType.AVAILABILITY_REPORT.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "stock-availability-report");

        } else if (type.equals(InvReportType.AVAILABILITY_REPORT.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("stock-availability-report", startDate, endDate);

        } else if (type.equals(InvReportType.AVAILABILITY_REPORT.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

        } else if (type.equals(InvReportType.STOCK_AGING.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "stock-aging-report");

        } else if (type.equals(InvReportType.STOCK_AGING.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("stock-aging-report", startDate, endDate);

        } else if (type.equals(InvReportType.STOCK_AGING.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "stock-aging-report");

        } else if (type.equals(InvReportType.STOCK_VALUE.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "stock-value-report");

        } else if (type.equals(InvReportType.STOCK_VALUE.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("stock-value-report", startDate, endDate);

        } else if (type.equals(InvReportType.STOCK_VALUE.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "stock-value-report");

        } else if (type.equals(InvReportType.BEST_SELLING.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "best-selling-criteriasearch");

        } else if (type.equals(InvReportType.BEST_SELLING.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("best-selling-criteriasearch", startDate, endDate);

        } else if (type.equals(InvReportType.BEST_SELLING.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "best-selling-criteriasearch");

        } else if (type.equals(InvReportType.WORST_SELLING.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "worst-selling-criteriasearch");

        } else if (type.equals(InvReportType.WORST_SELLING.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("worst-selling-criteriasearch", startDate, endDate);

        } else if (type.equals(InvReportType.WORST_SELLING.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "worst-selling-criteriasearch");

        } else if (type.equals(InvReportType.BELOW_MIN_QTY.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.getItemNameReports(startDate, endDate, "below-min-qty");

        } else if (type.equals(InvReportType.BELOW_MIN_QTY.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.getBrandNameReports("below-min-qty", startDate, endDate);

        } else if (type.equals(InvReportType.BELOW_MIN_QTY.getValue())
                && criteria.equals(InvMeasureType.WAREHOUSE.getValue())) {

            return this.getWarehouseReports(startDate, endDate, "below-min-qty");

        } else if (type.equals(InvReportType.STOCK_MOVT.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {

            return this.trackInventoryMovement(startDate, endDate, "by-item");

        } else if (type.equals(InvReportType.STOCK_MOVT.getValue())
                && criteria.equals(InvMeasureType.BRAND_NAME.getValue())) {

            return this.trackInventoryMovement(startDate, endDate, "by-brand");

        } else if (type.equals(InvReportType.STOCK_LISTING.getValue())
                && criteria.equals(InvMeasureType.ITEM_NAME.getValue())) {
            return this.getItemNameReports(startDate, endDate, "inventory-listing");
        }

        return null;
    }

    public List<InventoryReportFormat> trackInventoryMovement(Date startDate, Date endDate, String category) {
        if (category.equals("by-item")) {
            return auxillaryService.viewStockMovementsByItem(startDate, endDate);
        } else {
            return auxillaryService.viewStockMovementsByBrand(startDate, endDate);
        }
          
    }

    //******************************* REPORTS BY ITEM-NAME *******************************************
    public List<InventoryReportFormat> getItemNameReports(Date startDate, Date endDate, String criteria) {
        List<InventoryReportFormat> report = new ArrayList<>();
        InventoryReportFormat content = auxillaryService.generateReportsByItemName(startDate, endDate, criteria);
        if (content == null) {
            return report;
        } else {
            report.add(content);
            return report;
        }
    }

    //************************************ REPORTS BY BRAND NAME ********************************************
    public List<InventoryReportFormat> getBrandNameReports(String type, Date startDate, Date endDate) {
        List<InventoryReportFormat> brandList = new ArrayList<>();

        List<Manufacturer> brand = null;

        List<StockItemUnit> siUnit = null;
        switch (type) {
            case "best-selling-criteriasearch":
            case "worst-selling-criteriasearch":
                return auxillaryService.processBestAndWorstSellingProductsByBrand(startDate, endDate, type);
            case "stock-availability-report":
                List<StockItemUnit> itemUnitList = inventoryStockItemUnitBean.getProductsAvailable();
                return auxillaryService.viewAvailableBrands(itemUnitList);
            case "below-min-qty":
                brand = inventoryManufacturerBean.getBrandNamesOfCurrentInventoryItems(startDate, endDate);
                if (brand.isEmpty()) {
                    return brandList;
                }
                siUnit = inventoryStockItemUnitBean.getInventoryItemsUsingOrderLevel(startDate, endDate);
                break;
            default:
                brand = inventoryManufacturerBean.getBrandNamesOfCurrentInventoryItems(startDate, endDate);
                if (brand.isEmpty()) {
                    return brandList;
                }
                siUnit = inventoryStockItemUnitBean.getInventoryItems(startDate, endDate);
                break;
        }

        Set<Integer> ids = siUnit.stream().map(StockItemUnit::getStock_item_id).collect(toSet());
        List<StockItem> sItem = inventoryStock_ItemBean.getStockItemUsingParamList(ids);
        Set<Integer> brandId = sItem.stream().map(StockItem::getManufacturer_id).collect(toSet());
        List<Manufacturer> distinctBrands = brand.stream().filter(f -> brandId.contains(f.getManufacturer_id())).collect(toList());
        for (Manufacturer manufacturer : distinctBrands) {
            List<StockItem> si = sItem.stream().filter(s -> Integer.valueOf(s.getManufacturer_id()).equals(manufacturer.getManufacturer_id())).collect(toList());
            List<Integer> sid = si.stream().map(StockItem::getStock_item_id).collect(toList());
            List<StockItemUnit> siu = siUnit.stream().filter(s -> sid.contains(s.getStock_item_id())).collect(toList());

            brandList.add(auxillaryService.fetchBrandReport(startDate, endDate, siu, si, type, manufacturer));

        }
        return brandList;

    }

    //************************************* REPORTS BY WAREHOUSE ********************************************
    public List<InventoryReportFormat> getWarehouseReports(Date startDate, Date endDate, String criteria) {
        List<InventoryReportFormat> warehouseList = new ArrayList<>();

        // 1. Get all the warehouses available
        List<ItemWarehouse> warehouses = inventoryWarehouseBean.findAllWarehouses();

        // 1a Get all the warehouse id's
        List<Integer> list = warehouses.stream().map(ItemWarehouse::getWarehouseid).collect(toList());

        // 2 Check the criteria specified 
        List<StockItemUnit> unprocessedStocks = null;
        switch (criteria) {
            case "best-selling-criteriasearch":
            case "worst-selling-criteriasearch":
                return auxillaryService.processBestAndWorstSellingByWarehouse(startDate, endDate,
                        criteria);

            case "below-min-qty":
                unprocessedStocks = inventoryStockItemUnitBean.getInventoryItemsUsingOrderLevel(startDate, endDate);
                break;
            case "stock-availability-report":
                return null;
            default:
                unprocessedStocks = inventoryStockItemUnitBean.getInventoryItems(startDate, endDate);
                break;
        }

        List<StockItemUnit> stocksInWarehouse = unprocessedStocks.stream().filter(f -> list.contains(f.getWarehouse_id())).collect(toList());
        List<Integer> unitId = stocksInWarehouse.stream().map(StockItemUnit::getWarehouse_id).collect(toList());

        //4. filter all the warehouses that have stocks
        Set<ItemWarehouse> distinctWarehouses = warehouses.stream().filter(p -> unitId.contains(p.getWarehouseid())).collect(toSet());

        // 5. for each distinct warehouse, process the stocks in it or return
        // null if warehouse is empty
        if (distinctWarehouses.isEmpty()) {
            return warehouseList;
        } else {
            distinctWarehouses.stream().forEach(warehouse -> {
                List<StockItemUnit> units = auxillaryService.filterStream(stocksInWarehouse,
                        siu -> Integer.valueOf(siu.getWarehouse_id()).equals(warehouse.getWarehouseid()));

                System.out.println(units);
                warehouseList.add(auxillaryService.generateInventoryReportByWarehouse(startDate, endDate, criteria,
                        units, warehouse));
            });
        }

        return warehouseList;

    }

    public InventoryStock_ItemBean getInventoryStock_ItemBean() {
        return inventoryStock_ItemBean;
    }

    public void setInventoryStock_ItemBean(InventoryStock_ItemBean inventoryStock_ItemBean) {
        this.inventoryStock_ItemBean = inventoryStock_ItemBean;
    }

    public InventoryStockItemUnitBean getInventoryStockItemUnitBean() {
        return inventoryStockItemUnitBean;
    }

    public void setInventoryStockItemUnitBean(InventoryStockItemUnitBean inventoryStockItemUnitBean) {
        this.inventoryStockItemUnitBean = inventoryStockItemUnitBean;
    }

    public InventoryAuxillaryBean getAuxillaryService() {
        return auxillaryService;
    }

    public void setAuxillaryService(InventoryAuxillaryBean auxillaryService) {
        this.auxillaryService = auxillaryService;
    }

    public InventoryManufacturerBean getInventoryManufacturerBean() {
        return inventoryManufacturerBean;
    }

    public void setInventoryManufacturerBean(InventoryManufacturerBean inventoryManufacturerBean) {
        this.inventoryManufacturerBean = inventoryManufacturerBean;
    }

    public InventoryWarehouseBean getInventoryWarehouseBean() {
        return inventoryWarehouseBean;
    }

    public void setInventoryWarehouseBean(InventoryWarehouseBean inventoryWarehouseBean) {
        this.inventoryWarehouseBean = inventoryWarehouseBean;
    }

}
