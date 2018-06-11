package week02;

import test.AbstractTestHarness;


public class TestHarness extends AbstractTestHarness
{

	public static void main(String[] args)
	{
		new TestHarness().runTests();

	}

	protected void runTests()
	{
		try
		{
			boolean javadocTest = executeTest(JUnitJavadocValidation.class);
			boolean volunteerTest = executeTest(JUnitVolunteerTest.class);
			boolean result = javadocTest && volunteerTest;

			trace(result ? "Tests Passed" : "Tests Failed");
		}
		catch(Exception ex)
		{
			trace(ex.getMessage());
		}
	}
}
