/*
4Sum 
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for (int i=0;i < length-3 ;i++ ){
            for (int j =i+1; j < length-2 ;j++ ){
                for (int m = j+1, n = length -1; m < n ; ) {
                    int val = num[i] + num[j] + num[n] + num[m];
                    if(val > target)
                        n--;
                    else if(val < target)
                        m++;
                    else{
                        List<Integer> intList = new ArrayList<Integer>();
                        intList.add(num[i]);
                        intList.add(num[j]);
                        intList.add(num[m]);
                        intList.add(num[n]);
                        if(!result.contains(intList))
                            result.add(intList);
                        m++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array={0,0,0,0};
        List<List<Integer>> result = new Sum4().fourSum(array,0);
        for (int i =0; i < result.size();i++ ) {
            System.out.println(result.get(i));
        }
        System.out.println("Hello World");
    }


}