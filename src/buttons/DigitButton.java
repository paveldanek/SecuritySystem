package buttons;

import events.DigitPressed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

public class DigitButton extends PanelButton implements EventHandler<ActionEvent> {
	private String digit = "";

	public DigitButton(String name) {
		super(name);
		digit = name;
	}

	@Override
	public void handle(ActionEvent event) {
		DigitPressed.instance().addDigit(digit);
		SecurityContext.instance().handleEvent(DigitPressed.instance());
	}
}
