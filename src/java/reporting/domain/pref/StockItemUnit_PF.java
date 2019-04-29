
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_ITEM_UNIT")
public class StockItemUnit_PF extends AbstractEntity implements Serializable {
   @Id
    @Column(name = "STOCK_UNIT_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_unit_item_id;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_item_id;

    @Column(name = "STOCK_BATCH_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_batch_id;

    @Column(name = "SUPPLIER_ID", columnDefinition = "Varchar2(15)")
    private String supplier_id;

    @Column(name = "STOCK_ITEM_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double stock_item_price;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(10)")
    private String currency_code;

    @Column(name = "PO_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer po_item_id;

    @Column(name = "BARCODE_NUMBER", columnDefinition = "Varchar2(20)")
    private String barcode_number;

    @Column(name = "MANUF_SERIAL_NO", columnDefinition = "Varchar2(20)")
    private String manuf_serial_no;

    @Column(name = "MANUFACTURE_DATE", columnDefinition = "DATE")
    private Date manufacture_date;

    @Column(name = "EXPIRY_DATE", columnDefinition = "DATE")
    private Date expiry_date;

    @Column(name = "PRODUCTION_PLANT_LOC", columnDefinition = "Varchar2(25)")
    private String item_type_id;

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entry_date;

    @Column(name = "SELLING_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double selling_price;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouse_id;

    @Column(name = "SECTION_ID", columnDefinition = "NUMBER(11)")
    private Integer section_id;

    @Column(name = "QUANTITY", columnDefinition = "DOUBLE PRECISION")
    private Double quantity;

    @Column(name = "SHELF_ID", columnDefinition = "NUMBER(11)")
    private Integer shelf_id;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;

    @Column(name = "ADDITIONAL_COST", columnDefinition = "DOUBLE PRECISION")
    private Double additional_cost;

    @Column(name = "WEIGHT_FACTR", columnDefinition = "DOUBLE PRECISION")
    private Double weight_factr;

    @Column(name = "ACTIVE_DATE", columnDefinition = "DATE")
    private Date active_date;

    @Column(name = "COUNTED_QUANTITY", columnDefinition = "DOUBLE PRECISION")
    private Double counted_quantity;

    private transient String revenueEarned;

  
    private transient Double qtyOfItemsSold;

    public Integer getStock_unit_item_id() {
        return stock_unit_item_id;
    }

    public void setStock_unit_item_id(Integer stock_unit_item_id) {
        this.stock_unit_item_id = stock_unit_item_id;
    }

    public Integer getStock_item_id() {
        return stock_item_id;
    }

    public void setStock_item_id(Integer stock_item_id) {
        this.stock_item_id = stock_item_id;
    }

    public Integer getStock_batch_id() {
        return stock_batch_id;
    }

    public void setStock_batch_id(Integer stock_batch_id) {
        this.stock_batch_id = stock_batch_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Double getStock_item_price() {
        return stock_item_price;
    }

    public void setStock_item_price(Double stock_item_price) {
        this.stock_item_price = stock_item_price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public Integer getPo_item_id() {
        return po_item_id;
    }

    public void setPo_item_id(Integer po_item_id) {
        this.po_item_id = po_item_id;
    }

    public String getBarcode_number() {
        return barcode_number;
    }

    public void setBarcode_number(String barcode_number) {
        this.barcode_number = barcode_number;
    }

    public String getManuf_serial_no() {
        return manuf_serial_no;
    }

    public void setManuf_serial_no(String manuf_serial_no) {
        this.manuf_serial_no = manuf_serial_no;
    }

    public Date getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(Date manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getItem_type_id() {
        return item_type_id;
    }

    public void setItem_type_id(String item_type_id) {
        this.item_type_id = item_type_id;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(Integer shelf_id) {
        this.shelf_id = shelf_id;
    }

    public Integer getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(Integer approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public Double getAdditional_cost() {
        return additional_cost;
    }

    public void setAdditional_cost(Double additional_cost) {
        this.additional_cost = additional_cost;
    }

    public Double getWeight_factr() {
        return weight_factr;
    }

    public void setWeight_factr(Double weight_factr) {
        this.weight_factr = weight_factr;
    }

    public Date getActive_date() {
        return active_date;
    }

    public void setActive_date(Date active_date) {
        this.active_date = active_date;
    }

    public Double getCounted_quantity() {
        return counted_quantity;
    }

    public void setCounted_quantity(Double counted_quantity) {
        this.counted_quantity = counted_quantity;
    }

    public String getRevenueEarned() {
        return revenueEarned;
    }

    public void setRevenueEarned(String revenueEarned) {
        this.revenueEarned = revenueEarned;
    }

    public Double getQtyOfItemsSold() {
        return qtyOfItemsSold;
    }

    public void setQtyOfItemsSold(Double qtyOfItemsSold) {
        this.qtyOfItemsSold = qtyOfItemsSold;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

    
    
    @Override
    public void setApprover(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
