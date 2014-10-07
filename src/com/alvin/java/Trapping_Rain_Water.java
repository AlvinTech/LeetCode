/**
 * 2014-6-3
 * @author Alvin
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Thanks Marcos for contributing this image!
 */
package com.alvin.java;
public class Trapping_Rain_Water {
    public int trap(int[] A) {
        if(A.length < 1){
            return 0;
        }
        int total = 0 , block = 0 , l = 0 ,
                r = A.length -1,h=0;
        while(l <= r){
            if(Math.min(A[l],A[r]) > h ){
                total += (Math.min(A[r],A[l]) - h) * (r - l +1);
                h = Math.min(A[r],A[l]);
            }
            if(A[r] > A[l]){
                block += A[l];
                l++;
            }
            else{
                block += A[r];
                r--;
            }
        }
        return total - block;
    }
    public static void main(String[] args) {
        int[] A={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trapping_Rain_Water().trap(A));
    }

}
