package states;

import events.PressAway;
import events.PressStay;
import events.UncheckZone;
import states.away.ArmedAway;
import timer.Notifiable;

public class Ready extends SecurityState implements Notifiable {
	private static Ready instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Ready() {
	}

	public static Ready instance() {
		if (instance == null) {
			instance = new Ready();
		}
		return instance;
	}

	@Override
	public void handleEvent(UncheckZone event) {

		SecurityContext.instance().changeState(NotReady.instance());
	}

	@Override
	public void handleEvent(PressAway event) {

		SecurityContext.instance().changeState(ArmedAway.instance());
	}

	public void handleEvent(PressStay event) {

	}

	@Override
	public void enter() {

		SecurityContext.instance().showReady();
	}

	@Override
	public void leave() {

	}
}
