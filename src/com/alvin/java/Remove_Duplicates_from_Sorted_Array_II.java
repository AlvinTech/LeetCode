/*
Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/
package com.alvin.java;
import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] A) {
        if(A ==null || A.length ==0)
            return 0;
        int index =1;
        boolean flag = true;
        for (int i = 0;i < A.length-1 ;i++){
            if(A[i] != A[i+1]){
                flag = true;
                A[index++] = A[i+1];
            }else if(flag){
                flag =false;
                A[index++] = A[i+1];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] A ={1,1,1,2,2,3};
        System.out.println(new Remove_Duplicates_from_Sorted_Array_II().removeDuplicates(A));
        System.out.println(Arrays.toString(A));
    }
}