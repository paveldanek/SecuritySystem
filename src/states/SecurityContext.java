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
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * 
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

	public void setDisplay(SecurityDisplay display) {
		this.display = display;
	}

	public int addZone() {
		zones[zoneCounter] = new Zone();
		zoneCounter++;
		return zoneCounter;
	}

	public void changeState(SecurityState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void handleEvent(DigitPressed event) {
		currentState.handleEvent(event);
		password = password + DigitPressed.instance().getDigit();
		if (password.equalsIgnoreCase(PASSWORD)) {
			handleEvent(EnterPassword.instance());
			password = "";
		}
	}

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

	public void handleEvent(EnterPassword event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(IncorrectPassword event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(CheckAllZones event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(UncheckZone event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressAway event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressCancel event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressMotion event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(PressStay event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(TimerTicked event) {
		currentState.handleEvent(event);
	}

	public void handleEvent(TimerRanOut event) {
		currentState.handleEvent(event);
	}

	public void showReady() {
		display.showReady();
	}

	public void showNotReady() {
		display.showNotReady();
	}

	public void showSecondsToAway(int seconds) {
		display.showSecondsToAway(seconds);
	}

	public void showSecondsToStay(int seconds) {
		display.showSecondsToStay(seconds);
	}

	public void showSecondsToBreach(int seconds) {
		display.showSecondsToBreach(seconds);
	}

	public void showAway() {
		display.showAway();
	}

	public void showStay() {
		display.showStay();
	}

	public void showBreach() {
		display.showBreach();
	}

	public void showCancel() {
		display.showCancel();
	}

	public void showPassword(String password) {
		display.showPassword(password);
	}

}