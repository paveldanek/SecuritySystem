package events;

public class PressStay extends SecurityEvent {
	private static PressStay instance;

	private PressStay() {

	}

	public static PressStay instance() {
		if (instance == null) {
			instance = new PressStay();
		}
		return instance;
	}
}