package com.alvin.java;/*  Valid Sudoku
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated. 


提示：
因为提示合格的数独可以没有解所以只需要满足数独的3个基本要求：
1.行分别为1~9
2.列分别为1~9
3.每个3*3 格子 分别是1~9
为了减少存储量 数据按位存
*/
import java.util.Arrays;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] cols = new int[9];
        int[] rows = new int[9];
        int[] squs = new int[9];
        Arrays.fill(cols,0);
        Arrays.fill(rows,0);
        Arrays.fill(squs,0);
        for (int i=0; i < 9 ;i++ ) {
            for (int j =0 ; j < 9 ;j++ ) {
                if(board[i][j] != '0' ){
                    int val = board[i][j] - '0';
                    if((rows[i] & 1 << val) > 0)
                        return false; // 一行出现 重复数。
                    else
                        rows[i] |= 1<< val;
                    if((cols[j] & 1 << val) > val)
                        return false;// 一列出现重复数；
                    else
                        cols[j] |= 1<< val;
                    int index = i/3*3 + j/3;
                    if((squs[index] & 1<<val) > 0)
                        return false;
                    else
                        squs[index] |= 1<<val;
                }
            }
        }
        return true;

    }
    public static void main(String[] args) {
        for(int i =0;i< 9;i++){
            for (int j =0;j < 9 ; j++) {
                int val = i/3*3 + j/3;
                System.out.print(val +" ");
            }
            System.out.println();
        }
        System.out.println("Hello world");
    }
}
