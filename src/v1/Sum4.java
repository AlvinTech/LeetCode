package v1;
/**
 * 2014-9-6
 * @author Alvin
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Sum4{
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i =0; i < num.length;i++ ) {
    		list.add(num[i]);
    	}
    	Collections.sort(list);
  
    	for (int i=0;i < list.size()-3 ;i++ ){
    		if(list.get(i) > target && list.get(i) >0)
    			break;
    		for (int j =i+1; j <list.size()-2 ;j++ ){
    			if(list.get(i)+list.get(j) > target && list.get(j) >0)
    				break;
    			for (int m = j+1, n = list.size()-1; m < n ; ) {
    				if(list.get(i)+list.get(j)+list.get(m)+list.get(n) > target)
    					n--;
    				else if(list.get(i)+list.get(j)+list.get(m)+list.get(n) < target)
    					m++;
    				else{
    					List<Integer> intList = new ArrayList<Integer>(); 
    					intList.add(list.get(i));
    					intList.add(list.get(j));
    					intList.add(list.get(m));
    					intList.add(list.get(n));
    					if(!result.contains(intList))
    						result.add(intList);
    					m++;
    				}

    			}
    		}
    				
    		
    	}
    	return result;
        
    }	
	public static void main(String[] args) {
		int[] array={1,-2,-5,-4,-3,3,3,5};
		List<List<Integer>> result = new Sum4().fourSum(array,-11);
		for (int i =0; i < result.size();i++ ) {
			System.out.println(result.get(i));
		}
		System.out.println("Hello World");
	}

	
}