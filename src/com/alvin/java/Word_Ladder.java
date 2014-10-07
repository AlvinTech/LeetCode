/*
Word  Ladder
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

思路1、 图论方法  dijkstra 最短路劲
改进： 
超时的地方不在BFS遍历，而是在我们构造图的地方。我们采用了两层遍历构造一个图，此时复杂度是O(n2)，数据量很小时可能
体现不出它的劣势，但是当n上千时（给定的测试集中有这样的例子），上面的方法构造图就显得太慢。

这里我们可以不用实际构造图，而在BFS遍历的时候去寻找当前单词可达的下一个单词。如果还是通过遍历所有的单词判断是否
可达，则复杂度和上面一样，但实际上在上千个单词中，只有少数几个可以由当前单词一步到达，我们之前的比较浪费了很多时间
在不可能的单词上。网上对该问题的解决无一例外都是按照下面的思路：将当前单词每一个字符替换成a~z的任意一个字符，然后
判断是否在词典中出现。此时的复杂度是O(26*word_length)，当单词比较短时，这种方法的优势就体现出来了。
*/
package com.alvin.java;
import java.util.*;

public class Word_Ladder {

    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null|| start.equals(end)
                || start.length() !=  end.length())
            return 0;

        Queue<String> queue = new LinkedList<String>();
        Map<String,Integer> map = new HashMap<String,Integer>();
        queue.add(start);
        map.put(start,1);
        while(!queue.isEmpty()){
            String head = queue.poll();
            int headDist = map.get(head);
            for(int i =0; i< head.length();i++){
                for(char j = 'a'; j < 'z'; j++){
                    if(head.charAt(i) == j)
                        continue;
                    StringBuilder sb = new StringBuilder(head);
                    sb.setCharAt(i,j);
                    if(sb.toString().equals(end))
                        return headDist+1;
                    if(dict.contains(sb.toString()) && !map.containsKey(sb.toString())){
                        queue.add(sb.toString());
                        map.put(sb.toString(),headDist+1);
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Set<String> dict =new HashSet<String>();
        dict.add("lest");
        dict.add("leet");
        dict.add("lose");
        dict.add("code");
        dict.add("lode");
        dict.add("robe");
        dict.add("lost");
        System.out.println(new Word_Ladder().ladderLength("leet","code",dict));
    }
}
