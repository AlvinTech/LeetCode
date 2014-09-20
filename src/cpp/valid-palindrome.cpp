#include <iostream>
using namespace std;
class Solution {
public:
    bool isPalindrome(string s) 
    {
    	if ( s.size() == 0 ) return true;
    	int start = 0;
    	int end = s.size() - 1;
    	
    	while( start < end )
    	{
    		char a = s[start];
    		char b = s[end];
    		//printf("%c,%c,%d,%d\n", a,b,isLetter(a),isLetter(b));
    		if ( !isLetter(a)  )
    		{
    			start++;
    			continue;
    		}
    		if ( !isLetter(b) )
    		{
    			end--;
    			continue;
    		}
    		if ( isEqual(a,b) )
    		{
    			start++;
    			end--;
    		}
    		else
    		{
    			return false;
    		}

    	}
    	return true;    
    }
    bool isLetter(char letter)
    {
    	if ( (letter >= 'A' && letter <= 'Z') 
    		|| (letter >= 'a' && letter <= 'z') 
    		|| (letter >= '0' && letter <= '9') )
	    	return true;
	    else return false;
    }
    bool isEqual(char a,char b)
    {
    	int dur = 'a' - 'A';
    	if ( a+dur == b || a-dur == b || a == b) return true;
    	else return false;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	bool result = s.isPalindrome("`l;`` 1o1 ??;l`");
	printf("%s\n", result ? "true":"false" );
	return 0;
}