import java.util.*;

public class WordLadder {


    //get adjacent words for a given word
    public List<String> getAdjacentWords(Set<String> wordDict, String word){

        char[] wordCharArray = word.toCharArray();
        List<String> adjWords = new ArrayList();

        for(int i=0; i<wordCharArray.length; i++){

            char ch =  wordCharArray[i];
            for(char c = 'a' ; c<='z' ; c++){
                if(wordCharArray[i] == c){
                    continue;
                }else{
                    wordCharArray[i] = c;
                    String newFormedWord = new String(wordCharArray);
                    if(wordDict.contains(newFormedWord)){
                        adjWords.add(newFormedWord);
                    }
                }
            }
            wordCharArray[i] = ch;
        }

        return adjWords;
    }


    public void getShortestPath(String startWord, String endWord, Set<String> wordDict){

        LinkedList<String> queue = new LinkedList();

        queue.add(startWord);

        System.out.println();
    }

    public static void main(String[] args){

        WordLadder ladder = new WordLadder();
        String startWord = "hit";
        String endWord = "cog";

        Set<String> wordDict = new HashSet(Arrays.asList("hot","dot","dog","lot","log","cog"));

        List<String> adjWords = ladder.getAdjacentWords(wordDict, startWord);

        System.out.println(adjWords.toString());

    }
}
