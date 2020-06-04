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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IfcSimplePropertyTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcSimplePropertyTemplate">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPropertyTemplate">
 *       &lt;sequence>
 *         &lt;element name="Enumerators" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPropertyEnumeration" minOccurs="0"/>
 *         &lt;element name="PrimaryUnit" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcUnit"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SecondaryUnit" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcUnit"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="TemplateType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcSimplePropertyTemplateTypeEnum" />
 *       &lt;attribute name="PrimaryMeasureType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *       &lt;attribute name="SecondaryMeasureType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *       &lt;attribute name="Expression" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *       &lt;attribute name="AccessState" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcStateEnum" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcSimplePropertyTemplate", propOrder = {
    "enumerators",
    "primaryUnit",
    "secondaryUnit"
})
public class IfcSimplePropertyTemplate
    extends IfcPropertyTemplate
{

    @XmlElementRef(name = "Enumerators", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcPropertyEnumeration> enumerators;
    @XmlElementRef(name = "PrimaryUnit", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcSimplePropertyTemplate.PrimaryUnit> primaryUnit;
    @XmlElementRef(name = "SecondaryUnit", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcSimplePropertyTemplate.SecondaryUnit> secondaryUnit;
    @XmlAttribute(name = "TemplateType")
    protected IfcSimplePropertyTemplateTypeEnum templateType;
    @XmlAttribute(name = "PrimaryMeasureType")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String primaryMeasureType;
    @XmlAttribute(name = "SecondaryMeasureType")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String secondaryMeasureType;
    @XmlAttribute(name = "Expression")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expression;
    @XmlAttribute(name = "AccessState")
    protected IfcStateEnum accessState;

    /**
     * Gets the value of the enumerators property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyEnumeration }{@code >}
     *     
     */
    public JAXBElement<IfcPropertyEnumeration> getEnumerators() {
        return enumerators;
    }

    /**
     * Sets the value of the enumerators property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyEnumeration }{@code >}
     *     
     */
    public void setEnumerators(JAXBElement<IfcPropertyEnumeration> value) {
        this.enumerators = value;
    }

    /**
     * Gets the value of the primaryUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcSimplePropertyTemplate.PrimaryUnit }{@code >}
     *     
     */
    public JAXBElement<IfcSimplePropertyTemplate.PrimaryUnit> getPrimaryUnit() {
        return primaryUnit;
    }

    /**
     * Sets the value of the primaryUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcSimplePropertyTemplate.PrimaryUnit }{@code >}
     *     
     */
    public void setPrimaryUnit(JAXBElement<IfcSimplePropertyTemplate.PrimaryUnit> value) {
        this.primaryUnit = value;
    }

    /**
     * Gets the value of the secondaryUnit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcSimplePropertyTemplate.SecondaryUnit }{@code >}
     *     
     */
    public JAXBElement<IfcSimplePropertyTemplate.SecondaryUnit> getSecondaryUnit() {
        return secondaryUnit;
    }

    /**
     * Sets the value of the secondaryUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcSimplePropertyTemplate.SecondaryUnit }{@code >}
     *     
     */
    public void setSecondaryUnit(JAXBElement<IfcSimplePropertyTemplate.SecondaryUnit> value) {
        this.secondaryUnit = value;
    }

    /**
     * Gets the value of the templateType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcSimplePropertyTemplateTypeEnum }
     *     
     */
    public IfcSimplePropertyTemplateTypeEnum getTemplateType() {
        return templateType;
    }

    /**
     * Sets the value of the templateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcSimplePropertyTemplateTypeEnum }
     *     
     */
    public void setTemplateType(IfcSimplePropertyTemplateTypeEnum value) {
        this.templateType = value;
    }

    /**
     * Gets the value of the primaryMeasureType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryMeasureType() {
        return primaryMeasureType;
    }

    /**
     * Sets the value of the primaryMeasureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryMeasureType(String value) {
        this.primaryMeasureType = value;
    }

    /**
     * Gets the value of the secondaryMeasureType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryMeasureType() {
        return secondaryMeasureType;
    }

    /**
     * Sets the value of the secondaryMeasureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryMeasureType(String value) {
        this.secondaryMeasureType = value;
    }

    /**
     * Gets the value of the expression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpression() {
        return expression;
    }

    /**
     * Sets the value of the expression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpression(String value) {
        this.expression = value;
    }

    /**
     * Gets the value of the accessState property.
     * 
     * @return
     *     possible object is
     *     {@link IfcStateEnum }
     *     
     */
    public IfcStateEnum getAccessState() {
        return accessState;
    }

    /**
     * Sets the value of the accessState property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcStateEnum }
     *     
     */
    public void setAccessState(IfcStateEnum value) {
        this.accessState = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcUnit"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcDerivedUnit",
        "ifcMonetaryUnit",
        "ifcNamedUnit"
    })
    public static class PrimaryUnit {

        @XmlElement(name = "IfcDerivedUnit", nillable = true)
        protected IfcDerivedUnit ifcDerivedUnit;
        @XmlElement(name = "IfcMonetaryUnit", nillable = true)
        protected IfcMonetaryUnit ifcMonetaryUnit;
        @XmlElementRef(name = "IfcNamedUnit", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcNamedUnit> ifcNamedUnit;

        /**
         * Gets the value of the ifcDerivedUnit property.
         * 
         * @return
         *     possible object is
         *     {@link IfcDerivedUnit }
         *     
         */
        public IfcDerivedUnit getIfcDerivedUnit() {
            return ifcDerivedUnit;
        }

        /**
         * Sets the value of the ifcDerivedUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcDerivedUnit }
         *     
         */
        public void setIfcDerivedUnit(IfcDerivedUnit value) {
            this.ifcDerivedUnit = value;
        }

        /**
         * Gets the value of the ifcMonetaryUnit property.
         * 
         * @return
         *     possible object is
         *     {@link IfcMonetaryUnit }
         *     
         */
        public IfcMonetaryUnit getIfcMonetaryUnit() {
            return ifcMonetaryUnit;
        }

        /**
         * Sets the value of the ifcMonetaryUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcMonetaryUnit }
         *     
         */
        public void setIfcMonetaryUnit(IfcMonetaryUnit value) {
            this.ifcMonetaryUnit = value;
        }

        /**
         * Gets the value of the ifcNamedUnit property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnitWithOffset }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSIUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcNamedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcContextDependentUnit }{@code >}
         *     
         */
        public JAXBElement<? extends IfcNamedUnit> getIfcNamedUnit() {
            return ifcNamedUnit;
        }

        /**
         * Sets the value of the ifcNamedUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnitWithOffset }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSIUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcNamedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcContextDependentUnit }{@code >}
         *     
         */
        public void setIfcNamedUnit(JAXBElement<? extends IfcNamedUnit> value) {
            this.ifcNamedUnit = value;
        }

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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcUnit"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcDerivedUnit",
        "ifcMonetaryUnit",
        "ifcNamedUnit"
    })
    public static class SecondaryUnit {

        @XmlElement(name = "IfcDerivedUnit", nillable = true)
        protected IfcDerivedUnit ifcDerivedUnit;
        @XmlElement(name = "IfcMonetaryUnit", nillable = true)
        protected IfcMonetaryUnit ifcMonetaryUnit;
        @XmlElementRef(name = "IfcNamedUnit", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcNamedUnit> ifcNamedUnit;

        /**
         * Gets the value of the ifcDerivedUnit property.
         * 
         * @return
         *     possible object is
         *     {@link IfcDerivedUnit }
         *     
         */
        public IfcDerivedUnit getIfcDerivedUnit() {
            return ifcDerivedUnit;
        }

        /**
         * Sets the value of the ifcDerivedUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcDerivedUnit }
         *     
         */
        public void setIfcDerivedUnit(IfcDerivedUnit value) {
            this.ifcDerivedUnit = value;
        }

        /**
         * Gets the value of the ifcMonetaryUnit property.
         * 
         * @return
         *     possible object is
         *     {@link IfcMonetaryUnit }
         *     
         */
        public IfcMonetaryUnit getIfcMonetaryUnit() {
            return ifcMonetaryUnit;
        }

        /**
         * Sets the value of the ifcMonetaryUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcMonetaryUnit }
         *     
         */
        public void setIfcMonetaryUnit(IfcMonetaryUnit value) {
            this.ifcMonetaryUnit = value;
        }

        /**
         * Gets the value of the ifcNamedUnit property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnitWithOffset }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSIUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcNamedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcContextDependentUnit }{@code >}
         *     
         */
        public JAXBElement<? extends IfcNamedUnit> getIfcNamedUnit() {
            return ifcNamedUnit;
        }

        /**
         * Sets the value of the ifcNamedUnit property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnitWithOffset }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSIUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcNamedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcConversionBasedUnit }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcContextDependentUnit }{@code >}
         *     
         */
        public void setIfcNamedUnit(JAXBElement<? extends IfcNamedUnit> value) {
            this.ifcNamedUnit = value;
        }

    }

}