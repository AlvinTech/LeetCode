/*  String to Integer
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.
*/

public class String_to_Integer {
    public int atoi(String str) {
        Long result  =0l;
        int flag = 0;
        int pow = 0;
        String val = str.trim();
        for (int i=0;i< val.length();i++) {
            pow = 10* pow;
            if((val.charAt(i) == '-'||val.charAt(i) == '+')){
                if(flag == 0 && val.charAt(i) == '-' )
                    flag = -1;
                else if(flag == 0 && val.charAt(i) == '+' )
                    flag =1;
                else
                    return 0;
            }

            else if(val.charAt(i) >= '0' && val.charAt(i) <= '9'){

                result = 10* result + val.charAt(i) -'0';
                if(2147483647  < result && (flag ==1 || flag==0))
                    return 2147483647;
                if(2147483648L <  result && (flag ==-1 ))
                    return -2147483648;

            }else{
                break;
            }

        }
        if(flag == 0)
            return (int) ((int)1*result);
        else
            return (int) ((int)flag*result);
    }
    public static void main(String[] args) {
        String  str  = "  -11919730356x";
        // int a = 2147483648;
        // System.out.println(a);
        System.out.println(new String_to_Integer().atoi(str));
    }
}