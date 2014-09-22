/*
Maximal Rectangle 
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
先求直方图，然后求直方图的最大矩形。
*/
package com.alvin.java;
public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
            return 0;
        int cols = matrix[0].length;
        int rows = matrix.length;
        int[][] h = new int[rows][cols];
        int max = 0 ;
        int area= 0;
        for(int i=0 ; i< rows; i++){
            for(int j=0; j < cols; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                if (j == 0){
                    h[i][j] =1;
                }
                else{
                    h[i][j] = h[i][j-1] + 1;
                }

                int y =1;
                int x = cols;
                while(i - y +1 >=0 && h[i-y+1][j] >0){
                    x = Math.min(x, h[i-y+1][j]);
                    max = Math.max(max, x*y);
                    y++;

                }

            }
        }
        return max;
    }
    public static void main(String[] args) {
        char[][] matrix ={{'1'}};
        System.out.println(new Maximal_Rectangle().maximalRectangle(matrix) );
    }
}