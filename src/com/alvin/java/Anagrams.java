package com.alvin.java;/*
Anagrams
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

注意：不要使用 Map<char[],List<String>> map; char[] 会保存地址 而不是字符串内容。
*/

import java.util.*;

public class Anagrams{
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for (int i = 0; i < strs.length ;i++ ) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            List<String> list  = map.get(new String(c));

            if(list == null){
                list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(new String(c),list);
                // System.out.println(new String(c)+"  100");
            }
            else
                list.add(strs[i]);
        }

        for( String s : map.keySet()){
            List<String> list = map.get(s);
            // System.out.println(list.size());
            if(list.size() > 1){

                result.addAll(list);
            }
        }
        // System.out.println(map.size());

        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"",""};
        System.out.println(new Anagrams().anagrams(strs));
    }
}