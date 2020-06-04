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
 * <p>Java class for IfcChangeActionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcChangeActionEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="nochange"/>
 *     &lt;enumeration value="modified"/>
 *     &lt;enumeration value="added"/>
 *     &lt;enumeration value="deleted"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcChangeActionEnum")
@XmlEnum
public enum IfcChangeActionEnum {

    @XmlEnumValue("nochange")
    NOCHANGE("nochange"),
    @XmlEnumValue("modified")
    MODIFIED("modified"),
    @XmlEnumValue("added")
    ADDED("added"),
    @XmlEnumValue("deleted")
    DELETED("deleted"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcChangeActionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcChangeActionEnum fromValue(String v) {
        for (IfcChangeActionEnum c: IfcChangeActionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}