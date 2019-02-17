import org.junit.jupiter.api.Test;

/**
 * Created by lovebisaria on 16/08/17.
 */
public class ZeroesInfactorial {
     public static Long getTrailingZeroes(Long number){

         long countOfZeroes = 0;
         long divisor = 5;

         if(number <= 0){
             return new Long(0);
         }

         while((number / divisor) != 0){
             countOfZeroes += (number / divisor);
             divisor *= 5;
         }

         return countOfZeroes;

     }


    @Test
    public void testThis(){
        String str = "https://my-alpha.ticketmaster.net/order/{orderId}/view";
        System.out.println(str.replace("{orderId}", "dummy_id"));
    }

}
