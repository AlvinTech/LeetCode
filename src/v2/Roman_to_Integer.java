/**  Roman to Integer
 * 2014-4-11
 * @author Alvin
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 */

public class Roman_to_Integer {

    public int romanToInt(String s) {
        int value =0;
        for(int i =0; i< s.length();i++){
            System.out.println(s.charAt(i));
            value += getValue(s,i);
        }
        return value;
    }

    public int getValue(String s, int index){
        int value =0;
        if(s.charAt(index) == 'I'){
            if(index < s.length()-1 && (s.charAt(index+1) == 'V' ||s.charAt(index+1) == 'X')  )
                value =-1;
            else
                value = 1;
        }
        else if(s.charAt(index) == 'V')
            value = 5;
        else if(s.charAt(index) == 'X'){
            if(index < s.length()-1 && (s.charAt(index+1) == 'L' ||s.charAt(index+1) == 'C')  )
                value =-10;
            else
                value = 10;
        }
        else if(s.charAt(index) == 'L')
            value = 50;
        else if(s.charAt(index) == 'C'){
            if(index < s.length()-1 && (s.charAt(index+1) == 'D' ||s.charAt(index+1) == 'M')  )
                value =-100;
            else
                value = 100;
        }
        else if(s.charAt(index) == 'D')
            value = 500;
        else if(s.charAt(index) == 'M')
            value = 1000;

        return value;

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(new Roman_to_Integer().romanToInt("MMMDLXXXVI"));
    }

}
