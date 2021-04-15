package states.stay;

import events.TimerRanOut;
import events.TimerTicked;
import events.TimerUp;
import states.SecurityContext;
import states.SecurityState;
import timer.Notifiable;
import timer.Timer;

public class CountdownToStay extends SecurityState implements Notifiable {

	private static CountdownToStay instance;
	private Timer timer;

	/**
	 * Private constructor for the singleton pattern
	 */
	protected CountdownToStay() {
	}

	public static CountdownToStay instance() {
		if (instance == null) {
			instance = new CountdownToStay();
		}
		return instance;
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
	}

	public void startTimer(int seconds) {
		if (timer == null) {
			timer = new Timer(this, seconds);
		}
	}

	public void stopTimer() {
		timer = null;
	}

	public int getTimeValue() {
		return timer.getTimeValue();
	}

	public void handleEvent(TimerTicked event) {
		SecurityContext.instance().showSecondsToStay(timer.getTimeValue());
	}

	public void handleEvent(TimerRanOut event) {
		SecurityContext.instance().showSecondsToStay(timer.getTimeValue());
		SecurityContext.instance().handleEvent(TimerUp.instance());
	}

}
