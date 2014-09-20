#include <iostream>
using namespace std;
class Solution {
public:
    string countAndSay(int n) 
    {
    	string s;
    	int tmp[100];
    	memset(&tmp,0,sizeof(int) * (100));
    	tmp[1] = 2;
    	for (int i = 1; i <= n; ++i)
	    {
	    	int target = i;
	    	int count = tmp[i];
	    	tmp[count] += 1;
	    	//tmp[tmp[count]] += tmp[count];
	    	/* code */
	    }

	    for (int i = 0; i < n+1; ++i)
	    {
	    	printf("%d,",tmp[i] );
	    }
	    printf("\n");
	    return s;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	s.countAndSay(3);
	return 0;
}