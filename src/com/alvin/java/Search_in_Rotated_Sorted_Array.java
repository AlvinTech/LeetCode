/**  Search in Rotated Sorted Array
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:07
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
package com.alvin.java;

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] A, int target) {
        if(target >=A[0]){
            for(int i=0 ; i< A.length;i++){
                if(A[i] == target)
                    return i;
            }
        }else
        {
            for(int i= A.length -1  ; i>=0;i--){
                if(A[i] == target)
                    return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] A ={4,5,6,7,1,2,3};
        int target  = 1;
        System.out.println(new Search_in_Rotated_Sorted_Array().search(A, target) );
    }

}
