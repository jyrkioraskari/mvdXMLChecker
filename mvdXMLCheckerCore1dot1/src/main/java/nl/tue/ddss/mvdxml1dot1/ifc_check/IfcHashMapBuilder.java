package nl.tue.ddss.mvdxml1dot1.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import de.rwth_aachen.dc.ifc.IfcModelInstance.IfcVersion;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.AbstractRule;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart_tech.mvd_xml_1dot1.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot1.EntityRule;

// Modified by JO 2020,2021, 2022

public class IfcHashMapBuilder {
	private final String userId;
	private EventBusCommunication communication = EventBusCommunication.getInstance();

	private Object ifcObject;
	private List<AttributeRule> attributeRules;
	private final List<HashMap<AbstractRule, ObjectToValue>> hashMaps = new ArrayList<HashMap<AbstractRule, ObjectToValue>>();
	private final String ifc_class_base;

	public IfcHashMapBuilder(String userId, Object ifcObject, List<AttributeRule> attributeRules,
			IfcVersion ifcversion) {
		this.ifcObject = ifcObject;
		this.attributeRules = attributeRules;
		this.userId = userId;

		switch (ifcversion) {
		default:
		case IFC2x3:
			ifc_class_base = "org.bimserver.models.ifc2x3tc1.";
			break;
		case IFC4:
			ifc_class_base = "org.bimserver.models.ifc4.";
			break;
		}
		// System.out.println("ifcObject: " + ifcObject);
		List<HashMap<AttributeRule, ObjectToValue>> initialHMs = new ArrayList<HashMap<AttributeRule, ObjectToValue>>();
		initialHMs.add(new HashMap<AttributeRule, ObjectToValue>());

		try {
			List<HashMap<AttributeRule, ObjectToValue>> hMs = buildHashMaps(ifcObject, attributeRules, initialHMs);

			for (HashMap<AttributeRule, ObjectToValue> hM : hMs)
				this.hashMaps.add(enrichHashMap(hM));
		} catch (ClassNotFoundException e) {
			communication.post(new CheckerNotificationEvent(this.userId,
					"The Java class  was not found. Is the spelling correct in mvdXML ? "));
		}

	}

	public List<HashMap<AbstractRule, ObjectToValue>> getHashMaps() {
		return this.hashMaps;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<HashMap<AttributeRule, ObjectToValue>> buildHashMaps(Object ifcObject,
			List<AttributeRule> attributeRules, List<HashMap<AttributeRule, ObjectToValue>> hashMaps)
			throws ClassNotFoundException {
		for (AttributeRule attributeRule : attributeRules) {
			Object value = getAttributeValue(ifcObject, attributeRule.getAttributeName());
			for (HashMap<AttributeRule, ObjectToValue> hm : hashMaps) {
				hm.put(attributeRule, new ObjectToValue(ifcObject, value));
			}
			if (attributeRule.getEntityRules() == null)
				continue;
			if (value == null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				for (EntityRule entityRule : entityRules)
					if ((entityRule.getAttributeRules() != null)
							&& (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
						hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps);

			}
			if (value instanceof Collection) {
				List<Object> valueList = new ArrayList<Object>();
				valueList.addAll((Collection) value);
				List<EntityRule> entityRules;
				switch (valueList.size()) {
				case 0:
					entityRules = attributeRule.getEntityRules().getEntityRule();
					for (EntityRule entityRule : entityRules) {
						if ((entityRule.getAttributeRules() != null)
								&& (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
							hashMaps = buildHashMaps(null, entityRule.getAttributeRules().getAttributeRule(), hashMaps);

					}

					break;
				case 1:
					entityRules = attributeRule.getEntityRules().getEntityRule();
					for (EntityRule entityRule : entityRules)
						if (isInstance(valueList.get(0), this.ifc_class_base + entityRule.getEntityName()))
							if ((entityRule.getAttributeRules() != null)
									&& (entityRule.getAttributeRules().getAttributeRule().size() >= 1))
								hashMaps = buildHashMaps(valueList.get(0),
										entityRule.getAttributeRules().getAttributeRule(), hashMaps);

					break;
				default:
					List<HashMap<AttributeRule, ObjectToValue>> hMs = copyHashMaps(hashMaps);
					for (int i = 0; i < valueList.size(); i++) {
						if (i == 0) {
							entityRules = attributeRule.getEntityRules().getEntityRule();
							for (EntityRule entityRule : entityRules) {
								if (isInstance(valueList.get(i), this.ifc_class_base + entityRule.getEntityName())
										&& entityRule.getAttributeRules() != null)
									hashMaps = buildHashMaps((valueList).get(i),
											entityRule.getAttributeRules().getAttributeRule(), hashMaps);
							}

						} else if (i >= 1) {
							List<HashMap<AttributeRule, ObjectToValue>> hashMapList = copyHashMaps(hMs);
							entityRules = attributeRule.getEntityRules().getEntityRule();
							for (EntityRule entityRule : entityRules) {
								if (isInstance(valueList.get(i), this.ifc_class_base + entityRule.getEntityName())
										&& entityRule.getAttributeRules() != null) {
									List<AttributeRule> attRuleList = entityRule.getAttributeRules().getAttributeRule();
									if (attRuleList.size() >= 1)
										hashMaps.addAll(buildHashMaps(valueList.get(i),
												entityRule.getAttributeRules().getAttributeRule(), hashMapList));

								}
							}
						}
					}

				}
			} else if (!(value instanceof String || value instanceof Double || value == null)) {				
					List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
					for (EntityRule entityRule : entityRules)
						if (isInstance(value, this.ifc_class_base + entityRule.getEntityName())
								&& entityRule.getAttributeRules() != null)
							hashMaps = buildHashMaps(value, entityRule.getAttributeRules().getAttributeRule(), hashMaps);				
			}
		}
		return hashMaps;
	}

	private boolean isInstance(Object obj, String className) {
		try {
			return Class.forName(className).isInstance(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			communication.post(new CheckerNotificationEvent(this.userId, "There is no class named: " + className));
		}
		return false;
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
			// communication.post(new CheckerErrorEvent(this.getClass().getName(),
			// e.getMessage()));
			communication.post(new CheckerErrorEvent(this.userId,
					"Attribute defined in mvdXML ConceptTemplate does not exist in IFC: ", e.getMessage()));
			// e.printStackTrace();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			communication.post(new CheckerErrorEvent(this.userId, this.getClass().getName(), e.getMessage()));
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
										communication.post(new CheckerNotificationEvent(this.userId,
												"The IFC Java class for " + entityName
														+ " was not found. Is the spelling correct in mvdXML ?"));
									}
								}
							} else {
								derivedValue = null;
								try {
									if (Class.forName(this.ifc_class_base + entityName).isInstance(value)) {
										derivedValue = value;
									}
								} catch (ClassNotFoundException e) {
									communication.post(new CheckerNotificationEvent(this.userId,
											"The IFC Java class for " + entityName
													+ " was not found. Is the spelling correct in mvdXML ?"));
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

	private List<HashMap<AttributeRule, ObjectToValue>> copyHashMaps(
			List<HashMap<AttributeRule, ObjectToValue>> hashMaps) {
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