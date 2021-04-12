package events;

public class PressMotion extends SecurityEvent {
	private static PressMotion instance;

	private PressMotion() {

	}

	public static PressMotion instance() {
		if (instance == null) {
			instance = new PressMotion();
		}
		return instance;
	}
}