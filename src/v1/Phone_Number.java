package v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2014-7-20
 * @author Alvin
 * 
 */

public class Phone_Number {

	/**
	 * @param args
	 */
	private static char[][] map = {{},{'a','b','c'},{'d','e','f'},
								   {'g','h','i'},{'j','k','l'},{'m','n','o'},
								   {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
	
    public List<String> letterCombinations(String digits) {
    	List<String> list = new ArrayList<String>();
    	Combinations(list,"",digits,digits.length());
		return list;
        
    }
    
    public void Combinations( List<String> list, String letters,String digits,int index){
    	if(index <=0){
    		list.add(letters);
    		return;
    	}
    	int j = digits.charAt(digits.length() -index)-'0' -1;
    	for(int i=0; i < map[j].length; i++){
    		String lettersNew = letters + map[j][i]; 
    		
    		Combinations(list,lettersNew,digits,index-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		for(int i =0; i< map.length;i++)
//			for(int j = 0;j < map[i].length;j++){
//				System.out.println(map[i][j]);
//			}
		String digits ="23";
		System.out.println(Arrays.toString(new Phone_Number().letterCombinations(digits).toArray()));

	}

}
