package de.rwth_aachen.dc.mvd.events;

public class CheckerShortNotificationEvent extends SessionEvent{
    private final String value;
    public CheckerShortNotificationEvent(String userId,String value) {
	super(userId);
	this.value = value;
    }
    public String getValue() {
        return value;
    }

    
}
