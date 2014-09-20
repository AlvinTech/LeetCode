#include <iostream>
class Solution {
public:
    int removeDuplicates(int A[], int n) 
    {
    	if (n == 0) return 0;
    	int currentFlag = 0;
    	int lastValue = A[0];
        int count = 0;
    	for (int i = 1; i < n; ++i)
    	{
    		if ( A[i] == lastValue )
    		{
                if ( count < 1 )
                {
                    count++;
                    currentFlag++;
                    A[currentFlag] = lastValue;
                }
                else
                {

                    continue;
                }
    		}
    		else
    		{
                printf("A[%d]=%d\n",i,A[i] );
                count = 0;
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
	int A[] = {1,1,1};
	int len = s.removeDuplicates(A,sizeof(A)/sizeof(int));
	char output[256];
	for (int i = 0; i < len; ++i)
	{
		//printf("%s,%d\n", A[i]);
		sprintf(output,"%s,%d",output,A[i]);
	}
	printf("%s\n",output );
	return 0;
}