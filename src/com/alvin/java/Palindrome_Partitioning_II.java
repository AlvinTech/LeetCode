/**
Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_II {
    public int minCut(String s){
        if(s == null)
            return 0;
        int i,j,n = s.length();
        int cuts[] = new int[n];
        boolean dp[][] = new boolean[n][n];
        for(i =0;i<n;i++){
            cuts[i] =i;          // 最多按i次切分 肯定是回文，每段会问1个字符。
            for ( j=0;j <= i ;j++ ) {
                if(j==i )
                    dp[j][i] = true;
                else{
                    if(s.charAt(i)!= s.charAt(j))
                        continue;
                    if( j == i-1)//a[1]= 1 a[2]=1  如果调用else 结果是错得    单个字符是回文
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
    }	public static void main(String[] args){
        System.out.println("Hello World");
        String s ="ab";
        List<List<String>> result = new ArrayList<List<String>>();
        int a  = new Palindrome_Partitioning_II().minCut(s);
        System.out.println(a);
    }

}