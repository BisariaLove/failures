package leetcode;
/*
 * @author love.bisaria on 09/01/19
 */

import java.util.Arrays;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {

        if(A.length == 0 || A.length == 1) return A;

        int evenIndex = 0;
        int oddIndex = A.length - 1;

        while(evenIndex < oddIndex){

            while(A[evenIndex] %2 == 0 && evenIndex < oddIndex) evenIndex++ ;

            while(A[oddIndex] %2 != 0 && oddIndex > evenIndex) oddIndex--;

            if(A[evenIndex] %2 != 0){
                swap(evenIndex, oddIndex, A);
            }

        }
        return A;
    }


    public static void swap(int i, int j, int[] A){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args){

        int[] A = new int[]{3,1,2,4};

        int[] res = sortArrayByParity(A);

        System.out.println("result: " + Arrays.toString(res));

    }
}
