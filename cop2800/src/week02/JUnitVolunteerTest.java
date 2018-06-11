package week02;
import test.AbstractJUnitBase;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

/**
 * JUnit test executed by the test harness
 * 
 * @author Scott LaChance
 *
 */
public class JUnitVolunteerTest extends AbstractJUnitBase
{

	@Test
	public void testVolunteerDefaultConstructor()
	{
		// Default constructor
		Volunteer volunteer = new Volunteer();
		assertNotNull("Default constructor failed", volunteer);
	}

	@Test
	public void testVolunteerFullConstructor()
	{
		String first = "Scott";
		String last = "LaChance";
		LocalDate now = LocalDate.now();
		double hours = 42;

		// Default constructor
		Volunteer volunteer = new Volunteer(first, last, now, hours);
	}

	@Test
	public void testVolunteerPartialConstructor()
	{
		String first = "Scott";
		String last = "LaChance";

		// Default constructor
		Volunteer volunteer = new Volunteer(first, last);
	}

	@Test
	public void testVolunteerGetterSetters()
	{
		String first = "Scott";
		String last = "LaChance";
		LocalDate now = LocalDate.now();
		double hours = 42.2;

		// First Name setter/getter
		Volunteer volunteer = new Volunteer();
		volunteer.setFirstName(first);
		String actual = volunteer.getFirstName();
		assertEquals(String.format("Invalid first name - expected: %s, actual%s", first, actual),
				first, actual);

		// Last Name setter/getter
		volunteer.setLastName(last);
		actual = volunteer.getLastName();
		assertEquals(String.format("Invalid last name - expected: %s, actual%s", last, actual),
				last, actual);

		// Last Name setter/getter
		volunteer.setStartDate(now);
		LocalDate actualDate = volunteer.getStartDate();
		assertEquals(String.format("Invalid date - expected: %s, actual%s", now, actualDate),
				now, actualDate);

		// Last Name setter/getter
		volunteer.setVolunteerHours(hours);
		double actualHours = volunteer.getVolunteerHours();
		assertEquals(String.format("expected: %f, actual%f", hours, actualHours),
				Double.toHexString(hours), Double.toHexString(actualHours));
	}
	
	@Test
	public void testDefaultToString()
	{
		String localDateString = LocalDate.now().toString();
		String expected = "Volunteer [firstName=no first name assigned, lastName=no last name assigned, startDate=" + localDateString + ", volunteerHours=0.0]";
		Volunteer v1 = new Volunteer();
		String actual = v1.toString();
		trace(actual);
		assertEquals(String.format("expected: %s, actual: %s", expected, actual),
				expected, actual);
	}
	
	@Test
	public void testSetDateToString()
	{	
		String expected = "Volunteer [firstName=no first name assigned, lastName=no last name assigned, startDate=2016-12-09, volunteerHours=0.0]";
		Volunteer v2 = new Volunteer();
		v2.setStartDate(2016, 12, 9);
		String actual = v2.toString();
		trace(actual);
		assertEquals(String.format("Failed testSetDateToString - expected: %s, actual: %s", expected, actual),
				expected, actual);
	}
	
	@Test
	public void testNameToString()
	{		
		String localDateString = LocalDate.now().toString();
		String expected = "Volunteer [firstName=Sally, lastName=Johnson, startDate=" + localDateString + ", volunteerHours=0.0]";
		Volunteer v3 = new Volunteer("Sally","Johnson");
		String actual = v3.toString();
		trace(actual);
		assertEquals(String.format("Failed testNameToString - expected: %s, actual: %s", expected, actual),
				expected, actual);
	}
	
	@Test
	public void testFullToString()
	{			
		String expected = "Volunteer [firstName=John, lastName=Doe, startDate=2016-12-16, volunteerHours=65.5]";
		LocalDate testDate = LocalDate.of(2016, 12, 16);
		Volunteer v4 = new Volunteer("John","Doe",testDate, 65.5);
		String actual = v4.toString();
		trace(actual);
		assertEquals(String.format("Failed testFullToString - expected: %s, actual: %s", expected, actual),
				expected, actual);
	}
}
