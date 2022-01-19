package tree;

import java.util.HashMap;
import java.util.Map;

public class SearchTextInDict {

    public static void main(String[] args) {
        String[] dict = {"bad", "dad", "mad", "pad", "bad", ".ad", "b.."};
        String[] searchStr = {"mad", "mad2", "pad", "1pad", ".ad", "b.."};
        Trie tr = new Trie();
        for (String str : dict) {
            tr.addWord(str);
        }

        for (String str : searchStr) {
            System.out.println(str + " - "+ tr.find(str));
        }
    }

}

class TrieNode {

    Map<Character, TrieNode> links;
    boolean isWord;

    public TrieNode() {
        links = new HashMap<>();
        isWord = false;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public boolean isWord() {
        return isWord;
    }

    public boolean contains(char ch) {
        return this.links.containsKey(ch);
    }

    public void add(char ch) {
        this.links.put(ch, new TrieNode());
    }

    public TrieNode get(char ch) {
        TrieNode cur = null;
        if (contains(ch)) {
            cur = this.links.get(ch);
        }
        return cur;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String str) {
        TrieNode currNode = root;
        for (char ch : str.toCharArray()) {
            if (!currNode.contains(ch)) {
                currNode.add(ch);
            }
            currNode = currNode.get(ch);
        }
        currNode.setWord(true);
    }

    public boolean find(String str) {
        return DFS(root, str.toCharArray(), 0);
    }

    private boolean DFS(TrieNode node, char[] chars, int currId) {

        if (chars.length == currId) {
            return node != null && node.isWord;
        }

        if (node.contains(chars[currId])) {
            for (TrieNode curr : node.links.values()) {
                if (DFS(curr, chars, currId + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
