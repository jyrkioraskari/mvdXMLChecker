package nl.tue.ddss.mvdxml1dot1.ifc_check;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
	private final List<HashMap<AbstractRule, Object>> hashMaps = new ArrayList<HashMap<AbstractRule, Object>>();
	private final String ifc_class_base;
	
	Set<Object> handled= new HashSet<>();
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
		List<HashMap<AttributeRule, Object>> initialHMs = new ArrayList<HashMap<AttributeRule, Object>>();
		initialHMs.add(new HashMap<AttributeRule, Object>());

		try {
			System.out.println("JO buildValueMaps");
			List<HashMap<AttributeRule, Object>> hMs = buildValueMaps(ifcObject, attributeRules, initialHMs,0);
			System.out.println("JO buildValueMaps done");
			handled.clear();
            System.out.println("JO enrichHashMap");
            if(hMs!=null)  //TODO sub templates
			for (HashMap<AttributeRule, Object> hM : hMs)
				if(hM!=null)
				  this.hashMaps.add(enrichHashMap(hM));
			System.out.println("JO enrichHashMap done");
		} catch (ClassNotFoundException e) {
			communication.post(new CheckerNotificationEvent(this.userId,
					"The Java class  was not found. Is the spelling correct in mvdXML ? "));
		}

	}

	public List<HashMap<AbstractRule, Object>> getHashMaps() {
		return this.hashMaps;
	}

	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<HashMap<AttributeRule, Object>> buildValueMaps(Object ifcObject,
			List<AttributeRule> mvdXML_template_attributeRules, List<HashMap<AttributeRule, Object>> hashMaps,int deep)
			throws ClassNotFoundException 
	
	{
		System.out.println(" -- Deep: "+deep +" hs: "+ hashMaps.size());
		boolean added=false;
		for (AttributeRule mvdXML_attributeRule : mvdXML_template_attributeRules) {
			System.out.println(" --- Deep: "+deep+ "rule "+mvdXML_attributeRule.getAttributeName());
			Object IFC_value = getIFCAttributeValue(ifcObject, mvdXML_attributeRule.getAttributeName());
			if(IFC_value==null)
				continue;
			if(handled.add(IFC_value))  //JO 2022_02 avoid loops
			{
			 for (HashMap<AttributeRule, Object> hm : hashMaps) {
				 if(mvdXML_attributeRule.getRuleID()!=null)  // Only with RuleID  JO 2022_02 
				 {	 
				    hm.put(mvdXML_attributeRule, IFC_value);
				    added=true;
				 }
			 }
		    }
			else 
			{
				System.out.println("Already handled");
				continue;
			}
			if (mvdXML_attributeRule.getEntityRules() == null)
				continue;
			if (IFC_value == null) {  //JO 2022_02 Should never be null
				System.out.print("N");
				continue;
				/*List<EntityRule> mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
				for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
					if ((mvdXML_entityRule.getAttributeRules() != null)
							&& (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1))
						hashMaps = buildValueMaps(null, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps,deep+1);*/

			}
			else if (IFC_value instanceof Collection) {
				System.out.print("C");
				List<Object> ifc_valueList = new ArrayList<Object>();  // Collection of any kind into List
				ifc_valueList.addAll((Collection) IFC_value);
				List<EntityRule> mvdXML_entityRules;
				switch (ifc_valueList.size()) {
				case 0:
					System.out.print("o");//JO 2022_02 Should never be null
					/*mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
					for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
						if ((mvdXML_entityRule.getAttributeRules() != null)
								&& (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1))
							hashMaps = buildValueMaps(null, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps,deep+1);

					}*/
					
					break;
				case 1:
					System.out.print("1");
					mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
					for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
						if (mvdXML_entityRule.getAttributeRules() != null && (mvdXML_entityRule.getAttributeRules().getAttributeRule().size() >= 1)
						&& isInstance(ifc_valueList.get(0), this.ifc_class_base + mvdXML_entityRule.getEntityName()))
						{								
					            List<HashMap<AttributeRule, Object>> ret =  buildValueMaps(ifc_valueList.get(0),
										mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps,deep+1);
								
								if(ret!=null)
								{
								  added=true;
						          hashMaps=ret;
								}
						}
					break;
				default:
					//List<HashMap<AttributeRule, Object>> hMs = copyValueMaps(hashMaps);
					System.out.print("DV "+ifc_valueList.size());
					List<HashMap<AttributeRule, Object>>  hashMapListBK=hashMaps;
					if(ifc_valueList.size()>1)
					   hashMapListBK = copyValueMaps(hashMaps);
					for (int i = 0; i < ifc_valueList.size(); i++) {
						
						if (i == 0) {
							mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
							for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
								if (mvdXML_entityRule.getAttributeRules() != null && isInstance(ifc_valueList.get(i), this.ifc_class_base + mvdXML_entityRule.getEntityName())
										)
								{
									List<HashMap<AttributeRule, Object>> ret = buildValueMaps((ifc_valueList).get(i),
											mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps,deep+1);
								
											if(ret!=null)
											{
											  added=true;
									          hashMaps=ret;
											}
								}
							}

						} else if (i >= 1) {
							mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
							for (EntityRule mvdXML_entityRule : mvdXML_entityRules) {
								if (mvdXML_entityRule.getAttributeRules() != null && isInstance(ifc_valueList.get(i), this.ifc_class_base + mvdXML_entityRule.getEntityName())
										) {
									List<AttributeRule> attRuleList = mvdXML_entityRule.getAttributeRules().getAttributeRule();
									if (attRuleList.size() >= 1)
									{
										List<HashMap<AttributeRule, Object>>  hashMapCopy=copyValueMaps(hashMapListBK);
										List<HashMap<AttributeRule, Object>> ret = buildValueMaps(ifc_valueList.get(i),
												mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMapCopy,deep+1);
										if(ret!=null)
										for(HashMap<AttributeRule, Object> rethm:ret)
											if(rethm!=null)
											{
												  added=true;
										          hashMaps.add(rethm);
											}
									}

								}
							}
						}
					}
					System.out.print("exDV ");
				}
			} else if (!(IFC_value instanceof String || IFC_value instanceof Double)) {
				System.out.print("EE ");
				List<EntityRule> mvdXML_entityRules = mvdXML_attributeRule.getEntityRules().getEntityRule();
				for (EntityRule mvdXML_entityRule : mvdXML_entityRules)
					if (mvdXML_entityRule.getAttributeRules() != null && isInstance(IFC_value, this.ifc_class_base + mvdXML_entityRule.getEntityName())
							)
					{
						List<HashMap<AttributeRule, Object>> ret =  buildValueMaps(IFC_value, mvdXML_entityRule.getAttributeRules().getAttributeRule(), hashMaps,deep+1);
					
								if(ret!=null)
								{
								  added=true;
						          hashMaps=ret;
								}
					}
				
			}
		}
		System.out.println("R");
		if(added==false)
			return null;
		return hashMaps;
	}

	private boolean isInstance(Object obj, String className) {
		try {
			return Class.forName(className).isInstance(obj);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
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
	private HashMap<AbstractRule, Object> enrichHashMap(HashMap<AttributeRule, Object> attributes_valuemap) {
		Set<AttributeRule> attributeRules = attributes_valuemap.keySet();
		HashMap<AbstractRule, Object> enrichedMap = new HashMap<AbstractRule, Object>();
		
		for (AttributeRule attributeRule : attributeRules) {
			Object ifcvalue_tuple = attributes_valuemap.get(attributeRule);
			enrichedMap.put(attributeRule, attributes_valuemap.get(attributeRule));  // ORG Value
			Object ifc_value = attributes_valuemap.get(attributeRule);
			if (attributeRule.getEntityRules() != null) {
				List<EntityRule> entityRules = attributeRule.getEntityRules().getEntityRule();
				if (entityRules.size() >= 1) {
					for (EntityRule entityRule : entityRules) {
						Object derivedValue = new Object();
						String entityName = entityRule.getEntityName();
						if (ifc_value == null) {
							derivedValue = ifc_value;
						} else {
							derivedValue = null;
							if (ifc_value instanceof Collection) {
								derivedValue = new ArrayList<Object>();
								for (Object object : (Collection<?>) ifc_value) {
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
									if (Class.forName(this.ifc_class_base + entityName).isInstance(ifc_value)) {
										derivedValue = ifc_value;
									}
								} catch (ClassNotFoundException e) {
									communication.post(new CheckerNotificationEvent(this.userId,
											"The IFC Java class for " + entityName
													+ " was not found. Is the spelling correct in mvdXML ?"));
								}
							}
						}
						
						if(derivedValue!=null) // JO 2022_02 No null values
						  enrichedMap.put(entityRule, derivedValue);
					}
				}
			}
		}
		return enrichedMap;
	}

	
	/*private List<HashMap<AttributeRule, Object>> copyValueMaps(
			List<HashMap<AttributeRule, Object>> org_hashMaps) {
		System.out.println("COPY");
		List<HashMap<AttributeRule, Object>> new_copy = new ArrayList<HashMap<AttributeRule, Object>>();
		
		for (HashMap<AttributeRule, Object> hashMap : org_hashMaps) {
			HashMap<AttributeRule, Object> hm = new HashMap<AttributeRule, Object>();
			
			for (AttributeRule attributeRule : hashMap.keySet()) {
				hm.put(attributeRule, hashMap.get(attributeRule));
			}
			new_copy.add(hm);
		}
		System.out.println("COPY done");
		return new_copy;
	}*/

	private List<HashMap<AttributeRule, Object>> copyValueMaps(
			List<HashMap<AttributeRule, Object>> org_hashMaps) {
		System.out.println("COPY");
		List<HashMap<AttributeRule, Object>> new_copy = new ArrayList<HashMap<AttributeRule, Object>>();
		
		for (HashMap<AttributeRule, Object> hashMap : org_hashMaps) {
			new_copy.add((HashMap<AttributeRule, Object>) hashMap.clone());
		}
		System.out.println("COPY done");
		return new_copy;
	}

	public Object getIfcObject() {
		return ifcObject;
	}

	public List<AttributeRule> getAttributeRules() {
		return attributeRules;
	}

	

}