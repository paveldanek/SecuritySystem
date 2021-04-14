package states.away;

import events.TimerRanOut;
import events.UncheckZone;
import states.Countdown;
import states.SecurityContext;
import timer.Timer;

public class CountdownToAway extends Countdown {
	private static CountdownToAway instance;

	/**
	 * Private for the singleton pattern
	 */
	private CountdownToAway() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToAway instance() {
		if (instance == null) {
			instance = new CountdownToAway();
		}
		return instance;
	}

	/**
	 * Processes a timer tick, generates a Timer Ran Out event
	 */
	@Override
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToAway(0);
		SecurityContext.instance().changeState(ArmedAway.instance());
	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {

		SecurityContext.instance().changeState(CountdownToAwayNotReady.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		SecurityContext.instance().showSecondsToAway(timer.getTimeValue());

	}

	@Override
	public void leave() {
		super.leave();
		SecurityContext.instance().showAway();
	}
}
