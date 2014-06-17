import java.util.Arrays;

/**
 * 2014-6-10
 * @author Alvin
 * 
 */

public class Merge_Sorted_Array {

    public void merge(int A[], int m, int B[], int n) {
    	int[]  list = new int[m+n];
    	int indexa = 0;
    	int indexb = 0;
    	int index =0;
    	while(indexa < m && indexb < n){
    		if(A[indexa] < B[indexb])
    			list[index++]=A[indexa++];
    		else
    			list[index++] = B[indexb++];
    	}
    	// a is over
    	if(indexa == m){
    		while(indexb < n)
    			list[index++] = B[indexb++];;
    	}
    	if(indexb == n)
    		while(indexa < m)
    			list[index++] = A[indexa++];
    	
    
    	for(int i=0; i< list.length ;i++){
    		A[i] = list[i];
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {};
		int b[] = {1};
		new Merge_Sorted_Array().merge(a, a.length, b, b.length);

	}

}
