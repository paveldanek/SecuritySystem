package events;

public class ChangeTextTo extends SecurityEvent {
	private static ChangeTextTo instance;

	private ChangeTextTo() {

	}

	public static ChangeTextTo instance() {
		if (instance == null) {
			instance = new ChangeTextTo();
		}
		return instance;
	}

	public void display(String digit) {
		this.digit = digit;
	}

}
