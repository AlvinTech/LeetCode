/* 递归
Palindrome Partitioning 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
注意： List 深拷贝。
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Palindrome_Partitioning {
    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        subPartition(result,list,s);

        return result;
    }

    public void subPartition(List<List<String>> result ,List<String> list,String s){
        if(s.length() == 0){
            List<String> listNew = new ArrayList<String>(list);
            result.add(listNew);
            return ;
        }

        for(int i =1 ; i <= s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                list.add(s.substring(0,i));
                subPartition(result,list,s.substring(i));
                list.remove(s.substring(0,i));
            }
        }
    }

    public boolean isPalindrome(String s){
        int length = s.length();
        for(int i = 0 ; i < length/2 ;i++){
            if(s.charAt(i) != s.charAt(length-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Hello World");
        String s ="aab";
        List<List<String>> result = new ArrayList<List<String>>();
        result = new Palindrome_Partitioning().partition(s);
        for(int i = 0 ; i< result.size();i++)
            System.out.println(Arrays.toString(result.get(i).toArray()));
    }

}