#include <iostream>
/***
动态规划思路
12345
5个节点

当1为头节点时
左边无子节点
右边有2345个子节点


*/
class Solution {
public:
    int numTrees(int n) 
    {
    	if ( n == 0 ) return 0;
    	int value[n];
    	memset(&value,0,sizeof(int)*(n+1));
    	
    	value[0] = 1;
    	int left = 0;
    	int right = 0;

    	int max = 1;

   		while( max <= n )
   		{
   			int sum = 0;
   			for ( int i = 0; i < max ; ++i )
	    	{
	    		left = i;
	    		right = max - i - 1;
	    		sum += (value[left] * value[right]);
	    	}
	    	value[max] = sum;
	    	//printf("value[%d]=%d,left=%d,right=%d\n",max,sum ,left,right);
	    	max ++;
   		}
    	return value[n];
        //return value[0];
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.numTrees(3);
	printf("%d\n",result );
	return 0;
}
