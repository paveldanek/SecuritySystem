package events;

/**
 * The class IncorrectPassword is invoked when the incorrect password is entered into the GUI.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class IncorrectPassword extends SecurityEvent {
	private static IncorrectPassword instance;

	private IncorrectPassword() {

	}

	/**
	 * Creates a new instance of the IncorrectPassword() object.
	 * @return instance    returns the instance of IncorrectPassword
	 */
	public static IncorrectPassword instance() {
		if (instance == null) {
			instance = new IncorrectPassword();
		}
		return instance;
	}
}
