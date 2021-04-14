package states.stay;

import events.TimerUp;
import events.UncheckZone;
import states.SecurityContext;

public class CountdownToStayReady extends CountdownToStay {
	private static CountdownToStayReady instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private CountdownToStayReady() {
	}

	public static CountdownToStayReady instance() {
		if (instance == null) {
			instance = new CountdownToStayReady();
		}
		return instance;
	}

	public void handleEvent(UncheckZone event) {
		SecurityContext.instance().changeState(CountdownToStayNotReady.instance());
	}

	public void handleEvent(TimerUp event) {
		// SecurityContext.instance().showSecondsToStay(CountdownToStay.instance().getTimeValue());
		CountdownToStay.instance().stopTimer();
		SecurityContext.instance().changeState(ArmedStay.instance());
	}

	@Override
	public void enter() {
		CountdownToStay.instance().startTimer(10);
		SecurityContext.instance().showSecondsToStay(CountdownToStay.instance().getTimeValue());
	}

	@Override
	public void leave() {
	}

}
