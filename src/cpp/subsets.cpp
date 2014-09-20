#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) 
    {
    	sort(S.begin(), S.end());
        vector<vector<int> > result;
        vector<int> parent;
        innerSubset(S,parent,result,0);
        return result;
    }
    void innerSubset(vector<int> &S, vector<int> &parent,  vector<vector<int> > &output, int deep )
    {
    	if ( deep == S.size() )
    	{
    		output.push_back(parent);
    	}
    	else
    	{
    		//不选
    		innerSubset(S,parent,output,deep+1);
    		//选
    		int tmp = S[deep];
    		parent.push_back(tmp);
    		innerSubset(S,parent,output,deep+1);
    		parent.pop_back();
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
	int values1[] = {1,2,3};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);
	Solution s;
	vector<vector<int> > result = s.subsets(v1);
	printVector2(result);
	return 0;
}