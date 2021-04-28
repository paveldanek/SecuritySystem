package states;

import events.DigitPressed;
import events.EnterPassword;
import events.IncorrectPassword;
import events.PressCancel;
import events.UncheckZone;
import states.breach.BreachNotReady;
import states.breach.BreachReady;

/**
 * Represents the cancel state
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
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
		SecurityContext.instance().clearPassword();
		SecurityContext.instance().changeState(BreachNotReady.instance());

	}

	/**
	 * Processes cancel button press
	 */
	@Override
	public void handleEvent(PressCancel event) {
		SecurityContext.instance().clearPassword();
		SecurityContext.instance().showCancel();
	}

	@Override
	public void enter() {
		SecurityContext.instance().showCancel();
		SecurityContext.instance().clearPassword();
	}

	@Override
	public void leave() {

	}

}
