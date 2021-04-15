package states.stay;

import events.CheckAllZones;
import events.TimerUp;
import states.NotReady;
import states.SecurityContext;

public class CountdownToStayNotReady extends CountdownToStay {
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

	public void handleEvent(CheckAllZones event) {
		SecurityContext.instance().changeState(CountdownToStayReady.instance());
	}

	public void handleEvent(TimerUp event) {
		// SecurityContext.instance().showSecondsToStay(CountdownToStay.instance().getTimeValue());
		CountdownToStay.instance().stopTimer();
		SecurityContext.instance().changeState(NotReady.instance());
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}

}
