package interviewCake;
/*
 * @author love.bisaria on 02/02/19
 */

import java.util.Arrays;

//total number of ways for form a sum
public class CoinChange {

    public static Integer changePossibilities(int sum, int[] denominations){

        return changePossibilities(sum, denominations, 0);

    }

    public static Integer changePossibilities(int amountLeft, int[] denominations, int index){

        System.out.printf("checking ways to make %d with %s\n",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        index, denominations.length)));

        //if we hit the amount spot on, yes!
        if(amountLeft == 0){
            System.out.println("Amount left: " + amountLeft + " ,Bingo!!.");
            return 1;
        }

        //we overshoot the amount left
        if(amountLeft < 0){
            System.out.println("Amount left: " + amountLeft + " ,less than zero.");
            return 0;
        }

        //we're out of denominations
        if(index == denominations.length){
            System.out.println("Index: " + index + " ,out of denominations.");
            return 0;
        }

        int currentCoin = denominations[index];

        int possibilities = 0;
        while(amountLeft >= 0){

            possibilities += changePossibilities(amountLeft, denominations, index+1);

            amountLeft -= currentCoin;
        }

        return possibilities;

    }

    public static void main(String[] args){

        int amount = 4;
        int[] denominations = new int[]{1, 2, 3};

        int ways = changePossibilities(amount, denominations);

        System.out.println();
        System.out.println();

        System.out.println("Total ways: " + ways);
    }
}
