package nl.tue.ddss.rule_parse;

import java.util.Collection;

import org.bimserver.emf.IdEObject;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

// rewritten by JO 2020

public class LessOperator extends AbstractComparatorOperator{

    // fields
    private Object leftOperand;
    private Object rightOperand;

	// constructors
	public LessOperator(String userId) {
		super(userId);
	}

	public LessOperator(String userId, Object leftOperand, Object rightOperand) {
		super(userId);
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		// System.out.println("LESS operator");

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
	Double right = Double.NaN;
	Double left = Double.NaN;

	right=getValue(rightOperand);
	left=getValue(leftOperand);
	if(right==null)
	    return false;
	if(left==null)
	    return false;

	if (right != Double.NaN && left != Double.NaN) {
	    if (left < right)
		result = true;
	    else
		result = false;
	} else
	    return null;

	if (result == false)
	    communication.post(new CheckerShortNotificationEvent(this.userId,"( <B style=\"color:red\"> " + left + " NOT < " + right + "</B> )"));
	else
	    communication.post(new CheckerShortNotificationEvent(this.userId,"( <B style=\"color:green\"> " + left + " < " + right + "</B> )"));

	return result;
    }
}