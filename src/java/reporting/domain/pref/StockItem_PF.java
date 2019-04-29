
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
@Table(name="STOCK_ITEM")
public class StockItem_PF extends AbstractEntity implements Serializable{
     @Id
    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_item_id;
    
    @Column(name = "STOCK_ITEM_NAME", columnDefinition = "Varchar2(100)")
    private String stock_item_name;
    
    @Column(name = "STOCK_ITEM_DESC", columnDefinition = "Varchar2(256)")
    private String stock_item_desc;

    @Column(name = "STOCK_ITEM_VERSION", columnDefinition = "Varchar2(100)")
    private String stock_item_version;

    @Column(name = "ITEM_CATEGORY_ID", columnDefinition = "NUMBER(11)")
    private Integer item_category_id;
    
    @Column(name = "ITEM_TYPE_ID", columnDefinition = "NUMBER(11)")
    private Integer item_type_id;
    
    @Column(name = "MANUFACTURER_ID", columnDefinition = "NUMBER(11)")
    private Integer manufacturer_id;
    
    @Column(name = "IMAGE_FILE_NAME", columnDefinition = "Varchar2(255)")
    private String image_file_name;
    
    @Column(name = "QUANTITY", columnDefinition = "DOUBLE PRECISION")
    private Double quantity;

    @Column(name = "LAST_UPDATE_DATE", columnDefinition = "DATE")
    private Date last_update_date;

    @Column(name = "REORDER_LEVEL", columnDefinition = "NUMBER(11)")
    private Integer reorder_level;
    
    @Column(name = "MAXIMUM_LEVEL", columnDefinition = "NUMBER(11)")
    private Integer maximum_level;
    
    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouse_id;
    
    @Column(name = "SECTION_ID", columnDefinition = "NUMBER(11)")
    private Integer section_id;
    
    @Column(name = "SHELF_ID", columnDefinition = "NUMBER(11)")
    private Integer shelf_id;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;
    
    @Column(name = "UNIT_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double unit_price;
    
    @Column(name = "TOTAL_PURCHASE_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double total_purchase_price;
    
    @Column(name = "AVERAGE_PURCHASE_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double average_purchase_price;
    
    @Column(name = "TOTAL_SELLING_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double total_selling_price;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_code;

    @Column(name = "BARCODE_NUMBER", columnDefinition = "Varchar2(20)")
    private String barcode_number;
    
    @Column(name = "UNIT_MEASURE", columnDefinition = "DOUBLE PRECISION")
    private Double unit_measure;
    
    @Column(name = "UNIT_OF_MEASURE_ID", columnDefinition = "NUMBER(11)")
    private Integer unit_of_measure_id;
    
    @Column(name = "UNIT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private Integer unit_type_id;
    
    @Column(name = "NUMBER_OF_ITEMS", columnDefinition = "NUMBER(11)")
    private Integer number_of_items;

    @Column(name = "CONTRA_INDICATION", columnDefinition = "Varchar2(650)")
    private String contra_indication;

    @Column(name = "STOCK_ASMBLY_TYP", columnDefinition = "NUMBER(11)")
    private Integer stock_asmbly_typ;
    
    @Column(name = "STOCK_SALES_TAX", columnDefinition = "DOUBLE PRECISION")
    private Double stock_sales_tax;
    
    @Column(name = "ITEM_GENERIC_NAME", columnDefinition = "NUMBER(11)")
    private String item_generic_name;

    public Integer getStock_item_id() {
        return stock_item_id;
    }

    public void setStock_item_id(Integer stock_item_id) {
        this.stock_item_id = stock_item_id;
    }

    public String getStock_item_name() {
        return stock_item_name;
    }

    public void setStock_item_name(String stock_item_name) {
        this.stock_item_name = stock_item_name;
    }

    public String getStock_item_desc() {
        return stock_item_desc;
    }

    public void setStock_item_desc(String stock_item_desc) {
        this.stock_item_desc = stock_item_desc;
    }

    public String getStock_item_version() {
        return stock_item_version;
    }

    public void setStock_item_version(String stock_item_version) {
        this.stock_item_version = stock_item_version;
    }

    public Integer getItem_category_id() {
        return item_category_id;
    }

    public void setItem_category_id(Integer item_category_id) {
        this.item_category_id = item_category_id;
    }

    public Integer getItem_type_id() {
        return item_type_id;
    }

    public void setItem_type_id(Integer item_type_id) {
        this.item_type_id = item_type_id;
    }

    public Integer getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    public String getImage_file_name() {
        return image_file_name;
    }

    public void setImage_file_name(String image_file_name) {
        this.image_file_name = image_file_name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public Integer getReorder_level() {
        return reorder_level;
    }

    public void setReorder_level(Integer reorder_level) {
        this.reorder_level = reorder_level;
    }

    public Integer getMaximum_level() {
        return maximum_level;
    }

    public void setMaximum_level(Integer maximum_level) {
        this.maximum_level = maximum_level;
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

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getTotal_purchase_price() {
        return total_purchase_price;
    }

    public void setTotal_purchase_price(Double total_purchase_price) {
        this.total_purchase_price = total_purchase_price;
    }

    public Double getAverage_purchase_price() {
        return average_purchase_price;
    }

    public void setAverage_purchase_price(Double average_purchase_price) {
        this.average_purchase_price = average_purchase_price;
    }

    public Double getTotal_selling_price() {
        return total_selling_price;
    }

    public void setTotal_selling_price(Double total_selling_price) {
        this.total_selling_price = total_selling_price;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getBarcode_number() {
        return barcode_number;
    }

    public void setBarcode_number(String barcode_number) {
        this.barcode_number = barcode_number;
    }

    public Double getUnit_measure() {
        return unit_measure;
    }

    public void setUnit_measure(Double unit_measure) {
        this.unit_measure = unit_measure;
    }

    public Integer getUnit_of_measure_id() {
        return unit_of_measure_id;
    }

    public void setUnit_of_measure_id(Integer unit_of_measure_id) {
        this.unit_of_measure_id = unit_of_measure_id;
    }

    public Integer getUnit_type_id() {
        return unit_type_id;
    }

    public void setUnit_type_id(Integer unit_type_id) {
        this.unit_type_id = unit_type_id;
    }

    public Integer getNumber_of_items() {
        return number_of_items;
    }

    public void setNumber_of_items(Integer number_of_items) {
        this.number_of_items = number_of_items;
    }

    public String getContra_indication() {
        return contra_indication;
    }

    public void setContra_indication(String contra_indication) {
        this.contra_indication = contra_indication;
    }

    public Integer getStock_asmbly_typ() {
        return stock_asmbly_typ;
    }

    public void setStock_asmbly_typ(Integer stock_asmbly_typ) {
        this.stock_asmbly_typ = stock_asmbly_typ;
    }

    public Double getStock_sales_tax() {
        return stock_sales_tax;
    }

    public void setStock_sales_tax(Double stock_sales_tax) {
        this.stock_sales_tax = stock_sales_tax;
    }

    public String getItem_generic_name() {
        return item_generic_name;
    }

    public void setItem_generic_name(String item_generic_name) {
        this.item_generic_name = item_generic_name;
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
