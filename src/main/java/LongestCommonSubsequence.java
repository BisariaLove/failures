import java.util.Arrays;

public class LongestCommonSubsequence {

    static int[] longestCommonSubsequence(int[] a, int[] b) {

        int row = a.length + 1;
        int column = b.length + 1;

        int[][] dp = new int[row][column];

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(a[i-1] == b[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else if(a[i-1] != b[j-1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        printArray(dp);

        int i= (row-1);
        int j= (column-1);
        int[] res = new int[dp[row-1][column-1]];
        int indx = dp[row-1][column-1] -1 ;

        while(i>0 && j >0){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j-1]){
                j--;
            }else{
                res[indx] = a[i-1];
                i--;
                j--;
                indx--;
            }
        }

        return res;
    }

    public static void main(String[] args){


        //int[] res = longestCommonSubsequence(new int[]{1, 2, 3, 4, 1}, new int[]{3, 4, 1, 2, 1, 3});
        int[] res = longestCommonSubsequence(new int[]{3, 9, 8, 3, 9, 7, 9, 7, 0}, new int[]{3, 3, 9, 9, 9, 1, 7, 2, 0, 6});

        System.out.println(Arrays.toString(res));
    }

    public static void printArray(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();

        }
    }
}
