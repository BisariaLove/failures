public class MergeSort {


    public void mergeSort(int arr[], int left, int right){

        if(left>=right){
            return;
        }
        int mid= (left + right)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, (mid+1), right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int left, int mid, int right){
        int n1 = mid-left + 1;
        int n2 = right - mid;

        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        int index = 0;
        for(int i = left; i < mid ; i++){
            leftArray[index] = arr[i];
            index++;
        }

        index = 0;
        for(int i =mid+1 ; i<right; i++){
            rightArray[index] = arr[i];
            index++;
        }

        int i=0, j=0;
        index=left;

        while((i<n1) && (j<n2)){

            if(leftArray[i]<=rightArray[j]){
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }

            index++;
        }

        while(i<n1){
            arr[index] = leftArray[i];
            i++;
            index++;
        }

        while(j<n2){
            arr[index] = rightArray[j];
            j++;
            index++;
        }

    }

    public static void main(String[] args){
        MergeSort sort = new MergeSort();

        int[] arr = new int[]{10, 9, 11, 1, 7,3,2};
        sort.mergeSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
