package buttons;

import events.PressAway;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class AwayButton extends PanelButton implements EventHandler<ActionEvent> {

	public AwayButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressAway.instance());
	}
}
