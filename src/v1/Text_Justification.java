package v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2014-9-7
 * @author Alvin
 * 
 */

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
