package zones;

public class Zone {

	private boolean checked;

	public Zone() {
		checked = true;
	}

	public boolean isChecked() {
		return checked;
	}

	public void toggle() {
		checked = !checked;
	}
}
