package v1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import java.util.ArrayList;
/**
 * Word Ladder II 
 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;
public class Word_Ladder_II {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	 if(start == null || end == null|| start.equals(end)
				 || start.length() !=  end.length())
			 return result;

		 Queue<String> queue = new LinkedList<String>();
		 Map<String,Integer> map = new HashMap<String,Integer>();
		 Map<String,List<List<String>>> change = new HashMap<String,List<List<String>>>();
		 queue.add(start);
		 List<String> list ;
		 list = new ArrayList<String>();
		 List<List<String>> next =  new ArrayList<List<String>>();
		 list.add(start);
		 next.add(list);
		 change.put(start,next);
		 map.put(start,1);
		 int minLength =Integer.MAX_VALUE;
		 while(!queue.isEmpty()){
			 String head = queue.poll();
			 int headDist = map.get(head);
			 for(int i =0; i< head.length() && headDist+1 <= minLength;i++){
				 for(char j = 'a'; j < 'z'; j++){
					 if(head.charAt(i) == j)
						 continue;
					 StringBuilder sb = new StringBuilder(head);
					 sb.setCharAt(i,j);
					 if(sb.toString().equals(end)){
						
						 List<List<String>> newNext =  new ArrayList<List<String>>();
						 for(List<String> val  : change.get(head)){
							 list = new ArrayList<String>(val);
							 list.add(sb.toString());
							 result.add(list);
						 }						
						 minLength = headDist+1; 
					 }
						 
					 if(dict.contains(sb.toString())){
						 if(!map.containsKey(sb.toString())){
							 queue.add(sb.toString());
							 List<List<String>> newNext =  new ArrayList<List<String>>();
							 for(List<String> val  : change.get(head)){
								 list = new ArrayList<String>(val);
								 list.add(sb.toString());
								 newNext.add(list);
							 }
							 change.put(sb.toString(),newNext);
							 map.put(sb.toString(),headDist+1);
						 }else{
							
							 for(List<String> val  : change.get(head)){
								 list = new ArrayList<String>(val);
								 list.add(sb.toString());
								 change.get(sb.toString()).add(list);
							 }
						 }
						 
					 }
					 
				 }
			 }
		 }
		 return result;
	    }
    public static void main(String[] args) {
		Set<String> dict =new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("tax");
		dict.add("tad");
//		["ted","tex","red","tax","tad","den","rex","pee"]
		dict.add("den");
		dict.add("rex");
		dict.add("pee");

		List<List<String>> result  =new Word_Ladder_II().findLadders("red","tax",dict);
		for(int i=0 ;i< result.size();i++)
			System.out.println(result.get(i));
	}
}
