package de.rwth_aachen.dc.mvd.events;

public class CheckerElementValidityNotificationEvent extends SessionEvent{
	private final String value;

	public CheckerElementValidityNotificationEvent(String userId, String value) {
		super(userId);
		this.value = value;
	}

	public String getValue() {
		return value;
	}


}
