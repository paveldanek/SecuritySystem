package states.breach;

import states.SecurityContext;
import states.SecurityState;

public class BreachReady extends SecurityState {
	private static BreachReady instance;

	private BreachReady() {

	}

	public static BreachReady instance() {
		if (instance == null) {
			instance = new BreachReady();
		}
		return instance;
	}

	@Override
	public void enter() {
		SecurityContext.instance().showBreach();

	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}
