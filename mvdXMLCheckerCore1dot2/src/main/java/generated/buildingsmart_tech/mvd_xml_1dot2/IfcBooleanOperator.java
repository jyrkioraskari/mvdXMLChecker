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
 * <p>Java class for IfcBooleanOperator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcBooleanOperator">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="union"/>
 *     &lt;enumeration value="intersection"/>
 *     &lt;enumeration value="difference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcBooleanOperator")
@XmlEnum
public enum IfcBooleanOperator {

    @XmlEnumValue("union")
    UNION("union"),
    @XmlEnumValue("intersection")
    INTERSECTION("intersection"),
    @XmlEnumValue("difference")
    DIFFERENCE("difference");
    private final String value;

    IfcBooleanOperator(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcBooleanOperator fromValue(String v) {
        for (IfcBooleanOperator c: IfcBooleanOperator.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
