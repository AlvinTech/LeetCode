/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 **/
public class Word_Search {
    private int[][] use ;
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if(word.length()  == 0)
            return true;
        if((board.length ==0  || board[0].length ==0) && word.length() != 0)
            return false;
        m = board.length;
        n = board[0].length;
        use = new int[m][n];
        for(int i = 0; i < m;i++)
            for(int j =0 ; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1 ||  dfs(board,word.substring(1),i,j))
                        return true;
                }

            }
        return false;
    }
    public  boolean dfs(char[][] board,String word,int i, int j){
        if(word.length() ==0 )
            return true;
        String str="";
        //up
        if(i > 0 && word.charAt(0) == board[i-1][j] && use[i-1][j] == 0 ){
            use[i][j] = 1;
            str = (word.length() > 1) ? word.substring(1) : "";
            if( dfs(board,str,i-1,j))
                return true;
            use[i][j] = 0;
        }

        //right
        if(j < n-1 && word.charAt(0) == board[i][j+1] && use[i][j+1] == 0 ){
            use[i][j] = 1;
            str = (word.length() > 1) ? word.substring(1) : "";
            if( dfs(board,str,i,j+1))
                return true;
            use[i][j] = 0;
        }
        //down
        if(i < m-1 && word.charAt(0) == board[i+1][j] && use[i+1][j] == 0){
            use[i][j] = 1;
            str = (word.length() > 1) ? word.substring(1) : "";
            if( dfs(board,str,i+1,j))
                return true;
            use[i][j] = 0;
        }
        //left
        if(j > 0  && word.charAt(0) == board[i][j-1] && use[i][j-1] == 0){
            use[i][j] = 1;
            str = (word.length() > 1) ? word.substring(1) : "";
            if( dfs(board,str,i,j-1))
                return true;
            use[i][j] = 0;
        }
        return false;
    }
    public static void main(String[] args) {
//		char[][] board={
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}
//		};
        char[][] board={
                {'a','a'}
        };
        System.out.println(new Word_Search().exist(board, "aaa"));

    }

}
