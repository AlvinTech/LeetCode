package book.stack;

import java.util.Scanner;
import java.util.Stack;

public class Conversion {

	public static int conver(int a,int base){
		Stack<Integer> s = new Stack<Integer>();
		while(a != 0){
			s.push(a % base);
			a = a / base;
		}
		String str = "";
		int baseInt=0;
		while(!s.isEmpty()){
			baseInt = baseInt * 10 + s.pop();
		}
		return baseInt;
		
	}
	
	
	public static long conver(int baseFrom, int baseTo,int a){
		Stack<Integer> s  = new Stack<Integer>();
		String str  = ""+a;
		System.out.println(str.length());
		int intBase10 =0;
		//转10进制

		for(int i=0;i<str.length();i++){
			intBase10 = intBase10* baseFrom + (str.charAt(i)-'0') % baseFrom;
		}
		//10转baseTo进制

		while(intBase10 !=0){
			s.push(intBase10 % baseTo);
			intBase10 = intBase10 /baseTo;
		}
		long newInt = 0;
		System.out.println(s.size());
		while(!s.isEmpty()){
			newInt = newInt * 10 + s.pop();
		}
		return newInt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	Scanner scanner = new Scanner(System.in);
		int a = 1348;
		System.out.println("input base=:");
		int base = scanner.nextInt();
		while(a != 0 ){
			System.out.print("input new a:");
			a  = scanner.nextInt();
			System.out.println("newInt:"+new Conversion().conver(a, base) );
		}*/
		System.out.println(new Conversion().conver(10, 8, 15));
	}
	
	

}
