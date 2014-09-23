/*解题思路：深度优先算法
N_Queens II
Now, instead outputting board configurations, return the total number of distinct solutions.
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class N_Queens_II {
    List<String[]> list = new ArrayList<String[]>();
    public int totalNQueens(int n) {
        String []board= new String[n];
        char[] init = new char[n];
        Arrays.fill(init, '.');
        for (int i =0; i < n ;i++ ) {
            board[i]= new String(init,0,n);
        }
        nextQueens(board,0,n);
        return list.size();
    }
    public void nextQueens(String[] board,int row,int n){
        if(row >= n){
            list.add(copy(board));
            return ;
        }
        char[] crow = board[row].toCharArray();
        for(int col=0; col< n;col++){
            if(ok(board,row,col,n)){
                crow[col] ='Q';
                board[row] = new String(crow);
                nextQueens(board,row+1,n);
                crow[col] ='.';
            }
        }
        board[row] = new String(crow);
    }
    public String[] copy(String[] board){
        String[] newboard = new String[board.length];
        for(int i = 0 ; i<board.length ; i++){
            newboard[i] = board[i].substring(0);
        }
        return newboard;
    }
    public boolean ok(String[] board,int row, int col,int n){
        for(int i =0 ; i < row; i++){
            // 确保列上不会重复
            if(board[i].charAt(col) == 'Q')
                return false;
            // 确保对角线不会重复
            int temp = col - row +i;
            if(temp >=0 && board[i].charAt(temp) == 'Q')
                return false;
            int temp1 = col + row -i;
            if(temp1 < n && board[i].charAt(temp1) == 'Q')
                return false;
        }
        return true;
    }

    public void  printBoard(String[] board){
        for(int i =0 ;i< board.length;i++)
            System.out.println(board[i]);
    }
    public static void main(String[] args){
        List<String[]> list = new N_Queens().solveNQueens(4);
        String[] board;
        for(int i = 0; i< list.size();i++){
            board = list.get(i);
            for(int j = 0 ; j < board.length;j++)
                System.out.println(board[j].toString());

            System.out.println("*****************");
        }

    }
}