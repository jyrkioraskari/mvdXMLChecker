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
 * <p>Java class for IfcMechanicalFastenerTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcMechanicalFastenerTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="anchorbolt"/>
 *     &lt;enumeration value="bolt"/>
 *     &lt;enumeration value="dowel"/>
 *     &lt;enumeration value="nail"/>
 *     &lt;enumeration value="nailplate"/>
 *     &lt;enumeration value="rivet"/>
 *     &lt;enumeration value="screw"/>
 *     &lt;enumeration value="shearconnector"/>
 *     &lt;enumeration value="staple"/>
 *     &lt;enumeration value="studshearconnector"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcMechanicalFastenerTypeEnum")
@XmlEnum
public enum IfcMechanicalFastenerTypeEnum {

    @XmlEnumValue("anchorbolt")
    ANCHORBOLT("anchorbolt"),
    @XmlEnumValue("bolt")
    BOLT("bolt"),
    @XmlEnumValue("dowel")
    DOWEL("dowel"),
    @XmlEnumValue("nail")
    NAIL("nail"),
    @XmlEnumValue("nailplate")
    NAILPLATE("nailplate"),
    @XmlEnumValue("rivet")
    RIVET("rivet"),
    @XmlEnumValue("screw")
    SCREW("screw"),
    @XmlEnumValue("shearconnector")
    SHEARCONNECTOR("shearconnector"),
    @XmlEnumValue("staple")
    STAPLE("staple"),
    @XmlEnumValue("studshearconnector")
    STUDSHEARCONNECTOR("studshearconnector"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcMechanicalFastenerTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcMechanicalFastenerTypeEnum fromValue(String v) {
        for (IfcMechanicalFastenerTypeEnum c: IfcMechanicalFastenerTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
