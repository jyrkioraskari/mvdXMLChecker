package de.rwth_aachen.dc.mvd.events;

public class CheckerNotificationEvent extends SessionEvent{
    private final String value;
    public CheckerNotificationEvent(String userId, String value) {
	super(userId);
	this.value = value;
    }
    public String getValue() {
        return value;
    }
    
}
