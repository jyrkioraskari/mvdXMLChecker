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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcLagTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcLagTime">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcSchedulingTime">
 *       &lt;sequence>
 *         &lt;element name="LagValue">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcTimeOrRatioSelect"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="DurationType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcTaskDurationEnum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcLagTime", propOrder = {
    "lagValue"
})
public class IfcLagTime
    extends IfcSchedulingTime
{

    @XmlElement(name = "LagValue", required = true)
    protected IfcLagTime.LagValue lagValue;
    @XmlAttribute(name = "DurationType")
    protected IfcTaskDurationEnum durationType;

    /**
     * Gets the value of the lagValue property.
     * 
     * @return
     *     possible object is
     *     {@link IfcLagTime.LagValue }
     *     
     */
    public IfcLagTime.LagValue getLagValue() {
        return lagValue;
    }

    /**
     * Sets the value of the lagValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcLagTime.LagValue }
     *     
     */
    public void setLagValue(IfcLagTime.LagValue value) {
        this.lagValue = value;
    }

    /**
     * Gets the value of the durationType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcTaskDurationEnum }
     *     
     */
    public IfcTaskDurationEnum getDurationType() {
        return durationType;
    }

    /**
     * Sets the value of the durationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcTaskDurationEnum }
     *     
     */
    public void setDurationType(IfcTaskDurationEnum value) {
        this.durationType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcTimeOrRatioSelect"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcDurationWrapper",
        "ifcRatioMeasureWrapper"
    })
    public static class LagValue {

        @XmlElement(name = "IfcDuration-wrapper", nillable = true)
        protected IfcDurationWrapper ifcDurationWrapper;
        @XmlElement(name = "IfcRatioMeasure-wrapper", nillable = true)
        protected IfcRatioMeasureWrapper ifcRatioMeasureWrapper;

        /**
         * Gets the value of the ifcDurationWrapper property.
         * 
         * @return
         *     possible object is
         *     {@link IfcDurationWrapper }
         *     
         */
        public IfcDurationWrapper getIfcDurationWrapper() {
            return ifcDurationWrapper;
        }

        /**
         * Sets the value of the ifcDurationWrapper property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcDurationWrapper }
         *     
         */
        public void setIfcDurationWrapper(IfcDurationWrapper value) {
            this.ifcDurationWrapper = value;
        }

        /**
         * Gets the value of the ifcRatioMeasureWrapper property.
         * 
         * @return
         *     possible object is
         *     {@link IfcRatioMeasureWrapper }
         *     
         */
        public IfcRatioMeasureWrapper getIfcRatioMeasureWrapper() {
            return ifcRatioMeasureWrapper;
        }

        /**
         * Sets the value of the ifcRatioMeasureWrapper property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcRatioMeasureWrapper }
         *     
         */
        public void setIfcRatioMeasureWrapper(IfcRatioMeasureWrapper value) {
            this.ifcRatioMeasureWrapper = value;
        }

    }

}