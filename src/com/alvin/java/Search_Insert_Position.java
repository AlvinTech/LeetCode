/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:03
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
package com.alvin.java;

public class Search_Insert_Position {
    public int searchInsert(int[] A, int target) {
        int sta = 0;
        int end = A.length;
        while (sta <= end){
            int mid = (sta + end)/2;
            if(A[mid] == target)
                return mid;
            else if(A[mid] < target)
                sta = mid +1;
            else
                end = mid-1;
        }
        return sta;
    }
}
//class Solution:
//        # @param A, a list of integers
//        # @param target, an integer to be inserted
//        # @return integer
//        def searchInsert(self, A, target):
//        for x in range(0,len(A)):
//        if A[x] >= target:
//        return x
//        pass
//        return len(A);
//pass