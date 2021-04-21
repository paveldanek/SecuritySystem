package states.away;

import events.PressMotion;
import events.UncheckZone;
import states.SecurityContext;
import states.SecurityState;
import states.breach.CountdownToBreachNotReady;
import states.breach.CountdownToBreachReady;

public class ArmedAway extends SecurityState {
	private static ArmedAway instance;

	public static ArmedAway instance() {
		if (instance == null) {
			instance = new ArmedAway();
		}
		return instance;
	}

	/**
	 * Processes the motion button being pressed. In AramedAwayState, this will
	 * trigger a countdown to a breach state.
	 */
	@Override
	public void handleEvent(PressMotion event) {
		SecurityContext.instance().changeState(CountdownToBreachReady.instance());
	}

	/**
	 * Processes one zone being unchecked. In AramedAwayState, this will trigger a
	 * countdown to a breach state.
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		SecurityContext.instance().changeState(CountdownToBreachNotReady.instance());
	}

	/**
	 * initialize the state
	 * 
	 */
	@Override
	public void enter() {
		SecurityContext.instance().showAway();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}
