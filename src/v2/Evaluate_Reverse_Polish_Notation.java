/*  Evaluate Reverse Polish Notation
*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
* */

/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-15
 * Time: 下午5:03
 * To change this template use File | Settings | File Templates.
 */
import java.util.Stack;
public class Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack() ;

        for(int i=0;i<tokens.length;i++){
            if(isOperators(tokens[i])){
                int va2 = s.pop();
                int va1 = s.pop();
                if("+".equals(tokens[i]))
                    s.push(va1+va2);
                else if("-".equals(tokens[i]))
                    s.push(va1-va2);
                else if("*".equals(tokens[i]))
                    s.push(va1*va2);
                else if("/".equals(tokens[i]))
                    s.push(va1/va2);


            }
            else
                s.push(Integer.parseInt(tokens[i]));
        }

        return s.pop();

    }
    public boolean isOperators(String operator){
        if(operator.equals("+")||operator.equals("-") || operator.equals("*")||operator.equals("/"))
            return true;
        else
            return false;
    }




    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation s = new Evaluate_Reverse_Polish_Notation();
        String[] tokens ={"2", "1", "+", "3", "*"};
        System.out.println(s.evalRPN(tokens));

    }
}
