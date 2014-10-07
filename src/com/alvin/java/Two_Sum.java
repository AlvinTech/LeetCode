/**   Two Sum
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
package com.alvin.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    //隐含条件是 array 是正整数序列，且是递增序列。
    public int[] twoSum(int[] numbers, int target) {
        int[] two =new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0 ; i < numbers.length; i++)
            map.put(numbers[i],i);
        for (int i = 0 ; i < numbers.length; i++){
            if(map.get(target - numbers[i])!= null && map.get(target - numbers[i])!= i){
                two[0] = i+1;
                two[1] = map.get(target - numbers[i])+1;
                return two;
            }
        }
        return  two;
    }

    public static void main(String[] args){
        int [] array = {3,2,4};
        int target=6;
        int[] two = new Two_Sum().twoSum(array,target);
        System.out.println(two[0]);
        System.out.println(two[1]);

    }
}
