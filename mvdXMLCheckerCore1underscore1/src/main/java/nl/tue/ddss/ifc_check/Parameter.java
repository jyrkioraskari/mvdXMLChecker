package nl.tue.ddss.ifc_check;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.buildingsmart_tech.mvdxml.mvdxml1_1.AbstractRule;
import org.eclipse.emf.common.util.Enumerator;

import nl.tue.ddss.ifc_check.IfcHashMapBuilder.ObjectToValue;

public class Parameter {
    Object result;
    String name;
    HashMap<AbstractRule, ObjectToValue> hashMap;

    public Parameter(String name, HashMap<AbstractRule, ObjectToValue> hashMap) {
	this.name = name;
	this.hashMap = hashMap;
    }

    public Object getResult() {
	Set<AbstractRule> rules = this.hashMap.keySet();
	Object value = null;
	for (AbstractRule rule : rules) {
	    if (name.equals(rule.getRuleID())) {
		//System.out.println(name+" equals");
		value = this.hashMap.get(rule).getValue();
		//System.out.println("value is: "+value);
		break;
	    }

	}
	
	// Fixed by JO 2020
	if (value == null)
	    result = null;
	else if (value instanceof Collection)
	    result = value;
	else if (value instanceof Double || value instanceof String)
	    result = value;
	else if (value instanceof Enumerator)
	    result = ((Enumerator) value).getLiteral();
	else if (value instanceof org.bimserver.models.ifc2x3tc1.impl.IfcLabelImpl)
	    result = ((org.bimserver.models.ifc2x3tc1.impl.IfcLabelImpl) value).getWrappedValue().toString();
	else if (value instanceof org.bimserver.models.ifc4.impl.IfcLabelImpl)
	    result = ((org.bimserver.models.ifc4.impl.IfcLabelImpl) value).getWrappedValue().toString();
	
	else if (value instanceof org.bimserver.models.ifc2x3tc1.impl.IfcRealImpl)
	    result = ((org.bimserver.models.ifc2x3tc1.impl.IfcRealImpl) value).getWrappedValue();
	else if (value instanceof org.bimserver.models.ifc4.impl.IfcRealImpl)
	    result = ((org.bimserver.models.ifc4.impl.IfcRealImpl) value).getWrappedValue();

	else if (value instanceof org.bimserver.models.ifc2x3tc1.impl.IfcIntegerImpl)
	    result = ((org.bimserver.models.ifc2x3tc1.impl.IfcIntegerImpl) value).getWrappedValue();
	else if (value instanceof org.bimserver.models.ifc4.impl.IfcIntegerImpl)
	    result = ((org.bimserver.models.ifc4.impl.IfcIntegerImpl) value).getWrappedValue();
	
	else if (value instanceof org.bimserver.models.ifc2x3tc1.impl.IfcBooleanImpl)
	    result = ((org.bimserver.models.ifc2x3tc1.impl.IfcBooleanImpl) value).getWrappedValue().toString();
	else if (value instanceof org.bimserver.models.ifc4.impl.IfcBooleanImpl)
	    result = ((org.bimserver.models.ifc4.impl.IfcBooleanImpl) value).getWrappedValue().toString();

	else if (value instanceof org.bimserver.models.ifc4.impl.IfcTextImpl)
	    result = ((org.bimserver.models.ifc4.impl.IfcTextImpl) value).getWrappedValue().toString();
	else if (value instanceof org.bimserver.models.ifc2x3tc1.impl.IfcTextImpl)
	    result = ((org.bimserver.models.ifc2x3tc1.impl.IfcTextImpl) value).getWrappedValue().toString();

	
	else if (value instanceof IdEObject)
	    result = value;
	else
	    result=value;
	
	System.out.println("Param WAS: "+result);
	return result;
    }

}
