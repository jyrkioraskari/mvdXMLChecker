package nl.tue.ddss.rule_parse;


import java.util.Collection;

import org.bimserver.emf.IdEObject;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;


// rewritten by JO 2020
public class LessEqualOperator {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

	// fields
	private Object leftOperand;
	private Object rightOperand;

	// constructors
	public LessEqualOperator() {
	}

	public LessEqualOperator(Object leftOperand, Object rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	// methods
	public Object getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(Object leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Object getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Object rightOperand) {
		this.rightOperand = rightOperand;
	}

	public Boolean getResult() {
	    Boolean result = false;
		double right = Double.NaN;
		double left = Double.NaN;

		if (rightOperand instanceof String) {
		    try {
			if(((String) rightOperand).length()!=0)
			right = Double.parseDouble((String) rightOperand);
		    } catch (Exception e) {
			e.printStackTrace();
	                return false;

		    }
		}
		if (rightOperand instanceof Double)
		    right = (Double) rightOperand;
		if (rightOperand instanceof Integer)
		    right = ((Integer) rightOperand).doubleValue();

		if (rightOperand instanceof Collection)
		    System.out.println("To be later supported");
		if (rightOperand instanceof IdEObject)
		    System.out.println("To be later supported");

		
		if (leftOperand instanceof String) {
		    try {
			if(((String) leftOperand).length()!=0)
			left = Double.parseDouble((String) leftOperand);
		    } catch (Exception e) {
			e.printStackTrace();
	                return false;

		    }
		}
		if (leftOperand instanceof Double)
		    left = (Double) leftOperand;
		if (leftOperand instanceof Integer)
		    left = ((Integer) leftOperand).doubleValue();

		if (leftOperand instanceof Collection)
		    System.out.println("To be later supported");
		if (leftOperand instanceof IdEObject)
		    System.out.println("To be later supported");

		if (right != Double.NaN && left != Double.NaN)
		    if (left <= right)
			result = true;
		    else
			result = false;
		if(result==false)
			communication.post(new CheckerShortNotificationEvent("( <B style=\"color:red\"> "+left+ " NOT <= " + right+"</B> )"));
		else
			communication.post(new CheckerShortNotificationEvent("( <B style=\"color:green\"> "+left+ " < " + right+"</B> )"));

		return result;
	}
}