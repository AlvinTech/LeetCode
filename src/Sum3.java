/**
 * 2014-6-8
 * @author Alvin
 * 
 */
import java.util.*;
public class Sum3 {
	 public List<List<Integer>> threeSum(int[] num) {
	    	List<List<Integer>> list = new ArrayList<List<Integer>>();
	    	List<Integer> array = new ArrayList<>();
	    	for(int i = 0;i< num.length;i++)
	    		array.add(num[i]);
	    	Collections.sort(array);
	    	for(int i = 0;i<array.size();i++)
	    		num[i] = array.get(i);
	    	
	    	for(int i =0; i< num.length;i++)
	    	{
	    		if(i >= 1 && num[i] ==num[i-1]){
	    			continue;
	    		}
	    		int j = i+1;
	    		int k = num.length-1;
	    		
	    		while(j < k){
	    			int sum =  num[i] + num[j] + num[k];
	    			if(sum > 0){
	    				int val = num[k];
	    				while(k >0 &&num[k] == val)
	    					k--;
	    				
	    			}else if(sum < 0){
	    				int val = num[j];
	    				while(j < num.length && num[j] == val)
	    					j++;
	    			}else{
	    				List<Integer> array1 = new ArrayList<>();
    					array1.add(num[i]);
    					array1.add(num[j]);
    					array1.add(num[k]);
    					if(!list.contains(array1))
    						list.add(array1);
    					j++;
	    			}
	    		}
	    	}
	       return list; 
	    }
    public List<List<Integer>> threeSum1(int[] num) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> array = new ArrayList<>();
    	for(int i = 0;i< num.length;i++)
    		array.add(num[i]);
    	Collections.sort(array);
    	for(int i = 0;i<array.size();i++)
    		num[i] = array.get(i);
    	
    	for(int i =0; i< num.length;i++)
    	{
    		if(num[i] >0)
    		{
    			i= num.length ;
    			break;
    		}
    
    		for(int j=i+1; j < num.length;j++)
    		{
    			if(num[i] + num[j]>0){
    				j=num.length;
    				break;
    			}
    			for(int k = j+1;k < num.length;k++){
    				if(num[i] + num[j] + num[k] >0){
    					k = num.length;
    					break;
    				}
    				if(num[i] + num[j] + num[k] == 0){
    					List<Integer> array1 = new ArrayList<>();
    					array1.add(num[i]);
    					array1.add(num[j]);
    					array1.add(num[k]);
    					if(!list.contains(array1))
    						list.add(array1);
    				}
    			}
    		}
    	}
       return list; 
    }
    public List<Integer> order(int a,int b,int c){
    	List<Integer> list  = new ArrayList<Integer>();
    	int val ;
    	// a > b
    	if(a <= b){
    		val = a;
    		a = b;
    		b = val;
    	}
    	//
    	if(c >= a){
    		list.add(b);
    		list.add(a);
    		list.add(c);
    	}else{
    		if(c >= b){
    			list.add(b);
    			list.add(c);
    			list.add(a);
    		}else{
    			list.add(c);
    			list.add(b);
    			list.add(a);
    		}
    	}
    	return list;
    }
	public static void main(String[] args) {
		int[] num = {0,-4,-1,-4,-2,-3,2};
		new Sum3().threeSum(num);
		System.out.println(Arrays.toString(new Sum3().order(1, 0, 3).toArray()));

	}

}
