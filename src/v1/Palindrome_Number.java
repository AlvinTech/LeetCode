package v1;
/**
 * 2014-5-31
 * @author Alvin
 * 
 */

public class Palindrome_Number {
	 public boolean isPalindrome(int x) {
		 if(x < 0)
			return false;
		 int y=0;
		 int val = x;
		 while(val > 0){
			 y = y*10+ (val % 10 );
			 val = val /10;
		 }
		 return y == x;
	        
	 }
	public static void main(String[] args) {
		System.out.println(new Palindrome_Number().isPalindrome(-11));

	}

}
