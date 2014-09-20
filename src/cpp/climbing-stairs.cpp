#include <iostream>

class Solution {
public:
	int climbStairs(int n) 
    {
    	if ( n == 0 ) return 0;
    	else if( n == 1 ) return 1;
    	else if( n == 2 ) return 2;
    	int tmp[n];
    	tmp[0] = 1;
    	tmp[1] = 2;
    	int sum = 0;
    	for (int i = 2; i < n; ++i)
    	{
    		tmp[i] = tmp[i-1] + tmp[i-2];
    	}
    	return tmp[n-1];
    }
    int climbStairs2(int n) 
    {
    	if ( n <= 0 )
	    {
	    	return 0;
	    }
	    else if( n == 1 )
	    {
	    	return 1;
	    }
	    else if( n == 2 )
	    {
	    	return 2;
	    }
	    else
	    {
	    	return climbStairs(n-1) + climbStairs(n-2);
	    }
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.climbStairs(44);
	//1,1,1,1
	//1,1,2
	//1,2,1
	//2,1,1
	//2,2
	//1134903170
	printf("%d\n",result );
	return 0;
}