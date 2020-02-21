package nl.tue.ddss.rule_parse;


import java.util.Collection;


import org.bimserver.emf.IdEObject;

public class LessEqualOperator {
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
		Boolean result = new Boolean(true);
		if (rightOperand instanceof String) {
			System.out.println("To be later supported");
			result = false;
		} else if (rightOperand instanceof Double) {
			if (leftOperand instanceof Double) {
				if ((Double)leftOperand<=(Double)rightOperand)
					result = true;
				else
					result = false;
			} else if (leftOperand instanceof Integer) {
				int left=((Integer)leftOperand).intValue();
				Double doub=new Double(left);
				if (doub<=(Double)rightOperand)
					result = true;
				else
					result = false;
			}
		} else if (rightOperand instanceof IdEObject) {
			System.out.println("To be later supported");
			result = false;
		} else if (rightOperand instanceof Collection) {
			System.out.println("To be later supported");
			result = false;
		}
		return result;
	}
}