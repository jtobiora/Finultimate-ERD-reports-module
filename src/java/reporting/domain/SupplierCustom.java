/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reporting.domain;

import java.util.Date;

/**
 *
 * @author S3-Developer
 */
public class SupplierCustom {
    
    public SupplierCustom(){
        
    }
    
    private String supplier_Number;

    private String supplier_Name;

    private String supplier_Phone;

    private String supplier_Email;

    private String supplier_Website;

    private String payment_Terms;

    private int business_Line_ID;

    private String currency_Code;

    private int country_ID;

    private String state_Code;

    private int city_ID;

    private String street_Addr;

    private String creator;

    private Date create_Date;

    private int approvalStatusID = 0;

    private transient String approver = "";

    private int supplier_ID;

    private String account_Number;

    private String account_Name;

    private int bank_ID;

    private int supplier_Reg_Status;

    /**
     * @return the supplier_Number
     */
    public String getSupplier_Number() {
        return supplier_Number;
    }

    /**
     * @param supplier_Number the supplier_Number to set
     */
    public void setSupplier_Number(String supplier_Number) {
        this.supplier_Number = supplier_Number;
    }

    /**
     * @return the supplier_Name
     */
    public String getSupplier_Name() {
        return supplier_Name;
    }

    /**
     * @param supplier_Name the supplier_Name to set
     */
    public void setSupplier_Name(String supplier_Name) {
        this.supplier_Name = supplier_Name;
    }

    /**
     * @return the supplier_Phone
     */
    public String getSupplier_Phone() {
        return supplier_Phone;
    }

    /**
     * @param supplier_Phone the supplier_Phone to set
     */
    public void setSupplier_Phone(String supplier_Phone) {
        this.supplier_Phone = supplier_Phone;
    }

    /**
     * @return the supplier_Email
     */
    public String getSupplier_Email() {
        return supplier_Email;
    }

    /**
     * @param supplier_Email the supplier_Email to set
     */
    public void setSupplier_Email(String supplier_Email) {
        this.supplier_Email = supplier_Email;
    }

    /**
     * @return the supplier_Website
     */
    public String getSupplier_Website() {
        return supplier_Website;
    }

    /**
     * @param supplier_Website the supplier_Website to set
     */
    public void setSupplier_Website(String supplier_Website) {
        this.supplier_Website = supplier_Website;
    }

    /**
     * @return the payment_Terms
     */
    public String getPayment_Terms() {
        return payment_Terms;
    }

    /**
     * @param payment_Terms the payment_Terms to set
     */
    public void setPayment_Terms(String payment_Terms) {
        this.payment_Terms = payment_Terms;
    }

    /**
     * @return the business_Line_ID
     */
    public int getBusiness_Line_ID() {
        return business_Line_ID;
    }

    /**
     * @param business_Line_ID the business_Line_ID to set
     */
    public void setBusiness_Line_ID(int business_Line_ID) {
        this.business_Line_ID = business_Line_ID;
    }

    /**
     * @return the currency_Code
     */
    public String getCurrency_Code() {
        return currency_Code;
    }

    /**
     * @param currency_Code the currency_Code to set
     */
    public void setCurrency_Code(String currency_Code) {
        this.currency_Code = currency_Code;
    }

    /**
     * @return the country_ID
     */
    public int getCountry_ID() {
        return country_ID;
    }

    /**
     * @param country_ID the country_ID to set
     */
    public void setCountry_ID(int country_ID) {
        this.country_ID = country_ID;
    }

    /**
     * @return the state_Code
     */
    public String getState_Code() {
        return state_Code;
    }

    /**
     * @param state_Code the state_Code to set
     */
    public void setState_Code(String state_Code) {
        this.state_Code = state_Code;
    }

    /**
     * @return the city_ID
     */
    public int getCity_ID() {
        return city_ID;
    }

    /**
     * @param city_ID the city_ID to set
     */
    public void setCity_ID(int city_ID) {
        this.city_ID = city_ID;
    }

    /**
     * @return the street_Addr
     */
    public String getStreet_Addr() {
        return street_Addr;
    }

    /**
     * @param street_Addr the street_Addr to set
     */
    public void setStreet_Addr(String street_Addr) {
        this.street_Addr = street_Addr;
    }

    /**
     * @return the creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator the creator to set
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return the create_Date
     */
    public Date getCreate_Date() {
        return create_Date;
    }

    /**
     * @param create_Date the create_Date to set
     */
    public void setCreate_Date(Date create_Date) {
        this.create_Date = create_Date;
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
     * @return the supplier_ID
     */
    public int getSupplier_ID() {
        return supplier_ID;
    }

    /**
     * @param supplier_ID the supplier_ID to set
     */
    public void setSupplier_ID(int supplier_ID) {
        this.supplier_ID = supplier_ID;
    }

    /**
     * @return the account_Number
     */
    public String getAccount_Number() {
        return account_Number;
    }

    /**
     * @param account_Number the account_Number to set
     */
    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }

    /**
     * @return the account_Name
     */
    public String getAccount_Name() {
        return account_Name;
    }

    /**
     * @param account_Name the account_Name to set
     */
    public void setAccount_Name(String account_Name) {
        this.account_Name = account_Name;
    }

    /**
     * @return the bank_ID
     */
    public int getBank_ID() {
        return bank_ID;
    }

    /**
     * @param bank_ID the bank_ID to set
     */
    public void setBank_ID(int bank_ID) {
        this.bank_ID = bank_ID;
    }

    /**
     * @return the supplier_Reg_Status
     */
    public int getSupplier_Reg_Status() {
        return supplier_Reg_Status;
    }

    /**
     * @param supplier_Reg_Status the supplier_Reg_Status to set
     */
    public void setSupplier_Reg_Status(int supplier_Reg_Status) {
        this.supplier_Reg_Status = supplier_Reg_Status;
    }
}
