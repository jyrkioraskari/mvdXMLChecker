package de.rwth_aachen.dc.mvd.events;

public class SessionEvent {
	private final String userId;

	public SessionEvent(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
	
}
