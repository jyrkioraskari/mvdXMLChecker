package nl.tue.ddss.mvdxml1dot1.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import de.rwth_aachen.dc.ifc.IfcModelInstance.IfcVersion;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.AbstractRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.EntityRule;

public class IfcHashMapBuilder {

    private Object ifcObject;
    private List<AttributeRule> attributeRules;
    private List<HashMap<AbstractRule, ObjectToValue>> hashMaps;
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
    private List<HashMap<AttributeRule, ObjectToValue>> buildHashMaps(Object ifcObject, List<AttributeRule> attributeRules, List<HashMap<AttributeRule, ObjectToValue>> hashMaps) throws ClassNotFoundException {
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
		e.printStackTrace();
	    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
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

			    if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(0))) {
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
				    if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(i))) {
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
				    if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(valueList.get(i))) {
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
			if (Class.forName(this.ifc_class_base + entityRule.getEntityName()).isInstance(value)) {
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
					// TODO Auto-generated catch block
					// e.printStackTrace();
				    }
				}
			    } else {
				derivedValue = null;
				try {
				    if (Class.forName(this.ifc_class_base + entityName).isInstance(value)) {
					derivedValue = value;
				    }
				} catch (ClassNotFoundException e) {
				    // TODO Auto-generated catch block
				    // e.printStackTrace();
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