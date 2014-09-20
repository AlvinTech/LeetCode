#include <iostream>
#include <vector>
using namespace std;
#define min(a,b) a<b?a:b
class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) 
    {
    	int max = triangle.size();
    	if ( max == 0 ) return 0;
    	if ( max == 1 ) return triangle[0][0];
    	int i = max-2;
    	while( i >= 0 )
    	{
    		for (int j = 0; j < triangle[i].size(); ++j)
    		{
    			triangle[i][j] += min(triangle[i+1][j],triangle[i+1][j+1]);
    		}
    		i--;
    	}
    	return triangle[0][0];    
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
	int values1[] = {2};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);

	int values2[] = {3,4};
	vector<int> v2;
	arr2vector(values2,sizeof(values2)/sizeof(int),v2);

	int values3[] = {6,5,7};
	vector<int> v3;
	arr2vector(values3,sizeof(values3)/sizeof(int),v3);

	int values4[] = {4,1,8,3};
	vector<int> v4;
	arr2vector(values4,sizeof(values4)/sizeof(int),v4);

	Solution s;
	vector<vector<int> > input;
	input.push_back(v1);
	//input.push_back(v2);
	//input.push_back(v3);
	//input.push_back(v4);

	int result = s.minimumTotal(input);
	printf("%d\n",result );
	return 0;
}


