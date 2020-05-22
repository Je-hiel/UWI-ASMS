package Executive;

import Club.Member;
import DAOs.ExecutiveDAO;

public abstract class Executive extends Member {
	
	private ExecutiveDAO dao;
	private String password;
	
	public Executive(int id, String firstName, String lastName, String email, String major, String status, String password) { 
		super(id, firstName, lastName, email, major, status);
		
		this.password = password;
		try {
			dao = new ExecutiveDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	public Executive() {
		// TODO Auto-generated constructor stub
		super();
	}

	public abstract void awardPoints();
	
	public void addMember(String firstName, String lastName, String email, String major) {
		try {
			dao.addMember(firstName, lastName, email, major);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}