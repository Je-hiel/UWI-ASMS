package Club;

public class Event {
	
	private int id;
	private String name;
	private String location;
	private String datetime;
	/**
	 * @param name
	 * @param location
	 * @param date
	 */
	public Event(String name, String location, String datetime) {
		super();
		this.name = name;
		this.location = location;
		this.datetime = datetime;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the date
	 */
	public String getDateTime() {
		return datetime;
	}
	/**
	 * @param date the date to set
	 */
	public void setDateTime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
}
