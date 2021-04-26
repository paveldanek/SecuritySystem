package buttons;

import events.PressAway;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

/**
 * The button for armed away request
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public class AwayButton extends PanelButton implements EventHandler<ActionEvent> {
	/**
	 * The button for armed away
	 * 
	 * @param name of stype string
	 */
	public AwayButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressAway.instance());
	}
}
