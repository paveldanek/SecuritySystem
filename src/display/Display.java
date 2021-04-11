package display;

public class Display {
	private static String message;
	private static Display instance;

	private Display() {
		message = "";
	}

	public static Display instance() {
		if (instance == null) {
			instance = new Display();
		}
		return instance;
	}

	public void show
}
