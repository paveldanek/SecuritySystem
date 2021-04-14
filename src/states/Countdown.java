package states;

import events.TimerTicked;
import timer.Notifiable;
import timer.Timer;

public class Countdown extends SecurityState implements Notifiable {
	protected Timer timer;

	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	@Override
	public void handleEvent(TimerTicked event) {

		SecurityContext.instance().showSecondsToAway(timer.getTimeValue());
	}

	@Override
	public void enter() {

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

}
