/**   Count and Say
 * 2014-5-16
 * @author Alvin
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
package com.alvin.java;
public class Count_and_Say {

    public String countAndSay(int n) {
        String sta = "1";
        String end ="";
        for(int i=0;i< n-1;i++){
            end = say(sta);
            sta = end;
        }
        return sta;
    }

    public String say(String str){
        String result = "";
        int count =1;
        for(int i=0;i< str.length();i++){
            if(i==str.length() -1){//因为最后一个没有被计入，需要单独处理
                result += count + str.substring(i,i+1);
                count =  1;
            }
            else if(str.charAt(i) ==str.charAt(i+1)){
                count++;
            }else{
                result += count +str.substring(i,i+1);
                count =  1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        new Count_and_Say().countAndSay(3);
    }

}
