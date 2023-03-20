package com.CS380.SpellingBee;
import java.io.IOException;
import java.io.Reader;

public interface TrieMethods {

	
		/**
		 * Throw that false value if the word is already contained
		 * @param input
		 * @return
		 */
		public boolean addWord(String input);
		/**
		 * takes a list of words and adds them using iterative addWord
		 * @param wordsIn
		 */
		
		public void addWords(String... wordsIn);
		
		/**
		 * Assumes the input stream contains words seperated by a newline character
		 * @param inStream ReaderStream
		 */
		void addWordsFromStream(Reader inStream) throws IOException ;

		/**
		 * Remove a given word from the trie.
		 * @param rWord
		 * @return true if successfully remove, false if not
		 */
		public boolean removeWord(String rWord);

		/**
		 * Check if the node is a word
		 * @param currentNode
		 * @return
		 */
		public boolean isWord(TrieNode currentNode);

		/**
		 * Keep tabs on how many words are in the trie
		 * @return
		 */
		public int numWordsContained();
		
		/**
		 * Check if a word is in the trie
		 * @param cWord
		 * @return
		 */
		public TrieNode containsWord(String cWord);

		


		
		
	}



