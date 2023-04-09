package com.CS380.SpellingBee;

/**
 * Interface for the Game class, has basic game logic method stubs
 */
public interface GameLogic {

public boolean isCorrectWordLength(String word);

public boolean containsCenterLetter(String word, char center);

public void createPangram(String[] listOfLetters);

public boolean isPangram (String word, String [] listOfLetters);
	
}
