package com.CS380.SpellingBee;

public interface GameLogic {

public boolean isCorrectWordLength(String word);

public boolean containsCenterLetter(String word, char center);

public void createPangram(String[] listOfLetters);

public boolean isPangram (String word, String [] listOfLetters);
	
}
