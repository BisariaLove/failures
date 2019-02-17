package dp.hackerrank;
/*
 * @author love.bisaria on 15/08/18
 */

import java.util.HashMap;

public class CoinChange {
    public int getChange(int total, int[] coins){
        return getWays(total, coins, 0);
    }

    public int getWays(int total, int[] coins, int index){

        if(total == 0){
            return 1;
        }

        int numWays = 0;
        int current = 0;

        if(index >= coins.length){
            return 0;
        }

        if(total< 0){
            return 0;
        }

        while(current <= total){
            numWays += getWays(total - current, coins, index+1);
            current+=coins[index];
        }

        return numWays;

    }

    public static void main(String[] args){
        CoinChange ch = new CoinChange();
        int numWays = ch.getChange(25, new int[]{25,10, 5, 1});

        System.out.println("Total number of ways: " + numWays);

    }
}
