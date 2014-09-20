#include <iostream>
#define N 10
class Solution {
public:
    void sortColors(int A[], int n) 
    {
    	if (n == 0) return;
    	int value[3] = {0,0,0};
    	int tmp = -1;
    	for (int i = 0; i < n; ++i)
    	{
    		tmp = A[i];
    		if ( tmp < 3 && tmp >= 0)
    		{
    			value[tmp] = value[tmp] + 1;
    		}
    	}
    	int* p = A;
    	for (int i = 0; i < 3; ++i)
    	{
    		tmp = value[i];
    		for (int j = 0; j < tmp; ++j)
    		{
    			*p = i;
    			p++;
    		}
    	}
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int A[N] = {1,1,1,2,2,2,0,0,0,0};
	s.sortColors(A,N);

	char output[256];
	for (int i = 0; i < N; ++i)
	{
		sprintf(output,"%s,%d",output,A[i]);
	}
	printf("%s\n",output );


	return 0;
}