/**    Pascal's Triangle II
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
import java.util.ArrayList;
import java.util.List;
public class Pascals_Triangle_II {
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
}
