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
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Subsets_II{
    public List<List<Integer>> subsetsWithDup(int[] num){
        List<Integer> list = new ArrayList<Integer>();
        int length = num.length;
        int size =(int) Math.pow(2,length);
        for(int i = 0 ; i < length;i++)
            list.add(num[i]);

        Collections.sort(list);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0 ; i< size;i++)
            result.add(new ArrayList<Integer>());
        for(int i = 0; i< length;i++)
            for(int j = 0 ;j< size;j++){
                if(((j>>i) & 1 )== 1){
                    result.get(j).add(list.get(i));
                }
            }

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