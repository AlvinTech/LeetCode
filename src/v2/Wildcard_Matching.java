/** Wildcard Matching
 Implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 * */
public class Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        int m = 0, n = 0, match = 0, index = -1;
        while(m < s.length()){
            if(n < p.length() && (p.charAt(n)=='?' || p.charAt(n) == s.charAt(m))){
                n++;
                m++;
            }
            else if(n < p.length() && p.charAt(n) == '*'){
                index  = n;
                match = m;
                n++;
            }
            else if(index != -1){
                n = index +1;
                match ++;
                m = match;
            }
            else
                return false;
        }
        while(n < p.length() && p.charAt(n) =='*')
            n++;
        return n == p.length();

    }
}
