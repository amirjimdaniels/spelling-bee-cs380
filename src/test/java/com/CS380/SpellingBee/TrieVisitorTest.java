/**
 * 
 */
package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



/**
 * @author ac-student
 *
 */
public class TrieVisitorTest {
	@Before
	public void setUp() {
		
	
	Trie wordSet= new Trie();
	TrieVisitor tester = new TrieVisitor(wordSet);
	
	String[] myWords= {"duck","goblin","horse","aaaa", "abcd"};
	
	wordSet.addWords(myWords);
	}
	

	@Test
	public void getWordsFromTest() {
		
		;
	}
	@Test
	public void getPathwayTest() {
		;
	}
	@Test
	public void walkDownTest() {
		;
	}
	@Test
	public void walkUpTest() {
		;
	}
	@Test
	public void getWordTest() {
		;
	}
	@Test
	public void  wordsOfLengthTest() {
		;
	}
	@Test
	public void getMaxDepthTest() {
		;
	}

}
