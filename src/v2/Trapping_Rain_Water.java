/**
 * 2014-6-3
 * @author Alvin
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Thanks Marcos for contributing this image!
 */

public class Trapping_Rain_Water {
    public int trap(int[] A) {
        if(A.length < 1){
            return 0;
        }
        int maxIndex = 0;
        int maxHeight = A[0];
        int total = 0;
        for(int i=1;i< A.length;i++){
            if(A[i]>A[i-1]){
                total += collectWater(maxIndex,maxHeight,i,A);
            }
            if(A[i]> maxHeight){
                maxIndex = i;
                maxHeight = A[i];
            }
        }
        return total;

    }

    public int collectWater(int  maxIndex, int maxHeight,int index,int[] A){
        if(maxHeight == 0){
            return 0;
        }else{
            int total = 0;
            int min = Math.min(A[index], maxHeight);
            for(int i= maxIndex+1;i<= index;i++){
                if(A[i] < min){
                    total +=min - A[i];
                    A[i] = min;
                }
            }
            return total;
        }


    }
    public static void main(String[] args) {
        int[] A={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Trapping_Rain_Water().trap(A));
    }

}
