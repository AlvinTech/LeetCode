/**     Longest Substring Without Repeating Characters
 * 2014-9-9
 * @author Alvin
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


 */

public class Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(s==null || s.length() < 2)
            return s.length();

        int[] maxLens = new int[length+1] ;
        int[] reSta = new int[length];
        maxLens[0]=0;
        maxLens[1] = 1;
        reSta[0]=-1;
        for(int i =2; i<= length;i++){
            reSta[i-1] = i-1 - maxLens[i-1]-1;
            for(int j=i - 1 - maxLens[i-1];j < i-1;j++){
                if(s.charAt(j) == s.charAt(i-1))
                    reSta[i-1] = j;
            }
            maxLens[i] = maxLens[i-1]+1;
            for(int j=i - 1 - maxLens[i-1];j <= i-1;j++){
                if(reSta[j] >= i - 1 - maxLens[i-1])
                    maxLens[i] = maxLens[i-1];
            }
        }
        return maxLens[length];

    }
    public static void main(String[] args) {
        String s ="bbbbb";
        System.out.println(new Longest_Substring_Without_Repeating_Characters().lengthOfLongestSubstring(s));

    }

}
