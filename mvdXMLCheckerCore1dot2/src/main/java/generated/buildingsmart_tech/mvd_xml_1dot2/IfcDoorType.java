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
 * <p>Java class for IfcDoorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcDoorType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBuildingElementType">
 *       &lt;attribute name="PredefinedType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDoorTypeEnum" />
 *       &lt;attribute name="OperationType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcDoorTypeOperationEnum" />
 *       &lt;attribute name="ParameterTakesPrecedence" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBoolean" />
 *       &lt;attribute name="UserDefinedOperationType" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcDoorType")
public class IfcDoorType
    extends IfcBuildingElementType
{

    @XmlAttribute(name = "PredefinedType")
    protected IfcDoorTypeEnum predefinedType;
    @XmlAttribute(name = "OperationType")
    protected IfcDoorTypeOperationEnum operationType;
    @XmlAttribute(name = "ParameterTakesPrecedence")
    protected Boolean parameterTakesPrecedence;
    @XmlAttribute(name = "UserDefinedOperationType")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String userDefinedOperationType;

    /**
     * Gets the value of the predefinedType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcDoorTypeEnum }
     *     
     */
    public IfcDoorTypeEnum getPredefinedType() {
        return predefinedType;
    }

    /**
     * Sets the value of the predefinedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcDoorTypeEnum }
     *     
     */
    public void setPredefinedType(IfcDoorTypeEnum value) {
        this.predefinedType = value;
    }

    /**
     * Gets the value of the operationType property.
     * 
     * @return
     *     possible object is
     *     {@link IfcDoorTypeOperationEnum }
     *     
     */
    public IfcDoorTypeOperationEnum getOperationType() {
        return operationType;
    }

    /**
     * Sets the value of the operationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcDoorTypeOperationEnum }
     *     
     */
    public void setOperationType(IfcDoorTypeOperationEnum value) {
        this.operationType = value;
    }

    /**
     * Gets the value of the parameterTakesPrecedence property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isParameterTakesPrecedence() {
        return parameterTakesPrecedence;
    }

    /**
     * Sets the value of the parameterTakesPrecedence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setParameterTakesPrecedence(Boolean value) {
        this.parameterTakesPrecedence = value;
    }

    /**
     * Gets the value of the userDefinedOperationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserDefinedOperationType() {
        return userDefinedOperationType;
    }

    /**
     * Sets the value of the userDefinedOperationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserDefinedOperationType(String value) {
        this.userDefinedOperationType = value;
    }

}