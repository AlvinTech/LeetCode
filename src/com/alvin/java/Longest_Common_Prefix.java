/**  Longest Common Prefix
 * 2014-7-3
 * @author Alvin
Write a function to find the longest common prefix string amongst an array of strings.
 */
package com.alvin.java;
public class Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length ==0)
            return "";
        if(strs.length ==1)
            return strs[0];

        for(int i =0;;i++){
            for(int j=0;j< strs.length;j++){
                if(i >= strs[j].length())
                    return strs[j].substring(0, i);
                else{
                    if(strs[j].charAt(i) != strs[0].charAt(i))
                        return strs[0].substring(0, i);
                }
            }
        }

    }
    public static void main(String[] args) {
        //	String[] strs ={"abcdef","abcdge","abcdjhg","abcdjjdjdj"};
        String[] strs ={"","b"};
        System.out.println(new Longest_Common_Prefix().longestCommonPrefix(strs));

    }

}
