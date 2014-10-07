/*
Word Break 
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
package com.alvin.java;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Word_Break {
    Map<String,Boolean> map = new HashMap<String,Boolean>();
    public boolean worldBreak(String s , Set<String> dict){
        if(dict.contains(s))
            return true;
        for (int i=1;i < s.length() ;i++ ) {
            if(!map.containsKey(s.substring(0,i))){
                map.put(s.substring(0,i),worldBreak(s.substring(0,i),dict));
            }
            if(!map.containsKey(s.substring(i,s.length()))){
                map.put(s.substring(i,s.length()),worldBreak(s.substring(i,s.length()),dict));
            }

            if(map.get(s.substring(0,i)) && map.get(s.substring(i,s.length())))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");

        System.out.println(new Word_Break().worldBreak(s,dict));
    }
}