/** 递归
Palindrome Partitioning 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
注意： List 深拷贝。
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome_Partitioning {
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> list = new ArrayList<String>();
    public List<List<String>> partition(String s){
        if(s.length() == 0){
            result.add(new ArrayList<String>(list));
        }
        for (int i = 1; i <= s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                list.add(s.substring(0,i));
                partition(s.substring(i));
                list.remove(list.size()-1);
            }
        }
        return result;
    }
    public boolean isPalindrome(String s){
        int length = s.length();
        for(int i = 0 ; i < length/2 ;i++){
            if(s.charAt(i) != s.charAt(length-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        String s ="aab";
        List<List<String>> result = new ArrayList<List<String>>();
        result = new Palindrome_Partitioning().partition(s);
        for(int i = 0 ; i< result.size();i++)
            System.out.println(Arrays.toString(result.get(i).toArray()));
        System.out.println("12345".substring(5));
    }

}