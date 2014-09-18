package v1;
import java.util.Arrays;
import java.util.Stack;

/**
 * 2014-9-3
 * @author Alvin
 * 
 */

public class Simplify_Path {
	 public String simplifyPath(String path) {
	    	String[] array = path.split("/");
	    	Stack<String> stack = new Stack<String>();
	    	boolean out = false;
	    	for(int i=0 ;i< array.length;i++){
	    		if(array[i].equals("."))
	    			continue;
	    		else if(array[i].equals("..")){
	    			//out= true;
	    			if(!stack.empty())
	    				stack.pop();
	    		}else{
	    			if(array[i].trim().length() != 0)
	    				stack.add(array[i]);
	    		}
	    		
	    	}
	    	String result = "";
	    	while(!stack.empty()){
	    		result = "/"+stack.pop()+result;
	    	}
	    	if(result.length() == 0)
	    	    return "/";
	        return result;
	    }
	public static void main(String[] args) {
		String str ="/a/./b/../../c/";
		System.out.println(new Simplify_Path().simplifyPath("/.."));

	}

}
