package states;

import events.PressAway;
import events.PressStay;
import events.UncheckZone;
import states.away.CountdownToAway;
import states.stay.CountdownToStay;
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

		CountdownToAway.instance().startTimer();
		SecurityContext.instance().changeState(CountdownToAway.instance());
	}

	public void handleEvent(PressStay event) {
		CountdownToStay.instance().startTimer();
		SecurityContext.instance().changeState(CountdownToStay.instance());
	}

	@Override
	public void enter() {

		SecurityContext.instance().showReady();
	}

	@Override
	public void leave() {
	}
}
