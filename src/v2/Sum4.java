/*
4Sum 
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Sum4{
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i =0; i < num.length;i++ ) {
            list.add(num[i]);
        }
        Collections.sort(list);
        System.out.println(list);
        for (int i=0;i < list.size()-3 ;i++ ){
            if(list.get(i) > target)
                break;
            for (int j =i+1; j <list.size()-2 ;j++ ){
                if(list.get(i)+list.get(j) > target)
                    break;
                for (int m = j+1, n = list.size()-1; m < n ; ) {
                    if(list.get(i)+list.get(j)+list.get(m)+list.get(n) > target)
                        n--;
                    else if(list.get(i)+list.get(j)+list.get(m)+list.get(n) < target)
                        m++;
                    else{
                        List<Integer> intList = new ArrayList<Integer>();
                        intList.add(i);
                        intList.add(j);
                        intList.add(m);
                        intList.add(n);
                        result.add(intList);
                    }

                }
            }


        }
        return result;

    }
    public static void main(String[] args) {
        int[] array={1,2,3,6,3,7,1,3,6};
        List<List<Integer>> result = new Sum4().fourSum(array,9);
        for (int i =0; i < result.size();i++ ) {
            System.out.println(result.get(i));
        }
        System.out.println("Hello World");
    }


}