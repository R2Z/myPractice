package trie;

import java.util.HashMap;

public class Trie {
	
	public static void main(String[] args) {
		
		Trie tr = new Trie();
		tr.addWord("www.google.com");
		System.out.println(tr);
	}

	private TrieNode rootNode;
	private static final char END_OF_WORD_MARKER = '*';

	public Trie() {
		this.rootNode = new TrieNode();
	}

	public boolean addWord(String word) {

		TrieNode currentNode = this.rootNode;
		boolean isNewWord = false;

		// Work downwards through the trie, adding nodes
		// as needed, and keeping track of whether we add
		// any nodes.
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			if (!currentNode.isChildNode(character)) {
				isNewWord = true;
				currentNode.addChildNode(character);
			}

			currentNode = currentNode.getChildNode(character);
		}

		// Explicitly mark the end of a word.
		// Otherwise, we might say a word is
		// present if it is a prefix of a different,
		// longer word that was added earlier.
		if (!currentNode.isChildNode(END_OF_WORD_MARKER)) {
			isNewWord = true;
			currentNode.addChildNode(END_OF_WORD_MARKER);
		}

		return isNewWord;
	}

	@Override
	public String toString() {
		return "Trie [rootNode=" + rootNode + "]";
	}
	
}

class TrieNode {

	private HashMap<Character, TrieNode> nodeChildren;

	public TrieNode() {
		this.nodeChildren = new HashMap<>();
	}

	public boolean isChildNode(char character) {
		return this.nodeChildren.containsKey(character);
	}

	public void addChildNode(char character) {
		this.nodeChildren.put(character, new TrieNode());
	}

	public TrieNode getChildNode(char character) {
		return this.nodeChildren.get(character);
	}

	@Override
	public String toString() {
		return "TrieNode [nodeChildren=" + nodeChildren + "]";
	}
	
}