package nl.tue.ddss.mvdparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.buildingsmart_tech.mvdxml.mvdxml1_1.*;
import org.buildingsmart_tech.mvdxml.mvdxml1_1.Requirements.Requirement;

public class MvdXMLParser {

	private MvdXML mvdXML;
	private List<ConceptTemplate> templates;

	public MvdXML getMvdXML() {
		return mvdXML;

	}

	public MvdXMLParser(String fileName) throws JAXBException {
		JAXBContext mvdXMLSchema = JAXBContext
				.newInstance("org.buildingsmart_tech.mvdxml.mvdxml1_1");
		Unmarshaller unmarshaller = mvdXMLSchema.createUnmarshaller();
		StreamSource streamSource = new StreamSource(new File(fileName));
		
		JAXBElement<MvdXML> root = unmarshaller.unmarshal(streamSource,
				MvdXML.class);
		this.mvdXML = root.getValue();
		if(mvdXML.getTemplates()==null)
		    return;  // To avoid null pointer exception when an unknown XML schema is used
		this.templates=mvdXML.getTemplates().getConceptTemplate();
	}

	// Generate ConceptRoot list.
	public List<ConceptRoot> extractConceptRoots() throws JAXBException {
		MvdXML.Views views = getMvdXML().getViews();
		List<ModelView> modelViews = views.getModelView();
		List<ModelView.Roots> rootsCollection = new ArrayList<ModelView.Roots>();

		for (ModelView modelView : modelViews) {
			ModelView.Roots roots = modelView.getRoots();
			rootsCollection.add(roots);
		}

		List<ConceptRoot> conceptRoots = new ArrayList<ConceptRoot>();
		for (ModelView.Roots roots : rootsCollection) {
			conceptRoots.addAll(roots.getConceptRoot());
		}
		return conceptRoots;
	}
	
	public List<ModelView> getModelViews(){
		return mvdXML.getViews().getModelView();
	}
	
	public List<ConceptTemplate> getAllTemplates() throws JAXBException {
		List<ConceptTemplate> templates=getTemplates();
		List<ConceptTemplate> subTemplates=new ArrayList<ConceptTemplate>();
		for(ConceptTemplate template:templates){
			getTemplates(template,subTemplates);
		}
		templates.addAll(subTemplates);
		return templates;
	}
	
	private List<ConceptTemplate> getTemplates(ConceptTemplate template,List<ConceptTemplate> templates){
	    if (template.getSubTemplates()!=null){
	    	templates.addAll(template.getSubTemplates().getConceptTemplate());
	    	for(ConceptTemplate ct:template.getSubTemplates().getConceptTemplate()){
	    		getTemplates(ct,templates);
	    	}
	    }
		return templates;		
	}
			

	public List<ConceptTemplate> getTemplates() throws JAXBException {
		List<ConceptTemplate> conceptTemplates = getMvdXML().getTemplates()
				.getConceptTemplate();
		return conceptTemplates;
	}

	public List<MVDConstraint> getMVDConstraints() throws JAXBException {
		List<MVDConstraint> conceptTrees = new ArrayList<MVDConstraint>();
		for (ConceptRoot conceptRoot : extractConceptRoots()) {
			List<Concept> concepts = conceptRoot.getConcepts().getConcept();
			for (Concept concept : concepts) {
				String templateRef = concept.getTemplate().getRef();
				for (ConceptTemplate conceptTemplate : templates) {
					if (conceptTemplate.getUuid().equals(templateRef)) {
						conceptTrees.add(new MVDConstraint(conceptRoot,
								concept, conceptTemplate));
					}
				}
			}
		}
		return conceptTrees;
	}
	
	public List<MVDConstraint> getALLMVDConstraints() throws MvdXMLException{
		List<ModelView> modelViews=getModelViews();
		List<MVDConstraint> constraints=new ArrayList<MVDConstraint>();
		for (ModelView modelView:modelViews){
			List<ExchangeRequirement> exchangeRequirements=modelView.getExchangeRequirements().getExchangeRequirement();
			for (ExchangeRequirement er:exchangeRequirements){
				List<MVDConstraint> mcs=buildECMap(modelView,er);
				for(MVDConstraint mc:mcs){
					constraints.add(mc);
				}
			}
		}
		return constraints;
	} 
	
	public ConceptTemplate getTemplate(Concept concept){
		ConceptTemplate ct=null;
		for (ConceptTemplate conceptTemplate : templates) {
			if (conceptTemplate.getUuid().equals(concept.getTemplate())) {
				ct=conceptTemplate;
			}
		}
		return ct;
	}

	public List<TemplateRule> parseConcept(Concept concept) {
		List<TemplateRule> templateRules = new ArrayList<TemplateRule>();
		Rules rules = concept.getRules();
		List<JAXBElement<? extends AbstractRule>> abstractRules = rules
				.getAbstractRule();
		for (JAXBElement<? extends AbstractRule> jAXBElementRule : abstractRules) {
			TemplateRule templateRule = (TemplateRule) jAXBElementRule
					.getValue();
			templateRules.add(templateRule);
		}
		if (concept.getSubConcepts() != null) {
			List<Concept> subconcepts = concept.getSubConcepts().getConcept();
			for (Concept subconcept : subconcepts) {
				parseConcept(subconcept);
			}
		}
		return templateRules;
	}

	public List<AttributeRule.Constraints.Constraint> getConstraints(
			AttributeRule attributeRule) {
		List<AttributeRule.Constraints.Constraint> constraints = attributeRule
				.getConstraints().getConstraint();
		return constraints;
	}

	public List<EntityRule.Constraints.Constraint> getConstraints(
			EntityRule entityRule) {
		List<EntityRule.Constraints.Constraint> constraints = entityRule
				.getConstraints().getConstraint();
		return constraints;
	}

	public List<MVDConstraint> buildECMap(
			ModelView modelView, ExchangeRequirement er) throws MvdXMLException {
		List<MVDConstraint> constraints = new ArrayList<MVDConstraint>();
		List<ExchangeRequirement> exchangeRequirements = modelView
				.getExchangeRequirements().getExchangeRequirement();
		for (int i = 0; i < exchangeRequirements.size(); i++) {
			if (er.equals(exchangeRequirements.get(i))) {
				break;
			} else if (i == exchangeRequirements.size() - 1) {
				throw new MvdXMLException(
						"This model view does not have this exchange requirement");
			}
		}
		List<ConceptRoot> conceptRoots = modelView.getRoots().getConceptRoot();
		for (ConceptRoot root : conceptRoots) {
			List<Concept> concepts = root.getConcepts().getConcept();
			for (Concept concept : concepts) {
				List<Requirement> requirements = concept.getRequirements()
						.getRequirement();
				for (Requirement requirement : requirements) {
					if (requirement.getExchangeRequirement().equals(
							er.getUuid())) {
						constraints.add(new MVDConstraint(root,concept,getTemplate(concept),requirement.getRequirement()));
						}
					}
				}
			}
		return constraints;
	}

	public class TemplateParameter {
		private String parameter;
		private String value;

		public String getParameter() {
			return parameter;
		}

		public void setParameter(String parameter) {
			this.parameter = parameter;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public TemplateParameter(String parameter, String value) {
			this.parameter = parameter;
			this.value = value;
		}
	}

}
