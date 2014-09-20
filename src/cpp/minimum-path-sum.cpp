#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) 
    {
    	if ( grid.size() == 0 ) return 0;
    	if ( grid.size() == 1 && grid[0].size() == 1) return grid[0][0];
    	int height = grid.size();
    	int width = grid[0].size();
    	int x = width - 1;
    	int y = height - 1;
    	int min = x < y ? x : y;
    	int tmpa = INT_MAX;
    	int tmpb = INT_MAX;
    	int tmpMin = INT_MAX;
    	int startValue = grid[0][0];
    	while( min >= 0 )
    	{
    		for (int i = x; i >= 0 ; i-- )
    		{
    			if( i + 1 >= width ) tmpa = INT_MAX;
    			else tmpa = grid[y][i+1];
    			if( y + 1 >= height ) tmpb = INT_MAX; 
    			else tmpb = grid[y+1][i];
    			tmpMin = tmpa < tmpb ? tmpa : tmpb;
    			
    			if ( tmpMin == INT_MAX ) continue;
    			else
    			{
    				if( i==0 && y== 0) grid[y][i] = tmpMin;
    				else grid[y][i] = grid[y][i] + tmpMin;

    				//printf("x change [%d][%d]=%d,%d,%d,min=%d\n", y,i,grid[y][i] ,tmpa,tmpb,tmpMin);
    			} 

    		}
    		for (int i = y-1; i >= 0 ; i-- )
    		{
    			if( x + 1 >= width ) tmpa = INT_MAX;
    			else tmpa = grid[i][x+1];
    			if( i + 1 >= height ) tmpb = INT_MAX; 
    			else tmpb = grid[i+1][x];
    			
    			tmpMin = tmpa < tmpb ? tmpa : tmpb;
    			
    			if ( tmpMin == INT_MAX ) continue;
    			else 
    			{
    				if( i==0 && x== 0) grid[i][x] = tmpMin;
    				else grid[i][x] = grid[i][x] + tmpMin;
    				//printf("y change [%d][%d]=%d,%d,%d,min=%d\n" ,i,x,grid[i][x],tmpa,tmpb,tmpMin );
    			}
    		}
    		x--;
    		y--;
    		min--;
    	}
    	return grid[0][0] + startValue;    
    }
};


void printVector1(vector<int> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%d",buffer,v[i]);
	}
	printf("%s\n",buffer );
}

void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}

void printVector2(vector<vector<int> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%d",buffer,v[i][j]);
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}



int main(int argc, char const *argv[])
{
	int values1[] = {1,2};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);

	int values2[] = {5,6};
	vector<int> v2;
	arr2vector(values2,sizeof(values2)/sizeof(int),v2);

	int values3[] = {1,1};
	vector<int> v3;
	arr2vector(values3,sizeof(values3)/sizeof(int),v3);

	int values4[] = {0,2,5,2,1,2};
	vector<int> v4;
	arr2vector(values4,sizeof(values4)/sizeof(int),v4);

	Solution s;
	vector<vector<int> > grid;
	grid.push_back(v1);
	grid.push_back(v2);
	grid.push_back(v3);
	//grid.push_back(v4);

	printVector2(grid);

	int result = s.minPathSum(grid);

	printVector2(grid);

	
	printf("%d\n",result );
	return 0;
}