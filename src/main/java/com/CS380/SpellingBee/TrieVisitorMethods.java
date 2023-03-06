package com.CS380.SpellingBee;

public interface TrieVisitorMethods {
	
	
	
	public TrieNode[] getPathway(TrieNode node); 
	public String[] getWordsFrom(String Letters);
	public TrieNode walkDown();
	public TrieNode walkUp();
	public String getWord();
	public String[] wordsOfLength(int length);
	public int getMaxDepth();
}
