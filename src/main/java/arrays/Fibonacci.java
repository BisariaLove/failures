package arrays;
/*
 * @author love.bisaria on 19/09/18
 */


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
public class Fibonacci {

    public static int fib(int n) {

        if(n<0) throw new RuntimeException();

        if(n==0) return 0;
        if(n==1) return 1;

        // compute the nth Fibonacci number
        /*int[] memo = new int[n+1];

        for(int i=0; i<n+1;i++){
            memo[i]= -1;
        }

        memo[0]=0;
        memo[1]=1;*/

        int i=2;
        int a = 0; int b=1; int res=0;
        while(i<=n){
           res= a+b;

           a=b;
           b=res;


            /*if(memo[i] != -1) return memo[i];

            memo[i] = memo[i-1]+memo[i-2];

            i++;*/
            i++;
        }

        /*return memo[n];*/

        return res;
    }

    // tests

    @Test
    public void zerothFibonacciTest() {
        final int actual = fib(0);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void firstFibonacciTest() {
        final int actual = fib(1);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void secondFibonacciTest() {
        final int actual = fib(2);
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void thirdFibonacciTest() {
        final int actual = fib(3);
        final int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void fifthFibonacciTest() {
        final int actual = fib(5);
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void tenthFibonacciTest() {
        final int actual = fib(10);
        final int expected = 55;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void negativeFibonacciTest() {
        fib(-1);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Fibonacci.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
