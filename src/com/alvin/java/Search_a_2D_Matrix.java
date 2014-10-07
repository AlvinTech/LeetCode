
/*  Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
package com.alvin.java;

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int up = 0;
        int down = matrix.length-1;
        while(up <= down ){
            int mid  = (up + down) /2;
            if(target > matrix[mid][0])
                up = mid+1;
            else if(target < matrix[mid][0])
                down = mid-1;
            else
                return true;
        }

        int index = down >0? down :0;
        up = 0;
        down = matrix[0].length-1;
        while(up <= down){
            int mid = (up+down)/2;
            if(matrix[index][mid] == target)
                return true;
            else if(matrix[index][mid] < target)
                up = mid+1;
            else
                down = mid -1;
        }
        return false;

    }
    public static void main(String[] args) {
        // int[][] matrix ={{1,3,5,7},{10,11,12,20},{23,30,34,50}};
        int[][] matrix ={{1}};
        System.out.println(new Search_a_2D_Matrix().searchMatrix(matrix,0));
    }
}