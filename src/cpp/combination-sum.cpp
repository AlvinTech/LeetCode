#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) 
    {
        vector<vector<int> > v;
        sort( candidates.begin() , candidates.end() );
        if ( candidates.size() == 0 || target == 0) return v;
        vector<int> prev;

        innerCombinationSum(v,prev,candidates,target);
        return v;
    }
    void innerCombinationSum(vector<vector<int> > &v,vector<int> &prev,vector<int> &candidates,int target)
    {
    	int prevValue = candidates[0];
    	if ( prev.size() > 0 )
    	{
    		prevValue = prev[prev.size() - 1];
    	}
    	
    	for (int i = 0; i < candidates.size(); ++i)
    	{
    		int value =  target - candidates[i];
    		if (   prevValue > candidates[i] )
    		{
    			continue;
    		}
    		if ( value < 0 )
    		{
    			return;
    		}
    		else if( value == 0 )
    		{
    			vector<int> tmp = prev;
    			tmp.push_back(candidates[i]);
    			v.push_back(tmp);
    		}
    		else
    		{
    			vector<int> tmp = prev;
    			tmp.push_back(candidates[i]);
    			innerCombinationSum(v,tmp,candidates,value);
    		}
    	}
    }
};

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
	int int_array[] = {8 ,7, 4, 3};  

	Solution s;
	vector<int> candidates(int_array,int_array+4);

	vector<vector<int> > result = s.combinationSum(candidates,11);
	printVector2(result);
	return 0;
}