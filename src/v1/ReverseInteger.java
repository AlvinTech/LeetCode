package v1;

public class ReverseInteger {

	/**
	 * @param args
	 */
	 public int reverse(int x) {
		    int sun=0;
		    int flag = 0;
		    if(x<0){
		    	x = -x;
		    	flag = 1;
		    }
		    while(x>0){
		    	int temp = x%10;
		    	sun =sun*10+ temp;
		    	x= x/10;
		    }
		    if(flag ==1)
		    	return -sun;
		    else
		    	return sun;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -132;
		System.out.println(new ReverseInteger().reverse(x));

	}

}
