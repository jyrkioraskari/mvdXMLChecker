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
 * <p>Java class for IfcTaskTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcTaskTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="attendance"/>
 *     &lt;enumeration value="construction"/>
 *     &lt;enumeration value="demolition"/>
 *     &lt;enumeration value="dismantle"/>
 *     &lt;enumeration value="disposal"/>
 *     &lt;enumeration value="installation"/>
 *     &lt;enumeration value="logistic"/>
 *     &lt;enumeration value="maintenance"/>
 *     &lt;enumeration value="move"/>
 *     &lt;enumeration value="operation"/>
 *     &lt;enumeration value="removal"/>
 *     &lt;enumeration value="renovation"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcTaskTypeEnum")
@XmlEnum
public enum IfcTaskTypeEnum {

    @XmlEnumValue("attendance")
    ATTENDANCE("attendance"),
    @XmlEnumValue("construction")
    CONSTRUCTION("construction"),
    @XmlEnumValue("demolition")
    DEMOLITION("demolition"),
    @XmlEnumValue("dismantle")
    DISMANTLE("dismantle"),
    @XmlEnumValue("disposal")
    DISPOSAL("disposal"),
    @XmlEnumValue("installation")
    INSTALLATION("installation"),
    @XmlEnumValue("logistic")
    LOGISTIC("logistic"),
    @XmlEnumValue("maintenance")
    MAINTENANCE("maintenance"),
    @XmlEnumValue("move")
    MOVE("move"),
    @XmlEnumValue("operation")
    OPERATION("operation"),
    @XmlEnumValue("removal")
    REMOVAL("removal"),
    @XmlEnumValue("renovation")
    RENOVATION("renovation"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcTaskTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcTaskTypeEnum fromValue(String v) {
        for (IfcTaskTypeEnum c: IfcTaskTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
