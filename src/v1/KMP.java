package v1;
/**
 * 2014-9-10
 * @author Alvin
 * 
 */

import java.util.Arrays;
public class KMP{
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



    public String strStr(String s, String t) {
    	if(t.length() ==0)
    		return s;
        int [] next = getNext(t.toCharArray());
        int i = 0;
        int j = 0;
        while(i < s.length()){
        	if(j == -1 || s.charAt(i)== t.charAt(j)){
        		i++;
        		j++;
        	}else {
        		j = next[j];
        	}
        	if(j == t.length())
        		return s.substring(i - t.length(),s.length());
        } 
       
        return null; 
        
    }	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new KMP().getNext("ababc".toCharArray())));
		//[-1, 0, 0, 1, 2]
		System.out.println(new KMP().strStr("123456789","234"));
	}
}