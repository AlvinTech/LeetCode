/*
Divide Two Integers
Divide two integers without using multiplication, division and mod operator.
*/
public class Divide_Two_Integers{
    int divide(int dividend, int divisor) {
        long  a = Math.abs(( long)dividend);
        long  b = Math.abs(( long)divisor);
        int ans = 0, i = 0;
        while (a > b){
            i++;
            b = b << 1;
        }
        while (i >= 0){
            if (a >= b){
                a -= b;
                ans += (1 << i);
            }
            b = b >> 1;
            i--;
        }
        //通过最高位（符号位）亦或来判断最后结果的符号位。
        return (((dividend >> 31)^(divisor >> 31))==0) ? ans : -ans;
    }
}