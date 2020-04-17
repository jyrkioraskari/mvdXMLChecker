package nl.tue.ddss.mvdxml1dot1.rule_parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bimserver.emf.IdEObject;

public class EqualOperator {
	// fields
	private Object leftOperand;
	private Object rightOperand;

	// constructors
	public EqualOperator() {
	}

	public EqualOperator(Object leftOperand, Object rightOperand) {
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
		if(leftOperand==null){
			return false;
		}
		if (rightOperand instanceof String) {
			if (((String) rightOperand).startsWith("reg")){
				String reg = ((String) rightOperand);
				if (leftOperand instanceof String) {
					if (((String)leftOperand).matches(reg.substring(4).replace("\\\\", "\\"))){
						result = true;
					} else {
						result = false;
					}
				} else
					result = false;
			} else {
				if (leftOperand instanceof String) {
					if (leftOperand.equals(rightOperand)) {
						result = true;
					} else {
						result = false;
					}
				} else if (leftOperand instanceof IdEObject) {
					String typeName = leftOperand.getClass().getSimpleName();
					typeName = typeName.substring(0, typeName.length() - 4);
					if (typeName.equals(rightOperand)) {
						result = true;
					} else {
						result = false;
					}
				} else if (leftOperand instanceof Collection) {
					List<Object> valueList = new ArrayList<Object>();
					valueList.addAll((Collection<?>) leftOperand);
					for (int i = 0; i < valueList.size(); i++) {
						if (valueList.get(i) instanceof String) {
							if (valueList.get(i).equals(rightOperand)) {
								result = true;
								break;
							}
							if (!valueList.get(i).equals(rightOperand)
									&& i == valueList.size() - 1) {
								result = false;
							}
						} else if (valueList.get(i) instanceof IdEObject) {
							String typeName = valueList.get(i).getClass()
									.getSimpleName();
							typeName = typeName.substring(0,
									typeName.length() - 4);
							if (typeName.equals(rightOperand)) {
								result = true;
								break;
							}
							if (!typeName.equals(rightOperand)
									&& i == valueList.size() - 1) {
								result = false;
							}
						} else
							result = false;
					}
				} else {
					result = false;
				}
			}
		} else if (rightOperand instanceof Double) {
			if (leftOperand instanceof Double) {
				if (leftOperand.equals(rightOperand))
					result = true;
				else
					result = false;
			} else if (leftOperand instanceof Integer) {
				int left=((Integer)leftOperand).intValue();
				Double doub=new Double(left);
				if (doub.equals(rightOperand))
					result = true;
				else
					result = false;
			}
		} else if (rightOperand instanceof IdEObject) {
			if (leftOperand instanceof IdEObject) {
				String typeName = leftOperand.getClass().getSimpleName();
				typeName = typeName.substring(0, typeName.length() - 4);
				result=leftOperand.getClass().equals(rightOperand.getClass());
			}
			else
			System.out.println("To be later supported");
			result = false;
		} else if (rightOperand instanceof Collection) {
			System.out.println("To be later supported");
			result = false;
		}else if (rightOperand instanceof Boolean){
			if (leftOperand instanceof Boolean){
				result=leftOperand.equals(rightOperand);
			}
			else result=false;
		}
		return result;
	}
}