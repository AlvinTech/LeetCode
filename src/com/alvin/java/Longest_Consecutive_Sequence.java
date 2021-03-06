/**  Longest Consecutive Sequence
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.

 只需要更新上下边界值，因为数据的扩展只会再2端出现。所以2端的值需要确保正确，其余的位置的值可以不正确。
 mapStart 存该值的一下界
 mapEnd 寸该值的上界。
 * */


package com.alvin.java;

import java.util.HashMap;
import java.util.Map;
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] num){
        Map<Integer,Integer> mapStart = new HashMap<Integer,Integer>();
        Map<Integer,Integer> mapEnd = new HashMap<Integer,Integer>();
        int maxLength = 0;
        for(int  i = 0 ;i < num.length;i++){
            if(mapStart.containsKey(num[i]))
                continue;
            int low = num[i];
            int up = num[i];
            if(mapStart.containsKey(num[i]-1))
                low = mapStart.get(num[i]-1);
            if(mapEnd.containsKey(num[i]+1))
                up = mapEnd.get(num[i]+1);
            maxLength = Math.max(maxLength ,(up- low)+1);
            mapEnd.put(num[i],up);
            mapStart.put(num[i],low);
            mapEnd.put(low,up);
            mapStart.put(up,low);

        }
        return maxLength;
    }
}
