package week03;

import test.AbstractTestHarness;

/**
 * Wraps the JUnit tests and launches them
 * @author Scott LaChance
 *
 */
public class TestHarness extends AbstractTestHarness
{

	/**
	 * main entry point for the assignment test
	 * @param args command line arguments - not used
	 */
	public static void main(String[] args)
	{
		new TestHarness().runTests();

	}

	/**
	 * Implements the abstract method from AbstractTestHarness
	 * Calls the AbstractTestHarness.executetest to run the JUnit test
	 * Captures the results and evaluates success or failure
	 */
	protected void runTests()
	{
		try
		{
			boolean javadocTest = executeTest(JUnitJavadocValidation.class);
			boolean test = executeTest(JUnitHangmanTest.class);
			boolean result = javadocTest && test;

			trace(result ? "Tests Passed" : "Tests Failed");
		}
		catch(Exception ex)
		{
			trace(ex.getMessage());
		}
	}
}
