package states.breach;

import events.EnterPassword;
import events.TimerRanOut;
import events.TimerTicked;
import states.Countdown;
import states.Ready;
import states.SecurityContext;
import timer.Timer;

public class CountdownToBreach extends Countdown {
	private static CountdownToBreach instance;
	protected Timer timer;

	/**
	* Private for the singleton pattern
	*/
	protected CountdownToBreach() {
		this.enter();
	}

	/**
	* For singleton
	* 
	* @return the object
	*/
	public static CountdownToBreach instance() {
		if (instance == null) {
			instance = new CountdownToBreach();
		}
		return instance;
	}

	public void startTimer() {
		timer = new Timer(this, 10);
	}

	public void setTimer(Timer timer) {
		this.timer = new Timer(this, timer.getTimeValue());
	}

	public int getTimeValue() {
		return timer.getTimeValue();
	}
	
	public void handleEvent(TimerTicked event) {
		SecurityContext.instance().showSecondsToBreach(timer.getTimeValue());
	}
	
	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {
		SecurityContext.instance().changeState(Ready.instance());
		this.leave();
	}
	
	/**
	 * Processes the timer running out
	 */
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().changeState(Breach.instance());
	}

	@Override
	public void enter() {
		this.startTimer();
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}
}
