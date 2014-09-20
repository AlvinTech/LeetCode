#include <iostream>
using namespace std;
#define min(a,b) a < b ? a : b
class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
    	int size = s.size();
    	//int tmps[size];
    	int prevValue = 0;
    	int maxLen = 0;
    	//memset(tmps,0,sizeof(int)*size);
    	for (int i = size-1; i >= 0; --i)
    	{
    		int valueLeft = findChar(s[i],i,s);
    		if ( valueLeft > prevValue )
    		{
    			valueLeft = min(valueLeft,prevValue+1);
    		}
    		//printf("valueLeft:%d\n",valueLeft);
    		maxLen = maxLen > valueLeft ? maxLen : valueLeft;
    		prevValue = valueLeft;
    	}
    	return maxLen;    
    } 
    int findChar(char target,int index,string &s)
    {
    	int size = s.size();
    	if ( index == size - 1 ) return 1;
    	int start = index + 1;
    	bool find = false;
    	while( start < size )
    	{
    		if ( target == s[start] )
    		{
    			find = true;
    			break;
    		}
    		start++;
    	}
    	if ( find )
    	{
    		return start-index;
    	}
    	else
    	{
    		return size - index;
    	}
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	//0,1,2,3,4
	//      2,1
	int result = s.lengthOfLongestSubstring("abcabcbb");
	printf("result = %d\n", result);
	return 0;
}