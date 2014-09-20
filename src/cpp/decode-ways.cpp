#include <iostream>
#include <map>
using namespace std;

class Solution {
public:
    int numDecodings(string s) 
    {
    	std::map<string, int> map;
        return innerNumDecodings(s,map);
    }
    int innerNumDecodings(string s, map<string, int> &dic)
    {
    	int result = 0;
    	if( s.size() == 0 ) return 0;
    	if( dic.find(s) != dic.end() )
    	{
    		result = dic[s];
    	}
    	else
    	{
    		if ( s.size() == 1 )
	    	{
	    		int num = atoi(s.c_str());
	    		result += count(num);
	    	}
	    	else if( s.size() == 2 )
	    	{
	    		int num = atoi(s.c_str());
	    		if( num >= 10 )
	    			result += count(num);

	    		if( count(num/10) == 1 && count(num%10) == 1 )
	    			result += 1;
	    	}
	    	else
	    	{
	    		string tmp1,tmp2; 
	    		string tmpNext1,tmpNext2;
	    		int num1 = 0, num2 = 0; 
	    		int returnValue1 = 0,returnValue2 = 0;

	    		tmp1 = s.substr(0,1);
	    		tmp2 = s.substr(0,2);
	    		tmpNext1 = s.substr(1);
	    		tmpNext2 = s.substr(2);

	    		num1 = atoi(tmp1.c_str());
	    		num2 = atoi(tmp2.c_str());
	    		returnValue1 = count(num1);
	    		returnValue2 = num2 >= 10 ? count(num2) : 0;
	    		num1 = 0;
	    		num2 = 0;
	    		if ( returnValue1 > 0 ) 
	    			num1 = innerNumDecodings(tmpNext1,dic);

	    		if ( returnValue2 > 0 ) 
	    			num2 = innerNumDecodings(tmpNext2,dic);

	    		result += num1;
	    		result += num2;
	    	}
	    	dic[s] = result;
	    	//printf("%s=%d\n",s.c_str(),result );
    	}
    	return result;
    }
    int count(int value)
    {
    	if ( value > 0 && value < 27 ) return 1;
    	else return 0;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	//1103284012834032984123890128390
	//1485408
	printf("%d\n",s.numDecodings("611") );
	return 0;
}