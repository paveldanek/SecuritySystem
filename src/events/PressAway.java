package events;

public class PressAway extends SecurityEvent {
	private static PressAway instance;

	private PressAway() {

	}

	public static PressAway instance() {
		if (instance == null) {
			instance = new PressAway();
		}
		return instance;
	}
}
