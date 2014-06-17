import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 2014-4-11
 * @author Alvin
 * 
 */

public class Integer_to_Roman {

	private static LinkedHashMap<Integer,String> dic = new LinkedHashMap<Integer,String>();
	static{
		dic.put(1000, "M");
		dic.put(900, "CM");
		dic.put(500, "D");
		dic.put(400, "CD");
		dic.put(100, "C");
		dic.put(90, "XC");
		dic.put(50, "L");
		dic.put(40, "XL");
		dic.put(10, "X");
        dic.put(9, "IX");
        dic.put(5, "V");
        dic.put(4, "IV");
        dic.put(1, "I");
	}
    public String intToRoman(int num) {
        for(int x : dic.keySet()){
        	if(num >=x){
        		return dic.get(x) + intToRoman(num - x);
        	}
        }
        return "";
    }
	public static void main(String[] args) {
		System.out.println(new Integer_to_Roman().intToRoman(1001));

	}

}
