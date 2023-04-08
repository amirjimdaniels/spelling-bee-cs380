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
		assertEquals(0, tr.maxDepth);
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
	public void testAddWordAndContainsRandomWords() {
		String[] strings = new String[100];
		
		for (int i = 0; i < strings.length; i++) {
			strings[i] = Magic.generateRandomWordOfLength((int) (100*Math.random()));
			tester.addWord(strings[i]);
			System.out.println(strings[i]);
		}
		
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].length() >= App.MINIMUM_WORD_LENGTH) {
				assertNotNull(tester.containsWord(strings[i]));
				assertEquals(strings[i].charAt(strings[i].length() - 1), tester.containsWord(strings[i]).letter);
			}
		}
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
	public void testNumWordsContained() {
		tester.numWordsInTrie = 1;
		
		assertEquals(1, tester.numWordsContained());
	}
	
	@Test
	public void testNumWordsContainedThroughAddsAndRemoves() {
		tester.addWord("cooling");
		assertEquals(1, tester.numWordsContained());
		
		tester.addWords("ball", "football", "duck");
		
		assertEquals(4, tester.numWordsContained());
		
		tester.removeWord("ball");
		
		assertEquals(3, tester.numWordsContained());
		
		tester.removeWord("");		// make sure the function doesn't do it unles sit actually removes soemthing
		
		assertEquals(3, tester.numWordsContained());
		
		tester.removeWord("ducks");
		
		assertEquals(3, tester.numWordsContained());
		
		tester.removeWord("duck");
		
		assertEquals(2, tester.numWordsContained());
	}

	@Test
	public void testContainsWordEmptyList() {
		assertNull(tester.containsWord("duck"));
	}
	
	@Test
	public void testContainsWordEmptyListNull() {
		assertNull(tester.containsWord(null));
	}
	
	@Test
	public void testContainsWordEmptyListEmptyString() {
		assertNull(tester.containsWord(""));
	}
	
	@Test
	public void testContainsWordOneWordInListNotContained() {
		tester.numWordsInTrie++;
		assertNull(tester.containsWord("duck"));
	}
	
	@Test
	public void testContainsWordOneWordInListNull() {
		tester.numWordsInTrie++;
		assertNull(tester.containsWord(null));
	}
	
	@Test
	public void testContainsWordOneWordInListEmptyString() {
		tester.numWordsInTrie++;
		assertNull(tester.containsWord(""));
	}
	
	@Test
	public void testContainsWordOneWordInListContained() {
		tester.numWordsInTrie++;
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		
		assertNotNull(tester.containsWord("bird"));
		
		TrieNode returnedNode = tester.containsWord("bird");
		
		assertEquals('d', returnedNode.getLetter());
		assertEquals(4, returnedNode.getLayer());
		assertEquals('r', returnedNode.getParent().getLetter());		// that's probably enough
	}
	
	@Test
	public void testContainsWordOneWordInListContainedCapitalization() {
		tester.numWordsInTrie++;
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		
		assertNotNull(tester.containsWord("BiRd"));
		assertNotNull(tester.containsWord("BIRD"));
		assertNotNull(tester.containsWord("bIRD"));
		assertNotNull(tester.containsWord("BIRd"));
	}
	
	@Test
	public void testContainsWordOneWordInListFormerlyContained() {
		tester.numWordsInTrie++;
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', false, null));
		
		
		assertNull(tester.containsWord("bird"));
	}
	
	@Test
	public void testContainsWordTwoWordInList() {
		tester.numWordsInTrie += 2;
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		TrieNode current2 = tester.root.setChild(new TrieNode('r', false, null));
		current2 = current2.setChild(new TrieNode('o', false, null));
		current2 = current2.setChild(new TrieNode('c', false, null));
		current2 = current2.setChild(new TrieNode('k', true, null));
		
		
		assertNotNull(tester.containsWord("bird"));
		assertNotNull(tester.containsWord("rock"));
		assertNull(tester.containsWord("birds"));
	}
	
	
	@Test
	public void testContainsWordWithAddsAndRemoves() {
		
		tester.addWord("birds");
		
		assertNull(tester.containsWord("bird"));
		assertNull(tester.containsWord("rock"));
		assertNotNull(tester.containsWord("birds"));
		
		tester.addWords("bird", "rock");
		
		
		assertNotNull(tester.containsWord("bird"));
		assertNotNull(tester.containsWord("rock"));
		assertNotNull(tester.containsWord("birds"));
		
		tester.removeWord("birds");
		
		assertNotNull(tester.containsWord("bird"));
		assertNotNull(tester.containsWord("rock"));
		assertNull(tester.containsWord("birds"));
		
		tester.removeWord("bird");
		tester.removeWord("rock");
		
		assertNull(tester.containsWord("bird"));
		assertNull(tester.containsWord("rock"));
		assertNull(tester.containsWord("birds"));
		
	}
	
	@Test
	public void testGetMaxDepth() {
		assertEquals(0, tester.getMaxDepth());
		
		tester.maxDepth = 4;
		
		assertEquals(4, tester.getMaxDepth());
	}
	
	@Test
	public void testGetMaxDepthAfterAdd() {
		tester.addWord("bird");
		
		assertEquals(4, tester.getMaxDepth());
	}
	
	@Test
	public void testGetMaxDepthAfterRemove() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		tester.removeWord("bird");
		
		assertEquals(4, tester.getMaxDepth());
	}
	
	@Test
	public void testGetMaxDepthWithAddsAndRemoves() {
		
		tester.addWord("bird");
		
		assertEquals(4, tester.getMaxDepth());
		
		tester.removeWord("bird");
		
		assertEquals(0, tester.getMaxDepth());
		
		tester.addWords("bird", "birds", "train", "busses");
		
		assertEquals(6, tester.getMaxDepth());
	}
	
	@Test
	public void testSetMaxDepth() {
		assertEquals(0, tester.maxDepth);
		
		tester.setMaxDepth(4);
		
		assertEquals(4, tester.maxDepth);
		
		
		tester.setMaxDepth(7);
		
		assertEquals(7, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthEmptyList() {
		tester.fixupMaxDepth();
		
		assertEquals(0, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthOneElementFourDeep() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		
		tester.fixupMaxDepth();
		
		assertEquals(4, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthOneElementSevenLong() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('e', false, null));
		current = current.setChild(new TrieNode('s', true, null));
		
		
		tester.fixupMaxDepth();
		
		assertEquals(7, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthTwoElementDuplicatePathsFindLonger() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('e', false, null));
		current = current.setChild(new TrieNode('s', true, null));
		
		
		tester.fixupMaxDepth();
		
		assertEquals(7, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthTwoElement() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		
		TrieNode current2 = tester.root.setChild(new TrieNode('r', false, null));
		current2 = current2.setChild(new TrieNode('o', false, null));
		current2 = current2.setChild(new TrieNode('c', false, null));
		current2 = current2.setChild(new TrieNode('k', false, null));
		current2 = current2.setChild(new TrieNode('s', true, null));
		
		
		tester.fixupMaxDepth();
		
		assertEquals(5, tester.maxDepth);
	}
	
	@Test
	public void testFixupMaxDepthThroughAdds() {
		
		tester.addWord("brock");
		
		assertEquals(5, tester.maxDepth);
		
		tester.addWord("ruthless");
		
		assertEquals(8, tester.maxDepth);
	}
	
	
	@Test
	public void testFixupMaxDepthThroughRemoves() {
		
		TrieNode current = tester.root.setChild(new TrieNode('b', false, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('d', true, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('e', false, null));
		current = current.setChild(new TrieNode('s', true, null));
		
		current = tester.root.setChild(new TrieNode('r', false, null));
		current = current.setChild(new TrieNode('o', false, null));
		current = current.setChild(new TrieNode('c', false, null));
		current = current.setChild(new TrieNode('k', true, null));
		current = current.setChild(new TrieNode('i', false, null));
		current = current.setChild(new TrieNode('e', false, null));
		current = current.setChild(new TrieNode('s', true, null));
		
		tester.maxDepth = 7;
		
		tester.removeWord("bird");
		
		assertEquals(7, tester.maxDepth);
		
		tester.removeWord("ruthless");
		
		assertEquals(7, tester.maxDepth);
		
		tester.removeWord("rockies");
		
		assertEquals(7, tester.maxDepth);
		
		tester.removeWord("birdies");
		
		assertEquals(4, tester.maxDepth);
		
		tester.removeWord("rock");
		
		assertEquals(4, tester.maxDepth);
		
		tester.removeWord("bird");
		
		assertEquals(0, tester.maxDepth);
	}
	
	
	@Test
	public void testAllOfThem() {
		
		assertEquals(0, tester.numWordsContained());
		
		tester.addWord("birds");
		
		assertNull(tester.containsWord("bird"));
		assertNull(tester.containsWord("rock"));
		assertNotNull(tester.containsWord("birds"));
		assertEquals(1, tester.numWordsContained());
		assertEquals(5, tester.getMaxDepth());
		
		tester.addWords("bird", "rock");
		
		
		assertNotNull(tester.containsWord("bird"));
		assertNotNull(tester.containsWord("rock"));
		assertNotNull(tester.containsWord("birds"));
		assertEquals(3, tester.numWordsContained());
		assertEquals(5, tester.getMaxDepth());
		
		tester.removeWord("birds");
		
		assertNotNull(tester.containsWord("bird"));
		assertNotNull(tester.containsWord("rock"));
		assertNull(tester.containsWord("birds"));
		assertEquals(2, tester.numWordsContained());
		assertEquals(4, tester.getMaxDepth());
		
		tester.removeWord("bird");
		tester.removeWord("rock");
		
		assertNull(tester.containsWord("bird"));
		assertNull(tester.containsWord("rock"));
		assertNull(tester.containsWord("birds"));
		assertEquals(0, tester.numWordsContained());
		assertEquals(0, tester.getMaxDepth());
		
	}
	
	
	
	

}
