 /**  3Sum
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:46
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i =0; i< num.length;i++)
        {
            if(i >= 1 && num[i] ==num[i-1]){ //确保没有重复值
                continue;
            }
            int j = i+1;
            int k = num.length-1;

            while(j < k){
                int sum =  num[i] + num[j] + num[k];
                if(sum > 0){
                    int val = num[k];
                    while(k >0 && num[k] == val)   //确保没有重复值
                        k--;
                }else if(sum < 0){
                    int val = num[j];
                    while(j < num.length && num[j] == val) //确保没有重复值
                        j++;
                }else{
                    List<Integer> array1 = new ArrayList<Integer>();
                    array1.add(num[i]);
                    array1.add(num[j]);
                    array1.add(num[k]);
                    list.add(array1);
                    int val = num[j];
                    while(j < num.length && num[j] == val) //确保没有重复值
                        j++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] num = {0,-4,-1,-4,-2,-3,2};
        new Sum3().threeSum(num);
    }

}
