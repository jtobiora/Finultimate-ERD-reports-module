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
@Table(name="POLICY_SETTLEMENT")
public class PolicySettlement extends AbstractEntity implements Serializable{
    
    @Id
    @Column(name = "SETTLEMENT_ID", columnDefinition = "NUMBER(11)")
    private int settlement_id;
    
    @Column(name = "REFERENCE_NUMBER", columnDefinition = "Varchar2(20)")
    private String reference_number;

    @Column(name = "SETTLEMENT_CODE", columnDefinition = "Varchar2(20)")
    private String settlement_code;

    @Column(name = "SETTLEMENT_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private double settlement_amount;

    @Column(name = "INSTALMENT_NUMBER", columnDefinition = "NUMBER(11)")
    private int installment_number;

    @Column(name = "EXPENSE_DESC", columnDefinition = "Varchar2(256)")
    private String expense_desc;

    @Column(name = "DR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String dr_acct_code;
    
    @Column(name = "CR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String cr_acct_code;

    @Column(name = "ENTRY_DATE", columnDefinition = "DATE")
    private Date entry_date;

    @Column(name = "GRP_SETTLEMENT_CODE", columnDefinition = "Varchar2(20)")
    private String grp_settlement_code;

    @Column(name = "INSTAL_START_DATE", columnDefinition = "DATE")
    private Date instal_start_date;

    @Column(name = "INSTAL_END_DATE", columnDefinition = "DATE")
    private Date instalEndDate;

    @Column(name = "BANK_CODE", columnDefinition = "Varchar2(10)")
    private String bank_code;
    
    @Column(name = "ACCOUNT_NAME", columnDefinition = "Varchar2(100)")
    private String account_name;

    @Column(name = "ACCT_NUMBER", columnDefinition = "Varchar2(25)")
    private String acct_number;

    @Column(name = "SETTLEMENT_TYPE", columnDefinition = "NUMBER(11)")
    private int settlement_type;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private int approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver;

    @Column(name = "PAYOUT_STATUS", columnDefinition = "NUMBER(11)")
    private int payout_status;
    
    public PolicySettlement(){
        
    }

    public int getSettlement_id() {
        return settlement_id;
    }

    public void setSettlement_id(int settlement_id) {
        this.settlement_id = settlement_id;
    }

    public String getReference_number() {
        return reference_number;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    public String getSettlement_code() {
        return settlement_code;
    }

    public void setSettlement_code(String settlement_code) {
        this.settlement_code = settlement_code;
    }

    public double getSettlement_amount() {
        return settlement_amount;
    }

    public void setSettlement_amount(double settlement_amount) {
        this.settlement_amount = settlement_amount;
    }

    public int getInstallment_number() {
        return installment_number;
    }

    public void setInstallment_number(int installment_number) {
        this.installment_number = installment_number;
    }

    public String getExpense_desc() {
        return expense_desc;
    }

    public void setExpense_desc(String expense_desc) {
        this.expense_desc = expense_desc;
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

    public String getGrp_settlement_code() {
        return grp_settlement_code;
    }

    public void setGrp_settlement_code(String grp_settlement_code) {
        this.grp_settlement_code = grp_settlement_code;
    }

    public Date getInstal_start_date() {
        return instal_start_date;
    }

    public void setInstal_start_date(Date instal_start_date) {
        this.instal_start_date = instal_start_date;
    }

    public Date getInstalEndDate() {
        return instalEndDate;
    }

    public void setInstalEndDate(Date instalEndDate) {
        this.instalEndDate = instalEndDate;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAcct_number() {
        return acct_number;
    }

    public void setAcct_number(String acct_number) {
        this.acct_number = acct_number;
    }

    public int getSettlement_type() {
        return settlement_type;
    }

    public void setSettlement_type(int settlement_type) {
        this.settlement_type = settlement_type;
    }

    public int getApproval_status_id() {
        return approval_status_id;
    }

    public void setApproval_status_id(int approval_status_id) {
        this.approval_status_id = approval_status_id;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public int getPayout_status() {
        return payout_status;
    }

    public void setPayout_status(int payout_status) {
        this.payout_status = payout_status;
    }

    public EntityOperatorHolder getOperatorHolder() {
        return operatorHolder;
    }

    public void setOperatorHolder(EntityOperatorHolder operatorHolder) {
        this.operatorHolder = operatorHolder;
    }

    
}
