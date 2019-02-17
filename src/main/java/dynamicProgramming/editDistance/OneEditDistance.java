package dynamicProgramming.editDistance;
/*
 * @author love.bisaria on 22/12/18
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class OneEditDistance {

    /*Edit distance operations:
    * 1. addition
    * 2. remove
    * 3. replace
    * */

    public static boolean isOneEditDistanceApart(String str1, String str2){

        //if any of the string is null
        if(isEmpty(str1) || isEmpty(str2)) return false;

        if(Math.abs(str1.length() - str1.length()) == 1) return true;


        List<Character> charList1 = getCharList(str1);
        List<Character> charList2 = getCharList(str2);


        if( charList1.stream()
                .filter(e -> !charList2.contains(e))
                .count() > 1) {

            return false;
        }

        return true;

    }

    //Generate all the words that are one distance away
    //Assumption: words are 2 characters or more
    public static List<String> oneEditDistanceWords(String word){
        List<String> result = new ArrayList();

        //remove
        List<String> removeCharResults =  Stream.iterate(0, e-> e+1)
                .limit(word.length())
                .map((e) -> removeCharAtGivenIndex(word.toLowerCase(), e))
                .collect(Collectors.toList());

        System.out.println("Size of removeCharResults List: " + removeCharResults.size());
        System.out.println("removeCharResults" + removeCharResults);

        List<List<String>> replaceCharResult = replaceCharacterWithAllOtherAlphabets(word.toLowerCase());

        System.out.println("##Printing all the lists##");
        replaceCharResult.forEach(System.out::println);

        result.addAll(removeCharResults);

        return result;
    }

    public static List<List<String>> replaceCharacterWithAllOtherAlphabets(String word){

          return Stream.iterate(0, e->e+1)
                .limit(word.length())
                .map(e-> replaceCharacterWithAllOtherAlphabets(word, e))
                .collect(Collectors.toList());

    }

    //actually the return type should be Set<String> but I am using set so as to get the idea of the number of ops
    public static List<String> replaceCharacterWithAllOtherAlphabets(String word, int index){

        return Stream.iterate(0, e->e+1)
                .limit(26)
                .filter(e-> (char)('a'+e) != word.charAt(index))
                .map(e-> word.replace(word.charAt(index), (char)('a'+e)))
                .collect(Collectors.toList());
    }



    public static String removeCharAtGivenIndex(String word, int index){

        return word.substring(0, index) + word.substring(index+1, word.length());

    }

    public static void main(String[] args){
        //System.out.println(isOneEditDistanceApart("Hella", "Hello"));
        oneEditDistanceWords("Hello");
    }

    public static boolean isEmpty(String str){

        if(str == null || str.length() == 0) return true;

        return false;

    }

    public static List<Character> getCharList(String str){

        if(isEmpty(str)){
            return new ArrayList();
        }

        char[] charArray = new char[str.length()];

        str.getChars(0, str.length(), charArray, 0);

        List<Character> charList = new ArrayList();

        for(char e : charArray){
            charList.add(e);
        }

        return charList;
    }

}
