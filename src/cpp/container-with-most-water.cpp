#include <iostream>
#include <vector>
using namespace std;
#define min(a,b) a<b?a:b
class Solution {
public:
    int maxArea(vector<int> &height) 
    {
    	int start = 0;
    	int end = height.size() - 1;
    	int max = 0;
    	while( start < end )
    	{
    		int minHeight = min(height[start],height[end]);
    		int tmp = minHeight * (end-start);
    		max = max > tmp ? max : tmp;
    		if ( height[start] > height[end] ) end--;
    		else start++;
    	}
        return max;
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

int main(int argc, char const *argv[])
{
	int values1[] = {1,2,8,2,1,4,1};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);
	Solution s;
	int result = s.maxArea(v1);
	printf("result=%d\n", result);

	return 0;
}