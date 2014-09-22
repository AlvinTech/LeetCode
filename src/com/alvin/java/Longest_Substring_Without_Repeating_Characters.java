/**     Longest Substring Without Repeating Characters
 * 2014-9-9
 * @author Alvin
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
package com.alvin.java;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        int index = -1;// 为了保证length =1 时正确。
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i =0; i < length;i++){
            char key = s.charAt(i);
            if(map.containsKey(key) && index < map.get(key))
                index = map.get(key);
            max = Math.max(max,i - index);
            map.put(key,i);
        }
        return max;
    }
    public static void main(String[] args) {
        String s ="bbbbb";
        System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(s));

    }

}
