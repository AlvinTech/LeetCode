#include <iostream>
using namespace std;

/***
Method : DP (dynamic programming) 
 *  D[i,j]: the minimal edit distance for s1的前i个字符和 s2的前j个字符 
 *  DP Formulation: D[i,j]=min(

 D[i-1,j]+1
 ,D[i,j-1]+1
 ,D[i-1,j-1]+flag);//其中if(s1[i-1]!=s2[j-1])则flag=1,else flag=0; 

a) Insert a character
b) Delete a character
c) Replace a character

*/
#define min(a,b) a<b?a:b
class Solution 
{
public:
    int minDistance(string word1, string word2)
    {
    	int sizea = word1.size();
    	int sizeb = word2.size();
    	int values[sizea+1][sizeb+1];
    	for (int i = 0; i <= sizea; ++i)
    		for (int j = 0; j <= sizeb; ++j)
    			values[i][j] = INT_MAX;
    	values[0][0] = 0;

    	for (int i = 0; i <= sizea; ++i)
    	{
    		for (int j = 0; j <= sizeb; ++j)
    		{
    			if( i > 0 ) values[i][j] = min(values[i][j],values[i-1][j] + 1);
    			if( j > 0 ) values[i][j] = min(values[i][j],values[i][j-1] + 1);
    			if( i > 0 && j > 0 )
    			{
    				if ( word1[i-1] == word2[j-1] )
    				{
    					values[i][j] = min(values[i][j],values[i-1][j-1]);
    				}
    				else
    				{
    					values[i][j] = min(values[i][j],values[i-1][j-1]+1);
    				}
    			}
    		}
    	}
        return values[sizea][sizeb];
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	string word1 = "intention";
	string word2 = "execution";
	int result = s.minDistance(word1,word2);
	printf("%d\n", result );
	return 0;
}