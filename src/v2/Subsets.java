/*  Subsets
该题的解题思路很像小白鼠做试毒药的问题，用位的0 或者1
来表示该数是否具有值。 
if(((j >> i) & 1)==1) 表示j 向右移动i位 & 1 可以判断第i位是不是1 ；

Subsets
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Subsets{
    public List<List<Integer>> subsets(int[] s){
        List<Integer> list = new ArrayList();

        for(int i = 0 ; i < s.length;i++)
            list.add(s[i]);
        Collections.sort(list);
        int num = list.size();
        int subNum = (int)Math.pow(2,num);
        List<List<Integer>>  result= new ArrayList<List<Integer>>();
        for(int i=0;i < subNum;i++)
            result.add(new ArrayList<Integer>());
        for(int i =0;i < num;i++)
            for(int  j=0;j < subNum;j++)
                if(((j >> i) & 1)==1)
                    result.get(j).add(list.get(i));

        return result;

    }

    public static void main(String[] args){
        System.out.println("Hello World");
        int[]s = {4,1,0};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result = new Subsets().subsets(s);
        for(int i = 0 ; i< result.size();i++)
            System.out.println(Arrays.toString(result.get(i).toArray()));
    }

}