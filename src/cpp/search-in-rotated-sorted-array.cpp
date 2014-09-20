#include <iostream>

class Solution {
public:
    int search(int A[], int n, int target) 
    {
    	if ( n == 0 ) return -1;
    	int startValue = A[0];
    	int endValue = A[n-1];
    	int prev = 0;
    	if ( target > startValue )
    	{
    		//顺着来
    		for (int i = 0; i < n; ++i)
    		{
    			if ( i != 0 && prev > A[i] )
    				return -1;
    			if ( target == A[i] ) return i;
    			else if( target < A[i] ) return -1;
    			prev = A[i];
    		}
    	}
    	else if( target < endValue )
    	{
    		//倒着来
    		for (int i = n-1; i >= 0; --i)
    		{
    			if ( i != n-1 && prev < A[i] )
    				return -1;
    			if ( target == A[i] ) return i;
    			else if( target > A[i] ) return -1;
    			prev = A[i];
    		}
    	}
    	else if ( startValue == target ) return 0;
    	else if ( endValue == target ) return n-1;
    	else return -1;
    	return -1;
    }
};

int main(int argc, char const *argv[])
{
	
	int A[] = {4,5,6,7,0,1,2};
	Solution s;
	int result = s.search(A,sizeof(A)/sizeof(int),3);
	printf("%d\n",result );
	return 0;
}