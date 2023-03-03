package com.CS380.SpellingBee;

import java.util.ArrayList;

public class Node {
	char letter;
	boolean word; 
	int layer=0;
	Node parent;
	Node[] childs= new Node[26];
	/**
	 * real node for trie construction only 
	 * @param letter
	 * @param word
	 * @param parent
	 */
	
	public Node(char letter, boolean word, Node parent) {
		this.letter = letter;
		this.word = word;
		this.parent = parent;
	}

	/**
	 * Blank contructor for the root node
	 */
	public Node() {
		layer = 0;
		word = false;
				
	}
	
	/**
	 * fake node for bad babies
	 * @param parent
	 */
	public Node(Node parent) {
		this.parent = parent;
		this.layer = parent.layer+1;
	}
	
	/**
	 * Returns the pathways as a list of nodes (for removing words/working within the list)
	 * @return Pathway down to this node through the trie
	 */
	public Node[] getPathway() {
		ArrayList<Node> pathway = new ArrayList<>();
		Node current = this;
		while (current.layer > 0) {
			pathway.add(current.getLayer() - 1, current);		// lowest layer will be 1, so 1-1 = 0, and so on downwards
			current = current.getParent();
		}
		
		return pathway.toArray(new Node[0]);
	}
	
	public boolean isWord() {
		return word;//?
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
	
	public Node setChild(Node newChild) {
		this.childs[newChild.getLetter() - 'a'] = newChild;
		newChild.setParent(this);
		
		return newChild;
	}
	
	public boolean removeChild(char childChar) {
		boolean rtnVal = childs[Character.toLowerCase(childChar) - 'a'] == null;
		childs[Character.toLowerCase(childChar) - 'a']  = null;
		return rtnVal;
	}
	
	public Node getChild(char ch) {
		return childs[Character.toLowerCase(ch) - 'a'];
	}
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node[] getChilds() {
		return childs;
	}
	public void setChilds(Node[] childs) {
		this.childs = childs;
	}
	public boolean getWord() {
		return this.word;
	}
	public void setWord(boolean word) {
		this.word = word;
	}
	
	

}