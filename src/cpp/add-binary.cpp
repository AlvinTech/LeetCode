#include <iostream>
#include <stack>
using namespace std;
class Solution {
public:
    string addBinary(string a, string b) 
    {
    	//printf("%s,%s,%ld,%ld\n",a.c_str(),b.c_str(),a.size(),b.size() );
        string s;
        stack<char> stack;
        int sizea = a.size()-1;
        int sizeb = b.size()-1;
        int prev = 0;
        while( sizea >= 0 && sizeb >= 0 )
        {
        	int tmp = prev;
        	char ca = a[sizea];
        	char cb = b[sizeb];
        	if ( ca == '1' ) tmp++;
        	if ( cb == '1' ) tmp++;
        	stack.push('0' + tmp % 2 );
        	prev = tmp / 2; 

        	//printf("prev=%d,tmp=%d,%c,%c,%d,%d\n",prev,tmp ,ca,cb,sizea,sizeb);
        	sizea--;
        	sizeb--;
        }

        while( sizea >= 0 )
        {
        	int tmp = prev;
        	char ca = a[sizea];
        	if ( ca == '1' ) tmp++;
        	stack.push('0' + tmp % 2 );
        	prev = tmp / 2; 
        	sizea--;
        }
        while( sizeb >= 0 )
        {
        	int tmp = prev;
        	char cb = b[sizeb];
        	if ( cb == '1' ) tmp++;
        	stack.push('0' + tmp % 2 );
        	prev = tmp / 2; 
        	sizeb--;
        }
        if ( prev == 1 ) stack.push('1');

        while( !stack.empty() )
        {
        	s.push_back(stack.top());
        	stack.pop();
        }
        return s;
    }
};

int main(int argc, char const *argv[])
{
	Solution s;
	string result = s.addBinary("11111","1");
	printf("%s\n",result.c_str() );
	return 0;
}