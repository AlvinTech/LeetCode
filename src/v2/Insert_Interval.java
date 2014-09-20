/*
Insert Interval 
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
import java.util.List;
import java.util.ArrayList;
class Interval{
    int start;
    int end;
    Interval(){start = 0; end =0;}
    Interval(int s, int e){this.start = s; this.end = e;}
    public String toString(){return "start: "+ start+" end: "+end+"\n";}
}
public class Insert_Interval {

    public List<Interval> insert(List<Interval> intervals,Interval newInterval){
        if(newInterval ==  null)
            return intervals;
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }

        //binary search
        // 找比newInterval.start 大的点（不等于）；
        int left = 0;
        int right = intervals.size()-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(intervals.get(mid).start < newInterval.start)
                left = mid+1;
            else
                right = mid-1;
        }
        //第一个比newInterval.start小的位置
        int leftIndex = right;

        //binary search
        // 找比newInterval.end 小的点（不等于）；
        left = 0;
        right = intervals.size()-1;
        while(left <= right){
            int mid = (left +  right)/2;
            if(intervals.get(mid).end <newInterval.end)
                left =  mid +1;
            else
                right  = mid -1;
        }
        //第一个比newInterval.end大的位置（不包含等于）
        int rightIndex = left;

        //check left boundary 区间有重叠例如[1,5][2,6] start重叠
        if(leftIndex >= 0 && newInterval.start <= intervals.get(leftIndex).end)
            newInterval.start = Math.min(newInterval.start,intervals.get(leftIndex).start);
        else
            ++leftIndex;//区间不重叠的时候 该区域不能删除 leftIndex需要向后移动一位。
        //check right boundary 区间有重叠例如[5,10][2,9] end 重叠
        if(rightIndex < intervals.size() && intervals.get(rightIndex).start <= newInterval.end)
            newInterval.end = Math.max(newInterval.end,intervals.get(rightIndex).end);
        else
            --rightIndex;// 没有重叠需要向左边移动一位 如果越界了同意左移一位

        //添加新的区间
        intervals.add(leftIndex,newInterval);

        //删除原有已经被覆盖的区间
        if(rightIndex  >= leftIndex){
            for (int i = leftIndex;i<= rightIndex ;i++ ) {
                //leftIndex 位置已经插入新值 所以只能删除leftIndex+1;
                intervals.remove( leftIndex+1);
            }
        }
        return intervals;
    }
    public static void main(String[] args) {
        List<Interval> result = new ArrayList<Interval>();
        Interval a = new Interval(1,5);
        Interval b = new Interval(6,8);
        result.add(a);

        result = new Insert_Interval().insert(result, b);
        for(int i = 0 ; i< result.size();i++)
            System.out.println(result.get(i).toString());


    }

}
