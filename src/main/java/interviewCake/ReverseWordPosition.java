package interviewCake;
/*
 * @author love.bisaria on 10/01/19
 */

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseWordPosition {

    public static void reverseCharArray(char[] charArray, int start, int end){

        while(start <  end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

    }

    public static void reverseWords(char[] charArray){
        reverseCharArray(charArray, 0, charArray.length-1);

        int currentWordIndex = 0;
        for(int i=0; i<=charArray.length; i++){

            if(i== charArray.length|| charArray[i] == ' '){

                reverseCharArray(charArray, currentWordIndex, i-1);
                currentWordIndex = i+1;
            }
        }

    }



    // tests

    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    /*@Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverseWords(actual);
        System.out.println("twoWordsTest Actual: " + actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverseWords(actual);
        System.out.println("threeWordsTest Actual: " + actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverseWords(actual);
        System.out.println("multipleWordsSameLengthTest Actual: " + actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverseWords(actual);
        System.out.println("multipleWordsDifferentLengthsTest Actual: " + actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverseWords(actual);
        System.out.println("emptyStringTest Actual: " + Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }*/

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseWordPosition.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
