/**
 * 2014-4-28
 * @author Alvin
 * 
 */
import java.util.*;
public class Gray_Code {

	public ArrayList<Integer> grayCode(int n) {
		if (n == 0)
			return null;
		else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int max = 1 << n;
			int[] num = new int[max];
			for (int i = 0; i < max; i++) {
				num[i] = i;
			}
			list.add(num[0]);
			num[0]= -1;
			int a = num[0] & list.get(list.size()-1);
			for (int i = 0; i < max; i++) {
				if((num[i] != -1) && (num[0] & list.get(list.size()-1)))
					list.add(num[i]);
			}
			return list;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
