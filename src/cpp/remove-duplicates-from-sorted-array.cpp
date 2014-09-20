#include <iostream>
#define COUNT 1
class Solution {
public:
    int removeDuplicates(int A[], int n) 
    {
    	if (n == 0) return 0;
    	int currentFlag = 0;
    	int lastValue = A[0];
    	for (int i = 1; i < n; ++i)
    	{
    		if ( A[i] == lastValue )
    		{
    			continue;
    		}
    		else
    		{
    			currentFlag++;
    			lastValue = A[currentFlag] = A[i];
    		}
    	}
        return currentFlag + 1;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int A[COUNT] = {1};
	int len = s.removeDuplicates(A,COUNT);
	char output[256];
	for (int i = 0; i < len; ++i)
	{
		//printf("%s,%d\n", A[i]);
		sprintf(output,"%s,%d",output,A[i]);
	}
	printf("%s\n",output );
	return 0;
}