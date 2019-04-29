/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author S3-Developer
 */
@Entity
@Table(name="PAYMENT")
public class Payment extends AbstractEntity implements Serializable{
    
    @Id
    @Column(name = "PAYMENT_CODE", columnDefinition = "Varchar2(20)")
    private String payment_code;
    
    @Column(name = "REQUISTION_NUMBER", columnDefinition = "Varchar2(20)")
    private String requisition_number;
    
    @Column(name = "AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double amount;

    @Column(name = "PAYMENT_DATE", columnDefinition = "DATE")
    private Date payment_date;

    @Column(name = "FULL_NAME", columnDefinition = "Varchar2(100)")
    private String full_name;

    @Column(name = "CHEQUE_NUMBER", columnDefinition = "Varchar2(20)")
    private String cheque_number;
    
    @Column(name = "BANK_CODE", columnDefinition = "Varchar2(10)")
    private String bankCode;

    @Column(name = "BANK_SORT_CODE", columnDefinition = "Varchar2(10)")
    private String bank_sort_code;

    @Column(name = "STAFF_CODE", columnDefinition = "Varchar2(20)")
    private String staff_code;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_code;

    @Column(name = "DR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String dr_acct_code;
    
    @Column(name = "CR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String cr_acct_code;

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entry_date;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approvalStatusId;

    @Column(name = "APPROVER_NAME", columnDefinition = "VARCHAR(60)")
    private String approver;

    @Column(name = "PROCESSED_REQS", columnDefinition = "NUMBER(11)")
    private int processed_reqs;
    
    @Column(name = "FAILED_REQS", columnDefinition = "NUMBER(11)")
    private int failed_reqs;

    @Column(name = "ACTUAL_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double actual_amount;

    @Column(name = "PAYMENT_TYPE_ID", columnDefinition = "NUMBER(11)")
    private int payment_type_id;

    @Column(name = "BUDGET_ENTRY_ID", columnDefinition = "NUMBER(11)")
    private int budget_entry_id;

    @Column(name = "INSTALMENT_START_DATE", columnDefinition = "DATE")
    private Date instalment_start_date;
    
    @Column(name = "INSTALMENT_END_DATE", columnDefinition = "DATE")
    private Date instalment_end_date;
    
    @Column(name = "TRANSACT_EARNING_TYP", columnDefinition = "NUMBER(11)")
    private int transact_earning_typ;
    
    @Column(name = "PAY_FREQ_TYPE", columnDefinition = "NUMBER(11)")
    private int pay_freq_type;

   public Payment(){
       
   }

    public String getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(String payment_code) {
        this.payment_code = payment_code;
    }

    public String getRequisition_number() {
        return requisition_number;
    }

    public void setRequisition_number(String requisition_number) {
        this.requisition_number = requisition_number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCheque_number() {
        return cheque_number;
    }

    public void setCheque_number(String cheque_number) {
        this.cheque_number = cheque_number;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBank_sort_code() {
        return bank_sort_code;
    }

    public void setBank_sort_code(String bank_sort_code) {
        this.bank_sort_code = bank_sort_code;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getDr_acct_code() {
        return dr_acct_code;
    }

    public void setDr_acct_code(String dr_acct_code) {
        this.dr_acct_code = dr_acct_code;
    }

    public String getCr_acct_code() {
        return cr_acct_code;
    }

    public void setCr_acct_code(String cr_acct_code) {
        this.cr_acct_code = cr_acct_code;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public int getApprovalStatusId() {
        return approvalStatusId;
    }

    public void setApprovalStatusId(int approvalStatusId) {
        this.approvalStatusId = approvalStatusId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public int getProcessed_reqs() {
        return processed_reqs;
    }

    public void setProcessed_reqs(int processed_reqs) {
        this.processed_reqs = processed_reqs;
    }

    public int getFailed_reqs() {
        return failed_reqs;
    }

    public void setFailed_reqs(int failed_reqs) {
        this.failed_reqs = failed_reqs;
    }

    public double getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(double actual_amount) {
        this.actual_amount = actual_amount;
    }

    public int getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(int payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public int getBudget_entry_id() {
        return budget_entry_id;
    }

    public void setBudget_entry_id(int budget_entry_id) {
        this.budget_entry_id = budget_entry_id;
    }

    public Date getInstalment_start_date() {
        return instalment_start_date;
    }

    public void setInstalment_start_date(Date instalment_start_date) {
        this.instalment_start_date = instalment_start_date;
    }

    public Date getInstalment_end_date() {
        return instalment_end_date;
    }

    public void setInstalment_end_date(Date instalment_end_date) {
        this.instalment_end_date = instalment_end_date;
    }

    public int getTransact_earning_typ() {
        return transact_earning_typ;
    }

    public void setTransact_earning_typ(int transact_earning_typ) {
        this.transact_earning_typ = transact_earning_typ;
    }

    public int getPay_freq_type() {
        return pay_freq_type;
    }

    public void setPay_freq_type(int pay_freq_type) {
        this.pay_freq_type = pay_freq_type;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

   
}
