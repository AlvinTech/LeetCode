/* Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class Interval {
//    int start;
//    int end;
//    Interval() { start = 0; end = 0; }
//    Interval(int s, int e) { start = s; end = e; }
//    public String toString(){return "start: "+ start+" end: "+end+"\n";}
//
//}
public class Merge_Intervals {

    List<Interval> list = new ArrayList<Interval>();
    public List<Interval> merge(List<Interval> intervals) {
        for (int i = 0;i < intervals.size(); i++ ) {
            insertInterval(intervals.get(i));
        }
        return list;
    }
    public void insertInterval(Interval interval){
        if(list.size() ==  0){
            list.add(interval);
            return;
        }

        int left =0;
        int right = list.size()-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(list.get(mid).start < interval.start)
                left = mid +1;
            else
                right = mid -1;
        }
        int leftIndex = right;

        left = 0;
        right = list.size()-1;
        while(left <=  right){
            int mid = (left + right) /2;
            if(list.get(mid).end < interval.end)
                left  = mid+1;
            else
                right = mid -1;
        }
        int rightIndex = left;

        if(leftIndex >=0 && interval.start <= list.get(leftIndex).end)
            interval.start = Math.min(interval.start,list.get(leftIndex).start);
        else
            ++leftIndex;
        if(rightIndex < list.size() && interval.end >=  list.get(rightIndex).start)
            interval.end = Math.max(interval.end,list.get(rightIndex).end);
        else
            --rightIndex;
        list.add(leftIndex,interval);
        if(rightIndex >= leftIndex){
            for (int j = leftIndex; j <= rightIndex ;j++ ) {
                list.remove(leftIndex+1);
            }
        }
    }
    public static void main(String[] args) {
        List<Interval> result = new ArrayList<Interval>();
        Interval a = new Interval(1,4);
        Interval b = new Interval(1,5);
        result.add(a);
        result.add(b);

        result = new Merge_Intervals().merge(result);
        for(int i = 0 ; i< result.size();i++)
            System.out.println(result.get(i).toString());
        System.out.println(Arrays.toString(result.toArray()));

    }

}
