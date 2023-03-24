package com.CS380.SpellingBee;

import java.util.ArrayList;

// TODO: Empty for now

/**
 * the TrieVisitor is the Object responsible for walking the Trie and pulling
 * words from nodes
 * 
 * 
 * 
 * @author kieran leahy
 *
 */

public class TrieVisitor implements TrieVisitorMethods {
	Trie myTrie;
	TrieNode current;

	public TrieVisitor(Trie myTrie) {
		this.myTrie = myTrie;
		this.current = myTrie.root;
	}

	/**
	 * Returns the pathways as a list of nodes (for removing words/working within
	 * the list)
	 * 
	 * @return Pathway down to this node through the trie
	 */

	public TrieNode[] getPathway(TrieNode node) {
		ArrayList<TrieNode> pathway = new ArrayList<>();
		TrieNode current = node;
		while (current.layer > 0) {// avoid grabbing the root node (we need that pristine)

			if (current.letter == 0)// added to protect from adding fake nodes;
				current = current.getParent();

			else {
				pathway.add(current.getLayer() - 1, current); // adds to the corresponding ArrayList location (0
																// indexed, so layer-1 since the smallest layer will be
																// 1)
				current = current.getParent(); // walk up the tree
			}
		}

		return pathway.toArray(new TrieNode[0]); // convert to an array of type TrieNode
	}

	@Override
	public String[] getWordsFrom(String Letters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrieNode walkDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrieNode walkUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] wordsOfLength(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxDepth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getAllWords() {
		// TODO Auto-generated method stub
		return null;
	}
}
