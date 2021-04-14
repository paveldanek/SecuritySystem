package states;

import timer.Notifiable;
import timer.Timer;

public class Countdown extends SecurityState implements Notifiable {
	private static Countdown instance;
	protected Timer timer;

	/**
	 * Private for the singleton pattern
	 */
	protected Countdown() {
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static Countdown instance() {
		if (instance == null) {
			instance = new Countdown();
		}
		return instance;
	}

	public void startTimer() {
		timer = new Timer(this, 10);
	}

	public void setTimer(Timer timer) {
		this.timer = new Timer(this, timer.getTimeValue());
	}

	public int getTimeValue() {
		return timer.getTimeValue();
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
