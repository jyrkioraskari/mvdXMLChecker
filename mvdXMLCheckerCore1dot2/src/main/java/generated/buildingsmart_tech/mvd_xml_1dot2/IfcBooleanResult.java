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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IfcBooleanResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcBooleanResult">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcGeometricRepresentationItem">
 *       &lt;sequence>
 *         &lt;element name="FirstOperand">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBooleanOperand"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SecondOperand">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBooleanOperand"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Operator" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBooleanOperator" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcBooleanResult", propOrder = {
    "firstOperand",
    "secondOperand"
})
@XmlSeeAlso({
    IfcBooleanClippingResult.class
})
public class IfcBooleanResult
    extends IfcGeometricRepresentationItem
{

    @XmlElement(name = "FirstOperand", required = true)
    protected IfcBooleanResult.FirstOperand firstOperand;
    @XmlElement(name = "SecondOperand", required = true)
    protected IfcBooleanResult.SecondOperand secondOperand;
    @XmlAttribute(name = "Operator")
    protected IfcBooleanOperator operator;

    /**
     * Gets the value of the firstOperand property.
     * 
     * @return
     *     possible object is
     *     {@link IfcBooleanResult.FirstOperand }
     *     
     */
    public IfcBooleanResult.FirstOperand getFirstOperand() {
        return firstOperand;
    }

    /**
     * Sets the value of the firstOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcBooleanResult.FirstOperand }
     *     
     */
    public void setFirstOperand(IfcBooleanResult.FirstOperand value) {
        this.firstOperand = value;
    }

    /**
     * Gets the value of the secondOperand property.
     * 
     * @return
     *     possible object is
     *     {@link IfcBooleanResult.SecondOperand }
     *     
     */
    public IfcBooleanResult.SecondOperand getSecondOperand() {
        return secondOperand;
    }

    /**
     * Sets the value of the secondOperand property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcBooleanResult.SecondOperand }
     *     
     */
    public void setSecondOperand(IfcBooleanResult.SecondOperand value) {
        this.secondOperand = value;
    }

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link IfcBooleanOperator }
     *     
     */
    public IfcBooleanOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcBooleanOperator }
     *     
     */
    public void setOperator(IfcBooleanOperator value) {
        this.operator = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBooleanOperand"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcBooleanResult",
        "ifcCsgPrimitive3D",
        "ifcHalfSpaceSolid",
        "ifcSolidModel",
        "ifcTessellatedFaceSet"
    })
    public static class FirstOperand {

        @XmlElementRef(name = "IfcBooleanResult", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcBooleanResult> ifcBooleanResult;
        @XmlElementRef(name = "IfcCsgPrimitive3D", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcCsgPrimitive3D> ifcCsgPrimitive3D;
        @XmlElementRef(name = "IfcHalfSpaceSolid", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcHalfSpaceSolid> ifcHalfSpaceSolid;
        @XmlElementRef(name = "IfcSolidModel", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcSolidModel> ifcSolidModel;
        @XmlElementRef(name = "IfcTessellatedFaceSet", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcTessellatedFaceSet> ifcTessellatedFaceSet;

        /**
         * Gets the value of the ifcBooleanResult property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcBooleanClippingResult }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBooleanResult }{@code >}
         *     
         */
        public JAXBElement<? extends IfcBooleanResult> getIfcBooleanResult() {
            return ifcBooleanResult;
        }

        /**
         * Sets the value of the ifcBooleanResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcBooleanClippingResult }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBooleanResult }{@code >}
         *     
         */
        public void setIfcBooleanResult(JAXBElement<? extends IfcBooleanResult> value) {
            this.ifcBooleanResult = value;
        }

        /**
         * Gets the value of the ifcCsgPrimitive3D property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCone }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBlock }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcCsgPrimitive3D }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRectangularPyramid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCylinder }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSphere }{@code >}
         *     
         */
        public JAXBElement<? extends IfcCsgPrimitive3D> getIfcCsgPrimitive3D() {
            return ifcCsgPrimitive3D;
        }

        /**
         * Sets the value of the ifcCsgPrimitive3D property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCone }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBlock }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcCsgPrimitive3D }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRectangularPyramid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCylinder }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSphere }{@code >}
         *     
         */
        public void setIfcCsgPrimitive3D(JAXBElement<? extends IfcCsgPrimitive3D> value) {
            this.ifcCsgPrimitive3D = value;
        }

        /**
         * Gets the value of the ifcHalfSpaceSolid property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcBoxedHalfSpace }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcHalfSpaceSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalBoundedHalfSpace }{@code >}
         *     
         */
        public JAXBElement<? extends IfcHalfSpaceSolid> getIfcHalfSpaceSolid() {
            return ifcHalfSpaceSolid;
        }

        /**
         * Sets the value of the ifcHalfSpaceSolid property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcBoxedHalfSpace }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcHalfSpaceSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalBoundedHalfSpace }{@code >}
         *     
         */
        public void setIfcHalfSpaceSolid(JAXBElement<? extends IfcHalfSpaceSolid> value) {
            this.ifcHalfSpaceSolid = value;
        }

        /**
         * Gets the value of the ifcSolidModel property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcCsgSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSurfaceCurveSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSolidModel }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolidTapered }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolidPolygonal }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcManifoldSolidBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFixedReferenceSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolidTapered }{@code >}
         *     
         */
        public JAXBElement<? extends IfcSolidModel> getIfcSolidModel() {
            return ifcSolidModel;
        }

        /**
         * Sets the value of the ifcSolidModel property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcCsgSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSurfaceCurveSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSolidModel }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolidTapered }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolidPolygonal }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcManifoldSolidBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFixedReferenceSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolidTapered }{@code >}
         *     
         */
        public void setIfcSolidModel(JAXBElement<? extends IfcSolidModel> value) {
            this.ifcSolidModel = value;
        }

        /**
         * Gets the value of the ifcTessellatedFaceSet property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTessellatedFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTriangulatedFaceSet }{@code >}
         *     
         */
        public JAXBElement<? extends IfcTessellatedFaceSet> getIfcTessellatedFaceSet() {
            return ifcTessellatedFaceSet;
        }

        /**
         * Sets the value of the ifcTessellatedFaceSet property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTessellatedFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTriangulatedFaceSet }{@code >}
         *     
         */
        public void setIfcTessellatedFaceSet(JAXBElement<? extends IfcTessellatedFaceSet> value) {
            this.ifcTessellatedFaceSet = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcBooleanOperand"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ifcBooleanResult",
        "ifcCsgPrimitive3D",
        "ifcHalfSpaceSolid",
        "ifcSolidModel",
        "ifcTessellatedFaceSet"
    })
    public static class SecondOperand {

        @XmlElementRef(name = "IfcBooleanResult", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcBooleanResult> ifcBooleanResult;
        @XmlElementRef(name = "IfcCsgPrimitive3D", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcCsgPrimitive3D> ifcCsgPrimitive3D;
        @XmlElementRef(name = "IfcHalfSpaceSolid", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcHalfSpaceSolid> ifcHalfSpaceSolid;
        @XmlElementRef(name = "IfcSolidModel", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcSolidModel> ifcSolidModel;
        @XmlElementRef(name = "IfcTessellatedFaceSet", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
        protected JAXBElement<? extends IfcTessellatedFaceSet> ifcTessellatedFaceSet;

        /**
         * Gets the value of the ifcBooleanResult property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcBooleanClippingResult }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBooleanResult }{@code >}
         *     
         */
        public JAXBElement<? extends IfcBooleanResult> getIfcBooleanResult() {
            return ifcBooleanResult;
        }

        /**
         * Sets the value of the ifcBooleanResult property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcBooleanClippingResult }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBooleanResult }{@code >}
         *     
         */
        public void setIfcBooleanResult(JAXBElement<? extends IfcBooleanResult> value) {
            this.ifcBooleanResult = value;
        }

        /**
         * Gets the value of the ifcCsgPrimitive3D property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCone }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBlock }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcCsgPrimitive3D }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRectangularPyramid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCylinder }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSphere }{@code >}
         *     
         */
        public JAXBElement<? extends IfcCsgPrimitive3D> getIfcCsgPrimitive3D() {
            return ifcCsgPrimitive3D;
        }

        /**
         * Sets the value of the ifcCsgPrimitive3D property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCone }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcBlock }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcCsgPrimitive3D }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRectangularPyramid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRightCircularCylinder }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSphere }{@code >}
         *     
         */
        public void setIfcCsgPrimitive3D(JAXBElement<? extends IfcCsgPrimitive3D> value) {
            this.ifcCsgPrimitive3D = value;
        }

        /**
         * Gets the value of the ifcHalfSpaceSolid property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcBoxedHalfSpace }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcHalfSpaceSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalBoundedHalfSpace }{@code >}
         *     
         */
        public JAXBElement<? extends IfcHalfSpaceSolid> getIfcHalfSpaceSolid() {
            return ifcHalfSpaceSolid;
        }

        /**
         * Sets the value of the ifcHalfSpaceSolid property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcBoxedHalfSpace }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcHalfSpaceSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalBoundedHalfSpace }{@code >}
         *     
         */
        public void setIfcHalfSpaceSolid(JAXBElement<? extends IfcHalfSpaceSolid> value) {
            this.ifcHalfSpaceSolid = value;
        }

        /**
         * Gets the value of the ifcSolidModel property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcCsgSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSurfaceCurveSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSolidModel }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolidTapered }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolidPolygonal }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcManifoldSolidBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFixedReferenceSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolidTapered }{@code >}
         *     
         */
        public JAXBElement<? extends IfcSolidModel> getIfcSolidModel() {
            return ifcSolidModel;
        }

        /**
         * Sets the value of the ifcSolidModel property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcCsgSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSurfaceCurveSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSolidModel }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcExtrudedAreaSolidTapered }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFacetedBrepWithVoids }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcSweptDiskSolidPolygonal }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcAdvancedBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcManifoldSolidBrep }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcFixedReferenceSweptAreaSolid }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcRevolvedAreaSolidTapered }{@code >}
         *     
         */
        public void setIfcSolidModel(JAXBElement<? extends IfcSolidModel> value) {
            this.ifcSolidModel = value;
        }

        /**
         * Gets the value of the ifcTessellatedFaceSet property.
         * 
         * @return
         *     possible object is
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTessellatedFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTriangulatedFaceSet }{@code >}
         *     
         */
        public JAXBElement<? extends IfcTessellatedFaceSet> getIfcTessellatedFaceSet() {
            return ifcTessellatedFaceSet;
        }

        /**
         * Sets the value of the ifcTessellatedFaceSet property.
         * 
         * @param value
         *     allowed object is
         *     {@link JAXBElement }{@code <}{@link IfcPolygonalFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTessellatedFaceSet }{@code >}
         *     {@link JAXBElement }{@code <}{@link IfcTriangulatedFaceSet }{@code >}
         *     
         */
        public void setIfcTessellatedFaceSet(JAXBElement<? extends IfcTessellatedFaceSet> value) {
            this.ifcTessellatedFaceSet = value;
        }

    }

}