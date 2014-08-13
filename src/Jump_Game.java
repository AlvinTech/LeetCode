/**
 * 2014-7-2
 * @author Alvin
 * 如果出现不能跨越的域 肯定是该位为0；
 */

public class Jump_Game {

    public boolean canJump1(int[] A) {
    	int length = A.length;
    	boolean[] flag = new boolean[length];
    	flag[0] = true;
    	for(int i =0 ;i < A.length;i++){
    		if(flag[i]){
    			for(int j =1; j <=A[i] ;j++){
    				flag[i+j>= length ? length-1: i+j] = true;
    			}
    		}
    	}
        return flag[length-1];
    }
    public boolean canJump(int[] A) {
    	if(A.length <=1)
    		return true;
    	for(int i =0 ;i < A.length;i++){
    		if(A[i] == 0){
    			int j =i;
    			if(i == A.length -1)
    				return true;
    			for(; j >=0 ;j--){
    				if(j+A[j] >i)
    					break;
    			}
    			if(j==-1)
    				return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		int [] A= {2,0,0};
		System.out.println(new Jump_Game().canJump(A));
		

	}

}
