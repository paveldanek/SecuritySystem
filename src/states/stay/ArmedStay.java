package states.stay;

import states.SecurityContext;
import states.SecurityState;

public class ArmedStay extends SecurityState {
	private static ArmedStay instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private ArmedStay() {
	}

	public static ArmedStay instance() {
		if (instance == null) {
			instance = new ArmedStay();
		}
		return instance;
	}

	@Override
	public void enter() {
		SecurityContext.instance().showStay();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}
