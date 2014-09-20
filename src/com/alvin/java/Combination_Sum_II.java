package com.alvin.java;/*
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        addSum(num,list,target,0);
        return result;

    }
    public void addSum(int[] num,List<Integer> list,int target,int index){
        if(target <= 0){
            if(target == 0 && !result.contains(list))
                result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index;i < num.length ;i++ ) {
            if(num[i] > target)
                break;
            list.add(num[i]);
            addSum(num,list,target-num[i],i+1);
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