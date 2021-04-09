package controller.states;

import controller.events.CheckAllZones;
import controller.events.EnterPassword;
import controller.events.PressAway;
import controller.events.PressCancel;
import controller.events.PressMotion;
import controller.events.PressStay;
import controller.events.UncheckZone;

public abstract class SecurityState {

	/**
	 * Initializes the state
	 */
	public abstract void enter();

	/**
	 * Performs any necessary clean up while leaving the state
	 */
	public abstract void leave();

	/**
	 * Processes all the zones being checked
	 */
	public void handleEvent(CheckAllZones event) {

	}

	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {

	}

	/**
	 * Processes the away button being pressed
	 */
	public void handleEvent(PressAway event) {

	}

	/**
	 * Processes the cancel button being pressed
	 */
	public void handleEvent(PressCancel event) {

	}

	/**
	 * Processes the motion button being pressed
	 */
	public void handleEvent(PressMotion event) {

	}

	/**
	 * Processes stay button being pressed
	 */
	public void handleEvent(PressStay event) {

	}

	/**
	 * Processes one zone being unchecked
	 */
	public void handleEvent(UncheckZone event) {

	}
}
