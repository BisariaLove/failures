package arrays.search;
/*
 * @author love.bisaria on 18/09/18
 */

public class BinarySearch {

    public static int binarySearch(int[] arr, int item){

        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = (start+end)/2;

            if(arr[mid] == item){
                return mid;
            } else if(arr[mid] < item){ //search right sub array
                start = mid+1;
            }
            else if(arr[mid] > item){ // search left sub array
                end = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args){

        int[] arr = new int[]{5, 6, 7, 1, 2, 3, 4 };
        System.out.println(binarySearch(arr, 5));

    }
}
