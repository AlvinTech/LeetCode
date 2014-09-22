/*
Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
*/
package com.alvin.java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i =0; i < n;i++){
            int base = 1 << i;
            for(int j = list.size()-1;j >=0;j--){
                list.add(base + list.get(j));
            }
        }
        return list;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Gray_Code().grayCode(2).toArray()));
    }
}