package events;

public class TimerRanOut extends SecurityEvent {
	private static TimerRanOut timerRanOut;

	/**
	 * A singleton representing the event Timer Ran Out.
	 * 
	 * @param value the amount of time left
	 */
	private TimerRanOut() {

	}

	public static TimerRanOut instance() {
		if (timerRanOut == null) {
			timerRanOut = new TimerRanOut();
		}
		return timerRanOut;
	}
}
