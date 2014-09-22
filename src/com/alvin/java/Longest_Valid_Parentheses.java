/*
Longest Valid Parentheses
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
package com.alvin.java;
import java.util.Arrays;
import java.util.Stack;


public class Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();      //保存括号
        Stack<Integer> index = new Stack<Integer>();          //保存下标
        int val[] = new int[s.length()];                     //标记能匹配的括号
        int num =0;
        for(int i =0 ;i< s.length();i++){
            if(s.charAt(i) == ')'&& !stack.empty() && stack.peek() == '('){
                stack.pop();           // 如果括号匹配，记录下标
                val[index.pop()] = 1;
                val[i] = 1;
            }else{
                stack.push(s.charAt(i));
                index.push(i);
            }
        }
        int k =0;
        for(int i =0 ;i< s.length();i++){ // 统计 最长连续有效括号数量
            if(val[i] == 0 ){
                num = Math.max(k, num);
                k=0;
            }
            else
                k++;
        }
        num = Math.max(k, num);
        return num;
    }
    public static void main(String[] args) {
        System.out.println(new Longest_Valid_Parentheses().longestValidParentheses("()"));

    }

}
