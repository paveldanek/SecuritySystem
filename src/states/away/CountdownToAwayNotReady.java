package states.away;

import events.CheckAllZones;
import events.TimerRanOut;
import events.TimerTicked;
import states.Countdown;
import states.NotReady;
import states.SecurityContext;

public class CountdownToAwayNotReady extends Countdown {

	private static CountdownToAwayNotReady instance;

	/**
	 * Private for the singleton pattern
	 */
	private CountdownToAwayNotReady() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToAwayNotReady instance() {
		if (instance == null) {
			instance = new CountdownToAwayNotReady();
		}
		return instance;
	}

	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	@Override
	public void handleEvent(TimerTicked event) {

		SecurityContext.instance().showSecondsToNotReady(timer.getTimeValue());
	}

	/**
	 * Processes a timer tick, generates a Timer Ran Out event
	 */
	@Override
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToNotReady(0);
		SecurityContext.instance().showNotReady();
		SecurityContext.instance().changeState(NotReady.instance());
	}

	/**
	 * Processes all the zones being checked
	 */
	@Override
	public void handleEvent(CheckAllZones event) {

		CountdownToAway.instance().setTimer(timer);
		SecurityContext.instance().changeState(CountdownToAway.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showSecondsToNotReady(timer.getTimeValue());
	}

	@Override
	public void leave() {

		super.leave();
	}

}
