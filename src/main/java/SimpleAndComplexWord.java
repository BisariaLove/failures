import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleAndComplexWord {

    public static String[] simpleWords(String[] data) {
        List<String> list = new ArrayList();
        for (String word : data) {
            if (!isCompound(data, word)) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static boolean isCompound(String[] data, String word) {
        return isCompound(data, word, 0);
    }

    public static boolean isCompound(String[] data, String word, int iteration) {
        if (data == null || word == null || (word.trim().length() <=0)) {
            return false;
        }
        for (String str : data) {
            if (str.equals(word) && iteration > 0) {
                return true;
            }
            if (word.startsWith(str)) {
                String subword = word.substring(str.length());
                if (isCompound(data, subword, iteration + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args){
        SimpleAndComplexWord obj = new SimpleAndComplexWord();

        System.out.println(Arrays.asList(obj.simpleWords(new String[]{"sales", "person", "salesperson"})));

    }
}
