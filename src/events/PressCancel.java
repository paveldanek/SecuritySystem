package events;

public class PressCancel extends SecurityEvent {
	private static PressCancel instance;

	private PressCancel() {

	}

	public static PressCancel instance() {
		if (instance == null) {
			instance = new PressCancel();
		}
		return instance;
	}
}