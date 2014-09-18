package v1;
/**
 * 2014-9-17
 * @author Alvin
 * 
 */

public class Wildcard_Matching {
	 public boolean isMatch(String s, String p) {
		 int m = 0, n = 0, match = 0, index = -1;
		 while(m < s.length()){
			 if(n < p.length() && (p.charAt(n)=='?' || p.charAt(n) == s.charAt(m))){
				 n++;
				 m++;
			 }
			 else if(n < p.length() && p.charAt(n) == '*'){
				 index  = n;
				 match = m;
				 n++;
			 }
			 else if(index != -1){
				 n = index +1;
				 match ++;
				 m = match;
			 }
			 else
				 return false;
		 }
		 while(n < p.length() && p.charAt(n) =='*')
			 n++;
		 return n == p.length();
		 
	 }
	 

	public static void main(String[] args) {
		String s ="ab";
		String p ="*a";
		System.out.println(new Wildcard_Matching().isMatch(s, p));

	}

}
