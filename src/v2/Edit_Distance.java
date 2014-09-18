/* DP
1.如果 word1[i] = word2[j] 则array[i][j] = array[i][j] 无需任何改变就能以相同的步数转化
2.如果不相等   word1[0..i] 转化到word2[0..j] 可以通过下面的途径转化
a. word1[0..i-1] 转化到 word2[0..j] 然后 world1在加上world[i];
b. word1[0..i] 转化到word2[0..j-1] 然后word2 加上word2[j];
c. word1[0..i-1] 转化到word2[0..j-1] 然后将word1[i] 换成word[j];
所以对于第二种情况
Array[i][j] = Min(array[i][j],array[i-1][j],array[i][j-1]) + 1 ；3种情况都会增加一步转化 

Edit Distance 
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

public class Edit_Distance{
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int array[][]= new int[n+1][m+1];
        //init
        for(int i =0 ; i < n+1;i++)
            array[i][0] = i;
        for(int i = 0 ; i < m +1; i++)
            array[0][i] = i;
        for(int i = 1; i < n+1;i++)
            for(int j = 1; j < m+1;j++){
                if(word2.charAt(i-1) == word1.charAt(j-1))
                    array[i][j] = array[i-1][j-1];
                else
                    array[i][j] = Math.min(array[i-1][j-1],Math.min(array[i-1][j],array[i][j-1]))+1;

            }
        return array[n][m];
    }
    public static void main(String[] args){
        System.out.println(new Edit_Distance().minDistance("12345","12345"));
    }
} 