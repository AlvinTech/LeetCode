/**
 * 2014-5-29
 * @author Alvin
 * 
 */

public class Set_Matrix_Zeroes {

    public void setZeroes(int[][] matrix) {
    	if(matrix.length ==0)
    		return ;
    	else if(matrix[0].length == 0)
    		return ;
    	boolean firstRow = false,
    			firstClo = false;
    	for(int i=0;i< matrix.length;i++){
    		if(matrix[i][0] == 0){
    			firstClo = true;
        		break;
    		}
    	}
    	
    	for(int i=0;i< matrix[0].length;i++){
    		if(matrix[0][i] ==0){
    			firstRow = true;
    			break;
    		}
    	}
    	
    	for(int i=1;i< matrix.length;i++)
    		for(int j =1;j< matrix[0].length;j++){
    			if(matrix[i][j] == 0){
    				matrix[i][0] =0;
    				matrix[0][j] =0;
    			}
    		}
    	
    	for(int i=1;i< matrix.length;i++)
    		for(int j =1;j< matrix[0].length;j++){
    			if(matrix[i][0] ==0 || matrix[0][j] ==0) matrix[i][j] =0;
    		}
    	
    	
    	if(firstRow){
    		for(int i=0;i< matrix[0].length;i++)
    			matrix[0][i]=0;	
    	}
    	if(firstClo){
    		for(int i=0;i< matrix.length;i++)
    			matrix[i][0]=0;	
    	}

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
