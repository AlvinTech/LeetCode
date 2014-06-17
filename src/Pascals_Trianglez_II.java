/**
 * 2014-5-29
 * @author Alvin
 * 
 */
import java.util.*;
public class Pascals_Trianglez_II {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> array =  new ArrayList<Integer>();
		if(rowIndex == 0){
			array.add(1);
		}else{
			for(int i=0;i < rowIndex;i++)
				array = Triangle(array);
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
		System.out.println(Arrays.toString(new Pascals_Trianglez_II().getRow(12).toArray()));
	}

}
