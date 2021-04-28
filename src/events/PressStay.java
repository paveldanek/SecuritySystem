package events;

/**
 * The class PressStay is invoked when the Stay button is pressed.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class PressStay extends SecurityEvent {
	private static PressStay instance;

	private PressStay() {

	}

	/**
	 * Creates a new instance of the PressStay() object.
	 * 
	 * @return instance returns the instance of PressStay
	 */
	public static PressStay instance() {
		if (instance == null) {
			instance = new PressStay();
		}
		return instance;
	}
}
