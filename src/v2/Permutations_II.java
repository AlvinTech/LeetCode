/*
Permutations_II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Time Limit Exceeded
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Permutations_II {
    List<List<Integer>>  result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    int length;
    boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] num) {
        if(num == null || num.length ==0)
            return result;
        length = num.length;
        flag = new boolean[num.length];
        Arrays.sort(num);
        permutations(num);
        return result;
    }
    public void permutations(int[] num){
        if(list.size() == length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0; i< length;i++){
            if(flag[i])
                continue;
            if(i > 0 && num[i] == num[i-1] && !flag[i-1])
                continue;
            flag[i] = true;
            list.add(num[i]);
            permutations(num);
            //roll back
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] num = {1,1,2};
        List<List<Integer>>   list = new Permutations_II().permuteUnique(num);
        for(int i =0 ;i< list.size();i++){
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }




    }

}
