/**   Sort Colors
 * 2014-5-16
 * @author Alvin
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
 */
package com.alvin.java;
public class Sort_Colors {

    public void sortColors(int[] A) {
        countSort(A);
    }

    public int[] countSort(int[] A){
        int c0= 0;
        int c1 =0;
        int c2 = 0;
        for(int i=0 ;i<A.length;i++){
            if(A[i] == 0)
                c0++;
            else if(A[i]== 1)
                c1++;
            else c2++;
        }

        for(int i=0;i< c0;i++){
            A[i] = 0;
        }
        for(int i=0;i< c1;i++){
            A[i+c0] = 1;
        }
        for(int i=0;i< c2;i++){
            A[i+c1+c0] = 2;
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A={0,1,2,0,1,2};
        new Sort_Colors().sortColors(A);
    }

}
