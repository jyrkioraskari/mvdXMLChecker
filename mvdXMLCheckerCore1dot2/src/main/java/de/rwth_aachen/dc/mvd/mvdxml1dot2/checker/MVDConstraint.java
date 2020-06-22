package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import java.util.ArrayList;
import java.util.List;

import generated.buildingsmart_tech.mvd_xml_1dot2.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot2.TemplateRule;

public class MVDConstraint {

    private final ConceptRoot conceptRoot;
    private final Concept concept;
    private final List<TemplateRule> templateRules;
    private final ConceptTemplate conceptTemplate;
    private final List<AttributeRule> attributeRules;
    @SuppressWarnings("unused")
    private final String requirement;
    private String operator;

    public MVDConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate conceptTemplate) {
	this(conceptRoot, concept, conceptTemplate, null);

    }

    public MVDConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate conceptTemplate, String requirement) {
	if (concept.getTemplateRules() != null)
	    this.operator = concept.getTemplateRules().getOperator();
	if (operator == null)
	    this.operator = "and";
	this.conceptRoot = conceptRoot;
	this.concept = concept;
	this.conceptTemplate = conceptTemplate;
	this.requirement = requirement;

	this.templateRules = new ArrayList<TemplateRule>();
	for (Object t : concept.getTemplateRules().getTemplateRulesOrTemplateRule())
	    this.templateRules.add((TemplateRule) t);
	this.attributeRules = conceptTemplate.getRules().getAttributeRule();
    }

    public ConceptRoot getConceptRoot() {
	return conceptRoot;
    }

    public Concept getConcept() {
	return concept;
    }

    public List<TemplateRule> getTemplateRules() {
	return templateRules;
    }

    public ConceptTemplate getConceptTemplate() {
	return conceptTemplate;
    }

    public List<AttributeRule> getAttributeRules() {
	return attributeRules;
    }

    public String getRequirement() {
	return requirement;
    }

    public String getOperator() {
	return operator;
    }

}
