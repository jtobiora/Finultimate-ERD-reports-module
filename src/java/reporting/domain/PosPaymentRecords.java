/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamix.abstractobjects.AbstractEntity;
import com.rsdynamix.dynamo.common.entities.BusinessActionTrailEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="POS_PAYMENT_RECORDS")
public class PosPaymentRecords extends AbstractEntity implements Serializable{
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER(20)")
    private int posPaymentRecordID;
    
    @Column(name = "PAYMENT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double paymentAmount;
    
    @Column(name = "BANK_TRANSACTION_NO", columnDefinition = "Varchar2(255)")
    private String bankTransactionNumber;
    
    @Column(name = "CARD_NO", columnDefinition = "Varchar2(255)")
    private String cardNo;
    
    @Column(name = "PAYMENT_METHOD", columnDefinition = "NUMBER(11)")
    private int paymentMethod;
    
    @Column(name = "SALES_TRANSACTION_NO", columnDefinition = "Varchar2(225)")
    private String salesTransactionNo;
    
    @Column(name = "TRANSACTION_ID", columnDefinition = "NUMBER(20)")
    private int transactionID;
    
    @Column(name = "BANK_ID", columnDefinition = "NUMBER(20)")
    private int bankID;
    
    private transient int approvalStatusID = 0;
    
    private transient String approver = "";
    
    //
    private transient BusinessActionTrailEntity actionTrail = new BusinessActionTrailEntity();
    
    public PosPaymentRecords() {
        posPaymentRecordID = 0;
        
    }

    /**
     * @return the posPaymentRecordID
     */
    public int getPosPaymentRecordID() {
        return posPaymentRecordID;
    }

    /**
     * @param posPaymentRecordID the posPaymentRecordID to set
     */
    public void setPosPaymentRecordID(int posPaymentRecordID) {
        this.posPaymentRecordID = posPaymentRecordID;
    }

    /**
     * @return the paymentAmount
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return the bankTransactionNumber
     */
    public String getBankTransactionNumber() {
        return bankTransactionNumber;
    }

    /**
     * @param bankTransactionNumber the bankTransactionNumber to set
     */
    public void setBankTransactionNumber(String bankTransactionNumber) {
        this.bankTransactionNumber = bankTransactionNumber;
    }

    /**
     * @return the cardNo
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo the cardNo to set
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * @return the paymentMethod
     */
    public int getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the salesTransactionNo
     */
    public String getSalesTransactionNo() {
        return salesTransactionNo;
    }

    /**
     * @param salesTransactionNo the salesTransactionNo to set
     */
    public void setSalesTransactionNo(String salesTransactionNo) {
        this.salesTransactionNo = salesTransactionNo;
    }

    /**
     * @return the transactionID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    /**
     * @return the bankID
     */
    public int getBankID() {
        return bankID;
    }

    /**
     * @param bankID the bankID to set
     */
    public void setBankID(int bankID) {
        this.bankID = bankID;
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
}
