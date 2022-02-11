package nl.tue.ddss.mvdxml1dot2.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.rwth_aachen.dc.ifc.IfcModelInstance.IfcVersion;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.AbstractRule;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart_tech.mvd_xml_1dot2.AttributeRule;
import generated.buildingsmart_tech.mvd_xml_1dot2.EntityRule;

// Modified by JO 2020,2021, 2022

public class IfcHashMapBuilder {
	private final String userId;
	private EventBusCommunication communication = EventBusCommunication.getInstance();

	private Object ifcObject;
	private List<AttributeRule> attributeRules;
	private final List<HashMap<AbstractRule, Map.Entry<Object, Object>>> hashMaps = new ArrayList<HashMap<AbstractRule, Map.Entry<Object, Object>>>();
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
		List<HashMap<AttributeRule, Map.Entry<Object, Object>>> initialHMs = new ArrayList<HashMap<AttributeRule, Map.Entry<Object, Object>>>();
		initialHMs.add(new HashMap<AttributeRule, Map.Entry<Object, Object>>());

		try {
			List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hMs = buildValueMaps(ifcObject, attributeRules, initialHMs);

			for (HashMap<AttributeRule, Map.Entry<Object, Object>> hM : hMs)
				this.hashMaps.add(enrichHashMap(hM));
		} catch (ClassNotFoundException e) {
			communication.post(new CheckerNotificationEvent(this.userId,
					"The Java class  was not found. Is the spelling correct in mvdXML ? "));
		}

	}

	public List<HashMap<AbstractRule, Map.Entry<Object, Object>>> getHashMaps() {
		return this.hashMaps;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<HashMap<AttributeRule, Map.Entry<Object, Object>>> buildValueMaps(Object ifcObject,
			List<AttributeRule> mvdXML_template_attributeRules, List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hashMaps)
			throws ClassNotFoundException {
		for (AttributeRule mvdXML_attributeRule : mvdXML_template_attributeRules) {
			Object IFC_value = getIFCAttributeValue(ifcObject, mvdXML_attributeRule.getAttributeName());
			for (HashMap<AttributeRule, Map.Entry<Object, Object>> hm : hashMaps) {
				hm.put(mvdXML_attributeRule, new AbstractMap.SimpleEntry<>(ifcObject, IFC_value));
			}
			if (mvdXML_attributeRule.getEntityRules() == null)
				continue;
			if (IFC_value == null) {
				List<EntityRule> mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
				for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
					if ((mvdXML_entityRule.getAttributeRules() != null)
							&& (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1))
						hashMaps = buildValueMaps(null, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps);

			}
			else if (IFC_value instanceof Collection) {
				List<Object> IFC_valueList = new ArrayList<Object>();  // Collection of any kind into List
				IFC_valueList.addAll((Collection) IFC_value);
				List<EntityRule> mvdXML_entityRules;
				switch (IFC_valueList.size()) {
				case 0:
					mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
					for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
						if ((mvdXML_entityRule.getAttributeRules() != null)
								&& (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1))
							hashMaps = buildValueMaps(null, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps);

					}

					break;
				case 1:
					mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
					for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
						if (mvdXML_entityRule.getAttributeRules() != null && (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1)
						&& isInstance(IFC_valueList.get(0), this.ifc_class_base + mvdXML_entityRule.getEntityName()))
								hashMaps = buildValueMaps(IFC_valueList.get(0),
										mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps);

					break;
				default:
					List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hMs = copyHashMaps(hashMaps);
					for (int i = 0; i < IFC_valueList.size(); i++) {
						if (i == 0) {
							mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
							for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
								if (mvdXML_entityRule.getAttributeRules() != null && isInstance(IFC_valueList.get(i), this.ifc_class_base + mvdXML_entityRule.getEntityName())
										)
									hashMaps = buildValueMaps((IFC_valueList).get(i),
											mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps);
							}

						} else if (i >= 1) {
							List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hashMapList = copyHashMaps(hMs);
							mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
							for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
								if (mvdXML_entityRule.getAttributeRules() != null && isInstance(IFC_valueList.get(i), this.ifc_class_base + mvdXML_entityRule.getEntityName())
										) {
									List<AttributeRule> attRuleList = mvdXML_entityRule.getAttributeRules().getAttributeRule();
									if (attRuleList.size() >= 1)
										hashMaps.addAll(buildValueMaps(IFC_valueList.get(i),
												mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMapList));

								}
							}
						}
					}

				}
			} else if (!(IFC_value instanceof String || IFC_value instanceof Double || IFC_value == null)) {
				List<EntityRule> mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
				for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
					if (mvdXML_entityRule.getAttributeRules() != null && isInstance(IFC_value, this.ifc_class_base + mvdXML_entityRule.getEntityName())
							)
						hashMaps = buildValueMaps(IFC_value, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps);
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

	private Object getIFCAttributeValue(Object ifcObject, String attributeName) {
		Object value = new Object();
		try {
			if (ifcObject != null)
				value = ifcObject.getClass().getMethod("get" + attributeName).invoke(ifcObject);
			else {
				value = null;
			}
		} catch (NoSuchMethodException | SecurityException e) {
			communication.post(new CheckerErrorEvent(this.userId,
					"Attribute defined in mvdXML ConceptTemplate does not exist in IFC: ", e.getMessage()));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			communication.post(new CheckerErrorEvent(this.userId, this.getClass().getName(), e.getMessage()));
			e.printStackTrace();
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	private HashMap<AbstractRule, Map.Entry<Object, Object>> enrichHashMap(HashMap<AttributeRule, Map.Entry<Object, Object>> attributes_valuemap) {
		Set<AttributeRule> attributeRules = attributes_valuemap.keySet();
		HashMap<AbstractRule, Map.Entry<Object, Object>> enrichedMap = new HashMap<AbstractRule, Map.Entry<Object, Object>>();
		
		for (AttributeRule attributeRule : attributeRules) {
			Map.Entry<Object, Object> ifcvalue_tuple = attributes_valuemap.get(attributeRule);
			enrichedMap.put(attributeRule, attributes_valuemap.get(attributeRule));
			Object ifcObject = attributes_valuemap.get(attributeRule).getKey();
			Object value = attributes_valuemap.get(attributeRule).getValue();
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
						enrichedMap.put(entityRule, new AbstractMap.SimpleEntry<>(ifcObject, derivedValue));
					}
				}
			}
		}
		return enrichedMap;
	}

	private List<HashMap<AttributeRule, Map.Entry<Object, Object>>> copyHashMaps(
			List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hashMaps) {
		List<HashMap<AttributeRule, Map.Entry<Object, Object>>> hashMapList = new ArrayList<HashMap<AttributeRule, Map.Entry<Object, Object>>>();
		for (HashMap<AttributeRule, Map.Entry<Object, Object>> hashMap : hashMaps) {
			HashMap<AttributeRule, Map.Entry<Object, Object>> hm = new HashMap<AttributeRule, Map.Entry<Object, Object>>();
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

	

}