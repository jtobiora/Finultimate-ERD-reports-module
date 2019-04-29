
package CommandCenter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateTenantLicensesForLogin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateTenantLicensesForLogin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tenantDomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateTenantLicensesForLogin", propOrder = {
    "tenantDomainName"
})
public class ValidateTenantLicensesForLogin {

    protected String tenantDomainName;

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

}
