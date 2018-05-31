
package week03;



public class Hangman {
	
	// Constructors
	
	
	
	public String Hangman() {
		
	}
	
	public boolean isCorrectLetter(char) {
		
	}
	
	public String isCorrectWord(String) {
		
	}
	
	public boolean isWinner() {
		
	}
	
	
	
	
	// Public Methods
	
	// Protected Methods
	
	// Private Methods
	
private void initialize() {
		
	}
	
	private void trace(String) {
		
	}
	
	// Public Methods
	
	public char getM_incorrectLetters() {
		return m_incorrectLettersGuessed;
	}
	public StringBuilder getM_mysteryWordWithDashes() {
		return m_mysteryWordWithDashes;
	}
	public String get_MysteryWord() {
		return m_currentMysteryWord;
	}
	public int getM_NextMysteryWord() {
		return m_currentMysteryWordIndex++;
	}
	
	
	
		
	// Public Constants
		public static final int MAX_GUESSES = 7;
		
		
	}
		// Private data
		private String m_currentMysteryWord = "";
		private int m_currentMysteryWordIndex = 0;
		private String m_dictionary;
		private char m_incorrectLettersGuessed;
		private int m_incorrectLettersIndex;
		private boolean m_isWinner;
		private int maxMysteryWords = 0;
		private StringBuilder m_mysteryWordWithDashes;
		private int m_remainingGuesses = MAX_GUESSES ;

}
