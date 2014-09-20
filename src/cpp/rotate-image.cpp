#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    void rotate(vector<vector<int> > &matrix) 
    {
        int n = matrix.size();
        if ( n < 2 ) return;
        int start = 0;
        int end = n-1;
        while( start < end )
        {
            for (int i = start; i < end; ++i)
            {
                //int ii = i-start;
                //printf("%d,start=%d,end=%d\n",i,start,end);
                int tmp = matrix[start][i];
                matrix[start][i] =  matrix[end-i+start][start];

                matrix[end-i+start][start] = matrix[end][end-i+start];

                matrix[end][end-i+start] = matrix[i][end];

                matrix[i][end] = tmp;

                //printf("[%d][%d]->[%d][%d]->[%d][%d]->[%d][%d],\n", start,i,end-i+start,start,end,end-i+start,i,end);
            }
            //printf("\n");
            start++;
            end--;
            
        }
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
	int values1[] = {1,2,3,4,5};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);

	int values2[] = {16,17,18,19,6};
	vector<int> v2;
	arr2vector(values2,sizeof(values2)/sizeof(int),v2);

	int values3[] = {15,24,25,20,7};
	vector<int> v3;
	arr2vector(values3,sizeof(values3)/sizeof(int),v3);

    int values4[] = {14,23,22,21,8};
    vector<int> v4;
    arr2vector(values4,sizeof(values4)/sizeof(int),v4);

    int values5[] = {13,12,11,10,9};
    vector<int> v5;
    arr2vector(values5,sizeof(values5)/sizeof(int),v5);

	vector<vector<int> > matrix;
	matrix.push_back(v1);
	matrix.push_back(v2);
	matrix.push_back(v3);
    matrix.push_back(v4);
    matrix.push_back(v5);

	Solution s;
    printVector2(matrix);
    s.rotate(matrix);
    printVector2(matrix);
	/* code */
	return 0;
}