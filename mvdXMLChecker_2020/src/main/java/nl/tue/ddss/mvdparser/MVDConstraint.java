package nl.tue.ddss.mvdparser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import de.rwth_aachen.dc.mvdxml.xsd1_1.AbstractRule;
import de.rwth_aachen.dc.mvdxml.xsd1_1.AttributeRule;
import de.rwth_aachen.dc.mvdxml.xsd1_1.Concept;
import de.rwth_aachen.dc.mvdxml.xsd1_1.ConceptRoot;
import de.rwth_aachen.dc.mvdxml.xsd1_1.ConceptTemplate;
import de.rwth_aachen.dc.mvdxml.xsd1_1.ConceptTemplate.Rules;
import de.rwth_aachen.dc.mvdxml.xsd1_1.TemplateRules.TemplateRule;


public class MVDConstraint{
	
	private ConceptRoot conceptRoot;
	private Concept concept;
	private List<TemplateRule> templateRules;
	private ConceptTemplate conceptTemplate;
	private List<AttributeRule> attributeRules;
	@SuppressWarnings("unused")
	private String requirement;


	
	public List<AttributeRule> getAttributeRules() {
		return attributeRules;
	}

    

	public List<TemplateRule> getTemplateRules() {
		this.templateRules=new ArrayList<TemplateRule>();
		
		
		/*Rules rules = concept.getRules();
		List<JAXBElement<? extends AbstractRule>> abstractRules = rules
				.getAbstractRule();
		for (JAXBElement<? extends AbstractRule> jAXBElementRule : abstractRules) {
			TemplateRule templateRule = (TemplateRule) jAXBElementRule
					.getValue();
			templateRules.add(templateRule);
		}*/
		
		for(Object t:concept.getTemplateRules().getTemplateRulesOrTemplateRule())
		    this.templateRules.add((TemplateRule) t);
		return this.templateRules;
	}
	
	public  MVDConstraint(ConceptRoot conceptRoot,Concept concept,ConceptTemplate conceptTemplate){
		this(conceptRoot,concept,conceptTemplate,null);
	}
	
	public MVDConstraint(ConceptRoot conceptRoot,Concept concept,ConceptTemplate conceptTemplate,String requirement){
		this.conceptRoot=conceptRoot;
		this.concept=concept;
		this.conceptTemplate=conceptTemplate;
		this.requirement=requirement;
		List<AttributeRule> attributeRuleList=new ArrayList<AttributeRule>();
		Rules rules = conceptTemplate.getRules();
		List<AttributeRule> attrRules = rules.getAttributeRule();
		for (AttributeRule attributeRule : attrRules)
			attributeRuleList.add(attributeRule);
		this.attributeRules=attributeRuleList;
	}

	
	public ConceptRoot getConceptRoot() {
		return conceptRoot;
	}
	public void setConceptRoot(ConceptRoot conceptRoot) {
		this.conceptRoot = conceptRoot;
	}
	public Concept getConcept() {
		return concept;
	}
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	public ConceptTemplate getConceptTemplate() {
		return conceptTemplate;
	}
	public void setConceptTemplate(ConceptTemplate conceptTemplate) {
		this.conceptTemplate = conceptTemplate;
	}
	
	
	}
