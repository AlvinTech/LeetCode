/*
Subsets II 
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] num){
        Arrays.sort(num);
        int size = num.length ;
        int total = (int)Math.pow(2,size);
        List<List<Integer>>  result= new ArrayList<List<Integer>>();
        for(int i=0;i < total;i++)
            result.add(new ArrayList<Integer>());
        for(int i =0;i < size;i++)
            for(int  j=0;j < total;j++)
                if(((j >> i) & 1)==1)
                    result.get(j).add(num[i]);
        List<List<Integer>> result2 = new ArrayList<List<Integer>>();
        for(int i = 0 ; i< size;i++){
            if(!result2.contains(result.get(i))){
                result2.add(result.get(i));
            }
        }
        return result2;
    }
    public static void main(String[] args){
        System.out.println("Hello world");
    }
} 