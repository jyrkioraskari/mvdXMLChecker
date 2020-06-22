package nl.tue.ddss.mvdxml1dot2.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import de.rwth_aachen.dc.ifc.IfcModelInstance.IfcVersion;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.AbstractRule;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart_tech.mvd_xml_1dot2.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.EntityRule;

// Modified by JO 2020

public class IfcHashMapBuilder {
    private EventBusCommunication communication = EventBusCommunication.getInstance();
    private Object ifcObject;
    private List<AttributeRule> attributeRules;
    private final List<HashMap<AbstractRule, ObjectToValue>> hashMaps = new ArrayList<HashMap<AbstractRule, ObjectToValue>>();
    private final String ifc_class_base;

    public IfcHashMapBuilder(Object ifcObject, List<AttributeRule> attributeRules, IfcVersion ifcversion) {
	this.ifcObject = ifcObject;
	this.attributeRules = attributeRules;
	switch (ifcversion) {
	default:
	case IFC2x3:
	    ifc_class_base = "org.bimserver.models.ifc2x3tc1.";
	    break;
	case IFC4:
	    ifc_class_base = "org.bimserver.models.ifc4.";
	    break;
	}
        System.out.println("ifcObject: "+ifcObject);
	List<HashMap<AttributeRule, ObjectToValue>> initialHMs = new ArrayList<HashMap<AttributeRule, ObjectToValue>>();
	initialHMs.add(new HashMap<AttributeRule, ObjectToValue>());

	try {
	    List<HashMap<AttributeRule, ObjectToValue>> hMs = buildHashMaps(ifcObject, attributeRules, initialHMs,0);

	    for (HashMap<AttributeRule, ObjectToValue> hM : hMs)
		this.hashMaps.add(enrichHashMap(hM));
	} catch (ClassNotFoundException e) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
	    e.printStackTrace();
	}

    }

    public List<HashMap<AbstractRule, ObjectToValue>> getHashMaps() {
	return this.hashMaps;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private List<HashMap<AttributeRule, ObjectToValue>> buildHashMaps(Object ifcObject, List<AttributeRule> attributeRules, List<HashMap<AttributeRule, ObjectToValue>> hashMaps,int inx) throws ClassNotFoundException {	
	for (AttributeRule attributeRule : attributeRules) {
	    Object value = getAttributeValue(ifcObject, attributeRule.getAttributeName());
	    for (HashMap<AttributeRule, ObjectToValue> hm : hashMaps) {
		hm.put(attributeRule, new ObjectToValue(ifcObject, value));
	    }
	    if (value == null) {
		if (attributeRule.getEntityRules() != null) {
		    List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
		    for (EntityRule entityRule : entityRules)
			if ((entityRule.getAttributeRules() != null) && (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
			    hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps,inx+1);
		}
	    }
	    if (value instanceof Collection) {
		List<Object> valueList = new ArrayList<Object>();
		valueList.addAll((Collection) value);

		switch (valueList.size()) {
		case 0:
		    if (attributeRule.getEntityRules() != null) {
			List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
			for (EntityRule entityRule : entityRules) {
			    if ((entityRule.getAttributeRules() != null) && (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
				hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps,inx+1);

			}
		    }
		    break;
		case 1:
		    if (attributeRule.getEntityRules() != null) {
			List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
			for (EntityRule entityRule : entityRules)
			    if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(0)))
				if ((entityRule.getAttributeRules() != null) && (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
				    hashMaps = buildHashMaps(valueList.get(0), entityRule.getAttributeRules().getAttributeRule(), hashMaps,inx+1);
		    }
		    break;
		default:
		    List<HashMap<AttributeRule, ObjectToValue>> hMs = copyHashMaps(hashMaps);
		    for (int i = 0; i < valueList.size(); i++) {
			if (i == 0) {
			    if (attributeRule.getEntityRules() != null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				for (EntityRule entityRule : entityRules)
				    if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(i)))
					if (entityRule.getAttributeRules() != null)
					    hashMaps = buildHashMaps((valueList).get(i), entityRule.getAttributeRules().getAttributeRule(), hashMaps,inx+1);
			    }
			} else if (i >= 1) {
			    List<HashMap<AttributeRule, ObjectToValue>> hashMapList = copyHashMaps(hMs);
			    if (attributeRule.getEntityRules() != null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				for (EntityRule entityRule : entityRules) {
				    if ((Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(i))) && (entityRule.getAttributeRules() != null)) {
					List<AttributeRule> attRuleList = entityRule.getAttributeRules().getAttributeRule();
					if (attRuleList.size() >= 1)
					    hashMaps.addAll(buildHashMaps(valueList.get(i), entityRule.getAttributeRules().getAttributeRule(), hashMapList,inx+1));

				    }
				}
			    }
			}
		    }

		}
	    } else if (!(value instanceof String || value instanceof Double || value == null)) {
		if (attributeRule.getEntityRules() != null) {
		    List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
		    for (EntityRule entityRule : entityRules)
			if ((Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(value)) && (entityRule.getAttributeRules() != null))
			    hashMaps = buildHashMaps(value, entityRule.getAttributeRules().getAttributeRule(), hashMaps,inx+1);
		}
	    }
	}
	return hashMaps;
    }

    private Object getAttributeValue(Object ifcObject, String attributeName) {
	Object value = new Object();
	try {
	    if (ifcObject != null)
		value = ifcObject.getClass().getMethod("get" + attributeName).invoke(ifcObject);
	    else {
		value = null;
	    }
	} catch (NoSuchMethodException | SecurityException e) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
	    e.printStackTrace();
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
	    e.printStackTrace();
	}
	return value;
    }

    @SuppressWarnings("unchecked")
    private HashMap<AbstractRule, ObjectToValue> enrichHashMap(HashMap<AttributeRule, ObjectToValue> hM) {
	Set<AttributeRule> attributeRules = hM.keySet();
	HashMap<AbstractRule, ObjectToValue> enrichedHashMap = new HashMap<AbstractRule, ObjectToValue>();
	for (AttributeRule attributeRule : attributeRules) {
	    enrichedHashMap.put(attributeRule, hM.get(attributeRule));
	    Object ifcObject = hM.get(attributeRule).getIfcObject();
	    Object value = hM.get(attributeRule).getValue();
	    if (attributeRule.getEntityRules() != null) {
		List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
		if (entityRules.size() >= 1) {
		    for (EntityRule entityRule : entityRules) {
			Object derivedValue = new Object();
			String entityName = entityRule.getEntityName();
			if (value == null) {
			    derivedValue = value;
			} else {
			    derivedValue = null;
			    if (value instanceof Collection) {
				derivedValue = new ArrayList<Object>();
				for (Object object : (Collection<?>) value) {
				    try {
					if (object instanceof String) {
					} else if (object instanceof Double) {
					} else if (Class.forName(this.ifc_class_base + entityName).isInstance(object)) {
					    derivedValue = new ArrayList<Object>();
					    ((ArrayList<Object>) derivedValue).add(object);
					}
				    } catch (ClassNotFoundException e) {
					communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
					e.printStackTrace();
				    }
				}
			    } else {
				derivedValue = null;
				try {
				    if (Class.forName(this.ifc_class_base + entityName).isInstance(value)) {
					derivedValue = value;
				    }
				} catch (ClassNotFoundException e) {
				    communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
				    e.printStackTrace();
				}
			    }
			}
			enrichedHashMap.put(entityRule, new ObjectToValue(ifcObject, derivedValue));
		    }
		}
	    }
	}
	return enrichedHashMap;
    }

    private List<HashMap<AttributeRule, ObjectToValue>> copyHashMaps(List<HashMap<AttributeRule, ObjectToValue>> hashMaps) {
	List<HashMap<AttributeRule, ObjectToValue>> hashMapList = new ArrayList<HashMap<AttributeRule, ObjectToValue>>();
	for (HashMap<AttributeRule, ObjectToValue> hashMap : hashMaps) {
	    HashMap<AttributeRule, ObjectToValue> hm = new HashMap<AttributeRule, ObjectToValue>();
	    Set<AttributeRule> keySet = hashMap.keySet();
	    for (AttributeRule attributeRule : keySet) {
		hm.put(attributeRule, hashMap.get(attributeRule));
	    }
	    hashMapList.add(hm);
	}
	return hashMapList;
    }

    public Object getIfcObject() {
	return ifcObject;
    }

    public List<AttributeRule> getAttributeRules() {
	return attributeRules;
    }

    public class ObjectToValue {
	Object ifcObject;
	Object value;

	public ObjectToValue(Object ifcObject, Object value) {
	    this.ifcObject = ifcObject;
	    this.value = value;
	}

	public Object getIfcObject() {
	    return ifcObject;
	}

	public Object getValue() {
	    return value;
	}
    }

}