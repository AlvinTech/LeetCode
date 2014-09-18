package v1;
/**
 * 2014-9-16
 * @author Alvin
 * 
 */

public class Valid_Number2 {


	public boolean isNumber(String s){
		char[] c = s.trim().toCharArray();
		if(c.length == 0) 
			return false;
		int i =0,num =0;
		if(c[i] == '+' || c[i] =='-')
			i++;
		for(;i < c.length && (c[i]>='0' && c[i] <= '9');i++)
			num++;
		if(i < c.length && c[i] == '.')
			i++;
		for(;i < c.length && (c[i]>='0' && c[i] <= '9');i++)
			num++;
		if(num == 0)
			return false;
		if(i == c.length)
			return true;
		else if(i < c.length && c[i] != 'e')
			return false;
		else i++;
		num =0;
		if(i<c.length&&(c[i] == '+' || c[i] =='-'))
			i++;
		for(;i < c.length && (c[i]>='0' && c[i] <= '9');i++)
			num++;
		if(num == 0 )
			return false;
		if(i == c.length )
			return true;
		else
			 return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
