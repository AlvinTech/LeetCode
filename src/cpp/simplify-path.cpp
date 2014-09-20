#include <iostream>
#include <vector>
using namespace std;



class Solution {
public:
    string simplifyPath(string path) 
    {
    	vector<string> v;
    	path += '/';

    	int size = path.size();
    	int start = 0;
    	//string s = NULL;
    	int prev = -1;
    	while( start < size )
    	{
    		if ( path[start] == '/' )
    		{
    			if ( prev != -1 )
    			{
    				//printf("%d,%d\n",prev,start-prev );
    				int len = start-prev-1;
    				if ( len > 0 )
    				{
    					string tmp = path.substr(prev+1,len);
    					if ( tmp == "..")
    					{
    						if ( !v.empty() ) v.pop_back();
    					}
    					else
    					{
    						if ( tmp != "." )
    						{
    							v.push_back(tmp);
    						}
    						
    					}
    					//printf("%s\n",tmp.c_str() );
    				}
    				
    			}
    			prev = start;
    		}
    		start++;

    	}
    	string result;
    	for (int i = 0; i < v.size(); ++i)
    		result += '/' + v[i];
    	//printf("%ld\n",v.size() );
    	//printVector1(v);
    	if ( result.size() == 0 ) result = "/";
    	return result;    
    }
};



int main(int argc, char const *argv[])
{
	Solution s;
	string result = s.simplifyPath("");
	printf("%s\n", result.c_str());
	return 0;
}