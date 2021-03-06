//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcStructuralLoadSingleDisplacement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcStructuralLoadSingleDisplacement">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcStructuralLoadStatic">
 *       &lt;attribute name="DisplacementX" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLengthMeasure" />
 *       &lt;attribute name="DisplacementY" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLengthMeasure" />
 *       &lt;attribute name="DisplacementZ" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLengthMeasure" />
 *       &lt;attribute name="RotationalDisplacementRX" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPlaneAngleMeasure" />
 *       &lt;attribute name="RotationalDisplacementRY" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPlaneAngleMeasure" />
 *       &lt;attribute name="RotationalDisplacementRZ" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPlaneAngleMeasure" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcStructuralLoadSingleDisplacement")
@XmlSeeAlso({
    IfcStructuralLoadSingleDisplacementDistortion.class
})
public class IfcStructuralLoadSingleDisplacement
    extends IfcStructuralLoadStatic
{

    @XmlAttribute(name = "DisplacementX")
    protected Double displacementX;
    @XmlAttribute(name = "DisplacementY")
    protected Double displacementY;
    @XmlAttribute(name = "DisplacementZ")
    protected Double displacementZ;
    @XmlAttribute(name = "RotationalDisplacementRX")
    protected Double rotationalDisplacementRX;
    @XmlAttribute(name = "RotationalDisplacementRY")
    protected Double rotationalDisplacementRY;
    @XmlAttribute(name = "RotationalDisplacementRZ")
    protected Double rotationalDisplacementRZ;

    /**
     * Gets the value of the displacementX property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDisplacementX() {
        return displacementX;
    }

    /**
     * Sets the value of the displacementX property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDisplacementX(Double value) {
        this.displacementX = value;
    }

    /**
     * Gets the value of the displacementY property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDisplacementY() {
        return displacementY;
    }

    /**
     * Sets the value of the displacementY property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDisplacementY(Double value) {
        this.displacementY = value;
    }

    /**
     * Gets the value of the displacementZ property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDisplacementZ() {
        return displacementZ;
    }

    /**
     * Sets the value of the displacementZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDisplacementZ(Double value) {
        this.displacementZ = value;
    }

    /**
     * Gets the value of the rotationalDisplacementRX property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRotationalDisplacementRX() {
        return rotationalDisplacementRX;
    }

    /**
     * Sets the value of the rotationalDisplacementRX property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRotationalDisplacementRX(Double value) {
        this.rotationalDisplacementRX = value;
    }

    /**
     * Gets the value of the rotationalDisplacementRY property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRotationalDisplacementRY() {
        return rotationalDisplacementRY;
    }

    /**
     * Sets the value of the rotationalDisplacementRY property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRotationalDisplacementRY(Double value) {
        this.rotationalDisplacementRY = value;
    }

    /**
     * Gets the value of the rotationalDisplacementRZ property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRotationalDisplacementRZ() {
        return rotationalDisplacementRZ;
    }

    /**
     * Sets the value of the rotationalDisplacementRZ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRotationalDisplacementRZ(Double value) {
        this.rotationalDisplacementRZ = value;
    }

}
