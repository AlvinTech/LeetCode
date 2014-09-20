#include <iostream>
#define max(a,b) a>b?a:b
class Solution {
public:
    int maxSubArray(int A[], int n) 
    {
    	int result = INT_MIN;
    	int prev = 0;
    	for (int i = 0; i < n; ++i)
    	{
    		prev = max(prev + A[i],A[i]);
    		result = max( prev,result );
    	}
    	return result; 
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int A[] = {-2,1,-3,4,-1,2,1,-5,4};
	int result = s.maxSubArray(A,sizeof(A)/sizeof(int));
	printf("%d\n",result );
	return 0;
}
