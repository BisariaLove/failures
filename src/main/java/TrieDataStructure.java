import java.util.HashMap;
import java.util.Map;

/**
 * Created by lovebisaria on 02/09/17.
 */
public class TrieDataStructure {
    TrieNode root;

    public TrieDataStructure(){
        root = new TrieNode();
    }

    public void insertString(String str){
        TrieNode current = root;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            Character elem = str.charAt(i);
            Map<Character, TrieNode> childNodes = current.children;

            if(!childNodes.containsKey(elem)){
                t = new TrieNode(elem);
                childNodes.put(elem, t);
            }
            current = childNodes.get(elem);
            current.size++;
        }
    }

    public Integer searchCountOfPrefix(String prefix){
        TrieNode current = root;
        for(int i=0; i<prefix.length(); i++){
            Character elem = prefix.charAt(i);
            Map<Character, TrieNode> childNodes = current.children;
            if(childNodes.containsKey(elem)){
                if(i == (prefix.length() -1)){
                    return current.size;
                }
                current = childNodes.get(elem);
            }else{
                return 0;
            }
        }
        return 0;
    }

}

class TrieNode{

    char c;
    Map<Character, TrieNode> children;
    public int size = 0;

    public TrieNode(){
        children = new HashMap();
    }

    public TrieNode(char elem){
        c = elem;
        children = new HashMap();
    }
}
