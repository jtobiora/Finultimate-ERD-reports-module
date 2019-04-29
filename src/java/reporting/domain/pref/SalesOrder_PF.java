
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SALES_ORDER")
public class SalesOrder_PF extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "SALES_ORDER_ID", columnDefinition = "NUMBER(11)")
    private Integer salesOrderId;

    @Column(name = "ORDER_NUMBER", columnDefinition = "Varchar2(20)")
    private String orderNumber;

    @Column(name = "CLIENT_CODE", columnDefinition = "Varchar2(12)")
    private String clientCode;

    @Column(name = "ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private Double orderTotal;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currencyCode;

    @Column(name = "ORDER_DATE", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "TRANSACT_ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private Double transactOrderTotal;

    @Column(name = "COST_OF_SALES", columnDefinition = "DOUBLE PRECISION")
    private Double costOfSales;

    @Column(name = "COMMISSION_TYPE", columnDefinition = "NUMBER(11)")
    private Integer commissionType;

    @Column(name = "APPLY_COMM_TO_AGENT_TREE", columnDefinition = "NUMBER(11)")
    private Integer applyCommToAgentTree;

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entryDate;

    @Column(name = "AGENCY_ID", columnDefinition = "NUMBER(11)")
    private Integer agencyId;

    @Column(name = "COMMISSION_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double commissionAmount;

    @Column(name = "COMMISSION_RATE", columnDefinition = "DOUBLE PRECISION")
    private Double commissionRate;

    @Column(name = "TOTAL_INSTALMENT", columnDefinition = "NUMBER(11)")
    private Integer totalInstalment;

    @Column(name = "LAST_INSTALMENT", columnDefinition = "NUMBER(11)")
    private Integer lastInstallment;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approverName;

    @Column(name = "MOBILE_NUMBER", columnDefinition = "Varchar2(20)")
    private String mobileNumber;

    @Column(name = "EMAIL_ADDRESS", columnDefinition = "Varchar2(150)")
    private String emailAddress;

    @Column(name = "PROMOTION_CODE", columnDefinition = "Varchar2(25)")
    private String promotionCode;

    @Column(name = "TOTAL_DISCOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double totalDiscount;

    @Column(name = "LOYALTY_POINTS", columnDefinition = "NUMBER(11)")
    private Integer loyaltyPoints;

    @Column(name = "LOYALTY_POINTS_DSCNT", columnDefinition = "DOUBLE PRECISION")
    private Double loyaltyPointsDscnt;

    @Column(name = "NET_ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private Double netOrderTotal;

    @Column(name = "SHIPPING_METHOD_ID", columnDefinition = "NUMBER(11)")
    private Integer shippingMethodId;

    @Column(name = "SHIPPING_COST", columnDefinition = "DOUBLE PRECISION")
    private Double shippingCost;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private Integer warehouseId;

    @Column(name = "CREDIT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private Integer creditTypeId;

    @Column(name = "ACTION_STEP", columnDefinition = "NUMBER(11)")
    private Integer actionStep;

    @Column(name = "SALES_TRAN_TYP", columnDefinition = "NUMBER(11)")
    private Integer salesTranTyp;

    @Column(name = "SALES_TAX_AMT", columnDefinition = "DOUBLE PRECISION")
    private Double salesTaxAmt;

    @Column(name = "SALES_DEGREE_TYPE", columnDefinition = "NUMBER(11)")
    private Integer salesDegreeType;

    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public Integer getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Integer salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTransactOrderTotal() {
        return transactOrderTotal;
    }

    public void setTransactOrderTotal(Double transactOrderTotal) {
        this.transactOrderTotal = transactOrderTotal;
    }

    public Double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(Double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public Integer getApplyCommToAgentTree() {
        return applyCommToAgentTree;
    }

    public void setApplyCommToAgentTree(Integer applyCommToAgentTree) {
        this.applyCommToAgentTree = applyCommToAgentTree;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getTotalInstalment() {
        return totalInstalment;
    }

    public void setTotalInstalment(Integer totalInstalment) {
        this.totalInstalment = totalInstalment;
    }

    public Integer getLastInstallment() {
        return lastInstallment;
    }

    public void setLastInstallment(Integer lastInstallment) {
        this.lastInstallment = lastInstallment;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public Double getLoyaltyPointsDscnt() {
        return loyaltyPointsDscnt;
    }

    public void setLoyaltyPointsDscnt(Double loyaltyPointsDscnt) {
        this.loyaltyPointsDscnt = loyaltyPointsDscnt;
    }

    public Double getNetOrderTotal() {
        return netOrderTotal;
    }

    public void setNetOrderTotal(Double netOrderTotal) {
        this.netOrderTotal = netOrderTotal;
    }

    public Integer getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Integer shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(Integer creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    public Integer getActionStep() {
        return actionStep;
    }

    public void setActionStep(Integer actionStep) {
        this.actionStep = actionStep;
    }

    public Integer getSalesTranTyp() {
        return salesTranTyp;
    }

    public void setSalesTranTyp(Integer salesTranTyp) {
        this.salesTranTyp = salesTranTyp;
    }

    public Double getSalesTaxAmt() {
        return salesTaxAmt;
    }

    public void setSalesTaxAmt(Double salesTaxAmt) {
        this.salesTaxAmt = salesTaxAmt;
    }

    public Integer getSalesDegreeType() {
        return salesDegreeType;
    }

    public void setSalesDegreeType(Integer salesDegreeType) {
        this.salesDegreeType = salesDegreeType;
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
