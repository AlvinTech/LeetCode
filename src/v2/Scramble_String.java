/*
Scramble String 
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

DP

*/
public class  Scramble_String{
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2== null || s1.length() != s2.length() )
            return false;
        int length = s1.length();
        boolean[][][] flag = new boolean[length][length][length+1];
        for(int k =1;k <= length; k++){
            for (int i =0;i <=length-k ;i++ ) {
                for (int j=0; j<=  length-k;j++ ) {
                    if(k ==1){
                        flag[i][j][k] = (s1.charAt(i) == s2.charAt(j)? true: false);
                    }

                    else{
                        for(int l =1; l < k;l++){
                            if((flag[i][j][l] &&flag[i+l][j+l][k-l] )|| (flag[i][j + k - l][l] && flag[i + l][j][k - l])){
                                flag[i][j][k] = true;
                                break;
                            }
                        }
                    }

                }

            }
        }

        return flag[0][0][length];
    }
    public static void main(String[] args) {
        System.out.println(new Scramble_String().isScramble("great","rgeat"));
    }
}

