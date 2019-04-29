
package reporting.domain.pref;

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
public class SalesOrderItem_PF extends AbstractEntity implements Serializable {
        @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer orderItemId;

    @Column(name = "SALES_ORDER_ID", columnDefinition = "NUMBER(11)")
    private Integer salesOrderId;

    @Column(name = "STOCK_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer stockItemId;

    @Column(name = "QUANTITY", columnDefinition = "DOUBLE PRECISION")
    private Double quantity;

    @Column(name = "UNIT_PRICE", columnDefinition = "DOUBLE PRECISION")
    private Double unitPrice;

    @Column(name = "AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double amount;

    @Column(name = "LOYALTY_POINTS", columnDefinition = "NUMBER(11)")
    private Integer loyaltyPoints;

    @Column(name = "DISCOUNT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double discountAmount;

    @Column(name = "TRANSACT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double transactAmount;

    @Column(name = "COST_OF_SALES", columnDefinition = "DOUBLE PRECISION")
    private Double costOfSales;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currencyCode;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approverName;

    @Column(name = "STOCK_ITEM_UNIT_ID", columnDefinition = "NUMBER(11)")
    private Integer stockItemUnitId;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouseId;

    @Column(name = "COST_OF_STOCK", columnDefinition = "DOUBLE PRECISION")
    private Double costOfStock;

    @Column(name = "COMMISSION_RATE", columnDefinition = "DOUBLE PRECISION")
    private Double commissionRate;

    @Column(name = "AGENT_COMMISSION", columnDefinition = "DOUBLE PRECISION")
    private Double agentCommission;

    @Column(name = "PARENT_ORDER_ITEM_ID", columnDefinition = "NUMBER(11)")
    private Integer parentOrderItemId;

    @Column(name = "SALES_TAX_AMT", columnDefinition = "DOUBLE PRECISION")
    private Double salesTaxAmt;

    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getTransactAmount() {
        return transactAmount;
    }

    public void setTransactAmount(Double transactAmount) {
        this.transactAmount = transactAmount;
    }

    public Double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(Double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getApprovalStatusId() {
        return approvalStatusId;
    }

    public void setApprovalStatusId(Integer approvalStatusId) {
        this.approvalStatusId = approvalStatusId;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public Integer getStockItemUnitId() {
        return stockItemUnitId;
    }

    public void setStockItemUnitId(Integer stockItemUnitId) {
        this.stockItemUnitId = stockItemUnitId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Double getCostOfStock() {
        return costOfStock;
    }

    public void setCostOfStock(Double costOfStock) {
        this.costOfStock = costOfStock;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Double getAgentCommission() {
        return agentCommission;
    }

    public void setAgentCommission(Double agentCommission) {
        this.agentCommission = agentCommission;
    }

    public Integer getParentOrderItemId() {
        return parentOrderItemId;
    }

    public void setParentOrderItemId(Integer parentOrderItemId) {
        this.parentOrderItemId = parentOrderItemId;
    }

    public Double getSalesTaxAmt() {
        return salesTaxAmt;
    }

    public void setSalesTaxAmt(Double salesTaxAmt) {
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
