package events;

public class DigitPressed extends SecurityEvent {
	private static DigitPressed instance;
	private String digit = "";

	private DigitPressed() {

	}

	public static DigitPressed instance() {
		if (instance == null) {
			instance = new DigitPressed();
		}
		return instance;
	}

	public void addDigit(String digit) {
		this.digit = digit;
	}

	public String getDigit() {
		return this.digit;
	}
}