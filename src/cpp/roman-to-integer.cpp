#include <iostream>
#include <map>
using namespace std;

class Solution {
public:
    int romanToInt(string s) 
    {
    	map<char,int> dic;
    	dic['0'] = 0;
    	dic['I'] = 1;
    	dic['V'] = 5;
    	dic['X'] = 10;
    	dic['L'] = 50;
    	dic['C'] = 100;
    	dic['D'] = 500;
    	dic['M'] = 1000;
    	char prev = '0';
    	int sum = 0;
    	for (int i = 0; i < s.size(); ++i)
    	{
    		if( dic.find(s[i]) != dic.end() )
    		{
    			char current = s[i];
    			if ( dic[prev] >= dic[current] )
    			{
    				sum += dic[prev];
    			}
    			else
    			{
    				sum -= dic[prev];
    			}
    			prev = current;
    		}
    		else return 0;
    	}
    	sum += dic[prev];
    	return sum;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.romanToInt("MDCCCLXXXVIII");
	printf("%d\n", result );
	return 0;
}