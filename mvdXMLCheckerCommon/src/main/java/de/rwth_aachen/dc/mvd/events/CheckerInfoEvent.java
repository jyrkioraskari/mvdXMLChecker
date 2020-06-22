package de.rwth_aachen.dc.mvd.events;

public class CheckerInfoEvent {
    private final String topic;
    private final String value;
    public CheckerInfoEvent(String topic, String value) {
	super();
	this.topic = topic;
	this.value = value;
    }
    public String getTopic() {
        return topic;
    }
    public String getValue() {
        return value;
    }

    
}
