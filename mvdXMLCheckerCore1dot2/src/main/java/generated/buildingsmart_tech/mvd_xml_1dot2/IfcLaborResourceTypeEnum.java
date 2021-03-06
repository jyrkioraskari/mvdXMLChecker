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
 * <p>Java class for IfcLaborResourceTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcLaborResourceTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="administration"/>
 *     &lt;enumeration value="carpentry"/>
 *     &lt;enumeration value="cleaning"/>
 *     &lt;enumeration value="concrete"/>
 *     &lt;enumeration value="drywall"/>
 *     &lt;enumeration value="electric"/>
 *     &lt;enumeration value="finishing"/>
 *     &lt;enumeration value="flooring"/>
 *     &lt;enumeration value="general"/>
 *     &lt;enumeration value="hvac"/>
 *     &lt;enumeration value="landscaping"/>
 *     &lt;enumeration value="masonry"/>
 *     &lt;enumeration value="painting"/>
 *     &lt;enumeration value="paving"/>
 *     &lt;enumeration value="plumbing"/>
 *     &lt;enumeration value="roofing"/>
 *     &lt;enumeration value="sitegrading"/>
 *     &lt;enumeration value="steelwork"/>
 *     &lt;enumeration value="surveying"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcLaborResourceTypeEnum")
@XmlEnum
public enum IfcLaborResourceTypeEnum {

    @XmlEnumValue("administration")
    ADMINISTRATION("administration"),
    @XmlEnumValue("carpentry")
    CARPENTRY("carpentry"),
    @XmlEnumValue("cleaning")
    CLEANING("cleaning"),
    @XmlEnumValue("concrete")
    CONCRETE("concrete"),
    @XmlEnumValue("drywall")
    DRYWALL("drywall"),
    @XmlEnumValue("electric")
    ELECTRIC("electric"),
    @XmlEnumValue("finishing")
    FINISHING("finishing"),
    @XmlEnumValue("flooring")
    FLOORING("flooring"),
    @XmlEnumValue("general")
    GENERAL("general"),
    @XmlEnumValue("hvac")
    HVAC("hvac"),
    @XmlEnumValue("landscaping")
    LANDSCAPING("landscaping"),
    @XmlEnumValue("masonry")
    MASONRY("masonry"),
    @XmlEnumValue("painting")
    PAINTING("painting"),
    @XmlEnumValue("paving")
    PAVING("paving"),
    @XmlEnumValue("plumbing")
    PLUMBING("plumbing"),
    @XmlEnumValue("roofing")
    ROOFING("roofing"),
    @XmlEnumValue("sitegrading")
    SITEGRADING("sitegrading"),
    @XmlEnumValue("steelwork")
    STEELWORK("steelwork"),
    @XmlEnumValue("surveying")
    SURVEYING("surveying"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcLaborResourceTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcLaborResourceTypeEnum fromValue(String v) {
        for (IfcLaborResourceTypeEnum c: IfcLaborResourceTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
