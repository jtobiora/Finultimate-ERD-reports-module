
package CommandCenter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tenancyLicenseDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tenancyLicenseDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="applicationID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="applicationLogoBytes" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="applicationLogoFile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billingOptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billingTypeID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="billingTypeOptionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="numberOfRegisteredUsers" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="onboardingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tenancyLicenseID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tenancyStatusType" type="{http://services.licensing.business.s3systems.com/}tenancyStatusType" minOccurs="0"/>
 *         &lt;element name="tenantID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalBillAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tenancyLicenseDTO", propOrder = {
    "applicationID",
    "applicationLogoBytes",
    "applicationLogoFile",
    "applicationName",
    "billingOptionName",
    "billingTypeID",
    "billingTypeOptionID",
    "currencyCode",
    "expiryDate",
    "numberOfRegisteredUsers",
    "onboardingDate",
    "tenancyLicenseID",
    "tenancyStatusType",
    "tenantID",
    "totalBillAmount"
})
public class TenancyLicenseDTO {

    protected long applicationID;
    protected byte[] applicationLogoBytes;
    protected String applicationLogoFile;
    protected String applicationName;
    protected String billingOptionName;
    protected long billingTypeID;
    protected long billingTypeOptionID;
    protected String currencyCode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    protected long numberOfRegisteredUsers;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar onboardingDate;
    protected long tenancyLicenseID;
    protected TenancyStatusType tenancyStatusType;
    protected long tenantID;
    protected double totalBillAmount;

    /**
     * Gets the value of the applicationID property.
     * 
     */
    public long getApplicationID() {
        return applicationID;
    }

    /**
     * Sets the value of the applicationID property.
     * 
     */
    public void setApplicationID(long value) {
        this.applicationID = value;
    }

    /**
     * Gets the value of the applicationLogoBytes property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getApplicationLogoBytes() {
        return applicationLogoBytes;
    }

    /**
     * Sets the value of the applicationLogoBytes property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setApplicationLogoBytes(byte[] value) {
        this.applicationLogoBytes = value;
    }

    /**
     * Gets the value of the applicationLogoFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationLogoFile() {
        return applicationLogoFile;
    }

    /**
     * Sets the value of the applicationLogoFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationLogoFile(String value) {
        this.applicationLogoFile = value;
    }

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the billingOptionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingOptionName() {
        return billingOptionName;
    }

    /**
     * Sets the value of the billingOptionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingOptionName(String value) {
        this.billingOptionName = value;
    }

    /**
     * Gets the value of the billingTypeID property.
     * 
     */
    public long getBillingTypeID() {
        return billingTypeID;
    }

    /**
     * Sets the value of the billingTypeID property.
     * 
     */
    public void setBillingTypeID(long value) {
        this.billingTypeID = value;
    }

    /**
     * Gets the value of the billingTypeOptionID property.
     * 
     */
    public long getBillingTypeOptionID() {
        return billingTypeOptionID;
    }

    /**
     * Sets the value of the billingTypeOptionID property.
     * 
     */
    public void setBillingTypeOptionID(long value) {
        this.billingTypeOptionID = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the numberOfRegisteredUsers property.
     * 
     */
    public long getNumberOfRegisteredUsers() {
        return numberOfRegisteredUsers;
    }

    /**
     * Sets the value of the numberOfRegisteredUsers property.
     * 
     */
    public void setNumberOfRegisteredUsers(long value) {
        this.numberOfRegisteredUsers = value;
    }

    /**
     * Gets the value of the onboardingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOnboardingDate() {
        return onboardingDate;
    }

    /**
     * Sets the value of the onboardingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOnboardingDate(XMLGregorianCalendar value) {
        this.onboardingDate = value;
    }

    /**
     * Gets the value of the tenancyLicenseID property.
     * 
     */
    public long getTenancyLicenseID() {
        return tenancyLicenseID;
    }

    /**
     * Sets the value of the tenancyLicenseID property.
     * 
     */
    public void setTenancyLicenseID(long value) {
        this.tenancyLicenseID = value;
    }

    /**
     * Gets the value of the tenancyStatusType property.
     * 
     * @return
     *     possible object is
     *     {@link TenancyStatusType }
     *     
     */
    public TenancyStatusType getTenancyStatusType() {
        return tenancyStatusType;
    }

    /**
     * Sets the value of the tenancyStatusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TenancyStatusType }
     *     
     */
    public void setTenancyStatusType(TenancyStatusType value) {
        this.tenancyStatusType = value;
    }

    /**
     * Gets the value of the tenantID property.
     * 
     */
    public long getTenantID() {
        return tenantID;
    }

    /**
     * Sets the value of the tenantID property.
     * 
     */
    public void setTenantID(long value) {
        this.tenantID = value;
    }

    /**
     * Gets the value of the totalBillAmount property.
     * 
     */
    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    /**
     * Sets the value of the totalBillAmount property.
     * 
     */
    public void setTotalBillAmount(double value) {
        this.totalBillAmount = value;
    }

}
