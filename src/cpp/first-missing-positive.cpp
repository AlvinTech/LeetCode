#include <iostream>
class Solution {
public:
    int firstMissingPositive(int A[], int n) 
    {
    	for (int i = 0; i < n; ++i)
    	{
    		if ( A[i] < 0 ) return i;
    	}
        return n;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int values[] = {2,7,-1,9,10};
	int result = s.firstMissingPositive(values,sizeof(values)/sizeof(int));
	printf("%d\n",result );
	return 0;
}