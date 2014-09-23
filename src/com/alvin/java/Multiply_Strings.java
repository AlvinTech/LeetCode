/**  Multiply  Strings
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午3:51
 Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 */
package com.alvin.java;
public class Multiply_Strings {
    public String multiply(String num1, String num2) {
        int length2 = num2.length();
        int length1 = num1.length();
        String[] list = new String[length2+1];
        int total = length1+ length2;
        int i;
        //pre
        for( i=0; i < length2;i++ ){
            list[i] = zero(length2 -i)+ num1+ zero(i);
            list[i] = multip(list[i],num2.charAt(length2-1-i));
        }

        return aftDo(list);
    }

    private String aftDo(String[] list) {
        int val =0;
        int length  = list.length;
        if(length == 0)
            return null;
        else
            list[length -1] ="";
        for(int j = list[0].length()-1; j>=0;j--){
            val = (val / 10) ;
            for(int i=0; i< list.length-1;i++ ){
                val += list[i].charAt(j)-'0';
            }
            list[list.length-1]= val% 10 + list[list.length-1];
        }
        // delete pre 0
        String result = list[length-1];
        for(int i =0;i<result.length();){
            if(result.length() != 1 && result.charAt(0) == '0')
                result= result.substring(1);
            else
                break;
        }
        return result;
    }

    public String zero(int n){
        String result ="";
        for(int i=0; i< n;i++){
            result += "0";
        }
        return result;
    }

    public String multip(String num,char n){
        String result ="";
        int val = 0;
        for(int i =num.length()-1 ;i>=0;i--){
            val = (num.charAt(i)-'0') * (n -'0')+ (val/10) % 10;
            result =  val%10 +result;
        }
        return result;
    }
}
