package concurrency;
/*
 * @author love.bisaria on 02/01/19
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorServiceExample {

   private int sum =0;

   public void calculate(){

       long id = Thread.currentThread().getId();
       System.out.println(getSum() + "-- Thread " + id);
       setSum(getSum() + 1);
   }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    public static void main(String[] args){

        ExecutorService service = Executors.newFixedThreadPool(3);
        ExecutorServiceExample summation = new ExecutorServiceExample();

        IntStream.range(0, 1000)
                .forEach(count-> service.submit(summation::calculate));

        try{
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Final Value: " + summation.getSum());

    }
}
