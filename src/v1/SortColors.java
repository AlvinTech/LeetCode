package v1;
import java.util.Arrays;

/**
 * 2014-5-16
 * @author Alvin
 * 
 */

public class SortColors {

    public void sortColors(int[] A) {
    	countSort(A);
    }
    
    public int[] countSort(int[] A){
    	int c0= 0;
    	int c1 =0;
    	int c2 = 0;
    	for(int i=0 ;i<A.length;i++){
    		if(A[i] == 0)
    			c0++;
    		else if(A[i]== 1)
    			c1++;
    		else c2++;
    	}
    	
    	for(int i=0;i< c0;i++){
    		A[i] = 0;
    	}
    	for(int i=0;i< c1;i++){
    		A[i+c0] = 1;
    	}
    	for(int i=0;i< c2;i++){
    		A[i+c1+c0] = 2;
    	}
    	return A;
    }
	public static void main(String[] args) {
		int[] A={0,1,2,0,1,2};
		new SortColors().sortColors(A);
	}

}
