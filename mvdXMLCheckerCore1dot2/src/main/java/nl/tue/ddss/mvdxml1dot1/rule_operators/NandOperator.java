package nl.tue.ddss.mvdxml1dot1.rule_operators;

import de.rwth_aachen.dc.mvd.events.CheckerShortNotificationEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;

// JO 2020

public class NandOperator {
    private EventBusCommunication communication = EventBusCommunication.getInstance();

	// fields
	private Boolean leftOperand;
	private Boolean rightOperand;
		
	// constructors
	public NandOperator() {	
	}
	
	public NandOperator(Boolean leftOperand, Boolean rightOperand){
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	// methods
	public Boolean getLeftOperand() {
		return leftOperand;
	}

	public void setLeftOperand(Boolean leftOperand) {
		this.leftOperand = leftOperand;
	}

	public Boolean getRightOperand() {
		return rightOperand;
	}

	public void setRightOperand(Boolean rightOperand) {
		this.rightOperand = rightOperand;
	}
	
	public Boolean getResult() {
		return !(leftOperand && rightOperand);
	}
}
