
/** Unique Paths
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午3:05
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.


 */
package com.alvin.java;

public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int [][] array = new int[m][n];
        for(int i = 0 ; i < m; i++)
            array[i][0] = 1;
        for(int i = 0 ; i < n ; i++)
            array[0][i] = 1;
        for(int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n; j++){
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
}
