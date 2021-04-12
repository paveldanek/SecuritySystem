package events;

public class IncorrectPassword extends SecurityEvent {
	private static IncorrectPassword instance;

	private IncorrectPassword() {

	}

	public static IncorrectPassword instance() {
		if (instance == null) {
			instance = new IncorrectPassword();
		}
		return instance;
	}
}