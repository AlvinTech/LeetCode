/*
Next Permutation 

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Next_Permutation{
    public void nextPermutation(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        int length = num.length;
        if(num == null||length == 0)
            return ;
        int big = num[length-1];
        int target = num[length-1];

        int index = -1;
        for(int i =num.length-1 ;i>0;i--){
            if(num[i-1] < num[i]){
                target = num[i-1];
                list.add(num[i-1]);
                list.add(num[i]);
                index = i-1;
                break;
            }
            list.add(num[i]);
        }
        if(index  == -1)
            list.add(num[0]);

        Collections.sort(list);

        if(index  == -1){
            for (int i=0; i < list.size() ;i++ ) {
                num[i] = list.get(i);

            }
            return;
        }

        for (int i=0;i < list.size() ;i++ ) {
            if(target < list.get(i)){
                target = list.get(i);
                list.remove(i);
                break;
            }
        }

        num[index] = target;
        for (int i=0; i < list.size() ;i++ ) {
            num[i+index+1] = list.get(i);
        }

    }
    public static void main(String[] args) {
        int[] num = {1,2,1,1,5};
        new Next_Permutation().nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
} 