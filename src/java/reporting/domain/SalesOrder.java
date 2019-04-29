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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALES_ORDER")
public class SalesOrder extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "SALES_ORDER_ID", columnDefinition = "NUMBER(11)")
    private int salesOrderId;

    @Column(name = "ORDER_NUMBER", columnDefinition = "Varchar2(20)")
    private String orderNumber;

    @Column(name = "CLIENT_CODE", columnDefinition = "Varchar2(12)")
    private String clientCode;

    @Column(name = "ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double orderTotal;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currencyCode;

    @Column(name = "ORDER_DATE", columnDefinition = "DATE")
    private Date orderDate;

    @Column(name = "TRANSACT_ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double transactOrderTotal;

    @Column(name = "COST_OF_SALES", columnDefinition = "DOUBLE PRECISION")
    private double costOfSales;

    @Column(name = "COMMISSION_TYPE", columnDefinition = "NUMBER(11)")
    private int commissionType;

    @Column(name = "APPLY_COMM_TO_AGENT_TREE", columnDefinition = "NUMBER(11)")
    private int applyCommToAgentTree;

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entryDate;

    @Column(name = "AGENCY_ID", columnDefinition = "NUMBER(11)")
    private int agencyId;

    @Column(name = "COMMISSION_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double commissionAmount;

    @Column(name = "COMMISSION_RATE", columnDefinition = "DOUBLE PRECISION")
    private double commissionRate;

    @Column(name = "TOTAL_INSTALMENT", columnDefinition = "NUMBER(11)")
    private int totalInstalment;

    @Column(name = "LAST_INSTALMENT", columnDefinition = "NUMBER(11)")
    private int lastInstallment;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approverName;

    @Column(name = "MOBILE_NUMBER", columnDefinition = "Varchar2(20)")
    private String mobileNumber;

    @Column(name = "EMAIL_ADDRESS", columnDefinition = "Varchar2(150)")
    private String emailAddress;

    @Column(name = "PROMOTION_CODE", columnDefinition = "Varchar2(25)")
    private String promotionCode;

    @Column(name = "TOTAL_DISCOUNT", columnDefinition = "DOUBLE PRECISION")
    private double totalDiscount;

    @Column(name = "LOYALTY_POINTS", columnDefinition = "NUMBER(11)")
    private int loyaltyPoints;

    @Column(name = "LOYALTY_POINTS_DSCNT", columnDefinition = "DOUBLE PRECISION")
    private double loyaltyPointsDscnt;

    @Column(name = "NET_ORDER_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double netOrderTotal;

    @Column(name = "SHIPPING_METHOD_ID", columnDefinition = "NUMBER(11)")
    private int shippingMethodId;

    @Column(name = "SHIPPING_COST", columnDefinition = "DOUBLE PRECISION")
    private double shippingCost;

    @Column(name = "WAREHOUSE_ID", columnDefinition = "NUMBER(11)")
    private int warehouseId;

    @Column(name = "CREDIT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private int creditTypeId;

    @Column(name = "ACTION_STEP", columnDefinition = "NUMBER(11)")
    private int actionStep;

    @Column(name = "SALES_TRAN_TYP", columnDefinition = "NUMBER(11)")
    private int salesTranTyp;

    @Column(name = "SALES_TAX_AMT", columnDefinition = "DOUBLE PRECISION")
    private double salesTaxAmt;

    @Column(name = "SALES_DEGREE_TYPE", columnDefinition = "NUMBER(11)")
    private int salesDegreeType;

    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public SalesOrder(){
        
    }

    public int getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
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

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
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

    public double getTransactOrderTotal() {
        return transactOrderTotal;
    }

    public void setTransactOrderTotal(double transactOrderTotal) {
        this.transactOrderTotal = transactOrderTotal;
    }

    public double getCostOfSales() {
        return costOfSales;
    }

    public void setCostOfSales(double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public int getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(int commissionType) {
        this.commissionType = commissionType;
    }

    public int getApplyCommToAgentTree() {
        return applyCommToAgentTree;
    }

    public void setApplyCommToAgentTree(int applyCommToAgentTree) {
        this.applyCommToAgentTree = applyCommToAgentTree;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getTotalInstalment() {
        return totalInstalment;
    }

    public void setTotalInstalment(int totalInstalment) {
        this.totalInstalment = totalInstalment;
    }

    public int getLastInstallment() {
        return lastInstallment;
    }

    public void setLastInstallment(int lastInstallment) {
        this.lastInstallment = lastInstallment;
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

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getLoyaltyPointsDscnt() {
        return loyaltyPointsDscnt;
    }

    public void setLoyaltyPointsDscnt(double loyaltyPointsDscnt) {
        this.loyaltyPointsDscnt = loyaltyPointsDscnt;
    }

    public double getNetOrderTotal() {
        return netOrderTotal;
    }

    public void setNetOrderTotal(double netOrderTotal) {
        this.netOrderTotal = netOrderTotal;
    }

    public int getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(int shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(int creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    public int getActionStep() {
        return actionStep;
    }

    public void setActionStep(int actionStep) {
        this.actionStep = actionStep;
    }

    public int getSalesTranTyp() {
        return salesTranTyp;
    }

    public void setSalesTranTyp(int salesTranTyp) {
        this.salesTranTyp = salesTranTyp;
    }

    public double getSalesTaxAmt() {
        return salesTaxAmt;
    }

    public void setSalesTaxAmt(double salesTaxAmt) {
        this.salesTaxAmt = salesTaxAmt;
    }

    public int getSalesDegreeType() {
        return salesDegreeType;
    }

    public void setSalesDegreeType(int salesDegreeType) {
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
