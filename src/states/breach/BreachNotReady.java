package states.breach;

import states.SecurityContext;
import states.SecurityState;

public class BreachNotReady extends SecurityState {
	private static BreachNotReady instance;

	private BreachNotReady() {

	}

	public static BreachNotReady instance() {
		if (instance == null) {
			instance = new BreachNotReady();
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
