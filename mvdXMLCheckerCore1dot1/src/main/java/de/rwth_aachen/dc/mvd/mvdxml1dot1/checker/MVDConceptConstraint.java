package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import java.util.ArrayList;
import java.util.List;

import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot1.TemplateRules;
import generated.buildingsmart_tech.mvd_xml_1dot1.TemplateRules.TemplateRule;

public class MVDConceptConstraint {

	private final ConceptRoot conceptRoot;
	private final Concept concept;
	private final ConceptTemplate concept_conceptTemplate;

	private final List<AttributeRule> concept_attributeRules;
	@SuppressWarnings("unused")
	private final String requirement;
	
	private final List<TemplateRule> concept_templateRules;
	private String concept_operator;

	public MVDConceptConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate concept_conceptTemplate) {
		this(conceptRoot, concept, concept_conceptTemplate, null);

	}

	public MVDConceptConstraint(ConceptRoot conceptRoot, Concept concept, ConceptTemplate concept_conceptTemplate,
			String requirement) {
		if (concept.getTemplateRules() != null)
			this.concept_operator = concept.getTemplateRules().getOperator();
		if (this.concept_operator == null)
			this.concept_operator = "and";

		

		this.conceptRoot = conceptRoot;
		this.concept = concept;
		this.concept_conceptTemplate = concept_conceptTemplate;
		this.requirement = requirement;

		this.concept_templateRules = new ArrayList<TemplateRule>();
		try {
			if(concept.getTemplateRules()!=null && concept.getTemplateRules().getTemplateRulesOrTemplateRule()!=null) // TODO sub templates
			for (Object t : concept.getTemplateRules().getTemplateRulesOrTemplateRule()) {
				if (TemplateRules.class.isInstance(t)) {
					for (Object t2 : ((TemplateRules) t).getTemplateRulesOrTemplateRule())
						if (TemplateRules.class.isInstance(t2))
							this.concept_templateRules.add((TemplateRule) t2);
				} else
					this.concept_templateRules.add((TemplateRule) t);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
        if(concept_conceptTemplate.getRules()==null || concept_conceptTemplate.getRules().getAttributeRule()==null ) //TODO sub templates
        
        	this.concept_attributeRules = new ArrayList<AttributeRule>();
        else
 		this.concept_attributeRules = concept_conceptTemplate.getRules().getAttributeRule();
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

	public String getRequirement() {
		return requirement;
	}


	public String getConcept_operator() {
		return concept_operator;
	}

	public List<TemplateRule> getConcept_templateRules() {
		return concept_templateRules;
	}


	public List<AttributeRule> getConcept_attributeRules() {
		return concept_attributeRules;
	}

}
