#include <iostream>
#include <stack> 

using namespace std;
class Solution {
public:
    void reverseWords(string &s) 
    {
    	stack<char> mstack;
    	string result;
    	for ( string::reverse_iterator i = s.rbegin(); i != s.rend(); ++i)
    	{
    		if ( *i != ' ' )
    		{
    			mstack.push(*i);
    		}
    		else
    		{
    			bool changed = false;
    			while( !mstack.empty() )
    			{
    				result.push_back(  mstack.top() );
    				mstack.pop();
    				changed = true;
    			}
    			if ( changed ) result.push_back(' ');
    		}

    	}
    	//printf("size=========%ld\n",mstack.size() );
		while( !mstack.empty() )
		{
			result.push_back(  mstack.top() );
			mstack.pop();
		}
		//while( s.)
    	s = result; 
        for ( string::reverse_iterator i = s.rbegin(); i != s.rend(); ++i)
        {
        	if ( *i == ' ' ) s.erase(s.end() - 1);
        	else break;
        }
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	string str = "   a   b ";
	s.reverseWords(str);
	printf("result=%s|\n", str.c_str() );
	return 0;
}