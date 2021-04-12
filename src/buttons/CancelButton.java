package buttons;

import events.PressCancel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class CancelButton extends PanelButton implements EventHandler<ActionEvent> {

	public CancelButton(String name) {
		super(name);
	}

	@Override
	public void handle(ActionEvent event) {
		SecurityContext.instance().handleEvent(PressCancel.instance());
	}
}
