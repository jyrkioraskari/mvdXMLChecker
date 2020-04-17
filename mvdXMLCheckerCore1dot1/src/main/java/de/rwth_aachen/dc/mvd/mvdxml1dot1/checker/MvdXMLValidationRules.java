package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot1.EntityRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.ModelView;
import generated.buildingsmart_tech.mvd_xml_1dot1.ModelView.ExchangeRequirements.ExchangeRequirement;
import generated.buildingsmart_tech.mvd_xml_1dot1.MvdXML;
import generated.buildingsmart_tech.mvd_xml_1dot1.Requirements.Requirement;
import generated.buildingsmart_tech.mvd_xml_1dot1.TemplateRules.TemplateRule;
import nl.tue.ddss.mvdxml1dot1.mvdparser.MvdXMLException;

// Based on nl.tue.ddss.mvdparser.MvdXMLParser

public class MvdXMLValidationRules {

    private MvdXML mvdXML;
    private List<ConceptTemplate> concept_templates = new ArrayList<ConceptTemplate>();
    private boolean valid = true;

    public MvdXMLValidationRules(String filename) throws JAXBException {
	if(!checkMvdXMLSchemaVersion(filename))
	{
	    System.out.println("Not valid");
	    this.valid=false;
	    return;
	}
	System.out.println("Valid mvdXML 1.1");
	try {
	    JAXBContext mvdXMLSchema = JAXBContext.newInstance("generated.buildingsmart_tech.mvd_xml_1dot1");
	    Unmarshaller unmarshaller = mvdXMLSchema.createUnmarshaller();
	    StreamSource streamSource = new StreamSource(new File(filename));

	    JAXBElement<MvdXML> root = unmarshaller.unmarshal(streamSource, MvdXML.class);
	    this.mvdXML = root.getValue();
	    System.out.println("XML Root Templates: " + mvdXML.getTemplates().getConceptTemplate().size());
	    if (mvdXML.getTemplates() == null)
		return;
	    List<ConceptTemplate> main_concept_templates = mvdXML.getTemplates().getConceptTemplate(); // can be plural

	    for (ConceptTemplate t : main_concept_templates)
		addSubTemplates(t);
	    this.concept_templates.addAll(main_concept_templates);
	} catch (Exception e) {
	    this.valid = false;
	    e.printStackTrace();
	}
    }

    private boolean checkMvdXMLSchemaVersion(String filename) {
	try {
	    File myObj = new File(filename);
	    Scanner myReader = new Scanner(myObj);
	    for(int i=0;i<5;i++)
	    if(myReader.hasNextLine()) 
		if(checSchemaLine(myReader.nextLine()))
			return true;
	    
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	return false;
    }
    
    private boolean checSchemaLine(String line)
    {
	String[] tokens=line.split("[ =>]");
	for(String t:tokens)
	{
	    if(t.equals("\"http://buildingsmart-tech.org/mvd/XML/1.1\""))		
		return true;
	}
	return false;
    }

    private void addSubTemplates(ConceptTemplate concept_template) {
	if (concept_template.getSubTemplates() == null)
	    return;
	for (ConceptTemplate t : concept_template.getSubTemplates().getConceptTemplate()) {
	    this.concept_templates.add(t);
	    addSubTemplates(t);
	}

    }

    private List<ConceptRoot> extractConceptRoots() {
	MvdXML.Views modelviews = this.mvdXML.getViews();
	System.out.println("views: " + modelviews.getModelView().size());
	List<ModelView> modelViews = modelviews.getModelView(); // can be plural: the singular name is from the mvdXML definition
	List<ModelView.Roots> rootsCollection = new ArrayList<ModelView.Roots>();

	for (ModelView modelView : modelViews) {
	    ModelView.Roots roots = modelView.getRoots();
	    rootsCollection.add(roots);
	}

	List<ConceptRoot> conceptRoots = new ArrayList<ConceptRoot>();
	for (ModelView.Roots roots : rootsCollection) {
	    System.out.println("Add concept root");
	    conceptRoots.addAll(roots.getConceptRoot());
	}
	System.out.println("returned concept roots " + conceptRoots.size());
	return conceptRoots;
    }

    public List<ModelView> getModelViews() {
	return this.mvdXML.getViews().getModelView();
    }

    public List<ConceptTemplate> getAllTemplates() throws JAXBException {
	List<ConceptTemplate> templates = getTemplates();
	List<ConceptTemplate> subTemplates = new ArrayList<ConceptTemplate>();
	for (ConceptTemplate template : templates) {
	    getTemplates(template, subTemplates);
	}
	templates.addAll(subTemplates);
	return templates;
    }

    private List<ConceptTemplate> getTemplates(ConceptTemplate template, List<ConceptTemplate> templates) {
	if (template.getSubTemplates() != null) {
	    templates.addAll(template.getSubTemplates().getConceptTemplate());
	    for (ConceptTemplate ct : template.getSubTemplates().getConceptTemplate()) {
		getTemplates(ct, templates);
	    }
	}
	return templates;
    }

    public List<ConceptTemplate> getTemplates() throws JAXBException {
	List<ConceptTemplate> conceptTemplates = this.mvdXML.getTemplates().getConceptTemplate();
	return conceptTemplates;
    }

    public List<MVDConstraint> getMVDConstraints() {
	List<MVDConstraint> conceptTrees = new ArrayList<MVDConstraint>();

	for (ConceptRoot conceptRoot : extractConceptRoots()) {
	    List<Concept> concepts = conceptRoot.getConcepts().getConcept();
	    System.out.println("concepts: " + concepts.size());
	    for (Concept concept : concepts) {
		System.out.println("concept: " + concept.getUuid());
		String templateRef = concept.getTemplate().getRef();
		System.out.println("template ref was: " + templateRef);
		for (ConceptTemplate conceptTemplate : concept_templates) {
		    System.out.println("template id was: " + conceptTemplate.getUuid());
		    if (conceptTemplate.getUuid().equals(templateRef)) {
			conceptTrees.add(new MVDConstraint(conceptRoot, concept, conceptTemplate));
		    }
		}
	    }
	}
	return conceptTrees;
    }

    public List<MVDConstraint> getALLMVDConstraints() throws MvdXMLException {
	List<ModelView> modelViews = getModelViews();
	List<MVDConstraint> constraints = new ArrayList<MVDConstraint>();
	for (ModelView modelView : modelViews) {
	    List<ExchangeRequirement> exchangeRequirements = modelView.getExchangeRequirements().getExchangeRequirement();
	    for (ExchangeRequirement er : exchangeRequirements) {
		List<MVDConstraint> mcs = buildECMap(modelView, er);
		for (MVDConstraint mc : mcs) {
		    constraints.add(mc);
		}
	    }
	}
	return constraints;
    }

    public ConceptTemplate getTemplate(Concept concept) {
	ConceptTemplate ct = null;
	for (ConceptTemplate conceptTemplate : concept_templates) {
	    if (conceptTemplate.getUuid().equals(concept.getTemplate())) {
		ct = conceptTemplate;
	    }
	}
	return ct;
    }

    public List<TemplateRule> parseConcept(Concept concept) {
	List<TemplateRule> templateRules = new ArrayList<TemplateRule>();
	/*
	 * Rules rules = concept.getRules(); List<JAXBElement<? extends AbstractRule>>
	 * abstractRules = rules .getAbstractRule(); for (JAXBElement<? extends
	 * AbstractRule> jAXBElementRule : abstractRules) { TemplateRule templateRule =
	 * (TemplateRule) jAXBElementRule .getValue(); templateRules.add(templateRule);
	 * } if (concept.getSubConcepts() != null) { List<Concept> subconcepts =
	 * concept.getSubConcepts().getConcept(); for (Concept subconcept : subconcepts)
	 * { parseConcept(subconcept); } }
	 */

	for (Object t : concept.getTemplateRules().getTemplateRulesOrTemplateRule())
	    templateRules.add((TemplateRule) t);
	return templateRules;
    }

    public List<AttributeRule.Constraints.Constraint> getConstraints(AttributeRule attributeRule) {
	List<AttributeRule.Constraints.Constraint> constraints = attributeRule.getConstraints().getConstraint();
	return constraints;
    }

    public List<EntityRule.Constraints.Constraint> getConstraints(EntityRule entityRule) {
	List<EntityRule.Constraints.Constraint> constraints = entityRule.getConstraints().getConstraint();
	return constraints;
    }

    public List<MVDConstraint> buildECMap(ModelView modelView, ExchangeRequirement er) throws MvdXMLException {
	List<MVDConstraint> constraints = new ArrayList<MVDConstraint>();
	List<ExchangeRequirement> exchangeRequirements = modelView.getExchangeRequirements().getExchangeRequirement();
	for (int i = 0; i < exchangeRequirements.size(); i++) {
	    if (er.equals(exchangeRequirements.get(i))) {
		break;
	    } else if (i == exchangeRequirements.size() - 1) {
		throw new MvdXMLException("This model view does not have this exchange requirement");
	    }
	}
	List<ConceptRoot> conceptRoots = modelView.getRoots().getConceptRoot();
	for (ConceptRoot root : conceptRoots) {
	    List<Concept> concepts = root.getConcepts().getConcept();
	    for (Concept concept : concepts) {
		List<Requirement> requirements = concept.getRequirements().getRequirement();
		for (Requirement requirement : requirements) {
		    if (requirement.getExchangeRequirement().equals(er.getUuid())) {
			constraints.add(new MVDConstraint(root, concept, getTemplate(concept), requirement.getRequirement()));
		    }
		}
	    }
	}
	return constraints;
    }

    
    public boolean isValid() {
        return valid;
    }

}
