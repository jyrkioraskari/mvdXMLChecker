//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcBuildingElementProxyTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcBuildingElementProxyTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="complex"/>
 *     &lt;enumeration value="element"/>
 *     &lt;enumeration value="partial"/>
 *     &lt;enumeration value="provisionforvoid"/>
 *     &lt;enumeration value="provisionforspace"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcBuildingElementProxyTypeEnum")
@XmlEnum
public enum IfcBuildingElementProxyTypeEnum {

    @XmlEnumValue("complex")
    COMPLEX("complex"),
    @XmlEnumValue("element")
    ELEMENT("element"),
    @XmlEnumValue("partial")
    PARTIAL("partial"),
    @XmlEnumValue("provisionforvoid")
    PROVISIONFORVOID("provisionforvoid"),
    @XmlEnumValue("provisionforspace")
    PROVISIONFORSPACE("provisionforspace"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcBuildingElementProxyTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcBuildingElementProxyTypeEnum fromValue(String v) {
        for (IfcBuildingElementProxyTypeEnum c: IfcBuildingElementProxyTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
