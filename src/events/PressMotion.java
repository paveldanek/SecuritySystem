package events;

/**
 * The class PressMotion is invoked when the Motion Detector button is pressed.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class PressMotion extends SecurityEvent {
	private static PressMotion instance;

	private PressMotion() {

	}

	/**
	 * Creates a new instance of the PressMotion() object.
	 * 
	 * @return instance returns the instance of PressMotion
	 */
	public static PressMotion instance() {
		if (instance == null) {
			instance = new PressMotion();
		}
		return instance;
	}
}
