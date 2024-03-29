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
 * <p>Java class for IfcPropertyReferenceValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcPropertyReferenceValue">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcSimpleProperty">
 *       &lt;sequence>
 *         &lt;element name="PropertyReference" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcObjectReferenceSelect"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="UsageName" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcText" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcPropertyReferenceValue", propOrder = {
    "propertyReference"
})
public class IfcPropertyReferenceValue
    extends IfcSimpleProperty
{

    @XmlElementRef(name = "PropertyReference", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcPropertyReferenceValue.PropertyReference> propertyReference;
    @XmlAttribute(name = "UsageName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String usageName;

    /**
     * Gets the value of the propertyReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyReferenceValue.PropertyReference }{@code >}
     *     
     */
    public JAXBElement<IfcPropertyReferenceValue.PropertyReference> getPropertyReference() {
        return propertyReference;
    }

    /**
     * Sets the value of the propertyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyReferenceValue.PropertyReference }{@code >}
     *     
     */
    public void setPropertyReference(JAXBElement<IfcPropertyReferenceValue.PropertyReference> value) {
        this.propertyReference = value;
    }

    /**
     * Gets the value of the usageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsageName() {
        return usageName;
    }

    /**
     * Sets the value of the usageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsageName(String value) {
        this.usageName = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcObjectReferenceSelect"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcAddress",
        "ifcAppliedValue",
        "ifcExternalReference",
        "ifcMaterialDefinition",
        "ifcOrganization",
        "ifcPerson",
        "ifcPersonAndOrganization",
        "ifcTable",
        "ifcTimeSeries"
    })
    public static class PropertyReference {

        @XmlElementRef(name = "IfcAddress", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcAddress> ifcAddress;
        @XmlElementRef(name = "IfcAppliedValue", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcAppliedValue> ifcAppliedValue;
        @XmlElementRef(name = "IfcExternalReference", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcExternalReference> ifcExternalReference;
        @XmlElementRef(name = "IfcMaterialDefinition", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcMaterialDefinition> ifcMaterialDefinition;
        @XmlElement(name = "IfcOrganization", nillable = true)
        protected IfcOrganization ifcOrganization;
        @XmlElement(name = "IfcPerson", nillable = true)
        protected IfcPerson ifcPerson;
        @XmlElement(name = "IfcPersonAndOrganization", nillable = true)
        protected IfcPersonAndOrganization ifcPersonAndOrganization;
        @XmlElement(name = "IfcTable", nillable = true)
        protected IfcTable ifcTable;
        @XmlElementRef(name = "IfcTimeSeries", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcTimeSeries> ifcTimeSeries;

        /**
         * Gets the value of the ifcAddress property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcTelecomAddress }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPostalAddress }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAddress }{@code >}
         *     
         */
        public JAXBElement<? extends IfcAddress> getIfcAddress() {
            return ifcAddress;
        }

        /**
         * Sets the value of the ifcAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcTelecomAddress }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPostalAddress }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAddress }{@code >}
         *     
         */
        public void setIfcAddress(JAXBElement<? extends IfcAddress> value) {
            this.ifcAddress = value;
        }

        /**
         * Gets the value of the ifcAppliedValue property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcCostValue }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAppliedValue }{@code >}
         *     
         */
        public JAXBElement<? extends IfcAppliedValue> getIfcAppliedValue() {
            return ifcAppliedValue;
        }

        /**
         * Sets the value of the ifcAppliedValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcCostValue }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAppliedValue }{@code >}
         *     
         */
        public void setIfcAppliedValue(JAXBElement<? extends IfcAppliedValue> value) {
            this.ifcAppliedValue = value;
        }

        /**
         * Gets the value of the ifcExternalReference property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcExternalReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedHatchStyle }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedSurfaceStyle }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcClassificationReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedTextFont }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcDocumentReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcLibraryReference }{@code >}
         *     
         */
        public JAXBElement<? extends IfcExternalReference> getIfcExternalReference() {
            return ifcExternalReference;
        }

        /**
         * Sets the value of the ifcExternalReference property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcExternalReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedHatchStyle }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedSurfaceStyle }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcClassificationReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExternallyDefinedTextFont }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcDocumentReference }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcLibraryReference }{@code >}
         *     
         */
        public void setIfcExternalReference(JAXBElement<? extends IfcExternalReference> value) {
            this.ifcExternalReference = value;
        }

        /**
         * Gets the value of the ifcMaterialDefinition property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayerSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialConstituentSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayer }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialConstituent }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfileWithOffsets }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfile }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayerWithOffsets }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterial }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfileSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialDefinition }{@code >}
         *     
         */
        public JAXBElement<? extends IfcMaterialDefinition> getIfcMaterialDefinition() {
            return ifcMaterialDefinition;
        }

        /**
         * Sets the value of the ifcMaterialDefinition property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayerSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialConstituentSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayer }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialConstituent }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfileWithOffsets }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfile }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialLayerWithOffsets }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterial }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialProfileSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcMaterialDefinition }{@code >}
         *     
         */
        public void setIfcMaterialDefinition(JAXBElement<? extends IfcMaterialDefinition> value) {
            this.ifcMaterialDefinition = value;
        }

        /**
         * Gets the value of the ifcOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link IfcOrganization }
         *     
         */
        public IfcOrganization getIfcOrganization() {
            return ifcOrganization;
        }

        /**
         * Sets the value of the ifcOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcOrganization }
         *     
         */
        public void setIfcOrganization(IfcOrganization value) {
            this.ifcOrganization = value;
        }

        /**
         * Gets the value of the ifcPerson property.
         * 
         * @return
         *     possible object is
         *     {@link IfcPerson }
         *     
         */
        public IfcPerson getIfcPerson() {
            return ifcPerson;
        }

        /**
         * Sets the value of the ifcPerson property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcPerson }
         *     
         */
        public void setIfcPerson(IfcPerson value) {
            this.ifcPerson = value;
        }

        /**
         * Gets the value of the ifcPersonAndOrganization property.
         * 
         * @return
         *     possible object is
         *     {@link IfcPersonAndOrganization }
         *     
         */
        public IfcPersonAndOrganization getIfcPersonAndOrganization() {
            return ifcPersonAndOrganization;
        }

        /**
         * Sets the value of the ifcPersonAndOrganization property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcPersonAndOrganization }
         *     
         */
        public void setIfcPersonAndOrganization(IfcPersonAndOrganization value) {
            this.ifcPersonAndOrganization = value;
        }

        /**
         * Gets the value of the ifcTable property.
         * 
         * @return
         *     possible object is
         *     {@link IfcTable }
         *     
         */
        public IfcTable getIfcTable() {
            return ifcTable;
        }

        /**
         * Sets the value of the ifcTable property.
         * 
         * @param value
         *     allowed object is
         *     {@link IfcTable }
         *     
         */
        public void setIfcTable(IfcTable value) {
            this.ifcTable = value;
        }

        /**
         * Gets the value of the ifcTimeSeries property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcIrregularTimeSeries }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTimeSeries }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRegularTimeSeries }{@code >}
         *     
         */
        public JAXBElement<? extends IfcTimeSeries> getIfcTimeSeries() {
            return ifcTimeSeries;
        }

        /**
         * Sets the value of the ifcTimeSeries property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcIrregularTimeSeries }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTimeSeries }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRegularTimeSeries }{@code >}
         *     
         */
        public void setIfcTimeSeries(JAXBElement<? extends IfcTimeSeries> value) {
            this.ifcTimeSeries = value;
        }

    }

}
