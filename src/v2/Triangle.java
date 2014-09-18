/**  Triangle    有问题
 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
import java.util.ArrayList;
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null )
            return 0;
        else{
            int length = triangle.get(triangle.size()-1).size();// get the last row size
            int[] minTotal = new int[length];

            //init minTotal
            int i,j;
            ArrayList<Integer> lastLine = triangle.get(length-1);
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
}
