/**  Pascal's Triangle
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return
 图有误
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(numRows == 0) return result;
        if(numRows == 1){
            result.add(list);
            return result;
        }
        generate(numRows-1);
        List<Integer> pre = result.get(result.size()-1)  ;
        for(int i =0 ; i < pre.size()-1;i++){
            list.add(pre.get(i)+pre.get(i+1));
        }
        list.add(1);
        result.add(list);
        return result;
    }
}
