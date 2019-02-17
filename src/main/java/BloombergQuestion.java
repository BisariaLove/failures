//  Write a function to crush candy in a one dimensional board.
// In this problem, any sequence of 3 or more like items should be removed and any items adjacent to that sequence should now be considered adjacent to each other.
// This process should be repeated as many times as possible.

// Sample Input and expected output:
// ABBBCC -> ACC
// ABCCCBB -> A
// ABCDEEE

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BloombergQuestion {


    public static void main(String args[] ) throws Exception {


        System.out.println(candyCrush("ABBBCC"));
    }


    public static String candyCrush(String givenInput){



        //if size is less than 3 return as is
        if(givenInput.length() <3){
            return givenInput;
        }

        int i=0;
        char[] inputArr = givenInput.toCharArray();
        char[] outputArr = null;


        while(i< inputArr.length-2){


            if(inputArr[i] == inputArr[i+1] && inputArr[i] == inputArr[i+2]){
                outputArr = removeCharHelper(inputArr, i);
                inputArr = outputArr;
                i=0;
            }


            i++;

        }

        return new String(inputArr);

    }

    public static char[] removeCharHelper(char[] inputArr, int index){



        char[] outputArr = new char[inputArr.length];
        int i=0, k=0;


        for(; i< index; i++, k++){
            outputArr[k] = inputArr[i];
        }



        while( (i<inputArr.length) && inputArr[i] == inputArr[index] ){
            i++;
        }

        for(;i<inputArr.length; i++,k++){
            outputArr[k] = inputArr[i];
        }

        return outputArr;
    }
}
