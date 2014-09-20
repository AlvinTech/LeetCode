/*   Minimum Window Substring
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * */
public class Minimum_Window_Substring {
    public String minWindow(String S, String T) {
        int m = S.length();
        int n  = T.length();
        int require[] = new int[128];
        boolean use[] = new boolean[128];
        char s[] = S.toCharArray();
        int count  =  n;
        int i=-1 ,j=0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for(i = 0 ; i< n ;i++){
            require[T.charAt(i)]++;
            use[T.charAt(i)] = true;
        }
        i=-1;
        while(i < m && j < m){
            if(count > 0){
                i++;
                if( i == m)
                    break;
//        		System.out.print(s[i]+"   "+require['A']+" "+require['B']+" "+require['C']+"******* ");
                if(i ==12)
                    i =12;
                require[s[i]]--;
                if(use[s[i]] && require[s[i]] >= 0)
                    count--;
//        		System.out.println(require['A']+" "+require['B']+" "+require['C']+" " +count);
            }
            if(count == 0){
                if(minLen > i-j+1){
                    minLen  = i-j+1;
                    start = j;
                }
                require[s[j]]++;
                if(use[s[j]] && require[s[j]] > 0)
                    count++;
                j++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : S.substring(start,start+minLen);
    }
    public static void main(String[] args) {
        String S= "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(new Minimum_Window_Substring().minWindow(S, T));

    }

}
