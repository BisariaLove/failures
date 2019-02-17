package leetcode;

/*
 * @author love.bisaria on 22/10/18
 */

import java.util.*;

public class Jewels {
    public int numJewelsInStones(String J, String S) {
       Set<Character> set = new HashSet<Character>();

       for(char ch : J.toCharArray()){

           set.add(ch);
       }

        int total = 0;
        for(char c : S.toCharArray()){

            if(set.contains(c)){
                total++;
            }
        }

        return total;
    }


    public static void main(String[] args){
        Jewels obj = new Jewels();

        int total = obj.numJewelsInStones("aA", "aAAbbbb");

        System.out.println(total);

    }
}
