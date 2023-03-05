package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrieTest {
	Trie tester;
	
	@Before
	public void setUp() {
		tester = new Trie();
	}
	
	
	@Test
	public void testTrie() {
		Trie tr = new Trie();
		assertNotNull(tr);
		assertNotNull(tr.root);
		assertEquals(0, tr.root.layer);
		assertNull(tr.root.parent);
		assertEquals(0, tr.root.letter);
	}

	@Test
	public void testAddWord() {
		tester.addWord("duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);		//best method that uses no aditional method
		
	}

	@Test
	public void testAddWords() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveWord() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddWordsFromStream() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIsWord() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testNumWordsContained() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testContainsWord() {
		fail("Not yet implemented"); // TODO
	}

}
