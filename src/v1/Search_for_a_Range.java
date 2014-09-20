package v1;
import java.util.Arrays;

/**
 * 2014-7-2
 * @author Alvin
 * 
 */

public class Search_for_a_Range {
	public int[] searchRange(int[] A, int target) {
	        int index[] = new int[2];
	        index[0] = find(A,0,A.length-1,target,true);
	        index[1] = find(A,0,A.length-1,target,false);
	        return index;
	}
	public int find(int[] A, int sta, int end,int target,boolean flag){
		if(sta > end)
			return -1;
		else{
			int mid = (sta + end) / 2 ;
			if(A[mid] == target){
				if(flag){
					//find minIndex
					int index = mid-1;
					if(index  < sta)
						return sta;
					if(A[mid-1] == target)
						return find(A,sta,mid-1,target,flag);
					else
						return mid;
				}
				else{
					int index = mid+1;
					if(index  > end)
						return end;
					if(A[mid+1] == target)
						return find(A,mid+1,end,target,flag);
					else
						return mid;
				}
			}
			else if(A[mid] > target){
				// x > target  find target in the left
				return find(A,sta,mid-1,target,flag);
			}else
				// x < target  find target in the right
				return find(A,mid+1,end,target,flag);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A ={5, 7, 7, 8, 8, 10};
		int target  = 8;
		System.out.println(Arrays.toString(new Search_for_a_Range().searchRange(A, target) ));
	}

}
