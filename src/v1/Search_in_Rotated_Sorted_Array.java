package v1;
/**
 * 2014-7-17
 * @author Alvin
 * 
 */

public class Search_in_Rotated_Sorted_Array {

    public int search(int[] A, int target) {
    	if(target >=A[0]){
    		 for(int i=0 ; i< A.length;i++){
    	        	if(A[i] == target)
    	        		return i;
    	        }
    	}else
    	{
    		 for(int i= A.length -1  ; i>=0;i--){
    	        	if(A[i] == target)
    	        		return i;
    	        }
    	}
       
        return -1;
    }
	public static void main(String[] args) {
		int[] A ={4,5,6,7,1,2,3};
		int target  = 1;
		System.out.println(new Search_in_Rotated_Sorted_Array().search(A, target) );
	}

}
