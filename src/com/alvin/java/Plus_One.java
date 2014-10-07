
/**   Plus One
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午2:59
 Given a non-negative number represented as an array of digits, plus one to the number.
 The digits are stored such that the most significant digit is at the head of the list.
 */
package com.alvin.java;

import java.util.Arrays;

public class Plus_One {
    public int[] plusOne(int[] digits) {
        int[] array = new int[digits.length + 1];
        int val = 1;
        for(int i =digits.length-1 ; i>=0 ;i--){
            val = digits[i]+val;
            array[i+1] = val % 10;
            val = val /10;
        }
        array[0] = val;
        return (val == 0)? Arrays.copyOfRange(array,1,array.length): array;
    }
}
