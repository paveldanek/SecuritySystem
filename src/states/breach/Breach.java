package states.breach;

import states.SecurityContext;
import states.SecurityState;

public class Breach extends SecurityState {
	private static Breach instance;

	private Breach() {

	}

	public static Breach instance() {
		if (instance == null) {
			instance = new Breach();
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
