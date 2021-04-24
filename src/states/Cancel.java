package states;

import events.DigitPressed;
import events.EnterPassword;
import events.IncorrectPassword;
import events.UncheckZone;
import states.breach.BreachNotReady;
import states.breach.BreachReady;

public class Cancel extends SecurityState {
	private static Cancel instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Cancel() {
	}

	public static Cancel instance() {
		if (instance == null) {
			instance = new Cancel();
		}
		return instance;
	}

	/**
	 * Processes a digit press
	 */
	@Override
	public void handleEvent(DigitPressed event) {
		SecurityContext.instance().showPassword();
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
		SecurityContext.instance().changeState(BreachNotReady.instance());

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
