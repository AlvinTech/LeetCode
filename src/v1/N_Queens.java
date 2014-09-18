package v1;
/**
 * 2014-8-30
 * @author Alvin
 * 
 */
//N_Queens 问题 两个皇后不能出现再同一行 同一列 同一对角线上。
// 采用深度优先算法遍历数组
import java.util.List;
import java.util.ArrayList;
class N_Queens{

    public List<String[]> solveNQueens(int n) {
    	List<String[]> list = new ArrayList<String[]>();
    	String []board= new String[n];
    	char[] init = new char[n];
    	for(int i=0; i< n;i++)
    		init[i] ='.';
    	for (int i =0; i < n ;i++ ) {
    		board[i]= new String(init,0,n);
    	}
    	nextQueens(list,board,0,n);
    	return list;

        
    }
    public void nextQueens(List<String[]> list,String[] board,int row,int n){
    	if(row >= n){
    		String[] newBoard = new String[n];
    		for(int i=0;i< newBoard.length;i++){
    			newBoard[i] = board[i].substring(0);
    		}
    		list.add(newBoard);
    		return ;
    	}
    		
    	for(int col=0; col< n;col++){
    		String oldRow = board[row];
    		if(ok(board,row,col,n)){
    			String newRow = oldRow.substring(0,col)+'Q'+oldRow.substring(col+1);
    			board[row] = newRow;
    			nextQueens(list,board,row+1,n);
    		}
    		board[row] = oldRow;
    	}
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