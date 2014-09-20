#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > combine(int n, int k) 
    {
        vector<vector<int> > v;
        vector<int> solution;
        innerCombine(0,n,1,k,solution,v);
        return v;
    }
    void innerCombine(int min,int max,int deep, int k, vector<int> solution, vector<vector<int> > &result )
    {
    	for (int i = min + 1; i <= max; ++i)
    	{
    		vector<int> tmp = solution;
    		tmp.push_back(i);
    		if ( deep == k ) result.push_back(tmp);
    		else if( deep < k ) innerCombine(i,max,deep+1,k,tmp,result);
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
	Solution s;
	vector<vector<int> > result = s.combine(4,2);
	printVector2(result);
	return 0;
}