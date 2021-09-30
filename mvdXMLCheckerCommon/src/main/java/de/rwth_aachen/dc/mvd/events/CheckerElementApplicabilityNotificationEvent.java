package de.rwth_aachen.dc.mvd.events;

public class CheckerElementApplicabilityNotificationEvent {
    private final String value;
    public CheckerElementApplicabilityNotificationEvent(String value) {
	super();
	this.value = value;
    }
    public String getValue() {
        return value;
    }

    
}
