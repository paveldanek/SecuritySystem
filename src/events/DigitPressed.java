package events;

/**
 * The class DigitPressed is invoked when a digit is pressed on the GUI.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class DigitPressed extends SecurityEvent {
	private static DigitPressed instance;
	private String digit = "";

	private DigitPressed() {

	}

	/**
	 * Creates a new instance of the DigitPressed() object.
	 * @return instance   returns the instance of DigitPressed
	 */
	public static DigitPressed instance() {
		if (instance == null) {
			instance = new DigitPressed();
		}
		return instance;
	}

	/**
	 * addDigit assigns the given String argument to the String object digit.
	 * @param digit   a String object corresponding to the digit added
	 */
	public void addDigit(String digit) {
		this.digit = digit;
	}

	public String getDigit() {
		return this.digit;
	}
}
