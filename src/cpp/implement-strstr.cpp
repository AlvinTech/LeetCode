#include <iostream>
/****
KMP算法

最重要的是算出匹配字符串的next数组

  P      a    b   a    b   a

　j      0    1   2    3   4

 next    -1   0   0    1   2

 P      a    b   a    b   a   b   a   a

　j      0    1   2    3   4   5   6   7

 next    0    0   1   2    3   4   5   0

子串计算next数组

*/
class Solution {
public:
    char *strStr(char *haystack, char *needle) {
    	int len = 0;
    	int len2 = 0;
    	char* result = NULL;
    	while( needle[len] != '\0' ) len++;
    	while( haystack[len2] != '\0' ) len2++;
    	if ( len == 0 ) return haystack;
    	int nexts[len];
    	memset(nexts,0,sizeof(int)*len);
    	KMPNext(needle,len,nexts);

    	int i = 0;
    	int j = 0;
    	while( i < len2 )
    	{
    		//printf(" haystack[%d]=%c,  needle[%d]=%c \n",i,haystack[i] ,j,needle[j] );
    		if( haystack[i] == needle[j] )
    		{
    			//如果当前匹配，2个标号都++
    			i++;
    			j++;
    			if( j == len )
	    		{
	    			result = haystack + i - j;
	    			break;
	    		}
    		}
    		else
    		{
    			//如果不匹配，当j==0时，i++
    			//当j!=0时，i不变，j为next[j-1]内值
    			if (j == 0) i++;
    			else j = nexts[j-1];
    		}


    		
    	}
        return result;
    }
    void KMPNext(char *needle,int len,int output_nexts[])
    {
    	for (int i = 1; i < len; ++i)
    	{
    		int prev = output_nexts[i-1];
    		if ( needle[prev] == needle[i] )
    			output_nexts[i] = prev + 1;
    		else
    			output_nexts[i] = 0;
    	}
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	char haystack[] = "";
	char needle[] = "";
	char* result = s.strStr(haystack,needle);
	printf("%s\n", result);

	int len = sizeof(needle)/sizeof(char) - 1;
	//printf("len of needle = %d\n", len);
	int test[len];
	memset(test,0,sizeof(int)*len);
	s.KMPNext(needle,len,test);
	for (int i = 0; i < len; ++i)
	{
		printf(",%d",test[i] );
	}
	printf("\n" );

	return 0;
}