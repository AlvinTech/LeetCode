package v1;
import java.util.Stack;

/**
 * 2014-7-7
 * @author Alvin
 * 
 */

public class Valid_Parentheses {

	public boolean isValid(String s) {
		if(s.length() % 2 !=0)
			return false;
		Stack<Character>  stack   = new Stack<Character>();
		for(int i =0 ;i < s.length();i++){
			if(s.charAt(i) == '}'){
				 if(stack.empty())
					 return false;
				 else if(stack.peek() != '{')
					 return false;
				 else
					 stack.pop();
			}
			else if(s.charAt(i) == ']'){
				 if(stack.empty())
					 return false;
				 else if(stack.peek() != '[')
					 return false;
				 else
					 stack.pop();
			}
			else if(s.charAt(i) == ')'){
				 if(stack.empty())
					 return false;
				 else if(stack.peek() != '(')
					 return false;
				 else
					 stack.pop();
			}else
				stack.push(s.charAt(i));
				
		}
		return stack.empty();
		
	        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "][[[(({{}}))]]]";
		System.out.println(new Valid_Parentheses().isValid(s));
	}

}
