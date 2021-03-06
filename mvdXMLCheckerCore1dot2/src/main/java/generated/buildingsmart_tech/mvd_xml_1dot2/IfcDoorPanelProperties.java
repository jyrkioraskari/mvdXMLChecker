//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcDoorPanelProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcDoorPanelProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPreDefinedPropertySet">
 *       &lt;sequence>
 *         &lt;element name="ShapeAspectStyle" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcShapeAspect" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PanelDepth" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="PanelOperation" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDoorPanelOperationEnum" />
 *       &lt;attribute name="PanelWidth" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcNormalisedRatioMeasure" />
 *       &lt;attribute name="PanelPosition" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDoorPanelPositionEnum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcDoorPanelProperties", propOrder = {
    "shapeAspectStyle"
})
public class IfcDoorPanelProperties
    extends IfcPreDefinedPropertySet
{

    @XmlElementRef(name = "ShapeAspectStyle", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcShapeAspect> shapeAspectStyle;
    @XmlAttribute(name = "PanelDepth")
    protected Double panelDepth;
    @XmlAttribute(name = "PanelOperation")
    protected IfcDoorPanelOperationEnum panelOperation;
    @XmlAttribute(name = "PanelWidth")
    protected Double panelWidth;
    @XmlAttribute(name = "PanelPosition")
    protected IfcDoorPanelPositionEnum panelPosition;

    /**
     * Gets the value of the shapeAspectStyle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcShapeAspect }{@code >}
     *     
     */
    public JAXBElement<IfcShapeAspect> getShapeAspectStyle() {
        return shapeAspectStyle;
    }

    /**
     * Sets the value of the shapeAspectStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcShapeAspect }{@code >}
     *     
     */
    public void setShapeAspectStyle(JAXBElement<IfcShapeAspect> value) {
        this.shapeAspectStyle = value;
    }

    /**
     * Gets the value of the panelDepth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelDepth() {
        return panelDepth;
    }

    /**
     * Sets the value of the panelDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelDepth(Double value) {
        this.panelDepth = value;
    }

    /**
     * Gets the value of the panelOperation property.
     * 
     * @return
     *     possible object is
     *     {@link IfcDoorPanelOperationEnum }
     *     
     */
    public IfcDoorPanelOperationEnum getPanelOperation() {
        return panelOperation;
    }

    /**
     * Sets the value of the panelOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcDoorPanelOperationEnum }
     *     
     */
    public void setPanelOperation(IfcDoorPanelOperationEnum value) {
        this.panelOperation = value;
    }

    /**
     * Gets the value of the panelWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPanelWidth() {
        return panelWidth;
    }

    /**
     * Sets the value of the panelWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPanelWidth(Double value) {
        this.panelWidth = value;
    }

    /**
     * Gets the value of the panelPosition property.
     * 
     * @return
     *     possible object is
     *     {@link IfcDoorPanelPositionEnum }
     *     
     */
    public IfcDoorPanelPositionEnum getPanelPosition() {
        return panelPosition;
    }

    /**
     * Sets the value of the panelPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcDoorPanelPositionEnum }
     *     
     */
    public void setPanelPosition(IfcDoorPanelPositionEnum value) {
        this.panelPosition = value;
    }

}
