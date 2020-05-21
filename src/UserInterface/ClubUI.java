package UserInterface;

import Club.*;

/**
 * Manages the user interface used.
 * 
 * @author 
 */
public class ClubUI {

	private ClubController club;
	
	public ClubUI(ClubController asms) {
		club = asms;
	}
	
	public void start() {
		club.login();
	}
	
	public static void main(String[] args) {
		ClubUI ui = new ClubUI(new ClubController());
		ui.start();
	}
	
}
