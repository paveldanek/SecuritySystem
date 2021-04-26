package buttons;

import events.PressStay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

/**
 * The button for armed stay request
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class StayButton extends PanelButton implements EventHandler<ActionEvent> {
	/**
	 * The button for armed stay
	 * 
	 * @param name of type string
	 */
	public StayButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressStay.instance());
	}
}
