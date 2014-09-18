package v1;
/**
 * 2014-9-3
 * @author Alvin
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Palindrome_Partitioning_II {
	public int minCut1(String s){
		int length  = s.length();
		if(length <2)
			return 0;
		int[] cut = new int[length+1];
		int[][] map = new int[length+1][length+1];
		cut[0]= -1;
		for(int i =1; i< length+1;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0; j<i;j++ ){
				map[j][j]= 1;
				if(j==i-1)
					map[j][i]= 1;
				if(isPalindrome(s,j,i,map)){
					min = Math.min(min,cut[j]+1);
				}
			}

			cut[i] = min;
			
		}
		return cut[length];
	}
	public int minCut(String s){
		if(s == null)
			return 0;
		int i,j,n = s.length();
		int cuts[] = new int[n];
		boolean dp[][] = new boolean[n][n];
		for(i =0;i<n;i++){
			cuts[i] =i;
			for ( j=0;j <= i ;j++ ) {
				if(j==i )
					dp[j][i] = true;
				else{
					if(s.charAt(i)!= s.charAt(j))
						continue;
					if( j == i-1)//a[1]= 1 a[2]=1  
						dp[j][i]= true;
					else
						dp[j][i] = dp[j+1][i-1];
				}
				if(dp[j][i]){
					if(j ==0)
						cuts[i]=0;
					else
						cuts[i] = Math.min(cuts[j-1]+1,cuts[i]);
				}
			}

		}
		return cuts[n-1];
	}
	public boolean isPalindrome(String s,int sta,int end,int[][] map){	
		if(end- sta == 1)
			return true;
		if(s.charAt(sta) != s.charAt(end-1))
			return false;
		if(sta+1 ==end-1 || map[sta+1][end-1] == 1){
			map[sta][end]=1;
			System.out.println(sta + " " + end);
			return true;
		}		
		return false;
	}
	public static void main(String[] args){
		System.out.println("Hello World");
		String s ="ab";
		List<List<String>> result = new ArrayList<List<String>>();
		int a  = new Palindrome_Partitioning_II().minCut(s);
		System.out.println(a);
	}
	
}