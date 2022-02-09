package de.rwth_aachen.dc.mvd.events;

public class CheckerParserInfoEvent extends SessionEvent{
    private final String topic;
    private final String value;
    public CheckerParserInfoEvent(String userId, String topic, String value) {
	super(userId);
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
