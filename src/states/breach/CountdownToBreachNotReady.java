package states.breach;

import events.CheckAllZones;
import events.EnterPassword;
import events.TimerRanOut;
import events.TimerTicked;
import states.Countdown;
import states.NotReady;
import states.SecurityContext;

public class CountdownToBreachNotReady extends Countdown {
	private static CountdownToBreachNotReady instance;

	/**
	 * Private for the singleton pattern
	 */
	protected CountdownToBreachNotReady() {

	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToBreachNotReady instance() {
		if (instance == null) {
			instance = new CountdownToBreachNotReady();
		}
		return instance;
	}

	public void handleEvent(TimerTicked event) {
		SecurityContext.instance().showSecondsToBreach(super.getTimeValue());
	}

	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {
		SecurityContext.instance().changeState(NotReady.instance());
	}

	/**
	 * Processes the timer running out
	 */
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToBreach(0);
		SecurityContext.instance().clearPassword();
		SecurityContext.instance().changeState(BreachNotReady.instance());
	}

	/**
	 * Processes the event of all zones being checked
	 */
	@Override
	public void handleEvent(CheckAllZones event) {
		CountdownToBreachReady.instance().setTimer(timer);
		SecurityContext.instance().changeState(CountdownToBreachReady.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showSecondsToBreach(timer.getTimeValue());

	}

	@Override
	public void leave() {
		super.leave();
	}
}
