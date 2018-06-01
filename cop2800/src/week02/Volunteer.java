/**
 * @author David Rios
 */
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
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.volunteerHours = volunteerHours;
		
	}
	
	/**
	 * This constructor calls the Setters, sets them to Default Values, then checks to see if the updated
	 * value is null
	 */
	public Volunteer(String firstName, String lastName, LocalDate startDate)
	{
		this.firstName = DEFAULT_FIRST_NAME;
		this.lastName = DEFAULT_LAST_NAME;
		this.startDate = DEFAULT_START_DATE;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStartDate(startDate);
	}
	
	// Public Methods
	
	/**
	 * Adds the value of hours the volunteer has worked currently to the numbers already worked total.
	 * 
	 * @param newvolunteerHours current amount of hours worked by volunteer currently
	 * @param volunteerHours Last known amount of hours worked by volunteer total.
	 * @param this.volunteerHours Total amount of hours worked between newvolunteerHours and volunteerHours
	 */
	public void updateVolunteerHours (double hours) {
		
		this.volunteerHours =  hours + volunteerHours;
	}
	// Protected Methods
	
	// Private Methods
	
	// Public Methods
	
	/**
	 * Getters and setters for Volunteer class
	 * 
	 * @return Getter: Returns first name of Volunteer
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return Setter: Updates newFName with user input
	 */
	public void setFirstName(String newFName) {
		if (firstName != null && firstName.length() > 0) 
			this.firstName = newFName;
	}
	/**
	 * @return Getter returns volunteerHours
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return Setter, updates lastName with user input
	 */
	public void setLastName(String newLastName) {
		if (lastName != null && lastName.length() > 0) 
			this.lastName = newLastName;
	}
	/**
	 * @return Getter returns startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	/**
	 * @return Setter, updates startDate with user input
	 */
	public void setStartDate(LocalDate newStartDate) {
		if (startDate != null) 
			this.startDate = newStartDate;
		}
	/**
	 *@param Overload for setstartDate. Updates year, month, day.
	 */
	public void setStartDate(int year, int month, int day) {
		this.startDate = LocalDate.of(year, month, day);
	}
	/**
	 * @return Getter returns volunteerHours
	 */
	public double getVolunteerHours() {
		return volunteerHours;
	}
	/**
	 *@return Setter, updates volunteerHours with user input
	 */
	public void setVolunteerHours(double newHours) {
		this.volunteerHours = newHours;
	}

	// Public Constants
	public static final String DEFAULT_FIRST_NAME = "no first name assigned";
	public static final String DEFAULT_LAST_NAME = "no last name assigned";
	public static final LocalDate DEFAULT_START_DATE = LocalDate.now();
	public static final double DEFAULT_HOURS = 0;
	
	// Private data
	private String firstName;
	private String lastName;
	private LocalDate startDate;
	private double volunteerHours;

	
/**
 * @return Returned values based on user input. 
 */
public String toString() {
		
	return 
	"Volunteer " +
	"[firstName=" + firstName + ", " +
	"lastName=" + lastName + ", " +
	"startDate=" + startDate + ", " +
	"volunteerHours=" + volunteerHours+ "]";
	
	}
}
	
