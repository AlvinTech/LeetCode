package v1;
/**
 * 2014-9-3
 * @author Alvin
 * 
 */
/*
 * 判断是否为合法的数字
 * 整数 102938
 * 小数 0.1123
 * 正负数 -102938
 * 科学记数 2e10
 * */
public class Valid_Number {
    public boolean isNumber(String s) {
    	String num = s.trim().toLowerCase();
    	if(num.length() == 0)
    		return false;
    	for(int i = 0 ; i< num.length();i++){
    		if(!charNumber(num.charAt(i)))
    			return false;  			
    	}
    	if(num.charAt(0) == '-'|| num.charAt(0) == '+')
    		return valid(num.substring(1));
    	else 
    		return valid(num);
    }
    public boolean valid(String num){
    	if(num.length() == 0)
    		return false;
    	//小数 科学计数
     	int pos1 = num.indexOf(".");
    	int pos2 = num.indexOf("e");
    	if(pos1 >-1 && pos2 <0){//小数
    		if(num.length() ==1)
    			return false;
    		return onlyNumber(num.substring(0,pos1),false) && onlyNumber(num.substring(pos1+1),false);
    	}else if(pos1 >-1 && pos2 >-1){//小数 科学计数
    		if(num.length() <= 2)
    			return false;
    		if(pos1 > pos2)
    			return false;
    		
    		if(pos2 == pos1+1)
     		   return onlyNumber(num.substring(0,pos1),true) && onlyNumber2(num.substring(pos2+1),false) && !(num.substring(0,pos1).matches("0*")); 
    		
    		   return onlyNumber(num.substring(0,pos1),false) && onlyNumber(num.substring(pos1+1,pos2),false) && onlyNumber2(num.substring(pos2+1),false)&& !(num.substring(0,pos1).matches("0*")&&num.substring(pos1+1,pos2).matches("0*"));
    	}else if(pos1<0 && pos2>-1){//科学计数
    		if(num.length() ==1)
    			return false;
    		boolean flag = onlyNumber(num.substring(0,pos2),true) && onlyNumber2(num.substring(pos2+1),false);
    		String a ="";
    		if(flag)
    			 a = num.substring(0,pos2);
    		return (!a.equals("0")) && flag;
    	}else{
    		return onlyNumber(num,true);
    	}
    		
    }
   public boolean onlyNumber(String str,boolean flag){  //true 必须有值，false 可以没有值
	   if(str.length() == 0 && flag)
		   return false;
	   for(int i = 0 ;i<str.length();i++){
		   if(str.charAt(i) <'0' || str.charAt(i) >'9')
			   return false;
	   }
	   return true;
   }
   public boolean onlyNumber2(String str,boolean flag){ 
	   if(str.length() == 0)//true 必须有值，false 可以没有值
		   return flag;
	   if(str.charAt(0)=='-' || str.charAt(0)=='+')
		   return onlyNumber(str.substring(1),true);
	  
	   return onlyNumber(str.substring(0),true);
   }
   public boolean charNumber(char c){
    	if( (c <='9' && c>='0') || c =='-'||c =='+'|| c=='.' ||c=='e')
    		return true;
    	else
    		return false;
    }
  
	public static void main(String[] args) {
		//".1e" 对的
		// 5e 错得
    	String[] s = {
    			"5e",".1e",".0e","4078046578e3992","0e","+.8"," .2e81","005047e+6","1 a","2e10"
    	};
    	for(int i =0; i< s.length;i++)
    		System.out.println(new Valid_Number().isNumber(s[i]));
    	System.out.println("000001".matches("0+"));
    	System.out.println("".matches("0*"));
		// TODO Auto-generated method stub

	}

}
