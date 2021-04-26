package display;

/**
 * This interface ensures that any GUI that implements it has methods for
 * displaying relevant information for the user.
 * 
 * @author Ben Hines, Carter Clark, Chris Lara-Batencourt, Pavel Danek, Ricky
 *         Nguyen
 */
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
