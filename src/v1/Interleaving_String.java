package v1;
/**
 * 2014-9-14
 * @author Alvin
 * 
 */

public class Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s3.length() != s1.length() + s2.length())
    		return false;
    	if(s1.length() ==0 && s2.length() ==0 && s3.length() ==0)
    		return true;
    	int m = s1.length();
    	int n = s2.length();
    	boolean[][] array = new boolean[m+1][n+1];
    	for(int i = 1 ; i<=m;i++){
    		if(s1.substring(0,i).equals(s3.substring(0,i)))
    			array[i][0] = true;
    	}
    	for(int i = 1 ; i<=n;i++){
    		if(s2.substring(0,i).equals(s3.substring(0,i)))
    			array[0][i] = true;
    	}
    	for(int i =1; i <=m;i++){
    		for(int j =1; j<=n ;j++){
    			if(array[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
    				array[i][j] =true;
    			if(array[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1))
    				array[i][j] =true;
    		}
    	}
    	return array[m][n];
      
    }
  
	public static void main(String[] args) {
		String s1= "";
		String s2 ="b";
		String s3 ="b";
		System.out.println(new Interleaving_String().isInterleave(s1, s2, s3));

	}

}
