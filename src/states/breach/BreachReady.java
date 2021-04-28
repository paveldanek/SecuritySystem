package states.breach;

import events.EnterPassword;
import events.UncheckZone;
import states.Ready;
import states.SecurityContext;
import states.SecurityState;

/**
 * Represents the Breach state while zones are ready
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */

public class BreachReady extends SecurityState {
	private static BreachReady instance;

	private BreachReady() {

	}

	public static BreachReady instance() {
		if (instance == null) {
			instance = new BreachReady();
		}
		return instance;
	}

	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {
		SecurityContext.instance().changeState(Ready.instance());
	}

	/**
	 * Processes the event of all zones being checked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		SecurityContext.instance().changeState(BreachNotReady.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showBreach();

	}

	@Override
	public void leave() {

	}
}
