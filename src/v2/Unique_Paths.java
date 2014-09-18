/** Unique Paths
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午3:05
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 3 x 7 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.


 */
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        return (int)unique(m-1,n-1);

    }
    public double unique(int m, int n) {
        if(m == 0 || n ==0){
            return 1;
        }else
            return (m+n)*(m+n-1)*1.0*unique(m-1,n-1)/m/n ;

    }
}
