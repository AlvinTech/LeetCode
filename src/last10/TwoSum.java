package last10;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TwoSum {
	//隐含条件是 array 是正整数序列，且是递增序列。
	   public int[] twoSum(int[] numbers, int target) {
	        int[] two =new int[2];
	        for(int i=0;i<numbers.length;i++){
	        	if(numbers[i] >target)
	        		break;
	        	for(int j=i+1;j<numbers.length;j++){
	        		if(numbers[i]+ numbers[j] == target)
	        		{
	        			two[0] = i+1;
	        			two[1] = j+1;
	        			return two;
	        		}
	        	}
	        }
	        return two;
	        
	    }
	   
	   public static void main(String[] args){
		   int [] array = {2,7,11,15};
		   int target=9;
		   int[] two = new TwoSum().twoSum(array,target);
		   System.out.println(two[0]);
		   System.out.println(two[1]);
		   
	   }

}
