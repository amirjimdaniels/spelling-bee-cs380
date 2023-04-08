package com.CS380.SpellingBee;

import java.util.ArrayList;
import java.util.List;

public interface WordGeneratorMethods {
	
	/**
	 * Main functional method for creating the daily words list
	 * @return
	 */
	public TrieVisitor createDailyWords();
	
	/**
	 * Main functional method, but allows the user to specify the daily word
	 * @return
	 */
	public TrieVisitor createDailyWordsFromWord(String word) throws IllegalArgumentException;
	
	/**
	 * Selects a random word from the list of words with 7 unique letters and returns it
	 * @return
	 */
	public String selectMainWord();
	
	/**
	 * Finds all words that could be the pangram for the day
	 * @return
	 */
	public ArrayList<String> getEligibleWords();
	
	/**
	 * Getter for daily words list
	 * @return Dailywords as List
	 */
	public List<String> getDailyWordsAsList();
	
	/**
	 * Getter for daily words as TrieVisitor
	 * @return
	 */
	public TrieVisitor getDailyWords();
	
	/**
	 * Getter for allWords TrieVisitor (in case you want to check)
	 * @return
	 */
	public TrieVisitor getAllWords();
	
	/**
	 * Set the dailywords trie from an arraylist
	 * @param dailyWords
	 */
	public void setDailyWordsFromList(ArrayList<String> dailyWords);
	
	/**
	 * Set the dailywords Trie
	 * @param dailyWords
	 */
	public void setDailyWords(TrieVisitor dailyWords);
	
	/**
	 * Set the dailywords from a pre-existing trie
	 * @param dailyWords
	 */
	public void setDailyTrie(Trie dailyWords);
	
	/**
	 * sets our allwords trievisitor
	 * @param allWords
	 */
	public void setAllWords(TrieVisitor allWords);
}
