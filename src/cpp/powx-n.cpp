#include "iostream"
class Solution {
public:
    double pow(double x, int n) 
    {
        if ( 0 == n ) return 1;
        if ( x == 0 ) return 0;
        if ( x == 1 ) return 1;
        bool isNegative = n < 0 ? true : false;
        if ( isNegative ) n = -n;
        bool numIsNegatie = x < 0 ? true : false;

        double result = 1;
        while( n > 0 )
        {
        	result *= x;
        	n--;
        	if ( result == 0 ) break;
        	if ( result == 1 ) break;
        }
        if( numIsNegatie && n % 2 == 1 )
        {
			result = result > 0 ? -result:result;
        }
        if ( isNegative && result != 0 )
        {
        	result = 1/result;
        }
        return result;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	double result = s.pow(-1.00000, 2147483647);
	printf("%lf\n", result);
	return 0;
}