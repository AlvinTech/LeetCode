/*  Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

/**
 * 2014-6-12
 * @author Alvin
 *
 */
public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        String[]  list = s.split(" ");
        String result = "";
        for(int i = list.length-1 ;i >= 0 ;i--){
            if(!list[i].equals("") )
                result = result+ list[i]+" ";
        }
        if(result.length() > 0)
            return result.substring(0,result.length()-1);
        else
            return result;
    }
    public static void main(String[] args) {
        String s ="the sky is blue";
        System.out.println(new Reverse_Words_in_a_String().reverseWords(s));

    }

}
