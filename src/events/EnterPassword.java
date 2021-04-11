package events;

public class EnterPassword extends SecurityEvent {
	private static EnterPassword instance;

	private EnterPassword() {

	}

	public static EnterPassword instance() {
		if (instance == null) {
			instance = new EnterPassword();
		}
		return instance;
	}
}