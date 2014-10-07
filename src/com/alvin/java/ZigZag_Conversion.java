/**   ZigZag Conversion
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午5:01
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". * To change this template use File | Settings | File Templates.
 */
package com.alvin.java;

public class ZigZag_Conversion {

    public String convert(String s, int nRows) {

        if (nRows <= 1) {
            return s;
        } else {
            int dis = (nRows - 1) * 2;
            int length = s.length();
            int index = 0;
            char[] result = new char[length];
            for (int row = 0; row < nRows; row++) {
                int left = dis - row * 2;
                int right = dis - left;
                char a = ' ';
                int i = row;
                int flag = 1;
                while (i < length) {
                    //	System.out.println(s.charAt(i));
                    if (flag % 2 == 1 && left != 0) {
                        a = s.charAt(i);
                        result[index] = a;
                        i = i + left;
                        index++;

                    } else if (flag % 2 == 0 && right != 0) {
                        a = s.charAt(i);
                        result[index] = a;
                        i = i + right;
                        index++;

                    }
                    flag++;
                }

            }
            // System.out.println(result);
            return new String(result);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(new ZigZag_Conversion().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZag_Conversion().convert("A", 1));
    }

    }
