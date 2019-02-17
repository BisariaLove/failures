import java.util.*;

/**
 * Created by lovebisaria on 12/10/17.
 */
public class PriorityQueueTest {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //String sentence = sc.next();
        String sentence = "aab bbc aab bc bcb abd abd";

        String[] words = sentence.split("\\s+");


        WordFreqComparator comparator = new WordFreqComparator();
        Map<String, WordFreq> wordFreqMap = new HashMap<String, WordFreq>();
        PriorityQueue<WordFreq> maxHeap = new PriorityQueue<WordFreq>( comparator);

        for (String word: words){
           WordFreq wordFreq = wordFreqMap.getOrDefault(word, new WordFreq(word,1));


           Integer freq = wordFreq.getFrequency();
           freq +=1;
           wordFreq.setFrequency(freq);

            wordFreqMap.put(word, wordFreq);

        }

        for(Map.Entry<String, WordFreq> entry : wordFreqMap.entrySet()){
            maxHeap.add(entry.getValue());
        }

        while(!maxHeap.isEmpty()){
            WordFreq wordFreq = maxHeap.poll();

            System.out.println("Word Frequency: " + wordFreq.getWord() + " : " + wordFreq.getFrequency());
        }


    }
}

class WordFreqComparator implements Comparator<WordFreq>{

    public int compare(WordFreq c1, WordFreq c2) {
        return (int) (c2.getFrequency() - c1.getFrequency());
    }

}

class WordFreq{
    private String word;
    private Integer frequency;

    public WordFreq(String word, Integer frequency){
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
