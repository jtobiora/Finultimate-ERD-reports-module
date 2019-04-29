
package reporting.domain.pref;

import com.rsdynamics.projects.query.operators.EntityOperatorHolder;
import com.rsdynamix.abstractobjects.AbstractEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_REQ")
public class PaymentRequisition_PF extends AbstractEntity implements Serializable{
     @Id
    @Column(name = "REQUISITION_NO", columnDefinition = "Varchar2(20)")
    private String requisition_no;
    
    @Column(name = "TOTAL_REQUISITION_AMT", columnDefinition = "DOUBLE PRECISION")
    private Double total_requisition_number;

    @Column(name = "REQUISITION_DATE", columnDefinition = "DATE")
    private Date requisition_date;

    @Column(name = "PAYMENT_RECEIPT_NO", columnDefinition = "VARCHAR(15)")
    private String payment_receipt_no;

    @Column(name = "PAYMENT_DATE", columnDefinition = "DATE")
    private Date payment_date;
    
    @Column(name = "PAYMENT_AMT", columnDefinition = "PRECISION DOUBLE")
    private Double payment_amt;

    @Column(name = "CLAIM_NO", columnDefinition = "Varchar2(20)")
    private String claim_no;

    @Column(name = "DR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String dr_acct_code;

    @Column(name = "CR_ACCT_CODE", columnDefinition = "Varchar2(20)")
    private String cr_acct_code;
    
    @Column(name = "NARRATION", columnDefinition = "Varchar2(100)")
    private String narration;

    @Column(name = "PAYEE", columnDefinition = "Varchar2(100)")
    private String payee;

    @Column(name = "TOTAL_OUTSTANDING_AMT", columnDefinition = "DOUBLE PRECISION")
    private Double total_outstanding_amt;

    @Column(name = "APPROVAL_STATE_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_state_id;
    
    @Column(name = "APPROVED_BY", columnDefinition = "Varchar2(50)")
    private String approver;

    @Column(name = "SETTLEMENT_TYPE", columnDefinition = "NUMBER(11)")
    private Integer settlement_type;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_id;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver_name;
    
    @Column(name = "PAYEE_TYPE", columnDefinition = "Varchar2(50)")
    private String payee_type;

    public String getRequisition_no() {
        return requisition_no;
    }

    public void setRequisition_no(String requisition_no) {
        this.requisition_no = requisition_no;
    }

    public Double getTotal_requisition_number() {
        return total_requisition_number;
    }

    public void setTotal_requisition_number(Double total_requisition_number) {
        this.total_requisition_number = total_requisition_number;
    }

    public Date getRequisition_date() {
        return requisition_date;
    }

    public void setRequisition_date(Date requisition_date) {
        this.requisition_date = requisition_date;
    }

    public String getPayment_receipt_no() {
        return payment_receipt_no;
    }

    public void setPayment_receipt_no(String payment_receipt_no) {
        this.payment_receipt_no = payment_receipt_no;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Double getPayment_amt() {
        return payment_amt;
    }

    public void setPayment_amt(Double payment_amt) {
        this.payment_amt = payment_amt;
    }

    public String getClaim_no() {
        return claim_no;
    }

    public void setClaim_no(String claim_no) {
        this.claim_no = claim_no;
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

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public Double getTotal_outstanding_amt() {
        return total_outstanding_amt;
    }

    public void setTotal_outstanding_amt(Double total_outstanding_amt) {
        this.total_outstanding_amt = total_outstanding_amt;
    }

    public Integer getApproval_state_id() {
        return approval_state_id;
    }

    public void setApproval_state_id(Integer approval_state_id) {
        this.approval_state_id = approval_state_id;
    }

    public Integer getSettlement_type() {
        return settlement_type;
    }

    public void setSettlement_type(Integer settlement_type) {
        this.settlement_type = settlement_type;
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

    public String getPayee_type() {
        return payee_type;
    }

    public void setPayee_type(String payee_type) {
        this.payee_type = payee_type;
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
