/*
Next Permutation 

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
思路：只要发现不是按照降序排列的，就可以有next；
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Next_Permutation {
    public void nextPermutation(int[] num) {
        List<Integer> list = new ArrayList<Integer>();
        int length = num.length;
        if(num == null||length == 0)
            return ;
        int big = num[length-1];
        int target = num[length-1];

        int index = -1;
        for(int i =num.length-1 ;i>0;i--){  //检测是否降序排列
            if(num[i-1] < num[i]){          // 如果不是 j
                target = num[i-1];         //记录目标值，该为的新值需要比该值大。
                list.add(num[i-1]);
                list.add(num[i]);
                index = i-1;             //记下坐标
                break;
            }
            list.add(num[i]);
        }

        Collections.sort(list);

        if(index  == -1){  // 全部是降序，则放回一个升序。
            for (int i=0; i < list.size() ;i++ ) {
                num[i] = list.get(i);
            }
            return;
        }

        for (int i=0;i < list.size() ;i++ ) {    // 寻找一个比target 大的最小值。
            if(target < list.get(i)){
                target = list.get(i);
                list.remove(i);  //移除该值。
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