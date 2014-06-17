import java.util.ArrayList;

/**
 * 2014-4-28
 * @author Alvin
 * 
 */

public class Triangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null )
			return 0;
		else{
			int length = triangle.get(triangle.size()-1).size();// get the last row size
			int[] minTotal = new int[length];
			
			//init minTotal
			int i,j;
			ArrayList lastLine = triangle.get(length-1);
			for( i = 0 ; i < lastLine.size(); i++){
				minTotal[i] = (int) lastLine.get(i);
			}
			
		//from down to up
			for(i = triangle.size()-2; i>=0 ; i--){  //triangle.size()-1 is the lastline, we should form the triangle.size()-2 to the top
				ArrayList<Integer> line = triangle.get(i);
				for(j = 0; j <= i; j++){
					minTotal[j] = line.get(j) + Math.min(minTotal[j], minTotal[j+1]);
				}
			}
			
			return minTotal[0];
			
		}
	       
    }
	public static void main(String[] args) {

	}

}
