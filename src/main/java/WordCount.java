import java.util.Arrays;
import java.util.Map;

public class WordCount {

    public static void getWordCount(String sentence){
        String regex = "((\\b[^\\s]+\\b)((?<=\\.\\w).)?)";

        String[] words = sentence.split(regex);

        System.out.println(Arrays.deepToString(words));
    }

    public static void main(String[] args){
        getWordCount("The moon is our natural satellite, i.e. it rotates around the Earth!");
    }
}
