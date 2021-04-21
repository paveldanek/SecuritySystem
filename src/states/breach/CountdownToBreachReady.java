package states.breach;

import events.EnterPassword;
import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;
import states.Countdown;
import states.Ready;
import states.SecurityContext;

public class CountdownToBreachReady extends Countdown {
	private static CountdownToBreachReady instance;

	/**
	* Private for the singleton pattern
	*/
	protected CountdownToBreachReady() {
		
	}

	/**
	* For singleton
	* 
	* @return the object
	*/
	public static CountdownToBreachReady instance() {
		if (instance == null) {
			instance = new CountdownToBreachReady();
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
		SecurityContext.instance().changeState(Ready.instance());
	}
	
	/**
	 * Processes the timer running out
	 */
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToStay(0);
		SecurityContext.instance().changeState(BreachReady.instance());
	}

	/**
	 * Processes the event of a zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		SecurityContext.instance().changeState(CountdownToBreachNotReady.instance());
		
	}
	
	@Override
	public void enter() {
		super.startTimer();
	}

	@Override
	public void leave() {
		super.leave();
	}
}
