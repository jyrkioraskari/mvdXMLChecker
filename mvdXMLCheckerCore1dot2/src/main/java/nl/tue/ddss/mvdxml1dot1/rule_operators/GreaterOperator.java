package nl.tue.ddss.mvdxml1dot1.rule_operators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.bimserver.emf.IdEObject;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

//rewritten by JO 2020

public class GreaterOperator extends AbstractComparatorOperator {

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
		if (rightOperand == null)
			return false;
		if (leftOperand == null)
			return false;

		if (rightOperand instanceof String && leftOperand instanceof String
				&& (((String) rightOperand).contains(":") || ((String) leftOperand).contains(":"))) {

			try {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date lefttime = sdf.parse((String) leftOperand);
				left = (double) lefttime.getTime();
			} catch (ParseException e0) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					Date lefttime = sdf.parse((String) leftOperand);
					left = (double) lefttime.getTime();
				} catch (ParseException e1) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("HH");
						Date lefttime = sdf.parse((String) leftOperand);
						left = (double) lefttime.getTime();
					} catch (ParseException e2) {

					}
				}
			}
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Date righttime = sdf.parse((String) rightOperand);
				right = (double) righttime.getTime();
			} catch (ParseException e0) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					Date righttime = sdf.parse((String) rightOperand);
					right = (double) righttime.getTime();
				} catch (ParseException e1) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("HH");
						Date righttime = sdf.parse((String) rightOperand);
						right = (double) righttime.getTime();
					} catch (ParseException e2) {

					}
				}
			}

		}
		if (Double.isNaN(left) || Double.isNaN(right)) {
			left = getValue(leftOperand);
			right = getValue(rightOperand);
		}
		if (right == null)
			return false;
		if (left == null)
			return false;

		if (right != Double.NaN && left != Double.NaN) {
			if (left > right)
				result = true;
			else
				result = false;
		} else {
			communication.post(new CheckerShortNotificationEvent(
					this.userId,"( <B style=\"color:red\"> " + leftOperand + " NOT > " + rightOperand + "</B> )"));
			return false;
		}

		if (result == false) {
			System.out.println("Greater " + leftOperand + " NOT > " + rightOperand + " left: " + left + " right: "
					+ right + " left type: " + leftOperand.getClass().getName() + " right type: "
					+ rightOperand.getClass().getName());
			communication.post(new CheckerShortNotificationEvent(
					this.userId,"( <B style=\"color:red\"> " + leftOperand + " NOT > " + rightOperand + "</B> )"));
		} else {
			System.out.println("Greater " + leftOperand + "  > " + rightOperand);
			communication.post(new CheckerShortNotificationEvent(
					this.userId,"( <B style=\"color:green\"> " + leftOperand + " > " + rightOperand + "</B> )"));
		}

		// System.out.println("was greater");
		return result;
	}
}