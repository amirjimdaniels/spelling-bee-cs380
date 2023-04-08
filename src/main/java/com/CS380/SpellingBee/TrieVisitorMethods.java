package com.CS380.SpellingBee;

import java.util.ArrayList;

public interface TrieVisitorMethods {
	
	
	/**
	 * walks back up trie and returns array of nodes 
	 * @param node
	 * @return
	 */
	public TrieNode[] getPathway(TrieNode node); 
	public ArrayList<String> getAllWords();
	public String[] getWordsFrom(String Letters);
	public TrieNode walkDown();
	public TrieNode walkUp();
	public String getWord();
	public String[] wordsOfLength(int length);
	public int getMaxDepth();
}
