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
 package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

 public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null )
            return 0;
        List<Integer> list = triangle.get(triangle.size()-1);
        int[] min = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++)
            min[i] = list.get(i);
        for(int i = triangle.size()-2; i >= 0; i--){
            list = triangle.get(i);
            for(int j = 0 ; j <= i; j++){
                min[j] = list.get(i) + Math.min(min[j],min[j+1]);
            }
        }
        return min[0];
    }

}
