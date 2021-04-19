package states.away;

import events.EnterPassword;
import events.IncorrectPassword;
import events.PressMotion;
import events.UncheckZone;
import states.Ready;
import states.SecurityContext;
import states.SecurityState;
import states.breach.Breach;

public class CancelAway extends SecurityState {
	private static CancelAway instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CancelAway() {
	}

	public static CancelAway instance() {
		if (instance == null) {
			instance = new CancelAway();
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
		SecurityContext.instance().changeState(Breach.instance());
	}

	/**
	 * Processes the motion button being pressed
	 */
	@Override
	public void handleEvent(PressMotion event) {
		// using armed away explicitly, plan to talk about this
		ArmedAway.instance().handleEvent(event);
	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		// using armed away explicitly, plan to talk about this
		ArmedAway.instance().handleEvent(event);
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
