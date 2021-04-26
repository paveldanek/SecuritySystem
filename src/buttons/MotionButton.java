package buttons;

import events.PressMotion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

/**
 * The motion button that simulates a motion sensor
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class MotionButton extends PanelButton implements EventHandler<ActionEvent> {
	/**
	 * Creates a motion button with the desired string name
	 * 
	 * @param name of type string
	 */
	public MotionButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressMotion.instance());
	}
}
