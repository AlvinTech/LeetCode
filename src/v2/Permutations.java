/**     Permutations
 * 2014-7-15
 * @author Alvin
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Permutations {

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>>   list = new ArrayList<List<Integer>>();
        int[] flag = new int[num.length];
        function(list,new ArrayList<Integer>(),num,flag,num.length);
        return list;
    }
    public void function(List<List<Integer>>list, List<Integer> li,int[] num,int[] flag,int index){
        if(index ==0){
            if(!list.contains(li))
                list.add(li);
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
            function(list,listNew,num,flagNew,index-1);
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
