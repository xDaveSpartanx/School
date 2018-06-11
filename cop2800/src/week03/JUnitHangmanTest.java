package week03;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import test.AbstractJUnitBase;

public class JUnitHangmanTest extends AbstractJUnitBase
{
	// Letter frequency - used to order the lookup array
//	E	12,60%
//	T	9,37%
//	A	8,34%
//	O	7,70%
//	N	6,80%
//	I	6,71%
//	H	6,11%
//	S	6,11%
//	R	5,68%
//	L	4,24%
//	D	4,14%
//	U	2,85%
//	C	2,73%
//	M	2,53%
//	W	2,34%
//	Y	2,04%
//	F	2,03%
//	G	1,92%
//	P	1,66%
//	B	1,54%
//	V	1,06%
//	K	0,87%
//	J	0,23%
//	X	0,20%
//	Q	0,09%
//	Z	0,06%

	// test data - contains word to play against, expected dashed word result and overall game result
	private final TestData[] dictionary = {
			new TestData("trouble","trou-le","anihsdc",false), 
			new TestData("copyright","-o--ri-ht","eansldu",false),
			new TestData("problem","-ro-le-","tanihsd",false), 
			new TestData("form","-o--","etanihs",false),  
			new TestData("problem","-ro-le-","tanihsd",false), 
			new TestData("mythical","--thi-al","eonsrdu",false),
			new TestData("discover","disco-er","tanhlum",false),
			new TestData("consume","-ons--e","taihrld",false), 
			new TestData("document","document","aihsrl",true), 
			new TestData("flame","--a-e","tonihsr",false), 
			new TestData("flow","--o-","etanihs",false),
			new TestData("chart","-hart","eonisld",false),
			new TestData("magnetic","-a-neti-","ohsrldu",false), 
			new TestData("working","-or-in-","etahsld",false),
			new TestData("predict","-redi-t","aonhslu",false),
			new TestData("subordinate","su-ordinate","hlcmwyf",false),
			new TestData("making","-a-in-","etohsrl",false),
			new TestData("copy","-o--","etanihs",false), 
			new TestData("troublemaking","trou-lema-in-","hsdcwyf",false), 
			new TestData("uncopyrighted","uncopyrighted","aslmwf",true), 
			new TestData("unmaledictory","unmaledictory","hsw",true),
			new TestData("unpredictably","un-redicta-ly","ohsmwfg",false)
			};
	
	private final TestData[] dictionary2 = {
			new TestData("unmaledictory","unmaledictory","hsw",true)
			};
	
	private final TestData[] dictionary3 = {
			new TestData("document","document","aihsrl",true)
			};
	
	@Test
	public void testHangman()
	{
		String[] dict = getMysteryWordArray(dictionary);
		Hangman game = new Hangman(dict);
		playGame(game, dictionary);
	}
	
	@Test
	public void testHangmanDocument()
	{
		String[] dict = getMysteryWordArray(dictionary3);
		Hangman game = new Hangman(dict);
		playGame(game, dictionary3);
	}
	
	@Test
	public void testHangmanSingle()
	{
		String[] dict = getMysteryWordArray(dictionary2);
		Hangman game = new Hangman(dict);
		playGame(game, dictionary2);
	}
	
	/**
	 * Takes a TestData[] and generates the String[] of words to be used
	 * by the Hangman game
	 * 
	 * @param data TestData array to generate word list from
	 * @return String array of words for the game. 
	 */
	private String[] getMysteryWordArray(TestData[] data)
	{
		String[] dict = new String[data.length];
		for(int i = 0; i < data.length; i++)
		{
			dict[i] = data[i].getMysteryWord();
		}
		
		return dict;
	}
	
	/**
	 * Helper method that executes an instance of a game
	 * 
	 * @param game Hangman reference
	 * @param expectedMysterWords Number of expected mystery words in the dictionar
	 */
	private void playGame(Hangman game, TestData[] data)
	{
		Random rand = new Random();
		
		String overview = String.format("======================== Play Game ========================");
		trace(overview);
		
		int actualMysterWords = 0;
		int expectedMysterWords = data.length;
		int index = 0;	// index into TestData[] array
		
		// This array is based on the frequency a letter appears, most to least
		char[] seq = {'e','t','a','o','n','i','h','s','r','l','d','u','c','m','w','y','f','g','p','b','v','k','j','x','q','z'};
		
		// this call causes the game to retrieve the first word
		// prior to the first time it is called, no mystery word has been assigned yet
		while(game.getNextMysteryWord())
		{
			TestData curTestData = data[index++];
			actualMysterWords++;
			
			String mysteryWord = game.getMysteryWord();
			String header = String.format("====== Start Mystery word: %s; Mystery word dash: %s ======", mysteryWord, game.getMysteryWordWithDashes());
			trace(header);
			
			int expectedRemainingGuesses =  Hangman.MAX_GUESSES;
			int actualRemainingGuesses = game.getNumberOfGuessesLeft();
			
			assertEquals(String.format("Remaining guesses - expected: %d, actual: %d", expectedRemainingGuesses, actualRemainingGuesses), expectedRemainingGuesses, actualRemainingGuesses, actualMysterWords);
			
			for(char letter : seq)
			{
//				trace("Choosing: " + letter);
				boolean valid = game.isCorrectLetter(letter);
//				trace(String.format("%b - remaining gueses %d, Mystery word dashes: %s", result, game.getNumberOfGuessesLeft(), game.getMysteryWordWithDashes()));
//				trace("Mystery word dashes: " + game.getMysteryWordWithDashes());
				if(valid)
				{
					if(curTestData.getMysteryWord().equals(game.getMysteryWordWithDashes()))
					{
						// we completed the word
						game.isCorrectWord(curTestData.getMysteryWord());
						boolean isWinner = game.isWinner();
						if( isWinner == curTestData.getExpectedResult())
						{
							trace("Won game!! - " + game.getMysteryWordWithDashes());
							break;
						}
					}
				}
				
				if(game.getNumberOfGuessesLeft() == 0)
				{
					trace("Lost game: " + game.getMysteryWordWithDashes());
					break;
				}
			}
			
			String footer = String.format("====== End Mystery word: %s; Mystery word dash: %s; Incorrect letters: %s ======", mysteryWord, game.getMysteryWordWithDashes(), game.getIncorrectLetters().trim());
			trace(footer);
			String errorString = String.format("Error dashed mystery expected: %s, actual: %s", curTestData.getExpectedDash(), game.getMysteryWordWithDashes());
			assertEquals(errorString, game.getMysteryWordWithDashes(), curTestData.getExpectedDash());
			errorString = String.format("Error game result %s, expected: %s, actual: %s", mysteryWord, curTestData.getExpectedResult(), game.isWinner());
			assertTrue(errorString, curTestData.getExpectedResult() == game.isWinner());
			errorString = String.format("Error incorrect letters %s, expected: %s, actual: %s", mysteryWord, curTestData.getExpectedIncorrectLetters(), game.getIncorrectLetters());
			assertEquals(errorString, curTestData.getExpectedIncorrectLetters(),game.getIncorrectLetters());
		}
		
		String summary = String.format("****** Expected Mystery word count: %d;  Actual Mystery word count: %d ******\n", expectedMysterWords, actualMysterWords);
		trace(summary);
	}

	/**
	 * This class encapsulates the test data
	 * It contains the word to test, the expected dashed output and overall result
	 * The unit test defines an array of these TestData objects and iterates
	 * over them.
	 * 
	 * @author Scott LaChance
	 *
	 */
	class TestData
	{
		TestData(String word, String dash, String incorrect, boolean result)
		{
			m_mysteryWord = word;
			m_expectedDash = dash;
			m_expectedIncorrectLetters = incorrect;
			m_expectedResult = result;
		}
		
		public String getMysteryWord(){return m_mysteryWord;}
		public String getExpectedDash(){return m_expectedDash;}
		public String getExpectedIncorrectLetters(){return m_expectedIncorrectLetters;}
		public boolean getExpectedResult(){return m_expectedResult;}
		
		private String m_mysteryWord;
		private String m_expectedDash;
		private String m_expectedIncorrectLetters;
		private boolean m_expectedResult;
	}
}
