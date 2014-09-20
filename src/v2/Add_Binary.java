/**
 * 2014-6-10
 * @author Alvin
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class Add_Binary {

    public String addBinary(String a, String b) {
        if( a == null)
            return b;
        if(b == null)
            return a;
        int lengtha = a.length();
        int lengthb = b.length();
        int length = lengtha > lengthb ? lengtha :lengthb;
        length++;
        char[] arrayA = new char[length];
        char[] arrayB = new char[length];

        for(int i =0;i<length;i++ ){
            arrayA[length-1-i]='0';
            arrayB[length-1-i] = '0';
            if(i< lengtha)
                arrayA[length-1-i] = a.charAt(lengtha-1-i);
            if(i< lengthb)
                arrayB[length-1-i] = b.charAt(lengthb-1-i);

        }
        String result ="";
        int val =0;
        for(int i=length-1;i>= 0;i--){
            val += (arrayA[i]-'0')+ (arrayB[i]-'0');
            result = val%2 + result;
            val = val/2;
        }
        if(result.charAt(0)=='0')
            result = result.substring(1);
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Add_Binary().addBinary("100111101", "111"));
    }

}
