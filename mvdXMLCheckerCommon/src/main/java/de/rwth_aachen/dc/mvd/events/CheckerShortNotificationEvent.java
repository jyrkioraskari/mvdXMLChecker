package de.rwth_aachen.dc.mvd.events;

public class CheckerShortNotificationEvent {
    private final String value;
    public CheckerShortNotificationEvent(String value) {
	super();
	this.value = value;
    }
    public String getValue() {
        return value;
    }

    
}
