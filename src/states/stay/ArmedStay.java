package states.stay;

import events.PressCancel;
import events.UncheckZone;
import states.Cancel;
import states.SecurityContext;
import states.SecurityState;
import states.breach.BreachNotReady;

public class ArmedStay extends SecurityState {
	private static ArmedStay instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ArmedStay() {
	}

	public static ArmedStay instance() {
		if (instance == null) {
			instance = new ArmedStay();
		}
		return instance;
	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		SecurityContext.instance().changeState(BreachNotReady.instance());
	}

	/**
	 * Processes cancel button pressed event
	 */
	@Override
	public void handleEvent(PressCancel event) {
		SecurityContext.instance().changeState(Cancel.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showStay();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}
