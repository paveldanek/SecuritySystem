package states;

import events.CheckAllZones;
import timer.Notifiable;

public class NotReady extends SecurityState implements Notifiable {
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
		// TODO Auto-generated method stub

	}
}
