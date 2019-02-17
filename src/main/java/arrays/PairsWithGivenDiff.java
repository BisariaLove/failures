package arrays;
/*
 * @author love.bisaria on 15/09/18
 */

/*
* Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.

Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

Examples:

input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
output: []
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairsWithGivenDiff {


    static int[][] findPairsWithGivenDifference(int[] arr, int k) {

        int[][] temp = new int[arr.length][2];

        Set<Integer> nums = new HashSet();
        for(int i=0; i<arr.length; i++){
            nums.add(arr[i]);
        }

        int index=0;
        for(int i=0; i<arr.length; i++){

            if(nums.contains(arr[i]-k)){
                temp[index][0] = arr[i];
                temp[index][1] = (arr[i] - k);
                index++;
            }

        }

        int[][] result = new int[index][2];

        for(int i=0;i<index; i++){
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }
        return result;
    }

    public static void main(String[] args) {
        /*int[] arr = new int[]{0, -1, -2, 2, 1};
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference( arr, 1)));*/

        int[] arr = new int[]{1,5,11,7};
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference( arr, 6)));
    }
}
