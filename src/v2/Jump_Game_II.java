/*
Jump Game II 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
public class Jump_Game_II{
    public int  jump(int [] A){
        int minStep = 0;
        int distance =0;
        int current =0;
        for (int i=0; i< A.length ;i++) {
            if(i > distance){
                ++minStep;
                distance = current;
            }
            current = Math.max(current,i+A[i]);
        }
        return minStep;

    }
    public static void main(String[] args) {
        int[] array = {2,3,1,1,4};
        System.out.println(new Jump_Game_II().jump(array));
    }
} 