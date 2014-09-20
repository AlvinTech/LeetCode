/**   Reverse Integer
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321


 */
public class Reverse_Integer {
    public int reverse(int x) {
        int y = 0;
        while(x !=0){
            y = y*10 + x % 10;
            x = x/10;
        }
        return y;
    }
}
