/*
Maximal Rectangle 
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

public class Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length ==0 )
            return 0;

        int up = Integer.MAX_VALUE;
        int down = 0;
        int left = Integer.MAX_VALUE;
        int right = 0;
        int flag = 0;
        for (int i=0;i < matrix.length ;i++ )
            for (int j=0 ; j< matrix[i].length ;j++ ) {
                if(matrix[i][j] == '1'){
                    if(up > i)
                        up = i;
                    if(down < i)
                        down = i;
                    if(left > j)
                        left = j;
                    if(right < j)
                        right = j;
                    flag =1;
                }

            }

        if(flag == 0)
            return 0;
        else
            return (down- up+1)*(right- left+1);

    }
    public static void main(String[] args) {
        char[][] matrix ={{'1'}};
        System.out.println(new Maximal_Rectangle().maximalRectangle(matrix) );
    }
}