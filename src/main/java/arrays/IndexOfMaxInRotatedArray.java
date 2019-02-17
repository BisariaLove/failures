package arrays;
/*
 * @author love.bisaria on 27/09/18
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class IndexOfMaxInRotatedArray {

    public static void main(String[] args) {
        IndexOfMaxInRotatedArray obj  = new IndexOfMaxInRotatedArray();
        List<Integer> data = Arrays.asList(1,2,3);
        List<Integer> instructions = Arrays.asList(1,1,1,2);
        List<Integer> result = obj.getMaxElementIndexes(data, instructions);

        System.out.println(result);
    }

    private List<Integer> getMaxElementIndexes(List<Integer> data, List<Integer> instructions) {
        List<Integer> result = new ArrayList();
        Integer max = null;
        Integer maxIndex = null;
        for(int i = 0; i<data.size(); i++) {
            if(max == null || data.get(i) > max) {
                max = data.get(i);
                maxIndex = i;
            }

        }

        for(Integer m : instructions) {
            result.add(maxIndex-(m%instructions.size()));
        }
        return result;
    }
}
