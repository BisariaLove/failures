import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the journeyToMoon function below.
    static int journeyToMoon(int n, int[][] astronaut) {
        List<Set<Integer>> astroSameCountryList = new ArrayList();

        for(int i=0;i<n; i++) {
            Set<Integer> set = new HashSet();
            set.add(i);
            astroSameCountryList.add(set);
        }

        for(int i=0;i<astronaut.length;i++){
            int a1 = astronaut[i][0];
            int a2 = astronaut[i][1];

            Set<Integer> a1Set = null;
            Set<Integer> a2Set = null;

            for(Set<Integer> astroSet : astroSameCountryList){
                if(astroSet.contains(a1)){
                    a1Set = astroSet;
                }
                if(astroSet.contains(a2)){
                    a2Set = astroSet;
                }

                if((a1Set != null) && (a2Set != null)){
                    break;
                }
            }

            if(a1Set != a2Set){
                a1Set.addAll(a2Set);
                astroSameCountryList.remove(a2Set);
            }
        }

        int len  = astroSameCountryList.size();
        int[] sizes = new int[len];
        for(int i=0; i<len; i++){
            sizes[i] = astroSameCountryList.get(i).size();
        }

        int numWays = 0;
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                numWays += (sizes[i]*sizes[j]);
            }
        }

        return numWays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String[] np = scanner.nextLine().split(" ");

        int n = 10;

        int p = 7;

        int[][] astronaut = new int[][]{{0,2}, {1,8}, {1,4}, {2,8}, {2,6}, {3,5}, {6,9}};


        int result = journeyToMoon(n, astronaut);

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
