/*
Jump_Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
public class Jump_Game{
    public boolean canJump(int[] A) {
        if(A.length <=1)
            return true;
        for(int i =0 ;i < A.length;i++){
            if(A[i] == 0){
                int j =i;
                if(i == A.length -1)
                    return true;
                for(; j >=0 ;j--){
                    if(j+A[j] >i)
                        break;
                }
                if(j==-1)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int [] A= {2,0,0};
        System.out.println(new Jump_Game().canJump(A));
    }

}