package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

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
		assertTrue(tester.addWord("duck"));
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);	//best method that uses no additional method
		assertFalse(tester.addWord("duck"));
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
	}
	@Test
	public void testAddWordTwoAdds() {
		tester.addWord("duck");
		tester.addWord("bread");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);
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
	public void testAddWordsSingle() {
		tester.addWords("bread");
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);
	}
	
	@Test
	public void testAddWordsSingleTwice() {
		tester.addWords("bread");
		tester.addWords("duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);
	}
	
	@Test
	public void testAddWordsTwoWords() {
		tester.addWords("bread", "duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);
	}
	
	@Test
	public void testAddWordsDuplicateWords() {
		tester.addWords("duck", "duck");
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
	}
	
	@Test
	public void testAddWordsNull() {
		tester.addWords(null);
	}
	
	@Test
	public void testAddWordsListOfNull() {
		tester.addWords(null, null, null);
	}
	
	@Test
	public void testAddWordsListOfNullAndNonNull() {
		tester.addWords(null, "duck", null);
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);
	}

	@Test
	public void testRemoveWordEmptyListNotContained() {
		assertFalse(tester.removeWord("bull"));
	}
	
	@Test
	public void testRemoveWordEmptyListNull() {
		assertFalse(tester.removeWord(null));
	}
	
	@Test
	public void testRemoveWordEmptyListEmptyString() {
		assertFalse(tester.removeWord(""));
	}
	
	@Test
	public void testRemoveWordEmptyListNotContainedButWordInTrie() {
		tester.numWordsInTrie++;
		assertFalse(tester.removeWord("bull"));
	}
	
	@Test
	public void testRemoveWordEmptyListNullButWordInTrie() {
		tester.numWordsInTrie++;
		assertFalse(tester.removeWord(null));
	}
	
	@Test
	public void testRemoveWordEmptyListEmptyStringButWordInTrie() {
		tester.numWordsInTrie++;
		assertFalse(tester.removeWord(""));
	}
	
	@Test
	public void testRemoveWordInList() {
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		tester.numWordsInTrie++;
		
		assertTrue(tester.removeWord("bird"));
		assertFalse(current.word);
	}
	
	@Test
	public void testRemoveWordNotInListButWordWas() {
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', false, null));
		
		assertFalse(tester.removeWord("bird"));
		assertFalse(current.word);
	}
	
	@Test
	public void testAddWordAndRemove() {
		assertTrue(tester.addWord("bird"));
		
		assertTrue(tester.removeWord("bird"));
	}
	
	@Test
	public void testAddWordAndRemoveTwice() {
		assertTrue(tester.addWord("bird"));
		
		assertTrue(tester.removeWord("bird"));
		
		assertTrue(tester.addWord("bird"));
		
		assertTrue(tester.removeWord("bird"));
	}
	
	@Test
	public void testAddWordsAndRemove() {
		tester.addWords("bread", "duck");
		
		assertFalse(tester.removeWord("bird"));
		
		assertTrue(tester.addWord("bird"));
		
		assertTrue(tester.removeWord("bird"));
		
		assertTrue(tester.removeWord("duck"));
		
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);		// ensure bread is contained
		
		assertFalse(tester.root.childs[3].childs[20].childs[2].childs[10].word);		// ensure duck is not contained
	}
	

	@Test
	public void testAddWordsFromStream() throws IOException {
		String[] strings = {"duck", "bread"};
		BufferedReader buffer = new BufferedReader( new StringReader(  String.join(  "\n", strings  )) );		// add words from strings to a bufferedreader
		tester.addWordsFromStream(buffer);
		
		
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);		// ensure bread is contained
		
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);		// ensure duck is contained
		
	}
	
	@Test
	public void testAddWordsFromStreamNullValues() throws IOException {
		String[] strings = {"duck", "bread", ""};
		BufferedReader buffer = new BufferedReader( new StringReader(  String.join(  "\n", strings  )) );		// add words from strings to a bufferedreader
		tester.addWordsFromStream(buffer);
		
		assertTrue(tester.root.childs[3].childs[20].childs[2].childs[10].word);		// ensure duck is contained
		
		assertTrue(tester.root.childs[1].childs[17].childs[4].childs[0].childs[3].word);		// ensure bread is contained
		
		
		
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
