package buttons;

import events.DigitPressed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecurityContext;

/**
 * The digit button
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class DigitButton extends PanelButton implements EventHandler<ActionEvent> {
	private String digit = "";

	/**
	 * Creates the digit button with the proper text on the button
	 * 
	 * @param name of type string
	 */
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
