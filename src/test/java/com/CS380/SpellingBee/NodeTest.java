package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {
	TrieNode tester = new TrieNode('a',true,null);
	

	@Test
	public void testNodeCharBooleanNode() {
		TrieNode tester = new TrieNode('a',true,null);
		assertNotNull(tester);
		assertEquals(tester.letter, 'a');
		assertEquals(tester.word,true);
		assertNull(tester.parent);
	}

	@Test
	public void testNode() {
		TrieNode node = new TrieNode();
		assertNotNull(node);
		assertEquals(node.getLayer(), 0);

	

	}

	@Test
	public void testNodeNode() {
		TrieNode branch= new TrieNode(tester);
		assertEquals(branch.layer, 1);
		assertTrue(branch.parent.equals(tester));
	}

	@Test
	public void testGetPathway() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWord() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasChild() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetChild() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveChild() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChild() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLetter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLetter() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetParent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetChilds() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetChilds() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWord() {
		
		fail("Not yet implemented");
	
}

}

