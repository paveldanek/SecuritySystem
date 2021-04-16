package states.away;

import events.PressMotion;
import events.UncheckZone;
import states.SecurityContext;
import states.SecurityState;

public class ArmedAway extends SecurityState {
	private static ArmedAway instance;

	public static ArmedAway instance() {
		if (instance == null) {
			instance = new ArmedAway();
		}
		return instance;
	}

	/**
	 * Processes the motion button being pressed
	 */
	@Override
	public void handleEvent(PressMotion event) {

	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {

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
