package nl.tue.ddss.rule_parse;

import java.util.Collection;

import org.bimserver.emf.IdEObject;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

//rewritten by JO 2020

public class GreaterOperator extends AbstractComparatorOperator{

    // fields
    private Object leftOperand;
    private Object rightOperand;

    // constructors
 	public GreaterOperator(String userId) {
 		super(userId);
 	}

 	public GreaterOperator(String userId,Object leftOperand, Object rightOperand) {
 		super(userId);
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
	Double right = Double.NaN;
	Double left = Double.NaN;

	right=getValue(rightOperand);
	left=getValue(leftOperand);
	if(right==null)
	    return false;
	if(left==null)
	    return false;

	if (!Double.isNaN(right) && !Double.isNaN(left)) 
	{
	    if (left > right)
		result = true;
	    else
		result = false;
	}
	else 
	{
	    communication.post(new CheckerShortNotificationEvent(this.userId,"( <B style=\"color:red\"> "+leftOperand+ " NOT > " + rightOperand+"</B> )"));
	    return false;
        }
	
	
	if(result==false)
		communication.post(new CheckerShortNotificationEvent(this.userId,"( <B style=\"color:red\"> "+left+ " NOT > " + right+"</B> )"));
	else
		communication.post(new CheckerShortNotificationEvent(this.userId,"( <B style=\"color:green\"> "+left+ " > " + right+"</B> )"));

	//System.out.println("was greater");
	return result;
    }
}