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
 * <p>Java class for IfcReflectanceMethodEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcReflectanceMethodEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="blinn"/>
 *     &lt;enumeration value="flat"/>
 *     &lt;enumeration value="glass"/>
 *     &lt;enumeration value="matt"/>
 *     &lt;enumeration value="metal"/>
 *     &lt;enumeration value="mirror"/>
 *     &lt;enumeration value="phong"/>
 *     &lt;enumeration value="plastic"/>
 *     &lt;enumeration value="strauss"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcReflectanceMethodEnum")
@XmlEnum
public enum IfcReflectanceMethodEnum {

    @XmlEnumValue("blinn")
    BLINN("blinn"),
    @XmlEnumValue("flat")
    FLAT("flat"),
    @XmlEnumValue("glass")
    GLASS("glass"),
    @XmlEnumValue("matt")
    MATT("matt"),
    @XmlEnumValue("metal")
    METAL("metal"),
    @XmlEnumValue("mirror")
    MIRROR("mirror"),
    @XmlEnumValue("phong")
    PHONG("phong"),
    @XmlEnumValue("plastic")
    PLASTIC("plastic"),
    @XmlEnumValue("strauss")
    STRAUSS("strauss"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcReflectanceMethodEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcReflectanceMethodEnum fromValue(String v) {
        for (IfcReflectanceMethodEnum c: IfcReflectanceMethodEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}