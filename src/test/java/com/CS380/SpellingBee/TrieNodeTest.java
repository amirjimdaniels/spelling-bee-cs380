package com.CS380.SpellingBee;

import static org.junit.Assert.*;

import org.junit.Test;

<<<<<<< HEAD:src/test/java/com/CS380/SpellingBee/NodeTest.java
public class NodeTest {
	Node tester = new Node('a',true,null);
=======
public class TrieNodeTest {
	TrieNode tester = new TrieNode('a',true,null);
>>>>>>> 1b1c6a393ced561b091d2228bec224b4b0ecb850:src/test/java/com/CS380/SpellingBee/TrieNodeTest.java
	

	@Test
	public void testNodeCharBooleanNode() {
		Node tester = new Node('a',true,null);
		assertNotNull(tester);
		assertEquals(tester.letter, 'a');
		assertEquals(tester.word,true);
		assertNull(tester.parent);
	}

	@Test
	public void testNode() {
		Node node = new Node();
		assertNotNull(node);
		assertEquals(node.getLayer(), 0);

	

	}

	@Test
	public void testNodeNode() {
		Node branch= new Node(tester);
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

