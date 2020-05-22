package Club;

import Executive.*;

import java.awt.EventQueue;

import DAOs.*;

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
			System.out.println(e);
		}
		
		executive = new President();
	}
	
	public String getExecutiveLastName() {//throws Exception {
		if (executive.getLastName() == null) {
			return "";
		}
		return executive.getLastName();
		/*
		 * try { return executive.getLastName(); } catch (Exception e) { return ""; }
		 */
	}
	
	public String getExecutivePosition() {//throws Exception {
		return executive.getClass().getName();
		/*
		 * try { return executive.getClass().getName(); } catch (Exception e) { return
		 * "Executive"; }
		 */
	}

	public Executive login(String lastName, String password) {
		try 
		{
			executive = executiveDAO.login(lastName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return executive;
	}

	public void addMember(String firstName, String lastName, String email, String major) {
		executive.addMember(firstName, lastName, email, major);
	}
	public void editMember() {}
	public void viewMember() {}
	public void removeMember() {}
	
	public void awardPoint() {}
	
	public void addEvent() {}
	public void editEvent() {}
	public void viewEvent() {}
	public void removeEvent() {}
	
}
