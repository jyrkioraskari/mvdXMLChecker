package de.rwth_aachen.dc.mvd.events;

public class CheckerIssueEvent {
    private final String topic;
    private final String value;
    public CheckerIssueEvent(String topic, String value) {
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
