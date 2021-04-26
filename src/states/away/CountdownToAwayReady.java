package states.away;

import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;
import states.Countdown;
import states.SecurityContext;

/**
 * Represents the countdown to away state while zones are ready
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class CountdownToAwayReady extends Countdown {
	private static CountdownToAwayReady instance;

	/**
	 * Private for the singleton pattern
	 */
	private CountdownToAwayReady() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToAwayReady instance() {
		if (instance == null) {
			instance = new CountdownToAwayReady();
		}
		return instance;
	}

	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	@Override
	public void handleEvent(TimerTicked event) {

		SecurityContext.instance().showSecondsToAway(timer.getTimeValue());
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

		CountdownToAwayNotReady.instance().setTimer(timer);
		SecurityContext.instance().changeState(CountdownToAwayNotReady.instance());
	}

	@Override
	public void enter() {

		SecurityContext.instance().showSecondsToAway(timer.getTimeValue());
	}

	@Override
	public void leave() {

		super.leave();
	}
}
