/** 解题思路  DP
Distinct Subsequences 
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
package com.alvin.java;
class Distinct_Subsequences {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] array = new int[m+1][n+1];
        //T 为空时 s 删掉全部就能成为T
        for(int i=0 ; i< m+1;i++)
            array[i][0] = 1;

        for(int i=1; i< m+1;i++)
            for(int j = 1; j < n+1;j++){
				/*如果T.charAt(j) == S.charAt(i) 
				S[0..i-1] 转化到 T[j-1]的数量 + S[0..i-1]转化到T[0..j]的数量；
				不相等：只能通过S[0...i-1]转化到T[0..j]的数量
				*/
                array[i][j] = array[i-1][j] + (T.charAt(j-1) == S.charAt(i-1)? array[i-1][j-1] :0);
            }

        return array[m][n];

    }

    public static void main(String[] args){
        System.out.println(new Distinct_Subsequences().numDistinct("rabbbit","rabbit"));
    }
}