package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TrieNodeTest {
	 TrieNode tester;
	@Before
	public void setUp() {
	
	
	 tester = new TrieNode('a',true,null);
	}
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
// removed to make way for visitor class
//	@Test
//	public void testGetPathway() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsWord() {
		assertTrue(tester.isWord());
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
	//	assertEquals(,tester.getChild('a'));
		
	}

	@Test
	public void testGetLetter() {
		assertEquals('a', tester.getLetter());
	}

	@Test
	public void testSetLetter() {
		tester.setLetter('b');
		
	}

	@Test
	public void testGetLayer() {
		assertEquals(0, tester.layer);
	}

	@Test
	public void testSetLayer() {
		tester.setLayer(10);
		assertEquals(10, tester.getLayer());
		
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

