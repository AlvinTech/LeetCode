package v1;
/**
 * 2014-9-9
 * @author Alvin
 * 
 */

public class First_Missing_Positive{
    public int firstMissingPositive(int[] A) {
    	for (int i=0;i < A.length ;i++ ) {
    	   		int index = A[i];
    	   		if(index >0 && index <= A.length && i != index-1 && A[index-1] != index){
    	   			int val = A[index-1];
    	   			A[index-1] = A[i];
    	   			A[i] = val;
    	   			i--;
//    	   			if(i ==5)
//    	   				i=5;
//    	   			System.out.println(i);
    	   		}
    	   }
    	for (int i=0;i < A.length ;i++ ) {
    		if(A[i]-1 != i)
    			return i+1;
    	}
    	return A.length+1;   
    }	
	public static void main(String[] args) {
		int[] A ={10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6};

		System.out.println(new First_Missing_Positive().firstMissingPositive(A));
	}
}