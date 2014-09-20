#include <iostream>

class Solution {
public:
    int lengthOfLastWord(const char *s) 
    {
    	int max = strlen(s);
    	if (max == 0) return 0;
    	char* p = (char*)s;
    	char* pStart = p;
    	p = p + max - 1;
    	int index = 0;
    	//printf("%c\n",*(p) );
    	bool bfind = false;
    	while( p != pStart-1  )
    	{
    		if ( *p == ' ' )
    		{
    			bfind = true;
    			break;
    		}
    		index++;
    		p--;
    	}
    	if ( bfind ) return index;    
    	else return max;
    }
    int lengthOfLastWord2(const char *s) {
		int len = 0;
		while (*s) 
		{
			if (*s++ != ' ')
				++len;
			else if (*s && *s != ' ')
				len = 0;
		}
		return len; 
	}
};
int main(int argc, char const *argv[])
{
	Solution s;
	int len = s.lengthOfLastWord2("aaaaasdfasd aaa");
	printf("%d\n", len);

	return 0;
}