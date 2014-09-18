/*解题思路 DP
Unique Paths II
是Unique Paths 问题的改版。如果某个位置为1，这表示这条路不能通过
所以从起点到该位置的路径条数为0 。其余还是和Unique Paths一样。
*/
class Unique_Paths_II{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null  || obstacleGrid.length == 0)
            return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int [][] array = new int[rows][cols];
        if(obstacleGrid[0][0] !=0)
            array[0][0] = 1;
        else
            return 0;
        //init
        for(int i=1 ;i < rows;i++){
            if(obstacleGrid[i][0] != 1)
                array[i][0] = array[i-1][0];
        }
        for(int i=1; i < cols; i++){
            if(obstacleGrid[0][i] != 1)
                array[0][i] = array[0][i-1];
        }


        for(int i= 1; i < rows; i++){
            for(int j =1; j < cols; j++){
                if(obstacleGrid[i][j] != 1)
                    array[i][j] = array[i-1][j] + array[i][j-1];
                else
                    array[i][j] = 0;
            }
        }

        return array[rows-1][cols-1];

    }
    public static void main(String[] args){
        int[][] board = {{0,0,0},{0,1,0},{0,0,0}};
        int a = new Unique_Paths_II().uniquePathsWithObstacles(board);
        System.out.println(a);
    }
}