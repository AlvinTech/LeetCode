#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<string> > solveNQueens(int n) 
    {
    	vector<vector<string> > output;
    	if ( n == 0 ) return output;

		//vector<int> rows = vector<int>(n, 0);
    	vector<int> columns = vector<int>(n, 0);
    	vector<int> selected = vector<int>(n, -1);
        vector<int> principal_diagonals = vector<int>(2 * n, 0);
        vector<int> counter_diagonals = vector<int>(2 * n, 0);

        innerNQ(0,n,selected,columns,principal_diagonals,counter_diagonals,output);
        //printf("output size=%ld\n",output.size() );
    	return output;
    }
    void innerNQ(int deep
    	,int n
    	,vector<int> &selected
    	,vector<int> &columns
    	,vector<int> &principal_diagonals
    	,vector<int> &counter_diagonals
    	,vector<vector<string> > &output
    	)
    {
    	if ( deep == n )
    	{
    		vector<string> item;
    		//output.push_back(item);
    		for (int i = 0; i < selected.size(); ++i)
    		{
    			string tmps(n, '.');
    			tmps[selected[i]] = 'Q';
    			//printf("%s\n", tmps.c_str());
    			item.push_back(tmps);
    				
    		}
    		output.push_back(item);
    		
    		
    	}
    	else
    	{
    		for (int i = 0; i < n; ++i)
    		{
    			if ( columns[i] == 0
    			 && principal_diagonals[i+deep] == 0 
    			 && counter_diagonals[n - 1 + i -deep] == 0 
    			 )
    			{
    				columns[i] = 1;
    				principal_diagonals[i+deep] = 1;
    				counter_diagonals[n - 1 + i -deep] = 1;
    				selected[deep] = i;

    				innerNQ(deep+1,n,selected,columns,principal_diagonals,counter_diagonals,output);

    				selected[deep] = -1;
    				columns[i] = 0;
    				principal_diagonals[i+deep] = 0;
    				counter_diagonals[n - 1 + i -deep] = 0;
    			}
    		}
    	}
    }
};

void printVector2(vector<vector<string> > &v)
{
    char buffer[1024*10];
    memset( buffer,0,sizeof(char)*1024*10 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s%s\n",buffer,v[i][j].c_str());
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}


int main(int argc, char const *argv[])
{
	Solution s;
	vector<vector<string> > result = s.solveNQueens(1);
	printVector2(result);
	return 0;
}