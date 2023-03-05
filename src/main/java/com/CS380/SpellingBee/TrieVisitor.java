package com.CS380.SpellingBee;

import java.util.ArrayList;

// TODO: Empty for now








/*
 * 
 * 
 * 
 * PLACEHOLDER
 * 
 * 
 * 
 * 
 */







public class TrieVisitor {
	
	/**
	 * Returns the pathways as a list of nodes (for removing words/working within the list)
	 * 
	 * @return Pathway down to this node through the trie
	 */
	public TrieNode[] getPathway(TrieNode node) {
		ArrayList<TrieNode> pathway = new ArrayList<>();
		TrieNode current = node;
		while (current.layer > 0) {							// avoid grabbing the root node (we need that pristine)
			pathway.add(current.getLayer() - 1, current);	// adds to the corresponding ArrayList location (0 indexed, so layer-1 since the smallest layer will be 1)
			current = current.getParent();					// walk up the tree
		}
		
		return pathway.toArray(new TrieNode[0]);		// convert to an array of type TrieNode
	}
}
