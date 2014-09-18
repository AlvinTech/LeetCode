package v1;
import java.util.ArrayList;
import java.util.List;

/**
 * 2014-5-29
 * @author Alvin
 * 
 */
import java.util.*;
public class Pascals_Triangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> array = new ArrayList<List<Integer>>();
		if (numRows > 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			array.add(list);
			for (int i = 0; i < numRows - 1; i++) {
				array.add(Triangle(array.get(i)));
			}
		}
		return array;
	}
    public List<Integer> Triangle(List<Integer> list){
		List<Integer> array =  new ArrayList<Integer>();
		array.add(1);
		for(int i=0;i< list.size()-1;i++){
			array.add(list.get(i)+ list.get(i+1));
		}
		array.add(1);
		return array;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
