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
 * <p>Java class for IfcLogicalOperatorEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcLogicalOperatorEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="logicaland"/>
 *     &lt;enumeration value="logicalor"/>
 *     &lt;enumeration value="logicalxor"/>
 *     &lt;enumeration value="logicalnotand"/>
 *     &lt;enumeration value="logicalnotor"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcLogicalOperatorEnum")
@XmlEnum
public enum IfcLogicalOperatorEnum {

    @XmlEnumValue("logicaland")
    LOGICALAND("logicaland"),
    @XmlEnumValue("logicalor")
    LOGICALOR("logicalor"),
    @XmlEnumValue("logicalxor")
    LOGICALXOR("logicalxor"),
    @XmlEnumValue("logicalnotand")
    LOGICALNOTAND("logicalnotand"),
    @XmlEnumValue("logicalnotor")
    LOGICALNOTOR("logicalnotor");
    private final String value;

    IfcLogicalOperatorEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcLogicalOperatorEnum fromValue(String v) {
        for (IfcLogicalOperatorEnum c: IfcLogicalOperatorEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}