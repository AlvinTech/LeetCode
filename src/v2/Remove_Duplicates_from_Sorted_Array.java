/*
Remove_Duplicates_from_Sorted_Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/
import java.util.Arrays;
public class Remove_Duplicates_from_Sorted_Array {

    public int removeDuplicates(int[] A) {
        if(A ==null || A.length ==0)
            return 0;
        else{
            int length = A.length-1;
            int index =1;
            int count = 0;
            for(int i=0;i< length;i++){
                if(A[i] != A[i+1]){
                    A[index] = A[i+1];
                    index++;
                }
            }
            return index;
        }
    }


    private void resetArray(int[] a, int i, int count,int length) {
        for(int j =i; j<= length;j++){
            a[j-count] = a[j];
        }
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,3};
        System.out.println(new Remove_Duplicates_from_Sorted_Array().removeDuplicates(a));
        System.out.println(Arrays.toString(a));

    }

}
