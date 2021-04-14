package states.away;

import events.CheckAllZones;
import events.TimerRanOut;
import states.Countdown;
import states.NotReady;
import states.SecurityContext;
import timer.Timer;

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
	 * Processes a timer tick, generates a Timer Ran Out event
	 */
	@Override
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToAway(0);
		SecurityContext.instance().changeState(NotReady.instance());
	}

	/**
	 * Processes all the zones being checked
	 */
	@Override
	public void handleEvent(CheckAllZones event) {

		SecurityContext.instance().changeState(CountdownToAway.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 10);
		SecurityContext.instance().showSecondsToAway(timer.getTimeValue());

	}

	@Override
	public void leave() {
		super.leave();
		SecurityContext.instance().showNotReady();
	}

}
