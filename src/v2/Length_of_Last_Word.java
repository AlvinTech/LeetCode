/**  Length of Last Word
 * 2014-6-12
 * @author Alvin
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5.
 */

public class Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        int i =0;
        if(s==null || s.length() == 0)
            return 0;
        while(s.charAt(s.length()-1) == ' '){
            if(s.length()-1 <= 0)
                break;
            s = s.substring(0, s.length()-1);
        }
        while(i<s.length()){
            if(s.charAt(i) == ' '){
                s = s.substring(i+1);
                i = -1;
            }
            i++;
        }
        return s.length();

    }
    public static void main(String[] args) {
        String s= "     ";
        System.out.println(new Length_of_Last_Word().lengthOfLastWord(s));
    }

}
