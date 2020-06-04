package nl.tue.ddss.mvdxml1dot1.ifc_check;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;

import de.rwth_aachen.dc.ifc.IfcModelInstance.IfcVersion;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.AbstractRule;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MVDConstraint;
import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.Definitions;
import generated.buildingsmart_tech.mvd_xml_1dot1.Definitions.Definition;
import generated.buildingsmart_tech.mvd_xml_1dot1.EntityRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.TemplateRules.TemplateRule;
import generated.mvdxml1dot1.rule_operators.MvdXMLv1_1Lexer;
import generated.mvdxml1dot1.rule_operators.MvdXMLv1_1Parser;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcHashMapBuilder.ObjectToValue;


/*
 * Modified by J0 2020
 */

public class IfcMVDConstraintChecker {
    private List<MVDConstraint> constraints;

    private IfcVersion ifcversion;

    public IfcMVDConstraintChecker(List<MVDConstraint> constraints, IfcVersion ifcversion) throws DeserializeException, IOException, URISyntaxException {
	this.constraints = constraints;
	this.ifcversion = ifcversion;
    }

    public IssueReport checkModel(IfcModelInterface ifcModel, File ifcfile) throws RenderEngineException, DeserializeException, IOException {
	IssueReport issuereport = new IssueReport(ifcModel,ifcfile);
	for (MVDConstraint constraint : constraints) {
	    List<AttributeRule> attributeRules = constraint.getAttributeRules();
	    List<TemplateRule> templateRules = constraint.getTemplateRules();
	    try {
		Class cls = null;
		switch (this.ifcversion) {
		case IFC2x3:
		    cls = Class.forName("org.bimserver.models.ifc2x3tc1." + constraint.getConceptRoot().getApplicableRootEntity());
		    break;
		case IFC4:
		    cls = Class.forName("org.bimserver.models.ifc4." + constraint.getConceptRoot().getApplicableRootEntity());
		    break;
		default:
		    throw new RuntimeException("Unsupported IFC type");
		}

		List<Object> allRoots = ifcModel.getAllWithSubTypes(cls);

		if (allRoots.size() == 0)
		    issuereport.addIssue(cls.getCanonicalName(), "No " + cls.getCanonicalName() + " element in the model");

		for (Object ifcObject : allRoots) {
		    IfcHashMapBuilder ifcHashMapBuilder = new IfcHashMapBuilder(ifcObject, attributeRules, this.ifcversion);
		    List<HashMap<AbstractRule, ObjectToValue>> hashMaps = ifcHashMapBuilder.getHashMaps();

		    String comment = new String();
		    for (HashMap<AbstractRule, ObjectToValue> hashMap : hashMaps)
			comment = templateLevelRuleCheck(hashMap);

		    for (TemplateRule templateRule : templateRules) {
			boolean valid=false;
			for (int i = 0; i < hashMaps.size(); i++) {
			    Boolean result = conceptLevelRuleCheck(templateRule.getParameters(), hashMaps.get(i));
			    if(result == null)
				continue;
			    if (result == true)
			    {
				valid=true;
				break;
			    }
			}
			if (!valid)
				comment = comment + "\n This Object has to fulfil the requirements of " + templateRule.getParameters();
		    }
		    if (comment.length() > 0) {
			Definitions definitions = constraint.getConcept().getDefinitions();
			if (definitions != null) {
			    List<Definition> definitionList = definitions.getDefinition();
			    for (Definition definition : definitionList)
				comment = comment + "\n" + definition.getBody().getValue();
			}
			String type = ifcObject.getClass().getSimpleName();
			type = type.substring(0, type.length() - 4);
			
			
			switch (this.ifcversion) {
			case IFC2x3:
				if (ifcObject instanceof  org.bimserver.models.ifc2x3tc1.IfcProduct) {
				    String spatialStructureElement = new String();
				    if (ifcObject instanceof  org.bimserver.models.ifc2x3tc1.IfcElement)
					spatialStructureElement = getIfcSpatialStructure(( org.bimserver.models.ifc2x3tc1.IfcElement) ifcObject);
				    List<String> componantGuids = new LinkedList<String>();
				    componantGuids = getComponantGuids(componantGuids, ( org.bimserver.models.ifc2x3tc1.IfcProduct) ifcObject);
				    issuereport.addIssue(spatialStructureElement, (( org.bimserver.models.ifc2x3tc1.IfcProduct) ifcObject), (( org.bimserver.models.ifc2x3tc1.IfcProduct) ifcObject).getGlobalId() + "\n" + comment);
				} else {
				    issuereport.addIssue(null, (org.bimserver.models.ifc2x3tc1.IfcRoot) ifcObject, (( org.bimserver.models.ifc2x3tc1.IfcRoot) ifcObject).getGlobalId() + "\n" + comment);
				}
			    break;
			case IFC4:
				if (ifcObject instanceof  org.bimserver.models.ifc4.IfcProduct) {
				    String spatialStructureElement = new String();
				    if (ifcObject instanceof  org.bimserver.models.ifc4.IfcElement)
					spatialStructureElement = getIfcSpatialStructure(( org.bimserver.models.ifc4.IfcElement) ifcObject);
				    List<String> componantGuids = new LinkedList<String>();
				    componantGuids = getComponantGuids(componantGuids, ( org.bimserver.models.ifc4.IfcProduct) ifcObject);
				    issuereport.addIssue(spatialStructureElement, (( org.bimserver.models.ifc4.IfcProduct) ifcObject), (( org.bimserver.models.ifc4.IfcProduct) ifcObject).getGlobalId() + "\n" + comment);
				} else {
				    issuereport.addIssue(null, (org.bimserver.models.ifc4.IfcRoot) ifcObject, (( org.bimserver.models.ifc4.IfcRoot) ifcObject).getGlobalId() + "\n" + comment);
				}
			    break;
			default:
			    throw new RuntimeException("Unsupported IFC type");
			}
			
			
			
			
		    }
		}
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }
	}
	return issuereport;
    }

    private String getIfcSpatialStructure(org.bimserver.models.ifc2x3tc1.IfcElement ifcObject) {
	String guid = new String();
	List<org.bimserver.models.ifc2x3tc1.IfcRelContainedInSpatialStructure> ircsisss = ifcObject.getContainedInStructure();
	if (ircsisss != null && ircsisss.size() == 1) {
	    org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement isse = ircsisss.get(0).getRelatingStructure();
	    guid = isse.getGlobalId();
	}
	return guid;
    }

    private String getIfcSpatialStructure(org.bimserver.models.ifc4.IfcElement ifcObject) {
  	String guid = new String();
  	List<org.bimserver.models.ifc4.IfcRelContainedInSpatialStructure> ircsisss = ifcObject.getContainedInStructure();
  	if (ircsisss != null && ircsisss.size() == 1) {
  	  org.bimserver.models.ifc4.IfcSpatialStructureElement isse = (org.bimserver.models.ifc4.IfcSpatialStructureElement) ircsisss.get(0).getRelatingStructure();
  	    guid = isse.getGlobalId();
  	}
  	return guid;
      }

    
    private List<String> getComponantGuids(List<String> guids, org.bimserver.models.ifc2x3tc1.IfcObjectDefinition ifcObject) {
	if (ifcObject.getIsDecomposedBy().size() >= 1) {
	    List<org.bimserver.models.ifc2x3tc1.IfcRelDecomposes> irds = ifcObject.getIsDecomposedBy();
	    for (org.bimserver.models.ifc2x3tc1.IfcRelDecomposes ird : irds) {
		List<org.bimserver.models.ifc2x3tc1.IfcObjectDefinition> ifcObjects = ird.getRelatedObjects();
		for (org.bimserver.models.ifc2x3tc1.IfcObjectDefinition io : ifcObjects)
		    getComponantGuids(guids, io);
	    }
	} else
	    guids.add(ifcObject.getGlobalId());
	return guids;
    }
    
    private List<String> getComponantGuids(List<String> guids, org.bimserver.models.ifc4.IfcObjectDefinition ifcObject) {
   	if (ifcObject.getIsDecomposedBy().size() >= 1) {
   	    List<org.bimserver.models.ifc4.IfcRelAggregates> irds = ifcObject.getIsDecomposedBy();
   	    for (org.bimserver.models.ifc4.IfcRelAggregates ird : irds) {
   		List<org.bimserver.models.ifc4.IfcObjectDefinition> ifcObjects = ird.getRelatedObjects();
   		for (org.bimserver.models.ifc4.IfcObjectDefinition io : ifcObjects)
   		    getComponantGuids(guids, io);
   	    }
   	} else
   	    guids.add(ifcObject.getGlobalId());
   	return guids;
       }

    @SuppressWarnings("rawtypes")
    private String templateLevelRuleCheck(HashMap<AbstractRule, ObjectToValue> hashMap) {
	String report = new String();
	// No effect, since the cardinality check is not valid anymore in the 1.1
	// version of the specification
	Set<AbstractRule> rules = hashMap.keySet();
	for (AbstractRule rule : rules) {
	    ObjectToValue objectToValue = hashMap.get(rule);
	    //Object ifcObject = objectToValue.getIfcObject();
	    Object value = objectToValue.getValue();
	    List<Object> valueList = new ArrayList<Object>();
	    if (value == null) {
		valueList = null;
	    } else if (value instanceof Collection && value != null) {
		for (Object object : ((Collection) value)) {
		    valueList.add(object);
		}
	    } else {
		valueList.add(value);
	    }

	}
	return report;
    }

    private Boolean conceptLevelRuleCheck(String rule, HashMap<AbstractRule, ObjectToValue> hashMap) {
	rule=filterCharacters(rule);
	Boolean result = false;
	CharStream charStream = new ANTLRStringStream(rule);
	MvdXMLv1_1Lexer lexer = new MvdXMLv1_1Lexer(charStream);
	TokenStream tokenStream = new CommonTokenStream(lexer);
	MvdXMLv1_1Parser parser = new MvdXMLv1_1Parser(tokenStream,hashMap);
	try {
	    result = parser.expression();
	} catch (RecognitionException e) {
	    e.printStackTrace();
	}
	return result;
    }
    
    private String filterCharacters(String rule)
    {
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<rule.length();i++)
	{
	    char ch=rule.charAt(i);
	    if(ch!=';')
		sb.append(ch);
	}
	return sb.toString().trim();
    }

    @SuppressWarnings({ "rawtypes", "unused" })
    private List<Boolean> entityTypeCheck(List<EntityRule> entityRules, List<Object> valueList) {
	List<Boolean> result = new ArrayList<Boolean>();
	List<Class> entityTypes = new ArrayList<Class>();
	for (EntityRule entityRule : entityRules) {
	    try {
		Class cls = null;
		switch (this.ifcversion) {
		case IFC2x3:
		    cls = Class.forName("org.bimserver.models.ifc2x3tc1." + entityRule.getEntityName());
		    break;
		case IFC4:
		    cls = Class.forName("org.bimserver.models.ifc4." + entityRule.getEntityName());
		    break;
		default:
		    throw new RuntimeException("Unsupported IFC type");
		}
		entityTypes.add(cls);
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    }
	}

	for (int i = 0; i < valueList.size(); i++) {
	    Object value = valueList.get(i);
	    if (value == null) {
		result.add(true);
	    }
	    if (value instanceof Collection) {
		List<Boolean> cTypeCheckResult = new ArrayList<Boolean>();
		for (Object obj : (Collection) value) {
		    for (int j = 0; j < entityTypes.size(); j++) {
			if (entityTypes.get(j).isInstance(value)) {
			    cTypeCheckResult.add(true);
			    break;
			} else if (j == entityTypes.size() - 1)
			    cTypeCheckResult.add(false);
		    }
		}
		for (int j = 0; j < cTypeCheckResult.size(); j++) {
		    if (cTypeCheckResult.get(j) == false) {
			result.add(false);
			break;
		    } else if (cTypeCheckResult.get(j) == true && j == cTypeCheckResult.size() - 1)
			result.add(true);
		}
	    } else {
		for (int j = 0; j < entityTypes.size(); j++) {
		    if (entityTypes.get(j).isInstance(value)) {
			result.add(true);
			break;
		    } else if (j == entityTypes.size() - 1)
			result.add(false);

		}
	    }
	}
	return result;
    }

}
