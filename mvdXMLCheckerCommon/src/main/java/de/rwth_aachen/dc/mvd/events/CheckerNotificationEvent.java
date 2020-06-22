package de.rwth_aachen.dc.mvd.events;

public class CheckerNotificationEvent {
    private final String value;
    public CheckerNotificationEvent(String value) {
	super();
	this.value = value;
    }
    public String getValue() {
        return value;
    }

    
}
