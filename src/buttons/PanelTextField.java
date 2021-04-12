package buttons;

import javafx.scene.control.TextField;

public class PanelTextField extends TextField {

	public PanelTextField(String name) {
		super(name);
		setEditable(false);
	}

	public void display(String text) {
		super.setText(text);
	}
}