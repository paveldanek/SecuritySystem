package states;

import timer.Notifiable;
import timer.Timer;

/**
 * Represents the Countdown state that acts as a super clas to all countdown
 * states
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class Countdown extends SecurityState implements Notifiable {
	private static Countdown instance;
	protected Timer timer;

	/**
	 * Protected for the singleton pattern of subclasses
	 */
	protected Countdown() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static Countdown instance() {
		if (instance == null) {
			instance = new Countdown();
		}
		return instance;
	}

	/**
	 * Creates a new timer object and assigns it to the current class 'timer'
	 * reference
	 */
	public void startTimer(int time) {
		timer = new Timer(this, time);
	}

	/**
	 * Creates a new timer object with the same time value as the parameter 'timer'
	 * object and assigns it to the current class 'timer' reference
	 * 
	 * @param timer of type Timer
	 */
	public void setTimer(Timer timer) {
		this.timer = new Timer(this, timer.getTimeValue());
	}

	/**
	 * Returns the time value of the current class 'timer' reference
	 * 
	 * @return the time value as an integer
	 */
	public int getTimeValue() {
		return timer.getTimeValue();
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
