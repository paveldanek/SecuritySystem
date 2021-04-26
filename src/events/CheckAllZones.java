package events;

/**
 * The class CheckAllZones is invoked when all zones become checked.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class CheckAllZones extends SecurityEvent {
	private static CheckAllZones instance;

	private CheckAllZones() {

	}

	/**
	 * Creates a new instance of the CheckAllZones() object.
	 * @return instance    returns the instance of CheckAllZones
	 */
	public static CheckAllZones instance() {
		if (instance == null) {
			instance = new CheckAllZones();
		}
		return instance;
	}
}
