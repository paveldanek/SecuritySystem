package events;

public class TimerUp extends SecurityEvent {
	private static TimerUp timerRanOut;

	/**
	 * A singleton representing the event Timer Ran Out.
	 * 
	 * @param value the amount of time left
	 */
	private TimerUp() {

	}

	public static TimerUp instance() {
		if (timerRanOut == null) {
			timerRanOut = new TimerUp();
		}
		return timerRanOut;
	}
}
