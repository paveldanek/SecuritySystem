package events;

/**
 * The class TimerTicked is invoked when the Timer ticks.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class TimerTicked extends SecurityEvent {
	private int timeLeft;

	/**
	 * Stores the amount of time left in the Timer.
	 * 
	 * @param value the amount of time left
	 */
	public TimerTicked(int value) {
		timeLeft = value;
	}

	/**
	 * Needed for display purposes
	 */
	public int getTimeLeft() {
		return timeLeft;
	}
}
