#include <iostream>
#include <map>
#include <stack>
using namespace std;
class Solution {
public:
    bool isValid(string s) 
    {
    	map<char,char> dic;
    	dic['['] = ']';
    	dic['{'] = '}';
    	dic['('] = ')';

    	map<char,char> dic2;
    	stack<char> myStack;

    	for (int i = 0; i < s.size(); ++i)
    	{
    		if ( s[i] == '[' || s[i] == '{' || s[i] == '(')
    		{
    			myStack.push( dic[s[i]] );
    		}
    		else if(   s[i] == ']' || s[i] == '}' || s[i] == ')' )
    		{
    			if ( myStack.size() == 0) return false;
    			char target = myStack.top();
    			myStack.pop();
    			if ( s[i] != target )
    			{
    				return false;
    			}
    		}
    	}

    	if ( myStack.size() != 0) return false;
    	else return true;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	bool result = s.isValid(")");
	printf("%s\n",result ? "true" : "false" );
	return 0;
}