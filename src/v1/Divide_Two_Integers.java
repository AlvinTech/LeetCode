package v1;
/**
 * 2014-9-8
 * @author Alvin
 * 
 */

public class Divide_Two_Integers {

	 int divide(int dividend, int divisor) {
	        long  a = Math.abs(( long)dividend);
	        long  b = Math.abs(( long)divisor);
	        int ans = 0, i = 0;
	        while (a > b){
	            i++;
	            b = b << 1;
	        }
	        while (i >= 0){
	            if (a >= b){
	                a -= b;
	                ans += (1 << i);
	            }
	            b = b >> 1;
	            i--;
	        }

	        return (((dividend >> 31)^(divisor >> 31))==0) ? ans : -ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
