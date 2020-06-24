package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import java.util.ArrayList;
import java.util.List;

import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot1.TemplateRules.TemplateRule;

public class MVDConceptConstraint {

    private final ConceptRoot conceptRoot;
    private final Concept concept;
    private final ConceptTemplate concept_conceptTemplate;
    private final ConceptTemplate applicability_conceptTemplate;

    private final List<AttributeRule> applicability_attributeRules;
    private final List<AttributeRule> concept_attributeRules;
    @SuppressWarnings("unused")
    private final String requirement;
    private List<TemplateRule> applicability_templateRules;
    private String applicability_operator;
    private final List<TemplateRule> concept_templateRules;
    private String concept_operator;

    public MVDConceptConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate concept_conceptTemplate, ConceptTemplate applicability_conceptTemplate) {
	this(conceptRoot, concept, concept_conceptTemplate, applicability_conceptTemplate, null);

    }

    public MVDConceptConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate concept_conceptTemplate, ConceptTemplate applicability_conceptTemplate, String requirement) {
	if (concept.getTemplateRules() != null)
	    this.concept_operator = concept.getTemplateRules().getOperator();
	if (this.concept_operator == null)
	    this.concept_operator = "and";

	try {
	    if (conceptRoot.getApplicability().getTemplateRules() != null)
		this.applicability_operator = conceptRoot.getApplicability().getTemplateRules().getOperator();
	    if (this.applicability_operator == null)
		this.applicability_operator = "and";
	} catch (Exception e) {
	    this.applicability_operator = "and";
	}

	this.conceptRoot = conceptRoot;
	this.concept = concept;
	this.concept_conceptTemplate = concept_conceptTemplate;
	this.applicability_conceptTemplate = applicability_conceptTemplate;
	this.requirement = requirement;

	this.concept_templateRules = new ArrayList<TemplateRule>();
	for (Object t : concept.getTemplateRules().getTemplateRulesOrTemplateRule())
	    this.concept_templateRules.add((TemplateRule) t);

	this.applicability_templateRules = new ArrayList<TemplateRule>();
	try {
	    for (Object t : conceptRoot.getApplicability().getTemplateRules().getTemplateRulesOrTemplateRule())
		this.applicability_templateRules.add((TemplateRule) t);
	} catch (Exception e) {
	    // just in case there aren't any
	}

	this.concept_attributeRules = concept_conceptTemplate.getRules().getAttributeRule();
	if (applicability_conceptTemplate != null && applicability_conceptTemplate.getRules() != null)
	    this.applicability_attributeRules = applicability_conceptTemplate.getRules().getAttributeRule();
	else
	    this.applicability_attributeRules = new ArrayList<AttributeRule>();
    }

    public ConceptRoot getConceptRoot() {
	return conceptRoot;
    }

    public Concept getConcept() {
	return concept;
    }

    public ConceptTemplate getConcept_conceptTemplate() {
	return concept_conceptTemplate;
    }

    public ConceptTemplate getApplicability_conceptTemplate() {
	return applicability_conceptTemplate;
    }

    public String getRequirement() {
	return requirement;
    }

    public List<TemplateRule> getApplicability_templateRules() {
	return applicability_templateRules;
    }

    public String getApplicability_operator() {
	return applicability_operator;
    }

    public String getConcept_operator() {
	return concept_operator;
    }

    public List<TemplateRule> getConcept_templateRules() {
	return concept_templateRules;
    }

    public List<AttributeRule> getApplicability_attributeRules() {
	return applicability_attributeRules;
    }

    public List<AttributeRule> getConcept_attributeRules() {
	return concept_attributeRules;
    }

}
