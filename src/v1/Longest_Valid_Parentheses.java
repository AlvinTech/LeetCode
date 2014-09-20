package v1;
import java.util.Arrays;
import java.util.Stack;


public class Longest_Valid_Parentheses {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> index = new Stack<Integer>();
        int val[] = new int[s.length()];
        int num =0;
        for(int i =0 ;i< s.length();i++){
        	if(s.charAt(i) == ')'&& !stack.empty() && stack.peek() == '('){
        		stack.pop();
        		val[index.pop()] = 1;
        		val[i] = 1;
        	}else{
        		stack.push(s.charAt(i));
        		index.push(i);
        	}
        }
        int k =0;
        System.out.println(Arrays.toString(val));
        for(int i =0 ;i< s.length();i++){
        	if(val[i] == 0 ){
        		num = Math.max(k, num);
        		k=0;
        	}
        	else
        		k++;
        }
        num = Math.max(k, num); 
        return num;
    }
	public static void main(String[] args) {
		System.out.println(new Longest_Valid_Parentheses().longestValidParentheses("()"));

	}

}
