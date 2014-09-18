/*  Substring with Concatenation of All Words
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Substring_with_Concatenation_of_All_Words {

    private List<Integer> list = new ArrayList<Integer>();
    private Map<String, Integer> require = new HashMap<String, Integer>();
    private Map<String, Integer> use = new HashMap<String, Integer>();

    public List<Integer> findSubstring(String S, String[] L) {
        initRequire(L);
        int step = L[0].length();
        for (int i = 0; i < step; i++) {
            int start = i;
            int j = i;
            int count = L.length;
            use.clear();
            while (j <= S.length() - step) {
                String word = S.substring(j, j + step);
                if (!require.containsKey(word)) {// AEBACD nedd ABC when it E
                    j = j + step;
                    start = j;
                    use.clear();
                    count = L.length;
                } else if (!use.containsKey(word)
                        || use.get(word) < require.get(word)) { // AEBACD A
                    if (!use.containsKey(word))
                        use.put(word, 1);
                    else
                        use.put(word, use.get(word) + 1);
                    count--;
                    j = j + step;
                } else {// AEBACD second A so A is more the one; we should
                    // delete the element util the first A;
                    String temp = S.substring(start, start + step);
                    while (!temp.equals(word)) {
                        if (use.containsKey(temp)) { // delete an useful element
                            use.put(temp, use.get(temp) - 1);
                            count++;
                        }
                        start = start + step;
                        temp = S.substring(start, start + step);
                    }
                    start = start + step;
                    j = j + step;

                }
                if (count == 0 && use.size() != 0) {
                    list.add(start);
                }
            }
        }
        return list;
    }

    public void initRequire(String[] L) {
        for (int i = 0; i < L.length; i++) {
            if (!require.containsKey(L[i])) {
                require.put(L[i], 1);
            } else
                require.put(L[i], require.get(L[i]) + 1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String S = "abaababbaba";
        String[] L = { "ab", "ba", "ab", "ba" };
        System.out.println(new Substring_with_Concatenation_of_All_Words()
                .findSubstring(S, L));
    }

}
