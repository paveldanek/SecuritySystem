package zones;

/**
 * Represents a single zone in the Security System.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class Zone {

	private boolean checked;

	/**
	 * The constructor initiates the zone as checked.
	 */
	public Zone() {
		checked = true;
	}

	/**
	 * Returns the state of the zone.
	 * 
	 * @return TRUE - if zone is checked FALSE - if zone is unchecked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * Toggles the zone between checked and unchecked states.
	 */
	public void toggle() {
		checked = !checked;
	}
}
