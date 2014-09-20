package v1;
/**
 * 2014-5-16
 * @author Alvin
 * 
 */

public class Count_and_Say {
	
    public String countAndSay(int n) {
    	String sta = "1";
    	String end ="";
        for(int i=0;i< n-1;i++){
        	end = say(sta);
        	
        	sta = end;
        }
        
        return sta;
    }
    
    public String say(String str){
    //	System.out.println(str);
    	String result = "";
    	int count =1;
    	for(int i=0;i< str.length();i++){
    		if(i==str.length() -1){
    			result += count + str.substring(i,i+1);
    			count =  1;
    		}
    		else if(str.charAt(i) ==str.charAt(i+1)){
    			count++;
    		}else{
    			result += count +str.substring(i,i+1);
    			count =  1;
    		}
    	}
    	System.out.println(result);	
    	return result;
    }
	public static void main(String[] args) {
		new Count_and_Say().countAndSay(1);
	}

}
