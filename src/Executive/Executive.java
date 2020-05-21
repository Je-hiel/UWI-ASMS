package Executive;

import Club.Member;

public abstract class Executive extends Member {
	
	private String password;
	
	public Executive(int id, String firstName, String lastName, String email, String major, String status, String password) { 
		super(id, firstName, lastName, email, major, status);
		
		this.password = password;
	}
	 
	public abstract void awardPoints();
}