package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import de.rwth_aachen.dc.mvd.MvdXMLVersionCheck;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.Concept;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptRoot;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot1.EntityRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.ModelView;
import generated.buildingsmart_tech.mvd_xml_1dot1.ModelView.ExchangeRequirements.ExchangeRequirement;
import generated.buildingsmart_tech.mvd_xml_1dot1.MvdXML;
import generated.buildingsmart_tech.mvd_xml_1dot1.Requirements.Requirement;
import nl.tue.ddss.mvdxml1dot1.mvdparser.MvdXMLException;

// Based on nl.tue.ddss.mvdparser.MvdXMLParser
// Rewritten by JO 2022
// JO 2022_02

public class MvdXMLValidationRules {
	private final String userId;
	private EventBusCommunication communication = EventBusCommunication.getInstance();

	private MvdXML mvdXML;
	//private List<ConceptTemplate> concept_templates = new ArrayList<ConceptTemplate>();
	private Map<String,ConceptTemplate> concept_templates = new HashMap<String,ConceptTemplate>();
	private boolean valid = true;

	public MvdXMLValidationRules(String userId, String filename) throws JAXBException {
		this.userId = userId;
		if (!MvdXMLVersionCheck.checkMvdXMLSchemaVersion(filename)) {
			// System.out.println("Not valid");
			this.valid = false;
			return;
		}
		// System.out.println("Valid mvdXML 1.1");
		try {
			JAXBContext mvdXMLSchema = JAXBContext.newInstance("generated.buildingsmart_tech.mvd_xml_1dot1");
			Unmarshaller unmarshaller = mvdXMLSchema.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new File(filename));

			JAXBElement<MvdXML> root = unmarshaller.unmarshal(streamSource, MvdXML.class);
			this.mvdXML = root.getValue();
			if (mvdXML.getTemplates() == null)
				return;
			List<ConceptTemplate> main_concept_templates = mvdXML.getTemplates().getConceptTemplate(); // can be plural

			for (ConceptTemplate t : main_concept_templates)
				addSubTemplates(t);
			//this.concept_templates.addAll(main_concept_templates);
			for(ConceptTemplate ct:main_concept_templates)
				this.concept_templates.put(ct.getUuid(), ct);
		} catch (Exception e) {
			communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(), e.getMessage()));
			this.valid = false;
			e.printStackTrace();
		}
		
	}

	private void addSubTemplates(ConceptTemplate concept_template) {
		if (concept_template.getSubTemplates() == null)
			return;
		for (ConceptTemplate t : concept_template.getSubTemplates().getConceptTemplate()) {
			this.concept_templates.put(t.getUuid(),t);
			addSubTemplates(t);
		}

	}

	private List<ConceptRoot> extractConceptRoots() {
		MvdXML.Views modelviews = this.mvdXML.getViews();
		List<ModelView> modelViews = modelviews.getModelView(); // can be plural: the singular name is from the mvdXML
																// definition
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

	//JO 2022_02
	public List<MVDConceptConstraintRootSet> getMVDConstraints() {
		List<MVDConceptConstraintRootSet> constraints = new ArrayList<MVDConceptConstraintRootSet>();

		for (ConceptRoot conceptRoot : extractConceptRoots()) {
			String applicableIfcElement=conceptRoot.getApplicableRootEntity();
			MVDConceptConstraintRootSet conceptSet =new MVDConceptConstraintRootSet(conceptRoot,applicableIfcElement);
			constraints.add(conceptSet);
			
			try {
				String applicability_templateRef = conceptRoot.getApplicability()
						.getTemplate().getRef();
				conceptSet.setapplicabilityTemplates(this.concept_templates.get(applicability_templateRef));
				
			} catch (Exception e) {
				// if not exists
			}
			
			List<Concept> concepts = conceptRoot.getConcepts().getConcept();
			for (Concept concept : concepts) {
				String concept_templateRef = concept.getTemplate().getRef();
				conceptSet.add(new MVDConceptConstraint(conceptRoot, concept, this.concept_templates.get(concept_templateRef)));
			
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


	public boolean isValid() {
		return valid;
	}

}
