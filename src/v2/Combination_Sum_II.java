/*
Combination Sum II 
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Combination_Sum_II {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        for(int i=0;i < num.length;i++)
            numList.add(num[i]);
        Collections.sort(numList);
        addSum(numList,list,target,0);
        return result;

    }
    public void addSum(List<Integer> num,List<Integer> list,int target,int index){
        int length = num.size();
        if(target == 0){
            if(!result.contains(list))
                result.add(new ArrayList<Integer>(list));
            return;
        }

        if(index >= length)
            return;

        for (int i = index;i<length ;i++ ) {
            if(num.get(i) > target)
                break;
            list.add(num.get(i));
            addSum(num,list,target-num.get(i),i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]  num ={10,1,2,7,6,1,5};
        List<List<Integer>> result = new Combination_Sum_II().combinationSum2(num,8);
        for (int i=0;i< result.size() ;i++ ) {
            System.out.println(result.get(i));
        }
    }
}