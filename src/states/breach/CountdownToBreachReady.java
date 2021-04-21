package states.breach;

import events.EnterPassword;
import events.TimerRanOut;
import events.TimerTicked;
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
		SecurityContext.instance().showSecondsToBreach(timer.getTimeValue());
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
		SecurityContext.instance().changeState(BreachReady.instance());
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
