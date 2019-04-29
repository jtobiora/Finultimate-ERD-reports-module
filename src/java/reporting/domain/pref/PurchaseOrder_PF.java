
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
@Table(name="PURCHASE_ORDER")
public class PurchaseOrder_PF extends AbstractEntity implements Serializable{

    @Id
    @Column(name = "PURCHASE_ORDER_ID", columnDefinition = "NUMBER(11)")
    private Integer po_ID;
    
    @Column(name = "PURCHASE_ORDER_CODE", columnDefinition = "Varchar2(20)")
    private String purchase_order_code;

    @Column(name = "PURCHASE_ORDER_DESC", columnDefinition = "Varchar2(100)")
    private String purchase_order_desc;

    @Column(name = "PURCHASE_ORDER_DATE", columnDefinition = "DATE")
    private Date purchase_order_date;

    @Column(name = "AGREED_DELIVERY_DATE", columnDefinition = "DATE")
    private Date agreed_delivery_date;

    @Column(name = "TOTAL_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double total_amount;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_code;

    @Column(name = "SUPPLIER_ID", columnDefinition = "Varchar2(15)")
    private String supplier_ID;

    @Column(name = "DELIVERY_COUNTRY_ID", columnDefinition = "NUMBER(11)")
    private Integer delivery_country_ID;

    @Column(name = "DELIVERY_CITY_ID", columnDefinition = "NUMBER(11)")
    private Integer delivery_city_ID;

    @Column(name = "DELIVERY_STATE_CODE", columnDefinition = "Varchar2(15)")
    private String deliveryStateCode;
    
    @Column(name = "DELIVERY_ADDRESS", columnDefinition = "Varchar2(256)")
    private String delivery_address;

    @Column(name = "ORDER_INITIATOR", columnDefinition = "Varchar2(60)")
    private String order_initiator;

    @Column(name = "APPROVAL_REQUESTED", columnDefinition = "NUMBER(11)")
    private Integer approval_requested;
    
    @Column(name = "APPROVED", columnDefinition = "NUMBER(11)")
    private Integer approved;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE")
    private Date create_date;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approval_status_ID;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private String approver_name;

    @Column(name = "TOTAL_EXECUTED_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double total_executed_amount;

    @Column(name = "TOTAL_BALANCE_AMOUNT", columnDefinition = "DOUBLE PRECISION")
    private Double total_balance_amount;

    @Column(name = "PRICING_TYPE", columnDefinition = "NUMBER(11)")
    private Integer pricing_type;

    @Column(name = "PROCUREMENT_TYPE", columnDefinition = "NUMBER(11)")
    private Integer procurement_type;
    
    @Column(name = "ACTION_STEP", columnDefinition = "NUMBER(11)")
    private Integer action_step;

    @Column(name = "JOB_REQ_ID", columnDefinition = "NUMBER(11)")
    private Integer job_req_ID;

    @Column(name = "VENDOR_MULTPCT_TYPE", columnDefinition = "NUMBER(11)")
    private Integer vendor_multipct_type;

    public Integer getPo_ID() {
        return po_ID;
    }

    public void setPo_ID(Integer po_ID) {
        this.po_ID = po_ID;
    }

    public String getPurchase_order_code() {
        return purchase_order_code;
    }

    public void setPurchase_order_code(String purchase_order_code) {
        this.purchase_order_code = purchase_order_code;
    }

    public String getPurchase_order_desc() {
        return purchase_order_desc;
    }

    public void setPurchase_order_desc(String purchase_order_desc) {
        this.purchase_order_desc = purchase_order_desc;
    }

    public Date getPurchase_order_date() {
        return purchase_order_date;
    }

    public void setPurchase_order_date(Date purchase_order_date) {
        this.purchase_order_date = purchase_order_date;
    }

    public Date getAgreed_delivery_date() {
        return agreed_delivery_date;
    }

    public void setAgreed_delivery_date(Date agreed_delivery_date) {
        this.agreed_delivery_date = agreed_delivery_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getSupplier_ID() {
        return supplier_ID;
    }

    public void setSupplier_ID(String supplier_ID) {
        this.supplier_ID = supplier_ID;
    }

    public Integer getDelivery_country_ID() {
        return delivery_country_ID;
    }

    public void setDelivery_country_ID(Integer delivery_country_ID) {
        this.delivery_country_ID = delivery_country_ID;
    }

    public Integer getDelivery_city_ID() {
        return delivery_city_ID;
    }

    public void setDelivery_city_ID(Integer delivery_city_ID) {
        this.delivery_city_ID = delivery_city_ID;
    }

    public String getDeliveryStateCode() {
        return deliveryStateCode;
    }

    public void setDeliveryStateCode(String deliveryStateCode) {
        this.deliveryStateCode = deliveryStateCode;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getOrder_initiator() {
        return order_initiator;
    }

    public void setOrder_initiator(String order_initiator) {
        this.order_initiator = order_initiator;
    }

    public Integer getApproval_requested() {
        return approval_requested;
    }

    public void setApproval_requested(Integer approval_requested) {
        this.approval_requested = approval_requested;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Integer getApproval_status_ID() {
        return approval_status_ID;
    }

    public void setApproval_status_ID(Integer approval_status_ID) {
        this.approval_status_ID = approval_status_ID;
    }

    public String getApprover_name() {
        return approver_name;
    }

    public void setApprover_name(String approver_name) {
        this.approver_name = approver_name;
    }

    public Double getTotal_executed_amount() {
        return total_executed_amount;
    }

    public void setTotal_executed_amount(Double total_executed_amount) {
        this.total_executed_amount = total_executed_amount;
    }

    public Double getTotal_balance_amount() {
        return total_balance_amount;
    }

    public void setTotal_balance_amount(Double total_balance_amount) {
        this.total_balance_amount = total_balance_amount;
    }

    public Integer getPricing_type() {
        return pricing_type;
    }

    public void setPricing_type(Integer pricing_type) {
        this.pricing_type = pricing_type;
    }

    public Integer getProcurement_type() {
        return procurement_type;
    }

    public void setProcurement_type(Integer procurement_type) {
        this.procurement_type = procurement_type;
    }

    public Integer getAction_step() {
        return action_step;
    }

    public void setAction_step(Integer action_step) {
        this.action_step = action_step;
    }

    public Integer getJob_req_ID() {
        return job_req_ID;
    }

    public void setJob_req_ID(Integer job_req_ID) {
        this.job_req_ID = job_req_ID;
    }

    public Integer getVendor_multipct_type() {
        return vendor_multipct_type;
    }

    public void setVendor_multipct_type(Integer vendor_multipct_type) {
        this.vendor_multipct_type = vendor_multipct_type;
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
