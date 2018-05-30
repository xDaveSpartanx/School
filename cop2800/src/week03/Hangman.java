
package week03;



public class Hangman {
	
	// Constructors
	
	
	
	// Public Methods
	
	// Protected Methods
	
	// Private Methods
		
	// Public Methods
	
	// Public Constants
		public static final int MAX_GUESSES = 7;
		
		// Private data
		private String m_currentMysteryWord;
		private int m_currentMysteryWordIndex = 0;
		private String m_dicrtionary;
		private char m_incorrectLettersGuessed;
		private int m_incorrectLettersIndex;
		private boolean m_isWinner;
		private int maxMysteryWords = 0;
		private StringBuilder m_mysteryWordWithDashes;
		private int m_remainingGuesses = MAX_GUESSES;

}
