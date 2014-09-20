#include <iostream>
using namespace std;
class Solution {
public:
    int longestValidParentheses(string s) 
    {
    	int size = s.size();
    	int arr[size];
    	int max = 0;
    	memset(arr,0,sizeof(int)*size);

    	generateArray(s,size,arr);
    	for (int i = 1; i < size; ++i)
    	{
    		//printf("%d,",arr[i] );
    		if ( arr[i] != 0 )
    		{
    			arr[i] = arr[i] + arr[i-1];
    		}
    		max = max > arr[i] ? max : arr[i];
    	}
    	//printf("\n");

    	return max;    
    }
    void generateArray(string &s, int size, int arr[])
    {
    	bool changed = true;
    	while( changed )
    	{
    		changed = false;
    		int prevIndex = -1;
    		for (int i = 0; i < size; ++i)
    		{

    			if ( arr[i] == 0 )
    			{
    				if ( s[i] == ')' )
    				{
    					if ( prevIndex != -1 )
    					{
    						changed = true;
		    				arr[i] = 1;
		    				arr[prevIndex] = 1;
		    				prevIndex = -1;
    					}
    					else
    					{
		    				prevIndex = -1;
    					}
    					
    				}
    				else if( s[i] == '(' )
    				{
    					prevIndex = i;
    				}
    			}
    		}
    	}
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.longestValidParentheses(")()())");
	printf("%d\n",result );
	return 0;
}