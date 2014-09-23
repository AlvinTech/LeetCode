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
    List<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> permute(int[] num) {
        int[] flag = new int[num.length];
        DFS(list,num,flag,num.length);
        return result;
    }
    public void DFS(List<Integer> list,int[] num,int[] flag,int index){
        if(index ==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        int k =0;
        for(int i=0; i< index;i++){
            while(flag[k % num.length] != 0){
                k ++;
            }
            List <Integer> listNew = new ArrayList<Integer>(li);
            listNew.add(num[k]);
            int[] flagNew = Arrays.copyOf(flag, flag.length);
            flagNew[k % num.length] = 1;
            DFS(list,listNew,num,flagNew,index-1);
            k++;
        }
    }
    public static void main(String[] args) {
        int[] num = {1,1,2};
        List<List<Integer>>   list = new Permutations().permute(num);
        for(int i =0 ;i< list.size();i++){
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }




    }

}
