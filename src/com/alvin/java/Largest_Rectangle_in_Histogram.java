/*
Largest Rectangle in Histogram 
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
详细思路请看：http://blog.csdn.net/alvintech14/article/details/39474657
*/
package com.alvin.java;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int top ;
        int length = height.length;
        int max = 0;
        int i=0;
        while(i < length){
            if(stack.empty() || height[stack.peek()] <= height[i])
                stack.push(i++);
            else{
                top = stack.pop();
                max = Math.max(max, height[top]*(stack.empty() ? i : i-stack.peek()-1));
            }
        }
        while(!stack.empty()){
            top = stack.pop();
            max = Math.max(max, height[top]*(stack.empty() ? i : i-stack.peek()-1));
        }
        return max;

    }

    public static void main(String[] args) {
        int heigh[] = {2,1,5,6,2,3};
        System.out.println(new Largest_Rectangle_in_Histogram().largestRectangleArea(heigh));
        // TODO Auto-generated method stub

    }

}
