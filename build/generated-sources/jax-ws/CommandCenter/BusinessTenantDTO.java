
package CommandCenter;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for businessTenantDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="businessTenantDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appLogoFileContent" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="applicationIDList" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contactAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maximumNoOfTransactions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenancyLicenseList" type="{http://services.licensing.business.s3systems.com/}tenancyLicenseDTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tenantCityID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenantCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenantCountryID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tenantDomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenantID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tenantName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenantStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businessTenantDTO", propOrder = {
    "appLogoFileContent",
    "applicationIDList",
    "contactAddress",
    "contactPhone",
    "emailAddress",
    "maximumNoOfTransactions",
    "tenancyLicenseList",
    "tenantCityID",
    "tenantCode",
    "tenantCountryID",
    "tenantDomainName",
    "tenantID",
    "tenantName",
    "tenantStateCode"
})
public class BusinessTenantDTO {

    protected byte[] appLogoFileContent;
    @XmlElement(nillable = true)
    protected List<Long> applicationIDList;
    protected String contactAddress;
    protected String contactPhone;
    protected String emailAddress;
    protected int maximumNoOfTransactions;
    @XmlElement(nillable = true)
    protected List<TenancyLicenseDTO> tenancyLicenseList;
    protected int tenantCityID;
    protected String tenantCode;
    protected int tenantCountryID;
    protected String tenantDomainName;
    protected long tenantID;
    protected String tenantName;
    protected String tenantStateCode;

    /**
     * Gets the value of the appLogoFileContent property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAppLogoFileContent() {
        return appLogoFileContent;
    }

    /**
     * Sets the value of the appLogoFileContent property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAppLogoFileContent(byte[] value) {
        this.appLogoFileContent = value;
    }

    /**
     * Gets the value of the applicationIDList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicationIDList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicationIDList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getApplicationIDList() {
        if (applicationIDList == null) {
            applicationIDList = new ArrayList<Long>();
        }
        return this.applicationIDList;
    }

    /**
     * Gets the value of the contactAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * Sets the value of the contactAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactAddress(String value) {
        this.contactAddress = value;
    }

    /**
     * Gets the value of the contactPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * Sets the value of the contactPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhone(String value) {
        this.contactPhone = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the maximumNoOfTransactions property.
     * 
     */
    public int getMaximumNoOfTransactions() {
        return maximumNoOfTransactions;
    }

    /**
     * Sets the value of the maximumNoOfTransactions property.
     * 
     */
    public void setMaximumNoOfTransactions(int value) {
        this.maximumNoOfTransactions = value;
    }

    /**
     * Gets the value of the tenancyLicenseList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tenancyLicenseList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTenancyLicenseList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TenancyLicenseDTO }
     * 
     * 
     */
    public List<TenancyLicenseDTO> getTenancyLicenseList() {
        if (tenancyLicenseList == null) {
            tenancyLicenseList = new ArrayList<TenancyLicenseDTO>();
        }
        return this.tenancyLicenseList;
    }

    /**
     * Gets the value of the tenantCityID property.
     * 
     */
    public int getTenantCityID() {
        return tenantCityID;
    }

    /**
     * Sets the value of the tenantCityID property.
     * 
     */
    public void setTenantCityID(int value) {
        this.tenantCityID = value;
    }

    /**
     * Gets the value of the tenantCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantCode() {
        return tenantCode;
    }

    /**
     * Sets the value of the tenantCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantCode(String value) {
        this.tenantCode = value;
    }

    /**
     * Gets the value of the tenantCountryID property.
     * 
     */
    public int getTenantCountryID() {
        return tenantCountryID;
    }

    /**
     * Sets the value of the tenantCountryID property.
     * 
     */
    public void setTenantCountryID(int value) {
        this.tenantCountryID = value;
    }

    /**
     * Gets the value of the tenantDomainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantDomainName() {
        return tenantDomainName;
    }

    /**
     * Sets the value of the tenantDomainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantDomainName(String value) {
        this.tenantDomainName = value;
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
     * Gets the value of the tenantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantName() {
        return tenantName;
    }

    /**
     * Sets the value of the tenantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantName(String value) {
        this.tenantName = value;
    }

    /**
     * Gets the value of the tenantStateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantStateCode() {
        return tenantStateCode;
    }

    /**
     * Sets the value of the tenantStateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantStateCode(String value) {
        this.tenantStateCode = value;
    }

}
