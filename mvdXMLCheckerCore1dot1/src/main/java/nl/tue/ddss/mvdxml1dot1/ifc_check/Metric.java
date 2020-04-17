package nl.tue.ddss.mvdxml1dot1.ifc_check;

import java.util.Collection;

public class Metric {

    Object value;
    Integer metricSize;
    Object metricValue;
    Object metricType;
    Boolean metricUnique;

    public Metric(Object value) {
	this.value = value;
    }

    @SuppressWarnings("rawtypes")
    public Integer getMetricSize() {
	if (value == null) {
	    metricSize = 0;
	} else if (value instanceof Collection) {
	    metricSize = ((Collection) value).size();
	} else {
	    metricSize = 1;
	}
	return metricSize;
    }

    public Object getMetricType() {
	metricType = value;
	return metricType;
    }

    public Object getMetricValue() {
	if (value instanceof String || value instanceof Double || value instanceof Integer || value instanceof Boolean) {
	    metricValue = value;
	} else {
	    metricValue = null;
	}
	return metricValue;
    }

}