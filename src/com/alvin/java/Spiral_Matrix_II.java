/*
Spiral Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
package com.alvin.java;
import java.util.Arrays;

public class Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][]  array= new int[n][n];
        int index = 1;
        for (int i=0;index <=n*n ;i++ ){
            //up
            for (int j=0;j < n ;j++ ) {
                if(array[i][j] == 0)
                    array[i][j] = index ++;
            }
            //right
            for (int j=0;j < n ;j++ ) {
                if(array[j][n-1-i] == 0)
                    array[j][n-1-i] = index ++;
            }
            //down
            for (int j=n-1;j >=0 ;j-- ) {
                if(array[n-1-i][j] == 0)
                    array[n-1-i][j] = index ++;
            }
            //left
            for (int j=n-1;j >=0 ;j-- ) {
                if(array[j][i] == 0)
                    array[j][i] = index ++;
            }

        }
        return array;
    }
    public static void main(String[] args) {
        int[][] array = new Spiral_Matrix_II().generateMatrix(6);
        for(int i=0;i< array[0].length;i++)
            System.out.println(Arrays.toString(array[i]));
    }
} 