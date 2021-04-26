package states;

import events.CheckAllZones;

/**
 * Represents the Not Ready state of the Security System.
 * 
 */
public class NotReady extends SecurityState {
	private static NotReady instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private NotReady() {
	}

	public static NotReady instance() {
		if (instance == null) {
			instance = new NotReady();
		}
		return instance;
	}

	/**
	 * Processes all zones being checked event.
	 */
	@Override
	public void handleEvent(CheckAllZones event) {
		SecurityContext.instance().changeState(Ready.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showNotReady();
	}

	@Override
	public void leave() {
	}
}
