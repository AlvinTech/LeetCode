package v1;
/**
 * 2014-9-3
 * @author Alvin
 * 
 */

/*
Surrounded Regions 
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
import java.util.Arrays;
import java.util.Stack;
public class Surrounded_Regions{
    public void solve(char[][] board) {
    	if(board == null || board.length == 0)
    		return ;
    	int m = board.length;
    	int n = board[0].length;
        for(int i =0 ;i <m;i++){
        	// board[0][0..n]
        	if(board[i][0] == 'O'){
        		fillBoard(i,0,board,m,n);
        	}
        	if(board[i][n-1] == 'O'){
        		fillBoard(i,n-1,board,m,n);
        	}
        }

        for(int i =0 ;i <n;i++){
        	if(board[0][i] == 'O'){
        		fillBoard(0,i,board,m,n);
        	}
        	if(board[m-1][i] == 'O'){
        		fillBoard(m-1,i,board,m,n);
        	}
        }
        for(int i =0 ;i <m;i++)
        	 for(int j =0 ;j <n;j++){
        		if(board[i][j] == 'O'){
        			board[i][j] ='X';
        		}
        		if(board[i][j] == '1'){
        			board[i][j] ='O';
        		}
        }
      

    }
    public void fillBoard(int x, int y,char[][] board,int m ,int n){
    	Stack<Integer> iStack = new Stack<Integer>();
    	Stack<Integer> jStack = new Stack<Integer>();
    	iStack.add(x);
    	jStack.add(y);
    	while(!iStack.empty()){
    		x = iStack.pop();
    		y = jStack.pop();
    		board[x][y] = '1';
    		
    		//left
    		int i = x;
        	int j = y-1 > 0? y-1 : 0;
        	if(board[i][j] == 'O'){
        		iStack.add(i);
        		jStack.add(j);
        	}
        	//UP
        	i = x-1>0 ? x-1: 0;
        	j = y;
        	if(board[i][j] == 'O'){
        		iStack.add(i);
        		jStack.add(j);
        	}
         	//down
        	i = x+1 < m ?x+1 : m-1;
        	j = y;
        	if(board[i][j] == 'O'){
        		board[i][j] = '1';
        		fillBoard(i,j,board,m,n);
        	}
        	//right
        	i = x;
        	j = y+1 < n? y+1: n-1;
        	if(board[i][j] == 'O'){
        		iStack.add(i);
        		jStack.add(j);
        	}
    	}
    }
    public void fillBoard1(int x, int y,char[][] board,int m ,int n){
    	//up
    	int i = x;
    	int j = y-1 >= 0? y-1 : 0;
    	if(board[i][j] == 'O'){
    		board[i][j] = '1';
    		fillBoard(i,j,board,m,n);
    	}
    	
    	//down
    	i = x;
    	j = y+1 < n? y+1: n-1;
    	if(board[i][j] == 'O'){
    		board[i][j] = '1';
    		fillBoard(i,j,board,m,n);
    	}
    	
    	//left
    	i = x-1>0? x-1: 0;
    	j = y;
    	if(board[i][j] == 'O'){
    		board[i][j] = '1';
    		fillBoard(i,j,board,m,n);
    	}
    	
    	//right
    	i = x+1 < m ?x+1 : m-1;
    	j = y;
    	if(board[i][j] == 'O'){
    		board[i][j] = '1';
    		fillBoard(i,j,board,m,n);
    	}
    	
    }
	public static void main(String[] args) {
		char[][] board = {
		{'X','X','X','X'},
		{'X','O','O','X'},
		{'X','X','O','X'},
		{'X','O','X','X'}
	};
//		char[][] board = {
//				{'X','X','X'},
//				{'X','O','X'},
//				{'X','X','X'},
//			
//			};
	new Surrounded_Regions().solve(board);
		for(int i=0;i<board.length;i++){
			System.out.println(Arrays.toString(board[i]));
		}
 		System.out.println("Hello World");
	}
} 