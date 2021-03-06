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
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IfcResourceTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcResourceTime">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcSchedulingTime">
 *       &lt;attribute name="ScheduleWork" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDuration" />
 *       &lt;attribute name="ScheduleUsage" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveRatioMeasure" />
 *       &lt;attribute name="ScheduleStart" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDateTime" />
 *       &lt;attribute name="ScheduleFinish" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDateTime" />
 *       &lt;attribute name="ScheduleContour" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *       &lt;attribute name="LevelingDelay" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDuration" />
 *       &lt;attribute name="IsOverAllocated" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBoolean" />
 *       &lt;attribute name="StatusTime" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDateTime" />
 *       &lt;attribute name="ActualWork" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDuration" />
 *       &lt;attribute name="ActualUsage" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveRatioMeasure" />
 *       &lt;attribute name="ActualStart" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDateTime" />
 *       &lt;attribute name="ActualFinish" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDateTime" />
 *       &lt;attribute name="RemainingWork" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDuration" />
 *       &lt;attribute name="RemainingUsage" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveRatioMeasure" />
 *       &lt;attribute name="Completion" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPositiveRatioMeasure" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcResourceTime")
public class IfcResourceTime
    extends IfcSchedulingTime
{

    @XmlAttribute(name = "ScheduleWork")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scheduleWork;
    @XmlAttribute(name = "ScheduleUsage")
    protected Double scheduleUsage;
    @XmlAttribute(name = "ScheduleStart")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scheduleStart;
    @XmlAttribute(name = "ScheduleFinish")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scheduleFinish;
    @XmlAttribute(name = "ScheduleContour")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String scheduleContour;
    @XmlAttribute(name = "LevelingDelay")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String levelingDelay;
    @XmlAttribute(name = "IsOverAllocated")
    protected Boolean isOverAllocated;
    @XmlAttribute(name = "StatusTime")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statusTime;
    @XmlAttribute(name = "ActualWork")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String actualWork;
    @XmlAttribute(name = "ActualUsage")
    protected Double actualUsage;
    @XmlAttribute(name = "ActualStart")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String actualStart;
    @XmlAttribute(name = "ActualFinish")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String actualFinish;
    @XmlAttribute(name = "RemainingWork")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String remainingWork;
    @XmlAttribute(name = "RemainingUsage")
    protected Double remainingUsage;
    @XmlAttribute(name = "Completion")
    protected Double completion;

    /**
     * Gets the value of the scheduleWork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleWork() {
        return scheduleWork;
    }

    /**
     * Sets the value of the scheduleWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleWork(String value) {
        this.scheduleWork = value;
    }

    /**
     * Gets the value of the scheduleUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getScheduleUsage() {
        return scheduleUsage;
    }

    /**
     * Sets the value of the scheduleUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setScheduleUsage(Double value) {
        this.scheduleUsage = value;
    }

    /**
     * Gets the value of the scheduleStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleStart() {
        return scheduleStart;
    }

    /**
     * Sets the value of the scheduleStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleStart(String value) {
        this.scheduleStart = value;
    }

    /**
     * Gets the value of the scheduleFinish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleFinish() {
        return scheduleFinish;
    }

    /**
     * Sets the value of the scheduleFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleFinish(String value) {
        this.scheduleFinish = value;
    }

    /**
     * Gets the value of the scheduleContour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleContour() {
        return scheduleContour;
    }

    /**
     * Sets the value of the scheduleContour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleContour(String value) {
        this.scheduleContour = value;
    }

    /**
     * Gets the value of the levelingDelay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelingDelay() {
        return levelingDelay;
    }

    /**
     * Sets the value of the levelingDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelingDelay(String value) {
        this.levelingDelay = value;
    }

    /**
     * Gets the value of the isOverAllocated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsOverAllocated() {
        return isOverAllocated;
    }

    /**
     * Sets the value of the isOverAllocated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsOverAllocated(Boolean value) {
        this.isOverAllocated = value;
    }

    /**
     * Gets the value of the statusTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusTime() {
        return statusTime;
    }

    /**
     * Sets the value of the statusTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusTime(String value) {
        this.statusTime = value;
    }

    /**
     * Gets the value of the actualWork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualWork() {
        return actualWork;
    }

    /**
     * Sets the value of the actualWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualWork(String value) {
        this.actualWork = value;
    }

    /**
     * Gets the value of the actualUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActualUsage() {
        return actualUsage;
    }

    /**
     * Sets the value of the actualUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActualUsage(Double value) {
        this.actualUsage = value;
    }

    /**
     * Gets the value of the actualStart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualStart() {
        return actualStart;
    }

    /**
     * Sets the value of the actualStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualStart(String value) {
        this.actualStart = value;
    }

    /**
     * Gets the value of the actualFinish property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualFinish() {
        return actualFinish;
    }

    /**
     * Sets the value of the actualFinish property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualFinish(String value) {
        this.actualFinish = value;
    }

    /**
     * Gets the value of the remainingWork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemainingWork() {
        return remainingWork;
    }

    /**
     * Sets the value of the remainingWork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemainingWork(String value) {
        this.remainingWork = value;
    }

    /**
     * Gets the value of the remainingUsage property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRemainingUsage() {
        return remainingUsage;
    }

    /**
     * Sets the value of the remainingUsage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRemainingUsage(Double value) {
        this.remainingUsage = value;
    }

    /**
     * Gets the value of the completion property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCompletion() {
        return completion;
    }

    /**
     * Sets the value of the completion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCompletion(Double value) {
        this.completion = value;
    }

}
