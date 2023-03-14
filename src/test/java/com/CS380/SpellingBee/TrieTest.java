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
		assertArrayEquals(new TrieNode[26], tr.root.childs);
	}

	@Test
	public void testAddWord() {
		tester.addWord("duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);	//best method that uses no additional method
	}
	
	@Test
	public void testAddWordDuplicateAdds() {
		tester.addWord("duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);	//best method that uses no additional method
		tester.addWord("duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
	}
	
	@Test
	public void testAddWordNullWord() {
		assertFalse(tester.addWord(null));
	}
	
	@Test
	public void testAddWordNotAlphabet1() {
		assertFalse(tester.addWord(";9omp"));
	}
	
	@Test
	public void testAddWordNotAlphabet2() {
		assertFalse(tester.addWord("this has a space"));
	}
	
	@Test
	public void testAddWordNotAlphabet3() {
		assertFalse(tester.addWord("this6"));
	}
	
	@Test
	public void testAddWordValidWordCapital() {
		assertTrue(tester.addWord("Bread"));
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);
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
