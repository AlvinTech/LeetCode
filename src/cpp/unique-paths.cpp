#include <iostream>
class Solution {
public:
    int uniquePaths(int m, int n) {
    	int f[m][n];
    	memset(f,0,sizeof(int) * m * n );
    	int i,j;
    	for ( i = 0; i < m; ++i)
    	{
    		f[i][0] = 1;
    	}
    	for ( i = 0; i < n; ++i)
    	{
    		f[0][i] = 1;
    	}
    	for ( i = 1; i < m; ++i)
    	{
    		for (j = 1; j < n; ++j)
    		{
    			f[i][j] = f[i-1][j] + f[i][j-1];
    		}
    	}
    	return f[m-1][n-1];
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.uniquePaths(3,3 );
	printf("%d\n", result);
    printf("%d\n",3&-3 );
	return 0;
}