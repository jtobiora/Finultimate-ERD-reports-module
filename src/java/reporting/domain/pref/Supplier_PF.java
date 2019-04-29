
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
@Table(name = "SUPPLIER")
public class Supplier_PF extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "SUPPLIER_NUMBER", columnDefinition = "Varchar2(15)")
    private String supplier_Number;

    @Column(name = "SUPPLIER_NAME", columnDefinition = "Varchar2(100)")
    private String supplier_Name;

    @Column(name = "SUPPLIER_PHONE", columnDefinition = "Varchar2(20)")
    private String supplier_Phone;

    @Column(name = "SUPPLIER_EMAIL", columnDefinition = "Varchar2(100)")
    private String supplier_Email;

    @Column(name = "SUPPLIER_WEBSITE", columnDefinition = "Varchar2(100)")
    private String supplier_Website;

    @Column(name = "PAYMENT_TERMS", columnDefinition = "Varchar2(256)")
    private String payment_Terms;

    @Column(name = "BUSINESS_LINE_ID", columnDefinition = "NUMBER(11)")
    private Integer business_Line_ID;

    @Column(name = "CURRENCY_CODE", columnDefinition = "Varchar2(3)")
    private String currency_Code;

    @Column(name = "COUNTRY_ID", columnDefinition = "NUMBER(11)")
    private Integer country_ID;

    @Column(name = "STATE_CODE", columnDefinition = "Varchar2(3)")
    private String state_Code;

    @Column(name = "CITY_ID", columnDefinition = "NUMBER(11)")
    private Integer city_ID;

    @Column(name = "STREET_ADDR", columnDefinition = "Varchar2(255)")
    private String street_Addr;

    @Column(name = "CREATOR", columnDefinition = "Varchar2(20)")
    private String creator;

    @Column(name = "CREATE_DATE", columnDefinition = "DATE")
    private Date create_Date;

    @Column(name = "APPROVAL_STATUS_ID", columnDefinition = "NUMBER(11)")
    private Integer approvalStatusID = 0;

    @Column(name = "APPROVER_NAME", columnDefinition = "Varchar2(60)")
    private transient String approver = "";

    @Column(name = "SUPPLIER_ID", columnDefinition = "NUMBER(11)")
    private Integer supplier_ID;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "VARCHAR(15)")
    private String account_Number;

    @Column(name = "ACCOUNT_NAME", columnDefinition = "Varchar2(100)")
    private String account_Name;

    @Column(name = "BANK_ID", columnDefinition = "NUMBER(11)")
    private Integer bank_ID;

    @Column(name = "SUPPLIER_REG_STATUS", columnDefinition = "NUMBER(11)")
    private Integer supplier_Reg_Status;

    public String getSupplier_Number() {
        return supplier_Number;
    }

    public void setSupplier_Number(String supplier_Number) {
        this.supplier_Number = supplier_Number;
    }

    public String getSupplier_Name() {
        return supplier_Name;
    }

    public void setSupplier_Name(String supplier_Name) {
        this.supplier_Name = supplier_Name;
    }

    public String getSupplier_Phone() {
        return supplier_Phone;
    }

    public void setSupplier_Phone(String supplier_Phone) {
        this.supplier_Phone = supplier_Phone;
    }

    public String getSupplier_Email() {
        return supplier_Email;
    }

    public void setSupplier_Email(String supplier_Email) {
        this.supplier_Email = supplier_Email;
    }

    public String getSupplier_Website() {
        return supplier_Website;
    }

    public void setSupplier_Website(String supplier_Website) {
        this.supplier_Website = supplier_Website;
    }

    public String getPayment_Terms() {
        return payment_Terms;
    }

    public void setPayment_Terms(String payment_Terms) {
        this.payment_Terms = payment_Terms;
    }

    public Integer getBusiness_Line_ID() {
        return business_Line_ID;
    }

    public void setBusiness_Line_ID(Integer business_Line_ID) {
        this.business_Line_ID = business_Line_ID;
    }

    public String getCurrency_Code() {
        return currency_Code;
    }

    public void setCurrency_Code(String currency_Code) {
        this.currency_Code = currency_Code;
    }

    public Integer getCountry_ID() {
        return country_ID;
    }

    public void setCountry_ID(Integer country_ID) {
        this.country_ID = country_ID;
    }

    public String getState_Code() {
        return state_Code;
    }

    public void setState_Code(String state_Code) {
        this.state_Code = state_Code;
    }

    public Integer getCity_ID() {
        return city_ID;
    }

    public void setCity_ID(Integer city_ID) {
        this.city_ID = city_ID;
    }

    public String getStreet_Addr() {
        return street_Addr;
    }

    public void setStreet_Addr(String street_Addr) {
        this.street_Addr = street_Addr;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
    }

    public Integer getApprovalStatusID() {
        return approvalStatusID;
    }

    public void setApprovalStatusID(Integer approvalStatusID) {
        this.approvalStatusID = approvalStatusID;
    }

    public Integer getSupplier_ID() {
        return supplier_ID;
    }

    public void setSupplier_ID(Integer supplier_ID) {
        this.supplier_ID = supplier_ID;
    }

    public String getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }

    public String getAccount_Name() {
        return account_Name;
    }

    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    public Integer getBank_ID() {
        return bank_ID;
    }

    public void setBank_ID(Integer bank_ID) {
        this.bank_ID = bank_ID;
    }

    public Integer getSupplier_Reg_Status() {
        return supplier_Reg_Status;
    }

    public void setSupplier_Reg_Status(Integer supplier_Reg_Status) {
        this.supplier_Reg_Status = supplier_Reg_Status;
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
