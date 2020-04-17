package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

public class TemplateParameter {
	private String parameter;
	private String value;

	public String getParameter() {
	    return parameter;
	}

	public void setParameter(String parameter) {
	    this.parameter = parameter;
	}

	public String getValue() {
	    return value;
	}

	public void setValue(String value) {
	    this.value = value;
	}

	public TemplateParameter(String parameter, String value) {
	    this.parameter = parameter;
	    this.value = value;
	}
}
