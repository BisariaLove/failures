package arrays;
/*
 * @author love.bisaria on 30/09/18
 * https://leetcode.com/problems/container-with-most-water/description/
 */

public class MaxSum {

    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int maxArea=0;
        while(l<r){
            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));

            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        Integer ans = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }
}
