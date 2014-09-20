#include <iostream>
#include <vector>
using namespace std;
/****
2次二分查找实现
*/
class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) 
    {
    	if ( matrix.size() == 0 ) return false;
    	int row = search(matrix,target);
    	return searchSub(matrix[row],target);    
    }
    bool searchSub( vector<int> &arr, int target )
    {
    	int min = 0;
    	int max = arr.size() - 1;
    	int mid = min;
    	if ( target > arr[max] ) return false;
    	if ( target < arr[min] ) return false;
    	if ( target == arr[min] ) return true;
    	while( min < max )
    	{
    		mid = ((max - min + 1 )>>1) + min;
    		//printf("max=%d,min=%d,mid=%d\n",max,min,mid );
    		if ( arr[mid] < target )
    		{
    			if ( min != mid ) min = mid;
    			else break;
    		}
    		else if( arr[mid] > target )
    		{
    			if ( max != mid ) max = mid;
    			else break;
    		}
    		else
    		{
    			return true;
    		}
    	}
    	return false;
    }
    int search(vector<vector<int> > &matrix, int target)
    {
    	int min = 0;
    	int max = matrix.size() - 1;
    	int mid = min;
    	while( min < max )
    	{
    		mid = ((max - min + 1 )>>1) + min;
    		//printf("max=%d,min=%d,mid=%d\n",max,min,mid );
    		if ( matrix[mid][0] < target )
    		{
    			if ( min != mid ) min = mid;
    			else break;
    		}
    		else if( matrix[mid][0] > target )
    		{
    			if ( max != mid ) max = mid;
    			else break;
    		}
    		else
    		{
    			return mid;
    		}
    	}
    	return min;
    }
};
void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}

void printVector2(vector<vector<int> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%d",buffer,v[i][j]);
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}

int main(int argc, char const *argv[])
{
	int values1[] = {1,3,5,7};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);

	int values2[] = {10,11,16,20};
	vector<int> v2;
	arr2vector(values2,sizeof(values2)/sizeof(int),v2);

	int values3[] = {23,30,34,50};
	vector<int> v3;
	arr2vector(values3,sizeof(values3)/sizeof(int),v3);

	vector<vector<int> > matrix;
	matrix.push_back(v1);
	matrix.push_back(v2);
	matrix.push_back(v3);

	Solution s;
	bool result = s.searchMatrix(matrix,3);
	printf("%s\n",result == true ? "true" : "false" );
	/* code */
	return 0;
}