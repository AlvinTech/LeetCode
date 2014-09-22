/**  Letter Combinations of a Phone Number
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:31
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 */
package com.alvin.java;
import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
    private static char[][] map = {{},{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        Combinations(list,"",digits,digits.length());
        return list;
    }

    public void Combinations( List<String> list, String letters,String digits,int index){
        if(index <=0){
            list.add(letters);
            return;
        }
        int j = digits.charAt(digits.length() -index)-'0' -1;
        for(int i=0; i < map[j].length; i++){
            String lettersNew = letters + map[j][i];
            Combinations(list,lettersNew,digits,index-1);
        }
    }
}
