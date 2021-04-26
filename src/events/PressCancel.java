package events;

/**
// * The class PressAway is invoked when the Cancel button is pressed.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class PressCancel extends SecurityEvent {
	private static PressCancel instance;

	private PressCancel() {

	}

	/**
	 * Creates a new instance of the PressCancel() object.
	 * @return instance    returns the instance of PressCancel
	 */
	public static PressCancel instance() {
		if (instance == null) {
			instance = new PressCancel();
		}
		return instance;
	}
}
