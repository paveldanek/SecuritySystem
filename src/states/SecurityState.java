package states;

import events.CheckAllZones;
import events.DigitPressed;
import events.EnterPassword;
import events.IncorrectPassword;
import events.PressAway;
import events.PressCancel;
import events.PressMotion;
import events.PressStay;
import events.TimerRanOut;
import events.TimerTicked;
import events.UncheckZone;

/**
 * Superclass to every state of the Security System.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 * 
 * @Copyright (c) 2010 Code adapted from Brahma Dathan and Sarnath Ramnath
 *            Redistribution and use with or without modification, are permitted
 *            provided that the following conditions are met:
 *
 *            - the use is for academic purpose only - Redistributions of source
 *            code must retain the above copyright notice, this list of
 *            conditions and the following disclaimer. - Neither the name of
 *            Brahma Dathan or Sarnath Ramnath may be used to endorse or promote
 *            products derived from this software without specific prior written
 *            permission.
 *
 *            The authors do not make any claims regarding the correctness of
 *            the code in this module and are not responsible for any loss or
 *            damage resulting from its use.
 */

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
	 * Processes one zone being unchecked
	 */
	public void handleEvent(UncheckZone event) {

	}

	/**
	 * Processes the digit being entered
	 */
	public void handleEvent(DigitPressed event) {

	}

	/**
	 * Processes the password being entered
	 */
	public void handleEvent(EnterPassword event) {

	}

	/**
	 * Processes the password being incorrect
	 */
	public void handleEvent(IncorrectPassword event) {

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

	/**
	 * Processes a timer tick, generates a Timer Ticked event
	 */
	public void handleEvent(TimerTicked event) {

	}

}
