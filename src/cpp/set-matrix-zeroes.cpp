#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) 
    {
    	if ( matrix.size() == 0 ) return;
        vector<int> xs;
        vector<int> ys;
        for (int i = 0; i < matrix.size(); ++i)
        {
        	for (int j = 0; j < matrix[i].size(); ++j)
        	{
        		if ( matrix[i][j] == 0 )
        		{
        			ys.push_back(i);
        			xs.push_back(j);
        		}
        	}
        }
        for (int i = 0; i < xs.size(); ++i)
        {
        	int x = xs[i];
        	int y = ys[i];
        	for (int j = 0; j < matrix[y].size(); ++j)
        	{
        		matrix[y][j] = 0;
        	}
        	for (int j = 0; j < matrix.size(); ++j)
        	{
        		matrix[j][x] = 0;
        	}

        }
    }
};


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
	int values1[] = {1,3,5,7};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);

	int values2[] = {10,0,16,20};
	vector<int> v2;
	arr2vector(values2,sizeof(values2)/sizeof(int),v2);

	int values3[] = {23,30,0,50};
	vector<int> v3;
	arr2vector(values3,sizeof(values3)/sizeof(int),v3);

	vector<vector<int> > matrix;
	matrix.push_back(v1);
	matrix.push_back(v2);
	matrix.push_back(v3);
	printVector2(matrix);
	Solution s;
	s.setZeroes(matrix);
	printVector2(matrix);
	//printf("%s\n",result == true ? "true" : "false" );
	/* code */
	return 0;
}