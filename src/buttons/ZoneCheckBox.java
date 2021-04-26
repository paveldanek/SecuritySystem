package buttons;

import events.ZoneToggled;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import states.SecurityContext;

/**
 * The box that checks a zone that simulates a zone in a property as ready or
 * not ready
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class ZoneCheckBox extends CheckBox implements EventHandler<ActionEvent> {
	private int zoneNumber;

	/**
	 * Create a box that can be toggled
	 * 
	 * @param name the text to name it
	 */
	public ZoneCheckBox(String name) {
		super(name);
		setIndeterminate(false);
		setSelected(true);
		setOnAction(this);
		zoneNumber = SecurityContext.instance().addZone();
	}

	@Override
	public void handle(ActionEvent event) {
		ZoneToggled.instance().setZoneNumber(zoneNumber);
		SecurityContext.instance().handleEvent(ZoneToggled.instance());
	}
}
