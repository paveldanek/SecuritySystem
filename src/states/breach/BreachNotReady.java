package states.breach;

import events.CheckAllZones;
import events.EnterPassword;
import states.NotReady;
import states.SecurityContext;
import states.SecurityState;

public class BreachNotReady extends SecurityState {
	private static BreachNotReady instance;

	private BreachNotReady() {

	}

	public static BreachNotReady instance() {
		if (instance == null) {
			instance = new BreachNotReady();
		}
		return instance;
	}

	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {
		SecurityContext.instance().changeState(NotReady.instance());
	}

	/**
	 * Processes the event of all zones being checked
	 */
	@Override
	public void handleEvent(CheckAllZones event) {
		SecurityContext.instance().changeState(BreachReady.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showBreach();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}
