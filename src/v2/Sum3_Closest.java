/**
 * 2014-7-23
 * @author Alvin
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.Arrays;
public class Sum3_Closest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int result=0;
        int mx =num[0]+num[1]+num[2];
        int sum =0;
        int length = num.length;
        for (int i = 0; i < length-2; i++) {
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                sum = num[i] +num[j] + num[k];
                if (Math.abs(target - mx) > Math.abs(target - sum)) {
                    mx = sum;
                    if (mx == target) return mx;
                }
                if (sum > target)
                    k-- ;
                else
                    j++;
            }
        }
        return mx;
    }
    public static void main(String[] args) {
        int[] s ={-1,2,1,-4};
        System.out.println(new Sum3_Closest().threeSumClosest(s,100));

    }

}
