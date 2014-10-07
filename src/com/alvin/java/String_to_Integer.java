/*  String to Integer
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.
*/
package com.alvin.java;
public class String_to_Integer {
    public int atoi(String str) {
        long result  =0l;
        int ans = 1;
        String val = str.trim();
        int length = val.length();
        if(length == 0)
            return 0;
        int index = 0;
        if(val.charAt(index) == '+' || val.charAt(index) == '-'){
            ans = (val.charAt(index) == '-' ? -1 : 1);
            index++;
        }
        while(index < length && val.charAt(index) >= '0' && val.charAt(index) <= '9'){
            result = result * 10 + val.charAt(index) - '0';
            index++;
        }
        result = ans * result;
        if(result > 2147483647)
           return  2147483647;
        if(result < -2147483648)
            return  -2147483648;
        return (int)result;
    }
    public static void main(String[] args) {
        String  str  = "  -1";
        // int a = 2147483648;
        // System.out.println(a);
        System.out.println(new String_to_Integer().atoi(str));
    }
}