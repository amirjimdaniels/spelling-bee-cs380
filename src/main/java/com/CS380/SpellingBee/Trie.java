package com.CS380.SpellingBee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

public class Trie implements TrieMethods {
	/**
	 * Root node of the tree, has a layer of 0 and a parent of null
	 */
	Node root;
	/**
	 * Variable to keep track to the number of words contained within the Trie
	 */
	int numWordsInTrie;

	/**
	 * Creates a new Trie with a blank root note with layer = 0
	 */
	public Trie () {
		
		root = new Node();
		
	}

	
	@Override
	public boolean addWord(String input) {
		/*
		 * takes in String and turns into character array
		 * iterates through creating nodes where ones do not already exists 
		 * sets final node.word to true
		 */
		Node current = this.root;
		
		char[] working= input.toCharArray();
		
		for (int i=0; i<working.length; i++) {
			
			if (current.hasChild(working[i])) {
				
				current = current.getChild(working[i]);
				
			} else {
				
				current = current.setChild(new Node(working[i], false, current));
				
			}
		}
		
		current.setWord(true);

		numWordsInTrie++;
		
		return current.isWord();
	}

	@Override
	public void addWords(String... wordsIn) {
		for (String word: wordsIn) {
			addWord(word);
		}

	}
	
	/**
	 * Checks rWord using containsWord
	 * if node exists sets node word boolean to false and returns true
	 * else returns false. 
	 *
	 */
	@Override
	public boolean removeWord(String rWord) {
		
		Node endOfWord = this.containsWord(rWord);	// use containedWord to get the lowest node in the word if it exists
		
		
		if (endOfWord == null) return false; 		// if the word is not in the set, return
		else endOfWord.word=false;
		return true;
		
		
	}

	/**
	 * Assumes the input stream contains words seperated by a newline character
	 * @param inStream ReaderStream
	 * @throws IOException 
	 */
	@Override
	public void addWordsFromStream(Reader inStream) throws IOException {
		
		BufferedReader daReader = new BufferedReader(inStream);

		String word = daReader.readLine();		// this makes the assumption that the input in the stream is seperated by newline characters

		while (word != null) {
			addWord(word);
			word = daReader.readLine();
		}
	}

	/**
	 * Checks if the given node is the end of a word
	 */
	@Override
	public boolean isWord(Node currentNode) {
		return currentNode.isWord();
	}

	@Override
	public int numWordsContained() {
		return numWordsInTrie;
	}

	@Override
	public Node containsWord(String cWord) {
		
		Node current = root;
		int i = 0;
		char[] wordArray = cWord.toCharArray();
		
		while (i < wordArray.length && current.hasChild(wordArray[i])) {
			current = current.getChild(wordArray[i]);
			i++;
		}
		
		if (i < wordArray.length) {
			return null;
		} else if (current.isWord()) {
			return current;
		} else { return null; }
		
	}

	

}