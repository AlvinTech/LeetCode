#include <iostream>
#include <vector>
#include <map>
using namespace std;
class Solution {
public:
	string minWindow3(string S, string T) 
	{
		if ( T.size() == 0 || S.size() == 0 ) return "";
    	map<char,vector<int> > dic;
    	vector<int> tmp;
    	for (int i = 0; i < T.size(); ++i)
    	{
    		char target = T[i];
    		if ( dic.find(target) == dic.end() )
    		{
    			for (int j = 0; j < S.size(); ++j)
    			{
    				if ( S[j] == target )
    				{
    					dic[target].push_back(j);
    					tmp.push_back(j);
    				}
    				
    			}
    		}
    	}
    	if ( dic.size() == T.size() )
    	{
    		sort(tmp.begin(),tmp.end());
    		int start = 0;
    		int end = tmp.size()-1;
    		while ( start <= end )
    		{
    			printf("%d\n", tmp[start] );
    			start++;
    		}
    		return "";
    	}
    	else
    	{
    		return "";
    	}
	}
    string minWindow(string S, string T) 
    {
    	if ( T.size() == 0 || S.size() == 0 ) return "";
    	map<char,vector<int> > dic;
    	for (int i = 0; i < T.size(); ++i)
    	{
    		char target = T[i];
    		if ( dic.find(target) == dic.end() )
    		{
    			for (int j = 0; j < S.size(); ++j)
    			{
    				if ( S[j] == target )
    				{
    					dic[target].push_back(j);
    				}
    				
    			}
    			//printf("%c,%ld\n",target,dic[target].size() );
    		}
    	}
    	//sort(T.begin(),T.end());
    	//printf("%s\n",T.c_str() );
    	//if ( T.size() == 1 && dic.find(T[0]) != dic.end() ) return T;
    	vector<int> parent;
    	pair<int,int> result;
    	int min = INT_MAX;
    	innerMinWindow(T,0,dic,parent,result,&min);
    	
    	//printf("dic:%ld\n",dic.size() );
    	if ( min == INT_MAX ) return "";
    	else return S.substr(result.first,result.second-result.first + 1);    
    	//return S;
    }
    void innerMinWindow(string T
    	,int deep
    	,map<char,vector<int> > &dic
    	,vector<int> &parent
    	,pair<int,int> &result
    	,int *pmin)
    {
    	if ( deep == T.size() )
    	{
    		int min = INT_MAX;
    		int max = INT_MIN;
    		for (int i = 0; i < parent.size(); ++i)
    		{
    			min = min < parent[i] ? min : parent[i];
    			max = max > parent[i] ? max : parent[i];
    		}
    		if ( max - min >= 0 && max - min < *pmin)
    		{
    			*pmin = max - min;
    			result.first = min;
    			result.second = max;
    		}
    	}
    	else
    	{
    		int min = INT_MAX;
    		int max = INT_MIN;
    		//printf("deep:%d,value:%d\n",deep,max-min );
    		for (int i = 0; i < parent.size(); ++i)
    		{
    			min = min < parent[i] ? min : parent[i];
    			max = max > parent[i] ? max : parent[i];
    		}
    		if ( max - min >= *pmin ) return;

    		char target = T[deep];
    		if ( dic[target].size() > 0 )
    		{
    			for (int i = 0; i < dic[target].size(); ++i)
    			{
    				int tmp = dic[target][i];
    				dic[target].erase(dic[target].begin()+i);
    				parent.push_back(tmp);
    				innerMinWindow(T,deep+1,dic,parent,result,pmin);

    				parent.pop_back();
    				dic[target].insert(dic[target].begin()+i,tmp);

    			}
    		}
    	}
    }
};
int main(int argc, char const *argv[])
{
	/* code */
	Solution s;
	string result = s.minWindow("....","acccacbccc");
	printf("result:%s\n", result.c_str());
	return 0;
}