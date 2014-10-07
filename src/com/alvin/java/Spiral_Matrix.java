/*
Spiral Matrix 
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0 || matrix[0].length ==0)
            return list;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][]  array= new int[m][n];
        int index = 1;
        for (int i=0;index <=m*n ;i++ ){
            //up
            for (int j=0;j < n ;j++ ) {
                if(array[i][j] == 0){
                    list.add(matrix[i][j]);
                    array[i][j] = index ++;
                }

            }
            //right
            for (int j=0;j < m ;j++ ) {
                if(array[j][n-1-i] == 0){
                    array[j][n-1-i] = index ++;
                    list.add(matrix[j][n-1-i]);

                }
            }
            //down
            for (int j=n-1;j >=0 ;j-- ) {
                if(array[m-1-i][j] == 0){
                    array[m-1-i][j] = index ++;
                    list.add(matrix[m-i-1][j]);
                }
            }
            //left
            for (int j=m-1;j >=0 ;j-- ) {
                if(array[j][i] == 0){
                    array[j][i] = index ++;
                    list.add(matrix[j][i]);
                }
            }

        }
        return list;
    }
    public static void main(String[] args) {
        int[][] array = new int[3][4];
        int index=1;
        for(int i =0; i< 3;i++)
            for(int j =0; j < 4;j++){
                array[i][j] = index++;
            }
        List<Integer> list  = new Spiral_Matrix().spiralOrder(array);
        System.out.println(list);
    }
} 