
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem_PF extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "PO_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer po_Item_ID;
    
    @Column(name = "PURCHASE_ORDER_ID", columnDefinition = "NUMBER(11)")
    private Integer purchase_order_id;

    @Column(name = "ITEM_DESC", columnDefinition = "Varchar2(255)")
    private String item_desc;

    @Column(name = "UNIT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private Integer unit_type_ID;

    @Column(name = "QUANTITY", columnDefinition = "NUMBER(11)")
    private Integer quantity;

    @Column(name = "UNIT_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double unit_price;

    @Column(name = "AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double amount;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver_name;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stock_item_ID;

    @Column(name = "BASE_AMOUNT", columnDefinition = "NUMBER(11)")
    private Integer base_Amount;

    @Column(name = "EXECUTED_QUANTITY", columnDefinition = "NUMBER(11)")
    private Integer executed_Quantity;

    @Column(name = "EXECUTED_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double executed_Amount;
    
    @Column(name = "BALANCE_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double balance_Amount;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_Code;

    @Column(name = "DEPARTMENT_ID", columnDefinition = "NUMBER(11)")
    private Integer department_ID;

    @Column(name = "YR_BUDGET_ID", columnDefinition = "NUMBER(11)")
    private Integer yr_budget_ID;

    @Column(name = "MONTH_BUDGET_ID", columnDefinition = "NUMBER(11)")
    private String month_budget_ID;

    @Column(name = "PROCUREMENT_TYPE", columnDefinition = "NUMBER(11)")
    private Integer procurement_type;

    @Column(name = "STOCK_ITEM_NAME", columnDefinition = "Varchar2(150)")
    private String stock_Item_Name;

    @Column(name = "SUPPLIER_ID", columnDefinition = "NUMBER(11)")
    private Integer supplier_ID;

    public Integer getPo_Item_ID() {
        return po_Item_ID;
    }

    public void setPo_Item_ID(Integer po_Item_ID) {
        this.po_Item_ID = po_Item_ID;
    }

    public Integer getPurchase_order_id() {
        return purchase_order_id;
    }

    public void setPurchase_order_id(Integer purchase_order_id) {
        this.purchase_order_id = purchase_order_id;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public Integer getUnit_type_ID() {
        return unit_type_ID;
    }

    public void setUnit_type_ID(Integer unit_type_ID) {
        this.unit_type_ID = unit_type_ID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(Integer approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public String getApprover_name() {
        return approver_name;
    }

    public void setApprover_name(String approver_name) {
        this.approver_name = approver_name;
    }

    public Integer getStock_item_ID() {
        return stock_item_ID;
    }

    public void setStock_item_ID(Integer stock_item_ID) {
        this.stock_item_ID = stock_item_ID;
    }

    public Integer getBase_Amount() {
        return base_Amount;
    }

    public void setBase_Amount(Integer base_Amount) {
        this.base_Amount = base_Amount;
    }

    public Integer getExecuted_Quantity() {
        return executed_Quantity;
    }

    public void setExecuted_Quantity(Integer executed_Quantity) {
        this.executed_Quantity = executed_Quantity;
    }

    public Double getExecuted_Amount() {
        return executed_Amount;
    }

    public void setExecuted_Amount(Double executed_Amount) {
        this.executed_Amount = executed_Amount;
    }

    public Double getBalance_Amount() {
        return balance_Amount;
    }

    public void setBalance_Amount(Double balance_Amount) {
        this.balance_Amount = balance_Amount;
    }

    public String getCurrency_Code() {
        return currency_Code;
    }

    public void setCurrency_Code(String currency_Code) {
        this.currency_Code = currency_Code;
    }

    public Integer getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(Integer department_ID) {
        this.department_ID = department_ID;
    }

    public Integer getYr_budget_ID() {
        return yr_budget_ID;
    }

    public void setYr_budget_ID(Integer yr_budget_ID) {
        this.yr_budget_ID = yr_budget_ID;
    }

    public String getMonth_budget_ID() {
        return month_budget_ID;
    }

    public void setMonth_budget_ID(String month_budget_ID) {
        this.month_budget_ID = month_budget_ID;
    }

    public Integer getProcurement_type() {
        return procurement_type;
    }

    public void setProcurement_type(Integer procurement_type) {
        this.procurement_type = procurement_type;
    }

    public String getStock_Item_Name() {
        return stock_Item_Name;
    }

    public void setStock_Item_Name(String stock_Item_Name) {
        this.stock_Item_Name = stock_Item_Name;
    }

    public Integer getSupplier_ID() {
        return supplier_ID;
    }

    public void setSupplier_ID(Integer supplier_ID) {
        this.supplier_ID = supplier_ID;
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
