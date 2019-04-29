/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author S3-Developer
 */
@Entity
@Table(name="PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "PO_ITEM_ID", columnDefinition = "NUMBER(11)")
    private int po_Item_ID;
    
    @Column(name = "PURCHASE_ORDER_ID", columnDefinition = "NUMBER(11)")
    private int purchase_order_id;

    @Column(name = "ITEM_DESC", columnDefinition = "Varchar2(255)")
    private String item_desc;

    @Column(name = "UNIT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private int unit_type_ID;

    @Column(name = "QUANTITY", columnDefinition = "NUMBER(11)")
    private int quantity;

    @Column(name = "UNIT_PRICE", columnDefinition = "DOUBLE PRECISION")
    private double unit_price;

    @Column(name = "AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double amount;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver_name;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private int stock_item_ID;

    @Column(name = "BASE_AMOUNT", columnDefinition = "NUMBER(11)")
    private int base_Amount;

    @Column(name = "EXECUTED_QUANTITY", columnDefinition = "NUMBER(11)")
    private int executed_Quantity;

    @Column(name = "EXECUTED_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double executed_Amount;
    
    @Column(name = "BALANCE_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double balance_Amount;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_Code;

    @Column(name = "DEPARTMENT_ID", columnDefinition = "NUMBER(11)")
    private int department_ID;

    @Column(name = "YR_BUDGET_ID", columnDefinition = "NUMBER(11)")
    private int yr_budget_ID;

    @Column(name = "MONTH_BUDGET_ID", columnDefinition = "NUMBER(11)")
    private String month_budget_ID;

    @Column(name = "PROCUREMENT_TYPE", columnDefinition = "NUMBER(11)")
    private int procurement_type;

    @Column(name = "STOCK_ITEM_NAME", columnDefinition = "Varchar2(150)")
    private String stock_Item_Name;

    @Column(name = "SUPPLIER_ID", columnDefinition = "NUMBER(11)")
    private int supplier_ID;

    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    public PurchaseOrderItem() {
        
    }

    public int getPo_Item_ID() {
        return po_Item_ID;
    }

    public void setPo_Item_ID(int po_Item_ID) {
        this.po_Item_ID = po_Item_ID;
    }

    public int getPurchase_order_id() {
        return purchase_order_id;
    }

    public void setPurchase_order_id(int purchase_order_id) {
        this.purchase_order_id = purchase_order_id;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public int getUnit_type_ID() {
        return unit_type_ID;
    }

    public void setUnit_type_ID(int unit_type_ID) {
        this.unit_type_ID = unit_type_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(int approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public String getApprover_name() {
        return approver_name;
    }

    public void setApprover_name(String approver_name) {
        this.approver_name = approver_name;
    }

    public int getStock_item_ID() {
        return stock_item_ID;
    }

    public void setStock_item_ID(int stock_item_ID) {
        this.stock_item_ID = stock_item_ID;
    }

    public int getBase_Amount() {
        return base_Amount;
    }

    public void setBase_Amount(int base_Amount) {
        this.base_Amount = base_Amount;
    }

    public int getExecuted_Quantity() {
        return executed_Quantity;
    }

    public void setExecuted_Quantity(int executed_Quantity) {
        this.executed_Quantity = executed_Quantity;
    }

    public double getExecuted_Amount() {
        return executed_Amount;
    }

    public void setExecuted_Amount(double executed_Amount) {
        this.executed_Amount = executed_Amount;
    }

    public double getBalance_Amount() {
        return balance_Amount;
    }

    public void setBalance_Amount(double balance_Amount) {
        this.balance_Amount = balance_Amount;
    }

    public String getCurrency_Code() {
        return currency_Code;
    }

    public void setCurrency_Code(String currency_Code) {
        this.currency_Code = currency_Code;
    }

    public int getDepartment_ID() {
        return department_ID;
    }

    public void setDepartment_ID(int department_ID) {
        this.department_ID = department_ID;
    }

    public int getYr_budget_ID() {
        return yr_budget_ID;
    }

    public void setYr_budget_ID(int yr_budget_ID) {
        this.yr_budget_ID = yr_budget_ID;
    }

    public String getMonth_budget_ID() {
        return month_budget_ID;
    }

    public void setMonth_budget_ID(String month_budget_ID) {
        this.month_budget_ID = month_budget_ID;
    }

    public int getProcurement_type() {
        return procurement_type;
    }

    public void setProcurement_type(int procurement_type) {
        this.procurement_type = procurement_type;
    }

    public String getStock_Item_Name() {
        return stock_Item_Name;
    }

    public void setStock_Item_Name(String stock_Item_Name) {
        this.stock_Item_Name = stock_Item_Name;
    }

    public int getSupplier_ID() {
        return supplier_ID;
    }

    public void setSupplier_ID(int supplier_ID) {
        this.supplier_ID = supplier_ID;
    }

    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
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
