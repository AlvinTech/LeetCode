import java.util.Arrays;

/**
 * 2014-7-23
 * @author Alvin
 * 
 */

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
