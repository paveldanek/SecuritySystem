package states;

import events.CheckAllZones;
import events.EnterPassword;
import events.PressAway;
import events.PressCancel;
import events.PressMotion;
import events.PressStay;
import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;

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
	 * Processes a timer tick, generates a Timer Ran Out event
	 */
	public void handleEvent(TimerRanOut event) {

	}

	// IT MAY BE NOT NECESSARY TO HAVE TIMERTICKED HANDLER HERE, MAYBE MOVE TO
	// CONTEXT
	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	public void handleEvent(TimerTicked event) {

	}

	/**
	 * Processes one zone being unchecked
	 */
	public void handleEvent(UncheckZone event) {

	}
}
