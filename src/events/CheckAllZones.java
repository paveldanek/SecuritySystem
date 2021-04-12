package events;

public class CheckAllZones extends SecurityEvent {
	private static CheckAllZones instance;

	private CheckAllZones() {

	}

	public static CheckAllZones instance() {
		if (instance == null) {
			instance = new CheckAllZones();
		}
		return instance;
	}
}