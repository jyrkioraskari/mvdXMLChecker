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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcCartesianTransformationOperator2DnonUniform complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcCartesianTransformationOperator2DnonUniform">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcCartesianTransformationOperator2D">
 *       &lt;attribute name="Scale2" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcReal" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcCartesianTransformationOperator2DnonUniform")
public class IfcCartesianTransformationOperator2DnonUniform
    extends IfcCartesianTransformationOperator2D
{

    @XmlAttribute(name = "Scale2")
    protected Double scale2;

    /**
     * Gets the value of the scale2 property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScale2() {
        return scale2;
    }

    /**
     * Sets the value of the scale2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScale2(Double value) {
        this.scale2 = value;
    }

}