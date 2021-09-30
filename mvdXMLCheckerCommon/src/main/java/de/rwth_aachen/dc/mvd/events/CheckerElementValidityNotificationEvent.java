package de.rwth_aachen.dc.mvd.events;

public class CheckerElementValidityNotificationEvent {
    private final String value;
    public CheckerElementValidityNotificationEvent(String value) {
	super();
	this.value = value;
    }
    public String getValue() {
        return value;
    }

    
}
