package states;

import timer.Notifiable;
import timer.Timer;

public class Countdown extends SecurityState implements Notifiable {
	protected Timer timer;

	public void startTimer() {
		timer = new Timer(this, 10);
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
