#include <iostream>
//所有数有3个重复的，除了其中一个只出现一次，找出只出现一次的
class Solution {
public:
    int singleNumber(int A[], int n) 
    {
    	int ones = 0, twos = 0;
	    for(int i = 0; i < n; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;    
    }
};
int main(int argc, char const *argv[])
{
	int A[10] = {1,1,1,2,2,2,3,3,3,5};
	Solution s;
	int result = s.singleNumber(A,10);
	printf("%d\n", result);
	return 0;
}