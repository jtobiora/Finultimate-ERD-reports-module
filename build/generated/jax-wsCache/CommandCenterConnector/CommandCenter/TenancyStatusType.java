
package CommandCenter;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tenancyStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tenancyStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="ACTIVE"/>
 *     &lt;enumeration value="DEACTIVATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tenancyStatusType")
@XmlEnum
public enum TenancyStatusType {

    NONE,
    PENDING,
    ACTIVE,
    DEACTIVATED;

    public String value() {
        return name();
    }

    public static TenancyStatusType fromValue(String v) {
        return valueOf(v);
    }

}
