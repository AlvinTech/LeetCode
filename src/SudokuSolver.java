/**
 * 2014-6-6
 * @author Alvin
 * 
 */
public class SudokuSolver {
	   public void solveSudoku(char[][] board) {
		   int rows =9 ,cols = 9;
	       sudoku(0,-1,board,rows,cols) ;
	    }
	   
	public boolean sudoku(int x,int y,char[][] board ,int rows ,int cols){
		if(x == rows -1 && y == cols-1 ){
			if(board[0][0] == '5' && board[0][1] == '1'&& board[0][6] == '6'&&
					board[8][8] == '3' && board[8][7] == '8'&& board[8][0] == '6'){
				System.out.println("***************");
				print(board,9,9);
			}
			return true;
		}
		else{
			if(y == cols -1){
				x = x+1;
				y =0;
			}else
				y ++;
		}
		
		if(board[x][y] !='.'){
			return sudoku(x,y,board,rows,cols);
				
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
				sudoku(x,y,board,rows,cols) ;
						
			}
				board[x][y] ='.';
				return false;
		}
		
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
		// TODO Auto-generated method stub
	//	Vector v = new Vector<>();
		//v.add('2');
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
		
		//System.out.println(v.contains('2'));
		new SudokuSolver().solveSudoku(board);

		print(board,9,9);
	}

}
