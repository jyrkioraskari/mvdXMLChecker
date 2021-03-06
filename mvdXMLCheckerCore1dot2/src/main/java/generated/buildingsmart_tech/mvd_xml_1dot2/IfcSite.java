//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IfcSite complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcSite">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcSpatialStructureElement">
 *       &lt;sequence>
 *         &lt;element name="SiteAddress" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPostalAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="RefLatitude" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}List-IfcCompoundPlaneAngleMeasure" />
 *       &lt;attribute name="RefLongitude" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}List-IfcCompoundPlaneAngleMeasure" />
 *       &lt;attribute name="RefElevation" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLengthMeasure" />
 *       &lt;attribute name="LandTitleNumber" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcSite", propOrder = {
    "siteAddress"
})
public class IfcSite
    extends IfcSpatialStructureElement
{

    @XmlElementRef(name = "SiteAddress", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcPostalAddress> siteAddress;
    @XmlAttribute(name = "RefLatitude")
    protected List<Long> refLatitude;
    @XmlAttribute(name = "RefLongitude")
    protected List<Long> refLongitude;
    @XmlAttribute(name = "RefElevation")
    protected Double refElevation;
    @XmlAttribute(name = "LandTitleNumber")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String landTitleNumber;

    /**
     * Gets the value of the siteAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcPostalAddress }{@code >}
     *     
     */
    public JAXBElement<IfcPostalAddress> getSiteAddress() {
        return siteAddress;
    }

    /**
     * Sets the value of the siteAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcPostalAddress }{@code >}
     *     
     */
    public void setSiteAddress(JAXBElement<IfcPostalAddress> value) {
        this.siteAddress = value;
    }

    /**
     * Gets the value of the refLatitude property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refLatitude property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefLatitude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getRefLatitude() {
        if (refLatitude == null) {
            refLatitude = new ArrayList<Long>();
        }
        return this.refLatitude;
    }

    /**
     * Gets the value of the refLongitude property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refLongitude property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefLongitude().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getRefLongitude() {
        if (refLongitude == null) {
            refLongitude = new ArrayList<Long>();
        }
        return this.refLongitude;
    }

    /**
     * Gets the value of the refElevation property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRefElevation() {
        return refElevation;
    }

    /**
     * Sets the value of the refElevation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRefElevation(Double value) {
        this.refElevation = value;
    }

    /**
     * Gets the value of the landTitleNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandTitleNumber() {
        return landTitleNumber;
    }

    /**
     * Sets the value of the landTitleNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandTitleNumber(String value) {
        this.landTitleNumber = value;
    }

}
