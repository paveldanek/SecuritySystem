package states.stay;

import events.EnterPassword;
import events.IncorrectPassword;
import events.UncheckZone;
import states.Ready;
import states.SecurityContext;
import states.SecurityState;
import states.breach.BreachReady;

public class CancelStay extends SecurityState {
	private static CancelStay instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CancelStay() {
	}

	public static CancelStay instance() {
		if (instance == null) {
			instance = new CancelStay();
		}
		return instance;
	}

	/**
	 * Processes password correct event
	 */
	@Override
	public void handleEvent(EnterPassword event) {
		SecurityContext.instance().changeState(Ready.instance());
	}

	/**
	 * Processes password incorrect event
	 */
	@Override
	public void handleEvent(IncorrectPassword event) {
		SecurityContext.instance().changeState(BreachReady.instance());
	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		// not using armedstay class
		// SecurityContext.instance().changeState(Breach.instance());

		// using armed away explicitly, plan to talk about this
		ArmedStay.instance().handleEvent(event);
	}

	@Override
	public void enter() {
		SecurityContext.instance().showCancel();
		SecurityContext.instance().clearPassword();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

}
