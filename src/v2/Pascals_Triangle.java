/**  Pascal's Triangle
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return
 图有误
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
import java.util.ArrayList;
import java.util.List;
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
}
