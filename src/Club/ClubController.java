package Club;

import Executive.Executive;

import java.awt.EventQueue;

import DAOs.*;
import UserInterface.Login;

/**
 * Manages the operations of the club.
 * 
 * @author 
 */
public class ClubController {

	/** Represents the signed in executive. */
	private Executive executive;
	
	private ExecutiveDAO executiveDAO;
	
	
	public ClubController() {
		// Create the DAO
		try {
			executiveDAO = new ExecutiveDAO();
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
	}
	
	

	public void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(executiveDAO);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addMember() {}
	public void editMember() {}
	public void viewMember() {}
	public void removeMember() {}
	
	public void awardPoint() {}
	
	public void addEvent() {}
	public void editEvent() {}
	public void viewEvent() {}
	public void removeEvent() {}
	
}
