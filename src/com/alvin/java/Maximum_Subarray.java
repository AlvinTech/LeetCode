package com.alvin.java;

/**  Maximum Subarray
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午3:17
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

 click to show more practice.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] A) {
        if(A.length == 0)
            return 0;
        int max = A[0];
        int cur = A[0];
        for(int i = 1; i< A.length;i++){
            cur = Math.max(cur + A[i],A[i]); // 如果 cur + A[i] < A[i]的时候，表示cur 为负数，负数不可能是最大值的前缀。
            max = Math.max(cur,max);
        }
        return max;
    }
}

//class Solution:
//
//        def max(self,a,b):
//        return a if a > b  else  b
//        pass
//        def maxSubArray(self,A):
//
//        best = A[0];
//current = A[0]
//
//        for x in A[1:]:
//        current = self.max(current+x,x)
//        best =self.max(current,best)
//        pass
//        return best
//        pass
