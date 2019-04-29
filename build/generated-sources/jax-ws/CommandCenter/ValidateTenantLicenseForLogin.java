
package CommandCenter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateTenantLicenseForLogin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateTenantLicenseForLogin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenantDomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="applicationSystemID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateTenantLicenseForLogin", propOrder = {
    "tenantDomainName",
    "applicationSystemID"
})
public class ValidateTenantLicenseForLogin {

    protected String tenantDomainName;
    protected long applicationSystemID;

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
     * Gets the value of the applicationSystemID property.
     * 
     */
    public long getApplicationSystemID() {
        return applicationSystemID;
    }

    /**
     * Sets the value of the applicationSystemID property.
     * 
     */
    public void setApplicationSystemID(long value) {
        this.applicationSystemID = value;
    }

}
