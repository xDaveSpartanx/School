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
	public boolean isCorrectLetter(char letter){
		
		boolean result = false;
		// m_currentMysteryWord letter index
		int index = m_currentMysteryWord.indexOf(letter);
		// If index does not equal m_mysteryWordWithDashes index letter
		// 
		if(index != -1)
			{
			
			m_mysteryWordWithDashes.replace(index, index+1, new String(new char[] {letter}));
			result = true;
			}
		else
		{
			m_incorrectLettersGuessed[m_incorrectLettersIndex++] = letter;
			m_remainingGuesses--;
			result = false;
		}
			return result;
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
		// sets 
		m_maxMysteryWords = m_dictionary.length;
		m_isWinner = false;
	}
	
	private void trace(String msg) {
		System.out.println(msg);
	}

	
	// Public Methods
	
	public String getIncorrectLetters() {
		return new String(m_incorrectLettersGuessed).trim();
	}
	public String getMysteryWord() {
		return m_currentMysteryWord;
	}
	public String getMysteryWordWithDashes() {
		return m_mysteryWordWithDashes.toString();
	}
	public boolean getNextMysteryWord() {
			
		boolean result = false;
		
		if(m_currentMysteryWordIndex < m_maxMysteryWords)
		{
			//get the next word on the list, increment the index
			m_currentMysteryWord = m_dictionary[m_currentMysteryWordIndex++];
			
			//size the array that holds incorrect guesses; can't be bigger than MAX_ TRIES
			m_incorrectLettersGuessed = new char[MAX_GUESSES];
			m_incorrectLettersIndex = 0;
			m_isWinner = false;
			
			m_remainingGuesses = MAX_GUESSES;
			
			//build the dashed version of the mystery word
			//this will get updated when a character is selected
			m_mysteryWordWithDashes = new StringBuilder();
			for(int i = 0; i < m_currentMysteryWord.length(); i++)
			{
				m_mysteryWordWithDashes.append("-");
			}
			
			result = true;
		}
		return result;
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
	private int m_maxMysteryWords = 0;
	private StringBuilder m_mysteryWordWithDashes;
	private int m_remainingGuesses = MAX_GUESSES ;

}
