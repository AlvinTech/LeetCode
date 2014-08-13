import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2014-7-17
 * @author Alvin
 * 
 */

public class Combination_Sum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> li = new ArrayList<Integer>();
    	combination(list,li,candidates,target);
		return list;
        
    }
    
    public void combination(List<List<Integer>> list ,List<Integer> li,int[] candidates,int target ){
    	if(target <= 0){
    		if(target == 0 && !list.contains(li)){
    			list.add(li);
    		}
    		return;
    	}
    	for(int i =0; i < candidates.length;i++){
    		List<Integer> liNew = new ArrayList<Integer>(li);
    		int index =0;
    		while(index < liNew.size() &&candidates[i] > liNew.get(index)){
    			index++;
    		}
    		liNew.add(index,candidates[i]);
    		combination(list,liNew,candidates,target-candidates[i]);
    	}
    }
	public static void main(String[] args) {
		int[] candidates ={7,12,5,10,9,4,6,8};
		int target = 32;
		List<List<Integer>> list = new Combination_Sum().combinationSum(candidates, target);
		for(int i =0 ;i< list.size();i++){
			System.out.println(Arrays.toString(list.get(i).toArray()));
		}

	}

}
