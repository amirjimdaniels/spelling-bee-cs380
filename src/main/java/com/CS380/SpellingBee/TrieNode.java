package com.CS380.SpellingBee;

import java.util.ArrayList;
/**
 * Node for a Trie
 * 
 * @author Kieren Leahy
 * @author Tobias Ward
 * 
 *
 */
public class TrieNode {
	/**
	 * The letter being stored by this node
	 * i.e. 'a', 'b', 'c'
	 */
	char letter;
	
	/**
	 * Is this letter the end of a word?
	 */
	boolean word; 
	
	/**
	 * The layer refers to how far down the tree the node is.
	 * (how long is a word ending with this letter?)
	 */
	int layer;
	
	/**
	 * The parent node for the current node.
	 * 
	 * Within the tree this represents what letter came before this one in a word
	 */
	TrieNode parent;
	
	/**
	 * an array view of the children nodes. Left as <b>null</b> when
	 * there is no child.
	 */
	TrieNode[] childs= new TrieNode[26];
	
	/**
	 * Constructor for Trie Nodes in the Trie.
	 * <p>
	 * This is the main constructor, and is the one that should be called when
	 * populating the trie with letters. This constructor will automatically
	 * configure the parent to have itself as the corresponding child.
	 * </p>
	 * @param letter The letter represented by this node
	 * @param word True if a word ends on this node, false otherwise
	 * @param parent The parent node for the current, up the tree towards the root.
	 */
	public TrieNode(char letter, boolean word, TrieNode parent) {
		this.letter = letter;
		this.word = word;
		this.parent = parent;
		
		parent.setChild(this);
	}

	/**
	 * Constructor for root of Trie. Should only be used when constructing the Trie originally
	 * <p>
	 * This constructor will leave the parent value as <b>null</b>, and the char value as <b>\\u0000</b>
	 * as well as default layer to <b>0</b> and word to <b>false</b>
	 * </p>
	 */
	public TrieNode() {
		layer = 0;
		word = false;
				
	}
	
	/**
	 * Fake node for bad babies
	 * <p>
	 * creates a blank node for walking empty paths of the Trie.
	 * <p>
	 * 
	 * TODO: Fix this based on how the TrieVisitor Object works
	 * 
	 * @param parent
	 */
	public TrieNode(TrieNode parent) {
		this.parent = parent;
		this.layer = parent.layer+1;
	}
	
	/**
	 * Returns the pathways as a list of nodes (for removing words/working within the list)
	 * 
	 * @return Pathway down to this node through the trie
	 */
	public TrieNode[] getPathway() {
		ArrayList<TrieNode> pathway = new ArrayList<>();
		TrieNode current = this;
		while (current.layer > 0) {							// avoid grabbing the root node (we need that pristine)
			pathway.add(current.getLayer() - 1, current);	// adds to the corresponding ArrayList location (0 indexed, so layer-1 since the smallest layer will be 1)
			current = current.getParent();					// walk up the tree
		}
		
		return pathway.toArray(new TrieNode[0]);		// convert to an array of type TrieNode
	}
	
	/**
	 * Do it got a child with the charatcer already created?
	 * @param ch
	 * @return
	 */
	public boolean hasChild(char ch) {
		ch = Character.toLowerCase(ch);
		return childs[ch - 'a'] != null;
	}
	
	/**
	 * <p>
	 * Set a specific child of the current node to be a node 'newChild'. 
	 * This is designed to be used when adding a child to it's parent's 
	 * children array.
	 * </p>
	 * 
	 * <b>The child must be configured with a letter before using this method</b>
	 * <p></p>
	 * @param newChild
	 * @return
	 */
	public TrieNode setChild(TrieNode newChild) {
		this.childs[newChild.getLetter() - 'a'] = newChild;
		newChild.setParent(this);
		
		return newChild;
	}
	
	/**
	 * Removes a specific child
	 * <p>
	 * Removes the specified child of this node by setting the array location to null
	 * </p>
	 * @param childChar
	 * @return
	 */
	public boolean removeChild(char childChar) {
		boolean rtnVal = childs[Character.toLowerCase(childChar) - 'a'] == null;
		childs[Character.toLowerCase(childChar) - 'a']  = null;
		return rtnVal;
	}
	
	/**
	 * Gets a specific child of the current Node
	 * 
	 * @param ch the character of the requested child
	 * @return a child if there is one, null if there isn't
	 */
	public TrieNode getChild(char ch) {
		return childs[Character.toLowerCase(ch) - 'a'];
	}
	
	/**
	 * gets the letter stored in this node.
	 * 
	 * will be <b>\u0000</b> if the node has no letter
	 * @return
	 */
	public char getLetter() {
		return letter;
	}
	
	/**
	 * Sets the current letter (for manually assigning or changing)
	 * @param letter
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	/**
	 * gets the current node's layer
	 * @return
	 */
	public int getLayer() {
		return layer;
	}
	
	/**
	 * Sets the layer of the current node.
	 * @param layer
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}
	
	/**
	 * Returns the parent of this node, which should be the letter prior to it in the Trie
	 * @return
	 */
	public TrieNode getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent of the current node. Also, updates the layer to match
	 * so we don't have to do that ourselves elsewhere
	 * @param parent
	 */
	public void setParent(TrieNode parent) {
		this.parent = parent;
		this.layer = parent.getLayer() + 1;
	}
	
	/**
	 * Sets the parent of the current node without setting the layer
	 * @param parent
	 */
	public void setParentNoLayerUpdate(TrieNode parent) {
		this.parent = parent;
	}
	
	/**
	 * Returns the current childs array
	 * 
	 * @return
	 */
	public TrieNode[] getChilds() {
		return childs;
	}
	
	/**
	 * Set the childs array to a new pre-configured childs array
	 * 
	 * protected for no fuckery (so we don't accidentally use this instead of set child)
	 * 
	 * @param childs
	 */
	protected void setChilds(TrieNode[] childs) {
		this.childs = childs;
	}
	
	/**
	 * Is this node the end of a word?
	 * @return
	 */
	public boolean isWord() {
		return this.word;//?
	}
	/**
	 * Set whether this is a word or not
	 * @param word True if word, false otherwise
	 */
	public void setWord(boolean word) {
		this.word = word;
	}
	
	

}