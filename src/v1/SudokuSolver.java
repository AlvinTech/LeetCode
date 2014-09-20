package v1;
import java.util.Arrays;

/**
 * 2014-6-6
 * @author Alvin
 * 
 */
public class SudokuSolver {
	   public void solveSudoku(char[][] board) {
		   int rows =9 ,cols = 9;
		   char[][] newBoard =new char[9][9];
	       sudoku(0,-1,board,rows,cols,newBoard) ;
	       for(int i=0;i< 9;i++)
				for(int j =0;j <9 ;j++)
					board[i][j] = newBoard[i][j];
	      
	    }
	   
	public boolean sudoku(int x,int y,char[][] board ,int rows ,int cols,char[][] newBoard){
		//print(board,9,9);
		if(x == rows -1 && y == cols-1 ){
			if(isValidSudoku(board)){
				for(int i=0;i< 9;i++)
					for(int j =0;j <9 ;j++)
						newBoard[i][j] = board[i][j];
			}
			return false;
			
		}
		else{
			if(y == cols -1){
				x = x+1;
				y =0;
			}else
				y ++;
		}
		
		if(board[x][y] !='.'){
			  return sudoku(x,y,board,rows,cols,newBoard);
				
		}else{
			//Vector<Character> v = validate(x,y,board,rows,cols);
			char[] v = validate(x,y,board,rows,cols);
			/*while(!v.isEmpty()){
				board[x][y] = (char) v.get(0);
				if (sudoku(x,y,board,rows,cols) == false){
					v.remove(0);
				}else
					break;
			}*/
			for(int i=0; i< v.length  ;i++){
				if(v[i]=='0')
					continue;
				
				board[x][y] = v[i];
				sudoku(x,y,board,rows,cols,newBoard);
				
			}
				board[x][y] ='.';
				return false;
		}
		
	}
	public boolean isValidSudoku(char[][] board) {
		int[] cols = new int[9];
		int[] rows = new int[9];
		int[] squs = new int[9];
		Arrays.fill(cols, 0);
		Arrays.fill(rows, 0);
		Arrays.fill(squs, 0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '0') {
					int val = board[i][j] - '0';
					if ((rows[i] & 1 << val) > 0)
						return false; // 一行出现 重复数。
					else
						rows[i] |= 1 << val;
					if ((cols[j] & 1 << val) > val)
						return false;// 一列出现重复数；
					else
						cols[j] |= 1 << val;
					int index = i / 3 * 3 + j / 3;
					if ((squs[index] & 1 << val) > 0)
						return false;
					else
						squs[index] |= 1 << val;
				}
			}
		}
		return true;

	}
	public char[] validate(int x, int y, char[][] board,int rows, int cols){
		char[] v = {'1','2','3','4','5','6','7','8','9',};
		for(int i=0; i< rows;i++){
			if(board[i][y] != '.'){
				v[board[i][y]-'0'-1] ='0';
			}
			if(board[x][i] != '.'){
				v[board[x][i]-'0'-1] ='0';
			}
		}
		return v;
	}
	
	public static void print(char[][] board,int rows, int cols){
		for(int i=0;i< rows;i++){
			
			for(int j =0;j < cols;j++){
				System.out.print(board[i][j]+ "  ");
			}
			System.out.println();
		}
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
		

		new SudokuSolver().solveSudoku(board);

		print(board,9,9);
	}

}
