/**
 * @author David Rios
 *
 */
package week03;

public class Hangman {

	// Constructors
	
	public Hangman(String[] dictonary) {
		m_dictionary = dictonary ;
		initialize();	
	}

		
		// Public Methods
	public boolean isCorrectLetter(char cc){
		
		boolean result = false;
		int index =
		int index = m_currentMysteryWord.indexOf(m_currentMysteryWordIndex);
		if(index != m_mysteryWordWithDashes.indexOf(m_currentMysteryWord))
			{
			m_mysteryWordWithDashes.trimToSize();
			result = true;
			}
		else
		{
			m_incorrectLettersGuessed[m_incorrectLettersIndex++]  ;
			m_remainingGuesses--;
			result = false;
		}
			
	}
	
	public boolean isCorrectWord(String word) {
		if(m_currentMysteryWord.equals(word)) {
			return m_isWinner = true;
		}
		return m_isWinner;
	}
	
	public boolean isWinner() {
		return m_isWinner;
	}
	// Protected Methods
	
	// Private Methods
	
	private void initialize() {
		
	}
	
	private void trace() {
		
	}

	
	// Public Methods
	
	public char[] getIncorrectLetters() {
		return m_incorrectLettersGuessed;
	}
	public String getMysteryWord() {
		return m_currentMysteryWord;
	}
	public StringBuilder getMysteryWordWithDashes() {
		return m_mysteryWordWithDashes;
	}
	public boolean getNextMysteryWord() {
			
		boolean result = false;
		
		if(m_currentMysteryWordIndex < maxMysteryWords)
		{
			//get the next word ion the list, increment the index
			m_currentMysteryWord = m_dictionary[m_currentMysteryWordIndex++];
			
			//size the array that holds incorrect guesses; can't be bigger than MAX_ TRIES
			m_incorrectLettersGuessed = new char[MAX_GUESSES];
			m_incorrectLettersIndex = 0;
			m_isWinner = false;
			
			//build the dashed version of the mystery word
			//this will get updated when a character is selected
			m_mysteryWordWithDashes = new StringBulder();
			for(int i = 0; i < m_currentMysteryWord.length(); i++)
			{
				m_mysteryWordWithDashes.append("-");
			}
		}
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
