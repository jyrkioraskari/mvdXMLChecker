package de.rwth_aachen.dc.mvd.events;

public class CheckerElementApplicabilityNotificationEvent extends SessionEvent{
	private final String value;

	public CheckerElementApplicabilityNotificationEvent(String userId, String value) {
		super(userId);
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
