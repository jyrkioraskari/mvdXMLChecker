package nl.tue.ddss.mvdxml1dot1.rule_operators;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

import org.bimserver.emf.IdEObject;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

abstract public class AbstractComparatorOperator {
    protected EventBusCommunication communication = EventBusCommunication.getInstance();

    
    protected Double getValue(Object operand)
    {
	double value = Double.NaN;
	if(operand==null)
	{
	    communication.post(new CheckerShortNotificationEvent("( <B style=\"color:red\"> null value. </B> )"));
	    return null;
        }
	if (operand instanceof String) {
	    try {
		if(((String) operand).trim().length()>00)
		   value = Double.parseDouble((String) operand);
		else {
		    communication.post(new CheckerShortNotificationEvent("( <B style=\"color:red\"> Value is an empty String. </B> )"));
		    return null;
	        }
	    } 
	    catch (NumberFormatException e) {
		return null;
	    }
	    catch (Exception e) {
		    e.printStackTrace();
		    communication.post(new CheckerShortNotificationEvent("( <B style=\"color:red\"> Value of a  string, "+operand+", not a number</B> )"));
		    return null;
	    }
	}
	if (operand instanceof Double)
	    value = (Double) operand;
	if (operand instanceof Float)
	    value = ((Float) operand).doubleValue();

	if (operand instanceof Integer)
	    value = ((Integer) operand).doubleValue();
	if (operand instanceof Long)
	    value = ((Long) operand).doubleValue();

	/*
	if (operand instanceof Collection)
	    System.out.println("To be later supported");
	if (operand instanceof IdEObject)
	    System.out.println("To be later supported");
	    */

	return value;
    }
}
