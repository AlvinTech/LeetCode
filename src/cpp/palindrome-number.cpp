#include <iostream>
class Solution {
public:
    bool isPalindrome(int x) 
    {
    	if (x<0) return false;
    	long long tmp = x;
        long long y = 0;
        while( x != 0 )
        {
        	y = y * 10 + x % 10;
        	x = x / 10;
        }
        return tmp == y;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;

	bool result = s.isPalindrome( -1 );
	printf("%d\n", result);
	return 0;
}