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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for IfcBSplineCurve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcBSplineCurve">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBoundedCurve">
 *       &lt;sequence>
 *         &lt;element name="ControlPointsList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcCartesianPoint" maxOccurs="unbounded" minOccurs="2"/>
 *                 &lt;/sequence>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcCartesianPoint""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}arraySize"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Degree" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcInteger" />
 *       &lt;attribute name="CurveForm" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBSplineCurveForm" />
 *       &lt;attribute name="ClosedCurve" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLogical" />
 *       &lt;attribute name="SelfIntersect" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLogical" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcBSplineCurve", propOrder = {
    "controlPointsList"
})
@XmlSeeAlso({
    IfcBSplineCurveWithKnots.class
})
public abstract class IfcBSplineCurve
    extends IfcBoundedCurve
{

    @XmlElement(name = "ControlPointsList", required = true)
    protected IfcBSplineCurve.ControlPointsList controlPointsList;
    @XmlAttribute(name = "Degree")
    protected Long degree;
    @XmlAttribute(name = "CurveForm")
    protected IfcBSplineCurveForm curveForm;
    @XmlAttribute(name = "ClosedCurve")
    protected Logical closedCurve;
    @XmlAttribute(name = "SelfIntersect")
    protected Logical selfIntersect;

    /**
     * Gets the value of the controlPointsList property.
     * 
     * @return
     *     possible object is
     *     {@link IfcBSplineCurve.ControlPointsList }
     *     
     */
    public IfcBSplineCurve.ControlPointsList getControlPointsList() {
        return controlPointsList;
    }

    /**
     * Sets the value of the controlPointsList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcBSplineCurve.ControlPointsList }
     *     
     */
    public void setControlPointsList(IfcBSplineCurve.ControlPointsList value) {
        this.controlPointsList = value;
    }

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDegree(Long value) {
        this.degree = value;
    }

    /**
     * Gets the value of the curveForm property.
     * 
     * @return
     *     possible object is
     *     {@link IfcBSplineCurveForm }
     *     
     */
    public IfcBSplineCurveForm getCurveForm() {
        return curveForm;
    }

    /**
     * Sets the value of the curveForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcBSplineCurveForm }
     *     
     */
    public void setCurveForm(IfcBSplineCurveForm value) {
        this.curveForm = value;
    }

    /**
     * Gets the value of the closedCurve property.
     * 
     * @return
     *     possible object is
     *     {@link Logical }
     *     
     */
    public Logical getClosedCurve() {
        return closedCurve;
    }

    /**
     * Sets the value of the closedCurve property.
     * 
     * @param value
     *     allowed object is
     *     {@link Logical }
     *     
     */
    public void setClosedCurve(Logical value) {
        this.closedCurve = value;
    }

    /**
     * Gets the value of the selfIntersect property.
     * 
     * @return
     *     possible object is
     *     {@link Logical }
     *     
     */
    public Logical getSelfIntersect() {
        return selfIntersect;
    }

    /**
     * Sets the value of the selfIntersect property.
     * 
     * @param value
     *     allowed object is
     *     {@link Logical }
     *     
     */
    public void setSelfIntersect(Logical value) {
        this.selfIntersect = value;
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
     *       &lt;sequence>
     *         &lt;element ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcCartesianPoint" maxOccurs="unbounded" minOccurs="2"/>
     *       &lt;/sequence>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcCartesianPoint""/>
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
        "ifcCartesianPoint"
    })
    public static class ControlPointsList {

        @XmlElement(name = "IfcCartesianPoint", required = true, nillable = true)
        protected List<IfcCartesianPoint> ifcCartesianPoint;
        @XmlAttribute(name = "itemType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<QName> itemType;
        @XmlAttribute(name = "cType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<AggregateType> cType;
        @XmlAttribute(name = "arraySize", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<BigInteger> arraySize;

        /**
         * Gets the value of the ifcCartesianPoint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ifcCartesianPoint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIfcCartesianPoint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IfcCartesianPoint }
         * 
         * 
         */
        public List<IfcCartesianPoint> getIfcCartesianPoint() {
            if (ifcCartesianPoint == null) {
                ifcCartesianPoint = new ArrayList<IfcCartesianPoint>();
            }
            return this.ifcCartesianPoint;
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