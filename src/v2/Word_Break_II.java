/*
Word Break II 
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
public class Word_Break_II{
    Set<String> map = new HashSet<String>();

    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if(s == null || s .length() ==0)
            return result;
        result = word(s,dict);
        return result;
    }
    public List<String> word(String s, Set<String> dict){
        if(map.contains(s))
            return null;
        List<String> list = new ArrayList<String>();
        for (int i=1; i<= s.length();i++ ) {
            List<String> temp = new ArrayList<String>();
            String str = s.substring(0,i);
            if(dict.contains(str)){
                if(i < s.length())
                    temp = word(s.substring(i,s.length()),dict);
                else{
                    for (int j =0;j < temp.size() ; j++) {
                        list.add(str+" "+ temp.get(j));
                    }
                }
            }
            else{
                map.add(s.substring(i,s.length()));
            }
        }
        return (list.size() > 0)? list : null;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
