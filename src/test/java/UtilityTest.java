import org.junit.Test;

/**
 * Created by lovebisaria on 16/08/17.
 */
public class UtilityTest {

    @Test
    public void testTrailingZeroesInFactorial(){
        long num = 1234567890;
        long res = ZeroesInfactorial.getTrailingZeroes(num);

        System.out.println("Trailing Zeroes: " + res);
    }

}
