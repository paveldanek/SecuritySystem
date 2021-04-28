package events;

/**
 * The class ZoneToggled is invoked when a zone is toggled.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class ZoneToggled extends SecurityEvent {
	private static ZoneToggled instance;
	private int zoneNumber = 0;

	/**
	 * A singleton representing the event ZoneToggled.
	 * 
	 * @param value the amount of time left
	 */
	private ZoneToggled() {

	}

	/**
	 * Creates a new instance of the zoneToggled() object.
	 * 
	 * @return instance returns the instance of zoneToggled
	 */
	public static ZoneToggled instance() {
		if (instance == null) {
			instance = new ZoneToggled();
		}
		return instance;
	}

	public int getZoneNumber() {
		return this.zoneNumber;
	}

	public void setZoneNumber(int zoneNumber) {
		this.zoneNumber = zoneNumber;
	}

}
