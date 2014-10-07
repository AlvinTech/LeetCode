/*
Word Break II 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Word_Break_II {
    HashSet<String> map = new HashSet<String>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0)
            return res;
        res = recBreak(s, dict);
        return (res != null)?res:new ArrayList<String>();
    }

    private ArrayList<String> recBreak(String s, Set<String> dict){
        if(map.contains(s))
            return null;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> temp = null;
        for(int i =1; i<= s.length(); i++){
            temp = new ArrayList<String>();
            String str = s.substring(0, i);
            if(dict.contains(str)){
                if(i < s.length())
                    temp = recBreak(s.substring(i, s.length()), dict);
                if(temp != null){
                    if(temp.size() == 0)
                        list.add(str);
                    else{
                        for(int j = 0; j< temp.size(); j++){
                            list.add(str+" "+temp.get(j));
                        }
                    }
                }else{
                    map.add(s.substring(i, s.length()));
                }
            }
        }

        return (list.size() > 0)?list:null;

    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
