//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for IfcReinforcingMeshType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcReinforcingMeshType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcReinforcingElementType">
 *       &lt;sequence>
 *         &lt;element name="BendingParameters" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBendingParameterSelect" maxOccurs="unbounded"/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcBendingParameterSelect""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}arraySize"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="PredefinedType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcReinforcingMeshTypeEnum" />
 *       &lt;attribute name="MeshLength" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="MeshWidth" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="LongitudinalBarNominalDiameter" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="TransverseBarNominalDiameter" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="LongitudinalBarCrossSectionArea" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcAreaMeasure" />
 *       &lt;attribute name="TransverseBarCrossSectionArea" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcAreaMeasure" />
 *       &lt;attribute name="LongitudinalBarSpacing" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="TransverseBarSpacing" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveLengthMeasure" />
 *       &lt;attribute name="BendingShapeCode" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcReinforcingMeshType", propOrder = {
    "bendingParameters"
})
public class IfcReinforcingMeshType
    extends IfcReinforcingElementType
{

    @XmlElementRef(name = "BendingParameters", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcReinforcingMeshType.BendingParameters> bendingParameters;
    @XmlAttribute(name = "PredefinedType")
    protected IfcReinforcingMeshTypeEnum predefinedType;
    @XmlAttribute(name = "MeshLength")
    protected Double meshLength;
    @XmlAttribute(name = "MeshWidth")
    protected Double meshWidth;
    @XmlAttribute(name = "LongitudinalBarNominalDiameter")
    protected Double longitudinalBarNominalDiameter;
    @XmlAttribute(name = "TransverseBarNominalDiameter")
    protected Double transverseBarNominalDiameter;
    @XmlAttribute(name = "LongitudinalBarCrossSectionArea")
    protected Double longitudinalBarCrossSectionArea;
    @XmlAttribute(name = "TransverseBarCrossSectionArea")
    protected Double transverseBarCrossSectionArea;
    @XmlAttribute(name = "LongitudinalBarSpacing")
    protected Double longitudinalBarSpacing;
    @XmlAttribute(name = "TransverseBarSpacing")
    protected Double transverseBarSpacing;
    @XmlAttribute(name = "BendingShapeCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bendingShapeCode;

    /**
     * Gets the value of the bendingParameters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcReinforcingMeshType.BendingParameters }{@code >}
     *     
     */
    public JAXBElement<IfcReinforcingMeshType.BendingParameters> getBendingParameters() {
        return bendingParameters;
    }

    /**
     * Sets the value of the bendingParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcReinforcingMeshType.BendingParameters }{@code >}
     *     
     */
    public void setBendingParameters(JAXBElement<IfcReinforcingMeshType.BendingParameters> value) {
        this.bendingParameters = value;
    }

    /**
     * Gets the value of the predefinedType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcReinforcingMeshTypeEnum }
     *     
     */
    public IfcReinforcingMeshTypeEnum getPredefinedType() {
        return predefinedType;
    }

    /**
     * Sets the value of the predefinedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcReinforcingMeshTypeEnum }
     *     
     */
    public void setPredefinedType(IfcReinforcingMeshTypeEnum value) {
        this.predefinedType = value;
    }

    /**
     * Gets the value of the meshLength property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMeshLength() {
        return meshLength;
    }

    /**
     * Sets the value of the meshLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMeshLength(Double value) {
        this.meshLength = value;
    }

    /**
     * Gets the value of the meshWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMeshWidth() {
        return meshWidth;
    }

    /**
     * Sets the value of the meshWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMeshWidth(Double value) {
        this.meshWidth = value;
    }

    /**
     * Gets the value of the longitudinalBarNominalDiameter property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitudinalBarNominalDiameter() {
        return longitudinalBarNominalDiameter;
    }

    /**
     * Sets the value of the longitudinalBarNominalDiameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongitudinalBarNominalDiameter(Double value) {
        this.longitudinalBarNominalDiameter = value;
    }

    /**
     * Gets the value of the transverseBarNominalDiameter property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransverseBarNominalDiameter() {
        return transverseBarNominalDiameter;
    }

    /**
     * Sets the value of the transverseBarNominalDiameter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransverseBarNominalDiameter(Double value) {
        this.transverseBarNominalDiameter = value;
    }

    /**
     * Gets the value of the longitudinalBarCrossSectionArea property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitudinalBarCrossSectionArea() {
        return longitudinalBarCrossSectionArea;
    }

    /**
     * Sets the value of the longitudinalBarCrossSectionArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongitudinalBarCrossSectionArea(Double value) {
        this.longitudinalBarCrossSectionArea = value;
    }

    /**
     * Gets the value of the transverseBarCrossSectionArea property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransverseBarCrossSectionArea() {
        return transverseBarCrossSectionArea;
    }

    /**
     * Sets the value of the transverseBarCrossSectionArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransverseBarCrossSectionArea(Double value) {
        this.transverseBarCrossSectionArea = value;
    }

    /**
     * Gets the value of the longitudinalBarSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLongitudinalBarSpacing() {
        return longitudinalBarSpacing;
    }

    /**
     * Sets the value of the longitudinalBarSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLongitudinalBarSpacing(Double value) {
        this.longitudinalBarSpacing = value;
    }

    /**
     * Gets the value of the transverseBarSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransverseBarSpacing() {
        return transverseBarSpacing;
    }

    /**
     * Sets the value of the transverseBarSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransverseBarSpacing(Double value) {
        this.transverseBarSpacing = value;
    }

    /**
     * Gets the value of the bendingShapeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBendingShapeCode() {
        return bendingShapeCode;
    }

    /**
     * Sets the value of the bendingShapeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBendingShapeCode(String value) {
        this.bendingShapeCode = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBendingParameterSelect" maxOccurs="unbounded"/>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcBendingParameterSelect""/>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list""/>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}arraySize"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcBendingParameterSelect"
    })
    public static class BendingParameters {

        @XmlElements({
            @XmlElement(name = "IfcLengthMeasure-wrapper", type = IfcLengthMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPlaneAngleMeasure-wrapper", type = IfcPlaneAngleMeasureWrapper.class, nillable = true)
        })
        protected List<Object> ifcBendingParameterSelect;
        @XmlAttribute(name = "itemType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<QName> itemType;
        @XmlAttribute(name = "cType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<AggregateType> cType;
        @XmlAttribute(name = "arraySize", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<BigInteger> arraySize;

        /**
         * Gets the value of the ifcBendingParameterSelect property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ifcBendingParameterSelect property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIfcBendingParameterSelect().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IfcLengthMeasureWrapper }
         * {@link IfcPlaneAngleMeasureWrapper }
         * 
         * 
         */
        public List<Object> getIfcBendingParameterSelect() {
            if (ifcBendingParameterSelect == null) {
                ifcBendingParameterSelect = new ArrayList<Object>();
            }
            return this.ifcBendingParameterSelect;
        }

        /**
         * Gets the value of the itemType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the itemType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItemType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link QName }
         * 
         * 
         */
        public List<QName> getItemType() {
            if (itemType == null) {
                itemType = new ArrayList<QName>();
            }
            return this.itemType;
        }

        /**
         * Gets the value of the cType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AggregateType }
         * 
         * 
         */
        public List<AggregateType> getCType() {
            if (cType == null) {
                cType = new ArrayList<AggregateType>();
            }
            return this.cType;
        }

        /**
         * Gets the value of the arraySize property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the arraySize property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getArraySize().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigInteger }
         * 
         * 
         */
        public List<BigInteger> getArraySize() {
            if (arraySize == null) {
                arraySize = new ArrayList<BigInteger>();
            }
            return this.arraySize;
        }

    }

}