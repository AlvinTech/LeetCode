
/**  Rotate Image
 * 2014-6-12
 * @author Alvin
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
package com.alvin.java;
public class Rotate_Image {

    public void rotate(int[][] matrix) {
        int length  = matrix.length;
        int[][] array = new int[length][length];
        for(int i =0;i < length;i++){
            for(int j =0;j<length;j++){
                array[j][length-1-i] = matrix[i][j] ;
            }
        }

        for(int i =0;i < length;i++){
            for(int j =0;j<length;j++){
                matrix[i][j] =array[i][j];
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix ={{}};
        new Rotate_Image().rotate(matrix);
    }

}
