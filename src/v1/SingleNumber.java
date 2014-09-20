package v1;
/**
 * 2014-3-4
 * @author Alvin
 * Given an array of integers, every element appears twice except for one. Find that single one.

Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	
 */

public class SingleNumber {

	  public int singleNumber(int[] A) {
	        int n =0;
	        int result =0;
	        while(n<A.length){
	        	result = result^A[n];
	        	n++;
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


