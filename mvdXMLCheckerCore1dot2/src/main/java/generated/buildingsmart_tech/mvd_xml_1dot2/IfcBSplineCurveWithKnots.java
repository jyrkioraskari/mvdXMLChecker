//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.27 at 01:59:57 PM CEST 
//


package generated.buildingsmart_tech.mvd_xml_1dot2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcBSplineCurveWithKnots complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcBSplineCurveWithKnots">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBSplineCurve">
 *       &lt;attribute name="KnotMultiplicities">
 *         &lt;simpleType>
 *           &lt;restriction>
 *             &lt;simpleType>
 *               &lt;list itemType="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcInteger" />
 *             &lt;/simpleType>
 *             &lt;minLength value="2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Knots">
 *         &lt;simpleType>
 *           &lt;restriction>
 *             &lt;simpleType>
 *               &lt;list itemType="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcParameterValue" />
 *             &lt;/simpleType>
 *             &lt;minLength value="2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="KnotSpec" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcKnotType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcBSplineCurveWithKnots")
@XmlSeeAlso({
    IfcRationalBSplineCurveWithKnots.class
})
public class IfcBSplineCurveWithKnots
    extends IfcBSplineCurve
{

    @XmlAttribute(name = "KnotMultiplicities")
    protected List<Long> knotMultiplicities;
    @XmlAttribute(name = "Knots")
    protected List<Double> knots;
    @XmlAttribute(name = "KnotSpec")
    protected IfcKnotType knotSpec;

    /**
     * Gets the value of the knotMultiplicities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knotMultiplicities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnotMultiplicities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getKnotMultiplicities() {
        if (knotMultiplicities == null) {
            knotMultiplicities = new ArrayList<Long>();
        }
        return this.knotMultiplicities;
    }

    /**
     * Gets the value of the knots property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knots property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnots().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getKnots() {
        if (knots == null) {
            knots = new ArrayList<Double>();
        }
        return this.knots;
    }

    /**
     * Gets the value of the knotSpec property.
     * 
     * @return
     *     possible object is
     *     {@link IfcKnotType }
     *     
     */
    public IfcKnotType getKnotSpec() {
        return knotSpec;
    }

    /**
     * Sets the value of the knotSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcKnotType }
     *     
     */
    public void setKnotSpec(IfcKnotType value) {
        this.knotSpec = value;
    }

}
