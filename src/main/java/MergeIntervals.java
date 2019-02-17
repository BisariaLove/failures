import java.util.*;


class Interval {

    int start;
    int end;

    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }


    @Override
    public String toString() {
        return  new String("[" +start+ ", " +end+ "]");
    }

}


public class MergeIntervals {


   public List<Interval> mergeIntervals(List<Interval> intervals){


       Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2){
               if(i1.start!=i2.start)
                   return i1.start-i2.start;
               else
                   return i1.end-i2.end;
           }
       });

       if(intervals == null || intervals.size() == 0){
           return new ArrayList();
       }

       Stack<Interval> stack = new Stack();

       stack.push(intervals.get(0));

       for(int i = 1 ; i< intervals.size() ; i++){

           if((stack.peek().end >= intervals.get(i).start) && !(stack.peek().start > intervals.get(i).end)){
               Interval last = stack.pop();
               int start = Math.min(last.start, intervals.get(i).start);
               int end = Math.max(last.end, intervals.get(i).end);

               last = new Interval(start, end);
               stack.push(last);
           }else
               stack.push(intervals.get(i));
       }
       return new ArrayList(stack);

   }

   public static void main(String[] args){

       MergeIntervals intervals = new MergeIntervals();
       List<Interval> array = new ArrayList();
       array.add(new Interval(1,3));
       array.add(new Interval(2,6));
       array.add(new Interval(8, 10));
       array.add(new Interval(15, 18));


       intervals.mergeIntervals(array);

   }
}
