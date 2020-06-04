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
 * <p>Java class for IfcSensorTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IfcSensorTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="cosensor"/>
 *     &lt;enumeration value="co2sensor"/>
 *     &lt;enumeration value="conductancesensor"/>
 *     &lt;enumeration value="contactsensor"/>
 *     &lt;enumeration value="firesensor"/>
 *     &lt;enumeration value="flowsensor"/>
 *     &lt;enumeration value="frostsensor"/>
 *     &lt;enumeration value="gassensor"/>
 *     &lt;enumeration value="heatsensor"/>
 *     &lt;enumeration value="humiditysensor"/>
 *     &lt;enumeration value="identifiersensor"/>
 *     &lt;enumeration value="ionconcentrationsensor"/>
 *     &lt;enumeration value="levelsensor"/>
 *     &lt;enumeration value="lightsensor"/>
 *     &lt;enumeration value="moisturesensor"/>
 *     &lt;enumeration value="movementsensor"/>
 *     &lt;enumeration value="phsensor"/>
 *     &lt;enumeration value="pressuresensor"/>
 *     &lt;enumeration value="radiationsensor"/>
 *     &lt;enumeration value="radioactivitysensor"/>
 *     &lt;enumeration value="smokesensor"/>
 *     &lt;enumeration value="soundsensor"/>
 *     &lt;enumeration value="temperaturesensor"/>
 *     &lt;enumeration value="windsensor"/>
 *     &lt;enumeration value="userdefined"/>
 *     &lt;enumeration value="notdefined"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IfcSensorTypeEnum")
@XmlEnum
public enum IfcSensorTypeEnum {

    @XmlEnumValue("cosensor")
    COSENSOR("cosensor"),
    @XmlEnumValue("co2sensor")
    CO_2_SENSOR("co2sensor"),
    @XmlEnumValue("conductancesensor")
    CONDUCTANCESENSOR("conductancesensor"),
    @XmlEnumValue("contactsensor")
    CONTACTSENSOR("contactsensor"),
    @XmlEnumValue("firesensor")
    FIRESENSOR("firesensor"),
    @XmlEnumValue("flowsensor")
    FLOWSENSOR("flowsensor"),
    @XmlEnumValue("frostsensor")
    FROSTSENSOR("frostsensor"),
    @XmlEnumValue("gassensor")
    GASSENSOR("gassensor"),
    @XmlEnumValue("heatsensor")
    HEATSENSOR("heatsensor"),
    @XmlEnumValue("humiditysensor")
    HUMIDITYSENSOR("humiditysensor"),
    @XmlEnumValue("identifiersensor")
    IDENTIFIERSENSOR("identifiersensor"),
    @XmlEnumValue("ionconcentrationsensor")
    IONCONCENTRATIONSENSOR("ionconcentrationsensor"),
    @XmlEnumValue("levelsensor")
    LEVELSENSOR("levelsensor"),
    @XmlEnumValue("lightsensor")
    LIGHTSENSOR("lightsensor"),
    @XmlEnumValue("moisturesensor")
    MOISTURESENSOR("moisturesensor"),
    @XmlEnumValue("movementsensor")
    MOVEMENTSENSOR("movementsensor"),
    @XmlEnumValue("phsensor")
    PHSENSOR("phsensor"),
    @XmlEnumValue("pressuresensor")
    PRESSURESENSOR("pressuresensor"),
    @XmlEnumValue("radiationsensor")
    RADIATIONSENSOR("radiationsensor"),
    @XmlEnumValue("radioactivitysensor")
    RADIOACTIVITYSENSOR("radioactivitysensor"),
    @XmlEnumValue("smokesensor")
    SMOKESENSOR("smokesensor"),
    @XmlEnumValue("soundsensor")
    SOUNDSENSOR("soundsensor"),
    @XmlEnumValue("temperaturesensor")
    TEMPERATURESENSOR("temperaturesensor"),
    @XmlEnumValue("windsensor")
    WINDSENSOR("windsensor"),
    @XmlEnumValue("userdefined")
    USERDEFINED("userdefined"),
    @XmlEnumValue("notdefined")
    NOTDEFINED("notdefined");
    private final String value;

    IfcSensorTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IfcSensorTypeEnum fromValue(String v) {
        for (IfcSensorTypeEnum c: IfcSensorTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}