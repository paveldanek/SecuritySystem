package events;

/**
 * The class PressAway is invoked when the Away button is pressed.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class PressAway extends SecurityEvent {
	private static PressAway instance;

	private PressAway() {

	}

	/**
	 * Creates a new instance of the PressAway() object.
	 * @return instance    returns the instance of PressAway
	 */
	public static PressAway instance() {
		if (instance == null) {
			instance = new PressAway();
		}
		return instance;
	}
}
