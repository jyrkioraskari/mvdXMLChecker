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
 * <p>Java class for IfcStructuralCurveAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcStructuralCurveAction">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcStructuralAction">
 *       &lt;attribute name="ProjectedOrTrue" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcProjectedOrTrueLengthEnum" />
 *       &lt;attribute name="PredefinedType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcStructuralCurveActivityTypeEnum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcStructuralCurveAction")
@XmlSeeAlso({
    IfcStructuralLinearAction.class
})
public class IfcStructuralCurveAction
    extends IfcStructuralAction
{

    @XmlAttribute(name = "ProjectedOrTrue")
    protected IfcProjectedOrTrueLengthEnum projectedOrTrue;
    @XmlAttribute(name = "PredefinedType")
    protected IfcStructuralCurveActivityTypeEnum predefinedType;

    /**
     * Gets the value of the projectedOrTrue property.
     * 
     * @return
     *     possible object is
     *     {@link IfcProjectedOrTrueLengthEnum }
     *     
     */
    public IfcProjectedOrTrueLengthEnum getProjectedOrTrue() {
        return projectedOrTrue;
    }

    /**
     * Sets the value of the projectedOrTrue property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcProjectedOrTrueLengthEnum }
     *     
     */
    public void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum value) {
        this.projectedOrTrue = value;
    }

    /**
     * Gets the value of the predefinedType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcStructuralCurveActivityTypeEnum }
     *     
     */
    public IfcStructuralCurveActivityTypeEnum getPredefinedType() {
        return predefinedType;
    }

    /**
     * Sets the value of the predefinedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcStructuralCurveActivityTypeEnum }
     *     
     */
    public void setPredefinedType(IfcStructuralCurveActivityTypeEnum value) {
        this.predefinedType = value;
    }

}