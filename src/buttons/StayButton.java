package buttons;

import events.PressStay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class StayButton extends PanelButton implements EventHandler<ActionEvent> {

	public StayButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressStay.instance());
	}
}
