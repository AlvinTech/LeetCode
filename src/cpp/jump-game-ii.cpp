#include <iostream>
//https://oj.leetcode.com/problems/jump-game/
class Solution {
public:
    int jump(int A[], int n) 
    {
    	if (n <= 1) return 0;
        int tmp = 0;
        int max = A[0];
        int jump = 1;
        int prevMax = max;
        for (int i = 0; i <= max; ++i)
        {
            tmp = i + A[i];
            if ( max < tmp )
            {
                max = tmp;
            }

            if ( i >= prevMax )
            {
                prevMax = max;
                jump++;
            }
            
            if( max >= n-1 )
            {
                if ( prevMax != max ) jump++;
                break;
            }
            
        }
        return max >= n -1 ? jump : 0; 
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int A[15] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
	int B[5] = {2,3,1,1,4};
	int value1 = s.jump(A,15);
	printf("result1:%d\n\n",value1 );
	
    int value2 = s.jump(B,5);
	printf("result2:%d\n\n",value2 );
	return 0;
}