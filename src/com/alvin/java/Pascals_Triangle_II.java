 /**    Pascal's Triangle II
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        List<Integer> pre = getRow(rowIndex-1); ;
        for(int i =0 ; i < pre.size()-1;i++){
            list.add(pre.get(i)+pre.get(i+1));
        }
        list.add(1);
        return list;
    }
}
