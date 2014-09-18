/**   Sudoku Solver
 * 2014-9-6
 *
 * @author Alvin
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.


A sudoku puzzle...


...and its solution numbers marked in red.
 */

public class Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        sudoku(board,0);
    }

    private boolean sudoku(char[][] board, int pos) {
        int n = board.length;
        if(pos == n*n)
            return true;
        int x = pos/n;
        int y = pos%n;
        if(board[x][y]  == '.'){
            for(char c= '1'; c <= '9'; c++){
                board[x][y] = c;
                if(isValidSudoku(board,x,y) && sudoku(board,pos+1))
                    return true;
                board[x][y] ='.';
            }

        }else{
            if(sudoku(board,pos+1))
                return true;

        }
        return false;
    }

    public boolean isValidSudoku(char[][] board,int x,int y) {
        char c = board[x][y];
        for(int i=0; i < 9;i++){
            if(y != i && board[x][i] == c)
                return false;
            if(x != i && board[i][y] == c)
                return false;
        }
        int xx = x/3 *3;
        int yy = y/3 *3;
        for(int i = xx;i < xx+3;i++)
            for(int j = yy; j < yy+3;j++){
                if(x != i && y !=j && board[i][j] == c)
                    return false;
            }
        return true;
    }

    public static void print(char[][] board,int rows, int cols){
        for(int i=0;i< rows;i++){

            for(int j =0;j < cols;j++){
                System.out.print(board[i][j]+ "  ");
            }
            System.out.println();
        }
    }
    public void solveSudoku2(char[][] board) {
        dfs(board, 0);
    }
    private boolean dfs(char[][] board, int pos)
    {
        int n = board.length;
        if (pos == n*n)
        {
            return true;
        }
        int x = pos / n;
        int y = pos % n;
        if (board[x][y] == '.')
        {
            for (char c='1'; c<='9'; ++c)
            {
                board[x][y] = c;
                if (validate(board, x, y) && dfs(board, pos+1))
                {
                    return true;
                }
                board[x][y] = '.';
            }
        }
        else
        {
            if (dfs(board, pos+1))
            {
                return true;
            }
        }
        return false;
    }
    private boolean validate(char[][] board, int x, int y)
    {
        char c = board[x][y];
        for (int i=0; i<9; ++i)
        {
            if (y != i && board[x][i] == c)
            {
                return false;
            }
            if (x != i && board[i][y] == c)
            {
                return false;
            }
        }
        int xx = x / 3 * 3;
        int yy = y / 3 * 3;
        for (int i=xx; i<xx+3; ++i)
        {
            for (int j=yy; j<yy+3; ++j)
            {
                if (x != i && y != j && board[i][j] == c)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board={{'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'},
        };
        new Sudoku_Solver().solveSudoku(board);
        print(board,9,9);

    }

}
