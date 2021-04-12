package buttons;

import events.PressMotion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class MotionButton extends PanelButton implements EventHandler<ActionEvent> {

	public MotionButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressMotion.instance());
	}
}
