/**     Permutations
 * 2014-7-15
 * @author Alvin
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    List<List<Integer>>   result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();    // save the answer
    boolean[] flag ;                                      // the numbers is used ;
    int length ;
    public List<List<Integer>> permute(int[] num) {
        length = num.length;
        if(length == 0) return result;
        flag = new boolean[length];      //init flag
        DFS(num);        // dfs deep first research
        return result;                   // return
    }
    public void DFS(int[] num){   //index is  how many numbers do not add the list
        if(list.size() ==  length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0; i< length ;i++){
            if(flag[i])
                continue;
            list.add(num[i]);
            flag[i] = true;
            DFS(num);
            list.remove(list.size() -1);     // rall back
            flag[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] num = {1};
        List<List<Integer>>   list = new Permutations().permute(num);
        for(int i =0 ;i< list.size();i++){
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }




    }

}
