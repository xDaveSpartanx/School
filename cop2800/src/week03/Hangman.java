
package week03;

public class Hangman {

	// Constructors
	
	public Hangman(String m_currentMysteryWord, int m_currentMysteryWordIndex, String m_dictionary) {
		this.initialize();
		this.m_currentMysteryWord = m_currentMysteryWord;
		this.m_currentMysteryWordIndex = m_currentMysteryWordIndex -1;
		this.m_dictionary = m_dictionary;
	}
	
/*
	public boolean isCorrectLetter() {
		
	}
	
	public String isCorrectWord() {
		
	}

	public boolean isWinner() {
		
		
	}
*/
	
	// Public Methods
	
	// Protected Methods
	
	// Private Methods
	
	private void initialize() {
		
	}
	
/*	private void trace() {
		
	}
*/
	
	// Public Methods
	
	public char[] getIncorrectLetters() {
		return m_incorrectLettersGuessed;
	}
	public String getMysteryWord() {
		return this.m_currentMysteryWord;
	}
	public StringBuilder getMysteryWordWithDashes() {
		return m_mysteryWordWithDashes;
	}
	public int getNextMysteryWord() {
		return m_currentMysteryWordIndex++;
	}
 	public int getNumberOfGuessesLeft() {
		return m_remainingGuesses;
	}

	
		
	// Public Constants
		public static final int MAX_GUESSES = 7;
		

	// Private data
	private String m_currentMysteryWord;
	private int m_currentMysteryWordIndex = 0;
	private String[] m_dictionary;
	private char[] m_incorrectLettersGuessed;
	private int m_incorrectLettersIndex;
	private boolean m_isWinner;
	private int maxMysteryWords = 0;
	private StringBuilder m_mysteryWordWithDashes;
	private int m_remainingGuesses = MAX_GUESSES ;

}
