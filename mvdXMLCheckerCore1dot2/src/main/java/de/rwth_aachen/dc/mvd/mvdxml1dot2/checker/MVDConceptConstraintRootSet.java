package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import java.util.ArrayList;
import java.util.List;

import generated.buildingsmart_tech.mvd_xml_1dot2.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot2.TemplateRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.TemplateRules;


public class MVDConceptConstraintRootSet {


	private final List<MVDConceptConstraint> concept_constraints=new ArrayList<>();
	private List<AttributeRule> applicability_attributeRules;
	private final String applicableIfcElement;
	private List<TemplateRule> applicability_templateRules;
	private String applicability_operator;

	
	public MVDConceptConstraintRootSet(ConceptRoot conceptRoot, String applicableIfcElement) {
		super();
		this.applicableIfcElement = applicableIfcElement;
		
		this.applicability_templateRules = new ArrayList<TemplateRule>();
		try {
			if(conceptRoot.getApplicability()!=null && conceptRoot.getApplicability().getTemplateRules()!=null)  // JO 2022_02
			for (Object t : conceptRoot.getApplicability().getTemplateRules().getTemplateRulesOrTemplateRule())
				if (TemplateRules.class.isInstance(t)) {
					for (Object t2 : ((TemplateRules) t).getTemplateRulesOrTemplateRule())
						if (TemplateRules.class.isInstance(t2))
							this.applicability_templateRules.add((TemplateRule) t2);
				} else
					this.applicability_templateRules.add((TemplateRule) t);
		} catch (Exception e) {
			e.printStackTrace(); // There are no
			System.out.println("conceptRoot.getApplicability():" + conceptRoot.getApplicability());
			System.out.println("conceptRoot.getApplicability().getTemplateRules():"
					+ conceptRoot.getApplicability().getTemplateRules());
			// just in case there aren't any
		}
		
		try {
			if (conceptRoot.getApplicability().getTemplateRules() != null)
				this.applicability_operator = conceptRoot.getApplicability().getTemplateRules().getOperator();
			if (this.applicability_operator == null)
				this.applicability_operator = "and";
		} catch (Exception e) {
			this.applicability_operator = "and";
		}
	}

	public void add(MVDConceptConstraint mvdConceptConstraint) {
		concept_constraints.add(mvdConceptConstraint);
	}

	public void setapplicabilityTemplates(ConceptTemplate applicability_conceptTemplate) {
		if (applicability_conceptTemplate != null && applicability_conceptTemplate.getRules() != null)
			this.applicability_attributeRules = applicability_conceptTemplate.getRules().getAttributeRule();
		else
			this.applicability_attributeRules = new ArrayList<AttributeRule>();		
	}

	public String getApplicableIfcElement() {
		return applicableIfcElement;
	}

	public List<AttributeRule> getApplicability_attributeRules() {
		return applicability_attributeRules;
	}


	public List<MVDConceptConstraint> getConcept_constraints() {
		return concept_constraints;
	}

	public List<TemplateRule> getApplicability_templateRules() {
		return applicability_templateRules;
	}

	public String getApplicability_operator() {
		return applicability_operator;
	}


}
