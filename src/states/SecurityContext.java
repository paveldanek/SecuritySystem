package states;

import events.CheckAllZones;
import events.DigitPressed;
import events.EnterPassword;
import events.PressAway;
import events.PressCancel;
import events.PressMotion;
import events.PressStay;
import events.TimerTicked;
import events.UncheckZone;
import events.ZoneToggled;
import zones.Zone;

public class SecurityContext {
	private static SecurityContext instance;
	private Zone[] zones = new Zone[5]; // works for up to 5 zones
	private int zoneCounter = 0;
	private static final String PASSWORD = "1234";
	private String password = "";

	private SecurityContext() {
		instance = this;
	}

	public static SecurityContext instance() {
		if (instance == null) {
			instance = new SecurityContext();
		}
		return instance;
	}

	public int addZone() {
		zones[zoneCounter] = new Zone();
		zoneCounter++;
		return zoneCounter;
	}

	public void handleEvent(DigitPressed event) {
		password = password + DigitPressed.instance().getDigit();
		System.out.println("Password entered: " + password);
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
		System.out.println("Password Correct.");
	}

	public void handleEvent(CheckAllZones event) {
		System.out.println("All Zones Checked.");

	}

	public void handleEvent(UncheckZone event) {
		System.out.println("Sone Zones Unchecked.");

	}

	public void handleEvent(PressAway event) {

	}

	public void handleEvent(PressCancel event) {
		// this is not the intended future functionality: just for testing purposes
		password = "";
		System.out.println("Password canceled.");
	}

	public void handleEvent(PressMotion event) {
	}

	public void handleEvent(PressStay event) {
	}

	public void handleEvent(TimerTicked event) {

	}
}
