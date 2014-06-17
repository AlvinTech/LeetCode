/**
 * 2014-6-13
 * @author Alvin
 * 
 */

public class Valid_Palindrome {

	public boolean isPalindrome(String s) {
	     if(s == null || s.length() == 0)
	    	 return true;
	     else{
	    	 int i=0;
	    	 int j = s.length()-1;
	    	 while(!isAlphanumeric(s.charAt(i))){
	    		 i++;
	    		 if(i == s.length() )
	    			 return true;
	    	 }
    			
    		 while(!isAlphanumeric(s.charAt(j)))
    			 j--;
	    	 while(i< j){
	    		 if(toLowCase(s.charAt(i))!=toLowCase(s.charAt(j)))
	    			 return false;
	    		 i++;
	    		 j--;
	    		 while(!isAlphanumeric(s.charAt(i)))
	    			 i++;
	    		 while(!isAlphanumeric(s.charAt(j)))
	    			 j--;
	    	 }
	    	 return true;
	    	 
	     }
	}
	public boolean isAlphanumeric(char c){
		if(c>= '0' && c <='9')
			return true;
		else if( (c>= 'A' && c<='Z')||(c>= 'a' && c<='z')){
			return true;
		}
		else
			return false;
	}
	public char toLowCase(char c){
		if(c>= '0' && c <='9')
			return c;
		else if(c>= 'A' && c<='Z'){
			return (char) (c-'A'+'a');
		}
		return c;
	}
	
	public boolean Palindrome(String s){
		for(int i=0 ;i <s.length()/2;i++){
			if(s.charAt(i) != s.charAt(s.length()-1-i) )
				return false;
		}
		return true;
	}
	public boolean isPalindrome1(String s) {
	     if(s == null || s.length() == 0)
	    	 return true;
	     else{
	    	 s = s.toLowerCase();
	    	 String str  = "";
	    	 for(int i = 0;i< s.length();i++){
	    		 if(Character.isLetter(s.charAt(i)))
	    			 str +=s.charAt(i);
	    	 }
	    	return Palindrome(str);
	    	 
	     }
	}
	public static void main(String[] args) {
		String s ="1a1";
		System.out.println(new Valid_Palindrome().isPalindrome(s));

	}

}
