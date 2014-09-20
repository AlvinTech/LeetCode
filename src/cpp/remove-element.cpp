#include <iostream>
class Solution {
public:
    int removeElement(int A[], int n, int elem) 
    {
    	int index = 0;
    	int len = n;
    	while( index != len )
    	{
    		if ( A[index] == elem )
    		{
    			len--;
    			A[index] = A[len];
    		}
    		else
    		{
    			index++;
    		}
    	}
        return len;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int A[1] = {0};
	int len = s.removeElement(A,1,1);
	printf("%d\n", len);
	return 0;
}