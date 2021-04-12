package display;

public interface SecurityDisplay {

	public void showReady();

	public void showNotReady();

	public void showSecondsToAway(int seconds);

	public void showSecondsToStay(int seconds);

	public void showSecondsToBreach(int seconds);

	public void showAway();

	public void showStay();

	public void showBreach();

	public void showCancel();

	public void showPassword(String password);
}