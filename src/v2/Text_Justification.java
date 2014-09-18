/**  Text Justification
 * 2014-9-7
 * @author Alvin
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
"This    is    an",
"example  of text",
"justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Text_Justification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new ArrayList<String>();
        int sta=0;
        int length =0;
        for(int i=0 ; i < words.length && words[i] != "";i++){
            length += words[i].length() + 1;
            //   System.out.println(length);
            if(length-1 >L ){
                line(Arrays.copyOfRange(words, sta, i),length-2 - words[i].length(),L ,list);
                sta = i;
                i--;
                length =0;
            }
        }
        if(sta < words.length){
            String str ="";
            length = 0;
            for(int i=sta; i< words.length &&  words[i] != "";i++){
                str += words[i] + " ";
                length += words[i].length()+1;
            }
            for(int i=0; i< L - length;i++)
                str += " ";

            list.add(str.substring(0,L));
        }


        return list;
    }
    public void line(String[] words,int length, int L,List<String> list){
        int n = words.length;
        if(n==1){
            String str = words[0];
            for(int i=words[0].length(); i< L ;i++)
                str += " ";
            list.add(str);
            return;
        }

        int sp = (L - length+n-1);
        int[] sps = new int[n-1];

        if(sps.length != 0 ){

            for(int i=0;i < sp;i++ ){
                sps[i%(n-1)]++;
            }
        }
        String str = "";
        for(int i=0;i < n;i++ ){
            str +=words[i];
            for(int j=0;i != n-1 && j < sps[i];j++ ){
                str+=" ";
            }
        }
        list.add(str);

        System.out.println(str);
    }
    public static void main(String[] args) {
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = {"a", "b", "c", "d", "e", "f", "g"};
        String[] words = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};

        List<String> list = new Text_Justification().fullJustify(words, 30);
        System.out.println(list);

    }

}
