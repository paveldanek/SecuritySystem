package states;

import display.SecurityDisplay;
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
import events.ZoneToggled;
import zones.Zone;

/**
 * The context is an observer for the security system and stores the context
 * info for states
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
public class SecurityContext {
	private static SecurityContext instance;
	private Zone[] zones = new Zone[5]; // works for up to 5 zones
	private int zoneCounter = 0;
	private static final String PASSWORD = "1234";
	private String password = "";
	private SecurityState currentState;
	private SecurityDisplay display;

	/**
	 * Singleton pattern.
	 */
	private SecurityContext() {
		instance = this;
		currentState = Ready.instance();
	}

	public static SecurityContext instance() {
		if (instance == null) {
			instance = new SecurityContext();
		}
		return instance;
	}

	/**
	 * Pairs this Security Context with a GUI.
	 * 
	 * @param display - GUI supplied
	 */
	public void setDisplay(SecurityDisplay display) {
		this.display = display;
	}

	/**
	 * Adds a new zone into the array of zones that are monitored.
	 * 
	 * @return the Zone number
	 */
	public int addZone() {
		zones[zoneCounter] = new Zone();
		zoneCounter++;
		return zoneCounter;
	}

	/**
	 * Takes care of transitions between states.
	 * 
	 * @param nextState - indicates the state transitioning into.
	 */
	public void changeState(SecurityState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Processes digit pressed event. Adds new digit to the password entry and
	 * compares the entry to the actual password, once they are the same length.
	 * Creates the EnterPassword (correct password) and IncorrectPassword (wrong
	 * password) events. Clears the password entry after comparing.
	 */
	public void handleEvent(DigitPressed event) {
		password = password + DigitPressed.instance().getDigit();
		currentState.handleEvent(event);
		// compares entered password when size is the same
		if (password.length() == PASSWORD.length()) {
			if (password.equalsIgnoreCase(PASSWORD)) {
				handleEvent(EnterPassword.instance());
				clearPassword();
			} else {
				handleEvent(IncorrectPassword.instance());
				clearPassword();
			}
		}
	}

	/**
	 * Processes zone toggled event. Toggles particular zone checked/unchecked. If
	 * all zones are checked it creates CheckAllZones event, if any zone is
	 * unchecked it creates UncheckZone event.
	 */
	public void handleEvent(ZoneToggled event) {
		boolean allZonesChecked = true;
		zones[ZoneToggled.instance().getZoneNumber() - 1].toggle();
		for (int index = 0; index < zoneCounter; index++) {
			if (!zones[index].isChecked()) {
				allZonesChecked = false;
				break;
			}
		}
		if (allZonesChecked) {
			handleEvent(CheckAllZones.instance());
		} else {
			handleEvent(UncheckZone.instance());
		}
	}

	/**
	 * Processes correct password entered event.
	 */
	public void handleEvent(EnterPassword event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes incorrect password entered event.
	 */
	public void handleEvent(IncorrectPassword event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes all zones checked event.
	 */
	public void handleEvent(CheckAllZones event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes a zone unchecked event.
	 */
	public void handleEvent(UncheckZone event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Away button pressed event.
	 */
	public void handleEvent(PressAway event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Cancel button pressed event.
	 */
	public void handleEvent(PressCancel event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Motion Detector button pressed (motion detected) event.
	 */
	public void handleEvent(PressMotion event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Stay button pressed event.
	 */
	public void handleEvent(PressStay event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Timer ticked event.
	 */
	public void handleEvent(TimerTicked event) {
		currentState.handleEvent(event);
	}

	/**
	 * Processes Timer ran out event.
	 */
	public void handleEvent(TimerRanOut event) {
		currentState.handleEvent(event);
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showReady() {
		display.showReady();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showNotReady() {
		display.showNotReady();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showSecondsToAway(int seconds) {
		display.showSecondsToAway(seconds);
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showSecondsToStay(int seconds) {
		display.showSecondsToStay(seconds);
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showSecondsToBreach(int seconds) {
		display.showSecondsToBreach(seconds);
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showAway() {
		display.showAway();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showStay() {
		display.showStay();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showBreach() {
		display.showBreach();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showCancel() {
		display.showCancel();
	}

	/**
	 * Invokes the corresponding method of the display.
	 */
	public void showPassword() {
		display.showPassword(password);
	}

	/**
	 * Clears the password entered.
	 */
	public void clearPassword() {
		password = "";
	}

}
