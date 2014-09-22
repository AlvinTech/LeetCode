/* Interleaving String
My Submissions
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
array[i][j] 表示 能否用s1 的前i个字符，和s2的前j个字符 组成s3 的前 i+j个字符。
*/
package com.alvin.java;

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
                //s1 的1前i-1个字符和 s2 的前j个字符能组成s3的前i+j-1的情况下，主要满足s1[i] == s3[i+j]就可以了，
                //具体小标的话需要-1，因为从0开始。
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
