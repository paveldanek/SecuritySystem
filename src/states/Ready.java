package states;

import events.PressAway;
import events.PressStay;
import events.UncheckZone;
import states.away.CountdownToAwayReady;
import states.stay.CountdownToStayReady;
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

		CountdownToAwayReady.instance().startTimer();
		SecurityContext.instance().changeState(CountdownToAwayReady.instance());
	}

	public void handleEvent(PressStay event) {
		CountdownToStayReady.instance().startTimer();
		SecurityContext.instance().changeState(CountdownToStayReady.instance());
	}

	@Override
	public void enter() {

		SecurityContext.instance().showReady();
	}

	@Override
	public void leave() {
	}
}
