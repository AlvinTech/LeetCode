package v1;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 2014-9-10
 * @author Alvin
 * 
 */

public class Word_Ladder2 {

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
	 public boolean oneStepChange(String word1, String word2){
	    	int num = 0;
	    	if(word1.length() !=  word2.length())
	    		return false;
	    	for(int i=0;i< word1.length();i++){
	    		if(word1.charAt(i) != word2.charAt(i))
	    			num++;
	    	}
	    	return (num ==1)? true: false;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
