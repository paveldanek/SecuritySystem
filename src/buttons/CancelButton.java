package buttons;

import events.PressCancel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

/**
 * The button for cancel request
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class CancelButton extends PanelButton implements EventHandler<ActionEvent> {
	/**
	 * The button for cancel
	 * 
	 * @param name of type string
	 */
	public CancelButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressCancel.instance());
	}
}
