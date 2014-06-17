import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 2014-6-16
 * @author Alvin
 * 
 */

public class Word_Break {

	public boolean wordBreak(String s, Set<String> dict) {
		if(dict.contains(s))
			return true;
		else{
			Iterator<String> iterator = dict.iterator();
			while(iterator.hasNext()){
				String str = iterator.next();
				int length = s.length();
				if(s.startsWith(str) && wordBreak(s.substring(str.length()),dict))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(new Word_Break().wordBreak(s,dict));
	}

}
