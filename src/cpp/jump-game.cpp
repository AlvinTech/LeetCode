#include <iostream>
//https://oj.leetcode.com/problems/jump-game/
class Solution {
public:
    bool canJump(int A[], int n) 
    {
    	if (n == 0) return false;
    	int result = jump(A,0,n);
    	printf("start=%d,return=%d\n",0 ,result);
    	if( result >= n -1 ) return true;
    	else return false;
    	
    }
    int jump(int A[],int start,int n)
    {
    	
    	int tmp = 0;
    	int max = A[start];
    	for (int i = start; i <= max; ++i)
    	{
    		tmp = i + A[i];
    		max = max > tmp ? max : tmp;
    		if( max >= n ) return max; 
    	}
    	return max; 
    }
};

int checkCPU( )
{
    union w
    {
    int a;
    char b;
    } c;
    c.a = 1;
    return(c.b ==1);
}

int main(int argc, char const *argv[])
{
	Solution s;
	int A[5] = {1,2};
	int B[1] = {0};
	bool value1 = s.canJump(A,2);
	printf("result:%d\n\n",checkCPU() );

    int i=1; 
    char *p=(char *)&i; 
    if(*p==1) 
    printf("Little Endian"); 
    else
    printf("Big Endian");

	//bool value2 = s.canJump(B,1);
	//printf("result:%d\n\n",value2 );
	return 0;
}

