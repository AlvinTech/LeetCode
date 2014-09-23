package com.alvin.java;

/**   Palindrome Number
 * Created with IntelliJ IDEA.
 * User: Alvin

 Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int y=0;
        int val = x;
        while(val > 0){
            y = y*10+ (val % 10 );
            val = val /10;
        }
        return y == x;
    }
}
