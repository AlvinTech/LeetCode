/**Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
package com.alvin.java;
public class Decode_Ways {
    public int numDecodings(String s) {
        int m = s.length();
        if(m == 0)
            return 0;
        int[] sum = new int[m+1];
        sum[0] = 1;
        if(s.charAt(0) !='0')
            sum[1] = 1;
        else
            sum[1] =0;
        for(int i=2 ;i< m+1;i++){
            int val  = Integer.parseInt(s.substring(i-2,i));
            if(s.charAt(i-1) == '0'){
                if(val <= 26 && val >=10)
                    sum[i] = sum[i-2];
                else
                    sum[i] = 0;
            }
            else if(val <= 26 && val >=10){
                sum[i] = sum[i-1]+ sum[i-2];
            }else if(val < 10 || val > 26)
                sum[i] =  sum[i-1];
        }
        return sum[m];
    }
    public static void main(String[] args) {
        String s = "227";
        System.out.println(new Decode_Ways().numDecodings(s));
    }
}