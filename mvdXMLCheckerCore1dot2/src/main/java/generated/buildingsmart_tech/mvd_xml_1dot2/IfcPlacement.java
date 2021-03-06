//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcPlacement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcPlacement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcGeometricRepresentationItem">
 *       &lt;sequence>
 *         &lt;element name="Location" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcCartesianPoint"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcPlacement", propOrder = {
    "location"
})
@XmlSeeAlso({
    IfcAxis1Placement.class,
    IfcAxis2Placement3D.class,
    IfcAxis2Placement2D.class
})
public abstract class IfcPlacement
    extends IfcGeometricRepresentationItem
{

    @XmlElement(name = "Location", required = true, nillable = true)
    protected IfcCartesianPoint location;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link IfcCartesianPoint }
     *     
     */
    public IfcCartesianPoint getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcCartesianPoint }
     *     
     */
    public void setLocation(IfcCartesianPoint value) {
        this.location = value;
    }

}
