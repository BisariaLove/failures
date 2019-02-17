import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {



    public  int longestIncreasingSubsequence(int[] array){
        int num =1;
        List<List<Integer>> subsequence = new ArrayList();

        int[] sequenceSize = new int[array.length];

        for(int i=0; i< array.length; i++){
            sequenceSize[i] = 1;
            List<Integer> list = new ArrayList();list.add(array[i]);
            subsequence.add(list);
        }



        for(int i=1;i<array.length; i++){
            for(int j=0; j<(i); j++){
                if(array[j]< array[i]){
                    sequenceSize[i] = Math.max(sequenceSize[i], sequenceSize[j]+1);
                    if(sequenceSize[i] < sequenceSize[j]+1){
                        List<Integer> newList = new ArrayList<Integer>();
                        newList.addAll(subsequence.get(j));
                        newList.add(array[i]);
                        subsequence.add(i, newList);
                    }
                }
            }
        }

        int largest = sequenceSize[0];

        int index = -1;
        for(int i=1;i<sequenceSize.length; i++){
            if(largest<sequenceSize[i] ){
                largest = sequenceSize[i];
                index = i;
            }
        }

        System.out.println("Subsequence : " + subsequence.get(index));
        return largest;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] arr = new int[]{3, 4, -1, 0, 6, 2, 3};
        System.out.println("Maximum:  " + obj.longestIncreasingSubsequence(arr));

        List<Integer> list = new ArrayList(5);
        list.add(0, 1);
    }
}
