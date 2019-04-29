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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALES_ORDER_ITEM")
public class SalesOrderItem extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID", columnDefinition = "NUMBER(11)")
    private int orderItemId;

    @Column(name = "SALES_ORDER_ID", columnDefinition = "NUMBER(11)")
    private int salesOrderId;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private int stockItemId;

    @Column(name = "QUANTITY", columnDefinition = "DOUBLE PRECISION")
    private double quantity;

    @Column(name = "UNIT_PRICE", columnDefinition = "DOUBLE PRECISION")
    private double unitPrice;

    @Column(name = "AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double amount;

    @Column(name = "LOYALTY_POINTS", columnDefinition = "NUMBER(11)")
    private int loyaltyPoints;

    @Column(name = "DISCOUNT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double discountAmount;

    @Column(name = "TRANSACT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double transactAmount;

    @Column(name = "COST_OF_SALES", columnDefinition = "DOUBLE PRECISION")
    private double costOfSales;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currencyCode;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approverName;

    @Column(name = "STOCK_ITEM_UNIT_ID", columnDefinition = "NUMBER(11)")
    private int stockItemUnitId;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private int warehouseId;

    @Column(name = "COST_OF_STOCK", columnDefinition = "DOUBLE PRECISION")
    private double costOfStock;

    @Column(name = "COMMISSION_RATE", columnDefinition = "DOUBLE PRECISION")
    private double commissionRate;

    @Column(name = "AGENT_COMMISSION", columnDefinition = "DOUBLE PRECISION")
    private double agentCommission;

    @Column(name = "PARENT_ORDER_ITEM_ID", columnDefinition = "NUMBER(11)")
    private int parentOrderItemId;

    @Column(name = "SALES_TAX_AMT", columnDefinition = "DOUBLE PRECISION")
    private double salesTaxAmt;

    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public SalesOrderItem(){
    
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public int getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(int stockItemId) {
        this.stockItemId = stockItemId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getTransactAmount() {
        return transactAmount;
    }

    public void setTransactAmount(double transactAmount) {
        this.transactAmount = transactAmount;
    }

    public double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getApprovalStatusId() {
        return approvalStatusId;
    }

    public void setApprovalStatusId(int approvalStatusId) {
        this.approvalStatusId = approvalStatusId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public int getStockItemUnitId() {
        return stockItemUnitId;
    }

    public void setStockItemUnitId(int stockItemUnitId) {
        this.stockItemUnitId = stockItemUnitId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getCostOfStock() {
        return costOfStock;
    }

    public void setCostOfStock(double costOfStock) {
        this.costOfStock = costOfStock;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(double agentCommission) {
        this.agentCommission = agentCommission;
    }

    public int getParentOrderItemId() {
        return parentOrderItemId;
    }

    public void setParentOrderItemId(int parentOrderItemId) {
        this.parentOrderItemId = parentOrderItemId;
    }

    public double getSalesTaxAmt() {
        return salesTaxAmt;
    }

    public void setSalesTaxAmt(double salesTaxAmt) {
        this.salesTaxAmt = salesTaxAmt;
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
