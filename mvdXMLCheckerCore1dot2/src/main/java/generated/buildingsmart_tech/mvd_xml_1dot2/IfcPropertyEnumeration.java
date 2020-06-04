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
 * <p>Java class for IfcPropertyEnumeration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IfcPropertyEnumeration">
 *   &lt;complexContent>
 *     &lt;extension base="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcPropertyAbstraction">
 *       &lt;sequence>
 *         &lt;element name="EnumerationValues">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcValue" maxOccurs="unbounded"/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcValue""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list-unique""/>
 *                 &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}arraySize"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Unit" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcUnit"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" type="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcLabel" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IfcPropertyEnumeration", propOrder = {
    "enumerationValues",
    "unit"
})
public class IfcPropertyEnumeration
    extends IfcPropertyAbstraction
{

    @XmlElement(name = "EnumerationValues", required = true)
    protected IfcPropertyEnumeration.EnumerationValues enumerationValues;
    @XmlElementRef(name = "Unit", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1", type = JAXBElement.class, required = false)
    protected JAXBElement<IfcPropertyEnumeration.Unit> unit;
    @XmlAttribute(name = "Name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String name;

    /**
     * Gets the value of the enumerationValues property.
     * 
     * @return
     *     possible object is
     *     {@link IfcPropertyEnumeration.EnumerationValues }
     *     
     */
    public IfcPropertyEnumeration.EnumerationValues getEnumerationValues() {
        return enumerationValues;
    }

    /**
     * Sets the value of the enumerationValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link IfcPropertyEnumeration.EnumerationValues }
     *     
     */
    public void setEnumerationValues(IfcPropertyEnumeration.EnumerationValues value) {
        this.enumerationValues = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyEnumeration.Unit }{@code >}
     *     
     */
    public JAXBElement<IfcPropertyEnumeration.Unit> getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IfcPropertyEnumeration.Unit }{@code >}
     *     
     */
    public void setUnit(JAXBElement<IfcPropertyEnumeration.Unit> value) {
        this.unit = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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
     *       &lt;group ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}IfcValue" maxOccurs="unbounded"/>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}itemType fixed="ifc:IfcValue""/>
     *       &lt;attribute ref="{https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1}cType fixed="list-unique""/>
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
        "ifcValue"
    })
    public static class EnumerationValues {

        @XmlElements({
            @XmlElement(name = "IfcAbsorbedDoseMeasure-wrapper", type = IfcAbsorbedDoseMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcAccelerationMeasure-wrapper", type = IfcAccelerationMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcAmountOfSubstanceMeasure-wrapper", type = IfcAmountOfSubstanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcAngularVelocityMeasure-wrapper", type = IfcAngularVelocityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcAreaDensityMeasure-wrapper", type = IfcAreaDensityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcAreaMeasure-wrapper", type = IfcAreaMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcBinary-wrapper", type = IfcBinaryWrapper.class, nillable = true),
            @XmlElement(name = "IfcBoolean-wrapper", type = IfcBooleanWrapper.class, nillable = true),
            @XmlElement(name = "IfcComplexNumber-wrapper", type = IfcComplexNumberWrapper.class, nillable = true),
            @XmlElement(name = "IfcCompoundPlaneAngleMeasure-wrapper", type = IfcCompoundPlaneAngleMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcContextDependentMeasure-wrapper", type = IfcContextDependentMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcCountMeasure-wrapper", type = IfcCountMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcCurvatureMeasure-wrapper", type = IfcCurvatureMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcDate-wrapper", type = IfcDateWrapper.class, nillable = true),
            @XmlElement(name = "IfcDateTime-wrapper", type = IfcDateTimeWrapper.class, nillable = true),
            @XmlElement(name = "IfcDescriptiveMeasure-wrapper", type = IfcDescriptiveMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcDoseEquivalentMeasure-wrapper", type = IfcDoseEquivalentMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcDuration-wrapper", type = IfcDurationWrapper.class, nillable = true),
            @XmlElement(name = "IfcDynamicViscosityMeasure-wrapper", type = IfcDynamicViscosityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricCapacitanceMeasure-wrapper", type = IfcElectricCapacitanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricChargeMeasure-wrapper", type = IfcElectricChargeMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricConductanceMeasure-wrapper", type = IfcElectricConductanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricCurrentMeasure-wrapper", type = IfcElectricCurrentMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricResistanceMeasure-wrapper", type = IfcElectricResistanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcElectricVoltageMeasure-wrapper", type = IfcElectricVoltageMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcEnergyMeasure-wrapper", type = IfcEnergyMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcForceMeasure-wrapper", type = IfcForceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcFrequencyMeasure-wrapper", type = IfcFrequencyMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcHeatFluxDensityMeasure-wrapper", type = IfcHeatFluxDensityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcHeatingValueMeasure-wrapper", type = IfcHeatingValueMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcIdentifier-wrapper", type = IfcIdentifierWrapper.class, nillable = true),
            @XmlElement(name = "IfcIlluminanceMeasure-wrapper", type = IfcIlluminanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcInductanceMeasure-wrapper", type = IfcInductanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcInteger-wrapper", type = IfcIntegerWrapper.class, nillable = true),
            @XmlElement(name = "IfcIntegerCountRateMeasure-wrapper", type = IfcIntegerCountRateMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcIonConcentrationMeasure-wrapper", type = IfcIonConcentrationMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcIsothermalMoistureCapacityMeasure-wrapper", type = IfcIsothermalMoistureCapacityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcKinematicViscosityMeasure-wrapper", type = IfcKinematicViscosityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLabel-wrapper", type = IfcLabelWrapper.class, nillable = true),
            @XmlElement(name = "IfcLengthMeasure-wrapper", type = IfcLengthMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLinearForceMeasure-wrapper", type = IfcLinearForceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLinearMomentMeasure-wrapper", type = IfcLinearMomentMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLinearStiffnessMeasure-wrapper", type = IfcLinearStiffnessMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLinearVelocityMeasure-wrapper", type = IfcLinearVelocityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLogical-wrapper", type = IfcLogicalWrapper.class, nillable = true),
            @XmlElement(name = "IfcLuminousFluxMeasure-wrapper", type = IfcLuminousFluxMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLuminousIntensityDistributionMeasure-wrapper", type = IfcLuminousIntensityDistributionMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcLuminousIntensityMeasure-wrapper", type = IfcLuminousIntensityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMagneticFluxDensityMeasure-wrapper", type = IfcMagneticFluxDensityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMagneticFluxMeasure-wrapper", type = IfcMagneticFluxMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMassDensityMeasure-wrapper", type = IfcMassDensityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMassFlowRateMeasure-wrapper", type = IfcMassFlowRateMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMassMeasure-wrapper", type = IfcMassMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMassPerLengthMeasure-wrapper", type = IfcMassPerLengthMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcModulusOfElasticityMeasure-wrapper", type = IfcModulusOfElasticityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcModulusOfLinearSubgradeReactionMeasure-wrapper", type = IfcModulusOfLinearSubgradeReactionMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcModulusOfRotationalSubgradeReactionMeasure-wrapper", type = IfcModulusOfRotationalSubgradeReactionMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcModulusOfSubgradeReactionMeasure-wrapper", type = IfcModulusOfSubgradeReactionMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMoistureDiffusivityMeasure-wrapper", type = IfcMoistureDiffusivityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMolecularWeightMeasure-wrapper", type = IfcMolecularWeightMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMomentOfInertiaMeasure-wrapper", type = IfcMomentOfInertiaMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcMonetaryMeasure-wrapper", type = IfcMonetaryMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcNonNegativeLengthMeasure-wrapper", type = IfcNonNegativeLengthMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcNormalisedRatioMeasure-wrapper", type = IfcNormalisedRatioMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcNumericMeasure-wrapper", type = IfcNumericMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPHMeasure-wrapper", type = IfcPHMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcParameterValue-wrapper", type = IfcParameterValueWrapper.class, nillable = true),
            @XmlElement(name = "IfcPlanarForceMeasure-wrapper", type = IfcPlanarForceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPlaneAngleMeasure-wrapper", type = IfcPlaneAngleMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPositiveInteger-wrapper", type = IfcPositiveIntegerWrapper.class, nillable = true),
            @XmlElement(name = "IfcPositiveLengthMeasure-wrapper", type = IfcPositiveLengthMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPositivePlaneAngleMeasure-wrapper", type = IfcPositivePlaneAngleMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPositiveRatioMeasure-wrapper", type = IfcPositiveRatioMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPowerMeasure-wrapper", type = IfcPowerMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcPressureMeasure-wrapper", type = IfcPressureMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcRadioActivityMeasure-wrapper", type = IfcRadioActivityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcRatioMeasure-wrapper", type = IfcRatioMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcReal-wrapper", type = IfcRealWrapper.class, nillable = true),
            @XmlElement(name = "IfcRotationalFrequencyMeasure-wrapper", type = IfcRotationalFrequencyMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcRotationalMassMeasure-wrapper", type = IfcRotationalMassMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcRotationalStiffnessMeasure-wrapper", type = IfcRotationalStiffnessMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSectionModulusMeasure-wrapper", type = IfcSectionModulusMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSectionalAreaIntegralMeasure-wrapper", type = IfcSectionalAreaIntegralMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcShearModulusMeasure-wrapper", type = IfcShearModulusMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSolidAngleMeasure-wrapper", type = IfcSolidAngleMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSoundPowerLevelMeasure-wrapper", type = IfcSoundPowerLevelMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSoundPowerMeasure-wrapper", type = IfcSoundPowerMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSoundPressureLevelMeasure-wrapper", type = IfcSoundPressureLevelMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSoundPressureMeasure-wrapper", type = IfcSoundPressureMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcSpecificHeatCapacityMeasure-wrapper", type = IfcSpecificHeatCapacityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcTemperatureGradientMeasure-wrapper", type = IfcTemperatureGradientMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcTemperatureRateOfChangeMeasure-wrapper", type = IfcTemperatureRateOfChangeMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcText-wrapper", type = IfcTextWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermalAdmittanceMeasure-wrapper", type = IfcThermalAdmittanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermalConductivityMeasure-wrapper", type = IfcThermalConductivityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermalExpansionCoefficientMeasure-wrapper", type = IfcThermalExpansionCoefficientMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermalResistanceMeasure-wrapper", type = IfcThermalResistanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermalTransmittanceMeasure-wrapper", type = IfcThermalTransmittanceMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcThermodynamicTemperatureMeasure-wrapper", type = IfcThermodynamicTemperatureMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcTime-wrapper", type = IfcTimeWrapper.class, nillable = true),
            @XmlElement(name = "IfcTimeMeasure-wrapper", type = IfcTimeMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcTimeStamp-wrapper", type = IfcTimeStampWrapper.class, nillable = true),
            @XmlElement(name = "IfcTorqueMeasure-wrapper", type = IfcTorqueMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcVaporPermeabilityMeasure-wrapper", type = IfcVaporPermeabilityMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcVolumeMeasure-wrapper", type = IfcVolumeMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcVolumetricFlowRateMeasure-wrapper", type = IfcVolumetricFlowRateMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcWarpingConstantMeasure-wrapper", type = IfcWarpingConstantMeasureWrapper.class, nillable = true),
            @XmlElement(name = "IfcWarpingMomentMeasure-wrapper", type = IfcWarpingMomentMeasureWrapper.class, nillable = true)
        })
        protected List<Object> ifcValue;
        @XmlAttribute(name = "itemType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<QName> itemType;
        @XmlAttribute(name = "cType", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<AggregateType> cType;
        @XmlAttribute(name = "arraySize", namespace = "https://standards.buildingsmart.org/IFC/RELEASE/IFC4/Add2TC1")
        protected List<BigInteger> arraySize;

        /**
         * Gets the value of the ifcValue property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ifcValue property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIfcValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IfcAbsorbedDoseMeasureWrapper }
         * {@link IfcAccelerationMeasureWrapper }
         * {@link IfcAmountOfSubstanceMeasureWrapper }
         * {@link IfcAngularVelocityMeasureWrapper }
         * {@link IfcAreaDensityMeasureWrapper }
         * {@link IfcAreaMeasureWrapper }
         * {@link IfcBinaryWrapper }
         * {@link IfcBooleanWrapper }
         * {@link IfcComplexNumberWrapper }
         * {@link IfcCompoundPlaneAngleMeasureWrapper }
         * {@link IfcContextDependentMeasureWrapper }
         * {@link IfcCountMeasureWrapper }
         * {@link IfcCurvatureMeasureWrapper }
         * {@link IfcDateWrapper }
         * {@link IfcDateTimeWrapper }
         * {@link IfcDescriptiveMeasureWrapper }
         * {@link IfcDoseEquivalentMeasureWrapper }
         * {@link IfcDurationWrapper }
         * {@link IfcDynamicViscosityMeasureWrapper }
         * {@link IfcElectricCapacitanceMeasureWrapper }
         * {@link IfcElectricChargeMeasureWrapper }
         * {@link IfcElectricConductanceMeasureWrapper }
         * {@link IfcElectricCurrentMeasureWrapper }
         * {@link IfcElectricResistanceMeasureWrapper }
         * {@link IfcElectricVoltageMeasureWrapper }
         * {@link IfcEnergyMeasureWrapper }
         * {@link IfcForceMeasureWrapper }
         * {@link IfcFrequencyMeasureWrapper }
         * {@link IfcHeatFluxDensityMeasureWrapper }
         * {@link IfcHeatingValueMeasureWrapper }
         * {@link IfcIdentifierWrapper }
         * {@link IfcIlluminanceMeasureWrapper }
         * {@link IfcInductanceMeasureWrapper }
         * {@link IfcIntegerWrapper }
         * {@link IfcIntegerCountRateMeasureWrapper }
         * {@link IfcIonConcentrationMeasureWrapper }
         * {@link IfcIsothermalMoistureCapacityMeasureWrapper }
         * {@link IfcKinematicViscosityMeasureWrapper }
         * {@link IfcLabelWrapper }
         * {@link IfcLengthMeasureWrapper }
         * {@link IfcLinearForceMeasureWrapper }
         * {@link IfcLinearMomentMeasureWrapper }
         * {@link IfcLinearStiffnessMeasureWrapper }
         * {@link IfcLinearVelocityMeasureWrapper }
         * {@link IfcLogicalWrapper }
         * {@link IfcLuminousFluxMeasureWrapper }
         * {@link IfcLuminousIntensityDistributionMeasureWrapper }
         * {@link IfcLuminousIntensityMeasureWrapper }
         * {@link IfcMagneticFluxDensityMeasureWrapper }
         * {@link IfcMagneticFluxMeasureWrapper }
         * {@link IfcMassDensityMeasureWrapper }
         * {@link IfcMassFlowRateMeasureWrapper }
         * {@link IfcMassMeasureWrapper }
         * {@link IfcMassPerLengthMeasureWrapper }
         * {@link IfcModulusOfElasticityMeasureWrapper }
         * {@link IfcModulusOfLinearSubgradeReactionMeasureWrapper }
         * {@link IfcModulusOfRotationalSubgradeReactionMeasureWrapper }
         * {@link IfcModulusOfSubgradeReactionMeasureWrapper }
         * {@link IfcMoistureDiffusivityMeasureWrapper }
         * {@link IfcMolecularWeightMeasureWrapper }
         * {@link IfcMomentOfInertiaMeasureWrapper }
         * {@link IfcMonetaryMeasureWrapper }
         * {@link IfcNonNegativeLengthMeasureWrapper }
         * {@link IfcNormalisedRatioMeasureWrapper }
         * {@link IfcNumericMeasureWrapper }
         * {@link IfcPHMeasureWrapper }
         * {@link IfcParameterValueWrapper }
         * {@link IfcPlanarForceMeasureWrapper }
         * {@link IfcPlaneAngleMeasureWrapper }
         * {@link IfcPositiveIntegerWrapper }
         * {@link IfcPositiveLengthMeasureWrapper }
         * {@link IfcPositivePlaneAngleMeasureWrapper }
         * {@link IfcPositiveRatioMeasureWrapper }
         * {@link IfcPowerMeasureWrapper }
         * {@link IfcPressureMeasureWrapper }
         * {@link IfcRadioActivityMeasureWrapper }
         * {@link IfcRatioMeasureWrapper }
         * {@link IfcRealWrapper }
         * {@link IfcRotationalFrequencyMeasureWrapper }
         * {@link IfcRotationalMassMeasureWrapper }
         * {@link IfcRotationalStiffnessMeasureWrapper }
         * {@link IfcSectionModulusMeasureWrapper }
         * {@link IfcSectionalAreaIntegralMeasureWrapper }
         * {@link IfcShearModulusMeasureWrapper }
         * {@link IfcSolidAngleMeasureWrapper }
         * {@link IfcSoundPowerLevelMeasureWrapper }
         * {@link IfcSoundPowerMeasureWrapper }
         * {@link IfcSoundPressureLevelMeasureWrapper }
         * {@link IfcSoundPressureMeasureWrapper }
         * {@link IfcSpecificHeatCapacityMeasureWrapper }
         * {@link IfcTemperatureGradientMeasureWrapper }
         * {@link IfcTemperatureRateOfChangeMeasureWrapper }
         * {@link IfcTextWrapper }
         * {@link IfcThermalAdmittanceMeasureWrapper }
         * {@link IfcThermalConductivityMeasureWrapper }
         * {@link IfcThermalExpansionCoefficientMeasureWrapper }
         * {@link IfcThermalResistanceMeasureWrapper }
         * {@link IfcThermalTransmittanceMeasureWrapper }
         * {@link IfcThermodynamicTemperatureMeasureWrapper }
         * {@link IfcTimeWrapper }
         * {@link IfcTimeMeasureWrapper }
         * {@link IfcTimeStampWrapper }
         * {@link IfcTorqueMeasureWrapper }
         * {@link IfcVaporPermeabilityMeasureWrapper }
         * {@link IfcVolumeMeasureWrapper }
         * {@link IfcVolumetricFlowRateMeasureWrapper }
         * {@link IfcWarpingConstantMeasureWrapper }
         * {@link IfcWarpingMomentMeasureWrapper }
         * 
         * 
         */
        public List<Object> getIfcValue() {
            if (ifcValue == null) {
                ifcValue = new ArrayList<Object>();
            }
            return this.ifcValue;
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
    public static class Unit {

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