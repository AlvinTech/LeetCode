#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) 
    {
        vector<string> v;
        return v;
    }
    void innerGenerate(int n, int deep, string &s, vector<string> &output)
    {
    	if ( deep == n )
    	{
    		output.push_back(s);
    		return;
    	}
    	else
    	{
    		//直接()
    		s += "()";
    		innerGenerate(n,deep+1,s,output);
    		s.erase(s.end()-2,s.end());

    		s += "(";
    		innerGenerate(n,deep+1,s,output);
    		s += ")";
    	}
    }
};

void printVector1(vector<string> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%s",buffer,v[i].c_str());
	}
	printf("%s\n",buffer );
}


int main(int argc, char const *argv[])
{
	Solution s;
	vector<string> result = s.generateParenthesis(4);
	printVector1(result);
	return 0;
}