package events;

/**
 * The class UncheckZone is invoked when a zone is unchecked.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class UncheckZone extends SecurityEvent {
	private static UncheckZone instance;

	/**
	 * A singleton representing the event UnCheckZone.
	 * 
	 */
	private UncheckZone() {

	}

	/**
	 * Creates a new instance of the UncheckZone() object.
	 * 
	 * @return instance returns the instance of PressStay
	 */
	public static UncheckZone instance() {
		if (instance == null) {
			instance = new UncheckZone();
		}
		return instance;
	}
}
