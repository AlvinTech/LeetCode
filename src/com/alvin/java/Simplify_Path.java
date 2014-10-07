/*
Simplify Path 
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/
package com.alvin.java;
import java.util.Stack;

public class Simplify_Path {
    public String simplifyPath(String path) {
        String[] array = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(int i=0 ;i< array.length;i++){
            if(array[i].equals("."))
                continue;
            else if(array[i].equals("..")){
                if(!stack.empty())
                    stack.pop();
            }else{
                if(array[i].trim().length() != 0)
                    stack.add(array[i]);
            }
        }
        String result = "";
        while(!stack.empty()){
            result = "/"+stack.pop()+result;
        }
        if(result.length() == 0)
            return "/";
        return result;
    }
}