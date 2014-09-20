package v1;
/**
 * 2014-9-10
 * @author Alvin
 * 
 */

public class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0)
			return 0;
		int cols = matrix[0].length;
		int rows = matrix.length;
		int[][] h = new int[rows][cols];
		int max = 0 ;
		int area= 0;
		for(int i=0 ; i< rows; i++){
			for(int j=0; j < cols; j++){
				if(matrix[i][j] == '0'){
					continue;
				}
				if (j == 0){
					h[i][j] =1;
				}
				else{
					h[i][j] = h[i][j-1] + 1;
				}
				
				int y =1;
				int x = cols;
				while(i - y +1 >=0 && h[i-y+1][j] >0){
					x = Math.min(x, h[i-y+1][j]);
					max = Math.max(max, x*y);
					y++;
					
				}
				
			}
		}
		return max;
	}
	public int maximalRectangle1(char[][] matrix){
    int area = 0;
    int numRows = matrix.length;
    if (numRows == 0) return 0;
    int numCols = matrix[0].length;
    if (numCols == 0) return 0;
    int [][] rowArea = new int[numRows][numCols];
    for (int i = 0; i < numRows; i++) { // y
        for (int j = 0; j < numCols; j++) {
            if (matrix[i][j] == '0') continue;
            else {
                if (j == 0) rowArea[i][j] = 1;
                else {
                    rowArea[i][j] = rowArea[i][j-1] + 1;
                }
                int y = 1;
                int x = numCols;
                while(i-y+1 >= 0 && rowArea[i-y+1][j] > 0) {
                    x = Math.min(x, rowArea[i-y+1][j]);
                    area = Math.max(area, x*y);
                    y++;
                }
            }
        }
    }
    return area;
}
	public static void main(String[] args) {
		char matrix[][] ={{'0','1'},{'1','0'}};
		System.out.println(new Maximal_Rectangle().maximalRectangle(matrix));

	}

}
