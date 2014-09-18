package v1;
/**
 * 2014-8-31
 * @author Alvin
 * 
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
//class Interval{
//	int start;
//	int end;
//	Interval(){start = 0; end =0;}
//	Interval(int s, int e){this.start = s; this.end = e;}
//	public String toString(){return "start: "+ start+" end: "+end+"\n";}
//}
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
		//第一个比newInterval.end大的位置
		int rightIndex = left;
		
		if(leftIndex >= 0 && newInterval.start <= intervals.get(leftIndex).end)
			newInterval.start = Math.min(newInterval.start,intervals.get(leftIndex).start);
		else
		    ++leftIndex;
		//check right boundary
		if(rightIndex < intervals.size() && intervals.get(rightIndex).start <= newInterval.end)
			newInterval.end = Math.max(newInterval.end,intervals.get(rightIndex).end);
		else
		    --rightIndex;
		
		intervals.add(leftIndex,newInterval);
		if(rightIndex  >= leftIndex){
			
			for (int i = leftIndex;i<= rightIndex ;i++ ) {
				intervals.remove( leftIndex+1);
			}
		}
		return intervals;
	}

	public static void main(String[] args) {
		List<Interval> result = new ArrayList<Interval>();
		Interval a = new Interval(1,4);
		Interval b = new Interval(1,5);
		result.add(a);
		
		result = new Insert_Interval().insert(result, b);
		for(int i = 0 ; i< result.size();i++)
			System.out.println(result.get(i).toString());
		System.out.println(Arrays.toString(result.toArray()));
		int array1[] = {1,23,4,5};
	

	}

}
