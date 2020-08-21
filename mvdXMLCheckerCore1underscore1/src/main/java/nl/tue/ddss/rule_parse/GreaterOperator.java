package nl.tue.ddss.rule_parse;

import java.util.Collection;

import org.bimserver.emf.IdEObject;

//rewritten by JO 2020

public class GreaterOperator {
    // fields
    private Object leftOperand;
    private Object rightOperand;

    // constructors
    public GreaterOperator() {
    }

    public GreaterOperator(Object leftOperand, Object rightOperand) {
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
		right = Double.parseDouble((String) rightOperand);
	    } catch (Exception e) {
	    }
	}
	if (rightOperand instanceof Double)
	    right = (Double) rightOperand;
	if (rightOperand instanceof Integer)
	    right = (Double) rightOperand;

	if (rightOperand instanceof Collection)
	    System.out.println("To be later supported");
	if (rightOperand instanceof IdEObject)
	    System.out.println("To be later supported");

	
	if (leftOperand instanceof String) {
	    try {
		left = Double.parseDouble((String) leftOperand);
	    } catch (Exception e) {
	    }
	}
	if (leftOperand instanceof Double)
	    left = (Double) leftOperand;
	if (leftOperand instanceof Integer)
	    left = (Double) leftOperand;

	if (leftOperand instanceof Collection)
	    System.out.println("To be later supported");
	if (leftOperand instanceof IdEObject)
	    System.out.println("To be later supported");

	if (right != Double.NaN && left != Double.NaN)
	    if (left > right)
		result = true;
	    else
		result = false;
	return result;
    }
}