/**  Maximum_Product_Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-10-1
 * Time: 下午9:01
 * To change this template use File | Settings | File Templates.
 * 思路： 负数只会出现 偶数个 或者奇数个，如果是偶数个 则全部相乘。如果是奇数个。
 * 则遍历每一个位置，去前一半和后一半的最大值。
 */
package com.alvin.java;

import java.util.Arrays;

public class Maximum_Product_Subarray {
    public int maxProduct(int[] A) {
        int length = A.length;
        int max = 0;
        if(length == 1)
            return A[0];
        if(A== null || A.length ==0 )
            return 0;
        int index = 0;
        for(int i = 0; i < length; i++){
            if(A[i] == 0 ){
                max = Math.max(max,maxP(Arrays.copyOfRange(A,index,i)));
                index = i+1;
            }
        }

        max = Math.max(max,maxP(Arrays.copyOfRange(A,index,A.length)));
        return  max;

    }
    public int  maxP(int[] A){
        int length = A.length;
        if(length == 1)
            return A[0];
        if(A== null || A.length ==0 )
            return 0;
        int max = A[0];

        int n = 0;
        int total = 1;
        int[] pre = new int[length];
        int[] aft = new int[length];
        for(int i = 0; i < length; i++){
            if(A[i] < 0)
                n++;
            total *= A[i];
        }
        pre[0] = 1;
        aft[length-1] = 1;
        for (int i = length-2; i >=0; i--){
            aft[i] = aft[i+1] * A[i+1];
            pre[length - i -1]  = pre[length-i - 2]* A[length-i-2];
        }
        if(n % 2 == 0)
            return total;
        else{
            for (int i = 0; i < A.length; i++){
                max = Math.max(max,Math.max(aft[i],pre[i]));
            }
            return max;
        }
    }
    public static void main(String[] args){
//        int[] A = {2,3,-4,5};
        int[] A = {0,-4};
        System.out.print(new Maximum_Product_Subarray().maxProduct(A));
    }
}
