package states;

import events.PressAway;
import events.PressStay;
import events.TimerRanOut;
import timer.Notifiable;

public class Ready extends SecurityState implements Notifiable {
	private static Ready instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private Ready() {
	}

	public static Ready instance() {
		if (instance == null) {
			instance = new Ready();
		}
		return instance;
	}

	@Override
	public void handleEvent(TimerRanOut event) {

	}

	public void handleEvent(PressAway event) {

	}

	public void handleEvent(PressStay event) {

	}

	@Override
	public void enter() {

	}

	@Override
	public void leave() {

	}
}
