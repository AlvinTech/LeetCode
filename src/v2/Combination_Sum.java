/*
Combination_Sum
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
