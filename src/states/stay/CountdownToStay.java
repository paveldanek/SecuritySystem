package states.stay;

import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;
import states.Countdown;
import states.SecurityContext;

public class CountdownToStay extends Countdown {
	private static CountdownToStay instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CountdownToStay() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static CountdownToStay instance() {
		if (instance == null) {
			instance = new CountdownToStay();
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
