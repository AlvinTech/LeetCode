package v1;
/**
 * 2014-6-4
 * @author Alvin
 * 
 */

public class Multiply_Strings {

    public String multiply(String num1, String num2) {
    	int length2 = num2.length();
    	int length1 = num1.length();
    	String[] list = new String[length2+1];
    	int total = length1+ length2;
    	int i;
    	
    	//pre  初始化，填充每行开头的0 和结尾的0
    	for( i=0; i < length2;i++ ){
    		list[i] = zero(length2 -i)+ num1+ zero(i);
    		//  计算 一个字符串 * 一个值 的字符串。
    		list[i] = multip(list[i],num2.charAt(length2-1-i));
    	//	System.out.println(list[i]);
    	}
    	
    	return aftDo(list);
    }
    
    private String aftDo(String[] list) {
    	int val =0;
    	int length  = list.length;
    	if(length == 0)
    		return null;
    	else
    		list[length -1] ="";
    	for(int j = list[0].length()-1; j>=0;j--){
    		val = (val / 10) ;  // 处理进位
    		for(int i=0; i< list.length-1;i++ ){
    			val += list[i].charAt(j)-'0';
    		}
    		list[list.length-1]= val% 10 + list[list.length-1];
    	}
    	// delete pre 0   如果结果为“0000”的情况需要处理
    	String result = list[length-1];
    	for(int i =0;i<result.length();){
    		if(result.length() != 1 && result.charAt(0) == '0')
    			result= result.substring(1);
    		else
    			break;
    	}
    		
    	
    		return result;
	}

	public String zero(int n){
    	String result ="";
    	for(int i=0; i< n;i++){
    		result += "0";
    	}
    	return result;
    }
    
    public String multip(String num,char n){
    	String result ="";
    	int val = 0;
    	for(int i =num.length()-1 ;i>=0;i--){
    	//	System.out.println(num.charAt(i)-'0');
    		val = (num.charAt(i)-'0') * (n -'0')+ (val/10) % 10; // 这个进位方法有问题，但是再这里就没有问题，因为这里的进位值不会是2位数
    		//System.out.println(val);
    		//result = num.substring(0, i)+ val%10 +num.substring(i+1);
    		result =  val%10 +result;
    	
    		
    	}
    //	System.out.println(result);
    	return result;
    }
	public static void main(String[] args) {
	//	new Multiply_Strings().multiply("123456789", "111112222");
		String num1 ="9369162965141127216164882458728854782080715827760307787224298083754";
		String num2 ="7204554941577564438";
	/*	long a1 = Long.parseLong(num1);
		long a2 = Long.parseLong(num2);
		//System.out.println(a1  +"    " + a2);
		long a3 = a1 * a2;
		System.out.println(a3);
		System.out.println();
		*/
		String s = new Multiply_Strings().multiply(num1, num2);
		System.out.println(s);
		//System.out.println(s.endsWith("67143675422804947379429215144664313370120390398055713625298709447"));
	}

}
