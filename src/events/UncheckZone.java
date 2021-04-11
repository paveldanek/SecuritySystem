package events;

public class UncheckZone extends SecurityEvent {
	private static UncheckZone instance;

	private UncheckZone() {

	}

	public static UncheckZone instance() {
		if (instance == null) {
			instance = new UncheckZone();
		}
		return instance;
	}
}