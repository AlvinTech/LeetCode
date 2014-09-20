#include <iostream>
class Solution {
public:
    int searchInsert(int A[], int n, int target) 
    {
    	if ( n == 0 ) return 0;

    	int min = 0;
    	int max = n-1;
    	int result = 0;
    	int mid = 0;
    	if ( target < A[0] ) return 0;
    	if ( target > A[n-1] ) return n;

    	while( max - min > 1 )
    	{
    		mid = ((max - min + 1)>>1) + min ;
    		if ( A[mid] > target )
    		{
    			max = mid;
    		}
    		else if( A[mid] == target )
    		{
    			return mid;
    		}
    		else
    		{
    			min = mid;
    		}//1,1,4
    		//2,2,4
    		//printf("%d,%d,%d\n", min,mid,max);
    	}
    	//printf("%d,%d,%d\n", min,mid,max);
    	if ( A[min] == target ) return min;
    	else return max;
       
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int values[] = {2,7,8,9,10};
	int result = s.searchInsert(values,sizeof(values)/sizeof(int), 9);
	printf("%d\n",result );
	return 0;
}