package buttons;

import javafx.scene.control.TextField;

/**
 * The panel text field for display to the user
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
public class PanelTextField extends TextField {
	/**
	 * Creates the panel text field with initial text
	 * 
	 * @param name of type string
	 */
	public PanelTextField(String name) {
		super(name);
		setEditable(false);
	}

	/**
	 * Displays the desired string to the user
	 * 
	 * @param text of type string to be displayed
	 */
	public void display(String text) {
		super.setText(text);
	}
}
