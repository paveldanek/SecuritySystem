package buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class PanelButton extends Button implements EventHandler<ActionEvent> {

	public PanelButton(String name) {
		super(name);
		setOnAction(this);
	}

}
