package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * The abstract GUI Panel Button object. Helps get rid of conditionals
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 *
 */
public abstract class PanelButton extends Button implements EventHandler<ActionEvent> {

	/**
	 * Create the panel button with the proper name. Makes the button a listener to
	 * clicks on itself.
	 * 
	 * @param name the text
	 */
	public PanelButton(String name) {
		super(name);
		setOnAction(this);
	}

}
