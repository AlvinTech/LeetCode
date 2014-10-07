 /**   Search for a Range
 * 2014-7-2
 * @author Alvin
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
 package com.alvin.java;
import java.util.Arrays;

public class Search_for_a_Range {
    public int[] searchRange(int[] A, int target) {
        int index[] = new int[2];
        index[0] = find(A,0,A.length-1,target,true);
        index[1] = find(A,0,A.length-1,target,false);
        return index;
    }
    public int find(int[] A, int sta, int end,int target,boolean flag){
        if(sta > end)
            return -1;
        else{
            int mid = (sta + end) / 2 ;
            if(A[mid] == target){
                if(flag){
                    //find minIndex
                    int index = mid-1;
                    if(index  < sta)
                        return sta;
                    if(A[mid-1] == target)   //确保find 函数肯定能找到一个。
                        return find(A,sta,mid-1,target,flag);
                    else
                        return mid;
                }
                else{
                    int index = mid+1;
                    if(index  > end)
                        return end;
                    if(A[mid+1] == target) //确保find 函数肯定能找到一个。
                        return find(A,mid+1,end,target,flag);
                    else
                        return mid;
                }
            }
            else if(A[mid] > target){
                // x > target  find target in the left
                return find(A,sta,mid-1,target,flag);
            }else
                // x < target  find target in the right
                return find(A,mid+1,end,target,flag);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] A ={5, 7, 7, 8, 8, 10};
        int target  = 8;
        System.out.println(Arrays.toString(new Search_for_a_Range().searchRange(A, target) ));
    }

}
