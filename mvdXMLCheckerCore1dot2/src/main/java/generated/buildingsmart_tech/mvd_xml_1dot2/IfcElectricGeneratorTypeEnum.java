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
 * <p>Java class for IfcElectricGeneratorTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcElectricGeneratorTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="chp"/>
 *     &lt;enumeration value="enginegenerator"/>
 *     &lt;enumeration value="standalone"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcElectricGeneratorTypeEnum")
@XmlEnum
public enum IfcElectricGeneratorTypeEnum {

    @XmlEnumValue("chp")
    CHP("chp"),
    @XmlEnumValue("enginegenerator")
    ENGINEGENERATOR("enginegenerator"),
    @XmlEnumValue("standalone")
    STANDALONE("standalone"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcElectricGeneratorTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcElectricGeneratorTypeEnum fromValue(String v) {
        for (IfcElectricGeneratorTypeEnum c: IfcElectricGeneratorTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
