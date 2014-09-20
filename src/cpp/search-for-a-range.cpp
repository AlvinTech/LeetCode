#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> searchRange(int A[], int n, int target)
    {
        std::vector<int> v;
        v.push_back(-1);
        v.push_back(-1);
    	if ( n == 0 ) return v;

    	int min = 0;
    	int max = n-1;
    	int result = 0;
    	int mid = 0;
    	if ( target < A[0] ) return v;
    	if ( target > A[n-1] ) return v;

    	while( max - min > 1 )
    	{
    		mid = ((max - min )>>1) + min ;
    		if ( A[mid] >= target )
    		{
    			max = mid;
    		}
    		else
    		{
    			min = mid;
    		}//1,1,4
    		//2,2,4
    		//printf("%d,%d,%d\n", min,mid,max);
    	}
        
        while( A[min] != target && min <= max )
        {
            min++;
        }
        v[0] = min;
        if( A[min] != target )
        {
            v[0] = -1;
            v[1] = -1;
            return v;
        }
        while( A[min+1] == target && min +1 < n )
        {
            min++;
        }
        v[1] = min;
       
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int values[] = {5,7,9,9,10};
	std::vector<int> v = s.searchRange(values,sizeof(values)/sizeof(int), 8 );
	printf("%d,%d\n",v[0],v[1] );
	return 0;
}