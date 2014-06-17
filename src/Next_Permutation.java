import java.util.Arrays;

/**
 * 2014-5-21
 * @author Alvin
 * 
 */

public class Next_Permutation {
    public void nextPermutation(int[] num) {
        if(isBig(num)){
        	sort(num);
        }else
        	swap(num);
    }
    
    public void swap(int[] num){
    	for(int i=num.length-1 ;i > 0;i--){
    		for(int j=i-1;j>=0;j--){
    			if(num[j] < num[i]){
    				int var = num[i];
    				num[i]=num[j];
    				num[j] = var;
    				fix(num,j+1);
    				return;
    			}
    		}
    	}
    }
    public void sort(int[] num){
    	int size = num.length;
    	for(int i=0;i< num.length /2 ;i++){
    		int var = num[size -1 -i];
    		num[size -1 -i] = num[i];
    		num[i] = var;
    	}
    }
    public boolean isBig(int[] num){
    	for(int i=0;i< num.length-1;i++){
    		if(num[i]< num[i+1])
    			return false;
    	}
    	return true;
    }
    public void fix(int[] num, int sta){
    	for(int i=num.length-1;i>= sta;i--){
    		for(int j =i-1;j>= sta;j--)
    		if(num[i] < num[j]){
    			int var =num[j];
    			num[j] = num[i];
    			num[i] = var;
    			fix(num,j+1);
    		}
    			
    	}
    }
	public static void main(String[] args) {
		int[] num ={1,2,3,4};
		int[] num1 ={2,3,1};
		new Next_Permutation().nextPermutation(num1);
		System.out.println(Arrays.toString(num1));
	}

}
