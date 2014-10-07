package com.alvin.java;/*
Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {
    List<String> list = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        int length =  s.length();
        if(length < 4 || length > 12)
            return list;
        for(int i=1;i<length -2;i++)
            for (int j = i+1;j<length-1 ;j++ )
                for (int k = j+1; k<=length ;k++ ) {
                    String ip1 = s.substring(0,i);
                    String ip2 = s.substring(i,j);
                    String ip3 = s.substring(j,k);
                    String ip4 = s.substring(k,length);

                    if(valid(ip1) && valid(ip2) && valid(ip3) && valid(ip4)){
                        String s1 = ip1+"."+ip2+"."+ip3+"."+ip4;
                        list.add(s1);
                    }

                }
        return list;
    }
    public boolean valid(String ip){
        if(ip.length() > 3 || ip.length() <1 )
            return false;
        if(ip.length() > 1 && ip.charAt(0) == '0')
            return false;
        if(Integer.parseInt(ip) > 255)
            return false;
        else
            return true;
    }
    public static void main(String[] args) {
        String ip = "25525511135";
        System.out.print(new Restore_IP_Addresses().restoreIpAddresses("010010"));
    }
}

