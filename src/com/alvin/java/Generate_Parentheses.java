 /**
 * 2014-5-19
 * @author Alvin
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 * 括号匹配问题：
 *若 第一个（ 对应为止k上的 ） 则：k之前 有i对括号，k之后有n-1-i对括号
 */
 package com.alvin.java;
import java.util.ArrayList;

public class Generate_Parentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> s  = new ArrayList<String>();
        if(n == 0)
            return s;
        else if(n == 1){
            s.add("()");
            return s;
        }

        ArrayList<String> result = generateParenthesis(n-1);
        for(int i=0;i< result.size();i++){
            String str = result.get(i);
            s.add("()"+ str);
            int count1 = 0;
            int count2 = 0 ;
            for(int j=0;j< str.length();j++){
                String t = str.substring(j,j+1);

                if(t.equals("("))
                    count1++;
                else
                    count2++;
                if(count1== count2){
                    s.add("("+ str.substring(0,j+1)+")"+str.substring(j+1,str.length()));
                }
            }
        }
        return s;
    }
    public int largestRectangleArea(int[] height) {
        return Area(height,0,height.length-1);
    }

    public int Area(int[] height,int sta,int end){
        if(sta > end){
            return 0;
        }else{
            int minIndex = minHeight(height,sta,end);
            int areaT = (end-sta+1)* height[minIndex];
            int areaL = Area(height,sta,minIndex-1);
            int areaR = Area(height,minIndex+1,end);
            return Math.max(Math.max(areaL, areaR),areaT);
        }
    }
    public int minHeight(int[] height,int sta,int end){
        int min =0Xffff;
        int index =sta;
        for(int i= sta; i<=end ;i++){
            if(min > height[i]){
                min = height[i];
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] height={2,1,5,6,2,3};
        String s1 ="1234";
        System.out.println(s1.substring(1));
        //System.out.println(new Generate_Parentheses().largestRectangleArea(height) );
        for(String s : new Generate_Parentheses().generateParenthesis(4))
            System.out.println(s);

    }

}
