package v1;
/**
 * 2014-3-4
 * @author Alvin
 * 
 */

public class Unique_Binary_Search_Trees {

	 public int numTrees(int n) {
	        long a = 1;
	        long b = 1;
	        for(int i = 2*n;i> n+1;i--)
	        	a*= i;
	        for(int i=n;i>0;i--)
	        	b *= i;
	        return (int) (a/b);
	    }

}

/** 思路
 * http://cs.lmu.edu/~ray/notes/binarytrees/
 * http://en.wikipedia.org/wiki/Catalan_numbers
 *  （2n）! /((n+1)!*n!)
 * 
 */
