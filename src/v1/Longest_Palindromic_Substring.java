package v1;
/**
 * 2014-9-11
 * @author Alvin
 * 
 */

public class Longest_Palindromic_Substring {
	
	public String preProcess(String s){
		int n =  s.length();
		if(n == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			sb.append('#');
			sb.append(s.charAt(i));
		}
		sb.append('#');
		return sb.toString();
	}
    public String longestPalindrome(String s) {
    	if(s == null || s.length() == 0)
    		return s;
    	String ps = preProcess(s);
//    	System.out.println(ps);
    	int n = ps.length();
    	int p[] = new int[n];
    	int center = 0; 
    	int right = 0;
    	for(int i = 1; i < n-1;i++){
    		int mirror = 2*center - i ;// c -(i-c);
    		p[i] = (right > i) ? Math.min(right - i, p[mirror]) : 0;
    		
    		while(i-1-p[i]>=0 && i+1+p[i] < n && ps.charAt(i+1+p[i]) == ps.charAt(i-1-p[i]))
    			p[i]++;
    		if(i + p[i] > right){
    			center = i;
    			right = i + p[i];
    		}
    	}
    	
    	int maxLen = 0;
    	int centerIndex = 0;
    	for(int i = 0; i < n-1;i++){
    		if(p[i] > maxLen){
    			maxLen = p[i];
    			centerIndex = i;
    		}
    	}
    	return s.substring((centerIndex- maxLen)/2, (centerIndex+ maxLen)/2 ); 
    }
    public static  void print(){
    	StringBuilder sb = new StringBuilder();
    	int i=0;
    	while( i++ < 25 )
    		sb.append( String.format("%02d,",i) );
    	System.out.println(sb.substring(0, sb.length()-1).toString());
   // 	System.out.println(sb.toString());
    }
	public static void main(String[] args) {
		print();
		String s="11234567654890";
		System.out.println(new Longest_Palindromic_Substring().longestPalindrome("bb"));

	}

}
