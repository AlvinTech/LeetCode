/*
Sqrt(x) 
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Sqrt{
    public int sqrt(int x) {
        double y=0,z=1.0;
        while((int)y - (int)z != 0){
            y = z;
            z = (double)x/2/y+y/2;
        }
        return (int)y;
    }
    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(4));
    }
}