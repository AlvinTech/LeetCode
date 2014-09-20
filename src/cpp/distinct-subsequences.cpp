#include <iostream>
#include <vector>
#include <map>
using namespace std;
/**

S = "rabbbit", T = "rabbit"
Return 3.

*/
class Solution {
public:
    int numDistinct(string S, string T) 
    {
    	vector<vector<int> > v;
    	vector<map<int,int> > values;
    	int min = -1;
    	int max = 0;
    	for (int i = 0; i < T.size(); ++i)
    	{
    		vector<int> tmp;
    		v.push_back(tmp);

    		map<int,int> tmp2;
    		values.push_back(tmp2);

    		for (int j = min + 1; j < S.size(); ++j)
    		{
    			if( S[j] == T[i] )
    			{ 
    				if ( v[i].size() == 0 ) min = j;
    				v[i].push_back(j);
    				//max = max > j ? max : j;
    			}
    		}
    		if ( v[i].size() == 0 ) return 0;
    	}
    	if (v.size() == 0) return 0;
    	
 
    	//printf("%d\n",*(int*)ptr);

        int result = innerNumDistinct(-1,0,v,values);
        return result;
    }
    int innerNumDistinct(int prev, int deep, vector<vector<int> > &v ,vector<map<int,int> > &values )
    {

    	if ( deep < v.size() )
    	{
    		//values[i].insert(pair<int, int>(1, -1));
    		std::map<int,int>::iterator it;
    		it = values[deep].find(prev+1);
    		int value = it == values[deep].end() ? -1 : values[deep][prev+1];
    		if ( value != -1 )
    		{
    			return value;
    		}
    		else
    		{
    			int sum = 0;
    			for (int i = 0; i < v[deep].size(); ++i)
	    		{
	    			if ( v[deep][i] > prev )
	    			{
    					if ( deep + 1 == v.size()  )
    						return (v[deep].size() - i);
    					else
    					{
    						int tmp = innerNumDistinct(v[deep][i],deep+1,v,values); 
    						sum += tmp;
    					}
	    			}
	    		}
	    		values[deep][prev+1] = sum;
	    		//printf("p[%d]=%d\n", deep,values[deep][prev+1]);
	    		return sum;
    		}
    		
    	}
    	return 0;
    	// else if ( deep == v.size() )
    	// {
    	// 	(*result)++;
    	// }

    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	string S = "rabbbit";
	string T = "rabbit";
	int result = s.numDistinct(S,T);
	printf("%d\n",result );
	return 0;
}