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
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for IfcRecurrencePattern complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcRecurrencePattern">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}Entity">
 *       &lt;sequence>
 *         &lt;element name="TimePeriods" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcTimePeriod" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcTimePeriod""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}arraySize"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="RecurrenceType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcRecurrenceTypeEnum" />
 *       &lt;attribute name="DayComponent">
 *         &lt;simpleType>
 *           &lt;restriction>
 *             &lt;simpleType>
 *               &lt;list itemType="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDayInMonthNumber" />
 *             &lt;/simpleType>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="WeekdayComponent">
 *         &lt;simpleType>
 *           &lt;restriction>
 *             &lt;simpleType>
 *               &lt;list itemType="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDayInWeekNumber" />
 *             &lt;/simpleType>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="MonthComponent">
 *         &lt;simpleType>
 *           &lt;restriction>
 *             &lt;simpleType>
 *               &lt;list itemType="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcMonthInYearNumber" />
 *             &lt;/simpleType>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Position" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcInteger" />
 *       &lt;attribute name="Interval" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcInteger" />
 *       &lt;attribute name="Occurrences" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcRecurrencePattern", propOrder = {
    "timePeriods"
})
public class IfcRecurrencePattern
    extends Entity
{

    @XmlElementRef(name = "TimePeriods", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcRecurrencePattern.TimePeriods> timePeriods;
    @XmlAttribute(name = "RecurrenceType")
    protected IfcRecurrenceTypeEnum recurrenceType;
    @XmlAttribute(name = "DayComponent")
    protected List<Long> dayComponent;
    @XmlAttribute(name = "WeekdayComponent")
    protected List<Long> weekdayComponent;
    @XmlAttribute(name = "MonthComponent")
    protected List<Long> monthComponent;
    @XmlAttribute(name = "Position")
    protected Long position;
    @XmlAttribute(name = "Interval")
    protected Long interval;
    @XmlAttribute(name = "Occurrences")
    protected Long occurrences;

    /**
     * Gets the value of the timePeriods property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcRecurrencePattern.TimePeriods }{@code >}
     *     
     */
    public JAXBElement<IfcRecurrencePattern.TimePeriods> getTimePeriods() {
        return timePeriods;
    }

    /**
     * Sets the value of the timePeriods property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcRecurrencePattern.TimePeriods }{@code >}
     *     
     */
    public void setTimePeriods(JAXBElement<IfcRecurrencePattern.TimePeriods> value) {
        this.timePeriods = value;
    }

    /**
     * Gets the value of the recurrenceType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcRecurrenceTypeEnum }
     *     
     */
    public IfcRecurrenceTypeEnum getRecurrenceType() {
        return recurrenceType;
    }

    /**
     * Sets the value of the recurrenceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcRecurrenceTypeEnum }
     *     
     */
    public void setRecurrenceType(IfcRecurrenceTypeEnum value) {
        this.recurrenceType = value;
    }

    /**
     * Gets the value of the dayComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dayComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDayComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getDayComponent() {
        if (dayComponent == null) {
            dayComponent = new ArrayList<Long>();
        }
        return this.dayComponent;
    }

    /**
     * Gets the value of the weekdayComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the weekdayComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWeekdayComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getWeekdayComponent() {
        if (weekdayComponent == null) {
            weekdayComponent = new ArrayList<Long>();
        }
        return this.weekdayComponent;
    }

    /**
     * Gets the value of the monthComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the monthComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMonthComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getMonthComponent() {
        if (monthComponent == null) {
            monthComponent = new ArrayList<Long>();
        }
        return this.monthComponent;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPosition(Long value) {
        this.position = value;
    }

    /**
     * Gets the value of the interval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterval(Long value) {
        this.interval = value;
    }

    /**
     * Gets the value of the occurrences property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOccurrences() {
        return occurrences;
    }

    /**
     * Sets the value of the occurrences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOccurrences(Long value) {
        this.occurrences = value;
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
     *         &lt;element ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcTimePeriod" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcTimePeriod""/>
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
        "ifcTimePeriod"
    })
    public static class TimePeriods {

        @XmlElement(name = "IfcTimePeriod", required = true, nillable = true)
        protected List<IfcTimePeriod> ifcTimePeriod;
        @XmlAttribute(name = "itemType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<QName> itemType;
        @XmlAttribute(name = "cType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<AggregateType> cType;
        @XmlAttribute(name = "arraySize", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<BigInteger> arraySize;

        /**
         * Gets the value of the ifcTimePeriod property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ifcTimePeriod property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIfcTimePeriod().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IfcTimePeriod }
         * 
         * 
         */
        public List<IfcTimePeriod> getIfcTimePeriod() {
            if (ifcTimePeriod == null) {
                ifcTimePeriod = new ArrayList<IfcTimePeriod>();
            }
            return this.ifcTimePeriod;
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
