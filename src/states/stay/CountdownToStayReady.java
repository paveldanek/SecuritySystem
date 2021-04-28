package states.stay;

import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;
import states.Countdown;
import states.SecurityContext;

/**
 * Represents the Count down to Stay state of the Security System, while all
 * zones are checked.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 * 
 */
public class CountdownToStayReady extends Countdown {
	private static CountdownToStayReady instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CountdownToStayReady() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToStayReady instance() {
		if (instance == null) {
			instance = new CountdownToStayReady();
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
		SecurityContext.instance().changeState(ArmedStay.instance());
	}

	/**
	 * Processes one zone being unchecked
	 */
	@Override
	public void handleEvent(UncheckZone event) {
		CountdownToStayNotReady.instance().setTimer(timer);
		SecurityContext.instance().changeState(CountdownToStayNotReady.instance());
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
