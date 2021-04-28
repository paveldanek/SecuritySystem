package states.stay;

import events.CheckAllZones;
import events.TimerRanOut;
import events.TimerTicked;
import states.Countdown;
import states.NotReady;
import states.SecurityContext;

/**
 * Represents the Count down to Stay state of the Security System, while some
 * zones are unchecked.
 *
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class CountdownToStayNotReady extends Countdown {
	private static CountdownToStayNotReady instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CountdownToStayNotReady() {
	}

	public static CountdownToStayNotReady instance() {
		if (instance == null) {
			instance = new CountdownToStayNotReady();
		}
		return instance;
	}

	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	@Override
	public void handleEvent(TimerTicked event) {
		SecurityContext.instance().showSecondsToStay(timer.getTimeValue());
	}

	/**
	 * Processes a timer tick, generates a Timer Ran Out event
	 */
	@Override
	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToStay(0);
		SecurityContext.instance().changeState(NotReady.instance());
	}

	/**
	 * Processes all the zones being checked
	 */
	@Override
	public void handleEvent(CheckAllZones event) {
		CountdownToStayReady.instance().setTimer(timer);
		SecurityContext.instance().changeState(CountdownToStayReady.instance());
	}

	@Override
	public void enter() {

		SecurityContext.instance().showSecondsToStay(timer.getTimeValue());
	}

	@Override
	public void leave() {
		super.leave();
	}

}
