/**
 * 2014-7-7
 * @author Alvin
 * 
 */

public class Valid_Sudoku {

	public boolean isValidSudoku(char[][] board) {
	     int length = board.length;
	     int[] col = new int[10];
	     int[] row = new int[10];
	     
	     if(length <=0)
	    	 return false;
	     else{
	    	 for(int i =0; i< length; i++){
	    		 for(int j =0 ;j< length;j++){
	    			 if(board[i][j]!='.'){
	    				 int  index = board[i][j]-'0';
	    				 if(row[index] !=0)
	    					 return false;
	    				 else
	    					 row[index] =1;
	    			 }
	    			 if(board[j][i]!='.'){
	    				 int index = board[j][i]-'0';
	    				// if(index == 5)
	    				//	 System.out.println(index);
	    				 if(col[index] !=0)
	    					 return false;
	    				 else
	    					 col[index] =1;
	    			 }
	    		 }
	    		 col = new int[10];
	 	    	row = new int[10];
	    	 }
	    	
	     }
	     return true;
	}
	public static void main(String[] args) {
		char[][] board={{'.','.','.','.','5','.','.','1','.'},
						{'.','4','.','3','.','.','.','.','.'},
						{'.','.','.','.','.','3','.','.','1'},
						{'8','.','.','.','.','.','.','2','.'},
						{'.','.','2','.','7','.','.','.','.'},
						{'.','1','5','.','.','.','.','.','.'},
						{'7','.','.','.','.','2','.','.','.'},
						{'.','2','.','9','.','.','.','.','.'},
						{'.','.','4','.','.','.','.','.','.'},
		};
		
		System.out.println(new Valid_Sudoku().isValidSudoku(board));

	}

}
