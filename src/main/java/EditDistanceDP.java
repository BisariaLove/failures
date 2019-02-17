import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class EditDistanceDP {

    public int minDistance(String word1, String word2) {

        int m = word1.length() + 1;
        int n = word2.length() + 1;

        int[][] dp = new int[m][n];

        //initialize the first row
        for(int i=1; i<m; i++){
            dp[i][0] = i;
        }

        //initialize the first column
        for(int j=1; j<n; j++){
            dp[0][j] = j;
        }

        for(int i=1;i<m; i++){
            for(int j=1; j<n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static int min(int x, int y, int z){
        int d = 0;

        while ( x != 0 && y != 0 && z != 0 )
        {
            x--; y--; z--; d++;
        }

        return d;
    }

    public static void printRandom(){
        Random rand= new Random();

        for(int i=0; i<52; i++){
            System.out.println( rand.nextInt(52-i));
        }

    }

    public static void main(String[] args) throws IOException {

        /*EditDistanceDP dp = new EditDistanceDP();
        System.out.println("Distance: " + dp.minDistance("horse", "ros"));*/

        //printRandom();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
        int num = -1;

        /*for(int i=0; i<num; i++){
            String line = reader.readLine();
            System.out.println("$$$$$$$$$$$$$" + line);



        }*/

       int count  = 0;String input = null;

       do{
           input = reader.readLine();
           if(count ==0)
           num = Integer.parseInt(input);

           System.out.println("$$$$$$$$$$$$$" + input);

           count ++;


       }while(input != null);

        String WRONG_INPUT = "WRONG INPUT(LINE $)";
        System.out.println(WRONG_INPUT.replace('$', (char)('0' + 1)));
    }
}
