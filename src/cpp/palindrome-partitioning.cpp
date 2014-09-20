#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<string> > partition(string s) 
    {
        vector<vector<string> > output;
        vector<string> parent;
        innerPartition(s,output,parent);
        return output;
    }
    void innerPartition(string s, vector<vector<string> > &output, vector<string> parent)
    {
    	int size = s.size();
    	if ( size == 0 )
    	{
    		return;
    	}
    	int start = 0;
    	while( start < size )
    	{
    		string current = s.substr(0,start+1);
    		
    		if ( isPalindrome(current) )
    		{
    			vector<string> tmp = parent;

    			tmp.push_back(current);
    			string sub = s.substr(start+1);
    			if ( sub.size() == 0 )
    			{
    				output.push_back(tmp);
    			}
    			else
    			{
    				innerPartition(sub,output,tmp);
    			}

    			//printf("%s,%s\n",current.c_str(),sub.c_str());
    			
    		}
    		//return;
    		start++;
    		
    	}

    }
    bool isPalindrome(string s)
    {
    	int begin = 0;
    	int end = s.size() - 1;
    	while( begin < end ) 
    		if ( s[begin++] != s[end--] ) return false;
    	return true;
    }
};
void printVector2(vector<vector<string> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%s",buffer,v[i][j].c_str());
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}


int main(int argc, char const *argv[])
{
	string input = "txtaab";
	Solution s;
	vector<vector<string> > result = s.partition(input);
	printVector2( result );
	return 0;
}