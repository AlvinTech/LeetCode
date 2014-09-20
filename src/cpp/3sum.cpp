#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) 
    {
        vector<vector<int> > v;
        if ( num.size() < 3 ) return v;

        sort(num.begin(),num.end());
        //v.push_back(num);

        vector<int> left;
        vector<int> right;
        int findZero = 0;
        for (int i = 0; i < num.size(); ++i)
        {
            if( num[i] < 0 ) left.push_back(num[i]);
            else if( num[i] > 0) right.push_back(num[i]);
            else findZero++;
        }
        if ( findZero > 2 )
        {
            std::vector<int> tmp;
            v.push_back(tmp);
            v[v.size() -1].push_back(0);
            v[v.size() -1].push_back(0);
            v[v.size() -1].push_back(0);
        }
        if ( left.size() == 0 || right.size() == 0 ) return v;
        

        int prev = 1;
        for (int i = 0; i < left.size(); ++i)
        {
            if( left[i] != prev )
            {
                The2Sum(right,-left[i],v,left[i]);
                prev = left[i];
            }
        }
        prev = -1;
        for (int i = 0; i < right.size(); ++i)
        {
            if( right[i] != prev )
            {
                The2Sum(left,-right[i],v,right[i]);
                prev = right[i];
            }
        }

        if ( findZero > 0 )
        {
            right.insert(right.begin(),left.begin(),left.end());
            //v.push_back(left);
            The2Sum(right,0,v,0);
        }

        return v;
    }
    void The2Sum(vector<int> &num , int sum,vector<vector<int> > &output, int userdata)
    {
    	vector<vector<int> > v;
    	int start = 0;
    	int end = num.size() - 1;
    	while( start < end )
    	{
    		if ( num[start] + num[end] < sum ) start++;
    		else if( num[start] + num[end] > sum ) end--;
    		else
    		{
    			vector<int> tmp;
    			output.push_back(tmp);
                if ( userdata == 0 )
                {
                    output[output.size()-1].push_back(num[start]);
                    output[output.size()-1].push_back(userdata);
                    output[output.size()-1].push_back(num[end]);
                }
                else if( userdata > 0 )
                {
                    output[output.size()-1].push_back(num[start]);
                    output[output.size()-1].push_back(num[end]);
                    output[output.size()-1].push_back(userdata);
                }
                else
                {
                    output[output.size()-1].push_back(userdata);
                    output[output.size()-1].push_back(num[start]);
                    output[output.size()-1].push_back(num[end]);
                    
                }
    			
    			int prev = num[start];
    			start++;
    			//printf("prev=%d,num[start]=%d\n",prev ,num[start] );
    			while( prev == num[start] && start < num.size() )
    				start++;
    				//printf("start=%d,value=%d\n",start,num[start] );
    		}
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
	Solution s;
   // int values[] = {-1,0,0,0,1};
	int values[] = {-1,0,1};
	//int values[] = {-1,-1,-1,-1,-1,1,2,3,4};
	vector<int> v;
	arr2vector(values,sizeof(values)/sizeof(int),v);

	vector<vector<int> > result = s.threeSum(v);
	printVector2(result);

	return 0;
}