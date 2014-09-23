/*   Minimum Window Substring
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * */
package com.alvin.java;
import java.util.HashMap;
import java.util.Map;
public class Minimum_Window_Substring {
    public String minWindow(String S, String T) {
        int m = S.length();
        int n  = T.length();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char s[] = S.toCharArray();
        int count  =  n;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0 ; i< n ;i++){
            if(!map.containsKey(T.charAt(i)))
                map.put(T.charAt(i),1);
            else
                map.put(T.charAt(i) , map.get(T.charAt(i))+1);
        }
        int i = -1 ,j = 0;
        while(i < m && j < m){  //i 循环开始和结束条件注意，
            if(count > 0){
                i++;
                if(i == m)
                    break;
                if(map.containsKey(s[i])){
                    map.put(s[i],map.get(s[i])-1);
                    if( map.get(s[i]) >= 0)
                        count--;
                }
            }
            if(count == 0){
                if(minLen > i-j+1){
                    minLen  = i-j+1;
                    start = j;
                }
                if(map.containsKey(s[j])){
                    map.put(s[j], map.get(s[j])+1);
                    if(map.get(s[j]) > 0)
                        count++;
                }
                j++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : S.substring(start,start+minLen);
    }
    public static void main(String[] args) {
        String S= "ABANC";
        String T = "ABC";
        System.out.println(new Minimum_Window_Substring().minWindow(S, T));

    }

}
