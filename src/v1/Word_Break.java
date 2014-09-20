package v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 2014-6-16
 * @author Alvin
 * 
 */

public class Word_Break {

	List<String> list  = new ArrayList<String>();
	public List<String> wordBreak(String s, Set<String> dict) {
		word(s,dict,"");
		return list;
	}
	public void  word(String s, Set<String> dict,String text){
		if(dict.contains(s)){
			text+= " " + s;
			list.add(new String(text).trim());
		}
		Iterator<String> iterator = dict.iterator();
		while(iterator.hasNext()){
			String str = iterator.next();
			int length = s.length();
			if(s.startsWith(str))
				word(s.substring(str.length()),dict,text+" "+str);
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		System.out.println(Arrays.toString(new Word_Break().wordBreak(s,dict).toArray()));
	}

}
