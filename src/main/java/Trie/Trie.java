package Trie;
/*
 * @author love.bisaria on 06/02/19
 */

import java.util.HashMap;
import java.util.Map;

public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode current = root;

        for(int i=0 ; i<word.length() ; i++){
            Character c = word.charAt(i);

            Map<Character, TrieNode> children = current.children;

            if(!children.containsKey(c)){
                children.put(c, new TrieNode());
            }

            current = children.get(c);
        }

        current.isEnd = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        char[] charArray = word.toCharArray();

        TrieNode current = root;

        for(int i=0; i<charArray.length; i++){

            Map<Character, TrieNode> children = current.children;

            if(!children.containsKey(charArray[i])){
                return false;
            }
            current = children.get(charArray[i]);
        }

        return current.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();

        TrieNode current = root;

        for(int i=0; i<charArray.length; i++){

            Map<Character, TrieNode> children = current.children;

            if(!children.containsKey(charArray[i])){
                return false;
            }

            current = children.get(charArray[i]);
        }
        return true;
    }

    public static void main(String[] args){

        Trie trie = new Trie();


        trie.insert("apple");
        System.out.println("Search apple: " + trie.search("apple"));   // returns true
        System.out.println("Search app: " + trie.search("app"));     // returns false
        System.out.println("StartsWith search app: " + trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println("Search app: " + trie.search("app"));
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap();
    boolean isEnd;

}
