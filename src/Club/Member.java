package Club;

public class Member {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String major;
	private String status;
	
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param major
	 * @param status
	 */
	public Member(int id, String firstName, String lastName, String email, String major, String status) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.major = major;
		this.status = status;
	}
	
	


	public Member() {
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	
	
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return String.format("Member [id=%d, first name=%s, last name=%s, email=%s, major=%s, status=%s]",
				id, firstName, lastName, email, major, status);
	}
	
}
