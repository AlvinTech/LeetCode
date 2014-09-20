#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int divide(int dividend, int divisor) 
    {
    	if ( divisor == 0 || dividend == 0) return 0;

    	bool negtive1 = false;
    	bool negtive2 = false;
    	unsigned int dividend2 = dividend;
    	unsigned int divisor2 = divisor;
    	if ( dividend < 0 )
    	{
    		dividend2 = -dividend;
    		negtive1 = true;
    	}
    	//printf("ld:%ld\n",dividend2 );
    	if ( divisor < 0 )
    	{
    		divisor2 = -divisor;
    		negtive2 = true;
    	}
    	//printf("%s,%s\n", negtive1?"-":"+",negtive2?"-":"+");

    	//vector<int> tmp;
    	int size = 0;
    	unsigned int doubleDivisor = divisor2;
    	while( doubleDivisor <= dividend2 && doubleDivisor > 0 )
    	{
    		size++;
    		doubleDivisor = doubleDivisor << 1;
    	}
    	//printf("size:%d\n",size );

    	if ( size == 0 ) return 0;
    	int start = size-1;
    	int result = 0;
    	unsigned int dividendValue = dividend2;
    	while( start >= 0 )
    	{
    		int tobe = (divisor2 << start) ;
    		//printf("tobe:%d\n",tobe );
    		if ( tobe <= dividendValue )
    		{
    			dividendValue -= tobe;
    			result += (1<<start);
    			//continue;
    		}
    		start--;
    	}
    	if ( (negtive1 | negtive2) && negtive1 != negtive2 )
    		return -result;
    	else return result;    
    }
};
int main(int argc, char const *argv[])
{
	/* code */
	Solution s;
	int result = s.divide(-2147483648,2);
	printf("%d\n",result );
	return 0;
}