#include <iostream>
#include <vector>
using namespace std;

/***
初始化数组dp，数组成员均为1 ，每个孩子先分配一个糖果
从左向右遍历，如果第i个孩子比第i - 1孩子等级高，则dp[i] = dp[i - 1] + 1
从右向左遍历，如果第i个孩子比第i + 1孩子等级高并且糖果比i+1糖果少，则dp[i] = dp[i + 1] + 1
*/
#define max(a,b) a>b ? a:b
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

class Solution {
public:
    int candy(vector<int> &ratings) 
    {
    	if ( ratings.size() == 0 ) return 0;

    	//sort(ratings.begin(),ratings.end());
    	int size = ratings.size();
    	
    	vector<int> tmps(size,1);


    	for (int i = 1; i < size; ++i)
    	{
    		if ( ratings[i] > ratings[i-1] )
    		{
    			 tmps[i] = tmps[i-1] + 1;
    			 //printf("1 tmps[%d]=%d\n", i,tmps[i]);
    		}
    	}
    	//printVector1(tmps);

    	int total = tmps[size-1];

    	for (int i = size-2; i >= 0; --i)
    	{
    		if ( ratings[i] > ratings[i+1] )
    		{
    			 tmps[i] = max(tmps[i+1] + 1,tmps[i]);
    			// printf("2 tmps[%d]=%d\n", i,tmps[i]);
    		}
    		total += tmps[i];
    	}
    	//printVector1(tmps);
    	return total;    
    }
};

void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}


int main(int argc, char const *argv[])
{
	int values1[] = {4,2,3,4,1};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);
	Solution s;
	int min = s.candy(v1);
	printf("min=%d\n", min);
	return 0;
}