package v1;
import java.util.Arrays;

/**
 * 2014-4-28
 * @author Alvin
 * 
 */

public class Remove_Duplicates_from_Sorted_Array {
	
	public int removeDuplicates(int[] A) {
		if(A ==null || A.length ==0)
			return 0;
		else{
			int length = A.length-1;
			  int index =1;
			  int count = 0;
			  for(int i=0;i< length;i++){
				  if(A[i] != A[i+1]){
					  A[index] = A[i+1];
					  index++;
				  }
			  }
		        return index;
		}
	}

	  public int removeDuplicates1(int[] A) {
		  int length = A.length-1;
		  for(int i=0;i< length;i++){
			  if(A[i] ==A[i+1]){		
				for(int j = i;j<length;j++){
					A[j] = A[j+1];
				}
				length--;
				i--;
			  }
		  }
	        return length+1;
	    }
	  
	  public int removeDuplicates2(int[] A) {
		  int length = A.length-1;
		  int count =0;
		  for(int i=0;i< length;i++){
			  if(A[i] ==A[i+1]){		
				  count++;
			  }
			  else if(count != 0){
				  resetArray(A,i+1,count,length);
				  i= i-count;
			
				  length =length- count;
				  count = 0;
			  }
		  }
	        return length-count+1;
	    }
	private void resetArray(int[] a, int i, int count,int length) {
		for(int j =i; j<= length;j++){
			a[j-count] = a[j];
		}
	}

	public static void main(String[] args) {
		int[] a = {};
		System.out.println(new Remove_Duplicates_from_Sorted_Array().removeDuplicates(a));
		System.out.println(Arrays.toString(a));

	}

}
