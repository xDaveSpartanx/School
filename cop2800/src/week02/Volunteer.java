package week02;

import java.time.LocalDate;


public class Volunteer{

	// Constructors
	/**
	 * Default Constructor
	 * Use the defaults to initialize the class
	 */
	public Volunteer()
	{
		// this is constructor chaining
		this(DEFAULT_FIRST_NAME,DEFAULT_LAST_NAME,DEFAULT_START_DATE,DEFAULT_HOURS);
	}
	/**
	 * Parameterized constructor
	 * Use the defaults to initialize the class
	 * @param firstName First name of the volunteer
	 * @param lastName Last name of the volunteer
	 */
	public Volunteer(String firstName, String lastName)
	{
		//this is constructor chaining
		this(firstName,lastName,DEFAULT_START_DATE,DEFAULT_HOURS);
	}
	/**
	 * Parameterized constructor used to initialize the Volunteer class
	 * 
	 * @param firstName First name of the volunteer
	 * @param lastName Last name of the volunteer
	 * @param startDate Start date for the volunteer
	 * @param volunteerHours Number of hours volunteered
	 */
	public Volunteer(String firstName, String lastName, LocalDate startDate, double volunteerHours)
	{
		m_firstName = firstName;
		m_lastname = lastName;
		m_startDate = startDate;
		m_hours = volunteerHours;
	}
	
	
	
	// Public Methods
	
	//public int updateVolunteerHours () {
	//	localDate now = LocalDatae.now();
	//	int nowYear;
		
	//}
	// Protected Methods
	
	// Private Methods
	
	// Public Methods
	public String getM_firstName() {
		return m_firstName;
	}
	public void setM_firstName(String m_firstName) {
		if (m_firstName != null && m_firstName.length() > 0) {
			this.m_firstName = m_firstName;
		}
	}
	
	public String getM_lastname() {
		return m_lastname;
	}
	public void setM_lastname(String m_lastname) {
		if (m_lastname != null && m_lastname.length() > 0) {
			this.m_lastname = m_lastname;
		}
		
	}
	public LocalDate getM_startDate() {
		return m_startDate;
	}
	public void setM_startDate(LocalDate m_startDate) {
		if (m_startDate != null) {
			this.m_startDate = m_startDate;
		}
	//public void setM_startDate(int year, int month, int day) {
	//	LocalDate tempDate = LocalDate.of(int year, month, dayOfMonth);
	///	this.m_startDate = LocalDate.of(year, month, dayOfMonth);
	//}
		
	}
	public double getM_hours() {
		return m_hours;
	}
	public void setM_hours(double m_hours) {
		this.m_hours = m_hours;
	}


	// Public Constants
	public static final String DEFAULT_FIRST_NAME = "no first name assigned";
	public static final String DEFAULT_LAST_NAME = "no first name assigned";
	public static final LocalDate DEFAULT_START_DATE = LocalDate.now();
	public static final double DEFAULT_HOURS = 0;
	
	// Private data
	private String m_firstName;
	private String m_lastname;
	private LocalDate m_startDate;
	private double m_hours;
}
