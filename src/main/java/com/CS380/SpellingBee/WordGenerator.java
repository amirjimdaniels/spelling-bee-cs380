package com.CS380.SpellingBee;

import java.util.ArrayList;
import java.util.List;

public class WordGenerator implements WordGeneratorMethods {
	
	/**
	 * TrieVisitor containing all of the words for the day
	 */
	TrieVisitor allWords;
	
	/**
	 * Store the words after generating
	 */
	TrieVisitor dailyWords;
	
	public WordGenerator(TrieVisitor allWords) {
		this.allWords = allWords;
		this.dailyWords = createDailyWords();
	}
	

	@Override
	public TrieVisitor createDailyWords() {
		String primaryWord = this.selectMainWord();
		
		return createDailyWordsFromWord(primaryWord);
	}
	
	@Override
	public TrieVisitor createDailyWordsFromWord(String word) throws IllegalArgumentException {
		
		Trie wordLetters = new Trie();
		
		word = Magic.uniqueCharactersOnlyOf(word);
		
		if (word.length() < 7) throw new IllegalArgumentException("Word does not have enough letters to create the daily list. It needs 7 letters, and has "+ word.length());
		
		wordLetters.addWords(allWords.getWordsFrom(word));
		
		TrieVisitor rtn = new TrieVisitor(wordLetters);
		
		return rtn;
	}
	

	@Override
	public String selectMainWord() {
		
		ArrayList<String> eligibleWords = getEligibleWords(); //generate all eligible words (7 unique letters)
		
		String selectedWord = eligibleWords.get((int)(Math.random()*eligibleWords.size())); //get a random word from the eligible list
		
		return selectedWord; //return the selected word
		
	}

	@Override
	public ArrayList<String> getEligibleWords() {
		ArrayList<String> eligibleWords = new ArrayList<>();
		for (int i = 7; i < allWords.getMaxDepth(); i++) {
			String[] tempList = allWords.wordsOfLength(i);
			for (String word : tempList) {
				eligibleWords.add(word);
			}
		}
		
		return eligibleWords;
	}

	@Override
	public List<String> getDailyWordsAsList() {
		ArrayList<String> rtnList = new ArrayList<>();
		for (String str : dailyWords.getAllWords()) {			// I don't think this is the intended functionality
			rtnList.add(str);
		}
		
		return rtnList;
	}

	@Override
	public TrieVisitor getDailyWords() {
		return this.dailyWords;
	}

	@Override
	public TrieVisitor getAllWords() {
		return this.allWords;
	}

	@Override
	public void setDailyWordsFromList(ArrayList<String> dailyWords) {
		Trie newTrie = new Trie();
		newTrie.addWords(dailyWords.toArray(new String[0]));
		this.dailyWords = new TrieVisitor(newTrie);
	}

	@Override
	public void setDailyWords(TrieVisitor dailyWords) {
		this.dailyWords = dailyWords;
	}

	@Override
	public void setDailyTrie(Trie dailyWords) {
		this.dailyWords = new TrieVisitor(dailyWords);
	}

	@Override
	public void setAllWords(TrieVisitor allWords) {
		this.allWords = allWords;
	}


}
