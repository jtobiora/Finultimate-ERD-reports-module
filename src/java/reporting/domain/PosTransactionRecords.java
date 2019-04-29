/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "POS_TRANSACTION_RECORDS")
public class PosTransactionRecords extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(11)")
    private long posTransactionID;

    @Column(name = "TRANSACTION_DATE", columnDefinition = "DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "TRANSACTION_DISCOUNT", columnDefinition = "DOUBLE PRECISION")
    private double transactionDiscount;

    @Column(name = "OUTLET_NAME", columnDefinition = "Varchar2(255)")
    private String outletName;

    @Column(name = "TRANSACTION_PROMO_CODE", columnDefinition = "Varchar2(255)")
    private String transactionPromoCode;

    @Column(name = "TRANSACTION_RECIEPT_NUMBER", columnDefinition = "Varchar2(255)")
    private String transactionReceiptNumber;

    @Column(name = "TRANSACTION_REFERENCE", columnDefinition = "Varchar2(255)")
    private String transactionReference;

    @Column(name = "TRANSACTION_SALES_ORDER_NUMBER", columnDefinition = "Varchar2(255)")
    private String transactionSalesOrderNumber;

    @Column(name = "TRANSACTION_STATUS", columnDefinition = "Varchar2(255)")
    private String transactionStatus;

    @Column(name = "TRANSACTION_SUBTOTAL", columnDefinition = "DOUBLE PRECISION")
    private double transactionSubTotal;

    @Column(name = "TRANSACTION_TOTAL", columnDefinition = "DOUBLE PRECISION")
    private double transactionTotal;

    @Column(name = "TRANSACTION_BALANCE", columnDefinition = "DOUBLE PRECISION")
    private double transactionBalance;

    @Column(name = "TRANSACTION_NUMBER", columnDefinition = "Varchar2(255)")
    private String transactionNumber;

    @Column(name = "TRANSACTION_TYPE", columnDefinition = "Varchar2(255)")
    private String transactionType;

    @Column(name = "IN_SERVER", columnDefinition = "NUMBER(1)")
    private int inServer;

    @Column(name = "SESSIONENTITY_ID", columnDefinition = "NUMBER(20)")
    private int sessionEntityID;

    @Column(name = "CART_ID", columnDefinition = "NUMBER(20)")
    private int cartID;

    @Column(name = "TRANSACTION_CUSTOMER", columnDefinition = "Varchar2(255)")
    private String transactionCustomer;

    @Column(name = "REFUNDENTITY_ID", columnDefinition = "NUMBER(20)")
    private int refundentityID;

    @Column(name = "TRANSACTION_USER", columnDefinition = "NUMBER(20))")
    private int transactionUser;

    @Column(name = "REGISTER", columnDefinition = "Varchar2(255)")
    private String register;

    private transient int approvalStatusID = 0;

    private transient String approver = "";

    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();

    public PosTransactionRecords() {
        posTransactionID = 0;

    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
        return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * @return the transactionDiscount
     */
    public double getTransactionDiscount() {
        return transactionDiscount;
    }

    /**
     * @param transactionDiscount the transactionDiscount to set
     */
    public void setTransactionDiscount(double transactionDiscount) {
        this.transactionDiscount = transactionDiscount;
    }

    /**
     * @return the outletName
     */
    public String getOutletName() {
        return outletName;
    }

    /**
     * @param outletName the outletName to set
     */
    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    /**
     * @return the transactionPromoCode
     */
    public String getTransactionPromoCode() {
        return transactionPromoCode;
    }

    /**
     * @param transactionPromoCode the transactionPromoCode to set
     */
    public void setTransactionPromoCode(String transactionPromoCode) {
        this.transactionPromoCode = transactionPromoCode;
    }

    /**
     * @return the transactionReceiptNumber
     */
    public String getTransactionReceiptNumber() {
        return transactionReceiptNumber;
    }

    /**
     * @param transactionReceiptNumber the transactionReceiptNumber to set
     */
    public void setTransactionReceiptNumber(String transactionReceiptNumber) {
        this.transactionReceiptNumber = transactionReceiptNumber;
    }

    /**
     * @return the transactionReference
     */
    public String getTransactionReference() {
        return transactionReference;
    }

    /**
     * @param transactionReference the transactionReference to set
     */
    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    /**
     * @return the transactionSalesOrderNumber
     */
    public String getTransactionSalesOrderNumber() {
        return transactionSalesOrderNumber;
    }

    /**
     * @param transactionSalesOrderNumber the transactionSalesOrderNumber to set
     */
    public void setTransactionSalesOrderNumber(String transactionSalesOrderNumber) {
        this.transactionSalesOrderNumber = transactionSalesOrderNumber;
    }

    /**
     * @return the transactionStatus
     */
    public String getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * @param transactionStatus the transactionStatus to set
     */
    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    /**
     * @return the transactionSubTotal
     */
    public double getTransactionSubTotal() {
        return transactionSubTotal;
    }

    /**
     * @param transactionSubTotal the transactionSubTotal to set
     */
    public void setTransactionSubTotal(double transactionSubTotal) {
        this.transactionSubTotal = transactionSubTotal;
    }

    /**
     * @return the transactionTotal
     */
    public double getTransactionTotal() {
        return transactionTotal;
    }

    /**
     * @param transactionTotal the transactionTotal to set
     */
    public void setTransactionTotal(double transactionTotal) {
        this.transactionTotal = transactionTotal;
    }

    /**
     * @return the transactionBalance
     */
    public double getTransactionBalance() {
        return transactionBalance;
    }

    /**
     * @param transactionBalance the transactionBalance to set
     */
    public void setTransactionBalance(double transactionBalance) {
        this.transactionBalance = transactionBalance;
    }

    /**
     * @return the transactionNumber
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * @param transactionNumber the transactionNumber to set
     */
    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    

    /**
     * @return the inServer
     */
    public int getInServer() {
        return inServer;
    }

    /**
     * @param inServer the inServer to set
     */
    public void setInServer(int inServer) {
        this.inServer = inServer;
    }

    /**
     * @return the sessionEntityID
     */
    public int getSessionEntityID() {
        return sessionEntityID;
    }

    /**
     * @param sessionEntityID the sessionEntityID to set
     */
    public void setSessionEntityID(int sessionEntityID) {
        this.sessionEntityID = sessionEntityID;
    }

    

    /**
     * @return the transactionCustomer
     */
    public String getTransactionCustomer() {
        return transactionCustomer;
    }

    /**
     * @param transactionCustomer the transactionCustomer to set
     */
    public void setTransactionCustomer(String transactionCustomer) {
        this.transactionCustomer = transactionCustomer;
    }

    /**
     * @return the refundentityID
     */
    public int getRefundentityID() {
        return refundentityID;
    }

    /**
     * @param refundentityID the refundentityID to set
     */
    public void setRefundentityID(int refundentityID) {
        this.refundentityID = refundentityID;
    }

    /**
     * @return the transactionUser
     */
    public int getTransactionUser() {
        return transactionUser;
    }

    /**
     * @param transactionUser the transactionUser to set
     */
    public void setTransactionUser(int transactionUser) {
        this.transactionUser = transactionUser;
    }

    

    /**
     * @return the approvalStatusID
     */
    public int getApprovalStatusID() {
        return approvalStatusID;
    }

    /**
     * @param approvalStatusID the approvalStatusID to set
     */
    public void setApprovalStatusID(int approvalStatusID) {
        this.approvalStatusID = approvalStatusID;
    }

    /**
     * @return the approver
     */
    public String getApprover() {
        return approver;
    }

    /**
     * @param approver the approver to set
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * @return the actionTrail
     */
    public BusinessActionTrailEntity getActionTrail() {
        return actionTrail;
    }

    /**
     * @param actionTrail the actionTrail to set
     */
    public void setActionTrail(BusinessActionTrailEntity actionTrail) {
        this.actionTrail = actionTrail;
    }

    /**
     * @return the posTransactionID
     */
    public long getPosTransactionID() {
        return posTransactionID;
    }

    /**
     * @param posTransactionID the posTransactionID to set
     */
    public void setPosTransactionID(long posTransactionID) {
        this.posTransactionID = posTransactionID;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the register
     */
    public String getRegister() {
        return register;
    }

    /**
     * @param cartID the cartID to set
     */
    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    /**
     * @return the cartID
     */
    public int getCartID() {
        return cartID;
    }
}
