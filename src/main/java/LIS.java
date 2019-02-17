import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {

    public int lengthOfLIS(int[] nums) {

        if(nums.length < 2) return nums.length;


        List<List<Integer>> sequences = new ArrayList(nums.length);

        List<Integer> list = new ArrayList();
        list.add(nums[0]);
        sequences.add(0, list);

        for(int i=1; i<nums.length; i++){
            List<Integer> currentList = new ArrayList();

            list = sequences.get(i-1);

            if(list.get(list.size() - 1)< nums[i]){
                currentList.addAll(list);
                currentList.add(nums[i]);
                sequences.add(i, currentList);
            } else if(list.get(list.size() - 1)> nums[i]){
                if(list.size()>1){
                    currentList.addAll(list);
                    currentList.remove(currentList.size()-1);
                    currentList.add(nums[i]);
                    sequences.add(i, currentList);
                }else{
                    sequences.add(i, Arrays.asList(nums[i]));
                }
            }else{
                sequences.add(i, Arrays.asList(nums[i]));
            }
        }

        int largest = -1;
        for(List<Integer> sequence : sequences){
            if(sequence.size() > largest){
                largest = sequence.size();
            }
        }

        return largest;


    }

    public static void main(String[] args){
        LIS obj = new LIS();

        //System.out.println(obj.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
        System.out.println(obj.lengthOfLIS(new int[] {4,4,4,4}));
    }
}
