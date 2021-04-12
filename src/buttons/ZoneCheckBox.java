package buttons;

import events.ZoneToggled;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import states.SecurityContext;

public class ZoneCheckBox extends CheckBox implements EventHandler<ActionEvent> {
	private int zoneNumber;

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
