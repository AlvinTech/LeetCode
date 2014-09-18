/*KMP算法 字符串匹配问题
kmp算法是一种改进的字符串匹配算法，由D.E.Knuth与V.R.Pratt和J.H.Morris同时发现，因此人们称它为克努特——莫里斯——普拉特操作（简称KMP算法）。KMP算法的关键是根据给定的模式串W1,m,定义一个next函数。next函数包含了模式串本身局部匹配的信息。
Implement strStr
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
　
对于next[]数组的定义如下：

　1) next[j] = -1  j = 0

　2) next[j] = max(k): 0<k<j   P[0...k-1]=P[j-k,j-1]

　3) next[j] = 0  其他

　如：

　P      a    b   a    b   a

　j      0    1   2    3   4

 next    -1   0   0    1   2
*/
import java.util.Arrays;
public class Implement_strStr{
    public int[] getNext(char[] t){
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i < t.length-1){
            if(j == -1 || t[i] == t[j]){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }



    public String strStr(String haystack, String needle) {
        if(needle.length() ==0)
            return haystack;
        int [] next = getNext(needle.toCharArray());
        int i = 0;
        int j = 0;
        while(i < haystack.length()){
            if(j == -1 || haystack.charAt(i)== needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
            if(j == needle.length())
                return haystack.substring(i - needle.length(),haystack.length());
        }

        return null;

    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Str().getNext("ababc".toCharArray())));
//        System.out.println(new Str().strStr("",""));
    }
}