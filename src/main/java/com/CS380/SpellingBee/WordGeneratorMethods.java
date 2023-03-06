package com.CS380.SpellingBee;

import java.util.ArrayList;

public interface WordGeneratorMethods {
	
	public TrieVisitor createDailyWords();
	
	/**
	 * Selects a random word from the list of words with 7 unique letters and returns it
	 * @return
	 */
	public String selectMainWord();

	public ArrayList<String> getDailyWords();
	public TrieVisitor getAllWords();
	public void setDailyWords(ArrayList<String> dailyWords);
	public void setAllWords(TrieVisitor allWords);
}
