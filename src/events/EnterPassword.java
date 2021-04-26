package events;

/**
 * The class EnterPassword is invoked when the password is entered into the GUI.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class EnterPassword extends SecurityEvent {
	private static EnterPassword instance;

	private EnterPassword() {

	}

	/**
	 * Creates a new instance of the EnterPassword() object.
	 * @return instance    returns the instance of CheckAllZones
	 */
	public static EnterPassword instance() {
		if (instance == null) {
			instance = new EnterPassword();
		}
		return instance;
	}
}
