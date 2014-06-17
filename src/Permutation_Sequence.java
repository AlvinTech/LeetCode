import java.util.Arrays;

/**
 * 2014-6-12
 * @author Alvin
 * 
 */

public class Permutation_Sequence {

	public String getPermutation(int n, int k) {
			int np = n;
	        String result ="";
	        int[] index =new int[n];
	        int[] flag =new int[n];
	        int i= 0;
	        while(k > 0){
	        	long total  = getTotal(n-1);
	        	index[i] =  (int) (k /total);
	        	k = (int) (k - (index[i])*total);
	        	if(k>0)
	        		index[i]++;
	        	n--;
	        	i++;
	        }
	        
	        int j =0;
	        for(i = 0;i< np;i++){
	        	int count = 0;
	        	if(index[i] == 0){
	        		for( j=np;j >=1;j--){
		        		if(flag[j-1] == 0)
			        			break;
		        	}
	        	}
	        	else{
	        		for( j=1;j <= np;j++){
	        			if(flag[j-1] == 0)
	        				count++;
	        			if(count == index[i])
		        			break;
	        		}
	        	}
	        	result = result + j;
	        	flag[j-1] = 1;
	        }
	       // System.out.println(Arrays.toString(index));
	        //System.out.println(result);
	        return result;
	}
	 
	public long getTotal(int n){
		long total = 1;
		while(n>0){
			total *= n;
			n--;
		}
		return total; 
	}
	public static void main(String[] args) {
		for(int i=1;i<= 6;i++)
		System.out.println(i+"    "+ new Permutation_Sequence().getPermutation(5, i));
	}

}
