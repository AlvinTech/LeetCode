/**
 * 2014-5-31
 * @author Alvin
 * 
 */

public class Unique_Paths {

    public int uniquePaths(int m, int n) {
    	return (int)unique(m-1,n-1);
    	
    }
    public double unique(int m, int n) {
    	if(m == 0 || n ==0){
    		return 1;
    	}else
    		return (m+n)*(m+n-1)*1.0*unique(m-1,n-1)/m/n ;
    	
    }
	public static void main(String[] args) {
		System.out.println(new Unique_Paths().uniquePaths(23,12));
	}

}
