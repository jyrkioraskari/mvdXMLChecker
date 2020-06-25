package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import de.rwth_aachen.dc.mvd.MvdXMLVersionCheck;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart_tech.mvd_xml_1dot2.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot2.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot2.EntityRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.ModelView;
import generated.buildingsmart_tech.mvd_xml_1dot2.ModelView.ExchangeRequirements.ExchangeRequirement;
import generated.buildingsmart_tech.mvd_xml_1dot2.MvdXML;
import generated.buildingsmart_tech.mvd_xml_1dot2.Requirements.Requirement;
import nl.tue.ddss.mvdxml1dot1.mvdparser.MvdXMLException;

// Based on nl.tue.ddss.mvdparser.MvdXMLParser

public class MvdXMLValidationRules {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

    private MvdXML mvdXML;
    private List<ConceptTemplate> concept_templates = new ArrayList<ConceptTemplate>();
    private boolean valid = true;

    public MvdXMLValidationRules(String filename) throws JAXBException {
	if (!MvdXMLVersionCheck.checkMvdXMLSchemaVersion(filename)) {
	    System.out.println("Not valid");
	    this.valid = false;
	    return;
	}
	System.out.println("Valid mvdXML 1.2");
	try {
	    JAXBContext mvdXMLSchema = JAXBContext.newInstance("generated.buildingsmart_tech.mvd_xml_2dot1");
	    Unmarshaller unmarshaller = mvdXMLSchema.createUnmarshaller();
	    StreamSource streamSource = new StreamSource(new File(filename));

	    JAXBElement<MvdXML> root = unmarshaller.unmarshal(streamSource, MvdXML.class);
	    this.mvdXML = root.getValue();
	    if (mvdXML.getTemplates() == null)
		return;
	    List<ConceptTemplate> main_concept_templates = mvdXML.getTemplates().getConceptTemplate(); // can be plural

	    for (ConceptTemplate t : main_concept_templates)
		addSubTemplates(t);
	    this.concept_templates.addAll(main_concept_templates);
	} catch (Exception e) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(), e.getMessage()));
	    this.valid = false;
	    e.printStackTrace();
	}
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
	List<ModelView> modelViews = modelviews.getModelView(); // can be plural: the singular name is from the mvdXML definition
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

    public List<MVDConceptConstraint> getMVDConstraints() {
	List<MVDConceptConstraint> conceptTrees = new ArrayList<MVDConceptConstraint>();

	for (ConceptRoot conceptRoot : extractConceptRoots()) {
	    ConceptTemplate applicability_conceptTemplate = null;
	    try {
		String applicability_templateRef = applicability_templateRef = conceptRoot.getApplicability().getTemplate().getRef();
		for (ConceptTemplate conceptTemplate : concept_templates) {
		    if (conceptTemplate.getUuid().equals(applicability_templateRef)) {
			applicability_conceptTemplate = conceptTemplate;
		    }
		}
	    } catch (Exception e) {
		// if not exists
	    }
	    List<Concept> concepts = conceptRoot.getConcepts().getConcept();
	    for (Concept concept : concepts) {
		String concept_templateRef = concept.getTemplate().getRef();
		for (ConceptTemplate concept_conceptTemplate : concept_templates) {
		    if (concept_conceptTemplate.getUuid().equals(concept_templateRef)) {
			conceptTrees.add(new MVDConceptConstraint(conceptRoot, concept, concept_conceptTemplate, applicability_conceptTemplate));
		    }
		}
	    }
	}
	return conceptTrees;
    }

    public List<MVDConceptConstraint> getALLMVDConstraints() throws MvdXMLException {
	List<ModelView> modelViews = getModelViews();
	List<MVDConceptConstraint> constraints = new ArrayList<MVDConceptConstraint>();
	for (ModelView modelView : modelViews) {
	    List<ExchangeRequirement> exchangeRequirements = modelView.getExchangeRequirements().getExchangeRequirement();
	    for (ExchangeRequirement er : exchangeRequirements) {
		List<MVDConceptConstraint> mcs = buildExchangeRequirementConceptConstraints(modelView, er);
		for (MVDConceptConstraint mc : mcs) {
		    constraints.add(mc);
		}
	    }
	}
	return constraints;
    }

    public List<AttributeRule.Constraints.Constraint> getConstraints(AttributeRule attributeRule) {
	List<AttributeRule.Constraints.Constraint> constraints = attributeRule.getConstraints().getConstraint();
	return constraints;
    }

    public List<EntityRule.Constraints.Constraint> getConstraints(EntityRule entityRule) {
	List<EntityRule.Constraints.Constraint> constraints = entityRule.getConstraints().getConstraint();
	return constraints;
    }

    private List<MVDConceptConstraint> buildExchangeRequirementConceptConstraints(ModelView modelView, ExchangeRequirement modelView_er) throws MvdXMLException {
	List<MVDConceptConstraint> constraints = new ArrayList<MVDConceptConstraint>();
	// NOTE: modelView.getRoots().getConceptRoot() give list of
	// ModelView.Roots.ConceptRoot (Roots is gingular)
	// This is a curiosity because of the XML definition (
	List<ConceptRoot> conceptRoots = modelView.getRoots().getConceptRoot();
	for (ConceptRoot root : conceptRoots) {
	    List<Concept> concepts = root.getConcepts().getConcept();
	    for (Concept concept : concepts) {
		List<Requirement> requirements = concept.getRequirements().getRequirement();
		for (Requirement requirement : requirements) {
		    if (requirement.getExchangeRequirement().equals(modelView_er.getUuid())) {
			communication.post(new CheckerNotificationEvent("Concept requirement " + concept.getUuid() + " is used since it refers to " + modelView_er.getUuid() + " exchangeRequirement in mvdXML"));
			constraints.add(new MVDConceptConstraint(root, concept, getTemplate(concept), getTemplate(root) ,requirement.getRequirement()));
		    }
		}
	    }
	}
	return constraints;
    }

    private ConceptTemplate getTemplate(Concept concept) {
	ConceptTemplate ct = null;
	for (ConceptTemplate conceptTemplate : concept_templates) {
	    if (conceptTemplate.getUuid().equals(concept.getTemplate())) {
		communication.post(new CheckerNotificationEvent("Concept template " + conceptTemplate.getUuid() + " was found for " + concept.getUuid()));
		ct = conceptTemplate;
	    }
	}
	return ct;
    }

    private ConceptTemplate getTemplate(ConceptRoot concept_root) {
	try {
	    ConceptTemplate ct = null;
	    for (ConceptTemplate conceptTemplate : concept_templates) {
		if (conceptTemplate.getUuid().equals(concept_root.getApplicability().getTemplate())) {
		    communication.post(new CheckerNotificationEvent("Applicability concept template " + conceptTemplate.getUuid() + " was found for " + concept_root.getUuid()));
		    ct = conceptTemplate;
		}
	    }
	    return ct;
	} catch (Exception e) {
	    return null;
	}
    }

    public boolean isValid() {
	return valid;
    }

}
