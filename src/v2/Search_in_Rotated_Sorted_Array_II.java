/** Search in Rotated Sorted Array II
 * Created with IntelliJ IDEA.
 * User: Alvin
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] A, int target) {
        if(target >=A[0]){
            for(int i=0 ; i< A.length;i++){
                if(A[i] == target)
                    return true;
            }
        }else
        {
            for(int i= A.length -1  ; i>=0;i--){
                if(A[i] == target)
                    return true;
            }
        }

        return false;
    }
}
