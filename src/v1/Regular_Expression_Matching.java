package v1;
/**
 * 2014-9-11
 * @author Alvin
 * 
 */
/*
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * */
public class Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {
    	if(p.length() == 0 )
    		if(s.length() == 0)
    			return true;
    		else
    			return false;
   	
        if(p.length() == 1){
        	if(s.length() ==1 && (p.charAt(0)== '.'  ||(  s.charAt(0) == p.charAt(0))))
        		return true;
        	else
        		return false;
        }
   
         if(p.charAt(1) == '*'){//p.length >2
        	 String pattern = (p.length() > 2)? p.substring(2) : "";
        	 if(isMatch(s,pattern))
         		return true;
        	 int i =0;
        	 while(i < s.length() && matchFirst(s.charAt(i),p.charAt(0))){
        		 String str = (i+1 <s.length()) ? s.substring(i+1) : "";
        		 if(isMatch(str,pattern))
        			 return true;
        		 i++;
        	 } 
        	 return false;
        }else{
        	if(p.charAt(0) == '.'){
        		if(s.length() ==0)
        			return false;
        		else if(s.length() ==1)
        		return isMatch("",p.substring(1));       		
        		else
        			return isMatch(s.substring(1),p.substring(1));
        	}else{
        		if(s.length() == 0)
        			return false;
        		if(s.charAt(0)!=p.charAt(0))
        			return false;
        		else {
        			if(s.length() == 1)
        				if(s.charAt(0)!= p.charAt(0))
        					return false;
        				else
        					return isMatch("",p.substring(1));
        			else
        				return isMatch(s.substring(1),p.substring(1));
        		}		
        	}
        		
        }
  //    return false;
		      	
    }
    public boolean matchFirst(char a, char b){
    	return (b == '.' || a == b);  	
    }
	public static void main(String[] args) {
		String s ="bbaa";
		String p ="a...";
		System.out.println(new Regular_Expression_Matching().isMatch(s, p));

	}

}
