/*  Valid Number
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
* */
public class Valid_Number {


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
}
