import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SolutionClass {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];


        System.out.println("Rows: "  + arr.length);
        System.out.println("Columns: " + arr[0].length);
        for (int i = 0; i<m; i++){
            arr[i][0] = 1;
        }

        for(int j = 0; j<n; j++){
            arr[0][j] = 1;
        }

        for(int i = 1; i<m ; i++){
            for(int j = 1; j<n; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        return arr[m-1][n-1];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new SolutionClass().uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}