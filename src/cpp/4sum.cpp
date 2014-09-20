#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) 
    {
        
    }
    int sum3( vector<int> &num, int target )
    {
    	for (int i = 0; i < num.size()-2; ++i)
    	{
    		int start = i+1;
    		int end = num.size()-1;
    		int value1 = num[i];
    		int sum = 0;
    		while( start < end )
    		{
    			sum = value1 + num[start] + num[end];
    			if ( sum < target )
    			{
    				start++;
    			}
    			else if( sum > target )
    			{
    				end--;
    			}
    			else
    			{
    				return target;
    			}
    		}
    	}
    	return INT_MAX;
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
	int values1[] = {-1,2,1,-4};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);
	Solution s;
	int result = s.fourSum(v1,1);
	printf("%d\n",result );
	return 0;
}