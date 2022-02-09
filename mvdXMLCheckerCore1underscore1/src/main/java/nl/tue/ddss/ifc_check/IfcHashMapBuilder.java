package nl.tue.ddss.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.buildingsmart_tech.mvdxml.mvdxml1_1.AbstractRule;
import org.buildingsmart_tech.mvdxml.mvdxml1_1.AttributeRule;
import org.buildingsmart_tech.mvdxml.mvdxml1_1.EntityRule;

import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

//Modified by JO 2020, 2022

public class IfcHashMapBuilder {
	private final String userId;
    private EventBusCommunication communication = EventBusCommunication.getInstance();
    private Object ifcObject;
    private List<AttributeRule> attributeRules;
    private List<HashMap<AbstractRule, ObjectToValue>> hashMaps;

    public Object getIfcObject() {
	return ifcObject;
    }

    public List<AttributeRule> getAttributeRules() {
	return attributeRules;
    }

    public IfcHashMapBuilder(String userId, Object ifcObject, List<AttributeRule> attributeRules) {
	this.ifcObject = ifcObject;
	this.attributeRules = attributeRules;
	this.userId = userId;
}

    public List<HashMap<AbstractRule, ObjectToValue>> getHashMaps() throws ClassNotFoundException {
	HashMap<AttributeRule, ObjectToValue> initialHM = new HashMap<AttributeRule, ObjectToValue>();
	List<HashMap<AttributeRule, ObjectToValue>> initialHMs = new ArrayList<HashMap<AttributeRule, ObjectToValue>>();
	initialHMs.add(initialHM);
	List<HashMap<AttributeRule, ObjectToValue>> hMs = buildHashMaps(ifcObject, attributeRules, initialHMs);
	hashMaps = new ArrayList<HashMap<AbstractRule, ObjectToValue>>();
	for (HashMap<AttributeRule, ObjectToValue> hM : hMs) {
	    HashMap<AbstractRule, ObjectToValue> hashMap = enrichHashMap(hM);
	    hashMaps.add(hashMap);
	}
	return hashMaps;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<HashMap<AttributeRule, ObjectToValue>> buildHashMaps(Object ifcObject, List<AttributeRule> attributeRules, List<HashMap<AttributeRule, ObjectToValue>> hashMaps) throws ClassNotFoundException {
	for (AttributeRule attributeRule : attributeRules) {	   
	    String attributeName = attributeRule.getAttributeName();
	    Object value = new Object();
	    try {
		if (ifcObject != null) {
		    Method m = ifcObject.getClass().getMethod("get" + attributeName);
		    value = m.invoke(ifcObject);
		} else {
		    value = null;
		}
	    } catch (NoSuchMethodException | SecurityException e) {
		communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(),e.getMessage()));
		e.printStackTrace();
	    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(),e.getMessage()));
		e.printStackTrace();
	    }

	    for (HashMap<AttributeRule, ObjectToValue> hm : hashMaps) {
		hm.put(attributeRule, new ObjectToValue(ifcObject, value));
	    }
	    if (value == null) {
		if (attributeRule.getEntityRules() != null) {
		    List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
		    for (EntityRule entityRule : entityRules) {
			if (entityRule.getAttributeRules() != null) {
			    if (entityRule.getAttributeRules().getAttributeRule().size() >= 1) {
				hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps);
			    }
			}
		    }
		}
	    }
	    if (value instanceof Collection) {
		List<Object> valueList = new ArrayList<Object>();
		valueList.addAll((Collection) value);
		if (valueList.size() == 0) {
		    if (attributeRule.getEntityRules() != null) {
			List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
			for (EntityRule entityRule : entityRules) {
			    if (entityRule.getAttributeRules() != null) {
				if (entityRule.getAttributeRules().getAttributeRule().size() >= 1) {
				    hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps);
				}
			    }
			}
		    }
		} else if (valueList.size() == 1) {
		    if (attributeRule.getEntityRules() != null) {
			List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
			for (EntityRule entityRule : entityRules) {

			    if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityRule.getEntityName()).isInstance(valueList.get(0))) {
				if (entityRule.getAttributeRules() != null) {
				    if (entityRule.getAttributeRules().getAttributeRule().size() >= 1) {
					hashMaps = buildHashMaps(valueList.get(0), entityRule.getAttributeRules().getAttributeRule(), hashMaps);
				    }
				}
			    }
			}
		    }
		} else {
		    List<HashMap<AttributeRule, ObjectToValue>> hMs = copyHashMaps(hashMaps);
		    for (int i = 0; i < valueList.size(); i++) {
			if (i == 0) {
			    if (attributeRule.getEntityRules() != null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				for (EntityRule entityRule : entityRules) {
				    if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityRule.getEntityName()).isInstance(valueList.get(i))) {
					if (entityRule.getAttributeRules() != null) {
					    hashMaps = buildHashMaps((valueList).get(i), entityRule.getAttributeRules().getAttributeRule(), hashMaps);
					}
				    }
				}
			    }
			}
			if (i >= 1) {
			    List<HashMap<AttributeRule, ObjectToValue>> hashMapList = copyHashMaps(hMs);
			    if (attributeRule.getEntityRules() != null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				for (EntityRule entityRule : entityRules) {
				    if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityRule.getEntityName()).isInstance(valueList.get(i))) {
					if (entityRule.getAttributeRules() != null) {

					    List<AttributeRule> attRuleList = entityRule.getAttributeRules().getAttributeRule();
					    if (attRuleList.size() >= 1) {
						hashMaps.addAll(buildHashMaps(valueList.get(i), entityRule.getAttributeRules().getAttributeRule(), hashMapList));
					    }
					}
				    }
				}
			    }
			}
		    }
		}
	    }

	    else if (!(value instanceof String || value instanceof Double || value == null)) {
		if (attributeRule.getEntityRules() != null) {
		    List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
		    for (EntityRule entityRule : entityRules) {
			if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityRule.getEntityName()).isInstance(value)) {
			    if (entityRule.getAttributeRules() != null) {
				hashMaps = buildHashMaps(value, entityRule.getAttributeRules().getAttributeRule(), hashMaps);
			    }
			}
		    }
		}
	    }
	}
	return hashMaps;
    }

    @SuppressWarnings("unchecked")
    public HashMap<AbstractRule, ObjectToValue> enrichHashMap(HashMap<AttributeRule, ObjectToValue> hM) {
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
					} else if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityName).isInstance(object)) {
					    derivedValue = new ArrayList<Object>();
					    ((ArrayList<Object>) derivedValue).add(object);
					}
				    } catch (ClassNotFoundException e) {
					communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(),e.getMessage()));				    }
				}
			    } else {
				derivedValue = null;
				try {
				    if (Class.forName("org.bimserver.models.ifc2x3tc1." + entityName).isInstance(value)) {
					derivedValue = value;
				    }
				} catch (ClassNotFoundException e) {
				    communication.post(new CheckerErrorEvent(this.userId,this.getClass().getName(),e.getMessage()));
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

    public List<HashMap<AttributeRule, ObjectToValue>> copyHashMaps(List<HashMap<AttributeRule, ObjectToValue>> hashMaps) {
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