import java.util.Arrays;

/**
 * 2014-7-15
 * @author Alvin
 * 
 */

public class Plus_One {

	public int[] plusOne(int[] digits) {
		int[] array = new int[digits.length + 1];
		int[] array2 = new int[digits.length];
		int val = 1;
		for(int i =digits.length-1 ; i>=0 ;i--){
			val = digits[i]+val;
			array2[i]= val % 10;
			array[i+1] = val % 10;
			val = val /10;
		}
		
		if(val == 0)
			return array2;
		else{
			array[0] = val;
			return array;
		}
	}
	public static void main(String[] args) {
		int[] digits ={1,9};
		System.out.println(Arrays.toString(new Plus_One().plusOne(digits)));

	}

}
