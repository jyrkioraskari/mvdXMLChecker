//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcMirroredProfileDef-temp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcMirroredProfileDef-temp">
 *   &lt;complexContent>
 *     &lt;restriction base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDerivedProfileDef">
 *       &lt;sequence>
 *         &lt;element name="ParentProfile" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcProfileDef"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcMirroredProfileDef-temp")
@XmlSeeAlso({
    IfcMirroredProfileDef.class
})
public abstract class IfcMirroredProfileDefTemp
    extends IfcDerivedProfileDef
{


}